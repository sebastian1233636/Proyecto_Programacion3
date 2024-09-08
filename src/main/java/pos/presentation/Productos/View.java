package pos.presentation.Productos;

import pos.Application;
import pos.logic.Categoria;
import pos.logic.Producto;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View implements PropertyChangeListener {
    private JPanel panel;
    private JLabel searchProductoLbl;
    private JTextField searchProducto;
    private JButton report;
    private JButton search;
    private JTable list;
    private JLabel codigoLbl;
    private JTextField codigo;
    private JLabel descripciónLbl;
    private JTextField descripción;
    private JLabel unidadLbl;
    private JTextField unidad;
    private JLabel preciobl;
    private JTextField precio;
    private JLabel categoriaLbl;
    private JComboBox categoria;
    private JButton save;
    private JButton delete;
    private JButton clear;
    private JTextField existencias;
    private JLabel existenciasLbl;

    public JPanel getPanel() {
        return panel;
    }

    private void Categories() {
        categoria.addItem("CAT-001-Dulces");
        categoria.addItem("CAT-002-Vinos");
        categoria.addItem("CAT-003-Basico");
        categoria.addItem("CAT-004-Hogar");
    }

    public View() {
        Categories();
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Producto filter = new Producto();
                    filter.setCodigo(searchProducto.getText());
                    filter.setDescripcion(searchProducto.getText());
                    controller.search(filter);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validate()) {
                    Producto n = take();
                    try {
                        controller.save(n);
                        JOptionPane.showMessageDialog(panel, "REGISTRO APLICADO", "", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = list.getSelectedRow();
                controller.edit(row);
            }
        });

        delete.addActionListener(new ActionListener() {
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

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.clear();
            }
        });
    }

    private boolean validate() {
        boolean valid = true;
        if (codigo.getText().isEmpty()) {
            valid = false;
            codigoLbl.setBorder(Application.BORDER_ERROR);
            JOptionPane.showMessageDialog(panel, "Codigo requerido", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            codigoLbl.setBorder(null);
            codigoLbl.setToolTipText(null);
        }

        if (descripción.getText().isEmpty()) {
            valid = false;
            descripciónLbl.setBorder(Application.BORDER_ERROR);
            JOptionPane.showMessageDialog(panel, "Descripción requerida", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            descripciónLbl.setBorder(null);
            descripciónLbl.setToolTipText(null);
        }

        if (unidad.getText().isEmpty()) {
            valid = false;
            unidadLbl.setBorder(Application.BORDER_ERROR);
            JOptionPane.showMessageDialog(panel, "Unidad requerida", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            unidadLbl.setBorder(null);
            unidadLbl.setToolTipText(null);
        }

        try {
            Float.parseFloat(precio.getText());
            preciobl.setBorder(null);
            preciobl.setToolTipText(null);
        } catch (Exception e) {
            valid = false;
            preciobl.setBorder(Application.BORDER_ERROR);
            JOptionPane.showMessageDialog(panel, "Coloque un valor válido para precio", "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {
            Integer.parseInt(existencias.getText());
            existenciasLbl.setBorder(null);
            existenciasLbl.setToolTipText(null);
        } catch (Exception e) {
            valid = false;
            existenciasLbl.setBorder(Application.BORDER_ERROR);
            JOptionPane.showMessageDialog(panel, "Coloque un valor válido para existencias", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return valid;
    }

    public Producto take() {
        Producto p = new Producto();
        p.setCodigo(codigo.getText());
        p.setDescripcion(descripción.getText());
        p.setUnidadMedida(unidad.getText());
        p.setPrecioUnitario(Double.parseDouble(precio.getText()));
        p.setCategoria(new Categoria((String) categoria.getSelectedItem()));
        p.setExistencias(Integer.parseInt(existencias.getText()));
        return p;
    }

    // MVC
    Model model;
    Controller controller;

    public void setModel(Model model) {
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Model.LIST:
                int[] cols = {TableModel.CODIGO, TableModel.DESCRIPCION, TableModel.UNIDAD_MEDIDA, TableModel.PRECIO_UNITARIO, TableModel.CATEGORIA, TableModel.EXISTENCIAS};
                list.setModel(new TableModel(cols, model.getList()));
                list.setRowHeight(30);
                TableColumnModel columnModel = list.getColumnModel();
                columnModel.getColumn(2).setPreferredWidth(100);
                columnModel.getColumn(4).setPreferredWidth(100);
                break;
            case Model.CURRENT:
                codigo.setText(model.getCurrent().getCodigo());
                descripción.setText(model.getCurrent().getDescripcion());
                unidad.setText(model.getCurrent().getUnidadMedida());
                precio.setText("" + model.getCurrent().getPrecioUnitario());
                Categoria categoriaObj = model.getCurrent().getCategoria();
                existencias.setText("" + model.getCurrent().getExistencias());
                if (model.getMode() == Application.MODE_EDIT) {
                    codigo.setEnabled(false);
                    delete.setEnabled(true);
                } else {
                    codigo.setEnabled(true);
                    delete.setEnabled(false);
                }
                codigoLbl.setBorder(null);
                codigoLbl.setToolTipText(null);
                descripciónLbl.setBorder(null);
                descripciónLbl.setToolTipText(null);
                unidadLbl.setBorder(null);
                unidadLbl.setToolTipText(null);
                preciobl.setBorder(null);
                preciobl.setToolTipText(null);
                categoriaLbl.setBorder(null);
                categoriaLbl.setToolTipText(null);
                existenciasLbl.setBorder(null);
                existenciasLbl.setToolTipText(null);
                break;
            case Model.FILTER:
                searchProducto.setText(model.getFilter().getCodigo());
                break;
        }
        this.panel.revalidate();
    }
}
