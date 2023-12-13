package com.demo.ownspringannotation.service;

import java.util.List;
import java.util.Map;

import com.demo.ownspringannotation.util.CurrencyEnum;

public interface CurrencyService {

	public List<CurrencyEnum> index();

	public Map<String, Double> exchange(CurrencyEnum currency, int amount);
}
