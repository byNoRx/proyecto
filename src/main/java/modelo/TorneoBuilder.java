package modelo;

import java.time.LocalDate;

/**
 * Clase que se usa para crear un torneo paso a paso
 */
public class TorneoBuilder {
    private String nombre;
    private String disciplina;
    private FormatoTorneo formato;
    private LocalDate fechaDeInicio;
    private int diasEntreRondas;

    // Getters y setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setFormato(FormatoTorneo formato) {
        this.formato = formato;
    }

    public void setFechaDeInicio(LocalDate fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public void setDiasEntreRondas(int diasEntreRondas) {
        this.diasEntreRondas = diasEntreRondas;
    }

    /**
     * Metodo para obtener el torneo con los atributos que se han dado
     *
     * @return Devuelve un torneo con los atributos que se dieron
     */
    public Torneo getResult() {
        return new Torneo(nombre, disciplina, formato, fechaDeInicio, diasEntreRondas);
    }
}
