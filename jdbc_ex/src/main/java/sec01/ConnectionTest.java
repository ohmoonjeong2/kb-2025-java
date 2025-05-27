package sec01;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectionTest {
    public static void main(String[] args) {
        String uri = "mongodb://127.0.0.1:27017";
        String db="todo_db";
        try(
                MongoClient mongoClient = MongoClients.create(uri) //Connection
           ) {
            MongoDatabase database = mongoClient.getDatabase(db);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
