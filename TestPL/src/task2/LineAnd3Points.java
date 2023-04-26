package task2;

public class LineAnd3Points {

    public static void main(String[] args) {
        Point point1 = new Point(3.0,1.0);
        Point point2 = new Point(4.0,2.0);
        Point point3 = new Point(3.5,1.5);

        if((point1.x - point2.x)*(point1.y-point3.y)==(point1.x-point3.x)*(point1.y-point2.y)){
            System.out.println("on the one line");
        }else {
            System.out.println("no on the line");
        }

    }


}
