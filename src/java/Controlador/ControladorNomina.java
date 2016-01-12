package Controlador;

import Beans.NominaBean;
import Beans.UserSystBean;
import Modelo.nomina;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ControladorNomina", urlPatterns = {"/ControladorNomina","/calcularnom","/descontarnom","/nomina"})
public class ControladorNomina extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String userPath = request.getServletPath();
        HttpSession varSesion = request.getSession();
        UserSystBean user = (UserSystBean) varSesion.getAttribute("usuario");
        if (user == null) { response.sendRedirect("acceso.jsp");
        } else if (userPath.equals("/nomina")) {
            List<NominaBean> listaNomina;
            listaNomina = nomina.listaNom();
            varSesion.setAttribute("nomina", listaNomina);
            response.sendRedirect("nomina.jsp");
        } else {
            System.out.println("El Servidor esta de nena y algo hizo mal |:|");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String userPath = request.getServletPath();
        HttpSession varSesion = request.getSession();
    }
}
