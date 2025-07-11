import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCrearTorneo extends JPanel implements ActionListener {
    private JButton botonLista;
    private JButton avanzar;
    private JButton atras;
    private int contador = 0;

    private JTextField textField;
    private JPanel topPanel;
    private JPanel centerPanel;

    public PanelCrearTorneo() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 600));

        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(topPanel, BorderLayout.NORTH);

        centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);

        botonLista = new JButton("Crear Torneo");
        avanzar = new JButton("Avanzar");
        atras = new JButton("Atras");

        botonLista.addActionListener(this);
        avanzar.addActionListener(this);
        atras.addActionListener(this);

        topPanel.add(botonLista);

        textField = new JTextField(20);
        textField.setHorizontalAlignment(JTextField.CENTER);
    }

    private void updateScreen() {
        centerPanel.removeAll();

        switch (contador) {
            case 0:
                topPanel.removeAll();
                topPanel.add(botonLista);
                break;
            case 1:
                topPanel.removeAll();
                topPanel.add(atras);
                topPanel.add(avanzar);
                // Show text field in center
                centerPanel.add(new JLabel("NOMBRE TORNEO:"));
                centerPanel.add(textField);
                break;
            case 2:
                topPanel.removeAll();
                topPanel.add(atras);
                topPanel.add(avanzar);
                centerPanel.add(new JLabel("Pantalla 2"));
                break;
            case 3:
                topPanel.removeAll();
                topPanel.add(atras);
                centerPanel.add(new JLabel("Pantalla Final"));
                break;
        }

        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonLista) {
            contador = 1;
            updateScreen();
        } else if (e.getSource() == avanzar) {
            if (contador < 3) {
                contador++;
                updateScreen();
            }
        } else if (e.getSource() == atras) {
            if (contador > 1) {
                contador--;
                updateScreen();
            } else {
                contador = 0;
                updateScreen();
            }
        }
    }
}