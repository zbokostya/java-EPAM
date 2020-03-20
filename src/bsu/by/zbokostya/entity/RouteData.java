package bsu.by.zbokostya.entity;

import java.util.Objects;

public class RouteData {
    private String destination;
    private long data;
    private int id;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RouteData{");
        sb.append("destination='").append(destination).append('\'');
        sb.append(", data=").append(data);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteData routeData = (RouteData) o;
        return data == routeData.data &&
                id == routeData.id &&
                Objects.equals(destination, routeData.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, data, id);
    }
}
