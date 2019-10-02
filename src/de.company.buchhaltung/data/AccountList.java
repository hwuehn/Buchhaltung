package data;

import application.KontoVerwaltung;
import presentation.AccountManagementFrame;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.util.stream.Collectors.toMap;

public class AccountList {

    private Map<Integer, String> accList = new HashMap<Integer, String>();
    private Scanner s = null;
    private File file;
    PrintWriter out = new PrintWriter(new FileOutputStream(file = new File ("saveData.txt"),true));

    public AccountList() throws FileNotFoundException {
    }

    public void createFile() throws IOException {
        if(!file.exists()){
            file.createNewFile();
        }
    }
    public void readFile() {
        scanFile();
    }
    public void fillAccList() {
        storeAcc(s, accList);
    }
    public void sortAccList() {
        Map<Object, Object> sortedByKey = accList.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, String>comparingByKey())
                .collect(toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
    public void writeFile() throws IOException {
        for (Map.Entry<Integer, Konto> entry : KontoVerwaltung.getKonten().entrySet()) {
            out.println(entry.getKey() + " " + entry.getValue());
        }
        out.close();
    }
    public void fillAccListComboBox() {
        scanFile();
        while (s.hasNext()) {
            String string = s.nextLine();
            if (string != null) {
                AccountManagementFrame.getAccListComboBox().addItem(string.concat(" "));
            }
        }
    }

    private void scanFile() {
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
