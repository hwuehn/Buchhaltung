package de.company.buchhaltung.application;


import de.company.buchhaltung.data.Konto;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;


// out of order
public class KontoVerwaltung{

    private static Dictionary<Integer, Konto> konten = new Hashtable<Integer, Konto>();

    public Konto createKonto(int id, String bezeichnung) throws IOException {
        Konto k = new Konto(id, bezeichnung);
        konten.put(id, k);
        return k;
    }
}