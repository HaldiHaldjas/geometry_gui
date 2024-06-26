public class Sphere {
    private double radius;
    
    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double calculateSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}
