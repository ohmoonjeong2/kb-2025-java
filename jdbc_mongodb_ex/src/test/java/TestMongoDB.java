import com.mongodb.client.*;
import com.mongodb.client.model.BsonField;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sec01.domain.Todo;
import sec01.util.TodoMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMongoDB {
    static MongoClient mongoClient;
    String dbName = "todo_db";

    @BeforeEach
    void connectMongoClient() throws Exception {
        String uri = "mongodb://127.0.0.1:27017";
        assertDoesNotThrow(() -> {
            mongoClient = MongoClients.create(uri); //RDB의 Connection과 같음
        });
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

    @Test
    @DisplayName("Todo VO를 Document로 만들어 todo컬렉션에 추가하기")
    void testFromVoToDocument(){
        Todo todo = Todo.builder().title("View객체정리").desc("보안,간결").done(false).build();
        Document document =  TodoMapper.toDocument(todo);
        assertDoesNotThrow(() -> {
            MongoDatabase db = mongoClient.getDatabase(dbName); //
            MongoCollection<Document> collection = db.getCollection("todo");
            InsertOneResult result = collection.insertOne(document);
        });
    }
    @Test
    @DisplayName("Document를 Todo VO로 변환하기")
    void testFromDocumentToVO(){
        MongoDatabase db = mongoClient.getDatabase(dbName);
        MongoCollection<Document> collection = db.getCollection("todo");
        FindIterable<Document> it = collection.find();

        List<Todo> list = new ArrayList<>();
        it.forEach((document) -> {
            Todo todo = TodoMapper.fromDocument(document);
            list.add(todo);
        });
        list.forEach(System.out::println);
    }

    @AfterEach
    void disconnectMongoClient() throws Exception {
        mongoClient.close();
    }
}