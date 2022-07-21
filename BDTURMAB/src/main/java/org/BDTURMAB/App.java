package org.BDTURMAB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		//Pessoa user = new Pessoa("Felipe", "Aluno");
		Carro car = new Carro("Fiat", "Toro", 2018, "Semi-novo");
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(car);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
