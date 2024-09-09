package pos.presentation.Facturar;

import pos.Application;
import pos.logic.Producto;
import pos.presentation.Facturar.TableModel;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


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

    public view() {
        buttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Producto filter = new Producto();
                    filter.setDescripcion(search.getText());
                   controller.AgregarLinea(controller.BuscarProducto(filter));

                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        buttonCobrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //aqui va lo que pasa cuando se selecciona cobrar
                FacturarCobrar subventana = new FacturarCobrar();
                subventana.setVisible(true);

            }
        });


        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aqui se despliega la subventana de buscar
            }
        });


        buttonCantidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FacturarCantidad subventanaCant = new FacturarCantidad();
                subventanaCant.setVisible(true);
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
                facDes.setVisible(true);
            }
        });
        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.cancelar();
            }
        });
    }

    public JPanel getPanel() {return panel;}




    Model model;
    Controller controller;

    public void setModel(pos.presentation.Facturar.Model model) {
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    public void setController(pos.presentation.Facturar.Controller controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case pos.presentation.Facturar.Model.LISTLINEAS:
                int[] cols = {pos.presentation.Facturar.TableModel.CODIGO,pos.presentation.Facturar.TableModel.ARTICULO,pos.presentation.Facturar.TableModel.CATEGORIA,pos.presentation.Facturar.TableModel.CANTIDAD,pos.presentation.Facturar.TableModel.PRECIO,pos.presentation.Facturar.TableModel.DESCUENTO,pos.presentation.Facturar.TableModel.NETO,pos.presentation.Facturar.TableModel.IMPORTE };
                list.setModel(new TableModel(cols, model.getLineas()));
                list.setRowHeight(30);
                TableColumnModel columnModel = list.getColumnModel();
                columnModel.getColumn(1).setPreferredWidth(150);
                columnModel.getColumn(1).setPreferredWidth(150);
                break;

            case pos.presentation.Facturar.Model.LISTCLIENTES:
                controller.loadClientes();
                break;


            case pos.presentation.Facturar.Model.LISTCAJEROS:
                controller.loadCajeros();
                break;

            case pos.presentation.Cajero.Model.CURRENT:
                /*id.setText(model.getCurrent().getID());
                nombre.setText(model.getCurrent().getNombre());

                if (model.getMode() == Application.MODE_EDIT) {
                    id.setEnabled(false);
                    delete.setEnabled(true);
                } else {
                    id.setEnabled(true);
                    delete.setEnabled(false);
                }
                idLbl.setBorder(null);
                idLbl.setToolTipText(null);
                nombreLbl.setBorder(null);
                nombreLbl.setToolTipText(null);*/
                break;

            case pos.presentation.Facturar.Model.FILTER:
                search.setText(model.getFilter().getDescripcion());
                break;
        }
        this.panel.revalidate();
    }


}
