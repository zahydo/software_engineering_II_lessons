package co.edu.unicauca.openmarket.domain;

/**
 * Representa un usuario que entra al sistema
 *
 * @author Libardo, Julio
 */
public class User {

    /**
     *
     */
    private String login;
    /**
     *
     */
    private String password;
    /**
     * Nombres y apellidos completos
     */
    private String username;

    /**
     * Constructor que inicializa un usuario
     *
     * @param login nombre del usuario
     * @param password contraseña secreta
     * @param username nombre del usuario
     */
    public User(String login, String password, String username) {
        this.login = login;
        this.password = password;
        this.username = username;

        //Vuelo vuelo = new Vuelo();
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

    public void setPassword(String contrasenia) {
        this.password = contrasenia;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String nombres) {
        this.username = nombres;
    }

}
