package data;

import java.util.ArrayList;
import java.util.List;

public class AccountAdministration {

    //list to store all ACCOUNTS
    private static List<Account> accounts = new ArrayList<>();

    public static void setAccounts(Account accountIdentifier) {
        accounts.add(accountIdentifier);
        System.out.println(accounts.toString());
    }

}
