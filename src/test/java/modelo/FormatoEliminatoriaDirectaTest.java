package modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

class FormatoEliminatoriaDirectaTest {

    private FormatoEliminatoriaDirecta formato;

    @BeforeEach
    void setUp() {
        formato = new FormatoEliminatoriaDirecta();
    }

    @Test
    void testOrdenarParticipantesAleatoriamente() {
        ArrayList<Participante> participantes = new ArrayList<>();
        participantes.add(new Jugador("Jugador 1", "jugador1@example.com", "111111111", "Casa #1"));
        participantes.add(new Jugador("Jugador 2", "jugador2@example.com", "222222222", "Casa #2"));
        participantes.add(new Jugador("Jugador 3", "jugador3@example.com", "333333333", "Casa #3"));
        participantes.add(new Jugador("Jugador 4", "jugador4@example.com", "444444444", "Casa #4"));

        ArrayList<Participante> copia = new ArrayList<>(participantes);

        formato.ordenarParticipantes(participantes);

        assertTrue(participantes.containsAll(copia) && copia.containsAll(participantes));
    }

    @Test
    void testGenerarPartidosConParticipantesInsuficientes() {
        ArrayList<Participante> participantes = new ArrayList<>();
        participantes.add(new Jugador("Jugador 1", "jugador1@example.com", "111111111",  "Casa #1"));

        ArrayList<Partido> partidos = new ArrayList<>();
        LocalDate fecha = LocalDate.now();

        boolean seLanzoExcepcion = false;
        try {
            formato.generarPartidos(participantes, partidos, fecha, 1);
        } catch (ParticipantesInsuficientesException e) {
            seLanzoExcepcion = true;
        }
        assertTrue(seLanzoExcepcion);
    }

    @Test
    void testGenerarPartidosYConectar() throws ParticipantesInsuficientesException {
        ArrayList<Participante> participantes = new ArrayList<>();
        participantes.add(new Jugador("Jugador 1", "jugador1@example.com", "111111111", "Casa #1"));
        participantes.add(new Jugador("Jugador 2", "jugador2@example.com", "222222222", "Casa #2"));
        participantes.add(new Jugador("Jugador 3", "jugador3@example.com", "333333333", "Casa #3"));
        participantes.add(new Jugador("Jugador 4", "jugador4@example.com", "444444444", "Casa #4"));
        participantes.add(new Jugador("Jugador 5", "jugador5@example.com", "555555555", "Casa #5"));

        ArrayList<Partido> partidos = new ArrayList<>();
        LocalDate fechaInicio = LocalDate.now();

        formato.generarPartidos(participantes, partidos, fechaInicio, 1);

        boolean existeRonda1 = false;
        for (Partido p : partidos) {
            if (p.getRonda() == 1) {
                existeRonda1 = true;
                break;
            }
        }
        assertTrue(existeRonda1);

        boolean existePartidoConSiguiente = false;
        for (Partido p : partidos) {
            if (p.getPartidoSiguiente() != null) {
                existePartidoConSiguiente = true;
                break;
            }
        }
        assertTrue(existePartidoConSiguiente);

        boolean existePartidoConParticipante = false;
        for (Partido p : partidos) {
            if (p.getParticipanteA() != null || p.getParticipanteB() != null) {
                existePartidoConParticipante = true;
                break;
            }
        }
        assertTrue(existePartidoConParticipante);

        for (Partido p : partidos) {
            assertNotNull(p.getFecha());
            assertTrue(p.getRonda() >= 1);
        }
    }
}
