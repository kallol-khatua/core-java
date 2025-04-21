// from abstract class
abstract class Person {
    // abstract method
    // public abstract void eat();
    // protected abstract void eat();
    abstract void eat(); // default (package-private)

    // NOTE
    // ===============================
    // can not override private method
    // can not final method
    // static method can not be abstract


    void sleep() {              // concrete method
        System.out.println("Sleeping...");
    }
}


// From concrete method
class Animal {
    protected void makeSound() {
        System.out.println("Animal sound");
    }

    // can not use private method from outside the class,
    // can not override private method
    private void a() {

    }
}


// from interface
interface Eatable {
    // implicitly eat method is public abstract ****************** (without body)
    void eat();

    // after java 8 default and static (with body)
    // after java 9 private(for internal use) (with body)
}


public class AnonymousInnerClass {
    public static void main(String[] args) {
        // from abstract class
        // =============================
        Person p = new Person() {
            // since abstract method eat() is default (package-private)
            // so possible access modifier can be default (package-private), protected, public
            @Override
            void eat() {
                System.out.println("Eating");
            }
        };
//        p.eat();


        // From concrete method
        // =============================
        // if we do not override any method then parent method will execute
        Animal a = new Animal() {
            @Override
            public void makeSound() {
                System.out.println("Animal sound object");
            }
        };
        a.makeSound();


        // from interface
        // =============================
        Eatable e = new Eatable() {
            @Override
            public void eat() {
                System.out.println("nice fruits");
            }
        };
        e.eat();
    }
}