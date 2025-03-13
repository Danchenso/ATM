package org.testcase.storage;

import org.testcase.entities.Account;
import org.testcase.entities.Currency;

import java.util.List;

public class EntityStorage {

    private List<Account> accounts;
    private List<Currency> currencies;

    public EntityStorage(List<Account> accounts, List<Currency> currencies) {
        this.accounts = accounts;
        this.currencies = currencies;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }
}
