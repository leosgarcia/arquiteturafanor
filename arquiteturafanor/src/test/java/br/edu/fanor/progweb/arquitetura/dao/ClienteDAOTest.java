package br.edu.fanor.progweb.arquitetura.dao;

import static org.junit.Assert.fail;







import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fanor.progweb.arquitetura.entity.Clientes;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@TransactionConfiguration(defaultRollback=false)
@Transactional(propagation=Propagation.REQUIRED)
public class ClienteDAOTest {

	@Autowired
	private ClienteDAO clienteDAO;
	
	@Ignore
	public void testSalvar() {
		Clientes cliente = new Clientes();
		cliente.setNome("Marcos");
		cliente.setCpf("1111111111");
		
		clienteDAO.salvar(cliente);
	}
	
	@Ignore
	public void testBuscarPorId(){
		Clientes cliente = clienteDAO.buscarPorId(1L);
		
		System.out.println("nome: "+cliente.getNome() + " - cpf: "+cliente.getCpf());
	}
	
	@Ignore
	public void testAtualizar(){
		Clientes cliente = clienteDAO.buscarPorId(1L);
		cliente.setNome("Maria");
		
		clienteDAO.atualizar(cliente);
	}
	
	@Test
	public void testExcluir(){
		Clientes cliente = clienteDAO.buscarPorId(1L);
		
		clienteDAO.excluir(cliente);
	}

}
