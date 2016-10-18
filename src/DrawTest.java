import javax.swing.*;
import java.awt.*;

import Frame.DrawFrame;

public class DrawTest {
    public static void main(String args[]) {
        /*
         *创建匿名内部类,该类实现接口Runnable.
         */
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DrawFrame drawFrame = new DrawFrame();
                /*
                 *原来的代码中使用了向上转型：
                 * JFrame frame = new DrawFrame();
                 *对象既可作为它本身的类型使用,也可作为它的基类的类型使用.
                 *把这种将某个对象的引用视为其基类类型的引用的做法称为[向上转型].
                 *引用变量frame的类型是JFrame,但实际调用方法时仍从子类开始
                 *检索;而访问成员变量时从父类检索.
                 */
                /*
                 *向上转型的实际意义只体现在函数调用时涉及参数传递和返回值时,
                 *原来的代码中此处使用的向上转型没有任何意义.
                 */
                drawFrame.setTitle("DrawBoard");
                drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                drawFrame.setVisible(true);
            }
        });
        /*
         *SwingUtilities.invokeLater()会调转调用EventQueue.invokeLater().
         *通过将Swing事件添加到事件队列中来避免冲突.这种冲突来自于其他线程
         *试图对Swing进行操作时发生,但前提是其他代码都通过向事件队列提交操
         *作.此处若将这些代码放到main()里面也可以,因为只有一个线程——main,
         *不会发生冲突,这么写的主要目的还是在于提高代码的健壮性.
         */
    }
}