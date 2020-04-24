package bsu.by.zbokostya.entity;

import java.util.Objects;

public class Route {
    private int id;
    private String cityOut;
    private String cityIn;

    public Route() {
    }

    public Route(String cityOut, String cityIn) {
        this.cityOut = cityOut;
        this.cityIn = cityIn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityOut() {
        return cityOut;
    }

    public void setCityOut(String cityOut) {
        this.cityOut = cityOut;
    }

    public String getCityIn() {
        return cityIn;
    }

    public void setCityIn(String cityIn) {
        this.cityIn = cityIn;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Route{");
        sb.append("id=").append(id);
        sb.append(", cityOut='").append(cityOut).append('\'');
        sb.append(", cityIn='").append(cityIn).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return id == route.id &&
                Objects.equals(cityOut, route.cityOut) &&
                Objects.equals(cityIn, route.cityIn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityOut, cityIn);
    }
}
