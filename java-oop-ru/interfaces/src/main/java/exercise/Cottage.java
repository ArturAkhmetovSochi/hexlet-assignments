package exercise;

// BEGIN
public class Cottage implements Home {
    private Double area;
    private Integer floorCount;

    public Cottage() {
    }

    public Cottage(Double area, Integer floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public Byte compareTo(Home home) {
        if (this.getArea() > home.getArea()) {
            return 1;
        } else if (this.getArea() < home.getArea()) {
            return -1;
        }
        return 0;
    }

    @Override
    public Double getArea() {
        return area;
    }
    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }

}
// END
