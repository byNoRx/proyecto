package org.udec.proyecto;

import java.util.ArrayList;
import java.time.LocalDate;

public class FormatoEliminatoriaDirecta implements FormatoTorneo {
    @Override
    public void generarPartidos(ArrayList<Participante> participantes, ArrayList<Partido> partidos, LocalDate fechaDeInicio, int diasEntreRondas) {

        int numParticipantes = participantes.size();
        int numPartidos = numParticipantes / 2;
        int numParticipantesSobrantes = numParticipantes % 2;
        LocalDate fechaPartido = fechaDeInicio;

        System.out.println("Formato Eliminatoria Directa");
        while (numPartidos > 0) {
            for (int i = 0; i < numPartidos; i++) {
                partidos.add(new Partido(fechaPartido));
            }

            numParticipantes = numPartidos + numParticipantesSobrantes;
            numPartidos = numParticipantes / 2;
            numParticipantesSobrantes = numParticipantes % 2;

            fechaPartido = fechaPartido.plusDays(diasEntreRondas);
        }
    }
}
