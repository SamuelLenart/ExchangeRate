package sk.kosickaakademia.lenart.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Database {
    private static final MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;
    private static Document docs;
    private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void writeData(double value, String[] to){
        database = mongoClient.getDatabase("ExchangeDB");
        collection = database.getCollection("currency");
        List<String> list = Arrays.asList(to.clone());
        docs=new Document("date",date.toString())
                .append("value",value)
                .append("rates", list);
        collection.insertOne(docs);
    }
    public void test(){
        database=mongoClient.getDatabase("testDB");
        collection = database.getCollection("test");
        docs=new Document("name","samuel").append("ages",new Document("age","20"));
        collection.insertOne(docs);
    }
}
