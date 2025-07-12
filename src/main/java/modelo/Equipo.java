package modelo;

import java.util.ArrayList;

public class Equipo extends Participante {
    private ArrayList<Jugador> jugadores;
    
    public Equipo(String nombre, String email, String telefono) {
        super(nombre, email, telefono); 
        jugadores = new ArrayList<>();
    }


    /**
     * Añade un jugador al equipo
     *
     * @param jugador el jugador que sera añadido
     */
    public void AddJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    /**
     * Elimina un jugador del equipo
     *
     * @param jugador el jugador que sera eliminado
     */
    public void RemoveJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }

    /**
     * Devuelve la lista de jugadores
     *
     * @return la lista de jugadores
     */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

}
