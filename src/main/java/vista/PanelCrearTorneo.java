package vista;

import modelo.FormatoEliminatoriaDirecta;
import modelo.FormatoLigaSimple;
import modelo.Torneo;
import modelo.TorneoBuilder;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class PanelCrearTorneo extends JPanel implements ActionListener {
    private JButton botonLista;
    private Checkbox checkbox4, checkbox6;
    private JTextField textFieldNombre;
    private JTextField textFieldDisciplina;
    private JTextField textFieldFecha;
    private JFormattedTextField textFieldDias;
    private JPanel topPanel, centerPanel, lowerPanel;
    private DefaultListModel<Torneo> torneoModel;

    public PanelCrearTorneo(DefaultListModel<Torneo> torneoModel) {
        this.torneoModel = torneoModel;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 900));

        CheckboxGroup grupo2 = new CheckboxGroup();
        checkbox4 = new Checkbox("Eliminatoria Directa", grupo2, true); // activado por defecto
        checkbox6 = new Checkbox("Liga", grupo2, false);

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
        JLabel fechaLabel = new JLabel(" Fecha de inicio (YYYY-MM-DD):");
        textFieldFecha = new JTextField(15);
        fechaPanel.add(fechaLabel);
        fechaPanel.add(textFieldFecha);
        topPanel.add(fechaPanel);

        JPanel diaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel diaLabel = new JLabel("Días entre rondas:");
        NumberFormat formato = NumberFormat.getIntegerInstance();
        formato.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(formato);
        formatter.setValueClass(Integer.class);
        formatter.setAllowsInvalid(false);
        formatter.setMinimum(1);
        textFieldDias = new JFormattedTextField(formatter);
        textFieldDias.setColumns(15);
        diaPanel.add(diaLabel);
        diaPanel.add(textFieldDias);
        topPanel.add(diaPanel);

        centerPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Opciones de Formato"));
        centerPanel.setBackground(Color.LIGHT_GRAY);
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(checkbox4);
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
            String disciplina = textFieldDisciplina.getText().trim();
            String fechaTexto = textFieldFecha.getText().trim();
            Object diasObj = textFieldDias.getValue();

            // Validación general
            if (nombre.isEmpty() || disciplina.isEmpty() || fechaTexto.isEmpty() || diasObj == null) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
                return;
            }

            LocalDate fecha;
            try {
                fecha = LocalDate.parse(fechaTexto);
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "La fecha debe estar en formato YYYY-MM-DD.");
                return;
            }

            int dias = ((Number) diasObj).intValue();

            TorneoBuilder torneoBuilder = new TorneoBuilder();
            torneoBuilder.setNombre(nombre);
            torneoBuilder.setDisciplina(disciplina);
            torneoBuilder.setFechaDeInicio(fecha);
            torneoBuilder.setDiasEntreRondas(dias);

            // Formato
            if (checkbox4.getState()) {
                torneoBuilder.setFormato(new FormatoEliminatoriaDirecta());
            } else if (checkbox6.getState()) {
                torneoBuilder.setFormato(new FormatoLigaSimple());
            } else {
                JOptionPane.showMessageDialog(this, "Formato no válido");
            }

            Torneo torneo = torneoBuilder.getResult();
            torneoModel.addElement(torneo);

            // Limpiar campos
            textFieldNombre.setText("");
            textFieldDisciplina.setText("");
            textFieldFecha.setText("");
            textFieldDias.setValue(null);
            JOptionPane.showMessageDialog(this, "Torneo creado exitosamente.");

            updateScreen();
        }
    }
}
