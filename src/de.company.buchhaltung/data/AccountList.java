package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class AccountList {

    private Map<Integer, String> accList = new HashMap<Integer, String>();
    private Scanner s = null;

    public void readAccListFromFileAndPutPairsInHashMap() {
        try {
            File file = new File("saveData.txt");
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNext()) {
            int key = Integer.parseInt(s.next());
            String value = s.next();
            if (key != 0) {
                accList.put(key, value);
            }
        }
    }

    public Map<Object, Object> sortAccPairsInHashMap() {
        Map<Object, Object> sortedByKey = accList.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, String>comparingByKey())
                .collect(toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sortedByKey;
    }

}
