package com.kb.starbucks.vo;
import java.util.Date;
public class Product {
    private String prodNo;
    private String prodName;
    private int prodPrice;
    private Date prodDt; //제조일자

//    private int quantity; //단일책임원칙에 위배




    public Product(){}
    public Product(String prodNo, String prodName, int prodPrice){
//        this.prodNo = prodNo;
//        this.prodName = prodName;
//        this.prodPrice = prodPrice;
        this(prodNo, prodName, prodPrice, null);
    }
    public Product(String prodNo, String prodName, int prodPrice, Date prodDt){
        this.prodNo = prodNo;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodDt = prodDt;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }

    public Date getProdDt() {
        return prodDt;
    }

    public void setProdDt(Date prodDt) {
        this.prodDt = prodDt;
    }

    @Override
    public String toString(){
        return prodNo + ":" + prodName + ":" + prodPrice + ":" + prodDt;
    }

    /**
     * 인자로 쓰이는 상품의 상품번호와 현재객체의 상품번호가 같으면 true반환
     * 그렇지않으면 false반환
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Product) {
            Product p = (Product) obj;
            return p.getProdNo().equals(this.getProdNo());
        }else{
            return false;
        }
    }
}
