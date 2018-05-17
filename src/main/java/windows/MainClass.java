package windows;

import org.hibernate.Session;

import controller.MysqlConnect;
import requests.TratamentodoHTML;



public class MainClass {       


    public static void main(String[] args) throws Exception {
//    	MysqlConnect mc = new MysqlConnect();
//    	Session	sessionObj = mc.buildSessionFactory().openSession();
//		System.out.println("foi a conexao");

        TelaInicial tI = new TelaInicial();
        tI.runtelaInicial();
//            TratamentodoHTML th = new TratamentodoHTML();
//            th.getArrayCompleteUrlNews();
        
    }
}

