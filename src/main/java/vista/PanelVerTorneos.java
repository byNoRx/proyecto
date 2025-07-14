package vista;

import modelo.Torneo;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que muestra un panel que permite ver los torneos que han sido creados y sus estadísticas
 */
public class PanelVerTorneos extends JPanel implements ActionListener {
    private JList<Torneo> torneoList;
    private JLabel labelParticipantes;
    private JLabel labelPartidos;
    private JLabel labelPartidosJugados;
    private JLabel labelPartidosPorJugar;
    private JLabel labelPuntos;

    public PanelVerTorneos(DefaultListModel<Torneo> torneoModel) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel("Torneos");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(titleLabel, BorderLayout.NORTH);

        torneoList = new JList<>(torneoModel);
        torneoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(torneoList);
        add(scrollPane, BorderLayout.CENTER);

        // Panel inferior con la información del torneo
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(Color.LIGHT_GRAY);
        infoPanel.setBorder(BorderFactory.createTitledBorder("Resumen del Torneo"));

        labelParticipantes = new JLabel("Participantes: ");
        labelPartidos = new JLabel("Partidos: ");
        labelPartidosJugados = new JLabel("Partidos jugados: ");
        labelPartidosPorJugar  = new JLabel("Partidos por jugar: ");
        labelPuntos = new JLabel("Puntos totales: ");

        labelParticipantes.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelPartidos.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelPartidosJugados.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelPartidos.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelPuntos.setAlignmentX(Component.LEFT_ALIGNMENT);

        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(labelParticipantes);
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(labelPartidos);
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(labelPartidosJugados);
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(labelPartidosPorJugar);
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(labelPuntos);
        infoPanel.add(Box.createVerticalStrut(10));

        add(infoPanel, BorderLayout.SOUTH);

        torneoList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Torneo seleccionado = torneoList.getSelectedValue();
                    if (seleccionado != null) {
                        labelParticipantes.setText("Participantes: " + seleccionado.getParticipantes().size());
                        labelPartidos.setText("Partidos: " + seleccionado.getPartidos().size());
                        labelPartidosJugados.setText("Partidos jugados: " + seleccionado.getTotalPartidosJugados());
                        labelPartidosPorJugar.setText("Partidos por jugar: " + (seleccionado.getPartidos().size() - seleccionado.getTotalPartidosJugados()));
                        labelPuntos.setText("Puntos totales: " + seleccionado.getTotalPuntos());
                        revalidate();
                        repaint();
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}