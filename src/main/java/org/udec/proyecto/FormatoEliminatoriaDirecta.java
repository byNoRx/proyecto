package org.udec.proyecto;

import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;


public class FormatoEliminatoriaDirecta implements FormatoTorneo {
    @Override
    public void ordenarParticipantes(ArrayList<Participante> participantes) {
        // Ordenar los participantes de manera aleatoria
        Collections.shuffle(participantes);
    }

    @Override
    public void generarPartidos(ArrayList<Participante> participantes, ArrayList<Partido> partidos, LocalDate fechaDeInicio, int diasEntreRondas) throws ParticipantesInsuficientesException {
        ordenarParticipantes(participantes);

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
                partidos.add(new Partido(fechaPartido, ronda));
            }

            numParticipantes = numPartidos + numParticipantesSobrantes;
            numPartidos = numParticipantes / 2;
            numParticipantesSobrantes = numParticipantes % 2;

            fechaPartido = fechaPartido.plusDays(diasEntreRondas);
            ronda++;
        }
    }

    public void asignarParticipantes(ArrayList<Participante> participantes) {
        // TODO: Implementar la asignación de los participantes en la eliminatoria directa.
    }

}
    @Override
    public void conectarPartidos(ArrayList<Partido> partidos) {
        for (Partido partido1 : partidos) {
            for (Partido partido2 : partidos) {
                if (partido2.getRonda() == partido1.getRonda() + 1 && partido2.getPartidosConectados() < 2) {
                    partido1.setPartidoSiguiente(partido2);
                    partido2.setPartidosConectados(partido2.getPartidosConectados() + 1);
                    break;
                }
            }
        }
    }
}