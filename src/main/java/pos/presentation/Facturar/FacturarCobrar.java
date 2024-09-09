package pos.presentation.Facturar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacturarCobrar extends JDialog {
    private JTextField textEfectivo;
    private JTextField textTarjeta;
    private JTextField textCheque;
    private JTextField textSimpe;
    private JLabel importe;
    private JButton okButton;
    private JButton cancelarButton;

    Model model;
    Controller controller;

    public FacturarCobrar() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double efectivo = Double.parseDouble(textEfectivo.getText());
                double tarjeta = Double.parseDouble(textTarjeta.getText());
                double cheque = Double.parseDouble(textCheque.getText());
                double simpe = Double.parseDouble(textSimpe.getText());
                double importeValue = Double.parseDouble(importe.getText());
                if(efectivo > importeValue){
                    JOptionPane.showMessageDialog(null, "El pago se ha efectuado correctamente.", "Pago Exitoso", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "El efectivo no es suficiente para cubrir el importe.", "Error de Pago", JOptionPane.WARNING_MESSAGE);
                }

                if(tarjeta > importeValue){
                    JOptionPane.showMessageDialog(null, "El pago se ha efectuado correctamente.", "Pago Exitoso", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "La tarjeta no es suficiente para cubrir el importe.", "Error de Pago", JOptionPane.WARNING_MESSAGE);
                }

                if(cheque > importeValue){
                    JOptionPane.showMessageDialog(null, "El pago se ha efectuado correctamente.", "Pago Exitoso", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "El cheque no es suficiente para cubrir el importe.", "Error de Pago", JOptionPane.WARNING_MESSAGE);
                }
                if(simpe > importeValue){
                    JOptionPane.showMessageDialog(null, "El pago se ha efectuado correctamente.", "Pago Exitoso", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "El sinpe no es suficiente para cubrir el importe.", "Error de Pago", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public void setImporte(){
        double pagoTotal = controller.calcularPagoTotal();
        String pagoTotalStr = String.valueOf(pagoTotal);
        importe.setText(pagoTotalStr);
    }


}
