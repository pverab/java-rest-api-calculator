package com.coralogix.calculator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ExchangeRate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long exchangeRateId;

	@Column
	private String originCurrency;

	@Column
	private String finalCurrency;

	@Column
	private String date;

	@Column
	private String value;

	public ExchangeRate() {
		super();
	}

	public ExchangeRate(String originCurrency, String finalCurrency, String date, String value) {
		super();
		this.originCurrency = originCurrency;
		this.finalCurrency = finalCurrency;
		this.date = date;
		this.value = value;
	}

	public Long getExchangeRateId() {
		return exchangeRateId;
	}

	public void setExchangeRateId(Long exchangeRateId) {
		this.exchangeRateId = exchangeRateId;
	}

	public String getOriginCurrency() {
		return originCurrency;
	}

	public void setOriginCurrency(String originCurrency) {
		this.originCurrency = originCurrency;
	}

	public String getFinalCurrency() {
		return finalCurrency;
	}

	public void setFinalCurrency(String finalCurrency) {
		this.finalCurrency = finalCurrency;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ExchangeRate [exchangeRateId=" + exchangeRateId + ", originCurrency=" + originCurrency
				+ ", finalCurrency=" + finalCurrency + ", date=" + date + ", value=" + value + "]";
	}

}
