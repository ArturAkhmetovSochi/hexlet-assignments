package exercise;

// BEGIN
public class Segment {
    private Point beginPoint;
    private Point endPoint;

    public Segment() {
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        Integer middleX = (beginPoint.getX() + endPoint.getX()) / 2;
        Integer middleY = (beginPoint.getY() + endPoint.getY()) / 2;
        Point middlePoint = new Point(middleX, middleY);

        return middlePoint;

    }

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

}
// END
