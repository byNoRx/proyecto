package org.udec.proyecto;

public class Torneo {
    private String nombre;
    private String disciplina;

    public Torneo(String nombre, String disciplina) {
        this.nombre = nombre;
        this.disciplina = disciplina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
