package org.udec.proyecto;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        FormatoEliminatoriaDirecta formato = new FormatoEliminatoriaDirecta();

        Jugador jugador1 = new Jugador("ana1","ana1@xd","12345","abc123");
        Jugador jugador2 = new Jugador("ana2","ana2@xd","12345","abc123");
        Jugador jugador3 = new Jugador("ana3","ana3@xd","12345","abc123");
        Jugador jugador4 = new Jugador("ana4","ana4@xd","12345","abc123");
        Jugador jugador12 = new Jugador("ana5","ana1@xd","12345","abc123");
        Jugador jugador23 = new Jugador("ana6","ana2@xd","12345","abc123");
        Jugador jugador34 = new Jugador("ana7","ana3@xd","12345","abc123");
        Jugador jugador45= new Jugador("ana8","ana4@xd","12345","abc123");




        Torneo torneo;

        TorneoBuilder torneoBuilder = new TorneoBuilder();
        torneoBuilder.setNombre("Nombre del torneo");
        torneoBuilder.setDisciplina("Disciplina del torneo");
        torneoBuilder.setFormato(formato);


        torneo = torneoBuilder.getResult();
        torneo.addParticipante(jugador1);
        torneo.addParticipante(jugador2);
        torneo.addParticipante(jugador3);
        torneo.addParticipante(jugador4);
        torneo.addParticipante(jugador12);
        torneo.addParticipante(jugador34);
        torneo.addParticipante(jugador45);
        torneo.addParticipante(jugador23);


        formato.generarPartidos(torneo);
        formato.PartidosRonda1();
        formato.definirGanadorGrupo(1);
        formato.definirGanadorGrupo(2);
        formato.definirGanadorGrupo(3);
        formato.definirGanadorGrupo(4);

        formato.PartidosRonda2();


        System.out.println(torneo.getNombre() + ", " + torneo.getDisciplina() +  ", " + torneo.getFormato());

    }
}