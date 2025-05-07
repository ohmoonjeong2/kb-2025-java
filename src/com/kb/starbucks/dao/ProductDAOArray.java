package com.kb.starbucks.dao;

import com.kb.starbucks.vo.Product;

import java.util.Arrays;

public class ProductDAOArray
//        implements ProductDAO
{
    private Product[] products; //저장소
    private int totalCnt; //저장된 상품수
    public ProductDAOArray(){
        products = new Product[5];
    }

    /**
     *  저장소의 크기만큼 저장소를 만든다
     * @param size 저장소의 크기
     */
    public ProductDAOArray(int size){
        products = new Product[size];
    }

    public void insert(Product product){
        for(int i=0; i<totalCnt; i++){
            //if(products[i].getProdNo().equals(product.getProdNo())){
            if(products[i].equals(product)){
                return;//이미 저장소에 있는 경우
            }
        }
        products[totalCnt] = product; //GOOD CODE
        totalCnt++;
        //products[totalCnt++] = product; //BAD CODE
    }


    public Product findByProdNo(String prodNo){
        for(int i=0; i<totalCnt; i++){
            if(products[i].getProdNo().equals(prodNo)){
                return products[i];//이미 저장소에 있는 경우
            }
        }
        return null;
    }

    public Product[] findAll(){
//        return products;
        Product[] pArr = new Product[totalCnt];

//        for(int i=0; i<totalCnt; i++){
//            pArr[i] = products[i];
//        }
//        System.arraycopy(products, 0, pArr, 0, totalCnt);

        pArr = Arrays.copyOf(products, totalCnt);
        return pArr;
    }
    public void update(Product product){

    }
    public void delete(String prodNo){

    }

}
