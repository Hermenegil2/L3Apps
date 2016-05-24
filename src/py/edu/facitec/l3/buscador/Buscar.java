package py.edu.facitec.l3.buscador;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import py.edu.facitec.l3.dao.ProveedorDao;
import py.edu.facitec.l3.model.Proveedor;

public class Buscar extends JDialog {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar dialog = new Buscar();
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
	public Buscar() {
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNombreCompaia = new JLabel("Nombre Compa\u00F1ia:");
		lblNombreCompaia.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		lblNombreCompaia.setBounds(10, 11, 158, 26);
		getContentPane().add(lblNombreCompaia);
		
		JLabel lblPorId = new JLabel("Por ID");
		lblPorId.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		lblPorId.setBounds(10, 48, 158, 26);
		getContentPane().add(lblPorId);
		
		JLabel lblRucOCi = new JLabel("RUC o CI:");
		lblRucOCi.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		lblRucOCi.setBounds(10, 99, 158, 26);
		getContentPane().add(lblRucOCi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 123, 764, 427);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre Compa\u00F1ias", "Nombre Contacto", "Direccion", "Ciudad", "Telefono", "Celular", "Email", "RUC o CI", "Cargo", "Pais"
			}
		));
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(172, 15, 253, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(172, 52, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(172, 103, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnBuscarProveedor = new JButton("Buscar Proveedor");
		btnBuscarProveedor.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		btnBuscarProveedor.setBounds(473, 14, 181, 23);
		getContentPane().add(btnBuscarProveedor);
		listaProveedor();

	}
	
	private void listaProveedor() {
		DefaultTableModel modelo=(DefaultTableModel) table.getModel();
		ArrayList<Proveedor>lista=ProveedorDao.listarProveedor();
		 Object[] fila=new Object[modelo.getColumnCount()];
		    for (int i = 0; i < lista.size(); i++) {
		    	fila[0]=lista.get(i).getCodigo();
		    	fila[1]=lista.get(i).getNombreCompañia();
		    	fila[2]=lista.get(i).getNombreContacto();
		    	fila[3]=lista.get(i).getDireccion();
		    	fila[4]=lista.get(i).getCiudad();
		    	fila[5]=lista.get(i).getTelefono();
		    	fila[6]=lista.get(i).getCelular();
		    	fila[7]=lista.get(i).getEmail();
		    	fila[8]=lista.get(i).getRuc_o_cedula();
		    	fila[9]=lista.get(i).getCargo();
		    	fila[10]=lista.get(i).getPais();
		    	modelo.addRow(fila);

		    }
		    
	}
	
}
