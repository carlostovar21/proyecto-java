

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.*;

@WebService
public class EmpleadoService {

    @WebMethod
    public boolean crearEmpleado(int id, String nombre, float salario) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "usuario", "contraseña");
            ps = con.prepareStatement("INSERT INTO EMPLEADOS (ID, NOMBRE, SALARIO) VALUES (?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setFloat(3, salario);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @WebMethod
    public String consultarEmpleado(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "usuario", "contraseña");
            ps = con.prepareStatement("SELECT NOMBRE, SALARIO FROM EMPLEADOS WHERE ID = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("NOMBRE");
                float salario = rs.getFloat("SALARIO");
                return "Nombre: " + nombre + ", Salario: " + salario;
            } else {
                return "No se encontró el empleado con el ID " + id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ocurrió un error al consultar el empleado";
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
