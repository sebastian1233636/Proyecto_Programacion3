package pos.presentation.Estadistica;

import javax.swing.*;
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
    private JButton agregarAll;
    private JButton deleteCategoria;
    private JButton deleteAll;
    private JTable table1;
    public JPanel PanelGrafico;


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
            }
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

                break;

        }
        this.panel1.revalidate();
    }
}
