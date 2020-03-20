package bsu.by.zbokostya.entity;

import java.util.Objects;

public class Ticket {
    private Flight flight;
    private double cost;
    private int id;

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ticket{");
        sb.append("flight=").append(flight);
        sb.append(", cost=").append(cost);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Double.compare(ticket.cost, cost) == 0 &&
                id == ticket.id &&
                Objects.equals(flight, ticket.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flight, cost, id);
    }
}
