
import java.util.LinkedHashMap;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    public LRUCache(int capacity){
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }
    @Override
    //This method is invoked by put and putAll after inserting a new entry into the map
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        return size()>capacity;
    }


    public static void main(String[] args) {
        LRUCache<String, Integer> studentMap = new LRUCache<>(3);
        studentMap.put("Bob", 99);
        studentMap.put("Alice", 89);
        studentMap.put("Ram", 91);
        studentMap.put("Vipul", 89);
        //put Vipul karte hi, bob remove ho gaye
        System.out.println(studentMap);//{Alice=89, Ram=91, Vipul=89}
        studentMap.get("Bob");//get karne se null ayega. 
        System.out.println(studentMap);//{Alice=89, Ram=91, Vipul=89}
    }
}