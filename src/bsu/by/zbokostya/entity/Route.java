package bsu.by.zbokostya.entity;

import java.util.ArrayList;
import java.util.Objects;

public class Route {
    private ArrayList<RouteData> route;
    private int id;

    public ArrayList<RouteData> getRoute() {
        return route;
    }

    public void setRoute(ArrayList<RouteData> route) {
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
        final StringBuilder sb = new StringBuilder("Route{");
        sb.append("route=").append(route);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route1 = (Route) o;
        return id == route1.id &&
                Objects.equals(route, route1.route);
    }

    @Override
    public int hashCode() {
        return Objects.hash(route, id);
    }
}
