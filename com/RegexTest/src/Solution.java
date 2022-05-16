import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/JavaTest/1.txt"));
        String startRegex = "<"+args[0]+">";   //<span>
        String endRegex   = "</"+args[0]+">";   //</span>
        String exampleHTML = "";
        int replyFlag1 = 0;
        int replyFlag2 = 0;




        /*Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(exampleHTML);
        //System.out.println(matcher.find() ? matcher.group());
        while (matcher.find()){
            System.out.println(matcher.group());
        }*/

    }
}
