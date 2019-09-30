package application;

import data.Konto;

import java.util.Dictionary;
import java.util.Hashtable;

public class KontoVerwaltung{

	private Dictionary<Integer, Konto> konten = new Hashtable<Integer,Konto>();

    public Konto createKonto(String bezeichnung, int id) {
        Konto k = new Konto(bezeichnung, id);
        konten.put(id, k);
        return k;
	}

}