package SaveRead;

import Shapes.MyShape;

import java.io.*;
import java.util.ArrayList;

public class SaveRead {
    public static void Save(ArrayList<MyShape> a) throws IOException {
        FileOutputStream file = new FileOutputStream("ShapeList");
        ObjectOutputStream outObj = new ObjectOutputStream(file);

        outObj.writeObject(a);
        outObj.close();
    }

    public static ArrayList<MyShape> Read() throws IOException, ClassNotFoundException {
        ArrayList<MyShape> shapes;
        FileInputStream file = new FileInputStream("ShapeList");
        ObjectInputStream inObj = new ObjectInputStream(file);
        
        shapes = (ArrayList<MyShape>) inObj.readObject();
        inObj.close();
        return shapes;
    }
}
