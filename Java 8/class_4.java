import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

class Employee {
    String name;
    int id;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " : " + name;
    }
}


// Comparable is used on class definition compareTo()
// Comparator is used by making separate class or by lambda expression compare()


// Anonymous Inner Class Vs Lambda expression
// ------------------------------------------
// Anonymous inner class creates .class file but lambda expression does not create
// lambda expression only for functional interfaces
//anonymous inner class for class (commonly abstract) or interface
class Animal {
    void makeSound() {
        System.out.println("Make some sound");
    }
}

abstract class Shape {
    abstract void draw();
}

interface Greeting {
    void hello();
}


interface A {
    void m1();
    void m2();
}

public class class_4 {
    public static void main(String[] args) {
//        List<Employee> l = new ArrayList<>();
//        l.add(new Employee(5, "Akash"));
//        l.add(new Employee(7, "Ram"));
//        l.add(new Employee(2, "Harsh"));
//        l.add(new Employee(1, "Kallol"));
//        l.add(new Employee(3, "Durga"));
//
//        System.out.println(l);
//
////        Sort list of custom object
////        ascending order of employee id
////        Collections.sort(l, (e1, e2) -> e1.id - e2.id);
//        l.sort((e1, e2) -> e1.id - e2.id);
//        System.out.println(l);
//
//
////        sort based on alphabetical or order of employee name
//        Comparator<Employee> c = (e1, e2) -> {
//            return e1.name.compareTo(e2.name);
//        };
////        Comparator<Employee> d = Comparator.comparing(e -> e.name);
////        Comparator<Employee> e = Comparator.comparing(Employee::getName);
////        Comparator<Employee> comp = Comparator
////                .comparing(Employee::getName)
////                .thenComparing(Employee::getAge);
//
//        l.sort(c);
//        System.out.println(l);




//        Anonymous Inner Class Examples -
//        Creating a class that extends a class
//         ======================================
////        Anonymous inner class are subclass from class(commonly abstract class) or interface
////        From a class
//        Animal a = new Animal() {
//            @Override
//            void makeSound() {
//                System.out.println("Woof");
//            }
//        };
//        a.makeSound();
//
////        From an abstract class
//        Shape s = new Shape() {
//            @Override
//            void draw() {
//                System.out.println("Drawing circle");
//            }
//        };
//        s.draw();
//
////        From interface
//        Greeting g = new Greeting() {
//            @Override
//            public void hello() {
//                System.out.println("Hello");
//            }
//        };
//        g.hello();


////        using thread
////        =====================
////        To use runnable use lambda expression as it is functional interface, or name a custom class
////        or make anonymous inner class
//
//
////        creating an object of the implementation of the runnable interface
////        1. providing implementation of runnable interface
////        2. creating object from that implementation class
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    System.out.println("1st child thread");
//                }
//            }
//        };
////        r.run();
//
////        Thread must have run method, so implement inner class or provide runnable
//        Thread t = new Thread(r);
//        t.start();
//
////        Thread is main class, new Thread() {}; create a child class and t2 creating object of the child class
//        Thread t2 = new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    System.out.println("2nd child thread");
//                }
//            }
//        };
//        t2.start();
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Main thread");
//        }


//        Anonymous inner class != functional interface
//        anonymous inner class in more powerful
//        if anonymous inner class implements an interface which contains a single abstract method
//        only then we can replace anonymous inner class with lambda expression
        A a = new A() {
            @Override
            public void m1() {
            }

            @Override
            public void m2() {
            }
        };
    }
}

@FunctionalInterface
interface One {
    void m1();
}

// Valid single abstract method (one from parent zero itself)
@FunctionalInterface
interface Two extends One{
}

//Invalid as two abstract method ( one from parent one itself)
//@FunctionalInterface
//interface Three extends One{
//    void m2();
//}

// valid as single abstract method (one from parent same in itself)
@FunctionalInterface
interface Four extends One{
    void m1();
}



// 1. lambda expression can be written only for functional interface (must)
// 2. functional interface can be or can not be declared with FunctionalInterface annotation (annotation optional)
// 3. if an interface that contains a single abstract method that is always functional interface  whether we use FunctionalInterface
// annotation or not