package vista;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa la ventana principal del gestor de torneos
 */
public class Ventana extends JFrame {
    public Ventana() {

        setTitle("Sistema de Gestión de Torneos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 900);
        setLayout(new BorderLayout());

        // Agregar panel principal a la izquierda
        add(new PanelPrincipal(), BorderLayout.WEST);

        setVisible(true);
    }


}