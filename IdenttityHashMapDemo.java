import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
public class IdenttityHashMapDemo{
    public static void main(String[] args) {
        String key1 = new String("key");//String ka hashcode content ke sath hota hai object ka sath nehi
        String key2 = new String("key");
        Map<String, Integer> map = new HashMap<>();
        map.put(key1, 1); // key, 1
        map.put(key2, 2); // key, 2
        System.out.println(key1.equals(key2));//[true]
        System.out.println(map); //{key:2}

        /*
        If we change HashMap to Identity HashMap, there will be 2 differnt key
        Agar ya class me Hascode() and euqalsTo() method ho ya na ho, but IdentiyHashMap me object hashcode hi chalega
        */
        Map<String, Integer> map2 = new IdentityHashMap<>();
        map2.put(key1, 1); // key, 1
        map2.put(key2, 2); // key, 2
        System.out.println(map2); //{key:1,key:2}
    }
    
}
