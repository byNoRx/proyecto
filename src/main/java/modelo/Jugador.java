package modelo;

public class Jugador extends Participante {
    private String direccion;
    
    public Jugador(String nombre, String email, String telefono, String direccion) {
        super(nombre, email, telefono); 
        this.direccion = direccion;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
