package Shapes;

import util.Mover;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;
import java.util.Vector;

public class MyEllipse extends MyShape implements Serializable {
    private Ellipse2D ellipse2D = new Ellipse2D.Double();
    private Point2D[] points = new Point2D[2];

    @Override
    public String getButtonName() {
        return "Ellipse";
    }

    @Override
    public String getClassName() {
        return "MyEllipse";
    }

    @Override
    public void init() {
        ellipse2D.setFrameFromDiagonal(points[0], points[1]);
    }

    public double getWidth() {
        return ellipse2D.getWidth();
    }

    public double getHeight() {
        return ellipse2D.getHeight();
    }

    @Override
    public void setPoints(Vector<Point2D> p) {
        p.toArray(points);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(pen);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.draw(ellipse2D);
    }

    @Override
    public boolean contains(Point2D p) {
        return ellipse2D.contains(p);
    }

    @Override
    public void move(Point2D p1, Point2D p2) {
        Mover.move(p1, p2, points);
        init();
    }
}
