package org.udec.proyecto;
import java.util.ArrayList;

public class Torneo {
    private String nombre;
    private String disciplina;
    private FormatoTorneo formato;
    private ArrayList<Participante> participantes;

    public Torneo(String nombre, String disciplina, FormatoTorneo formato) {
        this.nombre = nombre;
        this.disciplina = disciplina;
        this.formato = formato;
        this.participantes = new ArrayList<>();
    }

    public void generarPartidos() {
        formato.generarPartidos(participantes);
    }

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
}
