package modelo;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TorneoTest {

    @Test
    void testGenerarTorneoConParticipantesYPartidos() {
        FormatoTorneo formato = new FormatoEliminatoriaDirecta();
        Torneo torneo = new Torneo("Torneo de Prueba", "Ajedrez", formato, LocalDate.of(2025, 7, 12), 2);

        Participante p1 = new Jugador("Jugador 1", "jugador1@example.com", "111111111", "Casa 1");
        Participante p2 = new Jugador("Jugador 2", "jugador2@example.com", "222222222", "Casa 2");
        Participante p3 = new Jugador("Jugador 3", "jugador3@example.com", "333333333", "Casa 3");
        Participante p4 = new Jugador("Jugador 4", "jugador4@example.com", "444444444", "Casa 4");

        torneo.addParticipante(p1);
        torneo.addParticipante(p2);
        torneo.addParticipante(p3);
        torneo.addParticipante(p4);

        assertEquals(4, torneo.getParticipantes().size());

        // Generar partidos
        try {
            torneo.generarPartidos();
        } catch (ParticipantesInsuficientesException e) {
            System.out.println(e.getMessage());
        }

        // Con n participantes hay n-1 partidos
        assertEquals(3, torneo.getPartidos().size());
    }

    @Test
    void testAgregarYRemoverPartido() {
        Torneo torneo = new Torneo("Torneo", "Fútbol", new FormatoEliminatoriaDirecta(), LocalDate.now(), 1);
        Partido partido = new Partido(LocalDate.now(), 1);

        torneo.addPartido(partido);
        assertTrue(torneo.getPartidos().contains(partido));

        torneo.removePartido(partido);
        assertFalse(torneo.getPartidos().contains(partido));
    }

    @Test
    void testParticipantesInsuficientes() {
        Torneo torneo = new Torneo("Torneo", "Fútbol", new FormatoEliminatoriaDirecta(), LocalDate.now(), 1);
        torneo.addParticipante(new Jugador("Jugador 1", "jugador1@example.com", "111111111", "Casa 1"));

        boolean seLanzoExcepcion = false;
        try {
            torneo.generarPartidos();
        } catch (ParticipantesInsuficientesException e) {
            seLanzoExcepcion = true;
        }

        assertTrue(seLanzoExcepcion);
    }

    @Test
    void testParticipantesSuficientes() {
        Torneo torneo = new Torneo("Torneo", "Fútbol", new FormatoEliminatoriaDirecta(), LocalDate.now(), 1);
        torneo.addParticipante(new Jugador("Jugador 1", "jugador1@example.com", "111111111", "Casa 1"));
        torneo.addParticipante(new Jugador("Jugador 2", "jugador2@example.com", "222222222", "Casa 2"));

        boolean seLanzoExcepcion = false;
        try {
            torneo.generarPartidos();
        } catch (ParticipantesInsuficientesException e) {
            seLanzoExcepcion = true;
        }

        assertFalse(seLanzoExcepcion);
    }
}
