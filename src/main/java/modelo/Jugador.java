package modelo;

/**
 * Clase que representa a un jugador que puede participar en un torneo
 */
public class Jugador extends Participante {
    private String direccion;

    /**
     * Metodo constructor del jugador
     *
     * @param nombre
     * @param email
     * @param telefono
     * @param direccion
     */
    public Jugador(String nombre, String email, String telefono, String direccion) {
        super(nombre, email, telefono); 
        this.direccion = direccion;
    }

    // Metodos getters y setters

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
