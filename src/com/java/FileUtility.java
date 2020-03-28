package com.java;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FileUtility {

    public static void main(String args[]) {
        FileReadAndUpdate fr = new FileReadAndUpdate();
        String file = fr.getConfigSettings("{{credentialId}}", "123", "././main/resources/TestData.json");
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

    public String replaceFileText(String oldVaue, String newValue, String fileName) {
        ClassLoader cl = getClass().getClassLoader();
        InputStream input = cl.getResourceAsStream(fileName);   // get the file content

//        InputStreamReader isReader =
//                new InputStreamReader(
//                        cl.getResourceAsStream(fileName));
//        BufferedReader br = new BufferedReader(isReader);

        Scanner s = new Scanner(input).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";

        String updatedFile = result.replace(oldVaue, newValue);

//        PrintWriter writer =
//                new PrintWriter(
//                        new File(this.getClass().getResource(fileName).getPath()));

//        PrintWriter writer =
//                new PrintWriter(
//                        new File(cl.getResource(fileName).getPath()));
//
//        writer.println(updatedFile);
//        writer.flush();


//        FileWriter fstream = null;
//        fstream = new FileWriter("./src/main/resources/" + fileName);
//        BufferedWriter out = new BufferedWriter(fstream);
//        out.write(updatedFile);
//        out.write("\n");
//        out.flush();

        return updatedFile;
    }
}
