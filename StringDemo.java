/*
String is a class, not a primitive dataType : not in collection
-> When ever we create a new object we get a memory address for the reference of that object
for ex: In below a=new String("ram") =>a is memory address for the the reference.

In case of String: we store each string literal inside string pool in heap memory
when x is created, a string literal for "Ram" is stored in the strig pool.
 Although we got to memory address for that refernce as and b, since using 'new' they will store in heap
 c and d are pointing to string literal only which is stored in string pool
 https://www.youtube.com/watch?v=0O_iH-vDuZ0&list=PLA3GkZPtsafY62QhQ030p85HAer0pFDdr&index=10

 a==b or c==d we are comparing reference, not only the value

 ***************StringBuilder******************
 ->In case of string when append other string with it, it creates a new String and consumes new memory
 ->To improve the poor perfomance of string, StringBuilder we use
 ->StringBuilder is mutable we can append without creating new object

 **********************StringBuffer****************************
->Thread safe, other similliar to stringBuilder
->Since thread safe so perfomance is slower

*/
public class StringDemo {
    public static void main(String[] args) throws InterruptedException {
        String x = "Ram";
        String a = new String("Ram");
        String b = new String(x);
        String c = "Ram";
        String d = "Ram";
        String k = new String("Kangs");//kangs is stored in both string pool and heap memory
        System. out.println(a == b) ;//false
        System. out.println(c == d);//true


        /**********Methods************** */
        String name = "Akshit Sharma";
        int length = name.length() ;
        char ch = name.charAt(length - 1);
        String name2 = "Akshit Sharma";
        System.out.println(name==name2);

        /***equals**** */
        System.out.println(name.equals(name2));

        System.out.println(name.equalsIgnoreCase(name2));

        /*****compareTo -> comapres lexigraphically*****/
        String str1 = "remote";
        String str2 = "car";
        System.out.println("ascii of r: ");
        System.out.println('r'+0);
        System.out.println("ascii of c: ");
        System.out.println('c'+0);

        int i = str1.compareTo(str2);
        System.out.println(i);//differnce between ascii value 

        String m="kangs";
        String l="KanGs";
        System.out.println(m.compareToIgnoreCase(l));//differnce between ascii value 

        /*******SubString******* */

        String name3 = "Amar Panchal";
        String substring1 = name3.substring(5);//5 to end
        String substring2 = name3.substring(5,8);//5-7
        System.out.println(substring1);
        System.out.println(substring2);

        System.out.println(name.substring(2, 8));
        System.out.println(name.subSequence(2, 8));
        // Arp is a subsequence of Amar Panchal : just pehle jo aya wo pehle ana hai,in java both same


        /*******uppercase lowecase****** */
        System.out.println(name3.toUpperCase());
        System.out.println(name3.toLowerCase());


        /********trim()-remove extra spaces of starting and ending******** */
        String name4="   tonujk  ";
        System.out.println(name4.trim());//name4.trim() new string hai, name4 ko update nehi kia hai

        /**********replace()********** */
        String name5 = "Amar Panchal";
        String newName = name5.replace("Panchal","Sharma");
        System.out.println(newName);

        /*****contains()**** */
        System.out.println(newName.contains("Amar"));



        /******startsWith()->prefix check***** */
        System.out.println(newName.startsWith("Am"));

        /******endsWith()->suffix check***** */
        System.out.println(newName.endsWith("ma"));

        System.out.println(name.isEmpty());
        System.out.println(name.isBlank());

        System.out.println(newName.indexOf('a'));//first index
        System.out.println(newName.lastIndexOf('a'));//last index

        /**********************split******************/
        String s = "a,b,c,,";
        String[] arr = s.split(","); //[a,b,c,"",""]
        System.out.println("split: "+arr.length); //3

        String s12 = "a.b.c";
        String[] arr2 = s12.split(".");
        System.out.println(arr2.length);//0 not 3

        /*Internally, split( uses regex.In regex, a dot does not mean "dot"!
        "." means match any character. So it splits on every single character in the String.*/
        String[] arr3 = s.split("\\.");
        System.out.println(arr3.length);

        //We have used escape character along with the dot.By escaping the dot, we tell Java to treat it as a literal dot.

        //Java removes the empty spaces that are there in the end.

        /****************************Static methods************************************** */
        /********number to string****** */
        String a1=String.valueOf(10); //static method
        System.out.println(a1);

        String formattedStr = String.format("My name is %s and I am %d years old.", "John", 25);
        System.out.println(formattedStr);

        /*******************************StringBuilder*****************************/
        String s1 = "Hello";
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World").append(" !").reverse();
        String string = sb.toString();
        System.out.println(string);

        String s11 = new String("Shivam");
        String s2 = new String("Shivam");
        System.out.println(s11.equals(s2));

        StringBuffer s3 = new StringBuffer("Shivam");
        StringBuffer s4 = new StringBuffer("Shivam");
        System.out.println(s3.equals(s4));

        StringBuilder s5 = new StringBuilder("Shivam");
        StringBuilder s6 = new StringBuilder("Shivam");
        System.out.println(s5.equals(s6));


        /*Output:
        true 
        false
        false

        StringBuffer and StringBuilder have not overriden this equals method.
        In Object class's equals( method,
        there is a default implementation
        which compares using ' == '.*/

        /**********************StringBuffer****************************/
        

        Task t1 = new Task(sb);
        Task t2 = new Task(sb);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final length: "+ sb.length());

        
    }
    
}

class Task extends Thread { 
            private StringBuilder sb;

            public Task(StringBuilder sb) { 
                this.sb = sb;
            }

            @Override
            public void run(){
                for (int i = 0; i < 1000; i++) {
                    sb.append("a");
                }
            }
    }