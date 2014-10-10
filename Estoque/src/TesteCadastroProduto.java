import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.estoque.model.Produto;
import com.algaworks.estoque.repository.Produtos;
import com.algaworks.estoque.service.CadastroProdutoService;
import com.algaworks.estoque.service.ServiceException;
import com.algaworks.estoque.util.JpaUtil;

public class TesteCadastroProduto {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();

		Produtos produtos = new Produtos(manager);
		CadastroProdutoService servico = new CadastroProdutoService(produtos);
		
		Produto produto = new Produto();
		produto.setNome("Picanha");
		produto.setPrecoCusto(new BigDecimal(33.4));

		// regra de negócio não permite quantidade menor que 0
		produto.setQuantidadeEstoque(-2);
		
		try {
			trx.begin();
			servico.cadastrar(produto);
			trx.commit();
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		} finally {
			if (trx.isActive()) trx.rollback();
			manager.close();
		}
	}
	
}
