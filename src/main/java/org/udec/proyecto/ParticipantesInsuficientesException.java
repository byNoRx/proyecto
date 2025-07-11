package org.udec.proyecto;

public class ParticipantesInsuficientesException extends Exception {
    public ParticipantesInsuficientesException(String mensaje) {
        super(mensaje);
    }
}