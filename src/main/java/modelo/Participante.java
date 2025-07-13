package modelo;

/**
 * Clase participante que representa un participante (jugador o equipo) que puede participar en un torneo
 */
public abstract class Participante {
    private String nombre;
    private String email;
    private String telefono;

    /**
     * Metodo constructor del participante
     *
     * @param nombre
     * @param email
     * @param telefono
     */
    public Participante(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    // Metodos getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
