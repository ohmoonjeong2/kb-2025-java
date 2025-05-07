package com.kb.starbucks.dao;

import com.kb.starbucks.vo.Customer;

public interface CustomerDAO {
    /**
     * 고객을 저장소에 추가한다
     * 고객의 아이디가 이미 존재한다면 "이미 존재하는 아이디입니다" 출력후 저장하지 않는다
     * @param c
     */
    public void insert(Customer c);


    /**
     * 아이디에 해당하는 고객을 저장소에서 찾아 반환한다
     * @param id 아이디
     * @return 아이디에 해당하는 고객이 없으면 null을 반환한다
     */
    public Customer findById(String id);
}
