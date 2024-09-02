package pos.logic;

public class Categoria {
    private String nombre;




    public Categoria(String nom){
        this.nombre = nom;
    }


    public String getNombre(){
        return nombre;
    }
    
    @Override
    public String toString() {
        return nombre;
    }


}
