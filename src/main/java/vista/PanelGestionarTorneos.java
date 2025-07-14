package vista;

import modelo.Torneo;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa un panel que se usa para gestionar los torneos,
 * por ejemplo para añadir participantes y generar los partidos.
 */
public class PanelGestionarTorneos extends JPanel implements ActionListener {
    private JButton botonCrear, botonListar, botonEliminar, botonEditar, botonResult;
    private JList<Torneo> torneoList;
    private String seleccionado;
    private JPanel panelBotones;
    private JButton botonEquipo;
    private JButton botonJugador;
    private JButton botonVolver;
    private JButton guardarEquipo;
    private JButton volverEquipo;
    private JButton guardarJugador;
    private JButton volverJugador;

    private JTextField campo1;
    private JTextField campo2;
    private JTextField campo3;
    private JTextField campo4;

    private JTextField campo1Jugador;
    private JTextField campo2Jugador;
    private JTextField campo3Jugador;
    private JTextField campo4Jugador;
    private JTextField campo5Jugador;

    /**
     * Metodo constructor
     *
     * @param torneoModel
     */
    public PanelGestionarTorneos(DefaultListModel<Torneo> torneoModel) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 800));
        setBackground(Color.LIGHT_GRAY);

        botonEquipo = new JButton("Inscribir equipo");
        botonEquipo.addActionListener(this);
        botonJugador = new JButton("Inscribir jugador");
        botonJugador.addActionListener(this);
        botonVolver = new JButton("Volver");
        botonVolver.addActionListener(this);

        JPanel panelLista = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Torneos");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panelLista.add(titleLabel, BorderLayout.NORTH);

        torneoList = new JList<>(torneoModel);
        torneoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(torneoList);
        panelLista.add(scrollPane, BorderLayout.CENTER);

        torneoList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    seleccionado = String.valueOf(torneoList.getSelectedValue());
                    if (seleccionado != null) {
                        add(panelBotones, BorderLayout.SOUTH); //
                        revalidate();
                        repaint();
                        System.out.println(seleccionado);
                    }
                }
            }
        });

        panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(Color.LIGHT_GRAY);
        panelBotones.add(Box.createVerticalStrut(20));

        botonCrear = new JButton("Ver lista de participantes");
        botonListar = new JButton("Inscribir participantes");
        botonEliminar = new JButton("Generar partidos");
        botonEditar = new JButton("Eliminar participantes");
        botonResult = new JButton("Registrar resultados");

        Dimension botonSize = new Dimension(200, 40);
        JButton[] botones = { botonCrear, botonListar, botonEliminar, botonEditar, botonResult};
        for (JButton boton : botones) {
            boton.setAlignmentX(Component.CENTER_ALIGNMENT);
            boton.setMaximumSize(botonSize);
            boton.addActionListener(this);
            panelBotones.add(boton);
            panelBotones.add(Box.createVerticalStrut(15));
        }

        add(panelLista, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (seleccionado != null) {
            if (e.getSource() == botonCrear) {
            }

            if (e.getSource() == botonListar) {
                panelBotones.removeAll();

                botonEquipo.setAlignmentX(Component.CENTER_ALIGNMENT);
                botonJugador.setAlignmentX(Component.CENTER_ALIGNMENT);
                botonVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
                panelBotones.add(Box.createVerticalStrut(20));
                panelBotones.add(botonEquipo);
                panelBotones.add(Box.createVerticalStrut(15));
                panelBotones.add(botonJugador);
                panelBotones.add(Box.createVerticalStrut(15));
                panelBotones.add(botonVolver);

                revalidate();
                repaint();
            }

            if (e.getSource() == botonVolver) {
                panelBotones.removeAll();
                Dimension botonSize = new Dimension(200, 40);
                JButton[] botones = {botonCrear, botonListar, botonEliminar, botonEditar, botonResult};
                for (JButton boton : botones) {
                    boton.setAlignmentX(Component.CENTER_ALIGNMENT);
                    boton.setMaximumSize(botonSize);
                    panelBotones.add(boton);
                    panelBotones.add(Box.createVerticalStrut(15));

                    revalidate();
                    repaint();
                }
            }

            if(e.getSource() == botonEquipo) {
                panelBotones.removeAll();

                campo1 = new JTextField(15);
                campo2 = new JTextField(15);
                campo3 = new JTextField(15);
                campo4 = new JTextField(15);

                guardarEquipo = new JButton("Guardar equipo");
                guardarEquipo.addActionListener(this);
                volverEquipo = new JButton("Volver");
                volverEquipo.addActionListener(this);

                campo1.setMaximumSize(new Dimension(200, 30));
                campo2.setMaximumSize(new Dimension(200, 30));
                campo3.setMaximumSize(new Dimension(200, 30));
                campo4.setMaximumSize(new Dimension(200, 30));

                panelBotones.add(Box.createVerticalStrut(20));
                panelBotones.add(new JLabel("Definir nombre"));
                panelBotones.add(campo1);
                panelBotones.add(Box.createVerticalStrut(10));
                panelBotones.add(new JLabel("Definir email"));
                panelBotones.add(campo2);
                panelBotones.add(Box.createVerticalStrut(10));
                panelBotones.add(new JLabel("definir teléfono"));
                panelBotones.add(campo3);
                panelBotones.add(Box.createVerticalStrut(10));
                panelBotones.add(Box.createVerticalStrut(20));
                panelBotones.add(guardarEquipo);
                panelBotones.add(Box.createVerticalStrut(10));
                panelBotones.add(volverEquipo);

                revalidate();
                repaint();
            }

            if (e.getSource() == volverEquipo) {
                panelBotones.removeAll();

                panelBotones.add(botonEquipo);
                panelBotones.add(Box.createVerticalStrut(15));
                panelBotones.add(botonJugador);
                panelBotones.add(Box.createVerticalStrut(15));
                panelBotones.add(botonVolver);

                revalidate();
                repaint();
            }

            if (e.getSource() == botonJugador) {
                panelBotones.removeAll();

                guardarJugador = new JButton("Guardar jugador");
                guardarJugador.addActionListener(this);
                volverJugador = new JButton("Volver");
                volverJugador.addActionListener(this);

                campo1Jugador = new JTextField(15);
                campo2Jugador = new JTextField(15);
                campo3Jugador = new JTextField(15);
                campo4Jugador = new JTextField(15);
                campo5Jugador = new JTextField(15);

                campo1Jugador.setMaximumSize(new Dimension(200, 30));
                campo2Jugador.setMaximumSize(new Dimension(200, 30));
                campo3Jugador.setMaximumSize(new Dimension(200, 30));
                campo4Jugador.setMaximumSize(new Dimension(200, 30));
                campo5Jugador.setMaximumSize(new Dimension(200, 30));

                panelBotones.add(Box.createVerticalStrut(20));
                panelBotones.add(new JLabel("Definir nombre"));
                panelBotones.add(campo1Jugador);
                panelBotones.add(Box.createVerticalStrut(10));
                panelBotones.add(new JLabel("Definir email"));
                panelBotones.add(campo2Jugador);
                panelBotones.add(Box.createVerticalStrut(10));
                panelBotones.add(new JLabel("definir teléfono"));
                panelBotones.add(campo3Jugador);
                panelBotones.add(Box.createVerticalStrut(10));
                panelBotones.add(new JLabel("definir dirección"));
                panelBotones.add(campo4Jugador);
                panelBotones.add(Box.createVerticalStrut(10));
                panelBotones.add(guardarJugador);
                panelBotones.add(Box.createVerticalStrut(10));
                panelBotones.add(volverJugador);

                revalidate();
                repaint();
            }

            if (e.getSource() == volverJugador) {
                panelBotones.removeAll();

                panelBotones.add(botonEquipo);
                panelBotones.add(Box.createVerticalStrut(15));
                panelBotones.add(botonJugador);
                panelBotones.add(Box.createVerticalStrut(15));
                panelBotones.add(botonVolver);

                revalidate();
                repaint();
            }
        }
    }
}
