package task4;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        MinMove minMove = new MinMove(args[0]);
        System.out.println(minMove.result());
    }
}
