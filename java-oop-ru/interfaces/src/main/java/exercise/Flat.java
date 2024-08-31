package exercise;

// BEGIN
public class Flat implements Home {
    private Double area;
    private Double balconyArea;
    private Integer floor;

    public Flat() {
    }

    public Flat(Double area, Double balconyArea, Integer floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public Double getArea() {
        double result = area + balconyArea;
        return result;
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
    public String toString() {
        return "Квартира площадью " + this.getArea() + " метров на " + this.floor + " этаже";
    }
}
// END
