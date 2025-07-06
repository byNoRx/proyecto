package org.udec.proyecto;

import java.util.ArrayList;
import java.time.LocalDate;

public interface FormatoTorneo {
    public void ordenarParticipantes(ArrayList<Participante> participantes);
    public void generarPartidos(ArrayList<Participante> participantes, ArrayList<Partido> partidos, LocalDate fechaDeInicio, int diasEntreRondas) throws ParticipantesInsuficientesException;
}