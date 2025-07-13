package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FormatoLigaSimpleTest {

    private FormatoLigaSimple formato;
    private ArrayList<Participante> participantes;
    private ArrayList<Partido> partidos;
    private LocalDate fechaInicio;

    @BeforeEach
    public void setUp() {
        formato = new FormatoLigaSimple();
        participantes = new ArrayList<>();
        partidos = new ArrayList<>();
        fechaInicio = LocalDate.now();

        Jugador jugadorA = new Jugador("Jugador A", "a@example.com", "123456789", "Casa A");
        Jugador jugadorB = new Jugador("Jugador B", "b@example.com", "987654321", "Casa B");
        Jugador jugadorC = new Jugador("Jugador C", "c@example.com", "123123123", "Casa C");
        Jugador jugadorD = new Jugador("Jugador C", "c@example.com", "321321321", "Casa D");

        participantes.add(jugadorA);
        participantes.add(jugadorB);
        participantes.add(jugadorC);
        participantes.add(jugadorD);
    }

    @Test
    public void testGenerarPartidosLigaSimple() throws ParticipantesInsuficientesException {
        int diasEntreRondas = 1;

        formato.generarPartidos(participantes, partidos, fechaInicio, diasEntreRondas);

        // Si hay n participantes, entonces hay n * (n - 1) / 2 partidos
        assertEquals(6, partidos.size());

        // Comprobar que cada partido tiene dos participantes que son distintos
        for (Partido p : partidos) {
            assertNotNull(p.getParticipanteA());
            assertNotNull(p.getParticipanteB());
            assertNotEquals(p.getParticipanteA(), p.getParticipanteB());
        }

        // Comprobar que las fechas sean correctas
        for (int i = 0; i < partidos.size(); i++) {
            LocalDate fechaEsperada = fechaInicio.plusDays(i);
            assertEquals(fechaEsperada, partidos.get(i).getFecha());
        }
    }

    @Test
    public void testLanzaExcepcionSiHayUnParticipante() {
        participantes = new ArrayList<>();
        participantes.add(new Jugador("Jugador A", "a@example.com", "123456789", "Casa A"));

        boolean seLanzoExcepcion = false;
        try {
            formato.generarPartidos(participantes, partidos, fechaInicio, 1);
        } catch (ParticipantesInsuficientesException e) {
            seLanzoExcepcion = true;
        }
        assertTrue(seLanzoExcepcion);
    }
}
