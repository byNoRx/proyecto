package modelo;

/**
 * Clase para construir un equipo paso a paso
 */
public class EquipoBuilder {
    private String nombre;
    private String email;
    private String telefono;

    // Setters y Getters

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
