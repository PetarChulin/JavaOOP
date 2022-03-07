package PolymorphismLabP02Shapes;

public abstract class Shape {

    private Double perimeter;
    private Double area;


    public Double getPerimeter() {
        return perimeter;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    protected Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public abstract double calculatePerimeter();

    public abstract double calculateArea();

}
