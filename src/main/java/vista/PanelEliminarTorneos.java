package vista;

import javax.swing.*;
import java.awt.*;

public class PanelEliminarTorneos extends JPanel {
    public PanelEliminarTorneos() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel("Torneos ");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(titleLabel, BorderLayout.NORTH);

        String[] torneos = {"Torneo A", "Torneo B", "Torneo C", "Torneo D"};
        JList<String> torneoList = new JList<>(torneos);
        torneoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(torneoList);
        add(scrollPane, BorderLayout.CENTER);
    }
}