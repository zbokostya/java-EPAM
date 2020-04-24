package bsu.by.zbokostya.entity;

import java.io.*;
import java.util.Objects;

public class Plane {
    private int id;
    private String name;
    private int seats;
    private String serialNumber;
    private int companyId;

    public Plane() {
    }

    public Plane(int id, String name, int seats, String serialNumber, int companyId) {
        this.id = id;
        this.name = name;
        this.seats = seats;
        this.serialNumber = serialNumber;
        this.companyId = companyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return id == plane.id &&
                seats == plane.seats &&
                companyId == plane.companyId &&
                Objects.equals(name, plane.name) &&
                Objects.equals(serialNumber, plane.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, seats, serialNumber, companyId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Plane{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", seats=").append(seats);
        sb.append(", serialNumber='").append(serialNumber).append('\'');
        sb.append(", companyId=").append(companyId);
        sb.append('}');
        return sb.toString();
    }
}
