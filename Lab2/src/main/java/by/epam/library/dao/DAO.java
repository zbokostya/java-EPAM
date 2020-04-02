package by.epam.library.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;

public abstract class DAO<T> {
    private final static Logger logger = LogManager.getLogger();
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private ArrayList<T> data;

    public DAO() {
        this.data = new ArrayList<>();
    }

    public ArrayList<T> getData() {
        return data;
    }

    public void write() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(getPath()));
            outputStream.writeObject(data);
            logger.info(data.size() + " objects recorded.");
            outputStream.close();
        } catch (IOException e) {
            logger.error(e);
        }
    }

    public ArrayList<T> read() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(getPath()));
            data = (ArrayList<T>) inputStream.readObject();
            logger.info(data.size() + " objects read.");
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            logger.error(e);
        }
        return data;
    }

    public void add(T item) {
        if (data.add(item))
            logger.info("Object added successfully.");
        else
            logger.warn("Object is not added.");
    }

    public void remove(T entity) {
        if (data.remove(entity))
            logger.info("Object removed successfully.");
        else
            logger.warn("Cannot remove object.");
    }

    public void update(T entity) {
        data.forEach(i -> {
            if (i.hashCode() == entity.hashCode()) {
                i = entity;
                logger.info("Object updated successfully.");
            }
        });
    }

    public abstract String getPath();
}