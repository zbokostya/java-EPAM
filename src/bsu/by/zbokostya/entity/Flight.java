package bsu.by.zbokostya.entity;

import java.util.Objects;

public class Flight {
    private Plane plane;
    private Route route;
    private int id;

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Flight{");
        sb.append("plane=").append(plane);
        sb.append(", route=").append(route);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id &&
                Objects.equals(plane, flight.plane) &&
                Objects.equals(route, flight.route);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plane, route, id);
    }
}
