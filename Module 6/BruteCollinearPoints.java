//Write a program BruteCollinearPoints.java that examines 4 points at a time and checks whether they all lie on the same line segment, returning all such line segments. To check whether 
//the 4 points p, q, r, and s are collinear, check whether the three slopes between p and q, between p and r, and between p and s are all equal.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {

    private final List<LineSegment> segments = new ArrayList<>();

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points){
        if (points == null) {
            throw new IllegalArgumentException("The argument to the constructor is null");
        }
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException("The array contains a null element");
            }
        }
        Point[] copy = Arrays.copyOf(points, points.length);
        Arrays.sort(copy);
        for (int i = 0; i < copy.length - 1; i++) {
            if (copy[i].compareTo(copy[i + 1]) == 0) {
                throw new IllegalArgumentException("The array contains a repeated point");
            }
        }
        int n = copy.length;
        for (int i = 0; i < n; i++) {
            Point p = copy[i];
            for (int j = i + 1; j < n; j++) {
                Point q = copy[j];
                for (int k = j + 1; k < n; k++) {
                    Point r = copy[k];
                    for (int l = k + 1; l < n; l++) {
                        Point s = copy[l];
                        if (p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(q) == p.slopeTo(s)) {
                            segments.add(new LineSegment(p, s));
                        }
                    }
                }
            }
        }
    }

    // the number of line segments
    public int numberOfSegments(){
        return segments.size();
    }

    // the line segments
    public LineSegment[] segments(){
        return segments.toArray(new LineSegment[segments.size()]);
    }
 }