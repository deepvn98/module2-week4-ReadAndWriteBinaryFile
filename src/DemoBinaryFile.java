import java.io.*;
import java.util.ArrayList;

public class DemoBinaryFile {
    public static void main(String[] args) {
        ArrayList<Integer> list = demoInputStream("java.txt");
        list.add(0);

//        list.remove(0);
        System.out.println(list);
        demoOutputStream(list);

    }
    public static void demoOutputStream(ArrayList<Integer> list){
        FileOutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            outputStream = new FileOutputStream("java.txt");
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    public static ArrayList<Integer> demoInputStream(String source){
        File file = new File(source);
        FileInputStream fileInputStream = null;
        ArrayList<Integer> data = new ArrayList<>();
        ObjectInputStream objectInputStream = null;
        try {
            if (file.length()>0){
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                data =(ArrayList<Integer>)objectInputStream.readObject();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(objectInputStream!=null){
                    objectInputStream.close();
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }catch (NullPointerException e){
                e.printStackTrace();
            }

        }return data;

    }
}
