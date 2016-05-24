package py.edu.facitec.l3.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import py.edu.facitec.l3.dao.ArticuloDao;
import py.edu.facitec.l3.dao.CompraDao;
import py.edu.facitec.l3.dao.FuncionarioDao;
import py.edu.facitec.l3.model.Articulos;
import py.edu.facitec.l3.model.Funcionario;
import py.edu.facitec.l3.model.Proveedor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Compras extends JFrame {
	 Connection cn=null;
	   CallableStatement cts=null;
	private JPanel contentPane;
	private JTextField idfun;
	private JTextField nombrefun;
	private JTextField apellidofun;
	private JTextField idpro;
	private JTextField nombrepro;
	private JTextField direccionpro;
	private JTextField idart;
	private JTextField descripcionart;
	private JTextField preciocompraart;
	private JTextField stockart;
	private JTextField cantidadart;
	private JTextField totalart;
	private JTable table;
	private JTextField textField_12;
	private JTextField fecha;
	private JTextField hora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compras frame = new Compras();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	    
	/**
	 * Create the frame.
	 */
	public Compras() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 586);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		lblNombres.setBounds(86, 109, 77, 14);
		contentPane.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		lblApellidos.setBounds(301, 109, 77, 14);
		contentPane.add(lblApellidos);
		
		nombrefun = new JTextField();
		nombrefun.setFont(new Font("Tahoma", Font.BOLD, 12));
		nombrefun.setEditable(false);
		nombrefun.setBounds(86, 130, 189, 20);
		contentPane.add(nombrefun);
		nombrefun.setColumns(10);
		
		apellidofun = new JTextField();
		apellidofun.setFont(new Font("Tahoma", Font.BOLD, 12));
		apellidofun.setEditable(false);
		apellidofun.setColumns(10);
		apellidofun.setBounds(301, 130, 189, 20);
		contentPane.add(apellidofun);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 66, 503, 110);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDatosFuncionarios = new JLabel("Datos Funcionarios");
		lblDatosFuncionarios.setBounds(155, 11, 174, 14);
		panel.add(lblDatosFuncionarios);
		lblDatosFuncionarios.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 43, 46, 14);
		panel.add(lblId);
		lblId.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		
		idfun = new JTextField();
		idfun.setFont(new Font("Tahoma", Font.BOLD, 12));
		idfun.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					recuperarFuncionarioPorCodigo();
				}
			}
		});
		idfun.setBounds(10, 64, 46, 20);
		panel.add(idfun);
		idfun.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(533, 66, 503, 110);
		contentPane.add(panel_1);
		
		JLabel lblDatosProveedor = new JLabel("Datos Proveedor");
		lblDatosProveedor.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		lblDatosProveedor.setBounds(155, 11, 174, 14);
		panel_1.add(lblDatosProveedor);
		
		JLabel label_1 = new JLabel("ID");
		label_1.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		label_1.setBounds(10, 43, 46, 14);
		panel_1.add(label_1);
		
		idpro = new JTextField();
		idpro.setFont(new Font("Tahoma", Font.BOLD, 12));
		idpro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					recuperarProveedorPorCodigo();
					
				}
			}
		});
		idpro.setColumns(10);
		idpro.setBounds(10, 64, 46, 20);
		panel_1.add(idpro);
		
		nombrepro = new JTextField();
		nombrepro.setEditable(false);
		nombrepro.setFont(new Font("Tahoma", Font.BOLD, 12));
		nombrepro.setColumns(10);
		nombrepro.setBounds(78, 64, 189, 20);
		panel_1.add(nombrepro);
		
		JLabel lblNombreCompaia = new JLabel("Nombre Compa\u00F1ia");
		lblNombreCompaia.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		lblNombreCompaia.setBounds(78, 43, 158, 14);
		panel_1.add(lblNombreCompaia);
		
		direccionpro = new JTextField();
		direccionpro.setEditable(false);
		direccionpro.setFont(new Font("Tahoma", Font.BOLD, 12));
		direccionpro.setColumns(10);
		direccionpro.setBounds(290, 64, 189, 20);
		panel_1.add(direccionpro);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		lblDireccion.setBounds(290, 43, 77, 14);
		panel_1.add(lblDireccion);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.CYAN);
		panel_2.setBounds(10, 187, 740, 95);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("ID");
		label.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		label.setBounds(10, 43, 46, 14);
		panel_2.add(label);
		
		idart = new JTextField();
		idart.setFont(new Font("Tahoma", Font.BOLD, 12));
		idart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					recuperarArticulosPorCodigo();
				}
			}
		});
		idart.setColumns(10);
		idart.setBounds(10, 64, 46, 20);
		panel_2.add(idart);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		lblDescripcion.setBounds(77, 43, 115, 14);
		panel_2.add(lblDescripcion);
		
		descripcionart = new JTextField();
		descripcionart.setEditable(false);
		descripcionart.setFont(new Font("Tahoma", Font.BOLD, 12));
		descripcionart.setColumns(10);
		descripcionart.setBounds(77, 64, 246, 20);
		panel_2.add(descripcionart);
		
		JLabel lblPrecioCompra = new JLabel("Precio Compra");
		lblPrecioCompra.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		lblPrecioCompra.setBounds(338, 43, 126, 14);
		panel_2.add(lblPrecioCompra);
		
		preciocompraart = new JTextField();
		preciocompraart.setEditable(false);
		preciocompraart.setFont(new Font("Tahoma", Font.BOLD, 12));
		preciocompraart.setColumns(10);
		preciocompraart.setBounds(338, 64, 143, 20);
		panel_2.add(preciocompraart);
		
		stockart = new JTextField();
		stockart.setEditable(false);
		stockart.setFont(new Font("Tahoma", Font.BOLD, 12));
		stockart.setColumns(10);
		stockart.setBounds(503, 64, 46, 20);
		panel_2.add(stockart);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		lblStock.setBounds(503, 43, 46, 14);
		panel_2.add(lblStock);
		
		cantidadart = new JTextField();
		cantidadart.setFont(new Font("Tahoma", Font.BOLD, 12));
		cantidadart.setColumns(10);
		cantidadart.setBounds(559, 64, 46, 20);
		panel_2.add(cantidadart);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		lblCantidad.setBounds(559, 43, 81, 14);
		panel_2.add(lblCantidad);
		
		totalart = new JTextField();
		totalart.setEditable(false);
		totalart.setFont(new Font("Tahoma", Font.BOLD, 12));
		totalart.setColumns(10);
		totalart.setBounds(647, 64, 83, 20);
		panel_2.add(totalart);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		lblTotal.setBounds(647, 43, 46, 14);
		panel_2.add(lblTotal);
		
		JLabel lblDatosArticulos = new JLabel("Datos Articulos");
		lblDatosArticulos.setBounds(10, 11, 149, 21);
		panel_2.add(lblDatosArticulos);
		lblDatosArticulos.setFont(new Font("TimesHeavy", Font.BOLD, 18));
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		btnNewButton.setBounds(904, 187, 132, 95);
		contentPane.add(btnNewButton);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarFormularioEnTabla();
				limpiar();
			}
		});
		btnAgregar.setBackground(Color.CYAN);
		btnAgregar.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		btnAgregar.setBounds(762, 187, 132, 95);
		contentPane.add(btnAgregar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 293, 1026, 138);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Articulo", "Precio Compra", "Cantidad", "Total"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(41);
		table.getColumnModel().getColumn(1).setPreferredWidth(163);
		scrollPane.setViewportView(table);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBackground(Color.CYAN);
		btnNuevo.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		btnNuevo.setBounds(359, 441, 132, 95);
		contentPane.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.CYAN);
		btnGuardar.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		btnGuardar.setBounds(501, 441, 132, 95);
		contentPane.add(btnGuardar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.CYAN);
		btnEliminar.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		btnEliminar.setBounds(645, 441, 132, 95);
		contentPane.add(btnEliminar);
		
		JButton btnTotalGeneral = new JButton("Total General");
		btnTotalGeneral.setBackground(Color.LIGHT_GRAY);
		btnTotalGeneral.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		btnTotalGeneral.setBounds(904, 441, 132, 95);
		contentPane.add(btnTotalGeneral);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(659, 32, 77, 20);
		contentPane.add(textField_12);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		lblNumero.setBounds(659, 11, 77, 14);
		contentPane.add(lblNumero);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		lblFecha.setBounds(779, 14, 46, 14);
		contentPane.add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		lblHora.setBounds(904, 14, 46, 14);
		contentPane.add(lblHora);
		
		JLabel lblFormularioDeCompra = new JLabel("Formulario de Compra");
		lblFormularioDeCompra.setFont(new Font("TimesHeavy", Font.BOLD, 30));
		lblFormularioDeCompra.setBounds(71, 1, 394, 54);
		contentPane.add(lblFormularioDeCompra);
		
		fecha = new JTextField();
		fecha.setFont(new Font("TimesHeavy", Font.BOLD, 12));
		fecha.setEditable(false);
		fecha.setBounds(770, 32, 86, 20);
		contentPane.add(fecha);
		fecha.setColumns(10);
		
		hora = new JTextField();
		hora.setEditable(false);
		hora.setFont(new Font("TimesHeavy", Font.BOLD, 12));
		hora.setBounds(904, 32, 61, 20);
		contentPane.add(hora);
		hora.setColumns(10);
		fecha_hora();
		
	}
	private void recuperarProveedorPorCodigo() {
		if(idpro.getText().isEmpty() || idpro.getText().equals("")){
			JOptionPane.showMessageDialog(this, "Debe digitar el Codigo del Proveedor","Aviso", 1);
			idpro.requestFocus();
		} else {
			int codigo=Integer.parseInt(idpro.getText());
			
			Proveedor c=CompraDao.buscarProveedorId(codigo);
			if (c !=null) {//si es distinto anulo
				nombrepro.setText(c.getNombreCompañia());
				direccionpro.setText(c.getDireccion());
				
				
			}else {
				JOptionPane.showMessageDialog(this,"No Existe Proveedor con ese codigo" );
				
			}
			
		}
			
		}
		private void recuperarFuncionarioPorCodigo() {
			if(idfun.getText().isEmpty() || idfun.getText().equals("")){
				JOptionPane.showMessageDialog(this, "Debe digitar el Codigo del Funcionario","Aviso", 1);
				idfun.requestFocus();
			} else {
				int codigo=Integer.parseInt(idfun.getText());
				
				Funcionario c=FuncionarioDao.buscarFuncionarioId(codigo);
				if (c !=null) {//si es distinto anulo
					nombrefun.setText(c.getNombre());
					apellidofun.setText(c.getApellido());
					
					
				}else {
					JOptionPane.showMessageDialog(this,"No Existe Funcionario con ese codigo" );
					
				}
				
			}
	}
		private void recuperarArticulosPorCodigo() {
			if(idart.getText().isEmpty() || idart.getText().equals("")){
				JOptionPane.showMessageDialog(this, "Debe digitar el Codigo del Articulos","Aviso", 1);
				idart.requestFocus();
			} else {
				int codigo=Integer.parseInt(idart.getText());
				
				Articulos c=ArticuloDao.buscarArticuloId(codigo);
				if (c !=null) {//si es distinto anulo
					descripcionart.setText(c.getDescripcion());
					preciocompraart.setText(Integer.toString(c.getPreciounitario()));
					stockart.setText(Integer.toString(c.getStock()));
					
					
				}else {
					JOptionPane.showMessageDialog(this,"No Existe Articulos con ese codigo" );
					
				}
				
			}
	}
		private void agregarFormularioEnTabla() {
			DefaultTableModel modelo=(DefaultTableModel) table.getModel();
			Object[] fila=new Object[5];
			fila[0]=idart.getText();
			fila[1]=descripcionart.getText();
			fila[2]=preciocompraart.getText();
			fila[3]=cantidadart.getText();
			fila[4]=totalart.getText();
			modelo.addRow(fila);
			table.setModel(modelo);

		
		}
		private void fecha_hora() {  
		 Calendar cal=Calendar.getInstance();
		 String fechaa=cal.get(Calendar.DATE)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(cal.YEAR);
		String horaa=cal.get(cal.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(cal.SECOND); 
		this.fecha.setText(fechaa); 
		this.hora.setText(horaa);
		}
		
		private void limpiar() {
			this.idart.setText("");
			this.descripcionart.setText("");
			this.preciocompraart.setText("");
			this.cantidadart.setText("");
			this.totalart.setText("");

		}
		
		
		
}
