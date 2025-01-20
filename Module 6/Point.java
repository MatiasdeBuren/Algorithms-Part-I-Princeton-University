import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;

//The compareTo() method should compare points by their y-coordinates, breaking ties by their x-coordinates. Formally, the invoking point (x0, y0) is less than the argument point 
//(x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.

//The slopeTo() method should return the slope between the invoking point (x0, y0) and the argument point (x1, y1), which is given by the formula (y1 − y0) / (x1 − x0). Treat the slope 
//of a horizontal line segment as positive zero; treat the slope of a vertical line segment as positive infinity; treat the slope of a degenerate line segment (between a point and itself) 
//as negative infinity.

//The slopeOrder() method should return a comparator that compares its two argument points by the slopes they make with the invoking point (x0, y0). Formally, the point (x1, y1) is less 
//than the point (x2, y2) if and only if the slope (y1 − y0) / (x1 − x0) is less than the slope (y2 − y0) / (x2 − x0). Treat horizontal, vertical, and degenerate line segments as in the 
//slopeTo() method.


public class Point implements Comparable<Point> {
    
    private final int x;
    private final int y;

    // constructs the point (x, y)
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    // draws this point
    public void draw() {
        StdDraw.point(x, y);
    }

    // draws the line segment between this point and that point
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // string representation
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // compare two points by y-coordinates, breaking ties by x-coordinates
    public int compareTo(Point that){
        if (this.y < that.y) return -1;
        if (this.y > that.y) return 1;
        if (this.x < that.x) return -1;
        if (this.x > that.x) return 1;
        return 0;
    }

    // the slope between this point and that point
    public double slopeTo(Point that){
        if (this.x == that.x && this.y == that.y) return Double.NEGATIVE_INFINITY;
        if (this.y == that.y) return 0.0;
        if (this.x == that.x) return Double.POSITIVE_INFINITY;
        return (double) (that.y - this.y) / (that.x - this.x);
    }

    // compare two points by slopes they make with this point
    public Comparator<Point> slopeOrder(){
        return new SlopeOrder();
    }
    
    private class SlopeOrder implements Comparator<Point> {
        public int compare(Point p1, Point p2){
            double slope1 = slopeTo(p1);
            double slope2 = slopeTo(p2);
            if (slope1 < slope2) return -1;
            if (slope1 > slope2) return 1;
            return 0;
        }
    }

    // unit test
    public static void main(String[] args){
        Point p = new Point(1, 2);
        Point q = new Point(3, 4);
        Point r = new Point(5, 6);
        Point s = new Point(7, 8);
        Point t = new Point(9, 10);
        System.out.println(p.slopeTo(q)); // 1.0
        System.out.println(p.slopeTo(r)); // 1.0
        System.out.println(p.slopeTo(s)); // 1.0
        System.out.println(p.slopeTo(t)); // 1.0
        System.out.println(p.slopeOrder().compare(q, r)); // 0
        System.out.println(p.slopeOrder().compare(q, s)); // 0
        System.out.println(p.slopeOrder().compare(q, t)); // 0
        System.out.println(p.slopeOrder().compare(r, s)); // 0
        System.out.println(p.slopeOrder().compare(r, t)); // 0
        System.out.println(p.slopeOrder().compare(s, t)); // 0
    }

}