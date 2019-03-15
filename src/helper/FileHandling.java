package helper;
import app.ToDoList;
import java.io.*;
public  class FileHandling {

        public static void saveFile(ToDoList t){
            try {
                FileOutputStream fos = new FileOutputStream("data");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(t);
                oos.close();
            }
            catch(Exception e){
                System.out.println("Please try again :");
            }
        }

        public static Object openFile() throws FileNotFoundException
        {
            File f = new File("data");
            Object objectFromFile = null;
            if (f.exists())
            {
                try {
                    FileInputStream fis = new FileInputStream("data");
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    objectFromFile = ois.readObject();
                    ois.close();
                    return objectFromFile;

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return objectFromFile;
            }
            else throw  new FileNotFoundException();
        }
    }

