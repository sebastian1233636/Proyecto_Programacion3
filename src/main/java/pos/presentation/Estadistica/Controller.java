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
        agregarCategoriaSiNoExiste(cat001);
        agregarCategoriaSiNoExiste(cat002);
        agregarCategoriaSiNoExiste(cat003);
        agregarCategoriaSiNoExiste(cat004);
        agregarCategoriaSiNoExiste(cat005);
        agregarCategoriaSiNoExiste(cat006);
        agregarCategoriaSiNoExiste(cat007);
        agregarCategoriaSiNoExiste(cat008);
        agregarCategoriaSiNoExiste(cat009);
        agregarCategoriaSiNoExiste(cat010);
    }

    public void llenarAll(){
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
        agregarCategoriaSiNoExiste(cat001);
        agregarCategoriaSiNoExiste(cat002);
        agregarCategoriaSiNoExiste(cat003);
        agregarCategoriaSiNoExiste(cat004);
        agregarCategoriaSiNoExiste(cat005);
        agregarCategoriaSiNoExiste(cat006);
        agregarCategoriaSiNoExiste(cat007);
        agregarCategoriaSiNoExiste(cat008);
        agregarCategoriaSiNoExiste(cat009);
        agregarCategoriaSiNoExiste(cat010);
    }

    public void ClearCategoria(){
        model.getCategorias().clear();
    }

    private void agregarCategoriaSiNoExiste(Categoria categoria) {
        // Verifica si la categoría ya está en la lista usando equals en el objeto Categoria
        if (!model.getCategorias().contains(categoria)) {
            model.getCategorias().add(categoria);
        } else {
            System.out.println("La categoría " + categoria.getNombre() + " ya existe y no se agregará.");
        }
    }

    public void agregarCategoria(String nom){
        Categoria cat = new Categoria(nom);
        agregarCategoriaSiNoExiste(cat);
    }
    public void ActualizarData() {
        Rango r = model.getRango();
        List<Categoria> categorias = model.getCategorias();

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