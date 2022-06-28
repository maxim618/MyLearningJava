package task2;

import java.io.*;
import java.util.ArrayList;

public class Main {
    static Coord radius = new Coord();
    static Coord circle = new Coord();

    public static void main(String[] args) {
        ArrayList<Coord>listPoints = new ArrayList<>();

        try (BufferedReader reader1 = new BufferedReader(new FileReader(args[0]));
             BufferedReader reader2 = new BufferedReader(new FileReader(args[1]))) {
            String line;
            String[]array;
            Coord coord;

              line = reader1.readLine().replace("\r\n", "");
              array = line.split(" ");
              circle = new Coord(array[0],array[1]);
              line = reader1.readLine().replace("\r\n", "");
              radius = new Coord(line);

            while (reader2.ready()) {
                line = reader2.readLine().replace("\r\n", "");
                array = line.split(" ");
                coord = new Coord(array[0],array[1]);
                listPoints.add(coord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        printResult(listPoints);
    }
    public static void printResult(ArrayList<Coord>points){
        for(Coord c : points){
            float dist = (float) distance(circle.x, circle.y, c.x,c.y);
            if(dist==radius.radius)System.out.println(0);
            if(dist<radius.radius)System.out.println(1);
            if(dist>radius.radius)System.out.println(2);
        }
    }
    public static double distance(float x1, float y1, float x2, float y2)
    {
        x1 -= x2;
        y1 -= y2;
        return Math.sqrt(x1 * x1 + y1 * y1);
    }
}

