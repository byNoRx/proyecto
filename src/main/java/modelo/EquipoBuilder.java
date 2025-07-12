package modelo;

public class EquipoBuilder {
    private String nombre;
    private String email;
    private String telefono;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Equipo getResult() {
        return new Equipo(nombre, email, telefono);
    }
}
