package Painter;

import Shapes.MyPolygon;
import Shapes.MyShape;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Vector;

public class MyPolygonPainter extends MyPainter {
    private MyPolygon drawingShape = null;

    @Override
    public MyShape mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            // 左键
            points.add(e.getPoint());
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            // 右键
            drawingShape = new MyPolygon();
            drawingShape.setPoints(points);
            drawingShape.init();
            points.clear();
        }
        return drawingShape;
        /*
         *多边形画法:
         *左键先点一堆点,最后点击右键完成绘制.
         */
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public MyShape mouseDragged(MouseEvent e) {
        return null;
    }
}
