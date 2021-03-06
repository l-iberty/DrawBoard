package Painter;

import Shapes.MyEllipse;
import Shapes.MyShape;
import util.Dragger;

import java.awt.event.MouseEvent;

public class MyEllipsePainter extends MyPainter {
    private MyEllipse drawingShape;

    @Override
    public MyShape mousePressed(MouseEvent e) {
        points.add(e.getPoint());
        drawingShape = new MyRectangle();
        return drawingShape;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        points.clear();
    }

    @Override
    public MyShape mouseDragged(MouseEvent e) {
        Dragger.drag(e, points, drawingShape);
        return drawingShape;
    }
}