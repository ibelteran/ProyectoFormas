package dao;

import modelo.Cuerpo;
import modelo.Figura;

public interface FormaDAO {
    void guardarFigura(Figura figura);
    void guardarCuerpo(Cuerpo cuerpo);
}