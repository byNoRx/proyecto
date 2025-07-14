package vista;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa la ventana principal del gestor de torneos
 */
public class Ventana extends JFrame {
    public Ventana() {

        setTitle("Interfaz de Torneos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 900);
        setLayout(new BorderLayout());

        // Agregar panel de lista a la izquierda


        // Agregar panel principal al centro
        add(new PanelPrincipal(), BorderLayout.WEST);

        setVisible(true);
    }


}