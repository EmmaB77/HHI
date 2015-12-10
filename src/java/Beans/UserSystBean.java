package Beans;


public class UserSystBean {
    
    private int userSystId;
    private PersonaBean persona;
    private String usuario;
    private String password;

    public PersonaBean getPersona() {
        return persona;
    }

    public void setPersona(PersonaBean persona) {
        this.persona = persona;
    }

    public int getUserSystId() {
        return userSystId;
    }

    public void setUserSystId(int userSystId) {
        this.userSystId = userSystId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
