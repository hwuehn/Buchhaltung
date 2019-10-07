package de.company.buchhaltung.data;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class AccountList  {

    //maps to store normal and sorted ACCOUNTING LISTS for comboBoxes
    private Map<Integer, String> accList = new HashMap<Integer, String>();
    private Map<Object, Object> sortedByKey;

    public AccountList()  {
    }

    public void readFile() throws IOException {
        File file= new File("saveData.txt");
        Scanner s = new Scanner(file);

        if(!file.exists()){
            file.createNewFile();
        }

        // file scan and fill accList
        while (s.hasNext()) {
            int key = Integer.parseInt(s.next());
            String value = s.next();
            if (key != 0) {
                accList.put(key, value);
            }
        }
    }

    public void writeFile() throws FileNotFoundException {
        File file= new File("saveData.txt");
        //PrintWriter outAppend = new PrintWriter(new FileOutputStream(file,true));
        PrintWriter outOverwrite = new PrintWriter(file);
        for (Map.Entry<Integer, String> entry : accList.entrySet()) {
            outOverwrite.println(entry.getKey() + " " + entry.getValue());
        }
        outOverwrite.close();
    }

    public void writeSortedFile() throws FileNotFoundException {
        File file= new File("saveData.txt");
        //PrintWriter outAppend = new PrintWriter(new FileOutputStream(file,true));
        PrintWriter outOverwrite = new PrintWriter(file);
        for (Map.Entry<Object, Object> entry : sortAccList().entrySet()) {
            outOverwrite.println(entry.getKey() + " " + entry.getValue());
        }
        outOverwrite.close();
    }

    public Map<Object, Object> sortAccList() {
        sortedByKey = accList.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, String>comparingByKey())
                .collect(toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sortedByKey;
    }

    public Map<Integer, String> getAccList() {
        return accList;
    }
}
