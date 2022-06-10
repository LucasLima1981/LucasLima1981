package fiap.com.br.Janela;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import antlr.collections.impl.Vector;
import fiap.com.br.Botão.BotaoListener;
import fiap.com.br.Produto.Produto;
import fiap.com.br.ProdutoDao.ProdutoDao;
import fiap.com.br.StarRating.StarRater;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class Janela extends JFrame {

	private JTabbedPane abas = new JTabbedPane();
	private JPanel painelCadastro = new JPanel();
	private JLabel nome = new JLabel("Nome: ");
	private JTextField nomeTxt = new JTextField();
	private JLabel rua = new JLabel("Rua: ");
	private JTextField ruaTxt = new JTextField(20);
	private JLabel bairro = new JLabel("Bairro: ");
	private JTextField bairroTxt = new JTextField(20);
	private JLabel cidade = new JLabel("Cidade: ");
	private JTextField cidadeTxt = new JTextField(20);
	private JLabel estado = new JLabel("Estado: ");
	private JTextField estadoTxt = new JTextField(20);
	private JLabel plug = new JLabel("Tipo de plug:");
	JRadioButton tipo1 = new JRadioButton("Tipo 1");
	JRadioButton tipo2 = new JRadioButton("Tipo 2");
	JRadioButton CSS2 = new JRadioButton("CSS2");
	JRadioButton CHAdeMO = new JRadioButton("CHAdeMO");
	private JLabel preco = new JLabel("Preço do kw: ");
	private JTextField precoText = new JTextField(20);
	private JLabel avaliacao = new JLabel("Avaliação: ");
	private JButton btnSalvar = new JButton("Salvar");
	String[] colunas = { "id", "nome", "rua", "bairro", "cidade", "preço", "estado" };
	DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
	JTable tabela = new JTable(tableModel);

	public Janela() {
		getContentPane().setLayout(null);
		setBounds(150, 150, 700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void init() {

		nome.setBounds(226, 90, 46, 14);
		nome.setFont(new Font("Arial", Font.BOLD, 12));
		getContentPane().add(painelCadastro.add(nome));

		nomeTxt.setBounds(270, 90, 170, 20);
		getContentPane().add(nomeTxt);

		rua.setBounds(226, 110, 154, 45);
		rua.setFont(new Font("Arial", Font.BOLD, 12));
		getContentPane().add(rua);

		ruaTxt.setBounds(270, 120, 170, 20);
		getContentPane().add(ruaTxt);

		bairro.setBounds(226, 140, 154, 45);
		bairro.setFont(new Font("Arial", Font.BOLD, 12));
		getContentPane().add(bairro);

		bairroTxt.setBounds(270, 150, 170, 20);
		getContentPane().add(bairroTxt);

		cidade.setBounds(226, 170, 154, 45);
		cidade.setFont(new Font("Arial", Font.BOLD, 12));
		getContentPane().add(cidade);

		cidadeTxt.setBounds(270, 180, 170, 20);
		getContentPane().add(cidadeTxt);

		estado.setBounds(226, 200, 154, 45);
		estado.setFont(new Font("Arial", Font.BOLD, 12));
		getContentPane().add(estado);

		estadoTxt.setBounds(270, 210, 170, 20);
		getContentPane().add(estadoTxt);

		plug.setBounds(226, 230, 154, 45);
		plug.setFont(new Font("Arial", Font.BOLD, 12));
		getContentPane().add(plug);

		tipo1.setBounds(350, 240, 97, 23);
		getContentPane().add(tipo1);

		tipo2.setBounds(350, 260, 97, 23);
		getContentPane().add(tipo2);

		CSS2.setBounds(350, 280, 97, 23);
		getContentPane().add(CSS2);

		CHAdeMO.setBounds(350, 300, 97, 23);
		getContentPane().add(CHAdeMO);

		preco.setBounds(226, 330, 100, 14);
		preco.setFont(new Font("Arial", Font.BOLD, 12));
		getContentPane().add(preco);

		precoText.setBounds(305, 330, 130, 20);
		getContentPane().add(precoText);

		avaliacao.setBounds(226, 360, 80, 14);
		avaliacao.setFont(new Font("Arial", Font.BOLD, 12));
		getContentPane().add(avaliacao);

		StarRater star = new StarRater();
		star.setBounds(305, 360, 80, 30);
		getContentPane().add(star);

		btnSalvar.setBounds(290, 400, 80, 30);
		getContentPane().add(btnSalvar);
		this.add(abas);
		setVisible(true);

		BotaoListener listener = new BotaoListener(this);
		btnSalvar.addActionListener(listener);
		carregarDados();

		abas.add(painelCadastro, "Cadastro");
		abas.add(new JScrollPane(tabela), "Consulta");
		getContentPane().add(abas);
		abas.setBounds(0, 0, 800, 800);

	}

	public void carregarDados() {
		tableModel.setRowCount(0);
		List<Produto> lista = new ProdutoDao().listarTodos();
		lista.forEach(produto -> tableModel.addRow(produto.getData()));
	}

	public JTextField getNomeTxt() {
		return this.nomeTxt;
	}

	public JTextField getRuaTxt() {
		return this.ruaTxt;
	}

	public JTextField getBairroTxt() {
		return this.bairroTxt;
	}

	public JTextField getCidadeTxt() {
		return this.cidadeTxt;
	}

	public JTextField getEstadoTxt() {
		return this.estadoTxt;
	}

	public JTextField getprecoText() {
		return this.precoText;
	}

}
