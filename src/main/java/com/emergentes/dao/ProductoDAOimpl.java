
package com.emergentes.dao;

import com.emergentes.modelo.Productos;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milton
 */
public class ProductoDAOimpl extends ConexionDB implements ProductoDAO {

    @Override
    public void insert(Productos productos) throws Exception {
        try{
            this.conectar();
            String sql = "INSERT INTO productos(descripcion, cantidad, precio, categoria) values(?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,productos.getDescripcion());
            ps.setInt(2,productos.getCantidad());
            ps.setFloat(3,productos.getPrecio());
            ps.setString(4,productos.getDescripcion());

            ps.executeUpdate();
        }
        catch(Exception e){
            throw e;
        }
        finally{
            this.desconectar();
        }
        
        
    }

    @Override
    public void update(Productos productos) throws Exception {
        try{
            this.conectar();
            String sql = "UPDATE productos SET descripcion = ?, cantidad = ?, precio = ?, categoria = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,productos.getDescripcion());
            ps.setInt(2,productos.getCantidad());
            ps.setFloat(3,productos.getPrecio());
            ps.setString(4,productos.getDescripcion());

            ps.executeUpdate();
        
        }
        catch(Exception e){
            throw e;
        }
        finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        
        try{
            this.conectar();
            String sql = "DELETE FROM productos WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(2,id);
        }
        catch(SQLException e){
            throw e;
        }
        finally{
            this.desconectar();
        }
        
    }

    @Override
    public Productos getById(int id) throws Exception {
        Productos pro = new Productos();
         try{
            this.conectar();
            String sql = "SELECT * FROM productos";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            

            if(rs.next()){
                pro.setId(rs.getInt("id"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setCantidad(rs.getInt("cantidad"));
                pro.setPrecio(rs.getFloat("precio"));
                pro.setCategoria(rs.getString("categoria"));
            }
        
        }
        catch(SQLException e){
            throw e;
        }
        finally{
            this.desconectar();
        }
        
        return pro;
        
    }

    @Override
    public List<Productos> getAll() throws Exception {
        ArrayList<Productos> lista = new ArrayList<Productos>();

        try{
            this.conectar();
            String sql = "SELECT * FROM productos";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Productos pro = new Productos();

                pro.setId(rs.getInt("id"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setCantidad(rs.getInt("cantidad"));
                pro.setPrecio(rs.getFloat("precio"));
                pro.setCategoria(rs.getString("categoria")); 

                lista.add(pro);
            }

            rs.close();
            ps.close();
        }
        catch(SQLException e){
            throw e;
        }
        finally{
            this.desconectar();
        }
        
        return lista;
    }
    
}
