package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import Factory.ButtonFactory;
import Factory.ShapeFactory;
import SaveRead.*;

public class DrawFrame extends JFrame implements ActionListener {
    private DrawComponent drawComponent;
    private static final int DEFAULT_WIDTH = 1200;
    private static final int DEFAULT_HEIGHT = 700;
    private ArrayList<String> classNamesOfShapes = ButtonFactory.getClassNamesOfShapes();
    // classNamesOfShapes存储的字符串是Shapes里的类名: MyLine...

    public DrawFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        drawComponent = new DrawComponent();
        JPanel buttonPanel = new JPanel();

        for (String className : classNamesOfShapes) {
            String graphClassName = "Shapes." + className;
            //addButton(buttonPanel, ShapeFactory.createShapeInstance(graphClassName).getButtonName(),
            //	e -> drawComponent.setClassName(className));
            buttonPanel.add(getButton(ShapeFactory.createShapeInstance(graphClassName).getButtonName()));
        }

        buttonPanel.add(getButton("Save"));
        /*addButton(buttonPanel, "Save", e -> {
            try {
                SaveRead.Save(drawComponent.getShapes());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });*/
        buttonPanel.add(getButton("Clear"));
        //addButton(buttonPanel, "Clear", e -> drawComponent.clear());

        add(buttonPanel, BorderLayout.NORTH);
        add(drawComponent, BorderLayout.CENTER);
        pack();
    }

    private JButton getButton(String title) {
        JButton button = new JButton(title);
        button.addActionListener(this);

        return button;
    }

    public void actionPerformed(ActionEvent evt) {
        JButton src = (JButton) evt.getSource();

        if (src.getText().equals("Save")) {
            try {
                SaveRead.Save(drawComponent.getShapes());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else if (src.getText().equals("Clear")) {
            drawComponent.clear();
        }
        else {
            drawComponent.setPainter("My" + src.getText());
        }
    }
}
