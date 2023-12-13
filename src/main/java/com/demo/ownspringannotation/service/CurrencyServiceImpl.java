package com.demo.ownspringannotation.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.demo.ownspringannotation.util.CurrencyEnum;
import com.demo.ownspringannotation.util.CurrencyUtil;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	@Override
	public List<CurrencyEnum> index() {
		return List.of(CurrencyEnum.values());
	}

	@Override
	public Map<String, Double> exchange(CurrencyEnum currency, int amount) {
		Map<String, Double> response = new HashMap<>();
		Double currencyValue = CurrencyUtil.currencyValues.get(currency);
		response.put("MXN to" + currency.name(), amount * currencyValue);
		return response;
	}

}
