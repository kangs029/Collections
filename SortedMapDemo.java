/*
SortedMap is an interface that extends Map and guarantees that the entries are sorted based on
the keys, either in their natural ordering or by a specified Comparator.

**********NavigableMap=>Interface*************
NavigableMap extends SortedMap, providing more powerful navigation options such as
finding the closest matching key or retrieving the map in reverse order. it has more methods
*/

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {
    public static void main(String[] args) {
        Map<String,Integer> mp=new TreeMap<>();//Iternally Read-black tree

        /*We can use Map directly why Sorted Map: because it has extra special methods */
        SortedMap<Integer,String> map=new TreeMap<>();
        map.put(91, "Vivek");
        map.put(99, "Shubham");
        map.put(78, "Mohit");
        map.put(77, "Vipul");
        System.out.println(map);

        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.headMap(91));//kaha tak chahiye
        System.out.println(map.tailMap(91));//kaha se chahiye
        System.out.println(map.headMap(91));
        System.out.println(map.subMap(78,91));
    
    }
    
}
