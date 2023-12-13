package com.demo.ownspringannotation.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ownspringannotation.aop.SaveInFile;
import com.demo.ownspringannotation.service.CurrencyService;
import com.demo.ownspringannotation.util.CurrencyEnum;

@RestController
@RequestMapping(path = "currency")
public class CurrencyController {

	@Autowired
	private CurrencyService service;

	/**
	 * @apiNote Example http://localhost:5443/currency
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<CurrencyEnum>> index() {
		return ResponseEntity.ok(service.index());
	}

	/**
	 * Converts an amount of Mexican $ to any other currency
	 * 
	 * @param currency Target currency
	 * @param amount   Amount in Mexican $
	 * @return Converted amount
	 * @apiNote Example POST http://localhost:5443/currency/USD?amount=1000
	 */
	@PostMapping(path = "{currency}")
	@SaveInFile(value = "files/currencies.txt") // relative path or empty
	public ResponseEntity<Map<String, Double>> exchange(@PathVariable CurrencyEnum currency,
			@RequestParam Integer amount) {
		return ResponseEntity.ok(this.service.exchange(currency, amount));
	}
}
