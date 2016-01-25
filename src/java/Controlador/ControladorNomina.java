package Controlador;

import Beans.EmpleadoBean;
import Beans.NominaBean;
import Beans.UserSystBean;
import Beans.ProyectoBean;
import Modelo.Proyecto;
import Modelo.nomina;
import Modelo.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControladorNomina", urlPatterns = {"/ControladorNomina", "/calcularnom", "/descontarnom", "/nomina", "/recibo", "/generar"})
public class ControladorNomina extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String userPath = request.getServletPath();
        HttpSession varSesion = request.getSession();
        UserSystBean user = (UserSystBean) varSesion.getAttribute("usuario");
        if (user == null) {
            response.sendRedirect("acceso.jsp");
        } else if (userPath.equals("/nomina")) {
            List<NominaBean> listaNomina;
            listaNomina = nomina.listaNom();
            List<EmpleadoBean> listaEmpleados;
            listaEmpleados = Empleado.listarEmpleados();
            List<ProyectoBean> listaProyectos;
            listaProyectos = Proyecto.listaProyectos();
            varSesion.setAttribute("proyectos", listaProyectos);
            varSesion.setAttribute("nominas", listaNomina);
            varSesion.setAttribute("empleados", listaEmpleados);
            response.sendRedirect("nomina.jsp");
        } else if (userPath.equals("/recibo")) {
            List<NominaBean> listaSemanas;
            listaSemanas = nomina.listaSemanas();
            varSesion.setAttribute("semanas", listaSemanas);
            response.sendRedirect("recibosN.jsp");
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
        if (userPath.equals("/calcularnom")) {
            int idEmp = Integer.parseInt(request.getParameter("idEmp"));
            String semana1 = request.getParameter("semana1");
            String semana2 = request.getParameter("semana2");
            String semana = "Semana del " + semana1 + " al " + semana2;
            float viernes = Float.parseFloat(request.getParameter("viernes"));
            float lunes = Float.parseFloat(request.getParameter("lunes"));
            float martes = Float.parseFloat(request.getParameter("martes"));
            float miercoles = Float.parseFloat(request.getParameter("miercoles"));
            float jueves = Float.parseFloat(request.getParameter("jueves"));
            float hrsExtra = Float.parseFloat(request.getParameter("tiempo_extra"));
            float sobreS = Float.parseFloat(request.getParameter("sobre"));
            float viaticos = Float.parseFloat(request.getParameter("viaticos"));
            float otrosI = Float.parseFloat(request.getParameter("otrosI"));
            float deducc = Float.parseFloat(request.getParameter("deducciones"));
            float infonavit = nomina.obtenerDescInfonavit(idEmp);
            float hrsSemana = viernes + lunes + martes + miercoles + jueves;
            float hrsTotales = viernes + lunes + martes + miercoles + jueves + hrsExtra;
            float normal;
            float extra;
            float ingresos;
            float deducciones;
            float sueldo;

            normal = hrsSemana * nomina.obtenerSalario(idEmp);
            extra = hrsExtra * nomina.obtenerSalario(idEmp) * 2;

            ingresos = normal + extra + sobreS + viaticos + otrosI;
            deducciones = deducc + infonavit;

            sueldo = ingresos - deducciones;

            NominaBean nominac = new NominaBean();
            nominac.setId_empleado(idEmp);
            nominac.setSemanaNom(semana);
            nominac.setHrsViernes(viernes);
            nominac.setHrsLunes(lunes);
            nominac.setHrsMartes(martes);
            nominac.setHrsMiercoles(miercoles);
            nominac.setHrsJueves(jueves);
            nominac.setHrsExtra(hrsExtra);
            nominac.setHrsTotales(hrsTotales);
            nominac.setSobresueldo(sobreS);
            nominac.setViaticos(viaticos);
            nominac.setOtros_ingresos(otrosI);
            nominac.setInfonavit(infonavit);
            nominac.setOtros_deducciones(deducc);
            nominac.setSueldoEx(extra);
            nominac.setSueldo_N(normal);
            nominac.setTotal_ingresos(ingresos);
            nominac.setTotal_deducciones(deducciones);
            nominac.setSueldoT(sueldo);
            nomina.calcularNom(nominac);
            System.out.println("Normal: " + normal + ", Extra: " + extra + ", Total Ingresos: " + ingresos + ", Total Deducciones: " + deducciones + ", Sueldo Total: " + sueldo);
            response.sendRedirect("nomina");
        }

        if (userPath.equals("/descontarnom")) {

            String dia = request.getParameter("dia");
            int idNom = Integer.parseInt(request.getParameter("idNomD"));
            int idEmp = Integer.parseInt(request.getParameter("idEmD"));
            float horas = Float.parseFloat(request.getParameter("horas"));
            NominaBean nom = new NominaBean();
            nom.setIdNom(idNom);
            nom.setId_empleado(idEmp);
            nomina.descontarNom(idNom, dia, horas, idEmp);
            response.sendRedirect("nomina");
        }

        if (userPath.equals("/generar")) {
            String semana = request.getParameter("semana");
            List<NominaBean> listaNomina;
            listaNomina = nomina.listaNomxSem(semana);
            List<EmpleadoBean> listaEmpleados;
            listaEmpleados = Empleado.listarEmpleados();
            List<NominaBean> listaSemanas;
            listaSemanas = nomina.listaSemanas();
            varSesion.setAttribute("semanas", listaSemanas);
            varSesion.setAttribute("nominas", listaNomina);
            varSesion.setAttribute("empleados", listaEmpleados);
            response.sendRedirect("recibosN.jsp");
        }
    }
}
