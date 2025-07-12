package org.udec.proyecto;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Torneo torneo;

        TorneoBuilder torneoBuilder = new TorneoBuilder();
        torneoBuilder.setNombre("[Nombre del torneo]");
        torneoBuilder.setDisciplina("[Disciplina del torneo]");
        torneoBuilder.setFormato(new FormatoEliminatoriaDirecta());
        torneoBuilder.setFechaDeInicio(LocalDate.now());
        torneoBuilder.setDiasEntreRondas(1);

        torneo = torneoBuilder.getResult();

        System.out.println(torneo.getNombre() + ", " + torneo.getDisciplina() + ", " + torneo.getFormato() + ", " + torneo.getFechaDeInicio() + ", " + torneo.getDiasEntreRondas());

        int numeroDeJugadores = 5;
        for (int i = 0; i < numeroDeJugadores; i++) {
            JugadorBuilder jugadorBuilder = new JugadorBuilder();
            jugadorBuilder.setNombre("[Nombre del jugador" + i + "]");
            jugadorBuilder.setEmail("[Email del jugador" + i + "]");
            jugadorBuilder.setTelefono("[Telefono del jugador" + i + "]");
            jugadorBuilder.setDireccion("[Direccion del jugador" + i + "]");
            torneo.addParticipante(jugadorBuilder.getResult());
        }
        System.out.println("Participantes: " + torneo.getParticipantes().size());
        for (Participante participante : torneo.getParticipantes()) {
            System.out.println(participante.getNombre());
        }
        
        try {
            torneo.generarPartidos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Partidos: " + torneo.getPartidos().size());
        for (Partido partido : torneo.getPartidos()) {
            System.out.println(partido.getFecha() + " " + partido.getParticipanteA() + " vs " + partido.getParticipanteB() + " Ronda:" + partido.getRonda());
        }

        System.out.println("......");

        System.out.println("Partidos: " + torneo.getPartidos().size());
        for (Partido partido : torneo.getPartidos()) {
            System.out.println(partido.getFecha() + " " + partido.getParticipanteA() + " vs " + partido.getParticipanteB() + " Ronda:" + partido.getRonda());
            if (partido.getPartidoSiguiente() == null) {
                break;
            }
            System.out.println("SIGUIENTE -> " + partido.getPartidoSiguiente().getParticipanteA() + " vs " + partido.getPartidoSiguiente().getParticipanteB() + " Ronda:" + partido.getPartidoSiguiente().getRonda());
        }

        System.out.println("......PASA LA RONDA 1......");

        torneo.getPartidos().get(0).setPuntajeA(1);
        torneo.getPartidos().get(0).terminarPartido();

        torneo.getPartidos().get(1).setPuntajeB(2);
        torneo.getPartidos().get(1).terminarPartido();

        System.out.println("Partidos: " + torneo.getPartidos().size());
        for (Partido partido : torneo.getPartidos()) {
            System.out.println(partido.getFecha() + " " + partido.getParticipanteA() + " vs " + partido.getParticipanteB() + " Ronda:" + partido.getRonda());
            if (partido.getPartidoSiguiente() == null) {
                break;
            }
            System.out.println("SIGUIENTE -> " + partido.getPartidoSiguiente().getParticipanteA() + " vs " + partido.getPartidoSiguiente().getParticipanteB() + " Ronda:" + partido.getPartidoSiguiente().getRonda());
        }

        System.out.println("......PASA LA RONDA 2......");

        torneo.getPartidos().get(2).setPuntajeA(3);
        torneo.getPartidos().get(2).terminarPartido();

        System.out.println("Partidos: " + torneo.getPartidos().size());
        for (Partido partido : torneo.getPartidos()) {
            System.out.println(partido.getFecha() + " " + partido.getParticipanteA() + " vs " + partido.getParticipanteB() + " Ronda:" + partido.getRonda());
            if (partido.getPartidoSiguiente() == null) {
                break;
            }
            System.out.println("SIGUIENTE -> " + partido.getPartidoSiguiente().getParticipanteA() + " vs " + partido.getPartidoSiguiente().getParticipanteB() + " Ronda:" + partido.getPartidoSiguiente().getRonda());
        }
    }
}