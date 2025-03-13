package org.testcase.managers;

import org.testcase.entities.Currency;

import java.util.List;

public class CurrencyManager {

  public void changeRate(List<Currency> currencies, Currency currency, double newPrice) {
    if (newPrice < 0) return;
    for (Currency c: currencies){
      if (c.getName().equals(currency.getName())){
        currency.setExchangeRate(newPrice);
      }
    }


  }
}
