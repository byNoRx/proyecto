package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCrearTorneo extends JPanel implements ActionListener {
    private JButton botonLista;

    private Checkbox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6;

    private JTextField textFieldNombre;
    private JTextField textFieldDisciplina;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel lowerPanel;

    public PanelCrearTorneo() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 900));

        // Crear grupos de checkboxes
        CheckboxGroup grupo1 = new CheckboxGroup();
        CheckboxGroup grupo2 = new CheckboxGroup();
        CheckboxGroup grupo3 = new CheckboxGroup();

        checkbox1 = new Checkbox("Formato1", grupo1, false);
        checkbox2 = new Checkbox("formato2", grupo1, false);
        checkbox3 = new Checkbox("Formato3", grupo1, false);
        checkbox3.setVisible(false);

        checkbox4 = new Checkbox("Eliminación simple", grupo2, false);
        checkbox5 = new Checkbox("Eliminación doble", grupo2, false);
        checkbox6 = new Checkbox("Liga", grupo2, false);



        // Panel superior con nombre y disciplina
        topPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        add(topPanel, BorderLayout.NORTH);

        botonLista = new JButton("Crear Torneo");
        botonLista.addActionListener(this);
        topPanel.add(botonLista);

        JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel nombreLabel = new JLabel("Nombre:");
        textFieldNombre = new JTextField(15);
        nombrePanel.add(nombreLabel);
        nombrePanel.add(textFieldNombre);
        topPanel.add(nombrePanel);

        JPanel disciplinaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelDisciplina = new JLabel("Disciplina:");
        textFieldDisciplina = new JTextField(15);
        disciplinaPanel.add(labelDisciplina);
        disciplinaPanel.add(textFieldDisciplina);
        topPanel.add(disciplinaPanel);

        // Panel central con checkboxes alineados en filas y columnas
        centerPanel = new JPanel(new GridLayout(2, 3, 20, 20));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Opciones de Formato"));
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setBackground(Color.LIGHT_GRAY);

        centerPanel.add(checkbox1);
        centerPanel.add(checkbox2);
        centerPanel.add(checkbox3);
        centerPanel.add(checkbox4);
        centerPanel.add(checkbox5);
        centerPanel.add(checkbox6);


        // Panel inferior
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
            updateScreen();
        }
    }
}