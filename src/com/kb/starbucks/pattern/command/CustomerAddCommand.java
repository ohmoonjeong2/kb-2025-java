package com.kb.starbucks.pattern.command;

import com.kb.starbucks.dao.CustomerDAO;
import com.kb.starbucks.vo.Customer;

import java.util.Scanner;

public class CustomerAddCommand implements StarbucksCommand {
    private CustomerDAO cDao;
    private Scanner sc;

    public CustomerAddCommand(CustomerDAO cDao, Scanner sc) {
        this.cDao = cDao;
        this.sc = sc;
    }

    @Override
    public void command() {
        System.out.println(">>고객추가<<");
        System.out.println("고객ID:");
        String id = sc.nextLine();
        System.out.println("고객비번:");
        String pwd = sc.nextLine();
        System.out.println("고객이름:");
        String name = sc.nextLine();
        cDao.insert(new Customer(id, pwd, name));
    }
}
