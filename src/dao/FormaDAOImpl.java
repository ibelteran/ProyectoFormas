package dao;

import modelo.Cuerpo;
import modelo.Figura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FormaDAOImpl implements FormaDAO {
    private ConexionBD conexionBD;

    public FormaDAOImpl() {
        this.conexionBD = new ConexionBD();
    }

    @Override
    public void guardarFigura(Figura figura) {
        String sql = "INSERT INTO formas (tipo, categoria, descripcion, area, perimetro, volumen) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, figura.getNombre());
            ps.setString(2, "Figura");
            ps.setString(3, figura.toString());
            ps.setDouble(4, figura.calcularArea());
            ps.setDouble(5, figura.calcularPerimetro());
            ps.setNull(6, java.sql.Types.DOUBLE);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("No se pudo guardar la figura en la base de datos.");
            System.out.println("Detalle: " + e.getMessage());
        }
    }

    @Override
    public void guardarCuerpo(Cuerpo cuerpo) {
        String sql = "INSERT INTO formas (tipo, categoria, descripcion, area, perimetro, volumen) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cuerpo.getNombre());
            ps.setString(2, "Cuerpo");
            ps.setString(3, cuerpo.toString());
            ps.setDouble(4, cuerpo.calcularArea());
            ps.setDouble(5, cuerpo.calcularPerimetro());
            ps.setDouble(6, cuerpo.calcularVolumen());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("No se pudo guardar el cuerpo en la base de datos.");
            System.out.println("Detalle: " + e.getMessage());
        }
    }
}
