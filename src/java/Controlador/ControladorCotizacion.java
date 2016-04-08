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

@WebServlet(name = "ControladorCotizacion", urlPatterns = {"/ControladorCotizacion", "/cotizacion", "/agregar_cot"})
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String userPath = request.getServletPath();
        HttpSession varSesion = request.getSession();

        if (userPath.equals("/agregar_cot")) {
            String fecsol = request.getParameter("fechasol");
            String solcot = request.getParameter("solCot");
            String refer = request.getParameter("referencia");
            String title = request.getParameter("titulo");
            String numcot = request.getParameter("coti");
            String desc = request.getParameter("desc");
            String fecot = request.getParameter("fechacot");
            float monto = Float.parseFloat(request.getParameter("monto"));
            String oc = request.getParameter("ordenC");
            int iduser = Integer.parseInt(request.getParameter("usuario"));
            int idemp = Integer.parseInt(request.getParameter("ejecutor"));
            int avance = Integer.parseInt(request.getParameter("avance"));
            String status = request.getParameter("estatus");
            String numfact = request.getParameter("factura");
            float total = Float.parseFloat(request.getParameter("totalnum"));
            String totaletra = request.getParameter("totaletra");

            CotizacionBean coti = new CotizacionBean();
            coti.setFechaSolCot(fecsol);
            coti.setSolCot(solcot);
            coti.setReferencia(refer);
            coti.setTituloCot(title);
            coti.setNumCot(numcot);
            coti.setDescCot(desc);
            coti.setFechaCot(fecot);
            coti.setMontoCot(monto);
            coti.setOrdComCot(oc);
            coti.setIduser(iduser);
            coti.setIdemplo(idemp);
            coti.setAvanceCot(avance);
            coti.setEstatusCot(status);
            coti.setNumFactCot(numfact);
            coti.setTotal(total);
            coti.setCanLetCot(totaletra);
            Cotizacion.agregarCot(coti);    
        }
    }
}
