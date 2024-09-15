package pos.presentation.Estadistica;

import pos.logic.Service;

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
    private JComboBox comboBox5;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTable table1;
    public JPanel PanelGrafico;


    public JPanel getPanel1() {
        return panel1;
    }

    private void Categories() {
        comboBox5.addItem("CAT-001-Frutas y Verduras");
        comboBox5.addItem("CAT-002-Carnes y Pescados");
        comboBox5.addItem("CAT-003-Lácteos y Huevos");
        comboBox5.addItem("CAT-004-Panadería");
        comboBox5.addItem("CAT-005-Bebidas");
        comboBox5.addItem("CAT-006-Congelados");
        comboBox5.addItem("CAT-007-Productos de Limpieza");
        comboBox5.addItem("CAT-008-Cuidado Personal");
        comboBox5.addItem("CAT-009-Alimentos en Conserva");
        comboBox5.addItem("CAT-010-Cereales y Granos");
    }

    public View () {
            Categories();
        panel1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(Service.instance().obtenerAniosDeFacturas());

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
            case pos.presentation.Cajero.Model.LIST:

                break;
            case pos.presentation.Cajero.Model.CURRENT:
                break;

            case pos.presentation.Cajero.Model.FILTER:

                break;
        }
       // this.panel.revalidate();
    }


}
