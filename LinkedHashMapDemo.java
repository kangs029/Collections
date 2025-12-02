import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(11,0.3f,true); // double linked list
        /*since inner implementation is in double linked list, so slow in perfomance & memory comparison to HashMap
        But used when we need insertion/access order.

        intiatal cap :11
        loadFactor:0.3f
        accessOrder: true [the ordering mode - {@code true} for access-order, {@code false} for insertion-order] ,so jo recently access hoga wo bad me ayega
        :It is like the oldeest or least recently use element will be in top, so that we can remove it.
        */
        linkedHashMap.put("Orange", 10);
        linkedHashMap.put("Apple", 20);
        linkedHashMap.put("Guava", 13);
        for (Map. Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ":"+ entry.getValue());
        }

        /*
        We can create LinkedHashMap from HashMap as well
        */
       HashMap<String, Integer> hashMap = new HashMap<>();
       LinkedHashMap LinkedHashMap1 = new LinkedHashMap(hashMap);
       System.out.println(hashMap);

        hashMap.put("Shubham", 91);
        hashMap.put("Bob", 80);
        hashMap.put("Akshit", 78);

        Integer res = hashMap.getOrDefault("Vipul",0);
        hashMap.putIfAbsent("Shubham", 92);
        System.out.println(hashMap);
    }
}
