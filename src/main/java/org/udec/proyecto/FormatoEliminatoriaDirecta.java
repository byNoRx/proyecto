package org.udec.proyecto;

import java.util.ArrayList;
import java.time.LocalDate;

public class FormatoEliminatoriaDirecta implements FormatoTorneo {
    @Override
    public void generarPartidos(ArrayList<Participante> participantes, ArrayList<Partido> partidos, LocalDate fechaDeInicio, int diasEntreRondas) throws ParticipantesInsuficientesException {
        if (participantes.size() < 2) {
            throw new ParticipantesInsuficientesException("El torneo debe tener al menos 2 participantes.");
        }

        int numParticipantes = participantes.size();
        int numPartidos = numParticipantes / 2;
        int numParticipantesSobrantes = numParticipantes % 2;
        int ronda = 1;
        LocalDate fechaPartido = fechaDeInicio;
        while (numPartidos > 0) {
            for (int i = 0; i < numPartidos; i++) {
                partidos.add(new Partido(fechaPartido));
            }

            numParticipantes = numPartidos + numParticipantesSobrantes;
            numPartidos = numParticipantes / 2;
            numParticipantesSobrantes = numParticipantes % 2;

            fechaPartido = fechaPartido.plusDays(diasEntreRondas);
            ronda++;
        }
    }
}
