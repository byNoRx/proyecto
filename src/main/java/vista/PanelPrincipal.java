package vista;

import modelo.FormatoEliminatoriaDirecta;
import modelo.FormatoTorneo;
import modelo.Torneo;
import modelo.TorneoBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que representa un panel con una lista de botones interactuables,
 * para principalmentecrear, eliminar y gestionar torneos
 */
public class PanelPrincipal extends JPanel implements ActionListener {

    // Declarar paneles
    private JPanel BigPanel, panel1, panel2, BigPanel2, panel3, BigPanel3, panel4, BigPanel4, panel5, BigPanel5,panel6, BigPanel6;

    // Declarar botones
    private JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, boton10;

    // Declarar lista de torneos
    public ArrayList<Torneo> torneos = new ArrayList<>();

    /**
     * Metodo constructor
     */
    public PanelPrincipal() {
        DefaultListModel<Torneo> modeloCompartido = new DefaultListModel<>();

        /*
        TorneoBuilder torneoBuilder = new TorneoBuilder();
        torneoBuilder.setNombre("Torneo");
        torneoBuilder.setFormato(new FormatoEliminatoriaDirecta());
        torneoBuilder.setDisciplina("Disciplina");
        torneoBuilder.setFechaDeInicio(LocalDate.now());
        torneoBuilder.setDiasEntreRondas(1);
        Torneo torneo = torneoBuilder.getResult();
        modeloCompartido.addElement(torneo);
        */

        //modeloCompartido.addElement("Torneo A");
        //modeloCompartido.addElement("Torneo B");
        //modeloCompartido.addElement("Torneo C");
        //modeloCompartido.addElement("Torneo D");

        PanelLista panelLista = new PanelLista(modeloCompartido);
        PanelEliminarTorneos panelEliminar = new PanelEliminarTorneos(modeloCompartido);

        setLayout(new BorderLayout());
        setBackground(Color.white);

        BigPanel = new JPanel();

        panel2 = new PanelLista(modeloCompartido);
        BigPanel2 = new JPanel();
        BigPanel2.setPreferredSize(new Dimension(700, 700));

        BigPanel3 = new JPanel();
        BigPanel3.setPreferredSize(new Dimension(700, 700));

        BigPanel5=new JPanel();

        BigPanel6=new JPanel();

        panel3 = new PanelCrearTorneo(modeloCompartido);


        panel4 = new PanelEliminarTorneos(modeloCompartido);

        panel5 = new PanelGestionarTorneos(modeloCompartido);

        panel6 = new PanelVerTorneos(modeloCompartido);


        BigPanel4 = new JPanel();
        BigPanel3.setPreferredSize(new Dimension(700, 700));

        panel1 = new JPanel(new GridLayout(0, 1, 100, 50));
        boton1 = new JButton("Ver lista de torneos");
        boton1.addActionListener(this);


        boton2 = new JButton("crear torneo");
        boton2.addActionListener(this);


        boton3 = new JButton("Eliminar torneo");
        boton3.addActionListener(this);

        boton4 = new JButton("Gestor de torneos");
        boton4.addActionListener(this);


        boton5 = new JButton("Ver torneo");
        boton5.addActionListener(this);


        add(BigPanel, BorderLayout.WEST);
        add(BigPanel2, BorderLayout.CENTER);
        BigPanel.setPreferredSize(new Dimension(400, 400));

        BigPanel.add(panel1);
        BigPanel2.add(panel2);
        BigPanel3.add(panel3);
        BigPanel4.add(panel4);
        BigPanel5.add(panel5);
        BigPanel6.add(panel6);
        BigPanel.setBackground(Color.GRAY);

        panel1.add(boton1);
        panel1.add(boton2);
        panel1.add(boton3);
        panel1.add(boton4);
        panel1.add(boton5);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            this.removeAll();
            this.add(BigPanel, BorderLayout.WEST);
            this.add(BigPanel2, BorderLayout.CENTER);

            SwingUtilities.updateComponentTreeUI(this);
        }
        if (e.getSource() == boton2) {
            this.removeAll();
            this.add(BigPanel, BorderLayout.WEST);
            this.add(BigPanel3, BorderLayout.CENTER);


            SwingUtilities.updateComponentTreeUI(this);
        }
        if (e.getSource() == boton3) {
            this.removeAll();
            this.add(BigPanel, BorderLayout.WEST);
            this.add(BigPanel4, BorderLayout.CENTER);


            SwingUtilities.updateComponentTreeUI(this);
        }
        if (e.getSource() == boton4) {
            this.removeAll();
            this.add(BigPanel, BorderLayout.WEST);
            this.add(BigPanel5, BorderLayout.CENTER);


            SwingUtilities.updateComponentTreeUI(this);
        }
        if (e.getSource() == boton5) {
            this.removeAll();
            this.add(BigPanel, BorderLayout.WEST);
            this.add(BigPanel6, BorderLayout.CENTER);

            SwingUtilities.updateComponentTreeUI(this);
        }
    }
}

