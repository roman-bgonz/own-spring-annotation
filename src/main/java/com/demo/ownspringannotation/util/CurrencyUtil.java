package com.demo.ownspringannotation.util;

import java.util.HashMap;
import java.util.Map;

public class CurrencyUtil {

	public static final Map<CurrencyEnum, Double> currencyValues;

	static {
		currencyValues = new HashMap<>();
		currencyValues.put(CurrencyEnum.EUR, 0.054);
		currencyValues.put(CurrencyEnum.USD, 0.058);
		currencyValues.put(CurrencyEnum.GBP, 0.046);
	}
}
