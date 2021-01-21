package apresentacao;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dados.Consulta;
import dados.Medico;
import dados.Paciente;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import negocio.Sistema;
import persistencia.ConsultaDAO;
import persistencia.MedicoDAO;
import persistencia.PacienteDAO;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.util.List;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import java.awt.CardLayout;

public class Principal {
	
	static Sistema sistema = new Sistema();
	
	private JFrame frameSistemaHospital;
	
	private JTabbedPane tabbedOpcoes;
	
	private JTabbedPane tabbedCadastrar;
	private JPanel panelCadastrarMedico;
	private JPanel panelCadastrarPaciente;
	private JPanel panelCadastrarConsulta;
	
	private JLayeredPane layeredBuscar;
	private JPanel panelBuscar;
	private JPanel panelBuscarMedico;
	private JTable tableMedicos;
	private JScrollPane scrollMedico;
	private JPanel panelBuscarPaciente;
	private JTable tablePacientes;
	private JScrollPane scrollPaciente;
	private JPanel panelBuscarConsulta;
	private JTable tableConsultas;
	private JScrollPane scrollConsulta;
	
	private JPanel panelDeletar;
	
	private JLayeredPane layeredAlterar;
	private JPanel panelAlterar;
	private JPanel panelAlterarMedico;
	private JPanel panelAlterarPaciente;
	private JPanel panelAlterarConsulta;
	
	private JTextField textNomeMedico;
	private JTextField textIdadeMedico;
	private JTextField textCpfMedico;
	private JTextField textCidadeMedico;
	private JTextField textEspecialidade;
	
	private JTextField textNomePaciente;
	private JTextField textIdadePaciente;
	private JTextField textCpfPaciente;
	private JTextField textCidadePaciente;
	private JTextField textDescricao;
	
	private JTextField textValor;
	private JTextField textData;
	private JTextField textHorario;
	private JTextField textDiagnostico;
	private JTextField textMedico;
	private JTextField textPaciente;
	
	private JTextField textDeletarMedico;
	
	private JTextField textDeletarPaciente;
	
	private JTextField textDeletarConsulta;
	
	private JTextField textCodigoDigitadoMedico;
	private JTextField textAlterarNomeMedico;
	private JTextField textAlterarIdadeMedico;
	private JTextField textAlterarCpfMedico;
	private JTextField textAlterarCidadeMedico;
	private JTextField textAlterarEspecialidadeMedico;
	
	private JTextField textCodigoDigitadoPaciente;
	private JTextField textAlterarNomePaciente;
	private JTextField textAlterarIdadePaciente;
	private JTextField textAlterarCpfPaciente;
	private JTextField textAlterarCidadePaciente;
	private JTextField textAlterarDescricaoPaciente;
	
	private JTextField textCodigoDigitadoConsulta;
	private JTextField textAlterarValorConsulta;
	private JTextField textAlterarDataConsulta;
	private JTextField textAlterarHorarioConsulta;
	private JTextField textAlterarDiagnosticoConsulta;
	private JTextField textAlterarMedicoConsulta;
	private JTextField textAlterarPacienteConsulta;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frameSistemaHospital.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Criando frame do sistema
		frameSistemaHospital = new JFrame();
		frameSistemaHospital.setBounds(100, 100, 789, 449);
		frameSistemaHospital.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Criando abas de opcoes
		tabbedOpcoes = new JTabbedPane(JTabbedPane.TOP);
		frameSistemaHospital.getContentPane().add(tabbedOpcoes, BorderLayout.CENTER);
		
		//Criando a aba Cadastrar
		tabbedCadastrar = new JTabbedPane(JTabbedPane.TOP);
		tabbedOpcoes.addTab("Cadastrar", null, tabbedCadastrar, null);
		
		criarPainelCadastrarMedico();
		
		criarPainelCadastrarPaciente();
		
		criarPainelCadastrarConsulta();
		
		//Criando a aba Buscar  
		layeredBuscar = new JLayeredPane();
		layeredBuscar.setLayout(new CardLayout(0, 0));
		tabbedOpcoes.addTab("Buscar", null, layeredBuscar, null);
		
		criarPainelBuscar();
		
		criarPainelBuscarMedicos(); 
		
		criarPainelBuscarPacientes();
		
		criarPainelBuscarConsultas();
		
		//Criando a aba Deletar
		panelDeletar = new JPanel();
		panelDeletar.setLayout(null);
		tabbedOpcoes.addTab("Deletar", null, panelDeletar, null);
		
		criarDeletarMedico();
		
		criarDeletarPaciente();
		
		criarDeletarConsulta();
		
		//Criando a aba Alterar
		layeredAlterar = new JLayeredPane();
		layeredAlterar.setLayout(new CardLayout(0, 0));
		tabbedOpcoes.addTab("Alterar", null, layeredAlterar, null);
		
		criarPanelAlterar();
		
		criarPanelAlterarMedico();
		
		criarPanelAlterarPaciente();
		
