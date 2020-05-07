package bsu.by.zbokostya.entity;

import java.util.Objects;

public class Ticket {
    private Flight flight;
    private Plane plane;
    private int seat;
    private int cost;
    private int id;

    public Ticket() {
    }

    public Ticket(Flight flight, Plane plane, int seat, int cost) {
        this.flight = flight;
        this.plane = plane;
        this.seat = seat;
        this.cost = cost;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return seat == ticket.seat &&
                Double.compare(ticket.cost, cost) == 0 &&
                id == ticket.id &&
                Objects.equals(flight, ticket.flight) &&
                Objects.equals(plane, ticket.plane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flight, plane, seat, cost, id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ticket{");
        sb.append("flight=").append(flight);
        sb.append(", plane=").append(plane);
        sb.append(", seat=").append(seat);
        sb.append(", cost=").append(cost);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
