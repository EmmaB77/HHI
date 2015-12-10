package Modelo;

import Beans.CotDetalleBean;
import Beans.CotizacionBean;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleCotizacion {
    
    public static int agregar(Connection con, CotDetalleBean detalleCot){
        int status=0;
        PreparedStatement ps;
        /*|ID_COTI INT|INCISO|DESC_DETAIL|CANTIDAD|UNIDAD|IMPORTE*/
        String query="insert into detalle_cot (id_coti,inciso,desc_detail,cantidad,unidad,importe) values (?,?,?,?,?,?)";
        try{
            ps=con.prepareStatement(query);
            ps.setObject(1, detalleCot.getIdCot());
            ps.setObject(2, detalleCot.getIncisoCotDet());
            ps.setObject(3, detalleCot.getDescCotDet());
            ps.setObject(4, detalleCot.getCantCotDet());
            ps.setObject(5, detalleCot.getUniCotDet());
            ps.setObject(6, detalleCot.getImporteCotDet());
            status=ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
        return status;
    }
    
    public int modificar(){
        int status=0;
        return status;
    }
    
    public int eliminar(){
        int status=0;
        return status;
    }
    
    public static int eliminarPorIdCot(Connection cn, int idCot){
        int status= 0;
        PreparedStatement ps;
        String query="delete from detalle_cot where id_coti=?";
        try{
            ps=cn.prepareStatement(query);
            ps.setObject(1, idCot);
            status=ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
        return status;
    }
    
    public static List<CotDetalleBean> listarDetallesPorCot(int idCot){
        Connection con=Conexion.getConnetion();
        List<CotDetalleBean> lista = new ArrayList<>();
        PreparedStatement ps;
        String query="select id_receta, id_medicamento, especificacion from detalle_receta where id_receta=?";
        try{
            ps=con.prepareStatement(query);
            ps.setObject(1, idCot);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                CotDetalleBean detalle;
                detalle = DetalleCotizacion.obtenerDetalle(rs.getInt("id_medicamento"));
                lista.add(detalle);
            }
            con.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return lista;
    }
    
    public static CotDetalleBean obtenerDetalle(int idMedicamento){
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query="select id_coti, inciso, desc_detail, cantidad, unidad, importe from detalle_cot where id_coti=?";
        CotDetalleBean detalle = new CotDetalleBean();
        try{
            ps=con.prepareStatement(query);
            ps.setObject(1, idMedicamento);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                /*|ID_COTI|INCISO|DESC_DETAIL|CANTIDAD|UNIDAD|IMPORTE*/
                /*select id_coti, inciso, desc_detail, cantidad, unidad, importe where id_coti=?*/
                detalle.setIdCot(rs.getInt("id_coti"));
                detalle.setIncisoCotDet(rs.getInt("inciso"));
                detalle.setDescCotDet(rs.getString("desc_detail"));
                detalle.setCantCotDet(rs.getInt("cantidad"));
                detalle.setUniCotDet(rs.getString("unidad"));
                detalle.setImporteCotDet(rs.getFloat("importe"));
            }
            con.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return detalle;
    }
    
    /*public static List<CotDetalleBean> detallePorCot(int idReceta){
        Connection con=Conexion.getConnetion();
        List<CotDetalleBean> lista = new ArrayList<>();
        PreparedStatement ps;
        String query="select id_receta, id_medicamento, especificacion from detalle_receta where id_receta=?";
        try{
            ps=con.prepareStatement(query);
            ps.setObject(1, idReceta);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                CotDetalleBean detalle = new CotDetalleBean();
                detalle.setMedicamento(Medicamento.obtenerMedicamento(rs.getInt("id_medicamento")));
                detalle.setEspecificacion(rs.getString("especificacion"));
                lista.add(detalle);
            }
            con.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return lista;
    }*/
    
}
