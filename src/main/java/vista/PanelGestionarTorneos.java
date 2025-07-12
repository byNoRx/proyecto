package vista;

import javax.swing.*;
import java.awt.*;

public class PanelGestionarTorneos extends JPanel {
    private JButton botonCrear, botonListar, botonEliminar, botonEditar, botonSalir;

    public PanelGestionarTorneos(DefaultListModel<String> torneoModel) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(400, 600));
        setBackground(Color.LIGHT_GRAY);

        add(Box.createVerticalStrut(60));

        botonCrear = new JButton("Crear Torneo");
        botonListar = new JButton("Listar Torneos");
        botonEliminar = new JButton("Eliminar Torneo");
        botonEditar = new JButton("Editar Torneo");
        botonSalir = new JButton("Salir");

        Dimension botonSize = new Dimension(200, 40);
        JButton[] botones = { botonCrear, botonListar, botonEliminar, botonEditar, botonSalir };
        for (JButton boton : botones) {
            boton.setAlignmentX(Component.CENTER_ALIGNMENT);
            boton.setMaximumSize(botonSize);
            add(boton);
            add(Box.createVerticalStrut(20));
        }
    }


}