
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //For each loop
        for(int i: list){
            System.out.println(i);
        }

        //internal implentation of for each loop
        /*
        ->list(ArrayList) implements iterable interface. so, it implemenets iterator method inside it
        -> iterator() method returns Iterator type object, which contains some methods
        -> Iterator interface contains methods like i)hasNext(),ii)next() iii)
        ->hasNext(): checks next element hai ki nehi,ya end hai?
        ->next(): next ele ko return karta hai, aur iterator jo pointer hai usko ek position khiska deta hai
        */
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //remove
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        for (Integer number : numbers) {
            if (number % 2 == 0) {
               // numbers.remove (number);//ConcurrentModificationException
            }
        }
        /*
        If we use CopyOnWriteArrayList : element will remove but after the lopp
        If we want to remove during looping without exception, then we need to use iterator
        */
        Iterator<Integer> itr = numbers.iterator();
        while (itr.hasNext()) {
            Integer number = itr.next();
            if (number % 2 == 0) {
                itr.remove();
            }
        }
        System.out.println(numbers);
    
        /*
        ListIterator extends Iterator
        ArrayList has another method listIterator(), it has different methods
        i)boolean hasPrevious(); //if the list iterator has more elements when traversing the list in the reverse direction
        ii)int nextIndex(); //the index of the element that would be returned by a subsequent call to or list size if the list iterator is at the end of the list
        iii)int previousIndex(); //the index of the element that would be returned by a subsequent call to  or -1 if the list iterator is at the beginning of the list
        iv)void set(E e); //Replaces the last element returned by next or previous with the specified element (optional operation). This call can be made only if neither remove nor add have been called after the last call to next or previous.
        v)void add(E e);
        */
         ListIterator<Integer> itr2 = numbers.listIterator();

    }
}