package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.model.entity.CartItem;
import ra.model.entity.Product;
import ra.model.entity.UserLogin;
import ra.model.service.cart.CartServiceImp;
import ra.model.service.product.ProductServiceImp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("cartController")
public class CartController {
    CartServiceImp cartService = new CartServiceImp();
    ProductServiceImp productService = new ProductServiceImp();

    @RequestMapping("")
    public String cart(HttpServletRequest request, Model model) {
        UserLogin userLogin = (UserLogin) request.getSession().getAttribute("userLogin");
        if (userLogin == null) {
            return "redirect:/userController/form-login";
        } else {
            List<CartItem> list = cartService.FindAllByCartId(userLogin.getCartId());
            model.addAttribute("listCart", list);
            return "cart";
        }
    }

    @GetMapping("/add-to-cart/{proId}")
    public String addToCart(@PathVariable("proId") String proId, HttpSession session) {
        UserLogin userLogin = (UserLogin) session.getAttribute("userLogin");
        Product p = productService.findById(Integer.valueOf(proId));
        CartItem cartItem = cartService.findCartItemByID(userLogin.getCartId(), Integer.parseInt(proId));
        if (cartItem == null) {
            cartService.save(new CartItem(0,userLogin.getCartId(),p.getId(),p.getPrice(),1));
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            cartService.update(cartItem);
        }
        return "redirect:/cartController";

    }
    @GetMapping("/delete/{cartItemId}")
    public String delete(@PathVariable("cartItemId") String id){
        cartService.delete(Integer.valueOf(id));
        return "redirect:/cartController";
    }
    @GetMapping("/update")
    public  String update(@RequestParam("cdId") String cdId,@RequestParam("quantity") String quantity){
        cartService.update(new CartItem(Integer.valueOf(cdId),Integer.valueOf(quantity)));
        return "redirect:/cartController";
    }
}
