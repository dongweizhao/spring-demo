package com.example.spring.demo;

public class LambdaExample {

    public static void main(String[] args) {
        //无参数，无返回值：
        Runnable noParametersNoReturnValue = () -> System.out.println("Hello, World!");
        noParametersNoReturnValue.run(); // 输出: Hello, World!

        //单参数，无类型声明：
        java.util.function.Consumer<String> singleParameterNoType = s -> System.out.println(s);
        singleParameterNoType.accept("Single Parameter, No Type!"); // 输出: Single Parameter, No Type!
        //单参数，带类型声明：
        java.util.function.Consumer<String> singleParameterWithType = (String s) -> System.out.println(s);
        singleParameterWithType.accept("Single Parameter with Type!"); // 输出: Single Parameter with Type!

        //多个参数,无类型声明
        java.util.function.BiFunction<Integer, Integer, Integer> multipleParametersTypeInferred = (a, b) -> a + b;
        System.out.println(multipleParametersTypeInferred.apply(5, 10)); // 输出: 15

        //多个参数,有类型声明
        java.util.function.BiFunction<Integer, Integer, Integer> multipleParametersWithType = (Integer a, Integer b) -> a + b;
        System.out.println(multipleParametersWithType.apply(5, 10)); // 输出: 15

        // 多个参数，并且多行实现
        java.util.function.BiFunction<Integer, Integer, Integer> multipleStatements = (a, b) -> {
            int sum = a + b;
            return sum;
        };
        System.out.println(multipleStatements.apply(5, 10)); // 输出: 15

        // 无参数，但是有返回值
        java.util.function.Supplier<Integer> noParametersReturnValue = () -> 42;
        System.out.println(noParametersReturnValue.get()); // 输出: 42
    }
}