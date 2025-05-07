package com.kb.starbucks;

import com.kb.starbucks.dao.CustomerDAO;
import com.kb.starbucks.dao.ProductDAO;
import com.kb.starbucks.pattern.BeanFactory;
import com.kb.starbucks.vo.Customer;
import com.kb.starbucks.vo.Product;

import java.util.List;
import java.util.Scanner;

public class StarbucksUserFactory {
    private Scanner sc;
    //private ProductDAOArray pDao;
    private ProductDAO pDao;
    private CustomerDAO cDao;

    public StarbucksUserFactory(int size){
        try {
            //dao.properties파일을 로드(이름=값)해서 맵에 각 값객체를 저장한다
            BeanFactory factory = new BeanFactory("dao.properties");

            //맵에서 이름에해당하는 객체찾아 반환
            pDao = factory.getInstance("pDao", ProductDAO.class);
            cDao = factory.getInstance("cDao", CustomerDAO.class);
        }catch(Exception e){
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
        sc = new Scanner(System.in);
    }
    public void addCustomer(){
        System.out.println(">>고객추가<<");
        System.out.println("고객ID:");
        String id = sc.nextLine();
        System.out.println("고객비번:");
        String pwd = sc.nextLine();
        System.out.println("고객이름:");
        String name = sc.nextLine();
        cDao.insert(new Customer(id, pwd, name));
    }
    public void searchById(){
        System.out.println(">>고객 ID로 조회");
        System.out.println("고객ID:");
        String id = sc.nextLine();
        Customer c = cDao.findById(id);
        System.out.println(c); //고객정보가 다음과 같이 출력된다 : id는 XXX, pwd는 YYY, 이름은 ZZ
                               //id에 해당고객이 없다면 null이 출력된다
    }
    public void add(){
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
    public void search(){
        System.out.println(">>상품 전체조회<<");
        //Product[] all = pDao.findAll();
        List<Product> all = pDao.findAll();
        for(Product p : all){
            System.out.println(p);
//            System.out.println(p.getProdNo());
        }
    }
    public void searchByNo(){
        System.out.println(">>상품 상세조회<<");
        System.out.println("상품번호:");
        String prodNo = sc.nextLine();
        Product p = pDao.findByProdNo(prodNo);
        System.out.println(p); //p.getProdName(); NullPointerException발생가능
    }
    public static void main(String[] args) {
        StarbucksUserFactory su = new StarbucksUserFactory(100);
        String opt;
        do {
            System.out.println("1-전체조회, 2-상품추가, 3-상품번호로 검색, 4-상품명으로 검색, 5-고객추가, 6-ID로 고객조회, 9-종료");
            System.out.println("작업을 선택하세요:");
            opt = su.sc.nextLine();
            if (opt.equals("1")) {
                su.search();
            } else if (opt.equals("2")) {
                su.add();
            } else if (opt.equals("3")) {
                su.searchByNo();
            } else if (opt.equals("4")) {
            } else if (opt.equals("5")) {
                su.addCustomer();
            } else if (opt.equals("6")) {
                su.searchById();
//            } else if (opt.equals("9")) {
//                System.exit(0); //프로세스 종료
            }
        }while (!opt.equals("9"));

    }
}
