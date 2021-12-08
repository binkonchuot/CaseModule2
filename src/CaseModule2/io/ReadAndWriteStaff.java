package CaseModule2.io;

import CaseModule2.model.Staff;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteStaff {
    public static List<Staff> readStaff()  {
        try {
            File file = new File("staff.txt");
            if (!file.isFile()){
                file.createNewFile();
            }

            FileInputStream fileInputStream = new FileInputStream("staff.txt");
            if (fileInputStream.available() != 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                return (List<Staff>) objectInputStream.readObject();
            }
            return new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void writeStaff(List<Staff> staffs) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("staff.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(staffs);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
