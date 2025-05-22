package org.scoula.travel.dataimport;

import org.scoula.database.JDBCUtil;
import org.scoula.travel.dao.dao.TravelDao;
import org.scoula.travel.dao.dao.TravelDaoImp;
import org.scoula.travel.domain.TravelImageVO;

import java.io.File;

public class ImportImageData {
    public static void main(String[] args) {
        TravelDao dao = new TravelDaoImp();

        File dir = new File("../travel-image");
        File[] files = dir.listFiles();
        for (File file : files) {
            String fileName = file.getName();
            long travelNo = Long.parseLong(fileName.split("-")[0]);

            TravelImageVO image = TravelImageVO.builder()
                    .filename(fileName)
                    .travelNo(travelNo)
                    .build();

            System.out.println(image);
            dao.insertImage(image);
        }
    }
}
