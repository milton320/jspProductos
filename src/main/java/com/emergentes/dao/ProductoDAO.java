package com.emergentes.dao;

import com.emergentes.modelo.Productos;
import java.util.List;

/**
 *
 * @author Milton
 */
public interface ProductoDAO {
    public void insert(Productos productos) throws Exception;
    public void update(Productos productos) throws Exception;
    public void delete(int id) throws Exception;
    public Productos getById(int id) throws Exception;
    public List<Productos> getAll() throws Exception;
}
