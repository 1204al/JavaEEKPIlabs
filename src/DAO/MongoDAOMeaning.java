package DAO;

import entities.Meaning;

import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.mongodb.*;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

/**
 * Created by aliubivyi on 19.04.17.
 */
public class MongoDAOMeaning implements IDAOMeaning {

    MongoClient mongoClient;
    DB mongoDbDictionary;
    DBCollection meaningsCollection;
    final String meaningsCollectionName = "meanings";

    public MongoDAOMeaning()  {

        try {
            mongoClient = new MongoClient("localhost", 27017);
            mongoDbDictionary = mongoClient.getDB("dbdictionary");
            meaningsCollection = mongoDbDictionary.getCollection(meaningsCollectionName);
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException(e);

        }

    }



    private Meaning meaningFromDBObject(DBObject dbObject){
        Meaning meaning = new Meaning();
        meaning.setIdMeaning(0);
        meaning.setWord((String) dbObject.get("word"));
        meaning.setMeaning((String) dbObject.get("meaning"));
        return meaning;
    }
    private BasicDBObject documentFromMeaning(Meaning meaning){
        BasicDBObject document=new BasicDBObject();
        document.put("word",meaning.getWord());
        document.put("meaning",meaning.getMeaning());
        return document;
    }

    @Override
    public List<Meaning> findAll() {
        BasicDBObject searchQuery = new BasicDBObject();
        DBCursor cursor= meaningsCollection.find(searchQuery);
        List<Meaning> list = new ArrayList<>();
        while (cursor.hasNext()) {
            DBObject object = cursor.next();
            Meaning meaning = meaningFromDBObject(object);
            list.add(meaning);
        }
        return list;
    }

    @Override
    public Meaning findById(int id) {
        return null;
    }

    @Override
    public Meaning findByWord(String word) {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("word", word);
        DBCursor cursor= meaningsCollection.find(whereQuery);
        if(cursor.hasNext()){
            DBObject object=cursor.next();
            Meaning meaning=meaningFromDBObject(object);
            return meaning;
        }
        return null;
    }

    @Override
    public void update(Meaning entity) {
        BasicDBObject document=null;
        document=documentFromMeaning(entity);
        BasicDBObject whereQuery=new BasicDBObject();
        whereQuery.put("word",entity.getWord());
        meaningsCollection.update(whereQuery,document);
    }

    @Override
    public void delete(String word) {
        BasicDBObject whereQuery=new BasicDBObject();
        whereQuery.put("word",word);
        meaningsCollection.remove(whereQuery);
    }

    @Override
    public Meaning create(Meaning entity) {
        BasicDBObject document=null;
        document=documentFromMeaning(entity);
        meaningsCollection.insert(document);
        return entity;
    }
}
