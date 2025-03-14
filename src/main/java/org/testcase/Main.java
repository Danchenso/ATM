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

    accountManager.topUpBalance(
        entityStorage.getAccounts().get(2), 12.5, "USD", entityStorage);
    accountManager.topUpBalance(
        entityStorage.getAccounts().get(2), 12.5, "USD", entityStorage);
    accountManager.topUpBalance(
        entityStorage.getAccounts().get(2), 5.0, "USD", entityStorage);
    accountManager.topUpBalance(
        entityStorage.getAccounts().get(2), 12550.25, "RUB", entityStorage);
    accountManager.topUpBalance(
        entityStorage.getAccounts().get(2), 7449.75, "RUB", entityStorage);

    accountManager.withdrawFromBalance(
        entityStorage.getAccounts().get(2), 29.85, "USD", entityStorage);
    accountManager.withdrawFromBalance(
            entityStorage.getAccounts().get(2), 3.0, "USD", entityStorage);


    System.out.println(entityStorage.getAccounts().get(2).getBalance());
  }
}
