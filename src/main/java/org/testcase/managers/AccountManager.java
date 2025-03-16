package org.testcase.managers;

import org.testcase.entities.Currency;
import org.testcase.storage.EntityStorage;
import org.testcase.entities.Account;

import java.util.Map;

public class AccountManager {
    /* основная логика */

    // создание списка валют на балансе
    public void fillAccountBalanceMap(Account account, EntityStorage entityStorage) {
        for (int i = 0; i < entityStorage.getCurrencies().size(); i++) {
            account.getBalance().put(entityStorage.getCurrencies().get(i).getName(), 0.0);
        }
    }

    // пополнить баланс
    public void topUpBalance(
            Account account, double amount, String currencyCode, EntityStorage entityStorage) {
        if (checkCurrencyCode(entityStorage, currencyCode)) {
            account.getBalance().put(currencyCode, (account.getBalance().get(currencyCode)) + amount);
        }
    }

    // снять с баланса
    public void withdrawFromBalance(
            Account account, double amount, String currencyCode, EntityStorage entityStorage) {
        if (checkCurrencyCode(entityStorage, currencyCode)
                && checkWithdrawalSum(account, amount, currencyCode)) {
            account.getBalance().put(currencyCode, (account.getBalance().get(currencyCode)) - amount);
        }
    }

    // обменять валюту
    public void exchangeCurrency(Account account, double exchangeSum, String fromCurrency,
                                 String toCurrency, EntityStorage entityStorage) {
        if (checkCurrencyCode(entityStorage, fromCurrency)
                && (checkCurrencyCode(entityStorage, toCurrency))
                && checkWithdrawalSum(account, exchangeSum, fromCurrency)) {
            double toCurrencySum = exchangeSum * getExchangeRate(entityStorage, fromCurrency) / getExchangeRate(entityStorage, toCurrency);
            account.getBalance().put(toCurrency, account.getBalance().get(toCurrency) + toCurrencySum);
            account.getBalance().put(fromCurrency, account.getBalance().get(fromCurrency) - exchangeSum);

        }
    }

    public Map<String, Double> getBalance(Account account) {
        return account.getBalance();
    }

    // проверка существования валюты
    private boolean checkCurrencyCode(EntityStorage entityStorage, String currencyCode) {
        for (Currency cr : entityStorage.getCurrencies()) {
            if (cr.getName().equals(currencyCode)) {
                return true;
            }
        }
        System.out.println("Валюта не найдена");
        return false;
    }

    private boolean checkWithdrawalSum(Account account, double amount, String currencyCode) {
        if (account.getBalance().get(currencyCode) == 0) {
            System.out.println("Операция невозможна. Баланс в данной валюте - 0");
            return false;
        } else if (amount > account.getBalance().get(currencyCode)) {
            System.out.println(
                    "Вы хотите снять больше, чем у вас есть в данной валюте\n Ваш текущий баланс:"
                            + account.getBalance().get(currencyCode)
                            + " "
                            + currencyCode);
            return false;
        }

        return true;
    }

    private double getExchangeRate(EntityStorage entityStorage, String currencyCode) {
        for (Currency c : entityStorage.getCurrencies()) {
            if (c.getName().equals(currencyCode)) {
                return c.getExchangeRate();
            }
        }
        return 1;
    }
}
