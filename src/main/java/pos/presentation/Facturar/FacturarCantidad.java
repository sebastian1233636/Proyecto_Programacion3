package pos.presentation.Facturar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacturarCantidad extends JDialog{
    private JTextField textField1;
    private JButton okButton;
    private JButton cancelarButton;


    Model model;
    Controller controller;


    public FacturarCantidad() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.getCurrent().setCantidad(Integer.parseInt(textField1.getText()));
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.getCurrent().setCantidad(0);
            }
        });
    }
}
