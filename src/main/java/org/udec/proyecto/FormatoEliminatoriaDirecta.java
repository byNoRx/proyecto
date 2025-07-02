package org.udec.proyecto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public  class FormatoEliminatoriaDirecta implements FormatoTorneo {
    private ArrayList<Participante> grupo1 = new ArrayList<>();
    private ArrayList<Participante> grupo2 = new ArrayList<>();
    private ArrayList<Participante> grupo3 = new ArrayList<>();
    private ArrayList<Participante> grupo4 = new ArrayList<>();
    private ArrayList<Participante> grupo5 = new ArrayList<>();
    private ArrayList<Participante> grupo6 = new ArrayList<>();
    private ArrayList<Participante> grupo7 = new ArrayList<>();
    private ArrayList<Participante> grupo8 = new ArrayList<>();
    private ArrayList<Participante> grupo11 = new ArrayList<>();
    private ArrayList<Participante> grupo12 = new ArrayList<>();
    private ArrayList<Participante> grupo13 = new ArrayList<>();
    private ArrayList<Participante> grupo14 = new ArrayList<>();
    private ArrayList<Participante> Jugadores;


    @Override
    public void generarPartidos(Torneo torneo) {
        // TODO: Implementar la generación de la eliminatoria directa.


        Jugadores = torneo.getParticipantes();
        Collections.shuffle(Jugadores);
        System.out.println(Jugadores.toArray().length);
        for (int i = 0; i < (Jugadores.toArray().length/2)+1; i = i + 1) {
            switch (i) {
                case 0:
                    grupo1.add(Jugadores.get(0));
                    grupo1.add(Jugadores.get(1));
                    break;
                case 1:
                    grupo2.add(Jugadores.get(2));
                    grupo2.add(Jugadores.get(3));
                    break;
                case 3:
                    grupo3.add(Jugadores.get(4));
                    grupo3.add(Jugadores.get(5));
                    break;
                case 4:
                    grupo4.add(Jugadores.get(6));
                    grupo4.add(Jugadores.get(7));
                    break;
                case 5:
                    grupo5.add(Jugadores.get(8));
                    grupo5.add(Jugadores.get(9));
                    break;
                case 6:
                    grupo6.add(Jugadores.get(10));
                    grupo6.add(Jugadores.get(11));
                    break;
                case 7:
                    grupo7.add(Jugadores.get(12));
                    grupo7.add(Jugadores.get(13));
                    break;
                case 8:
                    grupo8.add(Jugadores.get(14));
                    grupo8.add(Jugadores.get(15));
                    break;

            }

        }



    }

    public String toString() {
        return "FormatoEliminatoriaDirecta";

    }

    public void PartidosRonda1() {

        for (int i = 0; i < Jugadores.toArray().length; i = i + 2) {

            System.out.print(Jugadores.get(i).getNombre() + " vs " + Jugadores.get(i + 1).getNombre());
            System.out.println();
        }
    }

    public void definirGanadorGrupo(int numeroGrupo) {
        ArrayList<Participante> grupo = switch (numeroGrupo) {
            case 1 -> grupo1;
            case 2 -> grupo2;
            case 3 -> grupo3;
            case 4 -> grupo4;
            case 5 -> grupo5;
            case 6 -> grupo6;
            case 7 -> grupo7;
            case 8 -> grupo8;
            default -> null;
        };
        if (grupo == null || grupo.size() != 2) {
            System.out.println("Grupo invalido o ya definido.");
            return;
        }
        Participante p1 = grupo.get(0);
        Participante p2 = grupo.get(1);


        System.out.println("Selecciona el ganador del Grupo " + numeroGrupo);
        System.out.println("1: " + p1.getNombre());
        System.out.println("2: " + p2.getNombre());

        Scanner scanner = new Scanner(System.in);
        int eleccion;
        do {
            System.out.print("Elige (1 o 2): ");
            eleccion = scanner.nextInt();

        }while (eleccion != 1 && eleccion != 2);
        Participante ganador = (eleccion == 1) ? p1 : p2;
        grupo.clear();
        grupo.add(ganador);
        System.out.println("Ganador: " + ganador.getNombre());
        agregarAGrupoSegundaRonda(ganador);



    }
    private void agregarAGrupoSegundaRonda(Participante ganador) {
        if (grupo11.size() < 2) {grupo11.add(ganador);}
        else if (grupo12.size() < 2) {grupo12.add(ganador);}
        else if (grupo13.size() < 2) {grupo13.add(ganador);}
        else if (grupo14.size() < 2) {grupo14.add(ganador);}
    }

    public void PartidosRonda2() {
        System.out.println("PartidosRonda2:");

       if(grupo11.size() == 2 ) {System.out.println(grupo11.get(0).getNombre() + " vs " + grupo11.get(1).getNombre());}

       if(grupo12.size() == 2 ) {System.out.println(grupo12.get(0).getNombre() + " vs " + grupo12.get(1).getNombre());}
    }

    }