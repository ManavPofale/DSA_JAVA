import java.util.Random;

class Solution {
    private double radius;
    private double x_center;
    private double y_center;
    private Random random;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.random = new Random();
    }
    public double[] randPoint() {
        while(true){
            double x = (random.nextDouble() * 2 - 1) * radius;
            double y = (random.nextDouble() * 2 - 1) * radius;
            if(x * x + y * y <= radius * radius){
                return new double[]{x_center + x, y_center + y};
            }
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */