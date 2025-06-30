package org.udec.proyecto;

public class TorneoBuilder {
    private String nombre;
    private String disciplina;
    private FormatoTorneo formato;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setFormato(FormatoTorneo formato) {
        this.formato = formato;
    }

    public Torneo getResult() {
        return new Torneo(nombre, disciplina, formato);
    }
}
