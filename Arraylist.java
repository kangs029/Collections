
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
The List interface is implemented by several classes in the
Java Collection Framework, such as ArrayList, LinkedList,
Vector, and Stack.

Key Features of the List Interface:
1.Order Preservation
2.Index-Based Access
3.Allows Duplicates

An ArrayList is a resizable array implementation of the List interface. Unlike arrays in Java, 
which have a fixed size, an ArrayList can change its size dynamically as elements are added or removed.
This flexibility makes it a popular choice when the number of elements in a list isn't known in advance.

Sequential memory address

Time Complexity
. Access by index (get) is O(1).
. Adding an element is O(n) in the worst case when resizing occurs.
. Removing elements can be O(n) because it may involve shifting elements.
. Iteration is O(n).

 */
public class Arraylist{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Banana");
        fruits.add("Date");

        fruits.remove("Apple"); //first occurance removes
        System.out.println(list);





        //List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(1);
        list.add(3);
        list.add(0, 0);
        System.out.println(list);

        List<Integer> list1 = List.of(4, 5, 6, 7, 8, 9);

        list.addAll(list1);
        System.out.println(list);
        list.remove(1);
         System.out.println(list);
        /*remove method also removes element if we pass object, so to remove
        element '1' not the element at index 1, we need to do as below
        */
        list.remove(Integer.valueOf(1));
        System.out.println(list);
















        // List<String> list = new ArrayList<>();
        // System.out.println(list.getClass().getName());

        // List<String> list1 = Arrays.asList("Monday", "Tuesday");
        // System.out.println(list1.getClass().getName());
        // //list1.add("Wednesday");//exception becuae of fixed size, we can replce using set(idx,ele)
        // list1.set(1,"Wednesday");

        String[] array = {"Apple", "Banana", "Cherry"};
        List<String> list2 = Arrays.asList(array);
        System.out.println(list2.getClass().getName());


        List<Integer> list3 = List. of(1, 2, 3, 4);
        //list3.set(1, 33);//exception unmodified, immytable

        //How to convert
        List<String> list4= new ArrayList<>(list2);
        list4.add("Mango");
        System.out.println(list4);









        
        // List<Integer> list=new ArrayList<>();
        // list.add(1);
        // list.add(8);
        // list.add(3);

        // //for each loop
        // for(int x:list){
        //     System.out.print(x+" ");
        // }
        // System.out.println("\n"+list.contains(8));
        // System.out.println(list.contains(2));

        //index
        list.remove(2);
        for(int x:list){
            System.out.print(x+" ");
        }
        System.out.println();

        //biz me element add kar dia, previous element shift ho jayega
        list.add(1,4);
        list.add(2,5);
        for(int x:list){
            System.out.print(x+" ");
        }
        System.out.println();

        //biz me element add kar dia, previous element shift nehi hoga replace hoga
        list.set(1,6);
        list.set(2,7);
        for(int x:list){
            System.out.print(x+" ");
        }

        //ArrayList->extends->AbstractList->->extends->->AbstarctCollectionList
        //it contains toString() so we can use it
        System.out.println(list);

        List<Integer> list6=new ArrayList<>(1000);
        System.out.println(list6.size()); //0
        System.out.println(list6.get(0));//IndexOutOfBoundsException

        //To access capacity ,using reflection we can acess private data
        /*
        List<Integer> list3=new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list3.add(1);
        }
        Field field = ArrayList.class.getDeclaredField(name: "elementData");
        field. setAccessible(true);
        Object[] elementData = (Object[]) field.get(list3);
        System. out.println("ArrayList capacity: " + elementData. length);

        list.add(1);

        elementData = (Object[]) field.get(list3);
        System. out.println("ArrayList capacity: " + elementData.length);
        */

    }
    
}
/*
When you create an ArrayList, it has an initial capacity (default is 10). The capacity refers
to the size of the internal array that can hold elements before needing to resize.
*/