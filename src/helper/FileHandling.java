package helper;
import app.ToDoList;
import model.Task;

import java.io.*;
import java.util.ArrayList;

public  class FileHandling {

        public static void saveFile(ToDoList t){
            try {
                FileOutputStream fos = new FileOutputStream("data");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(t.getTaskList());
                oos.close();
            }
            catch(Exception e){
                System.out.println("Please try again :");
            }
        }


        public static ArrayList<Task> openFile()
        {
            File f = new File("data");
            ArrayList<Task> objectFromFile = new ArrayList<>();

            try {
                FileInputStream fis = new FileInputStream("data");
                ObjectInputStream ois = new ObjectInputStream(fis);

                objectFromFile =  (ArrayList<Task>) ois.readObject();
                ois.close();

            }
            catch (EOFException e)
            {
                System.out.println("the file is empty");
            } catch (IOException e) {
                System.out.println("file data is not exist ");
            } catch (ClassNotFoundException e) {
                System.out.println("file data is not exist ");
            }

            return objectFromFile;
        }


        public static Object openFile2() throws FileNotFoundException
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

                } catch (EOFException e)
                {
                    System.out.println("the file is empty");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return objectFromFile;
            }
            else throw  new FileNotFoundException();
        }
    }

