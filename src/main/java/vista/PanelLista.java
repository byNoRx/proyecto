package vista;

import modelo.Torneo;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que simplemente muesta una lista de los torneos que han sido creados
 */
public class PanelLista extends JPanel {
    private JList<Torneo> torneoList;

    public PanelLista(DefaultListModel<Torneo> torneoModel) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel("Torneos ");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(titleLabel, BorderLayout.NORTH);

        torneoList = new JList<>(torneoModel);
        torneoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(torneoList);
        add(scrollPane, BorderLayout.CENTER);
    }
}
