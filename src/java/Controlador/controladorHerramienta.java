package Controlador;

import Beans.HerramientaBean;
import Beans.UserSystBean;
import Modelo.Inventario;
import Modelo.UserSystem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "controladorHerramienta", urlPatterns = {"/agregar_tool", "/eliminar_tool", "/tool", "/modificar_tool"})
public class controladorHerramienta extends HttpServlet {

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
        } else if (userPath.equals("/tool")) {
            List<HerramientaBean> listaTools;
            listaTools = Inventario.listaTools();
            varSesion.setAttribute("herramientas", listaTools);
            response.sendRedirect("controlInventario.jsp");
            System.out.println(userPath + " " + user);
        }
        if (userPath.equals("/eliminar_tool")) {
            int idTool = Integer.parseInt(request.getParameter("idHerramienta"));
            Inventario.eliminarTool(idTool);
            response.sendRedirect("tool");
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

        if (userPath.equals("/agregar_tool")) {
            String descTool = request.getParameter("desc");
            int cantTool = Integer.parseInt(request.getParameter("cant"));
            String tipoTool = request.getParameter("uni");
            String obseTool = request.getParameter("obse");
            String estTool = request.getParameter("est");

            HerramientaBean tool = new HerramientaBean();
            tool.setDescHerramienta(descTool);
            tool.setCantidadHerramienta(cantTool);
            tool.setTipoUniHerramienta(tipoTool);
            tool.setObservacionesHerramienta(obseTool);
            tool.setEstatusHerramienta(estTool);
            Inventario.agregarHerramienta(tool);
            response.sendRedirect("tool");
        }
        if (userPath.equals("/modificar_tool")) {

            int idTool = Integer.parseInt(request.getParameter("idu"));
            String descTool = request.getParameter("descu");
            int canTool = Integer.parseInt(request.getParameter("cantu"));
            String tipoTool = request.getParameter("uniu");
            String obseTool = request.getParameter("obseu");
            String estaTool = request.getParameter("estu");

            HerramientaBean tool = new HerramientaBean();
            tool.setIdHerramienta(idTool);
            tool.setDescHerramienta(descTool);
            tool.setCantidadHerramienta(canTool);
            tool.setTipoUniHerramienta(tipoTool);
            tool.setObservacionesHerramienta(obseTool);
            tool.setEstatusHerramienta(estaTool);
            Inventario.modificarTool(tool);
            response.sendRedirect("tool");
        }
    }
}
