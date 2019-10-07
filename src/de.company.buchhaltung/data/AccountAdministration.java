package de.company.buchhaltung.data;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class AccountAdministration {

    //list to store all ACCOUNTS
    private static List<Account> accounts = new ArrayList<>();

    public static List<Account> getAccounts() {
        return accounts;
    }

    public static void setAccounts(Account accountIdentifier) {
        accounts.add(accountIdentifier);
        output();
    }

    public static String output() {
        return MessageFormat.format(" [Konto = {0}]", accounts.get(0));
    }

}
