package task2;

public class Coord {
    float x;
    float y;
    float radius;

    public Coord(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Coord(String x, String y){
        this(Float.parseFloat(x),Float.parseFloat(y));
    }
    public Coord(String radius){
        this.radius = Float.parseFloat(radius);
    }
    public Coord(){}

}
