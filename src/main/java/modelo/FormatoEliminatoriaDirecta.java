package modelo;

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

        ArrayList<Participante> actualRonda = new ArrayList<>(participantes);
        LocalDate fechaPartido = fechaDeInicio;
        int ronda = 1;

        while (actualRonda.size() > 1) {
            ArrayList<Participante> siguienteRonda = new ArrayList<>();

            for (int i = 0; i < actualRonda.size(); i += 2) {
                if (i + 1 < actualRonda.size()) {
                    Partido partido = new Partido(fechaPartido, ronda);
                    partido.setParticipanteA(actualRonda.get(i));
                    partido.setParticipanteB(actualRonda.get(i + 1));
                    partidos.add(partido);

                    siguienteRonda.add(null);
                } else {
                    siguienteRonda.add(actualRonda.get(i));
                }
            }

            actualRonda = siguienteRonda;
            fechaPartido = fechaPartido.plusDays(diasEntreRondas);
            ronda++;
        }

        conectarPartidos(partidos);
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