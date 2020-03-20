package bsu.by.zbokostya.entity;

import java.io.*;
import java.util.Objects;

public class Plane implements Serializable {
    private String name;
    private int seats;
    private int id;

    public Plane(String name, int seats, int id){
        this.name = name;
        this.seats = seats;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Plane{");
        sb.append("name='").append(name).append('\'');
        sb.append(", seats=").append(seats);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return seats == plane.seats &&
                id == plane.id &&
                Objects.equals(name, plane.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, seats, id);
    }
}
