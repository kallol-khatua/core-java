class Outer {
    private final int num = 30;

    public void getNum() {
        System.out.println("GetNum function");
        System.out.println(num);

        Outer o = new Outer();
        Outer.Inner in = o.new Inner();

        in.print();
    }

    class Inner {
        public void print() {
            System.out.println("Print function inside member inner class");
            System.out.println(num);
        }
    }
}

public class MemberInnerClass {
    public static void main(String[] args) {
        Outer o = new Outer();
        Outer.Inner in = o.new Inner();

        in.print();

        o.getNum();
    }
}
