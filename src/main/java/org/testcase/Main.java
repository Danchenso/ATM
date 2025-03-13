package org.testcase;

import org.testcase.entities.Account;
import org.testcase.managers.AccountManager;
import org.testcase.storage.EntityStorage;
import org.testcase.storage.StorageManager;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {

    EntityStorage entityStorage =
        new EntityStorage(
            new ArrayList<>(), new ArrayList<>()); // создаются списки аккаунтов и валют
    StorageManager storageManager =
        new StorageManager(entityStorage); // создвется объект для заполнения списков

    storageManager.fillAccountStorage(); // списки заполняются данными
    storageManager.fillCurrencyStorage(); // списки заполняются данными

    AccountManager accountManager = new AccountManager();
    for (Account ac : entityStorage.getAccounts()) {
      accountManager.fillAccountBalanceMap(ac, entityStorage);
    }

    System.out.println(entityStorage.getAccounts().get(2));
  }
}
