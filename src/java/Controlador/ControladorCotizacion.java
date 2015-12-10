package Controlador;

import Beans.CotizacionBean;
import Beans.UserSystBean;
import Modelo.Cotizacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControladorCotizacion", urlPatterns = {"/ControladorCotizacion", "/cotizacion"})
public class ControladorCotizacion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String userPath = request.getServletPath();
        HttpSession varSesion = request.getSession();
        UserSystBean user = (UserSystBean) varSesion.getAttribute("usuario");
        if (user == null) {
            response.sendRedirect("acceso.jsp");
        } else if (userPath.equals("/cotizacion")) {
            List<CotizacionBean> listaCot;
                listaCot = Cotizacion.listarCotizaciones();
                varSesion.setAttribute("cotizaciones", listaCot);
            response.sendRedirect("cotizacion.jsp");
        }

    }

}
