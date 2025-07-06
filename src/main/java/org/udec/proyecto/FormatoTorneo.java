package org.udec.proyecto;

import java.util.ArrayList;
import java.time.LocalDate;

public interface FormatoTorneo {
    void generarPartidos(ArrayList<Participante> participantes, ArrayList<Partido> partidos, LocalDate fechaDeInicio, int diasEntreRondas);
}