package org.BdTurmaBTrab;

import java.util.ArrayList;
import java.util.List;

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
        Telefone telefone = new Telefone();
        telefone.setDDD(042);
        telefone.setNumero(40028922);
        telefone.setTipo("Aparelho movel");
        
        Telefone telefone2 = new Telefone();
        telefone2.setDDD(042);
        telefone2.setNumero(80041111);
        telefone2.setTipo("Telefone fixo");
        
        Endereco endereco = new Endereco("Rua Simeao Varela de Sa", 1666, "Vila Carli", "Guarapuava");
        
        Cliente c1 = new Cliente();
        c1.setNome("Marcos");
        c1.setData_nascimento("21/02/2002");
        c1.setSexo("Masculino");
        c1.setCpf("0750468045265");
        c1.setEndereco(endereco);
        
        List<Telefone> telefones = new ArrayList<Telefone>();
        telefones.add(telefone);
        telefones.add(telefone2);
        
        c1.setTelefones(telefones);
        
        Venda venda = new Venda();
        venda.setCliente(c1);
        venda.setCodigo("XY2128S");
        
        Produto produto = new Produto();
        produto.setCodigo("XAS48AS4Z5S5A");
        produto.setDescricao("Curso de Java");
        produto.setValor(45.00);
        produto.setVenda(venda);
        
        Produto produto2 = new Produto();
        produto.setCodigo("KO23K1OK21G2A");
        produto.setDescricao("Curso de SQL");
        produto.setValor(50.00);
        produto.setVenda(venda);
        
        List<Produto> produtos = new ArrayList<Produto>();
        produtos.add(produto);
        produtos.add(produto2);
        
        venda.setProdutos(produtos);
        
        @SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(telefone);
		session.save(telefone2);
		session.save(endereco);
		session.save(c1);
		session.save(produto);
		session.save(produto2);
		session.save(venda);
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
    }
}
