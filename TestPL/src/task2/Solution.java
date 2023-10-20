package task2;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        polygon.add(new Point(2.0, 2.0));
        polygon.add(new Point(1.0, 5.0));
        polygon.add(new Point(6.5, 5.5));
        polygon.add(new Point(6.0, 2.5));


        System.out.println(isPointInPolygon(new Point(6.0, 2.5), polygon));
        //System.out.println(isPointInPolygon(new Point(3.5, 2.5), polygon));
    }

    public static boolean isPointInPolygon(Point point, List<Point> polygon) {
        //напишите тут ваш код
        int intersect_count = 0;
        int size = polygon.size()-1;
        for (int i = 0; i < polygon.size(); i++) {
            Point p1 = polygon.get(i > 0 ? i - 1 : size);
            Point p2 = polygon.get(i);

            if (isIntersect(point.x, point.y, p1, p2)) intersect_count++;
        }

        return intersect_count % 2 == 1;
    }

    private static boolean isIntersect(double x, double y, Point p1, Point p2) {
        double dy1 = p1.y - y;
        double dy2 = p2.y - y;

        if (Math.signum(dy1) == Math.signum(dy2)) return false;
    //  if((dy1==0&&dy2==0)||(dy1<0&&dy2<0)||(dy1>0&&dy2>0)){
    //      return false;
    //  }


        double dx1 = p1.x - x;
        double dx2 = p2.x - x;

        if (dx1 >= 0 && dx2 >= 0) return true;
        if (dx1 < 0 && dx2 < 0) return false;

        double dx0 = dy1 * (p1.x - p2.x) / (p1.y - p2.y);

        return dx0 <= dx1;
    }

}
