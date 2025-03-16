package org.testcase;

import org.testcase.entities.Account;
import org.testcase.managers.AccountManager;
import org.testcase.storage.EntityStorage;
import org.testcase.storage.StorageManager;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        EntityStorage entityStorage =
                new EntityStorage(
                        new ArrayList<>(), new ArrayList<>()); // создаются списки аккаунтов и валют

        StorageManager storageManager =
                new StorageManager(entityStorage); // создвется объект для заполнения списков
        storageManager.fillAccountStorage(); // списки заполняются данными
        storageManager.fillCurrencyStorage(); // списки заполняются данными

        AccountManager accountManager = new AccountManager(); //основной класс с методами ввода снятия и т д
        for (Account ac : entityStorage.getAccounts()) {
            accountManager.fillAccountBalanceMap(ac, entityStorage);
        }

        Account account = entityStorage.getAccounts().get(3); // аккаунт для проверки работы приложения

        String replenishment = "Внести";
        String withdrawal = "Снять";
        String exchange = "Обменять";
        String balance = "Баланс";

        System.out.println("Добро пожаловать в ваш банковский аккаунт.\n" +
                "Доступно 5 валют: USD, CNY, KZT, TRY, RUB.\n" +
                "Возможны 4 операции: Внести, Снять, Обменять, Баланс\n" +
                "При выполнении любой операции введите сумму и код валюты через пробел\n");

        while (true) {
            System.out.println("Введите тип операции: ");
            Scanner scanner = new Scanner(System.in);
            String operationType = scanner.nextLine().trim();

            if (operationType.equalsIgnoreCase(replenishment)) {
                String[] topUpSum = getInputLineValues(scanner);
                double sum = Double.parseDouble(topUpSum[0]);
                String currency = topUpSum[1].toUpperCase();
                accountManager.topUpBalance(account, sum, currency, entityStorage);
            }

            if (operationType.equalsIgnoreCase(withdrawal)) {
                String[] withdrawalSum = getInputLineValues(scanner);
                double sum = Double.parseDouble(withdrawalSum[0]);
                String currency = withdrawalSum[1].toUpperCase();
                accountManager.withdrawFromBalance(account,sum,currency,entityStorage);
            }

            if (operationType.equalsIgnoreCase(balance)){
                System.out.println(accountManager.getBalance(account));
            }

            if (operationType.equalsIgnoreCase(exchange)){
                System.out.println("Введите, что вы хотите обменять");
                String[] exchangeSum = getInputLineValues(scanner);
                double sum = Double.parseDouble(exchangeSum[0]);
                String fromCurrency = exchangeSum[1].toUpperCase();
                System.out.println("Введите валюту, в которую хотите конвертировать сумму");
                String toCurrency = scanner.nextLine().toUpperCase();
                accountManager.exchangeCurrency(account, sum, fromCurrency, toCurrency, entityStorage);
            }

        }
    }


    static String[] getInputLineValues(Scanner scanner) {
        System.out.println("Введите сумму и валюту: (USD, CNY, KZT, TRY, RUB)");
        String topUpInput = scanner.nextLine();
        return topUpInput.trim().split(" ");
    }
}
