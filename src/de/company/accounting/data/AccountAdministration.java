package de.company.accounting.data;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

public class AccountAdministration {

    //list to store all ACCOUNTS
   private static Dictionary<Integer, Konto> accounts = new Hashtable<Integer, Konto>();

   public static Konto createAccount(int iD, String description) throws IOException {
        Konto k = new Konto(iD, description);
        accounts.put(iD, k);
       System.out.println(accounts);
        return k;
   }
}
