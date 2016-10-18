package Painter;

import Shapes.MyLine;
import Shapes.MyShape;
import util.Dragger;

import java.awt.event.MouseEvent;

public class MyLinePainter extends MyPainter {
    private MyLine drawingShape;

    @Override
    public MyShape mousePressed(MouseEvent e) {
        points.add(e.getPoint());
        drawingShape = new MyLine();
        return drawingShape;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        points.clear();
        // 鼠标释放以后清空points
    }

    @Override
    public MyShape mouseDragged(MouseEvent e) {
        Dragger.drag(e, points, drawingShape);
        return drawingShape;
    }
}
