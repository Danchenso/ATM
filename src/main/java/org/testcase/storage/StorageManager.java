package org.testcase.storage;

import org.testcase.entities.Account;
import org.testcase.entities.Currency;

import java.util.LinkedHashMap;

public class StorageManager {
  private EntityStorage entityStorage;

  public StorageManager(EntityStorage entityStorage) {
    this.entityStorage = entityStorage;
  }

  public void fillAccountStorage() {
    entityStorage.getAccounts().add(new Account(133549520, "Ben Ten", new LinkedHashMap<>()));
    entityStorage.getAccounts().add(new Account(125789651, "Cirilla", new LinkedHashMap<>()));
    entityStorage.getAccounts().add(new Account(123456789, "Dante", new LinkedHashMap<>()));
    entityStorage.getAccounts().add(new Account(111222333, "Unknown", new LinkedHashMap<>()));
  }

  public void fillCurrencyStorage(){
    entityStorage.getCurrencies().add(new Currency("USD", 91.45));
    entityStorage.getCurrencies().add(new Currency("CNY", 11.91));
    entityStorage.getCurrencies().add(new Currency("KZT", 0.19));
    entityStorage.getCurrencies().add(new Currency("TRY", 2.69));
    entityStorage.getCurrencies().add(new Currency("RUB", 1.00));

  }

}
