package modelo;

import java.time.LocalDate;

public class Partido {
    private LocalDate fecha;
    private int ronda;
    private Participante participanteA;
    private Participante participanteB;
    private int puntajeA;
    private int puntajeB;
    private Participante ganador;
    private Partido partidoSiguiente;
    private int partidosConectados;

    public Partido(LocalDate fecha, int ronda) {
        this.ronda = ronda;
        this.fecha = fecha;
        this.participanteA = null;
        this.participanteB = null;
        puntajeA = 0;
        puntajeB = 0;
        ganador = null;
    }

    public void setPartidoSiguiente(Partido partidoSiguiente) {
        this.partidoSiguiente = partidoSiguiente;
    }

    public Partido getPartidoSiguiente() {
        return partidoSiguiente;
    }

    public void setPartidosConectados(int partidosConectados) {
        this.partidosConectados = partidosConectados;
    }

    public int getPartidosConectados() {
        return partidosConectados;
    }

    /**
     * Calcula el ganador del partido
     */
    public void terminarPartido() {
        if (puntajeA > puntajeB) {
            ganador = participanteA;
        } else if (puntajeB > puntajeA) {
            ganador = participanteB;
        }
        if (partidoSiguiente == null) {
            return;
        }
        // Si el partido siguiente no tiene participante A, el ganador de este partido se pone como participante A
        if (partidoSiguiente.getParticipanteA() == null) {
            partidoSiguiente.setParticipanteA(ganador);
        }
        // Si el partido siguiente Sí tiene participante A, el ganador de este partido se pone como participante B
        else {
            partidoSiguiente.setParticipanteB(ganador);
        }
    }

    // Getters y Setters

    public void setParticipanteA(Participante participanteA) {
        this.participanteA = participanteA;
    }

    public Participante getParticipanteA() {
        return participanteA;
    }

    public void setParticipanteB(Participante participanteB) {
        this.participanteB = participanteB;
    }

    public Participante getParticipanteB() {
        return participanteB;
    }

    public void setPuntajeA(int puntajeA) {
        this.puntajeA = puntajeA;
    }

    public int getPuntajeA() {
        return puntajeA;
    }

    public void setPuntajeB(int puntajeB) {
        this.puntajeB = puntajeB;
    }

    public int getPuntajeB() {
        return puntajeB;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setGanador(Participante ganador) {
        this.ganador = ganador;
    }

    public Participante getGanador() {
        return ganador;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }
}
