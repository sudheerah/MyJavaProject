package com.java;

import java.util.Arrays;
import java.util.List;


interface Parser
{
    String parse(String s);
}

class StringParser
{
    public String convert(String s)
    {
        if (s.length()<=3)
            s = s.toUpperCase();
        else
            s = s.toLowerCase();

        return s;
    }
}

class MyPrinter
{
    public void print(String str, Parser p)
    {
        str = p.parse(str);
        System.out.println(str);
    }
}


public class MethRef{

    public static void main (String args[]) {
        List<String> names = Arrays.asList("John", "Jason", "Mark", "Steve");
        names.forEach(System.out::println); // pass method as ref System.out is class name :: is the syntax

        StringParser sp = new StringParser();
        String str = "Jason Bourne";
        MyPrinter mp = new MyPrinter();
//        mp.print(str, new Parser() {
//            @Override
//            public String parse(String s) {
//                return StringParser.convert(s);
//            }
//        });

        // re-write above code with lambda expression by removing boiler plate
//        mp.print(str, (String s) -> StringParser.convert(s));
//        mp.print(str, s -> StringParser.convert(s));
//          mp.print(str, StringParser::convert); // This code does the same thing and just passing the method ref without method variable

        // in instance method need to use object
        mp.print(str, sp::convert);

    }
}
