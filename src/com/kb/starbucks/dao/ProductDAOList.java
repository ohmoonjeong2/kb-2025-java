package com.kb.starbucks.dao;

import com.kb.starbucks.vo.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOList implements ProductDAO {
    private List<Product> products; //저장소
    public ProductDAOList() {
        products = new ArrayList<Product>();
    }
    @Override
    public void insert(Product product) {
        if(products.contains(product)){
            return;
        }
        products.add(product);
    }

    @Override
    public Product findByProdNo(String prodNo) {
        Product p = new Product();
        p.setProdNo(prodNo);
        try {
            return products.get(products.indexOf(p));
        }catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void update(Product product) {
        products.set(products.indexOf(product), product);
    }

    @Override
    public void delete(String prodNo) {
        Product p = new Product();
        p.setProdNo(prodNo);
        //products.remove(products.indexOf(prodNo)); //저 틀렸슴다~
        products.remove(products.indexOf(p));
    }
}
