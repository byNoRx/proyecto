package modelo;

import java.util.ArrayList;

/**
 * Clase que representa un equipo puede contener jugadores y es un participante del torneo
 */
public class Equipo extends Participante {
    private ArrayList<Jugador> jugadores;

    /**
     * Metodo constructor del equipo
     *
     * @param nombre
     * @param email
     * @param telefono
     */
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
