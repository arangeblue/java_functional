package functionalinterface;

import java.util.function.Function;

public class _Function {
    
    public static void main(String[] args) {

        int increment1 = increment(1);
        System.out.println(increment1);


        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(addBy1AndThenMultiplyBy10.apply(4)); 
    }
    

    // incrementByOneFunction과 increment는 동일한 결과를 보낸다.
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;


    static int increment(int number) {
        return number + 1;
    }
}
