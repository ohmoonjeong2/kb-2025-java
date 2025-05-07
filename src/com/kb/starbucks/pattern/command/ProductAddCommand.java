package com.kb.starbucks.pattern.command;

import com.kb.starbucks.dao.ProductDAO;
import com.kb.starbucks.vo.Product;

import java.util.Scanner;

public class ProductAddCommand implements StarbucksCommand {
    private Scanner sc;
    private ProductDAO pDao;

    public ProductAddCommand(ProductDAO pDao, Scanner sc) {
        this.sc = sc;
        this.pDao = pDao;
    }

    @Override
    public void command() {
        System.out.println(">>상품추가<<");
        System.out.println("상품번호:");
        String prodNo = sc.nextLine();
        System.out.println("상품이름:");
        String prodName = sc.nextLine();
        System.out.println("상품가격:");
        int prodPrice = Integer.parseInt(sc.nextLine());
        pDao.insert(new Product(prodNo, prodName, prodPrice));
        System.out.println(">>상품추가 성공<<");
    }
}
