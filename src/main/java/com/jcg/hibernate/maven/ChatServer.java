package com.jcg.hibernate.maven;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import controller.MysqlConnect;
import model.User;
import model.Words;

public class ChatServer {

	static User userObj;
	static Session sessionObj;
	static SessionFactory sessionFactoryObj;

//	static ArrayList<String> userNames = new ArrayList<String>();

	static ArrayList<PrintWriter> printWriters = new ArrayList<PrintWriter>();

	public static void main(String[] args) throws Exception {
		
		MysqlConnect msql = new MysqlConnect();
		sessionObj = msql.buildSessionFactory().openSession();
		System.out.println("carregando usuários");
		sessionObj.beginTransaction();
		List<User> userList = sessionObj.createCriteria(User.class).list();
		List<Words> wordsList = sessionObj.createCriteria(Words.class).list();
		System.out.println(userList.toString());
		System.out.println(wordsList.toString());
		sessionObj.close();

		System.out.println(userList.toString());
		System.out.println("Waiting for clients...");

		ServerSocket ss = new ServerSocket(8081);

		while (true)

		{

			Socket soc = ss.accept();

			System.out.println("Connection established");

			ConversationHandler handler = new ConversationHandler(soc);

			handler.run(userList, wordsList);

		}

	}

}
