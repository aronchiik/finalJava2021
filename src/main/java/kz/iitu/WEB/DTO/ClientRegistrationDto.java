package kz.iitu.WEB.DTO;

public class ClientRegistrationDto {
    private String nick;
    private String login;
    private String password;

    public ClientRegistrationDto(){}

    public ClientRegistrationDto(String nick, String login, String password) {
        this.nick = nick;
        this.login = login;
        this.password = password;
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
}
