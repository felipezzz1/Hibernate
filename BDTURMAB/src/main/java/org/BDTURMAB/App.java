package org.BDTURMAB;

import java.util.ArrayList;
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
		//criando emails e pessoas, usando oo para setar e adicionar emails
		//Email email1 = new Email("a@email.com");
		//Email email2 = new Email("b@email.com");
		//Endereco address1 = new Endereco("Rua Simeao Varela de Sa", 1666, "Vila Carli", 85012020, "Guarapuava", "Parana");
		///Pessoa p1 = new Pessoa();
		//p1.setNome("Marcos");
		//p1.setOcupacao("Aluno");
		//p1.setEndereco(address1);
		//email1.setPessoa(p1);
		//email2.setPessoa(p1);
		//List<Email> emails = new ArrayList<Email>();
		//emails.add(email1);
		//emails.add(email2);
		//p1.setEmails(emails);
		
		Venda venda = new Venda();
		venda.setCodigo("XY2128S");
		Produto produto = new Produto("Curso de Java");
		produto.setVenda(venda);
		Produto produto1 = new Produto("Curso SQL");
		produto1.setVenda(venda);
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(produto1);
		produtos.add(produto);
		venda.setProdutos(produtos);
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		//comeco das "transacoes"
		Transaction tx = session.beginTransaction();
		
		//salvando as coisas
		//session.save(p1);
		//session.save(address1);
		//session.save(email1);
		//session.save(email2);
		
		//query de endereco
		//Query q = session.createQuery("from Pessoa p where p.endereco.bairro='Trianon'");
		//Pessoa p1 = (Pessoa) q.uniqueResult();
		//System.out.println(p1.getNome());
		
		//session.save(address1);
		//session.save(p1);
		session.save(venda);
		session.save(produto1);
		session.save(produto);
				
		//printando
		//Pessoa p1 = (Pessoa) session.get(Pessoa.class, 1l);
		//Pessoa p2 = (Pessoa) session.load(Pessoa.class, 2l);
		//System.out.println(p1.getNome());
		//System.out.println(p2.getNome());
		
		//criando pessoas no bd
		//Pessoa user1 = new Pessoa("Carlos", "Professor");
		//Pessoa user2 = new Pessoa("Enzo", "Professor");
		//Carro car = new Carro("Fiat", "Toro", 2018, "Semi-novo");
		//Endereco address1 = new Endereco("Rua Simeao Varela de Sa", 1666, "Vila Carli", 85012020, "Guarapuava", "Parana");
		//Pessoa p1 = new Pessoa("Willian", "Aluno", address1);
		
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
		//session.createQuery("delete from Pessoa").executeUpdate();				
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}
}
