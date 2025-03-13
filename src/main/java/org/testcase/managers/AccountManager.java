package org.testcase.managers;

import org.testcase.storage.EntityStorage;
import org.testcase.entities.Account;

public class AccountManager {

    public void fillAccountBalanceMap(Account account, EntityStorage entityStorage){
        for (int i = 0; i < entityStorage.getCurrencies().size(); i++){
            account.getBalance().put(entityStorage.getCurrencies().get(i).getName(), 0.0);
        }
    }



}
