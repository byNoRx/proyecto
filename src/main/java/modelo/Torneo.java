package modelo;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Clase que representa un torneo
 */
public class Torneo {
    private String nombre;
    private String disciplina;
    private FormatoTorneo formato;
    private ArrayList<Participante> participantes;
    private ArrayList<Partido> partidos;
    private LocalDate fechaDeInicio;
    private int diasEntreRondas;

    /**
     * Metodo constructor del torneo
     *
     * @param nombre
     * @param disciplina
     * @param formato Indica el formato que tiene el torneo que se usa para generar los partidos
     * @param fechaDeInicio Indica la fecha en que inicia el torneo
     * @param diasEntreRondas Establece una distancia entre las rondas del torneo a partir de la fecha inicial
     */
    public Torneo(String nombre, String disciplina, FormatoTorneo formato, LocalDate fechaDeInicio, int diasEntreRondas) {
        this.nombre = nombre;
        this.disciplina = disciplina;
        this.formato = formato;
        this.participantes = new ArrayList<>();
        this.partidos = new ArrayList<>();
        this.fechaDeInicio = fechaDeInicio;
        this.diasEntreRondas = diasEntreRondas;
    }
    /**
     * Genera los partidos del torneo.
     */
    public void generarPartidos() throws ParticipantesInsuficientesException {
        formato.generarPartidos(participantes, partidos, fechaDeInicio, diasEntreRondas);
    }

    /**
     * Añade un participante al torneo
     *
     * @param participante el participante que sera añadido
     */
    public void addParticipante(Participante participante) {
        participantes.add(participante);
    }

    /**
     * Elimina un participante del torneo
     *
     * @param participante el participante que sera eliminado
     */
    public void removeParticipante(Participante participante) {
        participantes.remove(participante);
    }

    /**
     * Devuelve la lista de participantes
     *
     * @return la lista de participantes
     */
    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    /**
     * Añade un partido al torneo
     *
     * @param partido el partido que sera añadido
     */
    public void addPartido(Partido partido) {
        partidos.add(partido);
    }

    /**
     * Elimina un partido del torneo
     *
     * @param partido el partido que sera eliminado
     */
    public void removePartido(Partido partido) {
        partidos.remove(partido);
    }
    
    /**
     * Devuelve la lista de partidos
     *
     * @return la lista de partidos
     */
    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    /**
     * Metodo para obtener la cantidad de partidos que han sido jugados en el torneo
     *
     * @return Devuelve el total de partidos que han terminado
     */
    public int getTotalPartidosJugados() {
        int totalPartidosJugados = 0;
        for (Partido partido : partidos) {
            if (partido.getTerminado()) {
                totalPartidosJugados++;
            }
        }
        return totalPartidosJugados;
    }

    // Metodos getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public FormatoTorneo getFormato() {
        return formato;
    }

    public void setFormato(FormatoTorneo formato) {
        this.formato = formato;
    }

    public LocalDate getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(LocalDate fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public int getDiasEntreRondas() {
        return diasEntreRondas;
    }

    public void setDiasEntreRondas(int diasEntreRondas) {
        this.diasEntreRondas = diasEntreRondas;
    }
}
