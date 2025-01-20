
//The method segments() should include each maximal line segment containing 4 (or more) points exactly once. For example, if 5 points appear on a line segment in the order p→q→r→s→t, 
//then do not include the subsegments p→s or q→t.

import java.util.ArrayList;
import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {
    private ArrayList<LineSegment> segments = new ArrayList<>();
    private Point[] aux; // Auxiliary array for merge sort

    // Merge function for sorting Points based on slopes relative to 'p'
    private void merge(Point[] a, Point p, int lo, int mid, int hi) {
        System.arraycopy(a, lo, aux, lo, hi - lo + 1);
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (p.slopeTo(aux[j]) < p.slopeTo(aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    // Sort function for Points based on slopes relative to 'p'
    private void sort(Point[] a, Point p, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, p, lo, mid);
        sort(a, p, mid + 1, hi);
        merge(a, p, lo, mid, hi);
    }

    private void sort(Point[] a, Point p) {
        aux = new Point[a.length];
        sort(a, p, 0, a.length - 1);
    }

    // Finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException("The argument to the constructor is null");
        for (Point p : points) if (p == null) throw new IllegalArgumentException("The array contains a null element");

        // Check for duplicate points
        Point[] sortedPoints = Arrays.copyOf(points, points.length);
        Arrays.sort(sortedPoints);
        for (int i = 0; i < sortedPoints.length - 1; i++) {
            if (sortedPoints[i].compareTo(sortedPoints[i + 1]) == 0) {
                throw new IllegalArgumentException("The array contains a repeated point");
            }
        }

        for (Point p : points) {
            Point[] sortedBySlope = Arrays.copyOf(points, points.length);
            sort(sortedBySlope, p); // Sort points by slopes relative to 'p'

            int count = 1;
            Point min = p; // Keep track of the smallest point
            ArrayList<Point> collinear = new ArrayList<>();
            collinear.add(p);

            for (int i = 1; i < sortedBySlope.length; i++) {
                if (p.slopeTo(sortedBySlope[i]) == p.slopeTo(sortedBySlope[i - 1])) {
                    count++;
                    collinear.add(sortedBySlope[i]);
                    if (sortedBySlope[i].compareTo(min) < 0) {
                        min = sortedBySlope[i]; // Track smallest point in the group
                    }
                } else {
                    if (count >= 3 && min == p) { // Add segment only if 'p' is the smallest
                        segments.add(new LineSegment(p, collinear.get(collinear.size() - 1)));
                    }
                    count = 1;
                    collinear.clear();
                    collinear.add(p);
                    collinear.add(sortedBySlope[i]);
                    min = p;
                }
            }

            if (count >= 3 && min == p) { // Check last set of collinear points
                segments.add(new LineSegment(p, collinear.get(collinear.size() - 1)));
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

    public static void main(String[] args) {
         // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}