package task4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.abs;

public class MinMove {
    String pathName;
    ArrayList<Integer>integers = new ArrayList<>();
    public MinMove(String pathName) {
        this.pathName = pathName;
    }
    public int result() {
        File file = new File(pathName);
        int result = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                int i = Integer.parseInt(reader.readLine());
                integers.add(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(integers);
        int middle = (integers.size()-1)/2;

      for (int i : integers){
          result += abs(i-integers.get(middle));
      }
        return result;
    }
}
