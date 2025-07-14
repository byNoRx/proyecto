package vista;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Clase que representa un panel que se usa para eliminar los torneos que han sido creados anteriormente
 */
public class PanelEliminarTorneos extends JPanel {
    private JList<String> torneoList;

    /**
     * Metodo cosntructor
     *
     * @param torneoModel
     */
    public PanelEliminarTorneos(DefaultListModel<String> torneoModel) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel("Torneos");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(titleLabel, BorderLayout.NORTH);

        torneoList = new JList<>(torneoModel);
        torneoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        torneoList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String seleccionado = torneoList.getSelectedValue();
                if (seleccionado != null) {
                    int respuesta = JOptionPane.showConfirmDialog(PanelEliminarTorneos.this, "¿Deseas eliminar el torneo \"" + seleccionado + "\"?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

                    if (respuesta == JOptionPane.YES_OPTION) {
                        torneoModel.removeElement(seleccionado);
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(torneoList);
        add(scrollPane, BorderLayout.CENTER);
    }
}