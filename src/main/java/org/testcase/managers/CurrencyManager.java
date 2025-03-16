package org.testcase.managers;

import org.testcase.entities.Currency;
import org.testcase.storage.EntityStorage;

import java.util.List;

public class CurrencyManager {

    public void changeRate(EntityStorage entityStorage, String currencyCode, double newPrice) {
        if (newPrice <= 0) {
            System.out.println("Неверный курс");
            return;
        }
        for (Currency c : entityStorage.getCurrencies()) {
            if (c.getName().equals(currencyCode)) {
                c.setExchangeRate(newPrice);
            }
        }
    }
}
