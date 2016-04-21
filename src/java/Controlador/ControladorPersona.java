package Controlador;

import Beans.EmpleadoBean;
import Beans.PersonaBean;
import Beans.UserSystBean;
import Beans.UsuarioBean;
import Modelo.Empleado;
import Modelo.Persona;
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

/**
 *
 * @author Emmanuel
 */
@WebServlet(name = "ControladorPersona", urlPatterns = {"/ControladorPersona", "/persona", "/agregar_persona", "/modificar_persona", "/eliminar_persona", 
    "/definir_usuario","/agregar_empleado","/modificar_empleado"})
public class ControladorPersona extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String userPath = request.getServletPath();
        HttpSession varSesion = request.getSession();
        UserSystBean user = (UserSystBean) varSesion.getAttribute("usuario");
        if (user == null) {
            response.sendRedirect("acceso.jsp");
        } else if (userPath.equals("/persona")) {
            List<PersonaBean> listaTPersonas;
            listaTPersonas = Persona.listarPersonas();
            varSesion.setAttribute("personas", listaTPersonas);
            List<PersonaBean> listaPersonasD;
            listaPersonasD = Persona.listarPersonasSinDefinir();
            varSesion.setAttribute("personasd", listaPersonasD);
            List<EmpleadoBean> listaEmpleados;
            listaEmpleados = Empleado.listarEmpleados();
            varSesion.setAttribute("empleados", listaEmpleados);
            List<UsuarioBean> listaUsuarios;
            listaUsuarios = Solicitante.listarUsuarios();
            varSesion.setAttribute("usuarios", listaUsuarios);
            response.sendRedirect("persona.jsp");
        }if(userPath.equals("/eliminar_persona")){
            int idPersona = Integer.parseInt(request.getParameter("idPer"));
            Persona.eliminarPersona(idPersona);
            response.sendRedirect("persona");
        }if(userPath.equals("/definir_usuario")){
            int idPersona = Integer.parseInt(request.getParameter("idPer"));
            PersonaBean persona = new PersonaBean();
            persona.setIdPersona(idPersona);
            persona.setEstatusPersona("USUARIO");
            Persona.definirUsuario(persona);
            response.sendRedirect("persona");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String userPath = request.getServletPath();
        HttpSession varSesion = request.getSession();
        
        if(userPath.equals("/agregar_persona")){
            String nombre = request.getParameter("nombre");
            String apellidop = request.getParameter("apellidop");
            String apellidom = request.getParameter("apellidom");
            String calle = request.getParameter("calle");
            String num = request.getParameter("num");
            String colonia = request.getParameter("col");
            String ciudad = request.getParameter("cd");
            String estado = request.getParameter("edo");
            String telefono = request.getParameter("tel");
            String imss = request.getParameter("imss");
            String curp = request.getParameter("curp");
            String rfc = request.getParameter("rfc");
            String fecha = request.getParameter("fechai");
            
            PersonaBean persona = new PersonaBean();
            persona.setNombrePersona(nombre);
            persona.setApellidoPpersona(apellidop);
            persona.setApellidoMpersona(apellidom);
            persona.setCallePersona(calle);
            persona.setNumeroPersona(num);
            persona.setColoniaPersona(colonia);
            persona.setCiudadPersona(ciudad);
            persona.setEstadoPersona(estado);
            persona.setTelefonoPersona(telefono);
            persona.setNumSeguroPersona(imss);
            persona.setCurpPersona(curp);
            persona.setRfcPersona(rfc);
            persona.setFechaIngreso(fecha);
            persona.setEstatusPersona("SIN DEFINIR");
            
            Persona.agregarPersona(persona);
            response.sendRedirect("persona");
        }
        if(userPath.equals("/modificar_persona")){
            int idPersona = Integer.parseInt(request.getParameter("idPer"));
            String nombre = request.getParameter("nombre");
            String apellidop = request.getParameter("apellidop");
            String apellidom = request.getParameter("apellidom");
            String calle = request.getParameter("calle");
            String num = request.getParameter("num");
            String colonia = request.getParameter("col");
            String ciudad = request.getParameter("cd");
            String estado = request.getParameter("edo");
            String telefono = request.getParameter("tel");
            String imss = request.getParameter("imss");
            String curp = request.getParameter("curp");
            String rfc = request.getParameter("rfc");
            String fecha = request.getParameter("fechai");
            
            PersonaBean persona = new PersonaBean();
            persona.setIdPersona(idPersona);
            persona.setNombrePersona(nombre);
            persona.setApellidoPpersona(apellidop);
            persona.setApellidoMpersona(apellidom);
            persona.setCallePersona(calle);
            persona.setNumeroPersona(num);
            persona.setColoniaPersona(colonia);
            persona.setCiudadPersona(ciudad);
            persona.setEstadoPersona(estado);
            persona.setTelefonoPersona(telefono);
            persona.setNumSeguroPersona(imss);
            persona.setCurpPersona(curp);
            persona.setRfcPersona(rfc);
            persona.setFechaIngreso(fecha);
            persona.setEstatusPersona("SIN DEFINIR");
            
            Persona.modificarPersona(persona);
            response.sendRedirect("persona");
        }
        if(userPath.equals("/agregar_empleado")){
            int idPersona = Integer.parseInt(request.getParameter("idPer"));
            String puesto = request.getParameter("puesto");
            float salario = Float.parseFloat(request.getParameter("sal"));
            float info = Float.parseFloat(request.getParameter("info"));
            String cta = request.getParameter("banco");
            float trans = Float.parseFloat(request.getParameter("trans"));
            
            EmpleadoBean emp = new EmpleadoBean();
            emp.setIdPersona(idPersona);
            emp.setPuesto(puesto);
            emp.setInfonavit(info);
            emp.setSalarioxdia(salario);
            emp.setCuentaB(cta);
            emp.setTransa(trans);
            
            PersonaBean persona = new PersonaBean();
            persona.setIdPersona(idPersona);
            persona.setEstatusPersona("EMPLEADO");
            
            Empleado.definirEmpleado(persona, emp);
            response.sendRedirect("persona");
        }
        if(userPath.equals("/modificar_empleado")){
            int idPersona = Integer.parseInt(request.getParameter("idPer"));
            String puesto = request.getParameter("puesto");
            float salario = Float.parseFloat(request.getParameter("sal"));
            float info = Float.parseFloat(request.getParameter("info"));
            String cta = request.getParameter("banco");
            float trans = Float.parseFloat(request.getParameter("trans"));
            
            EmpleadoBean emp = new EmpleadoBean();
            emp.setIdEmpleado(idPersona);
            emp.setPuesto(puesto);
            emp.setInfonavit(info);
            emp.setSalarioxdia(salario);
            emp.setCuentaB(cta);
            emp.setTransa(trans);
            
            
            Empleado.modificarEmpleado(emp);
            response.sendRedirect("persona");
            
        }
        
    }

}
