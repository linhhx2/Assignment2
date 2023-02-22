package dao;

import model.Customer;
import model.Product;

import java.io.IOException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private List<Product> products;
    private static final String SOURCE="products.txt";
    public ProductDaoImpl() throws IOException {

    }
}
