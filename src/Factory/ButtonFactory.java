package Factory;

import java.io.File;
import java.util.ArrayList;

public class ButtonFactory {
    //getClassNamesOfShapes()和类名BUttonFactory有关系吗
    public static ArrayList<String> getClassNamesOfShapes() {
        ArrayList<String> classNames = new ArrayList<>();
        File dir = new File("C:\\Users\\len\\Desktop\\Program\\IntelliJ Projects\\src\\Shapes");
        File[] files = dir.listFiles();

        for (File file : files) {
        	String filename = file.getName();
        	if (!filename.equals("MyShape.java") && !filename.equals(".DS_Store"))
        		classNames.add(filename.substring(0, filename.length() - 5));
        }

        return classNames;
    }
}
