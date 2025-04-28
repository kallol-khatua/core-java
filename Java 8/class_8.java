import java.util.ArrayList;
import java.util.Date;
import java.util.function.*;

class Movie {
    String name;

    Movie(String name) {
        this.name = name;
    }
}

class User {
    int id;
    String name;
    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Emp {
    String name;
    double salary;
    Emp(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class class_8 {
    public static void main(String[] args) {
        Consumer<Movie> c1 = m -> System.out.println(m.name + " Ready to release");
        Consumer<Movie> c2 = m -> System.out.println(m.name + " Already released");
        Consumer<Movie> c3 = m -> System.out.println(m.name + " Flop movie");

//        consumer chaining is also type of Consumer
        Consumer<Movie> cc = c1.andThen(c2).andThen(c3);

//        andThen() method is present in Consumer() interface
//        but Function() interface have both andThen() and compose() method

        Movie m = new Movie("Movie name");
//        c1.accept(m);
//        c2.accept(m);
//        c3.accept(m);
//        cc.accept(m);


//        just supply required object do not take any input -> Supplier,
        /*
        interface Supplier<R> {
            public R get();
        }
         */
        // make a supplier to get system date
//        Supplier<Date> s1 = () -> new Date();
//        System.out.println(s1.get());


//        supply random otp of length 6
        Supplier<String> s2 = () -> {
            StringBuilder otp = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                otp.append(String.valueOf((int) (Math.random() * 10)));
            }
            return otp.toString();
        };
//        System.out.println(s2.get());



//        Two input
//        check sum of two num is even or odd
        BiPredicate<Integer, Integer> bp1 = (a, b) -> (a + b) % 2 == 0;
//        System.out.println(bp1.test(21, 8));
//        System.out.println(bp1.test(20, 8));
//        normal Predicate take 1 input and perform some condition check
//        but sometimes our requirement is to perform condition check on 2 input
//        we can use BiPredicate same as Predicate just take 2 input
        /*
        interface BiPredicate(T t1, T t2) {
            public boolean test(T t1, T t2);
        }

        methods -> .and() , .or() , .negate()
         */



//        BiFunction -> take two input and perform some operation and return result
        /*
        interface BiFunction<T, U, R> {
            public R apply();
        }

        methods -> .andThen()
         */
        BiFunction<Integer, String, User> bf1 = (id, name) -> new User(id, name);
//        User u1 = bf1.apply(1, "Kallol");
//        System.out.println(u1.name);
        ArrayList<User> userList = new ArrayList<>();
        userList.add(bf1.apply(1, "Kallol"));
        userList.add(bf1.apply(2, "Harsh"));
        userList.add(bf1.apply(3, "Karan"));
//        for(User u: userList) {
//            System.out.println("User id -> " + u.id);
//            System.out.println("User name -> " + u.name);
//            System.out.println();
//        }




        // BiConsumer
//        ====================
        /*
        interface BiConsumer<T, U> {
            public void accept(T t, U u);
        }

        methods -> .andThen()
         */
//        System.out.println("BiConsumer");
        BiConsumer<Integer, String> com1 = (id, name) -> {
            System.out.println("User id -> " + id);
            System.out.println("User name -> " + name);
        };
//        for(User u: userList) {
//            com1.accept(u.id, u.name);
//            System.out.println();
//        }


        Consumer<Emp> printEmp = e -> {
            System.out.println("Employee name -> " + e.name);
            System.out.println("Salary -> " + e.salary);
        };
        ArrayList<Emp> empList = new ArrayList<>();
        empList.add(new Emp("Kallol", 50000));
        empList.add(new Emp("Harsh", 65000));
        System.out.println("Before increment");
        for(Emp e: empList) {
            printEmp.accept(e);
        }
        BiConsumer<Emp, Double> inc = (e, amount) -> e.salary += amount;
        for(Emp e: empList) {
            inc.accept(e, 5000d);
        }
        System.out.println();
        System.out.println("After increment");
        for(Emp e: empList) {
            printEmp.accept(e);
        }

        
    }
}
