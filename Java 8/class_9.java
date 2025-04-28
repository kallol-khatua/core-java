import java.util.function.*;

public class class_9 {
    public static void main(String[] args) {
//        autoboxing and unboxing
//        primitive to wrapper class -> autoboxing
//        wrapper class to primitive -> unboxing

        Predicate<Integer> p1 = i -> i % 2 == 0;
        IntPredicate p2 = i -> i % 2 == 0;
        int[] nums = {3, 1, 8, 4, 9, 7};
//        for(int i : nums) {
//            if(p2.test(i)) {
//                System.out.println(i);
//            }
//        }

//        int -> Integer -> int
//        can use primitive version of functional interfaces

//        Primitive Predicate type
//        IntPredicate , DoublePredicate, LongPredicate
//        If need to take two input then normal BiPredicate<T, U>




//        Primitive Function
//        ======================
//        Function<T, R>
        /*

// input specified out any
        DoubleFunction<R>  input double output any
        LongFunction<R>   in Long out any
        IntFunction<R>  in int out any

// in and out both
        DoubleToIntFunction    in double out int
                            applyAsInt()
        DoubleToLongFunction    in double out long
                            applyAsLong()

        IntToLongFunction   in int out long
                            applyAsLong()
        IntToDoubleFunction     in int out double
                            applyAsDouble()

        LongToIntFunction   in long out int
                            applyAsInt()
        LongToDoubleFunction     in long out double
                            applyAsDouble()

//    in any out is specified
        ToDoubleFunction<T> in any out double
                            applyAsDouble()
        ToIntFunction<T>  in any out int
                            applyAsInt
        ToLongFunction<T>   in any out Long
                            applyAsLong()
         */

        /*
        BiFunction<T, U, R>
        ToIntBiFunction<T, U> out is int
                            applyAsInt()
        ToLongBiFunction<T, U> out is long
                           applyAsLong()
        ToDoubleBiFunction<T, U> out is double
                            applyAsDouble()
         */
        ToIntFunction<String> f1 = s -> s.length() - 1 + 1;
//        System.out.println(f1.applyAsInt("Kallol"));

        IntToDoubleFunction f2 = i -> Math.sqrt(i);
//        System.out.println(f2.applyAsDouble(8));





        // Consumer
        /*
        IntConsumer     in int
                        void accept(int value)
        DoubleConsumer  in double
        LongConsumer    in long
        --------------------------------
        type of bi-consumer
        ObjDoubleConsumer<T>  in obj and double
                             void accept(T t, double value)
        ObjIntConsumer<T>    in obj and int
                             void accept(T t, int value)
        ObjLongConsumer<T>    in obj and long
                             void accept(T t, long value)
        -------------------------------
         */




//      Supplier
        /*
        BooleanSupplier         return boolean  getAsBoolean()
        DoubleSupplier         return double     getAsDouble()
        IntSupplier         return int   getAsInt()
        LongSupplier     return long   getAsLong()
         */



//        UnaryOperator
        Function<Integer, Integer> f3 = i -> i * i;
//        System.out.println(f3.apply(5));
//        is input and output are same then can use UnaryOperator
//        it is a child of Function<T, T>
        UnaryOperator<Integer> uf1 = i -> i * i;
//        System.out.println(uf1.apply(5));

//        primitive Unary Operator
        /*
        IntUnaryOperator    applyAsInt()
        LongUnaryOperator   applyAsLong()
        DoubleUnaryOperator     applyAsDouble()
         */
        IntUnaryOperator uf2 = i -> i * i;
//        System.out.println(uf2.applyAsInt(5));


//        BinaryOperator
//        it is child of BiFunction<T, T, T>
        /*
        BinaryOperator<T>
            public T apply(T, T)
         */
        // primitive Binary Operator
        /*
        IntBinaryOperator    applyAsInt()
        LongBinaryOperator   applyAsLong()
        DoubleBinaryOperator     applyAsDouble()
         */

        IntUnaryOperator uf3 = i -> i + 1;
        System.out.println(uf3.applyAsInt(4));
        IntUnaryOperator uf4 = i -> i * i;
        System.out.println(uf4.applyAsInt(4));
        System.out.println(uf3.andThen(uf4).applyAsInt(4));

    }
}
