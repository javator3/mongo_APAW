package pl.sda.mongo_APAW.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


public class DocumentsExample {

    public static void main(String[] args) {


        Document document = new Document("name","Adam")
                .append("lastname", "Kowalski")
                .append("age", 18);



        for (int i = 0; i < 5; i++) {

//            Document document = new Document("name", "Andy" + i)
//                    .append("lastname", "Kowalski" + i)
//                    .append("age", 1 + i);


            MongoClient mongoClient = new MongoClient();
//            mongoClient.getDatabase("new").createCollection("uzytkownicy");
            MongoCollection<Document> collection = mongoClient
                    .getDatabase("new")
                    .getCollection("uzytkownicy");
            collection.insertOne(document);

            add("bogdan", "ggg", 23, collection);
            addMany(10, collection);
            countElement();
        }


           }

           public static void countElement(){

               MongoClient mongoClient = new MongoClient();
               MongoCollection<Document> collection = mongoClient
                       .getDatabase("new")
                       .getCollection("uzytkownicy");
               System.out.println(collection.countDocuments());



           }

           public static void add(String imie, String nazwisko, Integer wiek, MongoCollection<Document> collection){

        Document document = new Document("name", imie)
                .append("lastname", nazwisko)
                .append("wiek", wiek);
        collection.insertOne(document);

           }

           public static void addMany (int n, MongoCollection<Document> collection){

               List<Document> list = new ArrayList<Document>();

               for (int i = 0; i < n; i++) {
                   Document document = new Document("name", "imie" + i)
                           .append("lastname", "nazwisko" + i)
                           .append("wiek", "wiek" + i);
                   list.add(document);

               }
               collection.insertMany(list);
           }





//    public static void addPerson(){
//        for (int i = 0; i < 5; i++) {
//
//
//            Document document = new Document("name", "Andy" +i)
//                    .append("lastname", "Kowalski" + i)
//                    .append("age", 1 + i);
//
//        }



    }

