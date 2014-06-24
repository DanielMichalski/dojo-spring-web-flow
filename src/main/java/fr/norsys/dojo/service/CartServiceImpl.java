package fr.norsys.dojo.service;

import fr.norsys.dojo.model.OrderInfo;
import fr.norsys.dojo.model.Product;
import fr.norsys.dojo.model.ShoppingCart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service("cartService")
public class CartServiceImpl implements CartService {

    private Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    @Autowired
    private ShoppingCart cart;

    private Map<Long, Product> products = new HashMap<Long, Product>();

    public CartServiceImpl() {
        addProduct(1L, "Kayak Freestyle", 699, "item_1.jpg");
        addProduct(2L, "Kayak Mer", 1299, "item_2.jpg");
        addProduct(3L, "Kayak Polo", 599, "item_3.jpg");
    }

    private void addProduct(Long id, String desc, double price, String imgUrl) {
        Product product = new Product(id, desc, price, imgUrl);
        products.put(id, product);
    }

    public ShoppingCart getShoppingCart() {
        return cart;
    }

    public void setShoppingCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public List<Product> getProducts() {
        List<Product> list = new ArrayList<Product>(products.values());
        Collections.sort(list);
        return list;
    }

    public Product getProduct(long productId) {
        return products.get(productId);
    }

    public OrderInfo createOrderInfo() {
        return new OrderInfo();
    }

    public void submitOrder(OrderInfo orderInfo) {
        logger.info("PROCEED ORDER");
        logger.info("First Name : " + orderInfo.getFirstName());
        logger.info("Last Name : " + orderInfo.getLastName());
        logger.info("Adress : " + orderInfo.getAdress());
        logger.info("CreditCard : " + orderInfo.getCreditCardNumber());
    }
}
