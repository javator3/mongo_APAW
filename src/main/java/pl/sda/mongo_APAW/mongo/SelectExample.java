package pl.sda.mongo_APAW.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

public class SelectExample {

    public static void main(String[] args) {


        MongoClient mongoClient = new MongoClient();
        MongoCollection<Document> collection = mongoClient.getDatabase("new").getCollection("uzytkownicy");

//        showAge(5, collection);
//        showById("5ca876cb50d1b503d38fe891", collection);
        showBeetwen2and4(2, collection);

//        for (Document document : collection.find()) {
//            System.out.println(document.toJson());
//        }
//        Document first = collection.find().first();
//        System.out.println(first);

//        FindIterable<Document> iterable = collection.find(Filters.eq("name", "Adam"));
//        for(Document iterabl : iterable) {
//            System.out.println(iterabl);
//        }

//        Document first1 = collection.find(Filters.eq("lastname", "Kowalski")).first();
//        System.out.println(first1);
    }

    //napisz metodę która wypisze na eranie wszystkie elementy z kolekcji o wieku podanym w argumencie metody

    static void showAge(int n, MongoCollection<Document> collection) {

        FindIterable<Document> age1 = collection.find(Filters.eq("age", n));
        for (Document age : age1) {
            System.out.println(age);
        }
    }

    // napisz metode która wypisze na ekran elemnety z kolekcji o podanym id, w przypadku gdy taki element nie istnieje w tabeli to zwróć odpowiedni komunikat

    static void showById(String id, MongoCollection<Document> collection) {

        Document first2 = collection.find(Filters.eq("_id", new ObjectId(id))).first();
        if (first2 == null) {
            System.out.println("brak uzytkownika");
        } else {

            System.out.println(first2);
        }
    }

    // napisz metodę która wypisze elementy z kolekcji od 2 do 4 gdzie wiek jest >= niż podany przez użytkownika

    static void showBeetwen2and4(int n, MongoCollection<Document> collection) {

        FindIterable<Document> age2 = collection.find(Filters.gte("age", n)).skip(1).limit(3);
        for (Document age3: age2) {
            System.out.println(age3);
        }
    }


}
