package sec01.util;

import org.bson.Document;
import sec01.domain.Todo;

/**
 * Todo vo클래스와 MongoDB document를 매핑
 */
public class TodoMapper {
    public static Document toDocument(Todo todo) {

        return new Document("title", todo.getTitle())
                .append("desc", todo.getDesc())
                .append("done", todo.isDone());
    }

    public static Todo fromDocument(Document doc) {
        return Todo.builder()
                .id(doc.getObjectId("_id"))
                .title(doc.getString("title"))
                .desc(doc.getString("desc"))
                .done(doc.getBoolean("done"))
                .build();
    }
}
