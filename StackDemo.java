import java.util.LinkedList;
import java.util.Stack;

public class StackDemo {
    /*
    Stack extends vector,Since Stack extends Vector, it is synchronized,making it thread-safe.
    LIFO order
    */
   public static void main(String[] args) {
       Stack<Integer> stack = new Stack<>();
        stack.push( 1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System. out.println(stack);
        Integer removedElement = stack.pop();
        System. out.println(stack);
        Integer peek = stack.peek();
        System.out.println(peek);
        System.out.println(stack);
        System.out.println(stack.isEmpty());
        System. out.println(stack.size());

        int searchEle=stack.search(3);
        /*
        4
        3
        2
        1
        => 3rd element from top
         */
        System.out.println(searchEle);//2
        //Since stack extends vector, so we can use their method as well
        stack.add(1,8);


        //LinkedList as Stack: but not synchronized
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.getLast();// peek
        linkedList.removeLast(); //pop
        linkedList.size();
        linkedList.isEmpty();

   }
}
