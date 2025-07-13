package modelo;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Formato de eliminatoria doble para un torneo
 */
public class FormatoEliminatorioDoble implements FormatoTorneo {
    @Override
    public void ordenarParticipantes(ArrayList<Participante> participantes) {
        // TODO: Implementar el ordenamiento de la eliminatoria doble.
    }
    
    @Override
    public void generarPartidos(ArrayList<Participante> participantes, ArrayList<Partido> partidos, LocalDate fechaDeInicio, int diasEntreRondas) {
        // TODO: Implementar la generación de la eliminatoria doble.
    }

    @Override
    public void conectarPartidos(ArrayList<Partido> partidos) {
    }
}
