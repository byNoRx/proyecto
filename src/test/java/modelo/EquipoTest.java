package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class EquipoTest {

    private Equipo equipo;
    private Jugador jugador1;
    private Jugador jugador2;

    @BeforeEach
    void setUp() {
        equipo = new Equipo("Equipo", "equipo@example.com", "123456789");
        jugador1 = new Jugador("Juan", "juan@example.com", "987654321", "Casa 3");
        jugador2 = new Jugador("Maria", "maria@example.com", "123123123", "Casa 3");
    }

    @Test
    void addJugador() {
        equipo.AddJugador(jugador1);
        assertTrue(equipo.getJugadores().contains(jugador1));
        assertEquals(1, equipo.getJugadores().size());
    }

    @Test
    void removeJugador() {
        equipo.AddJugador(jugador1);
        equipo.AddJugador(jugador2);
        equipo.RemoveJugador(jugador1);

        assertFalse(equipo.getJugadores().contains(jugador1));
        assertTrue(equipo.getJugadores().contains(jugador2));
        assertEquals(1, equipo.getJugadores().size());
    }

    @Test
    void getJugadores() {
        assertTrue(equipo.getJugadores().isEmpty());

        equipo.AddJugador(jugador1);
        equipo.AddJugador(jugador2);

        ArrayList<Jugador> jugadores = equipo.getJugadores();
        assertEquals(2, jugadores.size());
        assertTrue(jugadores.contains(jugador1));
        assertTrue(jugadores.contains(jugador2));
    }
}