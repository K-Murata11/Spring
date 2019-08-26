package jp_co.good_works.lesson.transit.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import jp_co.good_works.lesson.transit.dao.TransitDao;
import jp_co.good_works.lesson.transit.exception.SearchException;
import jp_co.good_works.lesson.transit.form.SearchForm;

public class SearchLogic {
	private ArrayList<SearchForm> searchResult = new ArrayList<SearchForm>();
	private SearchForm searchInfo = null;
	public ArrayList<SearchForm> search(SearchForm searchData) throws SearchException {

		int hour = Integer.parseInt(searchData.getHhmi().substring(0, 2));
		int minute = Integer.parseInt(searchData.getHhmi().substring(3, 5));
		int time = (hour * 60) + minute;

		String startStation = searchData.getStartStation();
		String endStation = searchData.getEndStation();
		
		String sqlStart = "SELECT stationNo FROM stationInfo WHERE stationName = '" + startStation + "';";
		String sqlEnd = "SELECT stationNo FROM stationInfo WHERE stationName = '" + endStation + "';";
		ResultSet rsStart = TransitDao.connection(sqlStart);
		ResultSet rsEnd = TransitDao.connection(sqlEnd);

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM trainInfo WHERE stationNo = (SELECT stationNo FROM stationInfo WHERE stationName = '");

		//jspNameをDBで検索して、DBでのlogin_pwを取得する
		try {
			
			rsStart.next();
			int startStationNo = rsStart.getInt("stationNo");
			
			rsEnd.next();
			int endStationNo = rsEnd.getInt("stationNo");
			
			if (searchData.getStartEnd().equals("出発")) {
				sql.append(startStation + "') AND trainTime > " + time + " ORDER BY trainTime;");
			} else if (searchData.getStartEnd().equals("到着")) {
				sql.append(endStation + "') AND trainTime < " + time + " ORDER BY trainTime DESC;");
			}
			
			if(startStationNo > endStationNo) {
				sql.insert(sql.indexOf("ORDER") -1, " AND upDownFlag = 0 ");
			} else if (startStationNo < endStationNo) {
				sql.insert(sql.indexOf("ORDER") -1, " AND upDownFlag = 1 ");
			}
			
			int holidayFlag = search(searchData.getYyyymmdd());
			sql.insert(sql.indexOf("ORDER") -1, " AND holidayFlag = " + holidayFlag + " ");
			
			ResultSet rs = TransitDao.connection(sql.toString());

			while(rs.next()) {

				String trainNo = rs.getString("trainNo");
				int searchTime = Integer.parseInt(rs.getString("trainTime"));
				int searchHour = searchTime / 60;
				int searchMinute = searchTime % 60;

				String sqlTo ="SELECT * FROM trainInfo WHERE stationNo = (SELECT stationNo FROM stationInfo WHERE stationName = '";
				if (searchData.getStartEnd().equals("出発")) {
					sqlTo += endStation + "') AND trainNo = " + trainNo + ";";
				} else if (searchData.getStartEnd().equals("到着")) {
					sqlTo += startStation + "') AND trainNo = " + trainNo + ";";
				}
				ResultSet rsTo = TransitDao.connection(sqlTo);

				if(rsTo != null) {
					while(rsTo.next()) {

						searchInfo = new SearchForm();

						int searchToTime = Integer.parseInt(rsTo.getString("trainTime"));
						int searchToHour = searchToTime / 60;
						int searchToMinute = searchToTime % 60;
						
						
						if (searchData.getStartEnd().equals("出発")) {
							searchInfo.setStartHhmi(searchHour + ":" + searchMinute);
							searchInfo.setEndHhmi(searchToHour + ":" + searchToMinute);
						} else if (searchData.getStartEnd().equals("到着")) {
							searchInfo.setStartHhmi(searchToHour + ":" + searchToMinute);
							searchInfo.setEndHhmi(searchHour + ":" + searchMinute);
						}

						searchInfo.setStartStation(startStation);
						searchInfo.setEndStation(endStation);

					}
				}
				searchResult.add(searchInfo);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		if(searchResult.isEmpty() && searchResult.size() == 0) {
			throw new SearchException("検索値にエラーを検出しました");
		} else {
			return searchResult;
		}
	}
	
	private int search(String yyyymmdd) throws SearchException {
		Calendar cal = Calendar.getInstance();
		
		String[] ymds = yyyymmdd.split("-");
		int yyyy = Integer.parseInt(ymds[0]);
		int mm = Integer.parseInt(ymds[1]) + 1;
		int dd = Integer.parseInt(ymds[2]);
				
		cal.set(yyyy, mm, dd);
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.SUNDAY :
		case Calendar.SATURDAY :
			return 1;
		case Calendar.MONDAY :
		case Calendar.TUESDAY :
		case Calendar.WEDNESDAY :
		case Calendar.THURSDAY :
		case Calendar.FRIDAY :
			return 0;
		default :
			throw new SearchException("検索値にエラーを検出しました");
		}
		
	}

}
