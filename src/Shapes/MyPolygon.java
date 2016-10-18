package Shapes;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.Vector;

public class MyPolygon extends MyShape implements Serializable{
    private Vector<Point2D> points;//储存多边形的顶点
    private Polygon polygon;

    @Override
    public String getButtonName() {
        return "Polygon";
    }

    @Override
    public String getClassName() {
        return "MyPolygon";
    }

    public int getNumberOfPoints() {
        return points.size();
    }

    @Override
    public void setPoints(Vector<Point2D> p) {
        points = new Vector<>(p);
        // 调用Vector(Collection<? extends E> c)构造函数
    }

    @Override
    public boolean contains(Point2D p) {
        return polygon.contains(p);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(pen);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawPolygon(polygon);
    }

    @Override
    public void move(Point2D p1, Point2D p2) {
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        for (Point2D p : points) {
            Point2D point = new Point2D.Double(p.getX() + dx, p.getY() + dy);
            p.setLocation(point);
            // points存储了多边形的所有顶点,通过对每个顶点调用setLocation()更新其位置
        }
        init();
    }

    @Override
    public void init() {
        int n = points.size();
        int x[] = new int[n];
        int y[] = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = (int) points.get(i).getX();
            y[i] = (int) points.get(i).getY();
        }
        polygon = new Polygon(x, y, n);
    }
}
