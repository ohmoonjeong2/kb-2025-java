package com.kb.starbucks.service;

import com.kb.starbucks.dao.CustomerDAO;
import com.kb.starbucks.exception.FindException;
import com.kb.starbucks.vo.Customer;

public class CustomerService {
    private CustomerDAO cDAO;
    public CustomerService(CustomerDAO cDAO) {
        this.cDAO = cDAO;
    }
    /**
     * 고객추가한다
     */
    public void add(Customer c) {

    }
    public Customer getCustomer(String id) throws FindException {
        Customer c = cDAO.findById(id);
        if(c == null) {
            throw new FindException("아이디가 존재하지 않습니다");
        }
        return c;
    }
    public Customer login(String id, String pwd) throws FindException {
        Customer c = getCustomer(id);
        if(c.getPwd().equals(pwd)){
            return c;
        }
        throw new FindException("로그인 실패");
    }
}
