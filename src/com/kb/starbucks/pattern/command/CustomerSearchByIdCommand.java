package com.kb.starbucks.pattern.command;

import com.kb.starbucks.dao.CustomerDAO;
import com.kb.starbucks.vo.Customer;

import java.util.Scanner;

public class CustomerSearchByIdCommand implements StarbucksCommand {
    private CustomerDAO cDao;
    private Scanner sc;

    public CustomerSearchByIdCommand(CustomerDAO cDao, Scanner sc) {
        this.cDao = cDao;
        this.sc = sc;
    }


    @Override
    public void command() {
        System.out.println(">>고객 ID로 조회");
        System.out.println("고객ID:");
        String id = sc.nextLine();
        Customer c = cDao.findById(id);
        System.out.println(c); //고객정보가 다음과 같이 출력된다 : id는 XXX, pwd는 YYY, 이름은 ZZ
        //id에 해당고객이 없다면 null이 출력된다
    }
}
