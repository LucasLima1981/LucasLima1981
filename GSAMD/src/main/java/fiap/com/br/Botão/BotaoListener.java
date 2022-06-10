package fiap.com.br.Botão;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import fiap.com.br.Janela.Janela;
import fiap.com.br.Produto.Produto;
import fiap.com.br.ProdutoDao.ProdutoDao;

public class BotaoListener implements ActionListener {

	private Janela view;
	
	public BotaoListener(Janela view)
	{
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Produto produto = new Produto();
		
		produto.setNome( view.getNomeTxt().getText() );
		produto.setBairro( view.getBairroTxt().getText() );
		produto.setCidade( view.getCidadeTxt().getText() );
		produto.setEstado( view.getEstadoTxt().getText() );
		produto.setRua( view.getRuaTxt().getText() );
		produto.setPreco( Double.parseDouble(view.getprecoText().getText()));
		
		new ProdutoDao().inserir(produto);
		view.carregarDados();
		
	}

}
