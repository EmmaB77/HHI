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
        if (userPath.equals("/calcularnom")) {
            int idEmp = Integer.parseInt(request.getParameter("idEmp"));
            String semana = request.getParameter("semana");
            float viernes = Float.parseFloat(request.getParameter("viernes"));
            float sabado = Float.parseFloat(request.getParameter("sabado"));
            float domingo = Float.parseFloat(request.getParameter("domingo"));
            float lunes = Float.parseFloat(request.getParameter("lunes"));
            float martes = Float.parseFloat(request.getParameter("martes"));
            float miercoles = Float.parseFloat(request.getParameter("miercoles"));
            float jueves = Float.parseFloat(request.getParameter("jueves"));
            float hrsTotales = viernes+sabado+domingo+lunes+martes+miercoles+jueves;
            float hrex1;
            float hrex2;
            float salario = nomina.obtenerSalario(idEmp);
            float salarioL;
            float salarioM;
            float salarioMie;
            float salarioJ;
            float salarioV;
            float salarioS;
            float salarioD;
            float sueldo;
            
            
            if(domingo>0){
                hrex1 = domingo*2;
            }else{
                hrex1 = domingo;
            }

            if(sabado>0){
                hrex2 = sabado*2;
            }else{
                hrex2 = sabado;
            }
            
            
            salarioL = salario*lunes;
            salarioM = salario*martes;
            salarioMie = salario*miercoles;
            salarioJ = salario*jueves;
            salarioV = salario * viernes;
            salarioS = salario * hrex2;
            salarioD = salario * hrex1;
           
            sueldo = salarioL+salarioM+salarioMie+salarioJ+salarioV+salarioS+salarioD;
            
            NominaBean nominac = new NominaBean();
            nominac.setId_empleado(idEmp);
            nominac.setSemanaNom(semana);
            nominac.setHrsViernes(viernes);
            nominac.setHrsSabado(sabado);
            nominac.setHrsDomingo(domingo);
            nominac.setHrsLunes(lunes);
            nominac.setHrsMartes(martes);
            nominac.setHrsMiercoles(miercoles);
            nominac.setHrsJueves(jueves);
            nominac.setHrsTotales(hrsTotales);
            nominac.setSalarioT(sueldo);
            
            nomina.calcularNom(nominac);
            response.sendRedirect("nomina");
        }
    }
}