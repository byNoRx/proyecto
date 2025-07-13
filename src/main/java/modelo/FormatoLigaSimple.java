package modelo;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Formato de liga simple para un torneo
 */
public class FormatoLigaSimple implements FormatoTorneo {
    @Override
    public void ordenarParticipantes(ArrayList<Participante> participantes) {
        // TODO: Implementar el ordenamiento de la liga simple.
    }

    @Override
    public void generarPartidos(ArrayList<Participante> participantes, ArrayList<Partido> partidos, LocalDate fechaDeInicio, int diasEntreRondas) {
        // TODO: Implementar la generación de la liga simple.
    }

    @Override
    public void conectarPartidos(ArrayList<Partido> partidos) {
    }
}
