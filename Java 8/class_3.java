import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface Square {
    public int square(int n);
}

class SquareImpl implements Square {
    public int square(int n) {
        return n * n;
    }
}

class SquareClass {
    public void demo() {
        SquareImpl a = new SquareImpl();
        System.out.println("Square of " + 3 + " is " + a.square(3));

        Square b = new SquareImpl();
        System.out.println("Square of " + 3 + " is " + b.square(3));

        // Lambda expression
        Square s = n -> n * n;
        System.out.println("Square of " + 3 + " is " + s.square(3));
    }
}

// Lambda expression will not generate any separate .class file
// at the time of compilation it will compile


// Multithreading
// By implementing Runnable interface
// By extending Thread class
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread");
        }
    }
}


// Comparator interface
// compare() method
// int compare(Object a, Object b)
//    return -ve iff a has to come before b
//    return +ve iff a has to come after b
//    return 0 iff a and b are same
class MyComparator implements Comparator<Integer>{
    public int compare(Integer a, Integer b){
        return b - a;
    }
}


public class class_3 {
    public static void main(String[] args) {
//        lambda expression only applicable for functional interface
//        if we not have functional interface we can not write lambda expression

//        SquareClass s = new SquareClass();
//        s.demo();


//        Multithreading
//        MyRunnable r = new MyRunnable();
//        Thread t = new Thread(r);
//        t.start();
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Main Thread");
//        }

//        Lambda expression
//        Runnable r = () -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println("Child Thread - 1");
//            }
//        };
//        Thread t = new Thread(r);
//        t.start();
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Main Thread - 1");
//        }


        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(10);
        list.add(5);
        list.add(1);
        System.out.println(list);

//      sort in descending order
//        Collections.sort(list, new MyComparator());

//        using lambda expression
        Comparator<Integer> c = (a, b) -> b - a;
        Collections.sort(list, c);
        System.out.println(list);

//        list.stream().forEach(System.out::println);
//        list.forEach(System.out::println);

        List<Integer> even = list.stream().filter(n -> n%2 == 0).toList();
        System.out.println(even);
    }
}
