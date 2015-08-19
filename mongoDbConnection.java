package com.mkyong.core;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mkyong.config.SpringMongoConfig;
import com.mkyong.model.User;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
//import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) throws UnknownHostException {

		// For XML
		ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
		System.setProperty("java.net.preferIPv4Stack" , "true");
		// For Annotation
	//	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		//String dbURI = "mongodb://cma1cs0505.qaoneadr.local:27017";
		// String dbURI = "mongodb://ds059692.mongolab.com:59692";
		String dbURI = "mongodb://abhijeetjain:abhijain14@ds059692.mongolab.com:59692";
		MongoClientURI uri  = new MongoClientURI(dbURI); 		
		
		
		MongoClient mongoClient = new MongoClient(uri);
		//DB db = mongoClient.getDB("abhijeetmongodb");
		//System.out.println("Status ---> "+db.getStats());
		/*boolean auth = db.authenticate("abhijeetjain", "abhijain14".toCharArray());
		System.out.println("Auth :- "+auth);*/
		
		List<String> databases = mongoClient.getDatabaseNames();
		
		for (String dbName : databases) {
			System.out.println("- Database: " + dbName);
			
			DB db = mongoClient.getDB(dbName);
			//db.authenticate("abhijeetjain", "abhijain14".toCharArray());
			System.out.println("Status ---> "+db.getStats());
		}
	//	MongoClient mongoClient = MongoClient("cma1cs0505.qaoneadr.local", 27017);
		//MongoClient mongoClient = new MongoClient("ds059692.mongolab.com");
	/*	DB db = mongoClient.getDB("abhijeetmongodb");
		System.out.println("Status ---> "+db.getStats());*/
       //  List<String> databases = mongoClient.getDatabaseNames();
		
	/*	User user = new User("mkyong", "password123");

		// save
		mongoOperation.save(user);

		// now user object got the created id.
		System.out.println("1. user : " + user);

		// query to search user
		Query searchUserQuery = new Query(Criteria.where("username").is("mkyong"));

		// find the saved user again.
		User savedUser = mongoOperation.findOne(searchUserQuery, User.class);
		System.out.println("2. find - savedUser : " + savedUser);

		// update password
		mongoOperation.updateFirst(searchUserQuery, Update.update("password", "new password"),
				User.class);

		// find the updated user object
		User updatedUser = mongoOperation.findOne(
				new Query(Criteria.where("username").is("mkyong")), User.class);

		System.out.println("3. updatedUser : " + updatedUser);

		// delete
		mongoOperation.remove(searchUserQuery, User.class);

		// List, it should be empty now.
		List<User> listUser = mongoOperation.findAll(User.class);
		System.out.println("4. Number of user = " + listUser.size());*/

	}

}
