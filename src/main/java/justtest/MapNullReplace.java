package justtest;

import java.util.HashMap;
import java.util.Map;

public class MapNullReplace {
    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();
        map.put("A", "Wonderful");
        map.put("B", null);

        System.out.println("A:"+map.get("A").toString());
//        System.out.println("B"+map.get("B").toString());

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                entry.setValue(""); // Replace null with empty string
            }
        }

        System.out.println("A:"+map.get("A").toString());
        System.out.println("B"+map.get("B").toString());
    }
}
