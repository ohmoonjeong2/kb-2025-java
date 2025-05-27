package sec01;

import com.mongodb.ConnectionString;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMappedVO {
    static MongoClient mongoClient;
    String dbName = "todo_db";
    @BeforeEach
    void connectMongoClient() throws Exception {
//        String uri = "mongodb://127.0.0.1:27017";
//        assertDoesNotThrow(() -> {
//            mongoClient = MongoClients.create(uri); //RDB의 Connection과 같음
//
//        });


    }

    @Test
    void testInsert() throws Exception {
        String title = "MongoDB";
        String desc = "MongoDB 공부하기";
        boolean done = false;
        Document doc = new Document();
        doc.append("title", title);
        doc.append("desc", desc);
        doc.append("done", done);

        assertDoesNotThrow(() -> {
            MongoDatabase db = mongoClient.getDatabase(dbName); //
            MongoCollection<Document> collection = db.getCollection("todo");
            InsertOneResult result = collection.insertOne(doc);
        });
    }
    @DisplayName("전체검색 후 첫번째 Document의 title필드 테스트")
    @Test
    void testFindFirst() throws Exception {
        MongoDatabase db = mongoClient.getDatabase(dbName); //
        MongoCollection<Document> collection = db.getCollection("todo");

        Document doc = collection.find().first();
        System.out.println(doc);

        String expectedTitle = "MongoDB";
        assertEquals(expectedTitle, doc.get("title"));

    }
    @DisplayName("전체조회 후 filter")
    @Test
    void testFind() throws Exception {
        MongoDatabase db = mongoClient.getDatabase(dbName); //
        MongoCollection<Document> collection = db.getCollection("todo");
        Bson filter = Filters.eq("title", "MongoDB");
        FindIterable<Document> it =  collection.find();
        it
                .filter(filter)     // 조건 필터
                .projection(Projections.include("desc")) // 특정 필드만 반환
//                .sort(Sorts.ascending("title"))            // 정렬
//                .limit(10)                                // 최대 문서 수 제한
//                .skip(5)
                .forEach(System.out::println);                                 // 앞에서 5개 문서 건너뜀
    }

    @Test
    void testFindFilter(){
        MongoDatabase db = mongoClient.getDatabase(dbName); //
        MongoCollection<Document> collection = db.getCollection("todo");
        Bson filter = Filters.eq("title", "MongoDB");
        FindIterable<Document> it =  collection.find(filter);
        it.forEach(System.out::println);
    }

    @Test
    void testFindSort(){
        MongoDatabase db = mongoClient.getDatabase(dbName);
        MongoCollection<Document> collection = db.getCollection("todo");
        FindIterable<Document> it =  collection.find()
                .sort(Sorts.descending("title"));
        it.forEach(System.out::println);
    }

    @Test
    void testUpdate(){
        MongoDatabase db = mongoClient.getDatabase(dbName);
        MongoCollection<Document> collection = db.getCollection("todo");
        Bson filter = Filters.eq("title", "MongoDB");
        Document doc = new Document("$set", new Document("done", true));
        UpdateResult updateResult = collection.updateOne(filter, doc);
        long modifiedCount = updateResult.getModifiedCount();
        long expectedCount = 1;
        assertEquals(expectedCount, modifiedCount);
    }

    @Test
    void testDelete(){
        MongoDatabase db = mongoClient.getDatabase(dbName);
        MongoCollection<Document> collection = db.getCollection("todo");
        Bson filter = Filters.eq("title", "MongoDB");
        DeleteResult deleteResult = collection.deleteOne(filter);
        long deletedCount = deleteResult.getDeletedCount();
        long expectedCount = 1;
        assertEquals(expectedCount, deletedCount);
    }
    @AfterEach
    void disconnectMongoClient() throws Exception {
        mongoClient.close();
    }
}
