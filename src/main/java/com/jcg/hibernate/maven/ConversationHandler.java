package com.jcg.hibernate.maven;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.MysqlConnect;
import model.User;
import model.Words;

class ConversationHandler extends Thread {

	Socket socket;

	BufferedReader in;

	PrintWriter out;

	String name;
	String password;
	PrintWriter pw;

	static FileWriter fw;

	static BufferedWriter bw;
	static User userObj;
	static Session sessionObj;
	static SessionFactory sessionFactoryObj;
	static boolean exist = false;
	static boolean acceptPassword = false;
	static int i = 0;

	public ConversationHandler(Socket socket) throws IOException {

		this.socket = socket;

		fw = new FileWriter("C:\\Users\\user\\Desktop\\ChatServer-Logs.txt", true);

		bw = new BufferedWriter(fw);

		pw = new PrintWriter(bw, true);

	}

	public void run() {
		
		
		MysqlConnect msql = new MysqlConnect();
		sessionObj = msql.buildSessionFactory().openSession();
		System.out.println("carregando usuários");
		sessionObj.beginTransaction();
		List<User> userList = sessionObj.createCriteria(User.class).list();
		List<Words> wordsList = sessionObj.createCriteria(Words.class).list();
		sessionObj.close();
		try {

			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			out = new PrintWriter(socket.getOutputStream(), true);

			int count = 0;

			while (true) {

				if (count > 0) {

					out.println("NAMEALREADYEXISTS");

				} else {

					out.println("NAMEREQUIRED");

				}

				name = in.readLine();

				if (name == null) {

					return;

				}

				for (i = 0; i < userList.size(); i++) {
					if (name.equals(userList.get(i).getUserName())) {
						exist = true;
						out.println("NAMEACCEPTED");
						password = in.readLine();
						break;
						
					}
				}
					if(password.equals(userList.get(i).getPassword())){
						acceptPassword = true;
						out.println("PasswordACCEPT" + userList.get(i).getUserName());
						MainClass.userNames.add(name);
						MainClass.printWriters.add(out);
						break;
					}
					else {
						out.println("Password Incorreto");
					}
				
				if (exist == false) {
					out.println("Usuario não Existe");
				} 
				
				
					count++;
			
			}
					while (true) {

						String message = in.readLine();
						for (int j = 0; j < wordsList.size(); j++) {
							if (message.toLowerCase().contains(wordsList.get(j).getWords())) {
								message = message.replaceAll(wordsList.get(j).getWords(), "!@#@!@#@!@#");
							}
						}

						System.out.println(message);
						if (message == null) {

							return;

						}

						pw.println(name + ": " + message);
						for (PrintWriter writer : MainClass.printWriters) {

							writer.println(name + ": " + message);

						}
					}
		
		}
				
			
	

		catch (Exception e) {

			System.out.println(e);

		}
	}
}
