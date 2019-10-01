package application;

import data.Konto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

public class KontoVerwaltung{

    private Dictionary<Integer, Konto> konten = new Hashtable<Integer, Konto>();

    PrintWriter out = new PrintWriter(new FileOutputStream(new File ("saveData.txt"),true));

    public KontoVerwaltung() throws FileNotFoundException {
    }

    public Map<Integer, Konto> getKonten() {
        return (Map<Integer, Konto>) konten;
    }

    public Konto createKonto(int id, String bezeichnung) {
        Konto k = new Konto(id, bezeichnung);
        konten.put(id, k);

        // saves the Hashtable in File
        save();
        return k;
    }

    private void save() {
        for (Map.Entry<Integer, Konto> entry : getKonten().entrySet()) {
            out.println(entry.getKey() + "\t" + entry.getValue());
        }
        out.close();
    }
}