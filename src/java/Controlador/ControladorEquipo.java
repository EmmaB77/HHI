/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Beans.InversionEquipoBean;
import Beans.UserSystBean;
import Modelo.InversionEquipo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ControladorEquipo", urlPatterns = {"/ControladorEquipo", "/inversion", "/eliminar_equipo", "/agregar_equipo","/actualizar_inve"})
public class ControladorEquipo extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String userPath = request.getServletPath();
        HttpSession varSesion = request.getSession();
        UserSystBean user = (UserSystBean) varSesion.getAttribute("usuario");
        if (user == null) {
            response.sendRedirect("acceso.jsp");
        } else if (userPath.equals("/inversion")) {
            List<InversionEquipoBean> listaEquipo;
            listaEquipo = InversionEquipo.listaEquipo();
            varSesion.setAttribute("equipos", listaEquipo);
            response.sendRedirect("inversionHerramienta.jsp");
            System.out.println(listaEquipo);
        } else {
            System.out.println("Something is wrong, I can't know what thing... I'm Sorry :(");
        }
        if (userPath.equals("/eliminar_equipo")) {
            int idTool = Integer.parseInt(request.getParameter("idEquipo"));
            InversionEquipo.eliminarEquipo(idTool);
            response.sendRedirect("inversion");
        } else {
            System.out.println("Something is wrong, I can't know what thing... I'm Sorry :(");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String userPath = request.getServletPath();
        HttpSession varSesion = request.getSession();

        if (userPath.equals("/agregar_equipo")) {
            String fechaE = request.getParameter("fecha");
            String provE = request.getParameter("prov");
            String factE = request.getParameter("fact");
            String descE = request.getParameter("desc");
            float subtE = Float.parseFloat(request.getParameter("subt"));
            String respE = request.getParameter("iva");
            float iva = 0;
            float total;
            float iva2 = 0;
            if (respE.equals("si")) {
                iva = 0.16f * subtE;
                iva2 = Math.round(iva * 100) / 100;
                total = subtE + iva2;
            } else {
                total = subtE;
            }

            InversionEquipoBean equipo = new InversionEquipoBean();
            System.out.println(fechaE + " " + descE + " " + factE + " " + iva2 + " " + provE + " " + respE);
            equipo.setFechaEquipo(fechaE);
            equipo.setProveedorEquipo(provE);
            equipo.setFacturaEquipo(factE);
            equipo.setDescripEquipo(descE);
            equipo.setSubtEquipo(subtE);
            equipo.setIvaEquipo(iva2);
            equipo.setTotalEquipo(total);
            InversionEquipo.agregarEquipo(equipo);
            response.sendRedirect("inversion");

        }
        if (userPath.equals("/actualizar_inve")) {

            int idE = Integer.parseInt(request.getParameter("idU"));
            String fechaE = request.getParameter("fechaU");
            String provE = request.getParameter("provU");
            String factE = request.getParameter("factU");
            String descE = request.getParameter("descU");
            float subtE = Float.parseFloat(request.getParameter("subtU"));
            String respE = request.getParameter("ivaU");
            float iva = 0;
            float total;
            float iva2 = 0;
            if (respE.equals("si")) {
                iva = 0.16f * subtE;
                iva2 = Math.round(iva * 100) / 100;
                total = subtE + iva2;
            } else {
                total = subtE;
            }

            InversionEquipoBean equipo = new InversionEquipoBean();
            equipo.setIdEquipo(idE);
            equipo.setFechaEquipo(fechaE);
            equipo.setProveedorEquipo(provE);
            equipo.setFacturaEquipo(factE);
            equipo.setDescripEquipo(descE);
            equipo.setSubtEquipo(subtE);
            equipo.setIvaEquipo(iva2);
            equipo.setTotalEquipo(total);
            InversionEquipo.modificarEquipo(equipo);
            response.sendRedirect("inversion");
        }
    }
}
