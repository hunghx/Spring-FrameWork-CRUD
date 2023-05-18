package ra.model.service.cart;

import ra.model.entity.CartItem;
import ra.model.entity.Product;
import ra.model.util.ConnectionToDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartServiceImp implements IcartService {
    @Override
    public List<CartItem> findAll() {
        return null;
    }

    @Override
    public List<CartItem> FindAllByCartId(int cartId) {
        List<CartItem> list = new ArrayList<>();
        Connection conn = null;

        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_FindListOrderDetail(?)}");
            callSt.setInt(1, cartId);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                CartItem c = new CartItem();
                c.setId(rs.getInt("id"));
                c.setOrderId(rs.getInt("order_id"));
                c.setProductId(rs.getInt("product_id"));
                c.setPrice(rs.getDouble("product_price"));
                c.setQuantity(rs.getInt("quantity"));
                c.setName(rs.getString("name"));
                c.setImageUrl(rs.getString("image_url"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionToDB.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public boolean save(CartItem cartItem) {
        Connection conn = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_CreateOrderDetail(?,?,?,?)}");
            callSt.setInt(1, cartItem.getOrderId());
            callSt.setInt(2, cartItem.getProductId());
            callSt.setDouble(3, cartItem.getPrice());
            callSt.setInt(4, cartItem.getQuantity());
            callSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionToDB.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean update(CartItem cartItem) {
        Connection conn = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_ChangeQuantity(?,?)}");
            callSt.setInt(1, cartItem.getId());
            callSt.setInt(2, cartItem.getQuantity());
            callSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionToDB.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public CartItem findById(Integer cartItemId) {
        return null;
    }

    @Override
    public CartItem findCartItemByID(int cartId, int productId) {
        List<CartItem> list = FindAllByCartId(cartId);
        for (CartItem c : list) {
            if (c.getProductId() == productId) {
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean delete(Integer idDel) {
        Connection conn = null;

        try {
            conn= ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_DeleteOrderDetail(?)}");
            callSt.setInt(1,idDel);
            callSt.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                ConnectionToDB.close(conn);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean clearCart(int cartId) {
        Connection conn = null;

        try {
            conn= ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_ClearCartDetail(?)}");
            callSt.setInt(1,cartId);
            callSt.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                ConnectionToDB.close(conn);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
