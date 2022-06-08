package com.coralogix.calculator.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.coralogix.calculator.model.ExchangeRate;
import com.coralogix.calculator.model.ExternalServiceRs;
import com.coralogix.calculator.repository.ExchangeRateRepository;

@Service
public class ExchangeRateService {

	@Autowired
	ExchangeRateRepository exchangeRateRepository;

	private final RestTemplate restTemplate;

	private String urlBaseExternalService = "http://localhost:8080/fixer/latest";

	public ExchangeRateService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public ExchangeRate getExchangeRate(String originCurrency, String finalCurrency) {
		ExchangeRate exchangeRate = exchangeRateRepository.findExchangeRate(originCurrency, finalCurrency);

		if (exchangeRate == null) {

			String urlExternalService = urlBaseExternalService + "?base=" + originCurrency + "&symbols="
					+ finalCurrency;

			ExternalServiceRs result = new ExternalServiceRs();

			try {
				result = restTemplate.getForObject(urlExternalService, ExternalServiceRs.class);
			} catch (HttpClientErrorException e) {
				String responseBodyAsString = e.getResponseBodyAsString();
				String exceptionMessage = e.getMessage();

				System.out.println("responseBodyAsString: " + responseBodyAsString);
				System.out.println("exceptionMessage: " + exceptionMessage);

			}

			String value = result.getRates().get(finalCurrency);

			exchangeRate = new ExchangeRate(originCurrency, finalCurrency, result.getDate(), value);

			exchangeRateRepository.save(exchangeRate);
		}

		return exchangeRate;
	}

	public List<ExchangeRate> getAllExchangeRate() {
		return (List<ExchangeRate>) exchangeRateRepository.findAll();
	}
}
