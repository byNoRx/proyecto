package org.udec.proyecto;

import java.time.LocalDate;

public class Partido {
    private Participante participanteA;
    private Participante participanteB;
    private LocalDate fecha;
    private int puntajeA;
    private int puntajeB;
    private Participante ganador;

    public Partido(Participante participanteA, Participante participanteB, LocalDate fecha) {
        this.participanteA = participanteA;
        this.participanteB = participanteB;
        this.fecha = fecha;
        puntajeA = 0;
        puntajeB = 0;
        ganador = null;
    }

    /**
     * Calcula el ganador del partido
     */
    public void calcularGanador() {
        if (puntajeA > puntajeB) {
            ganador = participanteA;
        } else if (puntajeB > puntajeA) {
            ganador = participanteB;
        }
    }

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
}
