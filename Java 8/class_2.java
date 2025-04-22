import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface MyAdd {
    void add(int a, int b);
}

public class class_2 {
    public void m1() {
        System.out.println("Hello");
    }

    // Lambda expression - anonymous function
// no name
// no modifiers
// no return type
    Runnable a = () -> {
        System.out.println("Hello");
    };
    //    if single line can write without {}
    Runnable b = () -> System.out.println("Hello");


    //    -----------------------------------------------------------------------------
    public void add(int a, int b) {
        System.out.println(a + b);
    }

    public void add() {
// BiConsumer - 2 input, no return, accept(1, 2)
        BiConsumer<Integer, Integer> v = (a, b) -> System.out.print(a + b);
        v.accept(5, 10); // Outputs: 15
        // Consumer - 1 input, no return, accept(1)

        MyAdd d = (a, b) -> System.out.print(a + b);
        d.add(5, 10); // Outputs: 15
    }


    // -------------------------------------------------------------------------
    public int square(int a) {
        return a * a;
    }

    // Function - 1 input, return 1, apply(1)
    //  if single input then () are optional
    Function<Integer, Integer> square2 = n -> n * n;

//    n -> return n * n;  invalid if no curly braces then can not use return
//    n -> {return n * n;};  valid
//    n -> {return n * n};  invalid   semicolon not present
//    n -> {n * n;};  invalid   return keyword not present
//    n -> n * n;  valid
    // **************
    // without curly braces we can not use return keyword, compiler will consider return value automatically
    // with curly braces if we want to return any value compulsory we should use return
    //

    // BiFunction - 2 input, return 1, apply(1, 2)
//    BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
//    BiFunction<Integer, Integer, Integer> add2 = Integer::sum;

    // Function - list input, return 1, apply(List)
//    Function<List<Integer>, Integer> sumThree = list -> list.getFirst() + list.get(1) + list.get(2);
    // System.out.println(sumThree.apply(List.of(5,10,15))); // Output: 30


    // --------------------------------------------------------------------------
//    once we write lambda expression
//    functional interface
//    contains single abstract method (SAM)
//    Runnable
//    Callable
//    Comparable
//    ActionListener

}

// functional interface must contain a single abstract method
@FunctionalInterface
interface MyInterface {
    public void m1();

    default void m2() {

    }

    public static void m3() {

    }
}

//private, default, static method in an interface should have a body
// extends a functional interface so abstract method must be same
@FunctionalInterface
interface a extends MyInterface {
    public void m1();
}

// non-functional interface can have multiple abstract method
interface b extends MyInterface {
    public void m8();

    public void m30();
}


// Lambda expression with functional interface
//-----------------------------------------------
//@FunctionalInterface
interface DemoInter {
    public void m1();
}
class Demo implements DemoInter {
    public void m1() {
        System.out.println("Hello");
    }
}
class call {
    public static void main(String[] args) {
        Demo a = new Demo();
        a.m1();

        // Valid parent reference can hold child reference
        DemoInter b = new Demo();
        b.m1();

        // Direct implementation using lambda expression
        DemoInter c = () -> System.out.println("Hello, By lambda expression");
        c.m1();
    }
}



@FunctionalInterface
interface Add {
    public void add(int a, int b);
}
class AddNum implements Add {
    public void add(int a, int b) {
        System.out.println(a + b);
    }
}
class CallAdd {
    public static void main(String[] args) {
        AddNum a = new AddNum();
        a.add(8, 7);

        Add b = new AddNum();
        b.add(8, 7);

        Add c = (x, y) -> System.out.println(x + y);
        c.add(8, 7);
    }
}

// this will affect performance as single type we in compile in production run time it will use compiled code