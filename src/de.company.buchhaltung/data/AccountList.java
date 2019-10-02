package data;

import application.KontoVerwaltung;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.util.stream.Collectors.toMap;

public class AccountList {

    private Map<Integer, String> accList = new HashMap<Integer, String>();
    private Map<Object, Object> sortedByKey;
    private static Scanner s;
    private static File file;
    static PrintWriter out;
    static {
        try {
            out = new PrintWriter(new FileOutputStream(file = new File ("saveData.txt"),true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public AccountList() throws IOException {
        createFile();
        readFile();
        fillAccList();
        sortAccList();
    }

    public static Scanner getS() {
        return s;
    }

    public void createFile() throws IOException {
        if(!file.exists()){
            file.createNewFile();
        }
    }
    public static void readFile() {
        scanFile();
    }
    public void fillAccList() {
        storeAcc(s, accList);
    }
    public Map<Object, Object> sortAccList() {
        sortedByKey = accList.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, String>comparingByKey())
                .collect(toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sortedByKey;
    }
    public static void writeFile() throws IOException {
        for (Map.Entry<Integer, Konto> entry : KontoVerwaltung.getKonten().entrySet()) {
            out.println(entry.getKey() + " " + entry.getValue());
        }
        out.close();
    }

    public static void scanFile() {
        try {
            File file = new File("saveData.txt");
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void storeAcc(Scanner s, Map<Integer, String> accList) {
        while (s.hasNext()) {
            int key = Integer.parseInt(s.next());
            String value = s.next();
            if (key != 0) {
                accList.put(key, value);
            }
        }
    }
}
