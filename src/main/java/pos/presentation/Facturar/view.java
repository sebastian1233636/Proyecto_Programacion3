package pos.presentation.Facturar;

import pos.logic.Producto;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.util.List;


public class view {
    private JPanel JpanelCliente;
    private JPanel JpanelCajero;
    private JPanel JpanelComboBoxes;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JPanel PanelListado;
    private JTextField search;
    private JButton buttonAgregar;
    private JPanel PanelBotones;
    private JButton buttonCobrar;
    private JButton buttonBuscar;
    private JButton buttonCantidad;
    private JButton buttonQuitar;
    private JButton buttonDescuento;
    private JButton buttonCancelar;
    private JLabel LabelArticulos;
    private JLabel SubtotalLabel;
    private JLabel LabelDescuento;
    private JLabel textArea1;
    private JLabel dLabel;
    private JLabel textArea3;
    private JLabel textArea4;
    private JTable list;
    private JPanel panel;
    public JPanel getPanel() {return panel;}
    public JComboBox<String> getComboBox1() { return comboBox1;}
    public JComboBox<String> getComboBox2() { return comboBox2; }

    Model model;
    Controller controller;

    public void actualizarComboBox(JComboBox<String> comboBox, List<String> items) {
        comboBox.removeAllItems();
        for (String item : items) {
            comboBox.addItem(item);
        }
    }

    public view() {
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Producto filter = new Producto();
                    filter.setCodigo(search.getText());
                    controller.AgregarLinea(filter);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = list.getSelectedRow();
            }
        });

        buttonQuitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.delete();
                    JOptionPane.showMessageDialog(panel, "REGISTRO BORRADO", "", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.clear();
            }
        });
    }

    public void setModel(Model model) {
        this.model = model;
        model.addPropertyChangeListener(this::propertyChange);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Model.LISTLINEAS:
                int[] cols = {TableModel.CODIGO, TableModel.ARTICULO, TableModel.CATEGORIA, TableModel.CANTIDAD, TableModel.PRECIO, TableModel.DESCUENTO, TableModel.NETO, TableModel.IMPORTE};
                list.setModel(new TableModel(cols, model.getLineas()));
                list.setRowHeight(30);
                TableColumnModel columnModel = list.getColumnModel();
                break;
            case Model.CURRENT:
                break;
            case Model.FILTER:
                search.setText(model.getFilter().getCodigo());
                break;
        }
        this.panel.revalidate();
    }
}