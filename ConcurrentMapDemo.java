/*
    ************HashTable***************
    
        Hashtable is synchronized
        no null key or value
        Legacy Class, ConcurrentHashMap
        slower than HashMap
        implements Map
        only linkedlist in case of collision

    **********ConcurrentHashMap***********
        Java 7 -- > segment based locking -- > 16 segments -- > smaller hashmaps
        Only the segment being written to or read from is locked
        read: do not require locking unless there is a write operation happening on the same segment
        write: lock

        java 8 -- > no segmentation
               -- > Compare-And-Swap approach -- > no locking except resizing or collision(one in that bucket)
        Thread A last saw -- > x = 45
        Thread A work -- > x to 50
        if x is still 45, then change it to 50 else don't change and retry
        put -- > index

        Resizing HashMap ke tarah double nehi hota, one by one bucket add kia jata hai

        ******Immutable Map************
        i)Collections.unmodifiableMap(map1)
        ii)Map.of("Shubham", 98,"Vivek", 89); -> Limitation is only 10 entry can be possible
        iii)Map.ofEntries(Map.entry("Akshit", 99), Map.entry("Vivek",99)); -> limitations solved here , can add many entries
*/

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapDemo {
    public static void main(String[] args) {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "Apple");
        hashtable.put(2, "Barana");
        hashtable.put(3, "Cherry");
        System.out.println(hashtable);
        System. out.println("Value for key 2: "+ hashtable.get(2));


        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = Collections.unmodifiableMap(map1);
        System.out.println(map2);
        map2.put("C", 3); //throws exception

        Map<String, Integer> map3 = Map.of( "Shubham", 98,"Vivek", 89);
        map3.put("Akshit", 88);
        Map<String, Integer> map4 = Map.ofEntries(Map.entry("Akshit", 99), Map.entry("Vivek",99));

    }
    
}
