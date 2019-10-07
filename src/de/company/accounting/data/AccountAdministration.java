package de.company.accounting.data;

import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.toMap;

public class AccountAdministration {

    private Map<Integer, String> accList = new HashMap<Integer, String>();

    public AccountAdministration() {
    }

    public void readFile() throws IOException {
        File file = new File("saveData.txt");
        Scanner s = new Scanner(file);

        if (!file.exists()) {
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
        File file = new File("saveData.txt");
        //PrintWriter outAppend = new PrintWriter(new FileOutputStream(file,true));
        PrintWriter outOverwrite = new PrintWriter(file);
        for (Map.Entry<Integer, String> entry : accList.entrySet()) {
            outOverwrite.println(entry.getKey() + " " + entry.getValue());
        }
        outOverwrite.close();
    }

    public Map<Integer, String> sortAccList() {
        LinkedHashMap<Integer, String> sorted =
                accList.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sorted;
    }

    public Map<Integer, String> getAccList() {
        return accList;
    }

    public void load() {
        try {
            readFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void append(int iD, String description) {
        getAccList().put(iD, description); //normal list
        try {
            writeFile();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public List<String> getSortedList() {
        List<String> list = new ArrayList<>();
        Map<Integer, String> integerStringMap = sortAccList();
        for (Integer key : integerStringMap.keySet()) {
            String v = integerStringMap.get(key);
            list.add(key + " " + v);
        }
        return list;
    }
}
