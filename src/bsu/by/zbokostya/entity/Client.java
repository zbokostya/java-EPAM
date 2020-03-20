package bsu.by.zbokostya.entity;

import java.util.ArrayList;
import java.util.Objects;

public class Client extends User {
    private String name;
    private int flownHours;
    private double discount;
    private ArrayList<Ticket> tickets;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlownHours() {
        return flownHours;
    }

    public void setFlownHours(int flownHours) {
        this.flownHours = flownHours;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("name='").append(name).append('\'');
        sb.append(", flownHours=").append(flownHours);
        sb.append(", discount=").append(discount);
        sb.append(", tickets=").append(tickets);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return flownHours == client.flownHours &&
                Double.compare(client.discount, discount) == 0 &&
                id == client.id &&
                Objects.equals(name, client.name) &&
                Objects.equals(tickets, client.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, flownHours, discount, tickets, id);
    }
}
