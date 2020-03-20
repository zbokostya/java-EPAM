package bsu.by.zbokostya.entity;

import java.io.Serializable;

public class Admin extends User implements Serializable {
    public Admin() {
        super();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Admin{");
        sb.append("login='").append(login).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
