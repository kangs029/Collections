import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    /*
    *****Key Characteristics of the Map Interface****

        Key-Value Pairs: Each entry in a Map consists of a key and a value.
        Unique Keys: No two entries can have the same key.
        One Value per Key: Each key maps to a single value.
        Order: Some implementations maintain insertion order
        (LinkedHashMap), natural order (TreeMap), or no order (HashMap).

       ***** Key Characteristics HashMap****

            i) Unordered: Does not maintain any order of its elements.
            Allows null Keys and Values: Can have one null key and multiple null
            values.
            ii) Not Synchronized: Not thread-safe; requires external
            synchronization if used in a multi-threaded context.
            iii) Performance: Offers constant-time performance (O(1)) for basic
            operations like get and put, assuming the hash function disperses
            elements properly.

        *******Basic Components of HashMap**********
                ->Value
                ->Key
                ->Bucket: A place where key-value pairs are stored.
                          Think of buckets as cells in a list (array).
                ->Hash function : Converts key into an index(bucket location) for storage
                                    [A hash function is an algorithm that takes an
                                    input (or "key") and returns a fixed-size string
                                    of bytes, typically a numerical value. The
                                    output is known as a hash code, hash value, or
                                    simply hash. The primary purpose of a hash
                                    function is to map data of arbitrary size to
                                    data of fixed size

                                    · Deterministic: The same input will always produce the same output.
                                    . Fixed Output Size: Regardless of the input size, the hash code has a consistent size (e.g., 32-bit, 64-bit).
                                    . Efficient Computation: The hash function should compute the hash quickly.]
                
            ***************How Data is Stored in HashMap*****************

            Step 1: Hashing the Key

            First, the key is passed through a hash function to generate a unique hash code (an integer number).
            This hash code helps determine where the key-value pair will be stored in the array (called a "bucket array").

            Step 2: Calculating the Index

            The hash code is then used to calculate an index in the array (bucket location) using
            int index = hashCode % arraySize;

            The index decides which bucket will hold this key-value pair.
            For example, if the array size is 16, the key's hash code will be divided by 16, and the remainder will be the index.

            Step 3: Storing in the Bucket

            The key-value pair is stored in the bucket at the calculated index. Each bucket can hold multiple key-value pairs
            (this is called a collision handling mechanism, discussed later).

        ************How HashMap Retrieves Data*****************

        When we call get(key), the HashMap follows these steps:

        i) Hashing the Key: Similar to insertion, the key is hashed using the same hash
        function to calculate its hash code.

        ii) Finding the Index: The hash code is used to find the index of the bucket where
        the key-value pair is stored.

        iii) Searching in the Bucket: Once the correct bucket is found, it checks for the
        key in that bucket. If it finds the key, it returns the associated value.

        **********Collision**************
        when HashFuction sends same output for different inputs
        class Node<K, V> {
            final int hash;// hash code of the key
            final K key;// the key itself
            V value; // the value associated with the key
            Node<K, V> next; // pointer to the next node in case of a collision (linked list)
        }
        ***********Handling Collisions**************

        Since different keys can generate the same index (called a collision),
        HashMap uses a technique to handle this situation. Java's HashMap
        uses Linked Lists (or balanced trees after Java 8) for this.

        If multiple key-value pairs map to the same bucket, they are stored in a
        linked list inside the bucket.

        When a key-value pair is retrieved, the HashMap traverses the linked
        list, checking each key until it finds a match.    
        
        ***********HashMap Resizing (Rehashing)************

        HashMap has an internal array size, which by default is 16.
        When the number of elements (key-value pairs) grows and
        exceeds a certain load factor (default is 0.75), HashMap
        automatically resizes the array to hold more data. This process is
        called rehashing.

        The default size of the array is 16, so when more than 12
        elements (16 * 0.75) are inserted, the HashMap will resize.
            
        *******During rehashing********

        The array size is doubled.

        1. All existing entries are rehashed (i.e., their positions are recalculated)
        and placed into the new array.
        2. This ensures the HashMap continues to perform efficiently even as
        more data is added.
           
        **********Time Complexity***********

        HashMap provides constant time O(1) performance for basic
        operations like put() and get() (assuming no collisions).
        However, if there are many collisions, and many entries are
        stored in the same bucket, the performance can degrade to O(n),
        where n is the number of elements in that bucket.

        But after Java 8, if there are too many elements in a bucket,
        HashMap switches to a balanced tree instead of a linked list to
        ensure better performance O(log n).

        ->When linkedList size exceeds threshold=8, then only it converts to red balck tree
            

    */
   public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(31, "Shubham");
        map.put(11, "Akshit");
        map.put(2, "Neha");
        System.out.println(map);

        String student = map.get(31);
        System.out.println(student);
        String s = map.get(69);
        System.out.println(s);

        System.out.println(map.containsKey(2));
        System. out.println(map.containsValue("Shubham"));

        Set<Integer> keys = map.keySet();
        for(int i : keys){
            System.out.print(map.get(i)+" ");
        }
        System.out.println();

        for(Map.Entry<Integer,String> entry :map.entrySet()){
            entry.setValue(entry.getValue().toUpperCase());
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

        //map. remove (31);
        boolean res = map.remove (31, "Nitin") ;
        System. out.println ("REMOVED Nitin ? :" + res);
        System.out.println(map);

        /***********Collision example*************/
        System.out.println(simpleHash("ABC"));
        System.out.println(simpleHash("CBA"));
    }
        public static int simpleHash(String key) {
            int sum = 0;
            for (char c : key. toCharArray() ) {
                sum += (int) c;
            }
            return sum % 10;
        }
}
