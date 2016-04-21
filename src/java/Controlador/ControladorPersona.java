package Controlador;

import Beans.EmpleadoBean;
import Beans.PersonaBean;
import Beans.UserSystBean;
import Beans.UsuarioBean;
import Modelo.Empleado;
import Modelo.Persona;
import Modelo.Solicitante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Emmanuel
 */
@WebServlet(name = "ControladorPersona", urlPatterns = {"/ControladorPersona", "/persona"})
public class ControladorPersona extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String userPath = request.getServletPath();
        HttpSession varSesion = request.getSession();
        UserSystBean user = (UserSystBean) varSesion.getAttribute("usuario");
        if (user == null) {
            response.sendRedirect("acceso.jsp");
        } else if (userPath.equals("/persona")) {
            List<PersonaBean> listaTPersonas;
            listaTPersonas = Persona.listarPersonas();
            varSesion.setAttribute("personas", listaTPersonas);
            List<PersonaBean> listaPersonasD;
            listaPersonasD = Persona.listarPersonasSinDefinir();
            varSesion.setAttribute("personasd", listaPersonasD);
            List<EmpleadoBean> listaEmpleados;
            listaEmpleados = Empleado.listarEmpleados();
            varSesion.setAttribute("empleados", listaEmpleados);
            List<UsuarioBean> listaUsuarios;
            listaUsuarios = Solicitante.listarUsuarios();
            varSesion.setAttribute("usuarios", listaUsuarios);
            response.sendRedirect("persona.jsp");
        }
    }

}
