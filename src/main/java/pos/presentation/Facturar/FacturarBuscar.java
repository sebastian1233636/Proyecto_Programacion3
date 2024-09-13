package pos.presentation.Facturar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import pos.logic.Producto;
import pos.logic.Service;

public class FacturarBuscar extends JDialog {
    private JTextField textField1;
    private JButton buscarButton;
    private JTable table1;
    private JPanel panel;
    private Service service;

    public FacturarBuscar(Service service) {
        this.service = service;
        setContentPane(panel);
        setModal(true);
        pack();

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProductos();
            }
        });
        table1.setModel(new DefaultTableModel(new Object[]{"Código", "Descripción", "Precio", "Existencias"}, 0));
    }

    private void buscarProductos() {
        String descripcion = textField1.getText();
        Producto filtro = new Producto();

        if (descripcion != null && !descripcion.isEmpty()) {filtro.setDescripcion(descripcion);}
        else {
            JOptionPane.showMessageDialog(null, "La descripción no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            List<Producto> productos = service.searchDescripcion(filtro);

            if (productos.isEmpty()) { throw new Exception("No se encontraron productos con la descripción: " + descripcion); }

            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);
            for (Producto producto : productos) {
                model.addRow(new Object[]{
                        producto.getCodigo(),
                        producto.getDescripcion(),
                        producto.getPrecioUnitario(),
                        producto.getExistencias()
                });
            }
        } catch (Exception ex) {JOptionPane.showMessageDialog(null, "Error al buscar productos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);}
    }
}