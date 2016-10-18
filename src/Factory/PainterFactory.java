package Factory;

import Painter.MyPainter;

public class PainterFactory {
    public static MyPainter createPainterInstance(String painterName) {
        MyPainter painter = null;

        try {
            painter = (MyPainter) Class.forName(painterName).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return painter;
    }
}
