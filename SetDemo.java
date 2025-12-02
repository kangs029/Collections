
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
/*
Set is a collection that cannot contain duplicate elements
    faster operations
    Map -- > HashMap, LinkedHashMap, TreeMap, EnumMap
    Set -- > HashSet, LinkedHashSet, TreeSet, EnumSet
*/
public class SetDemo {
    public static void main(String[] args) {
    
        Set<Integer> set = new HashSet<>();
        set.add(12);
        set.add(1);
        set.add(1);
        set.add(67);
        System.out.println(set);

        /*
        Intesetion/accessorder =>LinkedHashSet
        */
        Set<Integer> set2 = new LinkedHashSet<>();
        set2.add(12);
        set2.add(1);
        set2.add(1);
        set2.add(67);
        System.out.println(set2);
    }
}
