package Controlador;

import Beans.GastoIndirectoBean;
import Beans.UserSystBean;
import Modelo.GastoIndirecto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControladorIndirecto", urlPatterns = {"/ControladorIndireto","/agregar_indi","/actualizar_indi","/eliminar_indi","/indirecto"})
public class ControladorIndirecto extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String userPath = request.getServletPath();
        HttpSession varSesion = request.getSession();
        UserSystBean user = (UserSystBean) varSesion.getAttribute("usuario");
        if (user == null) {
            response.sendRedirect("acceso.jsp");
        } else if (userPath.equals("/indirecto")) {
            List<GastoIndirectoBean> listaIndirectos;
            listaIndirectos = GastoIndirecto.listaGastos();
            varSesion.setAttribute("indirectos", listaIndirectos);
            response.sendRedirect("gastoIndirecto.jsp");
            System.out.println(listaIndirectos);
        } else {
            System.out.println("El Servidor esta de nena y algo hizo mal |:|");
        }
        if (userPath.equals("/eliminar_indi")) {
            int idIndi = Integer.parseInt(request.getParameter("idIndi"));
            GastoIndirecto.eliminarGasto(idIndi);
            response.sendRedirect("indirecto");
        } else {
            System.out.println("Aqui tambien... |:|");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String userPath = request.getServletPath();
        HttpSession varSesion = request.getSession();

        if (userPath.equals("/agregar_indi")) {
            String fechaI = request.getParameter("fecha");
            String mesI = request.getParameter("mes");
            String provI = request.getParameter("prov");
            String factI = request.getParameter("fact");
            String descI = request.getParameter("desc");
            float subtI = Float.parseFloat(request.getParameter("subt"));
            String respI = request.getParameter("iva");
            float iva = 0;
            float total;
            float iva2 = 0;
            if (respI.equals("si")) {
                iva = 0.16f * subtI;
                iva2 = Math.round(iva * 100) / 100;
                total = subtI + iva2;
            } else {
                total = subtI;
            }

            GastoIndirectoBean gasto = new GastoIndirectoBean();
            System.out.println(fechaI + " " + descI + " " + factI + " " + iva2 + " " + provI + " " + respI);
            gasto.setFechaIndirect(fechaI);
            gasto.setMesIndirect(mesI);
            gasto.setProveeIndirect(provI);
            gasto.setNumFactIndirect(factI);
            gasto.setDescIndirect(descI);
            gasto.setSubToIndirect(subtI);
            gasto.setIvaIndirect(iva2);
            gasto.setTotalIndirect(total);
            GastoIndirecto.agregarGasto(gasto);
            response.sendRedirect("indirecto");

        }
        if (userPath.equals("/actualizar_indi")) {

            int idI = Integer.parseInt(request.getParameter("idU"));
            String fechaI = request.getParameter("fechaU");
            String mesI = request.getParameter("mesU");
            String provI = request.getParameter("provU");
            String factI = request.getParameter("factU");
            String descI = request.getParameter("descU");
            float subtI = Float.parseFloat(request.getParameter("subtU"));
            String respI = request.getParameter("ivaU");
            float iva = 0;
            float total;
            float iva2 = 0;
            if (respI.equals("si")) {
                iva = 0.16f * subtI;
                iva2 = Math.round(iva * 100) / 100;
                total = subtI + iva2;
            } else {
                total = subtI;
            }
            GastoIndirectoBean gasto = new GastoIndirectoBean();
            gasto.setIdIndirect(idI);
            gasto.setFechaIndirect(fechaI);
            gasto.setMesIndirect(mesI);
            gasto.setProveeIndirect(provI);
            gasto.setNumFactIndirect(factI);
            gasto.setDescIndirect(descI);
            gasto.setSubToIndirect(subtI);
            gasto.setIvaIndirect(iva2);
            gasto.setTotalIndirect(total);
            GastoIndirecto.modificarGasto(gasto);
            response.sendRedirect("indirecto");
        }
    }
    
}
