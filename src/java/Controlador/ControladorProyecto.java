package Controlador;

import Beans.ProyectoBean;
import Beans.UserSystBean;
import Modelo.Proyecto;
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
 * @author windows
 */
@WebServlet(name = "ControladorProyecto", urlPatterns = {"/ControladorProyecto","/proyecto","/agregar_proy","/agregar_mat_direct","/agregar_mat_indirect","/agregar_mat_consu","/mano_obra"})
public class ControladorProyecto extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String userPath = request.getServletPath();
        HttpSession varSesion = request.getSession();
        UserSystBean user = (UserSystBean) varSesion.getAttribute("usuario");
        if (user == null) {
            response.sendRedirect("acceso.jsp");
        } else if (userPath.equals("/proyecto")) {
            List<ProyectoBean> listaProyectos;
            listaProyectos = Proyecto.listaProyectos();
            varSesion.setAttribute("proyectos", listaProyectos);
            response.sendRedirect("proyecto.jsp");
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
        
        if(userPath.equals("/agregar_proy")){
            
            String nombreP = request.getParameter("titulo");
            String ordenC = request.getParameter("orden");
            String requisi = request.getParameter("requisicion");
            String fechai = request.getParameter("fechai");
            float presu = Float.parseFloat(request.getParameter("presu"));
            
            float iva = presu * 0.16f;
            float total = presu+iva;
            
            ProyectoBean proy = new ProyectoBean();
            proy.setNombreProyecto(nombreP);
            proy.setOrdenComProyecto(ordenC);
            proy.setRequiProyecto(requisi);
            proy.setFehaIProyecto(fechai);
            proy.setPresupuestoProyecto(presu);
            proy.setDispProyecto(presu);
            proy.setIncurridoProyecto(0);
            proy.setIvaProyecto(iva);
            proy.setTotalproyecto(total);
            proy.setUtilidadProyecto(100);
            
            Proyecto.agregarProyecto(proy);
            response.sendRedirect("proyecto");
        }
        
    }
}
