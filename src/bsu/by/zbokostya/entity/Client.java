package bsu.by.zbokostya.entity;

import java.util.ArrayList;
import java.util.Objects;

public class Client extends User {
    private int id;
    private String name;
    private ArrayList<Ticket> tickets;
    private String passwordHash;

    public Client(int id, String name, ArrayList<Ticket> tickets, String passwordHash) {
        this.id = id;
        this.name = name;
        this.tickets = tickets;
        this.passwordHash = passwordHash;
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

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(name, client.name) &&
                Objects.equals(tickets, client.tickets) &&
                Objects.equals(passwordHash, client.passwordHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, tickets, passwordHash);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", tickets=").append(tickets);
        sb.append(", passwordHash='").append(passwordHash).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
