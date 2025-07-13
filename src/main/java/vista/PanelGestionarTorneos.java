package vista;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelGestionarTorneos extends JPanel implements ActionListener {
    private JButton botonCrear, botonListar, botonEliminar, botonEditar, botonSalir;
    private JList<String> torneoList;
    private String seleccionado;
    private JPanel panelBotones;

    public PanelGestionarTorneos(DefaultListModel<String> torneoModel) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 800));
        setBackground(Color.LIGHT_GRAY);


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
                    seleccionado = torneoList.getSelectedValue();
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
        botonSalir = new JButton("Registrar resultados");

        Dimension botonSize = new Dimension(200, 40);
        JButton[] botones = { botonCrear, botonListar, botonEliminar, botonEditar, botonSalir };
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
        }
    }
}
