import java.sql.Struct;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class class_7 {
    public static void main(String[] args) {
//        Predicate contain test method
//        Predicate<Integer> p1 = i -> i % 2 == 0;
//        System.out.println(p1.test(40));


//        input -----> perform operation ---> output
//        Function contains apply method
/*
        interface Function<T, R> {
            public R apply(T t);
        }
 */
//        Function<Integer, Integer> f1 = i -> i * i;
//        int num = 5;
//        System.out.println("Square of " + num + " is " + f1.apply(num));


//        take string as argument and return length of the string
//        Function<String, Integer> f2 = s -> s.length();
//        String name = "Kallol";
//        System.out.println(f2.apply(name));


//        student -> find grade -> return grade
        class Student {
            int marks;
            String name;

            Student(String name, int marks) {
                this.name = name;
                this.marks = marks;
            }
        }
        Function<Student, String> f3 = s -> {
            int marks = s.marks;
            if (marks >= 80) return "A";
            else if (marks >= 60) return "B";
            else if (marks >= 40) return "C";
            return "F";
        };

//        Student s1 = new Student("Kallol", 75);
//        System.out.println("grade of " + s1.name + " is -> " + f3.apply(s1));

//        predicate and function together
//        print grade of the student whose marks are greater than 60
        Predicate<Student> p2 = s -> s.marks >= 60;
        Student[] arr = {
                new Student("Abhijeet", 80),
                new Student("Karan", 75),
                new Student("Kallol", 58),
                new Student("Harsh", 60)
        };
        Consumer<Student> c1 = s -> {
            System.out.println("name -> " + s.name);
            System.out.println("marks -> " + s.marks);
            System.out.println("Grade -> " + f3.apply(s));
            System.out.println();
        };
        for (Student s : arr) {
            if (p2.test(s)) {
                c1.accept(s);
            }
        }




//        Function Chaining
//        f1.andThen(f2).apply(i)   ---->  first f1 followed by f2
//        f1.compose(f2).apply(i)   ----> first f2 and then f1
//        f1.andThen(f2).andThen(f3).... -> any number
        Function<Integer, Integer> f4 = i -> i * i;
        Function<Integer, Integer> f5 = i -> i + 5;
//        System.out.println(f4.andThen(f5).apply(3));
//        System.out.println(f4.compose(f5).apply(3));




//        Consumer -> take input and does not return anything
//        e.g. -> take and save to database
        /*
        interface Consumer<T> {
            public void accept();
        }
         */
        Consumer<String> c2 = s -> System.out.println(s);
//        c2.accept("Kallol");
    }
}
