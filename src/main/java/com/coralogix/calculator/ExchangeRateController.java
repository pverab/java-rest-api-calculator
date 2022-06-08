package com.coralogix.calculator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coralogix.calculator.model.ExchangeRate;
import com.coralogix.calculator.services.ExchangeRateService;

@RestController
@RequestMapping("/exchange-rate")
public class ExchangeRateController {

	@Autowired
	private ExchangeRateService exchangeRateService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ExchangeRate getExchangeRate(@RequestParam(name= "originCurrency") String originCurrency, @RequestParam(name= "finalCurrency") String finalCurrency) {
		return exchangeRateService.getExchangeRate(originCurrency, finalCurrency);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ExchangeRate> getAllExchangeRate() {
		return exchangeRateService.getAllExchangeRate();
	}
}
