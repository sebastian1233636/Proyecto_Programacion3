package pos.presentation.Facturar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacturarDescuento extends JDialog {
    private JTextField textField1;
    private JButton okButton;
    private JButton cancelarButton;


    Model model;
    Controller controller;

    public FacturarDescuento() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double descuento = Double.parseDouble(textField1.getText());
                model.getCurrent().setDescuento(descuento);
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.getCurrent().setDescuento(0.0);
            }
        });
    }
}
