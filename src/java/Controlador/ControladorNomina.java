package Controlador;

import Beans.EmpleadoBean;
import Beans.NominaBean;
import Beans.UserSystBean;
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
            List<EmpleadoBean> listaEmpleados;
            listaEmpleados = Empleado.listarEmpleados();
            varSesion.setAttribute("nominas", listaNomina);
            varSesion.setAttribute("empleados", listaEmpleados);
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
        if (userPath.equals("/calcularnom")) {
            int idEmp = Integer.parseInt(request.getParameter("idEmp"));
            String semana1 = request.getParameter("semana1");
            String semana2 = request.getParameter("semana2");
            String semana = "Semana del "+semana1+" al "+semana2;
            float viernes = Float.parseFloat(request.getParameter("viernes"));
            float lunes = Float.parseFloat(request.getParameter("lunes"));
            float martes = Float.parseFloat(request.getParameter("martes"));
            float miercoles = Float.parseFloat(request.getParameter("miercoles"));
            float jueves = Float.parseFloat(request.getParameter("jueves"));
            float hrsExtra = Float.parseFloat(request.getParameter("tiempo_extra"));
            float hrsSemana = viernes+lunes+martes+miercoles+jueves;
            float hrsTotales = viernes+lunes+martes+miercoles+jueves+hrsExtra;
            float salario1;
            float salario2;
            float sueldo;
            
            salario1 = hrsSemana * nomina.obtenerSalario(idEmp);
            salario2 = hrsExtra * nomina.obtenerSalario(idEmp) * 2;

            sueldo = salario1 + salario2;
            
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
            nominac.setSueldoT(sueldo);
            nomina.calcularNom(nominac);
            response.sendRedirect("nomina");
        }
        
        if(userPath.equals("/descontarnom")){
            
            String dia = request.getParameter("dia");
            int idNom = Integer.parseInt(request.getParameter("idNomi"));
            int idEmp = Integer.parseInt(request.getParameter("idEmpe"));
            float horas = Float.parseFloat(request.getParameter("horas"));
            NominaBean nom = new NominaBean();
            nom.setIdNom(idNom);
            nom.setId_empleado(idEmp);
            nomina.descontarNom(idNom, dia, horas, idEmp);
            response.sendRedirect("nomina");  
        }
    }
}