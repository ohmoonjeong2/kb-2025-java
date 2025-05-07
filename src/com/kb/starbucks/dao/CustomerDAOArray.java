package com.kb.starbucks.dao;

import com.kb.starbucks.vo.Customer;

public class CustomerDAOArray implements CustomerDAO{
    private Customer[] customers;
    private int totalCnt;

    /**
     * 매개변수없는 생성자가 존재하지 않으면 자바빈이 될 수 없다. 리플렉션 실패될 수 있다
     * ex)DaoFactory의
     *     Object obj = Class.forName(className).getDeclaredConstructor().newInstance();실패
     */
    public CustomerDAOArray() {
        customers = new Customer[100];
    }
    public CustomerDAOArray(int size) {
        customers = new Customer[size];
    }

    @Override
    public void insert(Customer customer){
        for(int i = 0; i < totalCnt; i++){
            //if(customer.getId().equals(customers[i].getId())){
            if(customers[i].getId().equals(customer.getId())){
                System.out.println("이미 존재하는 아이디입니다");
                return;
            }
        }
        customers[totalCnt] = customer;
        totalCnt++;
    }
    public Customer findById(String id){
        for(int i=0; i<totalCnt; i++){
            if(id.equals(customers[i].getId())){
                return customers[i];
            }
        }
        return null;
    }
    public void delete(int index) {
        if (index < 0 || index >= totalCnt) {
            System.out.println("유효하지 않은 인덱스입니다.");
            return;
        }

        // 삭제할 인덱스 이후의 요소들을 한 칸 앞으로 이동
        for (int i = index; i < totalCnt - 1; i++) {
            customers[i] = customers[i + 1];
        }

        // 마지막 요소를 null로 설정
        customers[totalCnt - 1] = null;

        // 전체 고객 수 감소
        totalCnt--;
    }

}
