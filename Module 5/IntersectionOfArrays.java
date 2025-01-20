import java.util.HashSet;
import java.util.Objects;

public class IntersectionOfArrays {
    //Intersection of two sets. Given two arrays a[][] and b[][], each containing n distinct 2D points in the plane, design a subquadratic algorithm to count the number of points that 
    //are contained both in array a[][] and b[][].

    public static void main(String[] args) {
        int[][] a = {{1, 3}, {2, 7}, {3, 4}, {2, 5}, {2, 1}};
        int[][] b = {{1, 2}, {7, 2}, {3, 4}, {2, 5}, {5, 1}};
        Intersection intersection = new Intersection(a, b);
        System.out.println(intersection.count());
        
    }

    public static class Intersection {

        private int[][] a;
        private int[][] b;

        public Intersection(int[][] a, int[][] b) {
            this.a = a;
            this.b = b;
        }

        private static class Point {
            int x, y;

            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            // Override equals and hashCode for proper hashing and comparison
            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                Point point = (Point) obj;
                return x == point.x && y == point.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }

        public int count() {
            HashSet<Point> set = new HashSet<>();
            int count = 0;

            for (int[] point : a) {
                set.add(new Point(point[0], point[1]));
            }

            for (int[] point : b) {
                if (set.contains(new Point(point[0], point[1]))) {
                    count++;
                }
            }

            return count;
        }
    }
}