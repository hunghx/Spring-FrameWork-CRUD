package ra.model.service.product;

import ra.model.entity.Product;
import ra.model.service.IService;

import java.util.List;

public interface IProductService extends IService<Product,Integer> {

    List<Product> findProductByPage(int page, int count);
}
