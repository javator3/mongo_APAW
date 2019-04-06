package pl.sda.mongo_APAW.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class SelectExample {

    public static void main(String[] args) {


        MongoClient mongoClient = new MongoClient();
        MongoCollection<Document> collection = mongoClient.getDatabase("new").getCollection("uzytkownicy");


//        for (Document document : collection.find()) {
//            System.out.println(document.toJson());
//        }
//        Document first = collection.find().first();
//        System.out.println(first);

        FindIterable<Document> iterable = collection.find(Filters.eq("name", "Adam"));
        for(Document iterabl : iterable) {
            System.out.println(iterabl);
        }
    }
}
