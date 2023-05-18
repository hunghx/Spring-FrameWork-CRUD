package ra.model.service.cart;

import ra.model.entity.CartItem;
import ra.model.service.IService;

import java.util.List;

public interface IcartService extends IService<CartItem,Integer> {
    boolean clearCart(int cartId);
    List<CartItem>  FindAllByCartId(int cartId);
    CartItem findCartItemByID(int cartId, int productId);
}
