package pos.presentation.Estadistica;

import pos.logic.Cajero;
import pos.logic.Categoria;
import pos.logic.Rango;
import pos.logic.Service;
import pos.presentation.Estadistica.Model;
import pos.presentation.Estadistica.View;

import java.util.ArrayList;
import java.util.List;


public class Controller {
    pos.presentation.Estadistica.View view;
    pos.presentation.Estadistica.Model model;


    public Controller(View view, Model model) {
        List<Categoria> catall = new ArrayList<Categoria>();
        List<Categoria> cats = new ArrayList<Categoria>();
        model.Init(catall,cats);
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void llenarComboBoxAnnioDesde(){
        model.setAnniodesde(Service.instance().obtenerAniosDeFacturas());
    }

    public void llenarComboBoxAnnioHasta(){
        model.setAnnioHasta(Service.instance().obtenerAniosDeFacturas());
    }

    public void llenarMesDesde(){
        model.setMesDesde(Service.instance().obtenerMesesDeFacturas());
    }
    public void llenarMesHasta(){
        model.setMesHasta(Service.instance().obtenerMesesDeFacturas());
    }

    public void ActualizarData(){
        Rango r = model.getRango();
        int colCount =(r.getAnnoHasta()-r.getAnnoDesde())*12+r.getMesHasta()-r.getMesDesde()+1;
        int rowCount = model.getCategorias().size();
        String[] cols = new String[colCount];
    }

}