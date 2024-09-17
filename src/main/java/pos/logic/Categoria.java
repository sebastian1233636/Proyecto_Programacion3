package pos.logic;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Categoria {
    private String nombre;

    public Categoria(){nombre = " ";}

    public Categoria(String nom){this.nombre = nom;}

    public String getNombre(){return nombre;}

    @Override
    public String toString() {return nombre;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Categoria categoria = (Categoria) obj;
        return this.nombre.equals(categoria.nombre); // O el campo que defina igualdad
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre); // Asegúrate de incluir todos los campos relevantes para la igualdad
    }

}