		criarPanelAlterarConsulta();
	}
	
	public void criarPainelCadastrarMedico() {
		panelCadastrarMedico = new JPanel();
		panelCadastrarMedico.setLayout(null);
		tabbedCadastrar.addTab("Medico", null, panelCadastrarMedico, null);
		
		JLabel lblNomeMedico = new JLabel("Nome");
		lblNomeMedico.setToolTipText("");
		lblNomeMedico.setBounds(82, 31, 80, 22);
		panelCadastrarMedico.add(lblNomeMedico);
		
		textNomeMedico = new JTextField();
		textNomeMedico.setBounds(244, 31, 374, 22);
		textNomeMedico.setColumns(10);
		panelCadastrarMedico.add(textNomeMedico);
		
		JLabel lblIdadeMedico = new JLabel("Idade");
		lblIdadeMedico.setBounds(82, 84, 46, 22);
		panelCadastrarMedico.add(lblIdadeMedico);
		
		textIdadeMedico = new JTextField();
		textIdadeMedico.setBounds(244, 84, 374, 22);
		textIdadeMedico.setColumns(10);
		panelCadastrarMedico.add(textIdadeMedico);
		
		JLabel lblCpfMedico = new JLabel("CPF");
		lblCpfMedico.setBounds(82, 137, 46, 22);
		panelCadastrarMedico.add(lblCpfMedico);
		
		textCpfMedico = new JTextField();
		textCpfMedico.setBounds(244, 137, 374, 22);
		textCpfMedico.setColumns(10);
		panelCadastrarMedico.add(textCpfMedico);
		
		JLabel lblCidadeMedico = new JLabel("Cidade");
		lblCidadeMedico.setBounds(82, 190, 46, 22);
		panelCadastrarMedico.add(lblCidadeMedico);
		
		textCidadeMedico = new JTextField();
		textCidadeMedico.setBounds(244, 190, 374, 22);
		textCidadeMedico.setColumns(10);
		panelCadastrarMedico.add(textCidadeMedico);
		
		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(82, 243, 92, 22);
		panelCadastrarMedico.add(lblEspecialidade);
		
		textEspecialidade = new JTextField();
		textEspecialidade.setBounds(244, 243, 374, 22);
		textEspecialidade.setColumns(10);
		panelCadastrarMedico.add(textEspecialidade);
		
		JButton btnRealizarCadastroMedico = new JButton("Cadastrar Medico");
		btnRealizarCadastroMedico.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cadastrarMedico();
			}
		});
		btnRealizarCadastroMedico.setBounds(244, 296, 159, 22);
		panelCadastrarMedico.add(btnRealizarCadastroMedico);
	}
	
	public void cadastrarMedico() {
		Medico medico = new Medico();
		
		medico.setNome(textNomeMedico.getText());
		medico.setIdade(Integer.parseInt(textIdadeMedico.getText()));		
		medico.setCpf(Long.parseLong(textCpfMedico.getText()));						
		medico.setCidade(textCidadeMedico.getText());
		medico.setEspecialidade(textEspecialidade.getText());
		
		try {
			sistema.cadastrarMedico(medico);
			limparCadastrarMedico();
			JOptionPane.showMessageDialog(null, "Cadastro do medico efetuado com sucesso!");
		} catch (ClassNotFoundException e1) {
			System.err.println(e1.getMessage());
			System.err.println("Erro, medico nao encontrado!");
			JOptionPane.showMessageDialog(null, "Erro, medico nao encontrado!");
		} catch (InsertException e2) {
			System.err.println(e2.getMessage());
			System.err.println("Erro ao inserir medico!");
			JOptionPane.showMessageDialog(null, "Erro ao inserir medico!");
		} catch (SQLException e3) {
			System.err.println(e3.getMessage());
			System.err.println("Erro ao acessar o banco de dados!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados!");
		}
	}
	
	public void criarPainelCadastrarPaciente() {
		panelCadastrarPaciente = new JPanel();
		panelCadastrarPaciente.setLayout(null);
		tabbedCadastrar.addTab("Paciente", null, panelCadastrarPaciente, null);
		
		JLabel lblNomePaciente = new JLabel("Nome");
		lblNomePaciente.setToolTipText("");
		lblNomePaciente.setBounds(82, 31, 80, 22);
		panelCadastrarPaciente.add(lblNomePaciente);
		
		textNomePaciente = new JTextField();
		textNomePaciente.setColumns(10);
		textNomePaciente.setBounds(244, 31, 374, 22);
		panelCadastrarPaciente.add(textNomePaciente);
		
		JLabel lblIdadePaciente = new JLabel("Idade");
		lblIdadePaciente.setBounds(82, 84, 46, 22);
		panelCadastrarPaciente.add(lblIdadePaciente);
		
		textIdadePaciente = new JTextField();
		textIdadePaciente.setColumns(10);
		textIdadePaciente.setBounds(244, 84, 374, 22);
		panelCadastrarPaciente.add(textIdadePaciente);
		
		JLabel lblCpfPaciente = new JLabel("CPF");
		lblCpfPaciente.setBounds(82, 137, 46, 22);
		panelCadastrarPaciente.add(lblCpfPaciente);
		
		textCpfPaciente = new JTextField();
		textCpfPaciente.setColumns(10);
		textCpfPaciente.setBounds(244, 137, 374, 22);
		panelCadastrarPaciente.add(textCpfPaciente);
		
		JLabel lblCidadePaciente = new JLabel("Cidade");
		lblCidadePaciente.setBounds(82, 190, 46, 22);
		panelCadastrarPaciente.add(lblCidadePaciente);
		
		textCidadePaciente = new JTextField();
		textCidadePaciente.setColumns(10);
		textCidadePaciente.setBounds(244, 190, 374, 22);
		panelCadastrarPaciente.add(textCidadePaciente);
		
		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setBounds(82, 247, 92, 22);
		panelCadastrarPaciente.add(lblDescricao);
		
		textDescricao = new JTextField();
		textDescricao.setColumns(10);
		textDescricao.setBounds(244, 243, 374, 22);
		panelCadastrarPaciente.add(textDescricao);
		
		JButton btnRealizarCadastroPaciente = new JButton("Cadastrar Paciente");
		btnRealizarCadastroPaciente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cadastrarPaciente();
			}
		});
		btnRealizarCadastroPaciente.setBounds(244, 296, 159, 22);
		panelCadastrarPaciente.add(btnRealizarCadastroPaciente);
	}
	
	public void cadastrarPaciente() {
		Paciente paciente = new Paciente();
		
		paciente.setNome(textNomePaciente.getText());
		paciente.setIdade(Integer.parseInt(textIdadePaciente.getText()));		
		paciente.setCpf(Long.parseLong(textCpfPaciente.getText()));						
		paciente.setCidade(textCidadePaciente.getText());
		paciente.setDescricao(textDescricao.getText());
		
		try {
			sistema.cadastrarPaciente(paciente);
			limparCadastrarPaciente();
			JOptionPane.showMessageDialog(null, "Cadastro do paciente efetuado com sucesso!");
		} catch (ClassNotFoundException e1) {
			System.err.println(e1.getMessage());
			System.err.println("Erro, paciente nao encontrado!");
			JOptionPane.showMessageDialog(null, "Erro, paciente nao encontrado!");
		} catch (InsertException e2) {
			System.err.println(e2.getMessage());
			System.err.println("Erro ao inserir paciente!");
			JOptionPane.showMessageDialog(null, "Erro ao inserir paciente!");
		} catch (SQLException e3) {
			System.err.println(e3.getMessage());
			System.err.println("Erro ao acessar o banco de dados!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados!");
		}
	}
	
	public void criarPainelCadastrarConsulta(){
		panelCadastrarConsulta = new JPanel();
		panelCadastrarConsulta.setLayout(null);
		tabbedCadastrar.addTab("Consulta", null, panelCadastrarConsulta, null);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setToolTipText("");
		lblValor.setBounds(82, 26, 80, 22);
		panelCadastrarConsulta.add(lblValor);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(244, 26, 374, 22);
		panelCadastrarConsulta.add(textValor);
		
		JLabel lblData = new JLabel("Data (aaaa-mm-dd)");
		lblData.setBounds(82, 78, 117, 22);
		panelCadastrarConsulta.add(lblData);
		
		textData = new JTextField();
		textData.setColumns(10);
		textData.setBounds(244, 74, 374, 22);
		panelCadastrarConsulta.add(textData);
		
		JLabel lblHorario = new JLabel("Horario (xx:xx:xx)");
		lblHorario.setBounds(82, 124, 117, 22);
		panelCadastrarConsulta.add(lblHorario);
		
		textHorario = new JTextField();
		textHorario.setColumns(10);
		textHorario.setBounds(244, 120, 374, 22);
		panelCadastrarConsulta.add(textHorario);
		
		JLabel lblDiagnstico = new JLabel("Diagnostico");
		lblDiagnstico.setBounds(82, 170, 80, 22);
		panelCadastrarConsulta.add(lblDiagnstico);
		
		textDiagnostico = new JTextField();
		textDiagnostico.setColumns(10);
		textDiagnostico.setBounds(244, 166, 374, 22);
		panelCadastrarConsulta.add(textDiagnostico);
		
		JLabel lblMedico = new JLabel("Codigo do Medico");
		lblMedico.setBounds(82, 216, 117, 22);
		panelCadastrarConsulta.add(lblMedico);
		
		textMedico = new JTextField();
		textMedico.setColumns(10);
		textMedico.setBounds(244, 212, 374, 22);
		panelCadastrarConsulta.add(textMedico);
		
		JLabel lblPaciente = new JLabel("Codigo do Paciente");
		lblPaciente.setBounds(82, 262, 117, 22);
		panelCadastrarConsulta.add(lblPaciente);
		
		textPaciente = new JTextField();
		textPaciente.setColumns(10);
		textPaciente.setBounds(244, 258, 374, 22);
		panelCadastrarConsulta.add(textPaciente);
		
		JButton btnRealizarCadastroConsulta = new JButton("Cadastrar Consulta");
		btnRealizarCadastroConsulta.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cadastrarConsulta();
			}
		});
		btnRealizarCadastroConsulta.setBounds(244, 304, 159, 22);
		panelCadastrarConsulta.add(btnRealizarCadastroConsulta);
	}
	
	public void cadastrarConsulta() {
		Consulta consulta = new Consulta();
		
		try {
			consulta.setValor(Double.parseDouble(textValor.getText()));
			consulta.setData(Date.valueOf(textData.getText()));
			consulta.setHorario(Time.valueOf(textHorario.getText()));
			consulta.setDiagnostico(textDiagnostico.getText());
			consulta.setMedico(sistema.getMedico(Integer.parseInt(textMedico.getText())));
			consulta.setPaciente(sistema.getPaciente(Integer.parseInt(textPaciente.getText())));
			
			sistema.cadastrarConsulta(consulta);
			limparCadastrarConsulta();
			JOptionPane.showMessageDialog(null, "Cadastro da consulta efetuado com sucesso!");
		} catch (ClassNotFoundException e1) {
			System.err.println(e1.getMessage());
			System.err.println("Erro, consulta nao encontrada!");
			JOptionPane.showMessageDialog(null, "Erro, consulta nao encontrada!");
		} catch (InsertException e2) {
			System.err.println(e2.getMessage());
			System.err.println("Erro ao inserir consulta!");
			JOptionPane.showMessageDialog(null, "Erro ao inserir consulta!");
		} catch (SQLException e3) {
			System.err.println(e3.getMessage());
			System.err.println("Erro ao acessar o banco de dados!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados!");
		} catch (NumberFormatException e4) {
			System.err.println(e4.getMessage());
			System.err.println("Erro nos codigos informados ou no formato dos dados inseridos!");
			JOptionPane.showMessageDialog(null, "Erro nos codigos informados ou no formato dos dados inseridos!");
		} catch (SelectException e5) {
			System.err.println(e5.getMessage());
			System.err.println("Erro ao acessar!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar!");
		}
	}
	
	public void criarPainelBuscar() {
		panelBuscar = new JPanel();
		panelBuscar.setLayout(null);
		layeredBuscar.add(panelBuscar, "name_184619816412700");
		
		JButton btnListarMedicos = new JButton("Listar Medicos");
		btnListarMedicos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelBuscar.setVisible(false);
				listarMedicos();
				panelBuscarMedico.setVisible(true);
			}
		});
		btnListarMedicos.setBounds(293, 78, 182, 23);
		panelBuscar.add(btnListarMedicos);
		
		JButton btnListarPacientes = new JButton("Listar Pacientes");
		btnListarPacientes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelBuscar.setVisible(false);
				listarPacientes();
				panelBuscarPaciente.setVisible(true);
			}
		});
		btnListarPacientes.setBounds(293, 179, 182, 23);
		panelBuscar.add(btnListarPacientes);
		
		JButton btnListarConsultas = new JButton("Listar Consultas");
		btnListarConsultas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelBuscar.setVisible(false);
				listarConsultas();
				panelBuscarConsulta.setVisible(true);
			}
		});
		btnListarConsultas.setBounds(293, 280, 182, 23);
		panelBuscar.add(btnListarConsultas);
	}
	public void listarMedicos() {
		
		tableMedicos.setBorder( new LineBorder(new Color(0, 0, 0)));
		tableMedicos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nome", "Idade", "Cpf", "Cidade", "Especialidade"
			}
		));
		tableMedicos.setBounds(0, 0, 667, 342);
		
		tableMedicos.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableMedicos.getColumnModel().getColumn(2).setPreferredWidth(20);
		tableMedicos.getColumnModel().getColumn(3).setPreferredWidth(20);
		tableMedicos.getColumnModel().getColumn(4).setPreferredWidth(20);
		tableMedicos.getColumnModel().getColumn(5).setPreferredWidth(20);
		
		atualizarTabelaMedicos();	
	}
	
	public void listarPacientes() {
		
		tablePacientes.setBorder( new LineBorder(new Color(0, 0, 0)));
		tablePacientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nome", "Idade", "Cpf", "Cidade", "Descricao"
			}
		));
		tablePacientes.setBounds(0, 0, 667, 342);
		
		tablePacientes.getColumnModel().getColumn(0).setPreferredWidth(20);
		tablePacientes.getColumnModel().getColumn(1).setPreferredWidth(85);
		tablePacientes.getColumnModel().getColumn(2).setPreferredWidth(20);
		tablePacientes.getColumnModel().getColumn(3).setPreferredWidth(20);
		tablePacientes.getColumnModel().getColumn(4).setPreferredWidth(35);
		tablePacientes.getColumnModel().getColumn(5).setPreferredWidth(150);
		
		atualizarTabelaPacientes();	
	}
	
	public void listarConsultas() {
		
		tableConsultas.setBorder( new LineBorder(new Color(0, 0, 0)));
		tableConsultas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Valor", "Data", "Horario", "Diagnostico", "Cod. Medico", "Cod. Paciente"
			}
		));
		tableConsultas.setBounds(0, 0, 667, 342);
		
		tableConsultas.getColumnModel().getColumn(0).setPreferredWidth(10);
		tableConsultas.getColumnModel().getColumn(1).setPreferredWidth(90);
		tableConsultas.getColumnModel().getColumn(2).setPreferredWidth(40);
		tableConsultas.getColumnModel().getColumn(3).setPreferredWidth(20);
		tableConsultas.getColumnModel().getColumn(4).setPreferredWidth(245);
		tableConsultas.getColumnModel().getColumn(5).setPreferredWidth(40);
		tableConsultas.getColumnModel().getColumn(6).setPreferredWidth(40);
		
		atualizarTabelaConsultas();	
	}
	
	public void criarPainelBuscarMedicos() {
		panelBuscarMedico = new JPanel();
		panelBuscarMedico.setLayout(null);
		layeredBuscar.add(panelBuscarMedico, "name_184619852570200");
		
		tableMedicos = new JTable();
		
		scrollMedico = new JScrollPane(tableMedicos);
		scrollMedico.setBounds(0, 0, 768, 333);
		scrollMedico.setViewportView(tableMedicos);
		panelBuscarMedico.add(scrollMedico);
		
		JButton btnVoltaBuscaMedicos = new JButton("Voltar");
		btnVoltaBuscaMedicos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelBuscarMedico.setVisible(false);
				panelBuscar.setVisible(true);
			}
		});
		btnVoltaBuscaMedicos.setBounds(164, 344, 89, 23);
		panelBuscarMedico.add(btnVoltaBuscaMedicos);
		
		JButton btnAtualizarListaMedico = new JButton("Atualizar Lista");
		btnAtualizarListaMedico.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				limpaTabela(tableMedicos);
				atualizarTabelaMedicos();
			}
		});
		btnAtualizarListaMedico.setBounds(417, 344, 170, 23);
		panelBuscarMedico.add(btnAtualizarListaMedico);
	}
	
	public void atualizarTabelaMedicos() {
		List<Medico> medicos;
		String linha[] = new String[] {"", "", "", "", "", ""};
		DefaultTableModel dadosMedico = (DefaultTableModel) tableMedicos.getModel();
		
		try {
			medicos = MedicoDAO.getInstance().getAll();
			int pos = -1;
			for(Medico medico : medicos) {
				pos++;
				dadosMedico.addRow(linha);
				dadosMedico.setValueAt(medico.getCodigo(), pos, 0);
				dadosMedico.setValueAt(medico.getNome(), pos, 1);
				dadosMedico.setValueAt(medico.getIdade(), pos, 2);
				dadosMedico.setValueAt(medico.getCpf(), pos, 3);
				dadosMedico.setValueAt(medico.getCidade(), pos, 4);
				dadosMedico.setValueAt(medico.getEspecialidade(), pos, 5);
			}
		} catch (ClassNotFoundException e1) {
			System.err.println(e1.getMessage());
			System.err.println("Erro, medico nao encontrado!");
			JOptionPane.showMessageDialog(null, "Erro, medico nao encontrado!");
		} catch (SelectException e2) {
			System.err.println(e2.getMessage());
			System.err.println("Erro ao acessar medico!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar medico!");
		} catch (SQLException e3) {
			System.err.println(e3.getMessage());
			System.err.println("Erro ao acessar o banco de dados!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados!");
		}
	}
	
	public void criarPainelBuscarPacientes() {
		panelBuscarPaciente = new JPanel();
		panelBuscarPaciente.setLayout(null);
		layeredBuscar.add(panelBuscarPaciente, "name_184619890625200");
		
		tablePacientes = new JTable();
		
		scrollPaciente = new JScrollPane(tablePacientes);
		scrollPaciente.setBounds(0, 0, 768, 333);
		scrollPaciente.setViewportView(tablePacientes);
		panelBuscarPaciente.add(scrollPaciente);
		
		JButton btnVoltaBuscaPacientes = new JButton("Voltar");
		btnVoltaBuscaPacientes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelBuscarPaciente.setVisible(false);
				panelBuscar.setVisible(true);
			}
		});
		btnVoltaBuscaPacientes.setBounds(164, 344, 89, 23);
		panelBuscarPaciente.add(btnVoltaBuscaPacientes);
		
		JButton btnAtualizarListaPaciente = new JButton("Atualizar Lista");
		btnAtualizarListaPaciente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				limpaTabela(tablePacientes);
				atualizarTabelaPacientes();
			}
		});
		btnAtualizarListaPaciente.setBounds(417, 344, 170, 23);
		panelBuscarPaciente.add(btnAtualizarListaPaciente);
	}
	
	public void atualizarTabelaPacientes() {
		List<Paciente> pacientes;
		String linha[] = new String[] {"", "", "", "", "", ""};
		DefaultTableModel dadosPaciente = (DefaultTableModel) tablePacientes.getModel();
		
		try {
			pacientes = PacienteDAO.getInstance().getAll();
			int pos = -1;
			for(Paciente paciente : pacientes) {
				pos++;
				dadosPaciente.addRow(linha);
				dadosPaciente.setValueAt(paciente.getCodigo(), pos, 0);
				dadosPaciente.setValueAt(paciente.getNome(), pos, 1);
				dadosPaciente.setValueAt(paciente.getIdade(), pos, 2);
				dadosPaciente.setValueAt(paciente.getCpf(), pos, 3);
				dadosPaciente.setValueAt(paciente.getCidade(), pos, 4);
				dadosPaciente.setValueAt(paciente.getDescricao(), pos, 5);
			}
		} catch (ClassNotFoundException e1) {
			System.err.println(e1.getMessage());
			System.err.println("Erro, paciente nao encontrado!");
			JOptionPane.showMessageDialog(null, "Erro, paciente nao encontrado!");
		} catch (SelectException e2) {
			System.err.println(e2.getMessage());
			System.err.println("Erro ao acessar paciente!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar paciente!");
		} catch (SQLException e3) {
			System.err.println(e3.getMessage());
			System.err.println("Erro ao acessar o banco de dados!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados!");
		}
	}
	
	public void criarPainelBuscarConsultas() {
		panelBuscarConsulta = new JPanel();
		panelBuscarConsulta.setLayout(null);
		layeredBuscar.add(panelBuscarConsulta, "name_184619928087000");
		
		tableConsultas = new JTable();
		
		scrollConsulta = new JScrollPane(tableConsultas);
		scrollConsulta.setBounds(0, 0, 768, 333);
		scrollConsulta.setViewportView(tableConsultas);
		panelBuscarConsulta .add(scrollConsulta);
		
		JButton btnVoltaBuscaConsultas = new JButton("Voltar");
		btnVoltaBuscaConsultas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelBuscarConsulta.setVisible(false);
				panelBuscar.setVisible(true);
			}
		});
		btnVoltaBuscaConsultas.setBounds(164, 344, 89, 23);
		panelBuscarConsulta.add(btnVoltaBuscaConsultas);
		
		JButton btnAtualizarListaConsulta = new JButton("Atualizar Lista");
		btnAtualizarListaConsulta.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				limpaTabela(tableConsultas);
				atualizarTabelaConsultas();
			}
		});
		btnAtualizarListaConsulta.setBounds(417, 344, 170, 23);
		panelBuscarConsulta.add(btnAtualizarListaConsulta);
	}
	
	public void atualizarTabelaConsultas() {
		List<Consulta> consultas;
		String linha[] = new String[] {"", "", "", "", "", "", ""};
		DefaultTableModel dadosConsulta = (DefaultTableModel) tableConsultas.getModel();
		
		try {
			consultas = ConsultaDAO.getInstance().getAll();
			int pos = -1;
			for(Consulta consulta : consultas) {
				pos++;
				dadosConsulta.addRow(linha);
				dadosConsulta.setValueAt(consulta.getCodigo(), pos, 0);
				dadosConsulta.setValueAt(consulta.getValor(), pos, 1);
				dadosConsulta.setValueAt(consulta.getData(), pos, 2);
				dadosConsulta.setValueAt(consulta.getHorario(), pos, 3);
				dadosConsulta.setValueAt(consulta.getDiagnostico(), pos, 4);
				dadosConsulta.setValueAt(consulta.getMedico().getCodigo(), pos, 5);
				dadosConsulta.setValueAt(consulta.getPaciente().getCodigo(), pos, 6);
			}
		} catch (ClassNotFoundException e1) {
			System.err.println(e1.getMessage());
			System.err.println("Erro, consulta nao encontrada!");
			JOptionPane.showMessageDialog(null, "Erro, consulta nao encontrada!");
		} catch (SelectException e2) {
			System.err.println(e2.getMessage());
			System.err.println("Erro ao acessar consulta!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar consulta!");
		} catch (SQLException e3) {
			System.err.println(e3.getMessage());
			System.err.println("Erro ao acessar o banco de dados!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados!");
		}
	}
	
	public void criarDeletarMedico() {
		JLabel lblDeletarMedico = new JLabel();
		lblDeletarMedico.setBackground(UIManager.getColor("Button.background"));
		lblDeletarMedico.setText("Digite o codigo do medico");
		lblDeletarMedico.setBounds(62, 79, 169, 23);
		panelDeletar.add(lblDeletarMedico);
		
		textDeletarMedico = new JTextField();
		textDeletarMedico.setBounds(282, 80, 144, 23);
		textDeletarMedico.setColumns(10);
		panelDeletar.add(textDeletarMedico);
		
		JButton btnDeletarMedico = new JButton("Deletar Medico");
		btnDeletarMedico.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				deletarMedico(textDeletarMedico.getText());
			}
		});
		btnDeletarMedico.setBounds(499, 80, 144, 23);
		panelDeletar.add(btnDeletarMedico);
	}
	
	public void deletarMedico(String textDeletarMedico) {
		try {
			sistema.removerMedico(sistema.getMedico(Integer.parseInt(textDeletarMedico)));
			limparDeletarMedico();
			JOptionPane.showMessageDialog(null, "Medico removido com sucesso!");
		} catch (ClassNotFoundException e1) {
			System.err.println(e1.getMessage());
			System.err.println("Erro, medico nao encontrado!");
			JOptionPane.showMessageDialog(null, "Erro, medico nao encontrado!");
		} catch (DeleteException e2) {
			System.err.println(e2.getMessage());
			System.err.println("Erro ao deletar medico!");
			JOptionPane.showMessageDialog(null, "Erro ao deletar medico!");
		} catch (SQLException e3) {
			System.err.println(e3.getMessage());
			System.err.println("Erro ao acessar o banco de dados!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados!");
		} catch (NumberFormatException e4) {
			System.err.println(e4.getMessage());
			System.err.println("Erro no codigo do medico informado!");
			JOptionPane.showMessageDialog(null, "Erro no codigo do medico informado!");
		} catch (SelectException e5) {
			System.err.println(e5.getMessage());
			System.err.println("Erro ao acessar medico!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar medico!");
		}
	}
	
	public void criarDeletarPaciente() {
		JLabel lblDeletarPaciente = new JLabel();
		lblDeletarPaciente.setBackground(UIManager.getColor("Button.background"));
		lblDeletarPaciente.setText("Digite o codigo do paciente");
		lblDeletarPaciente.setBounds(62, 180, 169, 23);
		panelDeletar.add(lblDeletarPaciente);
		
		textDeletarPaciente = new JTextField();
		textDeletarPaciente.setColumns(10);
		textDeletarPaciente.setBounds(282, 180, 144, 23);
		panelDeletar.add(textDeletarPaciente);
		
		JButton btnDeletarPaciente = new JButton("Deletar Paciente");
		btnDeletarPaciente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				deletarPaciente(textDeletarPaciente.getText());
			}
		});
		btnDeletarPaciente.setBounds(499, 180, 144, 23);
		panelDeletar.add(btnDeletarPaciente);
	}
	
	public void deletarPaciente(String textDeletarPaciente) {
		try {
			sistema.removerPaciente(sistema.getPaciente(Integer.parseInt(textDeletarPaciente)));
			limparDeletarPaciente();
			JOptionPane.showMessageDialog(null, "Paciente removido com sucesso!");
		} catch (ClassNotFoundException e1) {
			System.err.println(e1.getMessage());
			System.err.println("Erro, paciente nao encontrado!");
			JOptionPane.showMessageDialog(null, "Erro, paciente nao encontrado!");
		} catch (DeleteException e2) {
			System.err.println(e2.getMessage());
			System.err.println("Erro ao deletar paciente!");
			JOptionPane.showMessageDialog(null, "Erro ao deletar paciente!");
		} catch (SQLException e3) {
			System.err.println(e3.getMessage());
			System.err.println("Erro ao acessar o banco de dados!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados!");
		} catch (NumberFormatException e4) {
			System.err.println(e4.getMessage());
			System.err.println("Erro no codigo do paciente informado!");
			JOptionPane.showMessageDialog(null, "Erro no codigo do paciente informado!");
		} catch (SelectException e5) {
			System.err.println(e5.getMessage());
			System.err.println("Erro ao acessar paciente!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar paciente!");
		}
	}
	
	public void criarDeletarConsulta() {
		JLabel lblDeletarConsulta = new JLabel();
		lblDeletarConsulta.setBackground(UIManager.getColor("Button.background"));
		lblDeletarConsulta.setText("Digite o codigo da consulta");
		lblDeletarConsulta.setBounds(62, 280, 169, 23);
		panelDeletar.add(lblDeletarConsulta);
		
		textDeletarConsulta = new JTextField();
		textDeletarConsulta.setColumns(10);
		textDeletarConsulta.setBounds(282, 280, 144, 23);
		panelDeletar.add(textDeletarConsulta);
		
		JButton btnDeletarConsulta = new JButton("Deletar Consulta");
		btnDeletarConsulta.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				deletarConsulta(textDeletarConsulta.getText());
			}
		});
		btnDeletarConsulta.setBounds(499, 280, 144, 23);
		panelDeletar.add(btnDeletarConsulta);
	}
	
	public void deletarConsulta(String textDeletarConsulta) {
		try {
			sistema.removerConsulta(sistema.getConsulta(Integer.parseInt(textDeletarConsulta)));
			limparDeletarConsulta();
			JOptionPane.showMessageDialog(null, "Consulta removida com sucesso!");
		} catch (ClassNotFoundException e1) {
			System.err.println(e1.getMessage());
			System.err.println("Erro, consulta nao encontrada!");
			JOptionPane.showMessageDialog(null, "Erro, consulta nao encontrada!");
		} catch (DeleteException e2) {
			System.err.println(e2.getMessage());
			System.err.println("Erro ao deletar consulta!");
			JOptionPane.showMessageDialog(null, "Erro ao deletar consulta!");
		} catch (SQLException e3) {
			System.err.println(e3.getMessage());
			System.err.println("Erro ao acessar o banco de dados!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados!");
		} catch (NumberFormatException e4) {
			System.err.println(e4.getMessage());
			System.err.println("Erro no codigo da consulta informado!");
			JOptionPane.showMessageDialog(null, "Erro no codigo da consulta informado!");
		} catch (SelectException e5) {
			System.err.println(e5.getMessage());
			System.err.println("Erro ao acessar consulta!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar consulta!");
		}
	}
	
	public void criarPanelAlterar() {
		panelAlterar = new JPanel();
		panelAlterar.setLayout(null);
		layeredAlterar.add(panelAlterar, "name_185067173012800");
		
		JLabel lblAlterarMedico = new JLabel();
		lblAlterarMedico.setBackground(UIManager.getColor("Button.background"));
		lblAlterarMedico.setText("Digite o codigo do medico");
		lblAlterarMedico.setBounds(65, 78, 154, 23);
		panelAlterar.add(lblAlterarMedico);
		
		textCodigoDigitadoMedico = new JTextField();
		textCodigoDigitadoMedico.setBounds(284, 78, 145, 23);
		textCodigoDigitadoMedico.setColumns(10);
		panelAlterar.add(textCodigoDigitadoMedico);
		
		JButton btnAlterarMedicos = new JButton("Alterar Medico");
		btnAlterarMedicos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelAlterar.setVisible(false);
				panelAlterarMedico.setVisible(true);
			}
		});
		btnAlterarMedicos.setBounds(494, 78, 145, 23);
		panelAlterar.add(btnAlterarMedicos);
		
		JLabel lblAlterarPaciente = new JLabel();
		lblAlterarPaciente.setText("Digite o codigo do paciente");
		lblAlterarPaciente.setBackground(SystemColor.menu);
		lblAlterarPaciente.setBounds(65, 179, 154, 23);
		panelAlterar.add(lblAlterarPaciente);
		
		textCodigoDigitadoPaciente = new JTextField();
		textCodigoDigitadoPaciente.setBounds(284, 179, 145, 23);
		textCodigoDigitadoPaciente.setColumns(10);
		panelAlterar.add(textCodigoDigitadoPaciente);
		
		JButton btnAlterarPacientes = new JButton("Alterar Paciente");
		btnAlterarPacientes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelAlterar.setVisible(false);
				panelAlterarPaciente.setVisible(true);
			}
		});
		btnAlterarPacientes.setBounds(494, 179, 145, 23);
		panelAlterar.add(btnAlterarPacientes);
		
		JLabel lblAlterarConsulta = new JLabel();
		lblAlterarConsulta.setText("Digite o codigo da consulta");
		lblAlterarConsulta.setBackground(SystemColor.menu);
		lblAlterarConsulta.setBounds(65, 280, 154, 23);
		panelAlterar.add(lblAlterarConsulta);
		
		textCodigoDigitadoConsulta = new JTextField();
		textCodigoDigitadoConsulta.setBounds(284, 280, 145, 23);
		textCodigoDigitadoConsulta.setColumns(10);
		panelAlterar.add(textCodigoDigitadoConsulta);
		
		JButton btnAlterarConsultas = new JButton("Alterar Consulta");
		btnAlterarConsultas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelAlterar.setVisible(false);
				panelAlterarConsulta.setVisible(true);
			}
		});
		btnAlterarConsultas.setBounds(494, 280, 145, 23);
		panelAlterar.add(btnAlterarConsultas);
	}
	
	public void criarPanelAlterarMedico() {
		panelAlterarMedico = new JPanel();
		panelAlterarMedico.setLayout(null);
		panelAlterarMedico.setVisible(false);
		layeredAlterar.add(panelAlterarMedico, "name_185067340967200");
		
		JLabel lblMensagemAlterarMedico = new JLabel();
		lblMensagemAlterarMedico.setBackground(UIManager.getColor("Button.background"));
		lblMensagemAlterarMedico.setText("Preencha os campos que deseja alterar");
		lblMensagemAlterarMedico.setBounds(248, 28, 266, 20);
		panelAlterarMedico.add(lblMensagemAlterarMedico);
		
		JLabel lblAlterarNomeMedico = new JLabel("Nome");
		lblAlterarNomeMedico.setToolTipText("");
		lblAlterarNomeMedico.setBounds(84, 76, 80, 22);
		panelAlterarMedico.add(lblAlterarNomeMedico);
		
		textAlterarNomeMedico = new JTextField();
		textAlterarNomeMedico.setColumns(10);
		textAlterarNomeMedico.setBounds(248, 76, 374, 22);
		panelAlterarMedico.add(textAlterarNomeMedico);
		
		JLabel lblAlterarIdadeMedico = new JLabel("Idade");
		lblAlterarIdadeMedico.setBounds(84, 126, 46, 22);
		panelAlterarMedico.add(lblAlterarIdadeMedico);
		
		textAlterarIdadeMedico = new JTextField();
		textAlterarIdadeMedico.setColumns(10);
		textAlterarIdadeMedico.setBounds(248, 126, 374, 22);
		panelAlterarMedico.add(textAlterarIdadeMedico);
		
		JLabel lblALterarCpfMedico = new JLabel("CPF");
		lblALterarCpfMedico.setBounds(84, 176, 46, 22);
		panelAlterarMedico.add(lblALterarCpfMedico);
		
		textAlterarCpfMedico = new JTextField();
		textAlterarCpfMedico.setColumns(10);
		textAlterarCpfMedico.setBounds(248, 176, 374, 22);
		panelAlterarMedico.add(textAlterarCpfMedico);
		
		JLabel lblAlterarCidadeMedico = new JLabel("Cidade");
		lblAlterarCidadeMedico.setBounds(84, 226, 46, 22);
		panelAlterarMedico.add(lblAlterarCidadeMedico);
		
		textAlterarCidadeMedico = new JTextField();
		textAlterarCidadeMedico.setColumns(10);
		textAlterarCidadeMedico.setBounds(248, 226, 374, 22);
		panelAlterarMedico.add(textAlterarCidadeMedico);
		
		JLabel lblALterarEspecialidadeMedico = new JLabel("Especialidade");
		lblALterarEspecialidadeMedico.setBounds(84, 276, 92, 22);
		panelAlterarMedico.add(lblALterarEspecialidadeMedico);
		
		textAlterarEspecialidadeMedico = new JTextField();
		textAlterarEspecialidadeMedico.setColumns(10);
		textAlterarEspecialidadeMedico.setBounds(248, 276, 374, 22);
		panelAlterarMedico.add(textAlterarEspecialidadeMedico);
		
		JButton btnAlterarMedico = new JButton("Alterar Medico");
		btnAlterarMedico.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				alterarMedico(textCodigoDigitadoMedico.getText());
				panelAlterarMedico.setVisible(false);
				panelAlterar.setVisible(true);
			}
		});
		btnAlterarMedico.setBounds(248, 326, 129, 22);
		panelAlterarMedico.add(btnAlterarMedico);
	}
	
	public void alterarMedico(String textCodigoDigitadoMedico) {
		
		try {
			Medico medico = sistema.getMedico(Integer.parseInt(textCodigoDigitadoMedico));
			
			if(textAlterarNomeMedico.getText().equalsIgnoreCase("") == false && medico.getNome().equalsIgnoreCase(textAlterarNomeMedico.getText()) == false)
				medico.setNome(textAlterarNomeMedico.getText());
			if(textAlterarIdadeMedico.getText().equalsIgnoreCase("") == false && medico.getIdade() != Integer.parseInt(textAlterarIdadeMedico.getText()))
				medico.setIdade(Integer.parseInt(textAlterarIdadeMedico.getText()));		
			if(textAlterarCpfMedico.getText().equalsIgnoreCase("") == false && medico.getCpf() != Long.parseLong(textAlterarCpfMedico.getText()))
				medico.setCpf(Long.parseLong(textAlterarCpfMedico.getText()));
			if(textAlterarCidadeMedico.getText().equalsIgnoreCase("") == false && medico.getCidade().equalsIgnoreCase(textAlterarCidadeMedico.getText()) == false)
				medico.setCidade(textAlterarCidadeMedico.getText());
			if(textAlterarEspecialidadeMedico.getText().equalsIgnoreCase("") == false && medico.getEspecialidade().equalsIgnoreCase(textAlterarEspecialidadeMedico.getText()) == false)
				medico.setEspecialidade(textAlterarEspecialidadeMedico.getText());
		
			sistema.alterarMedico(medico);
			limparAlterarMedico();
			JOptionPane.showMessageDialog(null, "Medico alterado!");	
		} catch (ClassNotFoundException e1) {
			System.err.println(e1.getMessage());
			System.err.println("Erro, paciente nao encontrado!");
			JOptionPane.showMessageDialog(null, "Erro, paciente nao encontrado!");
		} catch (UpdateException e2) {
			System.err.println(e2.getMessage());
			System.err.println("Erro ao atualizar paciente!");
			JOptionPane.showMessageDialog(null, "Erro ao atualizar paciente!");
		} catch (SQLException e3) {
			System.err.println(e3.getMessage());
			System.err.println("Erro ao acessar o banco de dados!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados!");
		} catch (NumberFormatException e4) {
			System.err.println(e4.getMessage());
			System.err.println("Erro no codigo do medico informado ou no formato dos dados inseridos!");
			JOptionPane.showMessageDialog(null, "Erro no codigo do medico informado ou no formato dos dados inseridos!");
		} catch (SelectException e5) {
			System.err.println(e5.getMessage());
			System.err.println("Erro ao acessar paciente!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar paciente!");
		}
	}
	
	public void criarPanelAlterarPaciente() {
		panelAlterarPaciente = new JPanel();
		panelAlterarPaciente.setLayout(null);
		panelAlterarPaciente.setVisible(false);	
		layeredAlterar.add(panelAlterarPaciente, "name_185067444701100");
		
		JLabel lblMensagemAlterarPaciente = new JLabel();
		lblMensagemAlterarPaciente.setBounds(248, 30, 256, 20);
		lblMensagemAlterarPaciente.setText("Preencha os campos que deseja alterar");
		lblMensagemAlterarPaciente.setBackground(SystemColor.menu);
		panelAlterarPaciente.add(lblMensagemAlterarPaciente);
		
		JLabel lblAlterarNomePaciente = new JLabel("Nome");
		lblAlterarNomePaciente.setBounds(84, 79, 80, 22);
		panelAlterarPaciente.add(lblAlterarNomePaciente);
		
		textAlterarNomePaciente = new JTextField();
		textAlterarNomePaciente.setColumns(10);
		textAlterarNomePaciente.setBounds(248, 80, 374, 20);
		panelAlterarPaciente.add(textAlterarNomePaciente);
		
		JLabel lblAlterarIdadePaciente = new JLabel("Idade");
		lblAlterarIdadePaciente.setBounds(84, 129, 80, 22);
		panelAlterarPaciente.add(lblAlterarIdadePaciente);
		
		textAlterarIdadePaciente = new JTextField();
		textAlterarIdadePaciente.setColumns(10);
		textAlterarIdadePaciente.setBounds(248, 130, 374, 20);
		panelAlterarPaciente.add(textAlterarIdadePaciente);
		
		JLabel lblAlterarCpfPaciente = new JLabel("CPF");
		lblAlterarCpfPaciente.setBounds(84, 179, 80, 22);
		panelAlterarPaciente.add(lblAlterarCpfPaciente);
		
		textAlterarCpfPaciente = new JTextField();
		textAlterarCpfPaciente.setColumns(10);
		textAlterarCpfPaciente.setBounds(248, 180, 374, 20);
		panelAlterarPaciente.add(textAlterarCpfPaciente);
		
		JLabel lblAlterarCidadePaciente = new JLabel("Cidade");
		lblAlterarCidadePaciente.setBounds(84, 228, 80, 22);
		panelAlterarPaciente.add(lblAlterarCidadePaciente);
		
		textAlterarCidadePaciente = new JTextField();
		textAlterarCidadePaciente.setColumns(10);
		textAlterarCidadePaciente.setBounds(248, 230, 374, 20);
		panelAlterarPaciente.add(textAlterarCidadePaciente);
		
		JLabel lblALterarDescricaoPaciente = new JLabel("Descricao");
		lblALterarDescricaoPaciente.setBounds(84, 279, 80, 22);
		panelAlterarPaciente.add(lblALterarDescricaoPaciente);
		
		textAlterarDescricaoPaciente = new JTextField();
		textAlterarDescricaoPaciente.setColumns(10);
		textAlterarDescricaoPaciente.setBounds(248, 280, 374, 20);
		panelAlterarPaciente.add(textAlterarDescricaoPaciente);
		
		JButton btnAlterarPaciente = new JButton("Alterar Paciente");
		btnAlterarPaciente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				alterarPaciente(textCodigoDigitadoPaciente.getText());
				panelAlterarPaciente.setVisible(false);
				panelAlterar.setVisible(true);
			}
		});
		btnAlterarPaciente.setBounds(248, 330, 129, 20);
		panelAlterarPaciente.add(btnAlterarPaciente);
	}
	
	public void alterarPaciente(String textCodigoDigitadoPaciente) {
		
		try {
			Paciente paciente = sistema.getPaciente(Integer.parseInt(textCodigoDigitadoPaciente));
			
			if(textAlterarNomePaciente.getText().equalsIgnoreCase("") == false && paciente.getNome().equalsIgnoreCase(textAlterarNomePaciente.getText()) == false)
				paciente.setNome(textAlterarNomePaciente.getText());
			if(textAlterarIdadePaciente.getText().equalsIgnoreCase("") == false && paciente.getIdade() != Integer.parseInt(textAlterarIdadePaciente.getText()))
				paciente.setIdade(Integer.parseInt(textAlterarIdadePaciente.getText()));		
			if(textAlterarCpfPaciente.getText().equalsIgnoreCase("") == false && paciente.getCpf() != Long.parseLong(textAlterarCpfPaciente.getText()))
				paciente.setCpf(Long.parseLong(textAlterarCpfPaciente.getText()));
			if(textAlterarCidadePaciente.getText().equalsIgnoreCase("") == false &&paciente.getCidade().equalsIgnoreCase(textAlterarCidadePaciente.getText()) == false)
				paciente.setCidade(textAlterarCidadePaciente.getText());
			if(textAlterarDescricaoPaciente.getText().equalsIgnoreCase("") == false &&paciente.getDescricao().equalsIgnoreCase(textAlterarDescricaoPaciente.getText()) == false)
				paciente.setDescricao(textAlterarDescricaoPaciente.getText());
		
			sistema.alterarPaciente(paciente);
			limparAlterarPaciente();
			JOptionPane.showMessageDialog(null, "Paciente alterado!");
		} catch (ClassNotFoundException e1) {
			System.err.println(e1.getMessage());
			System.err.println("Erro, paciente nao encontrado!");
			JOptionPane.showMessageDialog(null, "Erro, paciente nao encontrado!");
		} catch (UpdateException e2) {
			System.err.println(e2.getMessage());
			System.err.println("Erro ao atualizar paciente!");
			JOptionPane.showMessageDialog(null, "Erro ao atualizar paciente!");
		} catch (SQLException e3) {
			System.err.println(e3.getMessage());
			System.err.println("Erro ao acessar o banco de dados!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados!");
		} catch (NumberFormatException e4) {
			System.err.println(e4.getMessage());
			System.err.println("Erro no codigo do paciente informado ou no formato dos dados inseridos!");
			JOptionPane.showMessageDialog(null, "Erro no codigo do paciente informado ou no formato dos dados inseridos!");
		} catch (SelectException e5) {
			System.err.println(e5.getMessage());
			System.err.println("Erro ao acessar paciente!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar paciente!");
		}
	}
	
	public void criarPanelAlterarConsulta() {
		panelAlterarConsulta = new JPanel();
		panelAlterarConsulta.setLayout(null);
		panelAlterarConsulta.setVisible(false);
		layeredAlterar.add(panelAlterarConsulta, "name_185067551954800");
		
		JLabel lblMensagemAlterarConsulta = new JLabel();
		lblMensagemAlterarConsulta.setText("Preencha os campos que deseja alterar");
		lblMensagemAlterarConsulta.setBackground(SystemColor.menu);
		lblMensagemAlterarConsulta.setBounds(248, 24, 292, 20);
		panelAlterarConsulta.add(lblMensagemAlterarConsulta);	
		
		JLabel lblAlterarValorConsulta = new JLabel("Valor");
		lblAlterarValorConsulta.setToolTipText("");
		lblAlterarValorConsulta.setBounds(84, 68, 80, 22);
		panelAlterarConsulta.add(lblAlterarValorConsulta);
		
		textAlterarValorConsulta = new JTextField();
		textAlterarValorConsulta.setColumns(10);
		textAlterarValorConsulta.setBounds(248, 68, 374, 22);
		panelAlterarConsulta.add(textAlterarValorConsulta);
		
		JLabel lblAlterarDataConsulta = new JLabel("Data (aaaa-mm-dd)");
		lblAlterarDataConsulta.setBounds(84, 111, 121, 22);
		panelAlterarConsulta.add(lblAlterarDataConsulta);
		
		textAlterarDataConsulta = new JTextField();
		textAlterarDataConsulta.setColumns(10);
		textAlterarDataConsulta.setBounds(248, 112, 374, 22);
		panelAlterarConsulta.add(textAlterarDataConsulta);
		
		JLabel lblAlterarHorarioConsulta = new JLabel("Horario (xx:xx:xx)");
		lblAlterarHorarioConsulta.setBounds(84, 155, 121, 22);
		panelAlterarConsulta.add(lblAlterarHorarioConsulta);
		
		textAlterarHorarioConsulta = new JTextField();
		textAlterarHorarioConsulta.setColumns(10);
		textAlterarHorarioConsulta.setBounds(248, 156, 374, 22);
		panelAlterarConsulta.add(textAlterarHorarioConsulta);
		
		JLabel lblAlterarDiagnosticoConsulta = new JLabel("Diagnostico");
		lblAlterarDiagnosticoConsulta.setBounds(84, 199, 80, 22);
		panelAlterarConsulta.add(lblAlterarDiagnosticoConsulta);
		
		textAlterarDiagnosticoConsulta = new JTextField();
		textAlterarDiagnosticoConsulta.setColumns(10);
		textAlterarDiagnosticoConsulta.setBounds(248, 200, 374, 22);
		panelAlterarConsulta.add(textAlterarDiagnosticoConsulta);
		
		JLabel lblAlterarMedicoConsulta = new JLabel("Codigo do Medico");
		lblAlterarMedicoConsulta.setBounds(84, 243, 121, 22);
		panelAlterarConsulta.add(lblAlterarMedicoConsulta);
		
		textAlterarMedicoConsulta = new JTextField();
		textAlterarMedicoConsulta.setColumns(10);
		textAlterarMedicoConsulta.setBounds(248, 244, 374, 22);
		panelAlterarConsulta.add(textAlterarMedicoConsulta);
		
		JLabel lblAlterarPacienteConsulta = new JLabel("Codigo do Paciente");
		lblAlterarPacienteConsulta.setBounds(84, 287, 121, 22);
		panelAlterarConsulta.add(lblAlterarPacienteConsulta);
		
		textAlterarPacienteConsulta = new JTextField();
		textAlterarPacienteConsulta.setColumns(10);
		textAlterarPacienteConsulta.setBounds(248, 288, 374, 22);
		panelAlterarConsulta.add(textAlterarPacienteConsulta);
		
		JButton btnAlterarConsulta = new JButton("Alterar Consulta");
		btnAlterarConsulta.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				alterarConsulta(textCodigoDigitadoConsulta.getText());
				panelAlterarConsulta.setVisible(false);
				panelAlterar.setVisible(true);
			}
		});
		btnAlterarConsulta.setBounds(248, 332, 129, 22);
		panelAlterarConsulta.add(btnAlterarConsulta);
	}
	
	public void alterarConsulta(String textCogidoDigitadoConsulta) {
		
		try {
			Consulta consulta = sistema.getConsulta(Integer.parseInt(textCogidoDigitadoConsulta));
			
			if(textAlterarValorConsulta.getText().equalsIgnoreCase("") == false && consulta.getValor() != Double.parseDouble(textAlterarValorConsulta.getText()))
				consulta.setValor(Double.parseDouble(textAlterarValorConsulta.getText()));
			if(textAlterarDataConsulta.getText().equalsIgnoreCase("") == false && consulta.getData() != Date.valueOf(textAlterarDataConsulta.getText()))
				consulta.setData(Date.valueOf(textAlterarDataConsulta.getText()));
			if(textAlterarHorarioConsulta.getText().equalsIgnoreCase("") == false && consulta.getHorario() != Time.valueOf(textAlterarHorarioConsulta.getText()))
				consulta.setHorario(Time.valueOf(textAlterarHorarioConsulta.getText()));
			if(textAlterarDiagnosticoConsulta.getText().equalsIgnoreCase("") == false && consulta.getDiagnostico().equalsIgnoreCase(textAlterarDiagnosticoConsulta.getText()) == false)
				consulta.setDiagnostico(textAlterarDiagnosticoConsulta.getText());
			if(textAlterarMedicoConsulta.getText().equalsIgnoreCase("") == false && consulta.getMedico().getCodigo() != Integer.parseInt(textAlterarMedicoConsulta.getText()))
				consulta.setMedico(sistema.getMedico(Integer.parseInt(textAlterarMedicoConsulta.getText())));
			if(textAlterarPacienteConsulta.getText().equalsIgnoreCase("") == false && consulta.getPaciente().getCodigo() != Integer.parseInt(textAlterarPacienteConsulta.getText()))
				consulta.setPaciente(sistema.getPaciente(Integer.parseInt(textAlterarPacienteConsulta.getText())));
			
			sistema.alterarConsulta(consulta);
			limparAlterarConsulta();
			JOptionPane.showMessageDialog(null, "Consulta alterada!");
		} catch (ClassNotFoundException e1) {
			System.err.println(e1.getMessage());
			System.err.println("Erro, consulta nao encontrada!");
			JOptionPane.showMessageDialog(null, "Erro, consulta nao encontrada!");
		} catch (UpdateException e2) {
			System.err.println(e2.getMessage());
			System.err.println("Erro ao atualizar consulta!");
			JOptionPane.showMessageDialog(null, "Erro ao atualizar consulta!");
		} catch (SQLException e3) {
			System.err.println(e3.getMessage());
			System.err.println("Erro ao acessar o banco de dados!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados!");
		} catch (NumberFormatException e4) {
			System.err.println(e4.getMessage());
			System.err.println("Erro nos codigo informados ou no formato dos dados inseridos!");
			JOptionPane.showMessageDialog(null, "Erro nos codigo informados ou no formato dos dados inseridos!");
		} catch (SelectException e5) {
			System.err.println(e5.getMessage());
			System.err.println("Erro ao acessar consulta!");
			JOptionPane.showMessageDialog(null, "Erro ao acessar consulta!");
		}
	}
	
	public void limpaTabela(JTable table) {
		DefaultTableModel limpa = (DefaultTableModel) table.getModel();
		while (limpa.getRowCount() > 0) {
			limpa.removeRow(0);
	    }
	}
	
	public void limparCadastrarMedico() {
		textNomeMedico.setText("");
		textIdadeMedico.setText("");
		textCpfMedico.setText("");
		textCidadeMedico.setText("");
		textEspecialidade.setText("");
	}
	
	public void limparCadastrarPaciente() {
		textNomePaciente.setText("");
		textIdadePaciente.setText("");
		textCpfPaciente.setText("");
		textCidadePaciente.setText("");
		textDescricao.setText("");
	}
	
	public void limparCadastrarConsulta() {
		textValor.setText("");
		textData.setText("");
		textHorario.setText("");
		textDiagnostico.setText("");
		textMedico.setText("");
		textPaciente.setText("");
	}
	
	public void limparDeletarMedico() {
		textDeletarMedico.setText("");
	}
	
	public void limparDeletarPaciente() {
		textDeletarPaciente.setText("");
	}
	
	public void limparDeletarConsulta() {
		textDeletarConsulta.setText("");
	}
	
	public void limparAlterarMedico() {
		textCodigoDigitadoMedico.setText("");
		textAlterarNomeMedico.setText("");
		textAlterarIdadeMedico.setText("");
		textAlterarCpfMedico.setText("");
		textAlterarCidadeMedico.setText("");
		textAlterarEspecialidadeMedico.setText("");
	}
	
	public void limparAlterarPaciente() {
		textCodigoDigitadoPaciente.setText("");
		textAlterarNomePaciente.setText("");
		textAlterarIdadePaciente.setText("");
		textAlterarCpfPaciente.setText("");
		textAlterarCidadePaciente.setText("");
		textAlterarDescricaoPaciente.setText("");
	}
	
	public void limparAlterarConsulta() {
		textCodigoDigitadoConsulta.setText("");
		textAlterarValorConsulta.setText("");
		textAlterarDataConsulta.setText("");
		textAlterarHorarioConsulta.setText("");
		textAlterarDiagnosticoConsulta.setText("");
		textAlterarMedicoConsulta.setText("");
		textAlterarPacienteConsulta.setText("");            	
	}
}
