package modelo;

/**
 * Clase para construir paso a paso un jugador
 */
public class JugadorBuilder {
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;

    // Metodos getters y setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Jugador getResult() {
        return new Jugador(nombre, email, telefono, direccion);
    }
}
