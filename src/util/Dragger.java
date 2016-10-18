package util;

import Shapes.MyShape;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Vector;

public class Dragger {
    public static void drag(MouseEvent e, Vector<Point2D> points, MyShape drawingShape) {
    	/*
    	 *e 鼠标拖动的每时每刻都在生成MouseEvent对象
    	 *points points来自MyPainter类,储存鼠标拖动的轨迹上的点.将其传递给MyShape的子类的
    	 * 		 setPoints()设置决定MyShape特征的那些点
    	 */
        points.add(e.getPoint());
        drawingShape.setPoints(points);
        drawingShape.init();
        points.remove(1);
        /*
         *鼠标按下去触发mousePressed,这个按击点被添加到points中;之后开始拖动,每拖动一个像素
         *的距离就触发mouseDragged,触发点被添加到points中,所以points.remove(1)将删除它,留在
         *points里的只有一个元素,即最先被添加到里面的按击点.也即,points里的第二个元素一直处
         *在更新状态,执行remove(1)之前,points里只有两个点元素:点1是首次按击的位置,点2是当前
         *鼠标拖动到的位置,除多边形外,这两个点唯一确定一个几何图形.
         */
    }
}
