package com.kb.starbucks.pattern.command;

import com.kb.starbucks.dao.ProductDAO;
import com.kb.starbucks.vo.Product;

import java.util.Scanner;

public class ProductSearchByNoCommand implements StarbucksCommand {
    private Scanner sc;
    private ProductDAO pDao;

    public ProductSearchByNoCommand(ProductDAO pDao, Scanner sc) {
        this.pDao = pDao;
        this.sc = sc;
    }

    @Override
    public void command() {
        System.out.println(">>상품 상세조회<<");
        System.out.println("상품번호:");
        String prodNo = sc.nextLine();
        Product p = pDao.findByProdNo(prodNo);
        System.out.println(p); //p.getProdName(); NullPointerException발생가능

    }
}
