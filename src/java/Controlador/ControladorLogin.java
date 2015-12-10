package Controlador;

import Beans.PersonaBean;
import Beans.UserSystBean;
import Modelo.Persona;
import Modelo.UserSystem;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@WebServlet(name = "ControladorLogin", urlPatterns = {"/ControladorLogin"})
public class ControladorLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String userPath = request.getServletPath();
        HttpSession varSesion = request.getSession();
        varSesion.setMaxInactiveInterval(7200);

        if (userPath.equals("/ControladorLogin")) {
            UserSystBean user;
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            boolean existe = UserSystem.validarUsuario(usuario, password);
            if (existe == true) {
                int idPersona = UserSystem.obtenerIdPersona(usuario, password);
                    user = UserSystem.obtenerUsuario(usuario, password);
                    PersonaBean persona = Persona.obtenerPersona(idPersona);
                    varSesion.setAttribute("usuario", user);
                    varSesion.setAttribute("persona", persona);
                    response.sendRedirect("index.jsp");
            } else {
                varSesion.setAttribute("error", 1);
                response.sendRedirect("verDetalleCot.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String userPath = request.getServletPath();
        HttpSession varSesion = request.getSession();
        varSesion.setMaxInactiveInterval(7200);

        if (userPath.equals("/ControladorLogin")) {
            UserSystBean user;
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            boolean existe = UserSystem.validarUsuario(usuario, password);
            if (existe == true) {
                int idPersona = UserSystem.obtenerIdPersona(usuario, password);
                    user = UserSystem.obtenerUsuario(usuario, password);
                    PersonaBean persona = Persona.obtenerPersona(idPersona);
                    varSesion.setAttribute("usuario", user);
                    varSesion.setAttribute("persona", persona);
                    response.sendRedirect("index.jsp");
            } else {
                varSesion.setAttribute("error", 1);
                response.sendRedirect("acceso.jsp");
                System.out.println("Vuelve a Ingresar");
            }
        }
    }

    public String getServletInf() {
        return "Short description";
    }// </editor-fold>
}
