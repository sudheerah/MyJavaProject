package com.java;

interface A {
    void show(int i);

}

//class Xyz implements A {
//    public void show(int i)
//    {
//        System.out.println("This is implementation of interface A show method" + i);
//    }
//}

public class LambdaDemo {

    public static void main (String args[]) {
        A obj;
//      obj = new Xyz();  // Can remove the class Xyz (above) as it has ONLY one method and do the implementation of the interface as below
//        obj = new A()  // Anonymous class inner class, This can be seen after compiling as $ class
//        {
//            public void show(int i)
//            {
//                System.out.println("This is implementation of interface A show method" + i);
//            }
//        };

        // Remove the boiler plate code from above code with lambda expression as below with Java8. Here you don't have inner class
        // In functional interface can use lambda expression
//        obj = (i) ->
//            {
//                System.out.println("This is implementation of interface A show method" + i);
//            };

        // Since the method has only one line can further shrinking the code
//        obj = (i) -> System.out.println("This is implementation of interface A show method" + i);
        obj = i -> System.out.println("This is implementation of interface A show method" + i);

        obj.show(6);
    }
}
