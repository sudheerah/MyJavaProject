package com.java;

import java.io.InputStream;
import java.util.Scanner;

public class FileRead {

    public static void main(String args[]) {
        FileReadAndUpdate fr = new FileReadAndUpdate();
        String file = fr.getConfigSettings("{{credentialId}}", "123", "./main/TestData.json");
    }


}

class FileReadAndUpdate {

    public String getConfigSettings(String oldVaue, String newValue, String fileName) {

        ClassLoader cl = getClass().getClassLoader();
//        File input = new File(cl.getResource(fileName).getFile());  // get the file name
        InputStream input = cl.getResourceAsStream(fileName);   // get the file content

        Scanner s = new Scanner(input).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";

        String updatedFile = result.replace(oldVaue, newValue);

        System.out.println(updatedFile);

        return null;
    }
}
