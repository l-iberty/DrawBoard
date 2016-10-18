package Shapes;

import util.Mover;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.Vector;

public class MyRectangle extends MyShape implements Serializable {
    private Rectangle2D rectangle2D = new Rectangle2D.Double();
    private Point2D[] points = new Point2D[2];

    @Override
    public String getButtonName() {
        return "Rectangle";
    }

    @Override
    public String getClassName() {
        return "MyRectangle";
    }

    @Override
    public void init() {
        rectangle2D.setFrameFromDiagonal(points[0], points[1]);
        /*
         *setFrameFromDiagonal()是Rectangle2D的超类RectangularShape的公有方法,
         *注释文档云:
         * Sets the diagonal of the framing rectangle of this <code>Shape</code>
         * based on two specified <code>Point2D</code> objects.  The framing
         * rectangle is used by the subclasses of <code>RectangularShape</code>
         * to define their geometry.
         */
    }

    public double getWidth() {
        return rectangle2D.getWidth();
    }

    public double getHeight() {
        return rectangle2D.getHeight();
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
        graphics2D.draw(rectangle2D);
    }

    @Override
    public boolean contains(Point2D p) {
        return rectangle2D.contains(p);
        //判断点是否在rectangle内
    }

    @Override
    public void move(Point2D p1, Point2D p2) {
        Mover.move(p1, p2, points);
        init();
    }
}
