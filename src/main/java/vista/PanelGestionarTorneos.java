package vista;

import modelo.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel para gestionar torneos: inscribir participantes, generar partidos y registrar resultados.
 */
public class PanelGestionarTorneos extends JPanel implements ActionListener {
    private JButton botonCrear, botonListar, botonEliminar, botonResult;
    private JButton botonJugador, botonVolver;
    private JButton guardarEquipo, volverEquipo;
    private JButton guardarJugador, volverJugador;
    private JButton guardarResultado, volverResultado;
    private JButton volverJugadorEquipo;

    private JList<Torneo> torneoList;
    private Torneo torneoSeleccionado;

    private JPanel panelBotones;

    private JTextField campo1, campo2, campo3;
    private JTextField campo1Jugador, campo2Jugador, campo3Jugador, campo4Jugador;
    private JTextField campoNumeroPartido, campoPuntajeA, campoPuntajeB;
    private JTextField campoNombreJugadorEquipo, campoEmailJugadorEquipo, campoTelefonoJugadorEquipo, campoDireccionJugadorEquipo;
    private JCheckBox checkTerminarPartido;

    public PanelGestionarTorneos(DefaultListModel<Torneo> torneoModel) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 800));
        setBackground(Color.LIGHT_GRAY);

        // Lista de torneos
        JPanel panelLista = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Torneos", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panelLista.add(titleLabel, BorderLayout.NORTH);

        torneoList = new JList<>(torneoModel);
        torneoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        torneoList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    torneoSeleccionado = torneoList.getSelectedValue();
                    if (torneoSeleccionado != null && !isAncestorOf(panelBotones)) {
                        add(panelBotones, BorderLayout.SOUTH);
                        refrescarPanel();
                    }
                }
            }
        });
        panelLista.add(new JScrollPane(torneoList), BorderLayout.CENTER);
        add(panelLista, BorderLayout.CENTER);

        // Panel de botones
        panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(Color.LIGHT_GRAY);
        panelBotones.add(Box.createVerticalStrut(20));

        botonCrear = new JButton("Ver lista de participantes");
        botonListar = new JButton("Inscribir participantes");
        botonEliminar = new JButton("Generar partidos");
        botonResult = new JButton("Registrar resultados");

        JButton[] botones = {botonCrear, botonListar, botonEliminar, botonResult};
        Dimension botonSize = new Dimension(200, 40);
        for (JButton boton : botones) {
            boton.setAlignmentX(Component.CENTER_ALIGNMENT);
            boton.setMaximumSize(botonSize);
            boton.addActionListener(this);
            panelBotones.add(boton);
            panelBotones.add(Box.createVerticalStrut(15));
        }

        // Botones adicionales
        botonJugador = new JButton("Inscribir jugador");
        botonJugador.addActionListener(this);
        botonVolver = new JButton("Volver");
        botonVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (torneoSeleccionado == null) return;

        if (e.getSource() == botonListar) {
            mostrarBotonesParticipante();

        } else if (e.getSource() == botonVolver) {
            restaurarBotonesIniciales();

        } else if (e.getSource() == guardarEquipo) {
            EquipoBuilder builder = new EquipoBuilder();
            builder.setNombre(campo1.getText());
            builder.setEmail(campo2.getText());
            builder.setTelefono(campo3.getText());
            Equipo equipo = builder.getResult();

            torneoSeleccionado.addParticipante(equipo);
            JOptionPane.showMessageDialog(this, "Equipo guardado: " + equipo.getNombre());
            mostrarBotonesParticipante();

        } else if (e.getSource() == volverEquipo) {
            mostrarBotonesParticipante();

        } else if (e.getSource() == botonJugador) {
            mostrarFormularioJugador();

        } else if (e.getSource() == guardarJugador) {
            JugadorBuilder builder = new JugadorBuilder();
            builder.setNombre(campo1Jugador.getText());
            builder.setEmail(campo2Jugador.getText());
            builder.setTelefono(campo3Jugador.getText());
            builder.setDireccion(campo4Jugador.getText());
            Jugador jugador = builder.getResult();

            torneoSeleccionado.addParticipante(jugador);
            JOptionPane.showMessageDialog(this, "Jugador guardado: " + jugador.getNombre());
            mostrarBotonesParticipante();

        } else if (e.getSource() == volverJugador) {
            mostrarBotonesParticipante();

        } else if (e.getSource() == botonCrear) {
            JOptionPane.showMessageDialog(this, torneoSeleccionado.getParticipantes().toString());

        } else if (e.getSource() == botonEliminar) {
            try {
                torneoSeleccionado.generarPartidos();
                JOptionPane.showMessageDialog(this, "Partidos generados correctamente");
            } catch (ParticipantesInsuficientesException ex) {
                JOptionPane.showMessageDialog(this, "No hay suficientes participantes para generar partidos.");
            }

        } else if (e.getSource() == botonResult) {
            mostrarFormularioResultado();

        } else if (e.getSource() == guardarResultado) {
            try {
                int numero = Integer.parseInt(campoNumeroPartido.getText()) - 1;
                int puntosA = Integer.parseInt(campoPuntajeA.getText());
                int puntosB = Integer.parseInt(campoPuntajeB.getText());

                if (numero < 0 || numero >= torneoSeleccionado.getPartidos().size()) {
                    JOptionPane.showMessageDialog(this, "Número de partido inválido");
                    return;
                }

                Partido partido = torneoSeleccionado.getPartidos().get(numero);
                partido.setPuntajeA(puntosA);
                partido.setPuntajeB(puntosB);
                partido.setTerminado(checkTerminarPartido.isSelected());

                JOptionPane.showMessageDialog(this, "Resultado guardado para partido " + (numero + 1));
                restaurarBotonesIniciales();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al ingresar los datos del resultado.");
            }

        } else if (e.getSource() == volverResultado) {
            restaurarBotonesIniciales();

        } else if (e.getSource() == volverJugadorEquipo) {
            mostrarBotonesParticipante();
        }
    }

    private void mostrarBotonesParticipante() {
        panelBotones.removeAll();
        panelBotones.add(botonJugador);
        panelBotones.add(Box.createVerticalStrut(15));
        panelBotones.add(botonVolver);
        refrescarPanel();
    }

    private void restaurarBotonesIniciales() {
        panelBotones.removeAll();
        JButton[] botones = {botonCrear, botonListar, botonEliminar, botonResult};
        for (JButton boton : botones) {
            panelBotones.add(boton);
            panelBotones.add(Box.createVerticalStrut(15));
        }
        refrescarPanel();
    }

    private void mostrarFormularioJugador() {
        panelBotones.removeAll();

        campo1Jugador = new JTextField(15);
        campo2Jugador = new JTextField(15);
        campo3Jugador = new JTextField(15);
        campo4Jugador = new JTextField(15);

        guardarJugador = new JButton("Guardar jugador");
        guardarJugador.addActionListener(this);
        volverJugador = new JButton("Volver");
        volverJugador.addActionListener(this);

        panelBotones.add(new JLabel("Nombre"));
        panelBotones.add(campo1Jugador);
        panelBotones.add(new JLabel("Email"));
        panelBotones.add(campo2Jugador);
        panelBotones.add(new JLabel("Teléfono"));
        panelBotones.add(campo3Jugador);
        panelBotones.add(new JLabel("Dirección"));
        panelBotones.add(campo4Jugador);
        panelBotones.add(Box.createVerticalStrut(10));
        panelBotones.add(guardarJugador);
        panelBotones.add(Box.createVerticalStrut(5));
        panelBotones.add(volverJugador);

        refrescarPanel();
    }

    private void mostrarFormularioResultado() {
        panelBotones.removeAll();

        campoNumeroPartido = new JTextField(5);
        campoPuntajeA = new JTextField(5);
        campoPuntajeB = new JTextField(5);
        checkTerminarPartido = new JCheckBox("Marcar partido como terminado");

        guardarResultado = new JButton("Guardar resultado");
        guardarResultado.addActionListener(this);
        volverResultado = new JButton("Volver");
        volverResultado.addActionListener(this);

        panelBotones.add(new JLabel("Número del partido"));
        panelBotones.add(campoNumeroPartido);
        panelBotones.add(new JLabel("Puntaje equipo A:"));
        panelBotones.add(campoPuntajeA);
        panelBotones.add(new JLabel("Puntaje equipo B:"));
        panelBotones.add(campoPuntajeB);
        panelBotones.add(Box.createVerticalStrut(10));
        panelBotones.add(checkTerminarPartido);
        panelBotones.add(Box.createVerticalStrut(10));
        panelBotones.add(guardarResultado);
        panelBotones.add(Box.createVerticalStrut(5));
        panelBotones.add(volverResultado);

        refrescarPanel();
    }

    private void refrescarPanel() {
        revalidate();
        repaint();
    }
}
