package controller;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.User;
import model.Words;

//Classes necessárias para uso de Banco de dados //

//Início da classe de conexão//

public class MysqlConnect {

	static Session sessionObj;
	static SessionFactory sessionFactoryObj;

	public SessionFactory buildSessionFactory() {
		// Creating Configuration Instance & Passing Hibernate Configuration File
		Configuration configObj = new Configuration().configure();
		configObj.configure("hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();

		// Creating Hibernate SessionFactory Instance
		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	public void insertUser(User user, List<User> userList) {

		try {
			sessionObj = buildSessionFactory().openSession();
			System.out.println("foi a conexao");
			sessionObj.beginTransaction();
			boolean test = false;
			for(int i=0 ; i<userList.size();i++) {
				if(user.getUserName().equals(userList.get(i).getUserName())) {
					test = true;
				}
			}
			if(test==true) {
				System.out.println("Usuario já existente");
			}
			else {
			sessionObj.save(user);
			sessionObj.getTransaction().commit();
			}
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("Foi realizado RollBack por erro falta de informação");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}

	}

	public void insertWord(Words words) {

		try {
			sessionObj = buildSessionFactory().openSession();
			System.out.println("foi a conexao");
			sessionObj.beginTransaction();
			sessionObj.save(words);
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("Foi realizado RollBack por erro falta de informação");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}

	}
	public boolean readUser(String user,String password) {
		sessionObj = buildSessionFactory().openSession();
		System.out.println("foi a conexao");
		sessionObj.beginTransaction();
		List<User> userList = sessionObj.createCriteria(User.class).list();
		System.out.println(userList.toString());
		boolean test = false;
		for(int i=0 ; i<userList.size();i++) {
			if(user.equals(userList.get(i).getUserName())) {
				test = true;
			}
		}
		return test;
		
	}

}