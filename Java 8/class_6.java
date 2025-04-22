import java.util.ArrayList;
import java.util.function.Predicate;

class Employee2 {
    String name;
    double salary;

    Employee2(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class class_6 {
    public static void main(String[] args) {
        // Predicate<> interface contains test method to check a certain condition
        Predicate<Integer> p1 = i -> i % 2 == 0;
//        System.out.println(p1.test(15));
//        System.out.println(p1.test(10));

        // Predicate<Employee> p2 = e -> e.salary > 10000 && e.age < 25;
        // p2.test(new Employee("Ram", 22, 15000));

        // write a predicate to check the length of a string is greater than 5 or not;
        Predicate<String> p3 = s -> s.length() > 5;
//        System.out.println(p3.test("Kallol"));
//        System.out.println(p3.test("Hi"));


        // check the employee whose salary is greater than 30k
        /*

        ArrayList<Employee2> employeeList = new ArrayList<>();
        employeeList.add(new Employee2("Ram", 26478));
        employeeList.add(new Employee2("Shyam", 46150));
        employeeList.add(new Employee2("Harsh", 43687));
        employeeList.add(new Employee2("Abhijeet", 28435));
        employeeList.add(new Employee2("Karan", 46795));
        employeeList.add(new Employee2("Dev", 30000));

        Predicate<Employee2> p4 = e -> e.salary > 30000;
        for (Employee2 e : employeeList) {
            if (p4.test(e)) {
                System.out.println(e.name + " -> " + e.salary);
            }
        }
         */


        // combine multiple predicate - Predicate joining
        // 1. predicate to check is even or odd
        // 2. predicate to check the number is multiple of 3 or not
        // p1.and(p2).test(40)  -> and
        // p1.or(p2).test(30) -> or
        Predicate<Integer> p5 = n -> n % 2 == 0;
        Predicate<Integer> p6 = n -> n % 3 == 0;
        System.out.println(p5.and(p6).test(30));
        System.out.println(p5.and(p6).test(33));
        System.out.println(p5.or(p6).test(33));
        // p1.negate().test() -> not operation
    }
}
