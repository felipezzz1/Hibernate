package org.BDTURMAB;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		//Pessoa user1 = new Pessoa("Carlos", "Professor");
		//Pessoa user2 = new Pessoa("Enzo", "Professor");
		//Carro car = new Carro("Fiat", "Toro", 2018, "Semi-novo");
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//criando usuarios no bd
		//Pessoa p1 = (Pessoa) session.get(Pessoa.class, 1l);
		//Pessoa p2 = (Pessoa) session.load(Pessoa.class, 2l);
		//System.out.println(p1.getNome());
		//System.out.println(p2.getNome());
		
		//salvando os usuarios
		//session.save(user2);
		//session.persist(user1);
		//session.getTransaction().commit();
		
		//criando query para usuario unico
		//String nome = "Carlos";
		//String ocupacao = "Professor";
		//Query q = session.createQuery("from Pessoa p where p.nome = :nome and p.ocupacao= :ocupacao");
		//q.setString("nome", nome);
		//q.setString("ocupacao", ocupacao);
		//q.setInteger("idade", 18);
		//Pessoa p = (Pessoa) q.uniqueResult();
		//System.out.println(p.getNome());
		//System.out.println(p.getOcupacao());
		
		//listando pessoas
		//Query q = session.createQuery("from Pessoa");
		//List<Pessoa> pessoas = (List<Pessoa>) q.list();
		
		//for (Pessoa pessoa : pessoas) {
			//System.out.println(pessoa.getNome());
		//}
		
		//excluindo e atualizando
		
		//atualizando
		//Pessoa p1 = (Pessoa) session.get(Pessoa.class, 1l);
		//p1.setNome("Willian");
		
		//excluindo
		//Pessoa p1 = (Pessoa) session.get(Pessoa.class, 1l);
		//session.delete(p1);
		
		//excluindo todas as pessoas do banco de dados
		session.createQuery("delete from Pessoa").executeUpdate();				
		tx.commit();
		
		session.close();
		sessionFactory.close();
	}
}
