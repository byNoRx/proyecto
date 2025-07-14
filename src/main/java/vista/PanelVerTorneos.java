package vista;

import modelo.Torneo;
import modelo.Partido;
import modelo.Participante;

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
    private JTextArea areaDetallePartidos;

    public PanelVerTorneos(DefaultListModel<Torneo> torneoModel) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.LIGHT_GRAY);

        // Título principal
        JLabel titleLabel = new JLabel("Torneos");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(titleLabel, BorderLayout.NORTH);

        // Lista de torneos a la izquierda
        torneoList = new JList<>(torneoModel);
        torneoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(torneoList);
        scrollPane.setPreferredSize(new Dimension(250, 600));
        add(scrollPane, BorderLayout.WEST);

        // Panel de estadísticas e información
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(Color.LIGHT_GRAY);
        infoPanel.setBorder(BorderFactory.createTitledBorder("Resumen del Torneo"));

        // Labels de resumen
        labelParticipantes = new JLabel("Participantes: ");
        labelPartidos = new JLabel("Partidos: ");
        labelPartidosJugados = new JLabel("Partidos jugados: ");
        labelPartidosPorJugar  = new JLabel("Partidos por jugar: ");
        labelPuntos = new JLabel("Puntos totales: ");

        // Alineación
        for (JLabel label : new JLabel[]{labelParticipantes, labelPartidos, labelPartidosJugados, labelPartidosPorJugar, labelPuntos}) {
            label.setAlignmentX(Component.LEFT_ALIGNMENT);
            infoPanel.add(label);
            infoPanel.add(Box.createVerticalStrut(5));
        }

        // Área de texto con los detalles de los partidos
        areaDetallePartidos = new JTextArea(10, 30);
        areaDetallePartidos.setEditable(false);
        areaDetallePartidos.setLineWrap(true);
        areaDetallePartidos.setWrapStyleWord(true);
        JScrollPane areaScroll = new JScrollPane(areaDetallePartidos);
        areaScroll.setPreferredSize(new Dimension(320, 250));

        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(new JLabel("Detalle de partidos:"));
        infoPanel.add(areaScroll);
        infoPanel.add(Box.createVerticalStrut(10));

        add(infoPanel, BorderLayout.CENTER);

        // Evento al seleccionar torneo
        torneoList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Torneo seleccionado = torneoList.getSelectedValue();
                    if (seleccionado != null) {
                        // Actualiza estadísticas
                        labelParticipantes.setText("Participantes: " + seleccionado.getParticipantes().size());
                        labelPartidos.setText("Partidos: " + seleccionado.getPartidos().size());
                        labelPartidosJugados.setText("Partidos jugados: " + seleccionado.getTotalPartidosJugados());
                        labelPartidosPorJugar.setText("Partidos por jugar: " +
                                (seleccionado.getPartidos().size() - seleccionado.getTotalPartidosJugados()));
                        labelPuntos.setText("Puntos totales: " + seleccionado.getTotalPuntos());

                        // Mostrar detalle de cada partido
                        StringBuilder detalles = new StringBuilder();
                        int index = 1;
                        for (Partido partido : seleccionado.getPartidos()) {
                            Participante a = partido.getParticipanteA();
                            Participante b = partido.getParticipanteB();
                            String nombreA = (a != null) ? a.getNombre() : "-";
                            String nombreB = (b != null) ? b.getNombre() : "-";

                            detalles.append("Partido ").append(index++).append(": ")
                                    .append("[Fecha: ").append(partido.getFecha()).append(", ")
                                    .append("Ronda: ").append(partido.getRonda()).append(", ")
                                    .append(nombreA).append(" (").append(partido.getPuntajeA()).append(") vs ")
                                    .append(nombreB).append(" (").append(partido.getPuntajeB()).append(")");

                            if (partido.getTerminado()) {
                                detalles.append(" - Terminado");
                            }

                            detalles.append("]\n");
                        }

                        areaDetallePartidos.setText(detalles.toString());
                        revalidate();
                        repaint();
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // No se necesita por ahora
    }
}
