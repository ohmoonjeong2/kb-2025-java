package com.kb.starbucks;

import com.kb.starbucks.dao.CustomerDAO;
import com.kb.starbucks.dao.ProductDAO;
import com.kb.starbucks.pattern.BeanFactory;
import com.kb.starbucks.pattern.command.ProductAddCommand;
import com.kb.starbucks.pattern.command.ProductSearchAllCommand;
import com.kb.starbucks.pattern.command.ProductSearchByNoCommand;
import com.kb.starbucks.pattern.command.StarbucksCommand;
import com.kb.starbucks.vo.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StarbucksUserFactoryCommand {
    private Scanner sc;
    //private ProductDAOArray pDao;
    private ProductDAO pDao;
    private CustomerDAO cDao;
    private Map<String, StarbucksCommand> commands;
    public StarbucksUserFactoryCommand(int size){
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

        commands = new HashMap<>();
        commands.put("1", new ProductSearchAllCommand(pDao, sc)); //전체 상품조회
        commands.put("2", new ProductAddCommand(pDao, sc)); //상품추가
        commands.put("3", new ProductSearchByNoCommand(pDao, sc)); //상품번호로 검색
//        commands.put("5", new ProductSearchAllCommand(pDao, sc));
//        commands.put("6", new ProductSearchAllCommand(pDao, sc));
        commands.put("5", ()->{ //고객추가
            System.out.println(">>고객추가<<");
            System.out.println("고객ID:");
            String id = sc.nextLine();
            System.out.println("고객비번:");
            String pwd = sc.nextLine();
            System.out.println("고객이름:");
            String name = sc.nextLine();
            cDao.insert(new Customer(id, pwd, name));
        });
        commands.put("6", ()->{ //ID로 검색
            System.out.println(">>고객 ID로 조회");
            System.out.println("고객ID:");
            String id = sc.nextLine();
            Customer c = cDao.findById(id);
            System.out.println(c); //고객정보가 다음과 같이 출력된다 : id는 XXX, pwd는 YYY, 이름은 ZZ
        });
    }
    public void executeCommand(String key){
        StarbucksCommand command ;
        command = commands.get(key);
        if(command != null) {
            command.command();
        }


    }
    public static void main(String[] args) {
        StarbucksUserFactoryCommand su = new StarbucksUserFactoryCommand(100);
        String opt;
        do {
            System.out.println("1-전체조회, 2-상품추가, 3-상품번호로 검색, 4-상품명으로 검색, 5-고객추가, 6-ID로 고객조회, 9-종료");
            System.out.println("작업을 선택하세요:");
            opt = su.sc.nextLine();
            su.executeCommand(opt);

//            if (opt.equals("1")) {
//                su.search();
//            } else if (opt.equals("2")) {
//                su.add();
//            } else if (opt.equals("3")) {
//                su.searchByNo();
//            } else if (opt.equals("4")) {
//            } else if (opt.equals("5")) {
//                su.addCustomer();
//            } else if (opt.equals("6")) {
//                su.searchById();
////            } else if (opt.equals("9")) {
////                System.exit(0); //프로세스 종료
//            }
        }while (!opt.equals("9"));

    }
}
