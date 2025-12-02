import java.util.ArrayList;
import java.util.List;

public class ComparableDemo {
    /*
    Comparable used when we need by default sorting logic for custom class

    ->Comparable has compareTo(o1) method =>it has 1 obj,means need to compare to the class=> class ke andar
    ->This method will call inside compare(o1,o2) method of comparator=> o1.compareTo(o2)
    ->since o1-o2 <0 => o1 first, then o2
            o1-o2>0 =>  o2 first, then o1
        so when we get compareTo( o1) => check this-other <0 or >0
    */
   public static void main(String[] args) {
       List<Student> students = new ArrayList<>() ;
        students.add(new Student( "Alice",3.5));
        students.add(new Student("Bob",3.7));
        students.add(new Student ("Charlie", 3.5));
        students.add(new Student("Akshit",3.9));
        students.sort(null);
        for (Student s : students) {
            System. out.println(s.getName() + ":"+ s.getGpa());
        }
   }
}

class Student implements Comparable<Student>{
    private String name;
    private double gpa;
            
    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }
    public String getName() { return name; }
            
    public double getGpa() { return gpa; }

    @Override
    public int compareTo(Student o){
        return Double.compare(o.getGpa(),this.getGpa());
    }
}