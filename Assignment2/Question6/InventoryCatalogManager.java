package Assignment2.Question6;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryCatalogManager {
    private final int totalItems;

    public InventoryCatalogManager(int totalItems) {
        this.totalItems = totalItems;
    }

    public Map<String, Integer> createSynchronizedMap() {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < totalItems; i++) {
            map.put("PROD_" + i, 100);
        }
        return Collections.synchronizedMap(map);
    }

    public Map<String, Integer> createConcurrentMap() {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < totalItems; i++) {
            map.put("PROD_" + i, 100);
        }
        return map;
    }
}