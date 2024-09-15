package pos.logic;

import java.util.List;

public class objetoEstadistica {
    Categoria categoria;
    List<String> fechas;
    double importe;


    public objetoEstadistica(Categoria cat){
        categoria = cat;
    }
    public void agregarFecha(String fecha){
        fechas.add(fecha);
    }
    public int contarFechas(){
        return fechas.size();
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<String> getFechas(){
        return fechas;
    }
    public double getImporte(){
        return importe;
    }
    public void setImporte(double importe){
        this.importe = importe;
    }
}
