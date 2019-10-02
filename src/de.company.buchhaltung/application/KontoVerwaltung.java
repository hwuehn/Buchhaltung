package application;

import data.AccountList;
import data.Konto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

public class KontoVerwaltung{

    private static Dictionary<Integer, Konto> konten = new Hashtable<Integer, Konto>();


    public KontoVerwaltung() throws FileNotFoundException {
    }

    public static Map<Integer, Konto> getKonten() {
        return (Map<Integer, Konto>) konten;
    }

    public Konto createKonto(int id, String bezeichnung) throws IOException {
        Konto k = new Konto(id, bezeichnung);
        konten.put(id, k);
        AccountList.writeFile();
        return k;
    }


}