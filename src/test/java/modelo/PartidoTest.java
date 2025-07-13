package modelo;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PartidoTest {

    @Test
    void testAsignacionDeParticipantesYPuntajes() {
        Partido partido = new Partido(LocalDate.now(), 1);

        Jugador jugadorA = new Jugador("Jugador A", "a@example.com", "123456789", "Casa A");
        Jugador jugadorB = new Jugador("Jugador B", "b@example.com", "987654321", "Casa B");

        partido.setParticipanteA(jugadorA);
        partido.setParticipanteB(jugadorB);
        partido.setPuntajeA(2);
        partido.setPuntajeB(1);

        assertEquals(jugadorA, partido.getParticipanteA());
        assertEquals(jugadorB, partido.getParticipanteB());
        assertEquals(2, partido.getPuntajeA());
        assertEquals(1, partido.getPuntajeB());
    }

    @Test
    void testTerminarPartidoAsignaGanador() {
        Partido partido = new Partido(LocalDate.now(), 1);

        Jugador jugadorA = new Jugador("Jugador A", "a@example.com", "123456789", "Casa A");
        Jugador jugadorB = new Jugador("Jugador B", "b@example.com", "987654321", "Casa B");

        partido.setParticipanteA(jugadorA);
        partido.setParticipanteB(jugadorB);
        partido.setPuntajeA(3); // Participante A gana
        partido.setPuntajeB(1); // Participante B pierde

        partido.terminarPartido();

        assertEquals(jugadorA, partido.getGanador());
    }

    @Test
    void testGanadorAvanzaAPartidoSiguiente() {
        Partido partido1 = new Partido(LocalDate.now(), 1);
        Partido partido2 = new Partido(LocalDate.now().plusDays(1), 2); // Partido 2 al día siguiente

        partido1.setPartidoSiguiente(partido2);

        Jugador jugadorA = new Jugador("Jugador A", "a@example.com", "123456789", "Casa A");
        Jugador jugadorB = new Jugador("Jugador B", "b@example.com", "987654321", "Casa B");

        partido1.setParticipanteA(jugadorA);
        partido1.setParticipanteB(jugadorB);
        partido1.setPuntajeA(4); // Participante A gana
        partido1.setPuntajeB(2); // Participante B pierde

        partido1.terminarPartido();

        assertEquals(jugadorA, partido2.getParticipanteA()); // Se asigna al ganador como participante A
        assertNull(partido2.getParticipanteB()); // Se mantiene sin asignar al participante B
    }

    @Test
    void testGanadorVaASegundoEspacioSiPrimeroYaOcupado() {
        Partido partido1 = new Partido(LocalDate.now(), 1);
        Partido partido2 = new Partido(LocalDate.now().plusDays(1), 2);

        Jugador jugadorA = new Jugador("Jugador A", "a@example.com", "123456789", "Casa A");
        Jugador jugadorB = new Jugador("Jugador B", "b@example.com", "987654321", "Casa B");
        Jugador jugadorC = new Jugador("Jugador C", "c@example.com", "123123123", "Casa C");

        partido1.setPartidoSiguiente(partido2);
        partido2.setParticipanteA(jugadorC);

        partido1.setParticipanteA(jugadorA);
        partido1.setParticipanteB(jugadorB);
        partido1.setPuntajeA(1); // Participante A pierde
        partido1.setPuntajeB(3); // Participante B gana

        partido1.terminarPartido();

        assertEquals(jugadorC, partido2.getParticipanteA()); // En el primer espacio se mantiene C
        assertEquals(jugadorB, partido2.getParticipanteB()); // En el segundo espacio queda B
    }
}