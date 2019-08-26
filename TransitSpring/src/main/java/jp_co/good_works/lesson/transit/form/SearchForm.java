package jp_co.good_works.lesson.transit.form;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;

public class SearchForm {
	
	@NotEmpty
	private String startStation;

	@NotEmpty
	private String endStation;
	
	@NotEmpty
	private String yyyymmdd;
	
	@NotEmpty
	private String hhmi;
	
	private String startHhmi;
	
	private String endHhmi;
	
	private String startEnd;

	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public String getEndStation() {
		return endStation;
	}

	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}

	public String getYyyymmdd() {
		return yyyymmdd;
	}

	public void setYyyymmdd(String yyyymmdd) {
		this.yyyymmdd = yyyymmdd;
	}

	public String getHhmi() {
		return hhmi;
	}

	public void setHhmi(String hhmi) {
		this.hhmi = hhmi;
	}

	public String getStartHhmi() {
		return startHhmi;
	}

	public void setStartHhmi(String startHhmi) {
		this.startHhmi = startHhmi;
	}

	public String getEndHhmi() {
		return endHhmi;
	}

	public void setEndHhmi(String endHhmi) {
		this.endHhmi = endHhmi;
	}

	public String getStartEnd() {
		return startEnd;
	}

	public void setStartEnd(String startEnd) {
		this.startEnd = startEnd;
	}

}
