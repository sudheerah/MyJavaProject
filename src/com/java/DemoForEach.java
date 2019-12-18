package com.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

//class ConsImpl implements Consumer<Integer>
//{
//    public void accept(Integer i)
//    {
//        System.out.println(i);
//    }
//}

public class DemoForEach {

    public static void main(String args[])
    {
        List<Integer> values = Arrays.asList(4,5,6,7,8);

        // External loops wher values picked up from outside

//        for (int i = 0;i<values.size();i++)
//        {
//            System.out.println(values.get(i));
//        }

        // Enhance for

//        for (int i : values)
//        {
//            System.out.println(i);
//        }

        // Internal loops 1.8, much faster than external loops
//       values.forEach(i -> System.out.println(i));   // Lambda

//        Consumer<Integer> c = new ConsImpl();

        // if class use ONLY once it can be defined as below which is anonymous inner class
//        Consumer<Integer> c = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer i) {
//                System.out.println(i);
//            }
//        };

        // Further can remove all boiler plate code there as below. Have to have lambda expression here
//        Consumer<Integer> c = (Integer i) -> {
//                System.out.println(i);
//            };

        // Since method contain one line do further change as below
//        Consumer<Integer> c = (Integer i) -> System.out.println(i);

        //Since we already working with integer can remove that as well and since just onepoarameter remove the brackets as well
//        Consumer<Integer> c = i -> System.out.println(i);
//        values.forEach(c);

        // Further
        values.forEach(i -> System.out.println(i)); // This is implementation of Consumer interface in Java8 as shown in LambdaDemo.java
    }
}
