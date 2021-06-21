public class Vector2 {
    
    public double x;
    public double y;
    // public final double x = x1;
    // public final double y = y1;
    
    public Vector2(double newX, double newY) {
        x = newX;
        y = newY;
    }

    public static void main(String[] args) {
        Vector2 v1 = new Vector2(20.01, 20.01);
        System.out.println(v1);

        Vector2 v2 = new Vector2(10.1, 30.1);
        Vector2 v3 = v1.plus(v2);
        System.out.println(v3);
        Vector2 v4 = v1.minus(v2);
        System.out.println(v4);
        double v5 = v1.dot(v2);
        System.out.println(v5);

    }

    public String toString() {
        // to overload the print fn
        return String.format("(%.2f,%.2f)",x,y);
    }

    public Vector2 plus(Vector2 v2) {
        double finalX = x + v2.x;
        double finalY = y + v2.y;
        return new Vector2(finalX, finalY);
    }

    public Vector2 minus(Vector2 v2) {
        double finalX = x - v2.x;
        double finalY = y - v2.y;
        return new Vector2(finalX, finalY);
    }
    
    public double dot(Vector2 v2) {
        double finalX = x * v2.x;
        double finalY = y * v2.y;
        return finalX + finalY;
    }


}