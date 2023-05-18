package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.model.entity.Product;
import ra.model.service.product.ProductServiceImp;

import java.lang.reflect.Array;
import java.util.List;

@Controller
public class HomeCotroller {
    ProductServiceImp productService =new  ProductServiceImp();
    @RequestMapping("")
    public String index(Model model) {
        List<Product> list = productService.findAll();
        List<Product> listPage = productService.findProductByPage(1,10);
        int pageCount =(list.size()%10)==0? (list.size() / 10):(list.size()/10 +1);
        model.addAttribute("listProduct",listPage);
        model.addAttribute("pageCount",new Array[pageCount]);
        return "home";
    }
    @GetMapping("/page/{id}")
    public String page(@PathVariable("id") String id, Model model){
        List<Product> list = productService.findAll();
        List<Product> listPage = productService.findProductByPage(Integer.parseInt(id),10);
        int pageCount =(list.size()%10)==0? (list.size() / 10):(list.size()/10 +1);
        model.addAttribute("listProduct",listPage);
        model.addAttribute("pageCount",new Array[pageCount]);
        model.addAttribute("pageCurrent",Integer.parseInt(id));
        return "home";
    }
}
