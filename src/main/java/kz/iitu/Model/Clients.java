package kz.iitu.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clients")
public class Clients implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nickname", length = 1000, nullable = false)
    private String nick;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

//
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "clients_roles",
//            joinColumns=@JoinColumn (
//                    name = "client_id",referencedColumnName = "id"),
//            inverseJoinColumns =@JoinColumn(
//                    name = "roles_id",referencedColumnName = "id")
//    )
//        Set<Role> projects = new HashSet<>();
//    private Collection<Role> roles;

//    public Collection<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Collection<Role> roles) {
//        this.roles = roles;
//    }

    //
    @Column(name = "is_admin", nullable = false, columnDefinition = "boolean default false")
    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Clients(String nick, String login, String password, boolean isAdmin) {
        this.nick = nick;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public Clients(String nick, String login, String password) {
        this.nick = nick;
        this.login = login;
        this.password = password;
    }
    public Clients(){}
}
