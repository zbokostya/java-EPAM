package bsu.by.zbokostya.DAO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ByteWriter {
    private ObjectOutputStream objectOutputStream;

    public ByteWriter(String filename){
        try {
            objectOutputStream =  new ObjectOutputStream(new FileOutputStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(Object object){
        try {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
