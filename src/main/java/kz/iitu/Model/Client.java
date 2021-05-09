package kz.iitu.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nickname", length = 1000, nullable = false)
    private String nick;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "clients_movies",
            joinColumns = @JoinColumn(
                    name = "client_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "movie_id",referencedColumnName = "id"))
    private Collection<Movie> movies;

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

    public Collection<Movie> getRoles() {
        return movies;
    }
    public void setRoles(Collection<Movie> roles) {
        this.movies = movies;
    }


    public Client(String nick, String login, String password, boolean isAdmin) {
        this.nick = nick;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public Client(String nick, String login, String password) {
        this.nick = nick;
        this.login = login;
        this.password = password;
    }
    public Client(){}
}
