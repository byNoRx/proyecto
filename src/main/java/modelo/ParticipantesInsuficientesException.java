package modelo;

/**
 * Exepcion para cuando no hayan suficiente participantes al momento de crear los partidos de un torneo
 */
public class ParticipantesInsuficientesException extends Exception {
    public ParticipantesInsuficientesException(String mensaje) {
        super(mensaje);
    }
}