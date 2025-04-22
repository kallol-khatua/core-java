// Anonymous inner class can be extended from a normal class
// Anonymous inner class can be extended from an abstract class
// Anonymous inner class can be implemented from an interface that has any number of abstract method

// lambda expression can be implemented from an interface which contains a single abstract method( functional interface)

// anonymous inner class > lambda expression

// default method
// before 8 version every method inside an interface is always public and abstract
// void m1();
// public void m1();
// abstract void m1();
// public abstract void m1();
// all are public abstract

// 8 v: default method + static method
// 9 v: private method + private static method

// variables
// -------------
// public static final always


// Default method / Virtual extension method / defender method
// -----------------------------------------------------------
// when implementation class present of an interface add default method inside interface
// without effecting the implementation class add new method to an interface => default method

interface Interf {
    default void m1() {
        System.out.println("Default method");
    }

//    hashCode method available inside object class
//    default int hashCode() {
//
//    }
//    Object class method we can not implement as default method
//    these object class methods are by default available to every class
}

class Test implements Interf {
    @Override
    public void m1() {
        System.out.println("Overriding version of default method");
    }

//    can not use default keyword as a method access modifier inside a class
//    default method must be present inside an interface
}


// multiple inheritance not allowed
class P1 {
    public void m1() {
        System.out.println("P1");
    }
}

class P2 {
    public void m1() {
        System.out.println("P2");
    }
}

//Class cannot extend multiple classes
//class C1 extends P1, P2 {
class C1 extends P1 {
    public void m1() {
        System.out.println("C1");
    }
}


//interface for
// variable -> public static final
// methods -> public abstract (up-to java 7), default, static, public abstract(java 8+), private, private static( 9+)
//public interface Kallol {}   -> to use public move this to another .java file
interface Kallol {
    // Implicitly public, static, final
    int MAX = 100;

    // Implicitly public and abstract
    void doSomething();

    // Java 8+: default method
    default void defaultMethod() {
        System.out.println("Default method");
    }

    // Java 8+: static method
    static void staticMethod() {
        System.out.println("Static method");
    }

    // Java 9+: private method
    private void helperMethod() {
        System.out.println("Private helper");
    }

    // Java 9+: private method
    private static void helperMethodTwo() {
        System.out.println("Private static method");
    }
}

interface Left {
    default void m1() {
        System.out.println("Left");
    }
}

interface Right {
    default void m1() {
        System.out.println("Right");
    }
}

// if both interface have same method and in the implementation class method body not present then error
class TestInterface implements Left, Right {
    //     way to overcome error
    public void m1() {
//        calls m1() method of left interface
        Left.super.m1();
//        calls m1() method of right interface
        Right.super.m1();
        System.out.println("Class");
    }
}


// class vs interface
class Dummy {
    public static void m1() {
        System.out.println("Static method inside a class");
    }

    public void m2() {
        System.out.println("Non static method inside a class");
    }

    public void m3() {
        System.out.println("Non static method inside a class");
    }
}

class DummyExtends extends Dummy {
    public static void m1() {
        System.out.println("Static method inside extended class");
    }

    @Override
    public void m2() {
        System.out.println("Non static method inside extended class");
    }

    public void m4() {
        System.out.println("Only present in child");
    }
}


interface DummyInterface {
    static void m1() {
        System.out.println("Interface static method");
    }

    default void m2() {
        System.out.println("Interface default method");
    }

    default void m3() {
        System.out.println("Interface default method");
    }
}

class DummyInterfaceImpl implements DummyInterface {
    //    static methods can not be overridden
    public static void m1() {
        System.out.println("M1");
    }

    @Override
    public void m2() {
        System.out.println("Overridden in implementation class");
    }

    public void m4() {
        System.out.println("Only present inside implementation class");
    }

    public void method() {
//        call static method
        DummyInterface.m1();
        DummyInterfaceImpl.m1();

//        call own method, parent static method not available inside implement class
        m1();
        m2();

//        can call non-static method
        DummyInterfaceImpl di = new DummyInterfaceImpl();
    }
}

public class class_5 {
    public static void main(String[] args) {
//       Default method
        Test i = new Test();
//        i.m1();


//        multiple inheritance not possible in java
//        eg -> p1 and p2 both have m1 method
//        c1 try to extend both p1 and p2 error will occur
        C1 c = new C1();
//        c.m1();


//        class can implement multiple interface together
//        if same method present in more than one interface then that method must be override in the implementation class
        TestInterface t = new TestInterface();
//        t.m1();


//        class vs interface
//        ---------------------------------
//        Class
//        =======================
//        can call static method directly
//        static methods can not be called from an object
//        static method can not be overridden

        /*
        =================
        Dummy.m1();
        DummyExtends.m1();
//        to call non-static method need to create an object of that class
        Dummy d = new Dummy();
        d.m2();
        d.m3();
        DummyExtends de = new DummyExtends();
//        overridden method - child method will execute
        de.m2();
//        not overridden so call the parent method
        de.m3();
//        only present in child
        de.m4();
        System.out.println("Parent holds child reference");
        Dummy d1 = new DummyExtends();
        d1.m2();
        d1.m3();
//        can not call method that not present in parent
//        d1.m4();
        ====================
         */


//        interface
//        =======================
//        when static method use that in interface
//        DummyInterface di = new DummyInterfaceImpl();
////        child method not available
//        di.m2();
//        di.m3();
//        DummyInterfaceImpl diImpl = new DummyInterfaceImpl();
////        diImpl.method();
//        diImpl.m2();
//        diImpl.m3();
//        diImpl.m4();

//         anonymous inner class
//        create a class which extends the interface then create object of that class
//        parent holds child reference can execute method which are present inside interface
//        if no abstract method then optional to write the methods
        DummyInterface dj = new DummyInterface() {
            public void m4() {
                System.out.println("K");
            }
        };
        dj.m3();
        dj.m3();
//        dj.m4();    error as only child has the method parent has no reference to these method


//        static main method can also be written inside interface and give the file name with interface name
//        execution will start from that main method

//        ************************* important points *************************
//        static methods are by default not be present in extended or implemented class
//        static methods can not be overridden

//        class extends class and class implements interface
//        parent holds parent reference then ->  only parents methods can be executed
//                      child holds child reference    ||||     parent holds child reference
//        if overridden,
//                           child method              ||||        child method
//        only in parent, method available in child
//                           parent method             ||||        parent method
//        only in child,
//                          child method               ||||         error not available
    }
}
