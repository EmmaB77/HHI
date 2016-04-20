package Controlador;

import Beans.ProyectoBean;
import Beans.ProyectoMCBean;
import Beans.ProyectoMDBean;
import Beans.ProyectoMIBean;
import Beans.ProyectoMaOBean;
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
@WebServlet(name = "ControladorProyecto", urlPatterns = {"/ControladorProyecto","/proyecto","/agregar_proy","/agregar_mat_direct","/agregar_mat_indirect","/agregar_mat_consu",
    "/mano_obra","/eliminar_proy","/ver_proyecto","/eliminar_md","/eliminar_mi","/eliminar_mc","/eliminar_mo"})
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
        }
        if(userPath.equals("/eliminar_proy")){
            int idProy = Integer.parseInt(request.getParameter("idproy"));
            Proyecto.eliminarProyecto(idProy);
            response.sendRedirect("proyecto");
        }
        if(userPath.equals("/eliminar_md")){
            int idProy = Integer.parseInt(request.getParameter("idProy"));
            int idDet = Integer.parseInt(request.getParameter("idMD"));
            float subtotal = Float.parseFloat(request.getParameter("subT"));
            float utilidad;
            
            float incurrido = Proyecto.obtenerIncurrido(idProy);
            float disponible = Proyecto.obtenerDisponible(idProy);
            float presupuesto = Proyecto.obtenerPresupuesto(idProy);
            
            float nincurrido = incurrido-subtotal;
            float ndisponible = disponible+subtotal;
            
            utilidad = ndisponible/presupuesto*100;
            ProyectoBean proy = new ProyectoBean();
            proy.setIncurridoProyecto(nincurrido);
            proy.setDispProyecto(ndisponible);
            proy.setUtilidadProyecto(utilidad);
            
            Proyecto.eliminarDirecto(idDet, idProy, proy);
            response.sendRedirect("ver_proyecto?idproy="+idProy);
        }
        if(userPath.equals("/eliminar_mi")){
            int idProy = Integer.parseInt(request.getParameter("idProy"));
            int idDet = Integer.parseInt(request.getParameter("idMI"));
            float subtotal = Float.parseFloat(request.getParameter("subT"));
            float utilidad;
            
            float incurrido = Proyecto.obtenerIncurrido(idProy);
            float disponible = Proyecto.obtenerDisponible(idProy);
            float presupuesto = Proyecto.obtenerPresupuesto(idProy);
            
            float nincurrido = incurrido-subtotal;
            float ndisponible = disponible+subtotal;
            
            utilidad = ndisponible/presupuesto*100;
            ProyectoBean proy = new ProyectoBean();
            proy.setIncurridoProyecto(nincurrido);
            proy.setDispProyecto(ndisponible);
            proy.setUtilidadProyecto(utilidad);
            
            Proyecto.eliminarIndirecto(idDet, idProy, proy);
            response.sendRedirect("ver_proyecto?idproy="+idProy);
        }
        if(userPath.equals("/eliminar_mc")){
            int idProy = Integer.parseInt(request.getParameter("idProy"));
            int idDet = Integer.parseInt(request.getParameter("idMC"));
            float subtotal = Float.parseFloat(request.getParameter("subT"));
            float utilidad;
            
            float incurrido = Proyecto.obtenerIncurrido(idProy);
            float disponible = Proyecto.obtenerDisponible(idProy);
            float presupuesto = Proyecto.obtenerPresupuesto(idProy);
            
            float nincurrido = incurrido-subtotal;
            float ndisponible = disponible+subtotal;
            
            utilidad = ndisponible/presupuesto*100;
            ProyectoBean proy = new ProyectoBean();
            proy.setIncurridoProyecto(nincurrido);
            proy.setDispProyecto(ndisponible);
            proy.setUtilidadProyecto(utilidad);
            
            Proyecto.eliminarConsumo(idDet, idProy, proy);
            response.sendRedirect("ver_proyecto?idproy="+idProy);
        }
        if(userPath.equals("/eliminar_mo")){
            int idProy = Integer.parseInt(request.getParameter("idProy"));
            int idDet = Integer.parseInt(request.getParameter("idMO"));
            float subtotal = Float.parseFloat(request.getParameter("subT"));
            float utilidad;
            
            float incurrido = Proyecto.obtenerIncurrido(idProy);
            float disponible = Proyecto.obtenerDisponible(idProy);
            float presupuesto = Proyecto.obtenerPresupuesto(idProy);
            
            float nincurrido = incurrido-subtotal;
            float ndisponible = disponible+subtotal;
            
            utilidad = ndisponible/presupuesto*100;
            ProyectoBean proy = new ProyectoBean();
            proy.setIncurridoProyecto(nincurrido);
            proy.setDispProyecto(ndisponible);
            proy.setUtilidadProyecto(utilidad);
            
            Proyecto.eliminarManoObra(idDet, idProy, proy);
            response.sendRedirect("ver_proyecto?idproy="+idProy);
        }
        if(userPath.equals("/ver_proyecto")){
            int id = Integer.parseInt(request.getParameter("idproy"));
            List<ProyectoBean> listaProyectos;
            listaProyectos = Proyecto.obtenerProyecto(id);
            varSesion.setAttribute("proyectos", listaProyectos);
            List<ProyectoMDBean> listaMD;
            listaMD = Proyecto.obtenerDirectos(id);
            varSesion.setAttribute("detallesd", listaMD);
            List<ProyectoMDBean> listaTotalMD;
            listaTotalMD = Proyecto.totalesDirecto(id);
            varSesion.setAttribute("totalesmd", listaTotalMD);
            List<ProyectoMIBean> listaMI;
            listaMI = Proyecto.obtenerIndirectos(id);
            varSesion.setAttribute("detallesi", listaMI);
            List<ProyectoMIBean> listaTotalMI;
            listaTotalMI = Proyecto.totalesIndirecto(id);
            varSesion.setAttribute("totalesmi", listaTotalMI);
            List<ProyectoMCBean> listaMC;
            listaMC = Proyecto.obtenerConsumo(id);
            varSesion.setAttribute("detallesc", listaMC);
            List<ProyectoMCBean> listaTotalMC;
            listaTotalMC = Proyecto.totalesConsumo(id);
            varSesion.setAttribute("totalesmc", listaTotalMC);
            List<ProyectoMaOBean> listaMaO;
            listaMaO = Proyecto.obtenerManoObra(id);
            varSesion.setAttribute("detallesmo", listaMaO);
            List<ProyectoMaOBean> listaTotalMaO;
            listaTotalMaO = Proyecto.totalesMaO(id);
            varSesion.setAttribute("totalesmo", listaTotalMaO);
            response.sendRedirect("verProyecto.jsp");
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
        if(userPath.equals("/agregar_mat_direct")){
            int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
            String fecha = request.getParameter("fechaf");
            String proveedor = request.getParameter("proveedor");
            String factura = request.getParameter("factura");
            String descripcion = request.getParameter("descripcion");
            
            float subtotal = Float.parseFloat(request.getParameter("subtotal"));
            float iva = subtotal*0.16f;
            float importe = subtotal+iva;
            float utilidad = 0;
            
            float incurrido = Proyecto.obtenerIncurrido(idProyecto);
            float disponible = Proyecto.obtenerDisponible(idProyecto);
            float presupuesto = Proyecto.obtenerPresupuesto(idProyecto);
            
            float nincurrido = incurrido+subtotal;
            float ndisponible = disponible-subtotal;
            
            utilidad = ndisponible/presupuesto*100;
            
            ProyectoMDBean matdirect = new ProyectoMDBean();
            matdirect.setIdProyecto(idProyecto);
            matdirect.setFechaFactMatDirect(fecha);
            matdirect.setPreveedorMatDirect(proveedor);
            matdirect.setNumFactMatDirect(factura);
            matdirect.setDescripMatDirect(descripcion);
            matdirect.setSubtMatDirect(subtotal);
            matdirect.setIvaMatDirect(iva);
            matdirect.setTotalMatDirect(importe);
            
            ProyectoBean proy = new ProyectoBean();
            proy.setIncurridoProyecto(nincurrido);
            proy.setDispProyecto(ndisponible);
            proy.setUtilidadProyecto(utilidad);
            
            Proyecto.agregarMatDirect(idProyecto, matdirect, proy);
            response.sendRedirect("proyecto");
        }
        if(userPath.equals("/agregar_mat_indirect")){
            int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
            String fecha = request.getParameter("fechaf");
            String proveedor = request.getParameter("proveedor");
            String factura = request.getParameter("factura");
            String descripcion = request.getParameter("descripcion");
            
            float subtotal = Float.parseFloat(request.getParameter("subtotal"));
            float iva = subtotal*0.16f;
            float importe = subtotal+iva;
            float utilidad;
            
            float incurrido = Proyecto.obtenerIncurrido(idProyecto);
            float disponible = Proyecto.obtenerDisponible(idProyecto);
            float presupuesto = Proyecto.obtenerPresupuesto(idProyecto);
            
            float nincurrido = incurrido+subtotal;
            float ndisponible = disponible-subtotal;
            
            utilidad = ndisponible/presupuesto*100;
            
            ProyectoMIBean matdirect = new ProyectoMIBean();
            matdirect.setIdProyecto(idProyecto);
            matdirect.setFechaFactMatIn(fecha);
            matdirect.setPreveedorMatIn(proveedor);
            matdirect.setNumFactMatIn(factura);
            matdirect.setDescripMatIn(descripcion);
            matdirect.setSubtMatIn(subtotal);
            matdirect.setIvaMatIn(iva);
            matdirect.setTotalMatIn(importe);
            
            ProyectoBean proy = new ProyectoBean();
            proy.setIncurridoProyecto(nincurrido);
            proy.setDispProyecto(ndisponible);
            proy.setUtilidadProyecto(utilidad);
            
            Proyecto.agregarMatIndirect(idProyecto, matdirect, proy);
            response.sendRedirect("proyecto");
        }
        if(userPath.equals("/agregar_mat_consu")){
            int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
            String fecha = request.getParameter("fechaf");
            String proveedor = request.getParameter("proveedor");
            String factura = request.getParameter("factura");
            String descripcion = request.getParameter("descripcion");
            
            float subtotal = Float.parseFloat(request.getParameter("subtotal"));
            float iva = subtotal*0.16f;
            float importe = subtotal+iva;
            float utilidad;
            
            float incurrido = Proyecto.obtenerIncurrido(idProyecto);
            float disponible = Proyecto.obtenerDisponible(idProyecto);
            float presupuesto = Proyecto.obtenerPresupuesto(idProyecto);
            
            float nincurrido = incurrido+subtotal;
            float ndisponible = disponible-subtotal;
            
            utilidad = ndisponible/presupuesto*100;
            
            ProyectoMCBean matdirect = new ProyectoMCBean();
            matdirect.setIdProyecto(idProyecto);
            matdirect.setFechaFactMatCon(fecha);
            matdirect.setPreveedorMatCon(proveedor);
            matdirect.setNumFactMatCon(factura);
            matdirect.setDescripMatCon(descripcion);
            matdirect.setSubtMatCon(subtotal);
            matdirect.setIvaMatCon(iva);
            matdirect.setTotalMatCon(importe);
            
            ProyectoBean proy = new ProyectoBean();
            proy.setIncurridoProyecto(nincurrido);
            proy.setDispProyecto(ndisponible);
            proy.setUtilidadProyecto(utilidad);
            
            Proyecto.agregarMatConsumo(idProyecto, matdirect, proy);
            response.sendRedirect("proyecto");
        }
        
        if(userPath.equals("/mano_obra")){
            int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
            String descripcion = request.getParameter("descripcion");
            
            float subtotal = Float.parseFloat(request.getParameter("subtotal"));
            float utilidad;
            
            float incurrido = Proyecto.obtenerIncurrido(idProyecto);
            float disponible = Proyecto.obtenerDisponible(idProyecto);
            float presupuesto = Proyecto.obtenerPresupuesto(idProyecto);
            
            float nincurrido = incurrido+subtotal;
            float ndisponible = disponible-subtotal;
            
            utilidad = ndisponible/presupuesto*100;
            
            ProyectoMaOBean matdirect = new ProyectoMaOBean();
            matdirect.setIdProyecto(idProyecto);
            matdirect.setDescMaO(descripcion);
            matdirect.setSubtMaO(subtotal);
            
            ProyectoBean proy = new ProyectoBean();
            proy.setIncurridoProyecto(nincurrido);
            proy.setDispProyecto(ndisponible);
            proy.setUtilidadProyecto(utilidad);
            
            Proyecto.agregarManoObra(idProyecto, matdirect, proy);
            response.sendRedirect("proyecto");
        }  
    }
}
