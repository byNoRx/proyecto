package org.udec.proyecto;

public class Partido {
    private Participante participanteA;
    private Participante participanteB;
    private int puntajeA;
    private int puntajeB;
    private Participante ganador;

    public Partido(Participante participanteA, Participante participanteB) {
        this.participanteA = participanteA;
        this.participanteB = participanteB;
        puntajeA = 0;
        puntajeB = 0;
        ganador = null;
    }
}
