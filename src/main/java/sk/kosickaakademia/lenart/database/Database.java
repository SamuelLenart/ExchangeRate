package sk.kosickaakademia.lenart.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Database {
    private static final MongoClient mongoClient = new MongoClient();
    private static MongoDatabase database;
    private static MongoCollection<Document> test;
    private static Document docs;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public <T> void add(String from, String to, double value, T result){
        database=mongoClient.getDatabase("ExchangeDB");
        test = database.getCollection("currency");
        JSONObject object = new JSONObject();
        object.put("datetime", format.format(new Date()));
        object.put("value", value);
        object.put("from", from);
        object.put("to", to);
        object.put("result", result);
        System.out.println(object);
        docs = Document.parse(object.toJSONString());
        test.insertOne(docs);
    }
    public void test(){
        database=mongoClient.getDatabase("testDB");
        test = database.getCollection("test");
        docs=new Document("name","samuel").append("ages",new Document("age","20"));
        test.insertOne(docs);
    }
}
