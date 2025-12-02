import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/*
[Comparator used when we wants different kind of logic to sort ]
->It has compare(o1,o2) method, means we need to compare 2 objects=> class ke bahar
*/
public class ComparatorDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(1);
        list.add(3);
        Object[] array = list.toArray();
        Integer[] array1 = list.toArray(new Integer[0]);
        //Collections.sort(list);
        list.sort(null);
        /*
        Sort method expect comparator, null=> natural order=>ascending
        Comparator is a interface( functional interface) which has a method compare()
        compare() expects two objects of same time.

        Since comparator is interface, we can use it by:
        i) creating concrete class
        ii) using lambda expression
         */
        class StringLengthComparator implements Comparator<String>{

            @Override
            /* if this method returns 
            i)negative : o1 comes first
            ii)positve : o2 comes first
            iii)0 : same level
            */
            public int compare(String o1, String o2) {
                return o1.length()- o2.length();
            }

        }
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("date");
        fruits.add("Banana");
        //fruits.sort(null); //natural order is lexiographic ,to write custom logic(based on length) create a class
        fruits.sort(new StringLengthComparator());
        //using lambda expresion
        fruits.sort((a,b)->a.length()-b.length());
        System.out.println(fruits);

        /*
        When we do list.sort(null), where list stores primtive type, then will sort it in natural order.
        Because interally they (eg: String, List<>) implements Comparable<T> , which has a method compareTo()
        CompareTo method is implemented as ascending order, so bydefault we are getting ascending order

        For custom type we have to implement compareTo() method to recieve natural order we we sort.
        it is not madnatory have natural order, we can always implement custom logic
         */
        class Student {
            private String name;
            private double gpa;
            
            public Student(String name, double gpa) {
                this.name = name;
                this.gpa = gpa;
            }
            public String getName() { return name; }
            
            public double getGpa() { return gpa; }
        }
    

        List<Student> students = new ArrayList<>() ;
        students.add(new Student( "Alice",3.5));
        students.add(new Student("Bob",3.7));
        students.add(new Student ("Charlie", 3.5));
        students.add(new Student("Akshit",3.9));
        students.sort((o1, o2)->(int) (o2.getGpa() - o1.getGpa())); //this will retun int value, calculation will be wrong

        students.sort((o1, o2)->{
            if (o2.getGpa() - o1.getGpa() > 0) {
                return 1;
            }else if(o2.getGpa() - o1.getGpa() < 0) {
                return -1;
            }else {
                return 0;
            }
        });
        //If GPA same, print in alphabatic order
        students.sort((o1, o2)->{
            if (o2.getGpa() - o1.getGpa() > 0) {
                return 1;
            }else if(o2.getGpa() - o1.getGpa() < 0) {
                return -1;
            }else {
                return o1.getName().compareTo(o2.getName());
            }
        });
        
        // ANother way in java 8+ , comparing is static method
        // ::=> method reference
        Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);
        students.sort(comparator);
        for (Student s : students) {
            System. out.println(s.getName() + ":"+ s.getGpa());
        }
        
        //This is also possible, we can add comparator in Collections.sort as well
        Collections.sort(students,comparator);
    }
}
