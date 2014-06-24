package fr.norsys.dojo.service;

import fr.norsys.dojo.model.OrderInfo;
import fr.norsys.dojo.model.Product;
import fr.norsys.dojo.model.ShoppingCart;

import java.util.List;

public interface CartService {

    ShoppingCart getShoppingCart();

    List<Product> getProducts();

    Product getProduct(long productId);

    OrderInfo createOrderInfo();

    void submitOrder(OrderInfo orderInfo);
}
