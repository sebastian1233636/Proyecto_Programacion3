package pos.presentation.Estadistica;

import pos.logic.Categoria;
import pos.logic.Rango;
import pos.logic.Service;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
        List<Categoria> catall = new ArrayList<>();
        List<Categoria> cats = new ArrayList<>();
        model.Init(catall, cats);
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void llenarComboBoxAnnioDesde() {
        model.setAnniodesde(Service.instance().obtenerAniosDeFacturas());
    }

    public void llenarComboBoxAnnioHasta() {
        model.setAnnioHasta(Service.instance().obtenerAniosDeFacturas());
    }

    public void llenarMesDesde() {
        model.setMesDesde(Service.instance().obtenerMesesDeFacturas());
    }

    public void llenarMesHasta() {
        model.setMesHasta(Service.instance().obtenerMesesDeFacturas());
    }

    public void llenarCategoriasAll(){
        Categoria cat001 = new Categoria("CAT-001-Frutas y Verduras");
        Categoria cat002 = new Categoria("CAT-002-Carnes y Pescados");
        Categoria cat003 = new Categoria("CAT-003-Lácteos y Huevos");
        Categoria cat004 = new Categoria("CAT-004-Panadería");
        Categoria cat005 = new Categoria("CAT-005-Bebidas");
        Categoria cat006 = new Categoria("CAT-006-Congelados");
        Categoria cat007 = new Categoria("CAT-007-Productos de Limpieza");
        Categoria cat008 = new Categoria("CAT-008-Cuidado Personal");
        Categoria cat009 = new Categoria("CAT-009-Alimentos en Conserva");
        Categoria cat010 = new Categoria("CAT-010-Cereales y Granos");
        model.getCategoriasAll().add(cat001);
        model.getCategoriasAll().add(cat002);
        model.getCategoriasAll().add(cat003);
        model.getCategoriasAll().add(cat004);
        model.getCategoriasAll().add(cat005);
        model.getCategoriasAll().add(cat006);
        model.getCategoriasAll().add(cat007);
        model.getCategoriasAll().add(cat008);
        model.getCategoriasAll().add(cat009);
        model.getCategoriasAll().add(cat010);
    }

    public void ActualizarData() {
        Rango r = model.getRango();
        List<Categoria> categorias = model.getCategoriasAll();

        int colCount = ((r.getAnnoHasta() - r.getAnnoDesde()) * 12 + r.getMesHasta() - r.getMesDesde()) + 2;
        int rowCount = categorias.size();

        String[] cols = new String[colCount];
        String[] rows = new String[rowCount];

        int mes = r.getMesDesde();
        int anno = r.getAnnoDesde();
        for (int i = 0; i < colCount; i++) {
            cols[i] = "Mes " + mes + " - Año " + anno;
            mes++;
            if (mes > 12) {
                mes = 1;
                anno++;
            }
        }

        for (int i = 0; i < rowCount; i++) {
            rows[i] = categorias.get(i).getNombre();
        }

        float[][] data = new float[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            Categoria categoria = categorias.get(i);
            for (int j = 0; j < colCount; j++) {
                int mesActual = r.getMesDesde() + j;
                int annoActual = r.getAnnoDesde();
                if (mesActual > 12) {
                    mesActual -= 12;
                    annoActual++;
                }
                data[i][j] = Service.instance().obtenerVentasPorCategoriaYFecha(categoria, annoActual, mesActual, annoActual, mesActual);
            }
        }
        model.setData(rows, cols, data);
    }
}