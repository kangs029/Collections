import java.util.Arrays;
import java.util.LinkedList;

public class Linkedlist {
    /*
    The LinkedList class in Java is a part of the Collection framework and
    implements the List interface. Unlike an ArrayList, which uses a
    dynamic array to store the elements, a LinkedList stores its elements
    as nodes in a doubly linked list. This provides different performance
    characteristics and usage scenarios compared to ArrayList.

    ****Performance Considerations****

        LinkedList has different performance characteristics compared to ArrayList:

        i) Insertions and Deletions: LinkedList is better for frequent insertions and deletions
        in the middle of the list because it does not require shifting elements, as in
        ArrayList.
        
        ii) Random Access: LinkedList has slower random access (get(int index)) compared
        to ArrayList because it has to traverse the list from the beginning to reach the
        desired index.

        iii) Memory Overhead: LinkedList requires more memory than ArrayList because
        each node in a linked list requires extra memory to store references to the next
        and previous nodes.
    */
    public static void main (String[] args){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.get(2); // 0(n)
        linkedList.addLast(4); // 0(1)
        linkedList.addFirst(0); // 0(1)
        linkedList.getFirst();
        linkedList.getLast();
        System. out.println(linkedList);
        //Predicate => filter: true false : Lamda expression
        linkedList.removeIf(x->x%2==0);
        System. out.println(linkedList);

        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat","Dog","Elephant"));
        LinkedList<String> animalsToRemove = new LinkedList<>(Arrays.asList("Dog", "Lion"));
        animals.removeAll(animalsToRemove);
        System.out.println(animals);
    }
}
