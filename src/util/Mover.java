package util;

import java.awt.geom.Point2D;

public class Mover {
    public static void move(Point2D p1, Point2D p2, Point2D[] points) {
    	/*
    	 *该移动方法的处理对象是除多边形外的图形,多边形有自己的移动方法.
    	 */

    	//移动时鼠标从p1->p2; points储存图形的特征点
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        //设置新的特征点
        Point2D newPoint1 = new Point2D.Double(points[0].getX() + dx, points[0].getY() + dy);
        Point2D newPoint2 = new Point2D.Double(points[1].getX() + dx, points[1].getY() + dy);
        //更新原来的特征点
        points[0].setLocation(newPoint1);
        points[1].setLocation(newPoint2);
    }
}
