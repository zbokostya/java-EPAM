package bsu.by.zbokostya.DAO;

import java.io.*;

public class ByteReader {
    private ObjectInputStream objectInputStream;

    public ByteReader(String filename){
        try {
            objectInputStream =  new ObjectInputStream(new FileInputStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object read(){
        Object object = null;
        try {
            object = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

    public int available() throws IOException {
        return objectInputStream.available();
    }

    public void close(){
        try {
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
