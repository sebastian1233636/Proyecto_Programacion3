package pos.presentation.Facturar;

import pos.Application;
import pos.logic.Cajero;
import pos.logic.Cliente;
import pos.logic.Producto;
import pos.logic.Service;
import pos.presentation.Facturar.TableModel;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;


public class view implements PropertyChangeListener {
    private JPanel JpanelCliente;
    private JPanel JpanelCajero;
    private JPanel JpanelComboBoxes;
    private JComboBox comboBoxClientes;
    private JComboBox comboBoxCajeros;
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

    public JPanel getPanel() {
        return panel;
    }

    public view() {
        buttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Producto filter = new Producto();
                    filter.setCodigo(search.getText());
                    controller.AgregarLinea(controller.BuscarProducto(filter));

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        buttonCobrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FacturarCobrar subventana = new FacturarCobrar();
                subventana.setModel(model);
                subventana.setVisible(true);
                subventana.setModal(true);
                subventana.pack();
            }
        });


        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonBuscar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Service service = Service.instance();
                        FacturarBuscar buscar = new FacturarBuscar(service);
                        buscar.setVisible(true);
                    }
                });

            }
        });

        buttonCantidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FacturarCantidad subventanaCant = new FacturarCantidad();
                subventanaCant.setModel(model);
                subventanaCant.setVisible(true);
                subventanaCant.setModal(true);
                subventanaCant.pack();
            }
        });


        buttonQuitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.BorrarLinea();
                    JOptionPane.showMessageDialog(panel, "REGISTRO BORRADO", "", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = list.getSelectedRow();
                controller.edit(row);
            }
        });
        buttonDescuento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FacturarDescuento facDes = new FacturarDescuento();
                facDes.setModel(model);
                facDes.setVisible(true);
                facDes.setModal(true);
                facDes.pack();
            }
        });

        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.cancelar();
            }
        });
    }

    Model model;
    Controller controller;

    public void setModel(Model model) {
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    public void setController(Controller controller) {this.controller = controller;}

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Model.LISTLINEAS:
                // Actualizar la tabla de líneas
                int[] cols = {TableModel.CODIGO, TableModel.ARTICULO, TableModel.CATEGORIA, TableModel.CANTIDAD, TableModel.PRECIO, TableModel.DESCUENTO, TableModel.NETO, TableModel.IMPORTE};
                list.setModel(new TableModel(cols, model.getLineas()));
                list.setRowHeight(30);
                TableColumnModel columnModel = list.getColumnModel();
                columnModel.getColumn(1).setPreferredWidth(150);
                columnModel.getColumn(1).setPreferredWidth(150);
                break;
            case Model.FILTER:
                search.setText(model.getFilter().getCodigo());
                break;
        }
        this.panel.revalidate();
    }
}