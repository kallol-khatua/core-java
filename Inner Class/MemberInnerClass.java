class Outer {
    private final int num = 30;

    public void getNum() {
        System.out.println("GetNum function");
        System.out.println(num);

        Outer o = new Outer();
        Outer.Inner in = o.new Inner();
        // from within the outer class can create the object of inner class directly
//        Inner in = new Inner();

        in.print();
    }


    // access modifier of the inner can be public or default ot protected ot private
    // for private inner class object can be created within its outer class itself
    class Inner {
        public void print() {
            System.out.println("Print function inside member inner class");
            System.out.println(num);
        }
    }
}


// object of member inner class exist within the object of its outer class
// so the inner class can access all data members including private
public class MemberInnerClass {
    public static void main(String[] args) {
        Outer o = new Outer();
        Outer.Inner in = o.new Inner();

        in.print();

        o.getNum();
    }
}
