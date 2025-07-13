package modelo;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Collections;

/**
 * Formato de liga simple para un torneo
 */
public class FormatoLigaSimple implements FormatoTorneo {

    @Override
    public void ordenarParticipantes(ArrayList<Participante> participantes) {
        Collections.shuffle(participantes); // Se ordenan aleatoriamente
    }

    @Override
    public void generarPartidos(ArrayList<Participante> participantes, ArrayList<Partido> partidos, LocalDate fechaDeInicio, int diasEntreRondas) throws ParticipantesInsuficientesException {
        ordenarParticipantes(participantes); // Primero se ordenan

        if (participantes.size() < 2) {
            throw new ParticipantesInsuficientesException("El torneo debe tener al menos 2 participantes.");
        }

        LocalDate fechaActual = fechaDeInicio;
        int ronda = 1;

        // Generar todos los pares posibles sin repetición
        for (int i = 0; i < participantes.size(); i++) {
            for (int j = i + 1; j < participantes.size(); j++) {
                Participante a = participantes.get(i);
                Participante b = participantes.get(j);

                Partido partido = new Partido(fechaActual, ronda);
                partido.setParticipanteA(a);
                partido.setParticipanteB(b);
                partidos.add(partido);

                fechaActual = fechaActual.plusDays(diasEntreRondas);
                ronda++;
            }
        }
    }

    @Override
    public void conectarPartidos(ArrayList<Partido> partidos) {
    }
}
