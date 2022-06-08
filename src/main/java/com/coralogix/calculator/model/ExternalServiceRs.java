package com.coralogix.calculator.model;

import java.sql.Timestamp;
import java.util.Map;


public class ExternalServiceRs {

	private boolean success;
	private Timestamp timestamp;
	private String base;
	private String date;
	private Map<String, String> rates;
	
	public ExternalServiceRs() {
		super();
	}

	public ExternalServiceRs(boolean success, Timestamp timestamp, String base, String date,
			Map<String, String> rates) {
		super();
		this.success = success;
		this.timestamp = timestamp;
		this.base = base;
		this.date = date;
		this.rates = rates;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Map<String, String> getRates() {
		return rates;
	}

	public void setRates(Map<String, String> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "ExternalServiceRs [success=" + success + ", timestamp=" + timestamp + ", base=" + base + ", date="
				+ date + ", rates=" + rates + "]";
	}
	
	
}
