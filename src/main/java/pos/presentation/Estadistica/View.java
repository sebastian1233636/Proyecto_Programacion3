package pos.presentation.Estadistica;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import pos.logic.Rango;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View implements PropertyChangeListener{
    private JPanel panel1;
    private JComboBox comboBoxAnniosDesde;
    private JComboBox comboBoxMesDesde;
    private JComboBox comboBoxAnniosHasta;
    private JComboBox comboBoxMesHasta;
    private JComboBox categorias;
    private JButton agregarCategoria;
    private JTable table1;
    public JPanel PanelGrafico;
    private JLabel desdeLabel;
    private JLabel hastaLabel;
    private JButton deleteAll;
    private JButton deleteCategoria;
    private JLabel categoriaLabel;
    private JButton agregarAll;


    public JPanel getPanel1() {
        return panel1;
    }

    private void Categories() {
        categorias.addItem("CAT-001-Frutas y Verduras");
        categorias.addItem("CAT-002-Carnes y Pescados");
        categorias.addItem("CAT-003-Lácteos y Huevos");
        categorias.addItem("CAT-004-Panadería");
        categorias.addItem("CAT-005-Bebidas");
        categorias.addItem("CAT-006-Congelados");
        categorias.addItem("CAT-007-Productos de Limpieza");
        categorias.addItem("CAT-008-Cuidado Personal");
        categorias.addItem("CAT-009-Alimentos en Conserva");
        categorias.addItem("CAT-010-Cereales y Granos");
    }

    public View () {
            Categories();
        panel1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
            }
        });
        agregarCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        panel1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);

                controller.llenarComboBoxAnnioDesde();
                controller.llenarComboBoxAnnioHasta();
                controller.llenarMesDesde();
                controller.llenarMesHasta();
                controller.llenarCategoriasAll();
                comboBoxAnniosDesde.addItem("2022");
                comboBoxAnniosDesde.addItem("2023");
                comboBoxAnniosHasta.addItem("2022");
                comboBoxAnniosHasta.addItem("2023");

                for(String annios: model.getAnniodesde()){
                    comboBoxAnniosDesde.addItem(annios);
                }
                for(String annios: model.getAnnioHasta()){
                    comboBoxAnniosHasta.addItem(annios);
                }
                for(String meses : model.getMesDesde()){
                    comboBoxMesDesde.addItem(meses);
                }
                for(String meses : model.getMesHasta()){
                    comboBoxMesHasta.addItem(meses);
                }
                controller.ClearCategoria();


            }
        });



        agregarAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int annoDesde = Integer.parseInt((String) comboBoxAnniosDesde.getSelectedItem());
                int mesDesde = Integer.parseInt((String) comboBoxMesDesde.getSelectedItem());
                int annoHasta = Integer.parseInt((String) comboBoxAnniosHasta.getSelectedItem());
                int mesHasta = Integer.parseInt((String) comboBoxMesHasta.getSelectedItem());
                Rango fecha = new Rango(annoDesde, mesDesde, annoHasta, mesHasta);
                model.setRango(fecha);
                controller.ClearCategoria();
                controller.llenarAll();
                controller.ActualizarData();
            }
        });

        deleteCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table1.getSelectedRow();

                if (selectedRow != -1) {
                    model.eliminarCategoria(selectedRow);
                    table1.setModel(model.getTableModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una categoría para eliminar.");
                }
            }
        });

        deleteAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al método del modelo que elimina todas las categorías
                controller.ClearCategoria();
                model.eliminarTodasCategorias();
                table1.setModel(model.getTableModel());
            }
        });
        agregarCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int annoDesde = Integer.parseInt((String) comboBoxAnniosDesde.getSelectedItem());
                int mesDesde = Integer.parseInt((String) comboBoxMesDesde.getSelectedItem());
                int annoHasta = Integer.parseInt((String) comboBoxAnniosHasta.getSelectedItem());
                int mesHasta = Integer.parseInt((String) comboBoxMesHasta.getSelectedItem());
                Rango fecha = new Rango(annoDesde, mesDesde, annoHasta, mesHasta);
                model.setRango(fecha);
                controller.agregarCategoria((String)categorias.getSelectedItem());
                controller.ActualizarData();
            }
        });
        panel1.addComponentListener(new ComponentAdapter() {
        });
    }

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
            case pos.presentation.Estadistica.Model.DATA:
                table1.setModel(model.getTableModel());
                ChartPanel chartPanel = model.createLineChart();
                PanelGrafico.removeAll();
                PanelGrafico.setLayout(new BorderLayout());
                PanelGrafico.add(chartPanel, BorderLayout.CENTER);
                PanelGrafico.revalidate();
                PanelGrafico.repaint();
                break;
        }
        this.panel1.revalidate();
    }
}
