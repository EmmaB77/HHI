package Controlador;

import Beans.CotizacionBean;
import Beans.CotDetalleBean;
import Beans.EmpleadoBean;
import Beans.UserSystBean;
import Beans.UsuarioBean;
import Modelo.Cotizacion;
import Modelo.Empleado;
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

@WebServlet(name = "ControladorCotizacion", urlPatterns = {"/ControladorCotizacion", "/cotizacion", "/agregar_cot", "/agregar_concp", "/asignar_orden", "/facturar",
    "/ver_cot", "/mod_cot", "/eliminar_det", "/eliminar_cot", "/modificar_cot", "/modificar_det"})
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
            List<EmpleadoBean> listaEmpleados;
            listaEmpleados = Empleado.listarEmpleados();
            varSesion.setAttribute("empleados", listaEmpleados);
            List<UsuarioBean> listaUsuarios;
            listaUsuarios = Solicitante.listarUsuarios();
            varSesion.setAttribute("usuarios", listaUsuarios);
            response.sendRedirect("cotizar.jsp");
        }
        if (userPath.equals("/ver_cot")) {
            int idCot = Integer.parseInt(request.getParameter("idCoti"));
            List<CotizacionBean> listaCot;
            listaCot = Cotizacion.obtenerCotizacion(idCot);
            varSesion.setAttribute("cotizaciones", listaCot);
            List<CotDetalleBean> listaDet;
            listaDet = Cotizacion.obtenerDetallesCot(idCot);
            varSesion.setAttribute("detalles", listaDet);
            response.sendRedirect("verDetalleCot.jsp");
        }
        if (userPath.equals("/mod_cot")) {
            int idCot = Integer.parseInt(request.getParameter("idCoti"));
            List<CotizacionBean> listaCot;
            listaCot = Cotizacion.obtenerCotizacion(idCot);
            varSesion.setAttribute("cotizaciones", listaCot);
            List<CotDetalleBean> listaDet;
            listaDet = Cotizacion.obtenerDetallesCot(idCot);
            varSesion.setAttribute("detalles", listaDet);
            List<EmpleadoBean> listaEmpleados;
            listaEmpleados = Empleado.listarEmpleados();
            varSesion.setAttribute("empleados", listaEmpleados);
            List<UsuarioBean> listaUsuarios;
            listaUsuarios = Solicitante.listarUsuarios();
            varSesion.setAttribute("usuarios", listaUsuarios);
            response.sendRedirect("modificarCotizacion.jsp");
        }
        if (userPath.equals("/eliminar_det")) {
            int idCot = Integer.parseInt(request.getParameter("idCoti"));
            int idDet = Integer.parseInt(request.getParameter("idDetCot"));
            Cotizacion.eliminarDetalle(idDet);
            response.sendRedirect("mod_cot?idCoti=" + idCot);
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
            int iduser = Integer.parseInt(request.getParameter("usuario"));
            int idemp = Integer.parseInt(request.getParameter("ejecutor"));
            String status = request.getParameter("estatus");
            float total = Float.parseFloat(request.getParameter("totalnum"));
            String totaletra = request.getParameter("totaletra");
            String tiempo = request.getParameter("timen");

            System.out.println("Usuario: " + iduser);
            System.out.println("Empleado: " + idemp);

            CotizacionBean coti = new CotizacionBean();
            coti.setFechaSolCot(fecsol);
            coti.setSolCot(solcot);
            coti.setReferencia(refer);
            coti.setTituloCot(title);
            coti.setNumCot(numcot);
            coti.setDescCot(desc);
            coti.setFechaCot(fecot);
            coti.setIduser(iduser);
            coti.setIdemplo(idemp);
            coti.setEstatusCot(status);
            coti.setTotal(total);
            coti.setCanLetCot(totaletra);
            coti.setOrdComCot("SIN ORDEN DE COMPRA");
            coti.setAvanceCot("SIN AVANCE");
            coti.setNumFactCot("SIN FACTURAR");
            coti.setTiempoEntrega(tiempo);
            Cotizacion.agregarCot(coti);
            response.sendRedirect("cotizacion");
        }
        if (userPath.equals("/agregar_concp")) {
            int idcot = Integer.parseInt(request.getParameter("idcot"));
            int inciso = Integer.parseInt(request.getParameter("inciso"));
            String descon = request.getParameter("descon");
            float canti = Float.parseFloat(request.getParameter("canti"));
            String unidad = request.getParameter("unidad");
            float preciu = Float.parseFloat(request.getParameter("pu"));
            float importe = canti * preciu;

            CotDetalleBean cotcon = new CotDetalleBean();
            cotcon.setIdCot(idcot);
            cotcon.setIncisoCotDet(inciso);
            cotcon.setDescCotDet(descon);
            cotcon.setCantCotDet(canti);
            cotcon.setUniCotDet(unidad);
            cotcon.setPrecioUni(preciu);
            cotcon.setImporteCotDet(importe);

            Cotizacion.agregarDetalle(cotcon);
            response.sendRedirect("cotizacion");
        }

        if (userPath.equals("/asignar_orden")) {
            String numcotoc = request.getParameter("numcotoc");
            String orden = request.getParameter("ordenc");

            Cotizacion.asignarOrdenCompra(numcotoc, orden);
            response.sendRedirect("cotizacion");
        }

        if (userPath.equals("/facturar")) {
            String numcotoc = request.getParameter("numcotfa");
            String factura = request.getParameter("facturan");
            String avance = request.getParameter("avance");

            Cotizacion.agregarFactura(numcotoc, factura, avance);
            response.sendRedirect("cotizacion");
        }
        if (userPath.equals("/eliminar_cot")) {
            int idCot = Integer.parseInt(request.getParameter("idCoti"));
            Cotizacion.eliminarCot(idCot);
            response.sendRedirect("cotizacion");
        }
        if (userPath.equals("/modificar_cot")) {
            int idCot = Integer.parseInt(request.getParameter("idCoti"));
            String fecsol = request.getParameter("fechasol");
            String solcot = request.getParameter("solCot");
            String refer = request.getParameter("referencia");
            String title = request.getParameter("titulo");
            String numcot = request.getParameter("coti");
            String desc = request.getParameter("desc");
            String fecot = request.getParameter("fechacot");
            int iduser = Integer.parseInt(request.getParameter("usuario"));
            int idemp = Integer.parseInt(request.getParameter("ejecutor"));
            String status = request.getParameter("estatus");
            float total = Float.parseFloat(request.getParameter("totalnum"));
            String totaletra = request.getParameter("totaletra");
            String tiempo = request.getParameter("timen");

            System.out.println("Usuario: " + iduser);
            System.out.println("Empleado: " + idemp);

            CotizacionBean coti = new CotizacionBean();
            coti.setFechaSolCot(fecsol);
            coti.setSolCot(solcot);
            coti.setReferencia(refer);
            coti.setTituloCot(title);
            coti.setNumCot(numcot);
            coti.setDescCot(desc);
            coti.setFechaCot(fecot);
            coti.setIduser(iduser);
            coti.setIdemplo(idemp);
            coti.setEstatusCot(status);
            coti.setTotal(total);
            coti.setCanLetCot(totaletra);
            coti.setTiempoEntrega(tiempo);
            Cotizacion.modificarCot(idCot, coti);
            response.sendRedirect("ver_cot?idCoti=" + idCot);
        }
    }
}
