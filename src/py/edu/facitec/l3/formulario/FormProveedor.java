package py.edu.facitec.l3.formulario;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import py.edu.facitec.l3.dao.ProveedorDao;
import py.edu.facitec.l3.model.Proveedor;
import py.edu.facitec.l3.util.ConexionManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class FormProveedor extends JDialog {
	CallableStatement cst;
	private JTextField pcodigo;
	private JTextField pnombrecompania;
	private JTextField pnombrecontacto;
	private JTextField pdireccion;
	private JTextField ptelefono;
	private JTextField pcelular;
	private JTextField pemail;
	private JTextField pruc;
	private JComboBox pciudad;
	private JComboBox pcargo;
	private JComboBox ppais;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JPanel panel_1;
	private JTable table;
	private JButton btnBuscar;
	private JButton btnNuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProveedor dialog = new FormProveedor();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public FormProveedor() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Formulario Proveedor");
		setBounds(100, 100, 961, 586);
		getContentPane().setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(10, 11, 745, 343);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setForeground(Color.BLACK);
		lblCodigo.setBounds(10, 11, 62, 21);
		panel_1.add(lblCodigo);
		lblCodigo.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		
		pcodigo = new JTextField();
		pcodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					eliminarModifi();
					abilitarN_B();
					abilitarCampoTextoTodo();
				}
				
			}
		});
		pcodigo.setBounds(73, 11, 86, 20);
		panel_1.add(pcodigo);
		pcodigo.setColumns(10);
		
		JLabel lblNombreCompaia = new JLabel("Nombre Compa\u00F1ia:");
		lblNombreCompaia.setForeground(Color.BLACK);
		lblNombreCompaia.setBounds(10, 63, 164, 21);
		panel_1.add(lblNombreCompaia);
		lblNombreCompaia.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		
		pnombrecompania = new JTextField();
		pnombrecompania.setBounds(165, 64, 199, 20);
		panel_1.add(pnombrecompania);
		pnombrecompania.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char car=evt.getKeyChar();
			       if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')) evt.consume();
			}
		});
		pnombrecompania.setColumns(10);
		
		JLabel lblNombreContacto = new JLabel("Nombre Contacto:");
		lblNombreContacto.setForeground(Color.BLACK);
		lblNombreContacto.setBounds(10, 115, 149, 21);
		panel_1.add(lblNombreContacto);
		lblNombreContacto.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setForeground(Color.BLACK);
		lblDireccion.setBounds(10, 167, 86, 21);
		panel_1.add(lblDireccion);
		lblDireccion.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setForeground(Color.BLACK);
		lblCiudad.setBounds(10, 219, 71, 21);
		panel_1.add(lblCiudad);
		lblCiudad.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setForeground(Color.BLACK);
		lblTelefono.setBounds(10, 271, 86, 21);
		panel_1.add(lblTelefono);
		lblTelefono.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setForeground(Color.BLACK);
		lblCelular.setBounds(381, 11, 62, 21);
		panel_1.add(lblCelular);
		lblCelular.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setBounds(381, 63, 62, 21);
		panel_1.add(lblEmail);
		lblEmail.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		
		JLabel lblRucOCi = new JLabel("RUC o CI:");
		lblRucOCi.setForeground(Color.BLACK);
		lblRucOCi.setBounds(381, 115, 86, 21);
		panel_1.add(lblRucOCi);
		lblRucOCi.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setForeground(Color.BLACK);
		lblCargo.setBounds(381, 167, 62, 21);
		panel_1.add(lblCargo);
		lblCargo.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		
		JLabel lblPais = new JLabel("Pais:");
		lblPais.setForeground(Color.BLACK);
		lblPais.setBounds(381, 219, 48, 21);
		panel_1.add(lblPais);
		lblPais.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		
		pnombrecontacto = new JTextField();
		pnombrecontacto.setBounds(165, 116, 199, 20);
		panel_1.add(pnombrecontacto);
		pnombrecontacto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char car=evt.getKeyChar();
			       if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')) evt.consume();
			}
		});
		pnombrecontacto.setColumns(10);
		
		pdireccion = new JTextField();
		pdireccion.setBounds(106, 168, 258, 20);
		panel_1.add(pdireccion);
		pdireccion.setColumns(10);
		
		pciudad = new JComboBox();
		pciudad.setForeground(Color.BLACK);
		pciudad.setBounds(91, 219, 110, 20);
		panel_1.add(pciudad);
		pciudad.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		pciudad.setModel(new DefaultComboBoxModel(new String[] {"Curuguaty", "Salto del Guaira", "Villa Ygatimi"}));
		
		ptelefono = new JTextField();
		ptelefono.setBounds(91, 272, 110, 20);
		panel_1.add(ptelefono);
		ptelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				 char car=evt.getKeyChar();
		           if(  ptelefono.getText().length()>=8)evt.consume();
		       if((car<'0' || car>'9') ) evt.consume();
			}
		});
		ptelefono.setColumns(10);
		
		pcelular = new JTextField();
		pcelular.setBounds(459, 12, 110, 20);
		panel_1.add(pcelular);
		pcelular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				 char car=evt.getKeyChar();
		           if(  pcelular.getText().length()>=8)evt.consume();
		       if((car<'0' || car>'9') ) evt.consume();
			}
		});
		pcelular.setColumns(10);
		
		pemail = new JTextField();
		pemail.setBounds(459, 64, 276, 20);
		panel_1.add(pemail);
		pemail.setColumns(10);
		
		pruc = new JTextField();
		pruc.setBounds(469, 116, 103, 20);
		panel_1.add(pruc);
		pruc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				 char car=evt.getKeyChar();
		           if(  pruc.getText().length()>=8)evt.consume();
		       if((car<'0' || car>'9') ) evt.consume();
			}
		});
		pruc.setColumns(10);
		
		pcargo = new JComboBox();
		pcargo.setForeground(Color.BLACK);
		pcargo.setBounds(462, 168, 110, 20);
		panel_1.add(pcargo);
		pcargo.setModel(new DefaultComboBoxModel(new String[] {"Gerente", "Jefe", "Empleado"}));
		pcargo.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		
		ppais = new JComboBox();
		ppais.setForeground(Color.BLACK);
		ppais.setBounds(462, 220, 110, 20);
		panel_1.add(ppais);
		ppais.setModel(new DefaultComboBoxModel(new String[] {"Paraguay", "Brasil", "Bolivia", "Argentina", "Uruguay"}));
		ppais.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(765, 11, 170, 343);
		getContentPane().add(panel);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 guardarProveedor();
			
			 abilitarN_B();
			 desabilitarG();
			}
		});
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obtenerUltimoId();
				abilitarBG();
				abilitarCampoTextoTodo();
				desabilitatTres();
				desabilitarBN();
			}
		});
		btnNuevo.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		panel.add(btnNuevo);
		btnGuardar.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		panel.add(btnGuardar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.setForeground(Color.BLACK);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarProveedor();
				limpiarProveedor();
			}
		});
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				desabilitarBus();
				desabilitarCampoTexto();
				
			}
		});
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		panel.add(btnBuscar);
		btnModificar.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		panel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		panel.add(btnEliminar);
		
		JButton btnCanselar = new JButton("Canselar");
		btnCanselar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abilitarN_B();
			    limpiarProveedor();
			    desabilitarG();
			}
		});
		btnCanselar.setForeground(Color.BLACK);
		btnCanselar.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		panel.add(btnCanselar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnCerrar.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		panel.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 365, 925, 171);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("TimesHeavy", Font.PLAIN, 10));
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre Compa\u00F1ia", "Nombre Contacto", "Direccion", "Ciudad", "Telefono", "Celular", "Email", "RUC o CI", "Cargo", "Pais"
			}
		));
		scrollPane.setViewportView(table);
		
		
	

		desabilitarCampoTextoTodo();
		

	}
	private void guardarProveedor() {
		Proveedor proveedor=new Proveedor();
		proveedor.setCodigo(Integer.parseInt(pcodigo.getText()));
		proveedor.setNombreCompañia(pnombrecompania.getText());
		proveedor.setNombreContacto(pnombrecontacto.getText());
		proveedor.setDireccion(pdireccion.getText());
		proveedor.setCiudad(pciudad.getSelectedIndex());
		proveedor.setTelefono(Integer.parseInt(ptelefono.getText()));
		proveedor.setCelular(Integer.parseInt(pcelular.getText()));
		proveedor.setEmail(pemail.getText());
		proveedor.setRuc_o_cedula(Integer.parseInt(pruc.getText()));
		proveedor.setCargo(pcargo.getSelectedIndex());
		proveedor.setPais(ppais.getSelectedIndex());

		
		ProveedorDao.registrarProveedor(proveedor);
		limpiarProveedor();
	}
	
	
	private void modificarProveedor() {
		
				Proveedor proveedor=new Proveedor();
				proveedor.setCodigo(Integer.parseInt(pcodigo.getText()));
				proveedor.setNombreCompañia(pnombrecompania.getText());
				proveedor.setNombreContacto(pnombrecontacto.getText());
				proveedor.setDireccion(pdireccion.getText());
				proveedor.setCiudad(pciudad.getSelectedIndex());
				proveedor.setTelefono(Integer.parseInt(ptelefono.getText()));
				proveedor.setCelular(Integer.parseInt(pcelular.getText()));
				proveedor.setEmail(pemail.getText());
				proveedor.setRuc_o_cedula(Integer.parseInt(pruc.getText()));
				proveedor.setCargo(pcargo.getSelectedIndex());
				proveedor.setPais(ppais.getSelectedIndex());
				
				ProveedorDao.modificarProveedor(proveedor);
			
	}
	private void obtenerUltimoId() {
		Proveedor proveedor=ProveedorDao.obtenerUltimoId();
		pcodigo.setText(proveedor.getCodigoo());
		limpiarProveedor();
	

	}
	private void limpiarProveedor() {
		pnombrecompania.setText("");
		pnombrecontacto.setText("");
		pdireccion.setText("");
		ptelefono.setText("");
		pcelular.setText("");
		pemail.setText("");
		pruc.setText("");
	
		}

	 private void eliminarModifi() {
		this.btnModificar.setEnabled(true);
		this.btnEliminar.setEnabled(true);

	}
	 private void desabilitarBN() {
		this.btnNuevo.setEnabled(false);
		this.btnBuscar.setEnabled(false);
		this.btnModificar.setEnabled(false);
		this.btnEliminar.setEnabled(false);
	}
	 private void abilitarBG() {
		this.btnGuardar.setEnabled(true);

	}
	 private void abilitarN_B() {
		this.btnNuevo.setEnabled(true);
		this.btnBuscar.setEnabled(true);

	}
	 private void desabilitarBus() {
		 this.btnNuevo.setEnabled(false);
		 this.btnGuardar.setEnabled(false);
			this.btnBuscar.setEnabled(false);
			this.btnModificar.setEnabled(false);
			this.btnEliminar.setEnabled(false);
	}
	

	
	 private void desabilitatTres() {
		this.btnModificar.setEnabled(false);
		this.btnEliminar.setEnabled(false);

	}
	 private void desabilitarCampoTexto() {
		this.pcodigo.setEnabled(true);
		this.pnombrecompania.setEnabled(false);
		this.pnombrecontacto.setEnabled(false);
		this.pdireccion.setEnabled(false);
		this.pciudad.setEnabled(false);
		this.ptelefono.setEnabled(false);
		this.pcelular.setEnabled(false);
		this.pemail.setEnabled(false);
		this.pcargo.setEnabled(false);
		this.ppais.setEnabled(false);

	}
	 private void desabilitarCampoTextoTodo() {
			this.pcodigo.setEnabled(false);
			this.pnombrecompania.setEnabled(false);
			this.pnombrecontacto.setEnabled(false);
			this.pdireccion.setEnabled(false);
			this.pciudad.setEnabled(false);
			this.ptelefono.setEnabled(false);
			this.pcelular.setEnabled(false);
			this.pemail.setEnabled(false);
			this.pcargo.setEnabled(false);
			this.ppais.setEnabled(false);
			this.pruc.setEnabled(false);

		}
	 private void abilitarCampoTextoTodo() {
			this.pcodigo.setEnabled(false);
			this.pnombrecompania.setEnabled(true);
			this.pnombrecontacto.setEnabled(true);
			this.pdireccion.setEnabled(true);
			this.pciudad.setEnabled(true);
			this.ptelefono.setEnabled(true);
			this.pcelular.setEnabled(true);
			this.pemail.setEnabled(true);
			this.pcargo.setEnabled(true);
			this.ppais.setEnabled(true);
			this.pruc.setEnabled(true);

		}
	 private void desabilitarG() {
		this.btnGuardar.setEnabled(false);
	}
	 
	}

	
