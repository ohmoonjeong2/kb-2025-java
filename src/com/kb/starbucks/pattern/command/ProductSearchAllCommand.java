package com.kb.starbucks.pattern.command;

import com.kb.starbucks.dao.ProductDAO;
import com.kb.starbucks.vo.Product;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ProductSearchAllCommand implements StarbucksCommand {
    private ProductDAO pDao;
    private Scanner    scanner;
    public ProductSearchAllCommand(ProductDAO pDao, Scanner sc) {
        this.pDao = pDao;this.scanner =  sc;
    }

    @Override
    public void command() {
        System.out.println(">>상품 전체조회<<");
        List<Product> all = pDao.findAll();
//        for(Product p : all){
//            System.out.println(p);
//        }
        Stream<Product> stream = all.stream();
        stream.forEach(System.out::println);
    }
}
