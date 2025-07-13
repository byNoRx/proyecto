package vista;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelVerTorneos extends JPanel implements ActionListener {
    private String seleccionado;
    private JButton botonVerInfo;
    private JButton botonVolver;
    private JList<String> torneoList;
    private JPanel panelBotones2;

    public PanelVerTorneos(DefaultListModel<String> torneoModel) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel("Torneos ");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(titleLabel, BorderLayout.NORTH);

        torneoList = new JList<>(torneoModel);
        torneoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(torneoList);
        add(scrollPane, BorderLayout.CENTER);

        torneoList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    seleccionado = torneoList.getSelectedValue();
                    if (seleccionado != null) {
                        add(panelBotones2, BorderLayout.SOUTH); //
                        revalidate();
                        repaint();
                        System.out.println(seleccionado);
                    }
                }
            }
        });


        botonVerInfo = new JButton("Inscribir equipo");
        botonVerInfo.addActionListener(this);
        botonVolver = new JButton("Inscribir jugador");
        botonVolver.addActionListener(this);

        panelBotones2 = new JPanel();
        panelBotones2.setLayout(new BoxLayout(panelBotones2, BoxLayout.Y_AXIS));
        panelBotones2.setBackground(Color.LIGHT_GRAY);
        panelBotones2.add(Box.createVerticalStrut(20));

        Dimension botonSize = new Dimension(200, 40);
        JButton[] botones = {botonVerInfo,botonVolver };
        for (JButton boton : botones) {
            boton.setAlignmentX(Component.CENTER_ALIGNMENT);
            boton.setMaximumSize(botonSize);
            boton.addActionListener(this);
            panelBotones2.add(boton);
            panelBotones2.add(Box.createVerticalStrut(15));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}