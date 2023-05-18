package ra.model.service.product;

import ra.model.entity.Product;
import ra.model.entity.Student;
import ra.model.util.ConnectionToDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImp implements IProductService{
    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        Connection conn = null;

        try {
            conn= ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_FindAllProduct()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setStock(rs.getInt("quantity"));
                p.setImage_url(rs.getString("image_url"));
                p.setPrice(rs.getDouble("price"));
                list.add(p);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                ConnectionToDB.close(conn);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public boolean save(Product product) {
        return false;
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public Product findById(Integer id) {
        Connection conn = null;
        Product p = null;
        try {
            conn= ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_FindProductById(?)}");
            callSt.setInt(1,id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setStock(rs.getInt("quantity"));
                p.setImage_url(rs.getString("image_url"));
                p.setPrice(rs.getDouble("price"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                ConnectionToDB.close(conn);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return p;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public List<Product> findProductByPage(int page, int count) {
        List<Product> list = new ArrayList<>();
        Connection conn = null;

        try {
            conn= ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_FindProductByPage(?,?)}");
            callSt.setInt(1,page);
            callSt.setInt(2,count);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setStock(rs.getInt("quantity"));
                p.setImage_url(rs.getString("image_url"));
                p.setPrice(rs.getDouble("price"));
                list.add(p);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                ConnectionToDB.close(conn);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
