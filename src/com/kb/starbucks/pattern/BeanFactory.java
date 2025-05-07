package com.kb.starbucks.pattern;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
    private String propertiesFileName;
    private Map<String, Object> beans = new HashMap<String, Object>();

    /**
     * 프로퍼티스파일에 저장된 프로퍼티이름에 해당하는 클래스타입의 객체를 생성해놓음
     * 프로퍼티스파일의 구성은 프로퍼티이름=프로퍼티값인데 프로퍼티값이 클래스이름이 되어야한다
     * 프로퍼티파일에 저장된 프로퍼티이름에 해당하는 객체를 생성해서 beans맵에 저장해둔다
     * @param propertiesFileName 프로퍼티스파일명
     * @throws Exception
     */
    public BeanFactory(String propertiesFileName) throws Exception{
        this.propertiesFileName = propertiesFileName;
        java.util.Properties env = new java.util.Properties();
//        env.load(new java.io.FileInputStream(propertiesFileName));
//        env.load(BeanFactory.class.getResourceAsStream(propertiesFileName)); //같은패키지에 propertiesFile이 있어야함
        env.load(BeanFactory.class.getResourceAsStream("/" + propertiesFileName)); //classpath에 propertiesFile이 있어야함
        for (Map.Entry<Object, Object> entry : env.entrySet()) {
            String propertyName =  (String)entry.getKey(); //pDao, cDao
            String className =  (String)entry.getValue();  //com.kb.starbucks.dao.ProductDAOArray, com.kb.starbucks.dao.CustomerDAOArray


            Object obj = Class.forName(className).getDeclaredConstructor().newInstance();
            beans.put(propertyName, obj);
        }
    }

    /**
     *
     * @param name
     * @param requiredType
     * @return
     * @param <T>
     * @throws Exception
     */
    public <T>T getInstance(String name, Class<T>requiredType) throws Exception {
        Object obj = beans.get(name);
        // obj가 requiredType의 인스턴스인지 체크
        if (requiredType.isInstance(obj)) {
            // 형변환 가능: 안전하게 형변환
            return requiredType.cast(obj);  // 또는 (T) obj; (둘 다 가능)
        } else {
            // 형변환 불가능: 예외 처리 또는 적절한 처리
            throw new ClassCastException("The bean is not of the required type: " + requiredType.getName());
        }
    }
}