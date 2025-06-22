package org.udec.proyecto;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Torneo torneo;

        TorneoBuilder torneoBuilder = new TorneoBuilder();
        torneoBuilder.setNombre("Nombre del torneo");
        torneoBuilder.setDisciplina("Disciplina del torneo");

        torneo = torneoBuilder.getResult();

        System.out.println(torneo.getNombre() + ", " + torneo.getDisciplina());
    }
}