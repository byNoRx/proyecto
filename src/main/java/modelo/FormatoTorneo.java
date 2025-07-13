package modelo;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Interfaz para crear formatos para los torneos
 */
public interface FormatoTorneo {
    /**
     * Metodo para ordenar los participantes del torneo antes de generar los partidos
     *
     * @param participantes lista de participantes del torneo
     */
    public void ordenarParticipantes(ArrayList<Participante> participantes);

    /**
     * Metodo para generar los partidos y asignar los participantes en los partidos iniciales del torneo
     *
     * @param participantes lista de participantes del torneo
     * @param partidos lista de partidos del torneo
     * @param fechaDeInicio fecha en que inicia el toreno
     * @param diasEntreRondas tiempo que hay entre rondas del torneo
     * @throws ParticipantesInsuficientesException exepcion cuando hay insuficientes participantes al generar el torneo
     */
    public void generarPartidos(ArrayList<Participante> participantes, ArrayList<Partido> partidos, LocalDate fechaDeInicio, int diasEntreRondas) throws ParticipantesInsuficientesException;

    /**
     * Metodo para conectar los partidos inferiores con los superiores y asi poder mover a los participantes ganadores
     *
     * @param partidos lista de partidos del torneo
     */
    public void conectarPartidos(ArrayList<Partido> partidos);
}