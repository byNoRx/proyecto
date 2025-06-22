package org.udec.proyecto;

public class TorneoBuilder {
    private String nombre;
    private String disciplina;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Torneo getResult() {
        return new Torneo(nombre, disciplina);
    }
}
