/*
Every class extends Object class, so all classes have their hascode() equalsTo() toString() methods
Bydefault every class has the implemetation of hascode()

In below ex: although we are assuming alice is same person, but since we have created 2 instances p1 and p3,
They will different hashcode
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeAndEqualsDemo {
    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person("Alice",1);
        Person p2 = new Person("Bob",2);
        Person p3 = new Person("Alice",1);

        map.put(p1, "Engineer"); // hashcode1 -- > index1
        map.put(p2, "Designer"); // hashcode2 -- > index2
        map.put(p3, "Manager"); // hashcode1 -- > index1 : we are assuming it should be same, but it will not since p1 and p3 are different instance
        /*If we don't implement hashcode and equals explicitly .otput will be : 3,Engineer,Manager
        After hascode and equals implementation , output becomes 2,Manager,Manager
        */
        System. out.println("HashMap Size: "+ map.size());
        System.out.println("Value for p1: "+ map.get(p1));
        System. out.println("Value for p3: "+ map.get(p3));
        System.out.println("HashCode of p1: "+ p1.hashCode());
        System. out.println("HashCode of p3: "+ p3.hashCode());

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Shubham", 90); // hashcode1 -- > index1
        map1.put("Neha", 92); // hashcode2 -- > index2
        map1.put("Shubham", 99); // hashcode1 -- > index1 -- > equals() ==false -- > replace

        }
    }
class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,id);
    }

  

    @Override
    public String toString() {
        return "id :"+id+" name: "+name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        //Main Logic
        //Using objects to avoid null pointer exception
        return this.id == other.id && Objects.equals(this.name, other.name);
    }
    
}