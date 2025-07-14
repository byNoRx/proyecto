package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa un panel que se usa para crear torneos
 */
public class PanelCrearTorneo extends JPanel implements ActionListener {
    private JButton botonLista;

    private Checkbox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6;

    private JTextField textFieldNombre;
    private JTextField textFieldDisciplina;
    private JTextField textFieldFecha;
    private JTextField textFieldDias;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel lowerPanel;
    private DefaultListModel<String> torneoModel;

    /**
     * Metodo constructor
     *
     * @param torneoModel
     */
    public PanelCrearTorneo(DefaultListModel<String> torneoModel) {
        this.torneoModel = torneoModel;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 900));

        CheckboxGroup grupo2 = new CheckboxGroup();


        checkbox4 = new Checkbox("Eliminatoria Directa", grupo2, false);
        //checkbox5 = new Checkbox("Eliminación doble", grupo2, false);
        checkbox6 = new Checkbox("Liga", grupo2, false);

        // Panel superior con nombre y disciplina
        topPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        add(topPanel, BorderLayout.NORTH);

        botonLista = new JButton("Crear Torneo");
        botonLista.addActionListener(this);
        topPanel.add(botonLista);

        JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel nombreLabel = new JLabel("             Nombre:");
        textFieldNombre = new JTextField(15);
        nombrePanel.add(nombreLabel);
        nombrePanel.add(textFieldNombre);
        topPanel.add(nombrePanel);

        JPanel disciplinaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelDisciplina = new JLabel("       Disciplina:");
        textFieldDisciplina = new JTextField(15);
        disciplinaPanel.add(labelDisciplina);
        disciplinaPanel.add(textFieldDisciplina);
        topPanel.add(disciplinaPanel);

        JPanel fechaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel fechaLabel = new JLabel(" Fecha de inicio:");
        textFieldFecha = new JTextField(15);
        fechaPanel.add(fechaLabel);
        fechaPanel.add(textFieldFecha);
        topPanel.add(fechaPanel);

        JPanel diaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel diaLabel = new JLabel("Dias entre partido:");
        textFieldDias = new JTextField(15);
        diaPanel.add(diaLabel);
        diaPanel.add(textFieldDias);
        topPanel.add(diaPanel);

        centerPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Opciones de Formato"));
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setBackground(Color.LIGHT_GRAY);

        centerPanel.add(checkbox4);
        //centerPanel.add(checkbox5);
        centerPanel.add(checkbox6);

        lowerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lowerPanel.setBackground(Color.BLACK);
        add(lowerPanel, BorderLayout.SOUTH);
    }

    private void updateScreen() {
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonLista) {
        String nombre = textFieldNombre.getText().trim();

        if (!nombre.isEmpty()) {
            torneoModel.addElement(nombre);
            textFieldNombre.setText("");
            JOptionPane.showMessageDialog(this,"torneo creado");
        } else {
            JOptionPane.showMessageDialog(this, "El campo de nombre está vacío.");
        }

        updateScreen();
        }
    }
}