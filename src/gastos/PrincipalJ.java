package gastos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JScrollBar;
import java.awt.Choice;

public class PrincipalJ extends JFrame {

	
	private JPanel contentPane;
	
	JTextPane textLista ;
	JTextPane textMonto ;
	JTextPane textFecha ;
	JCheckBox Categoria1 ;
	JCheckBox Categoria2 ;
	JCheckBox Categoria3 ;
	JCheckBox Categoria4 ;
	JTextPane textDescripcion ; 
	JTextPane textListaTotal ;
	
	int categoriaE = 0;
	int categoriaA = 0;
	int categoriaT = 0;
	int categoriaO = 0;
	int result = 0 ;

	
	HashMap<String, String > Fecha = new HashMap<String, String>();
	HashMap<String, String > Monto = new HashMap<String, String>();
	HashMap<String, String > Descripcion = new HashMap<String, String>();
	HashMap<String, Boolean> CategoriAlimentacion = new HashMap<String, Boolean>();
	HashMap<String, Boolean> CategoriEntretenimiento = new HashMap<String, Boolean>();
	HashMap<String, Boolean> CategoriTransporte = new HashMap<String, Boolean>();
	HashMap<String, Boolean> CategoriOtros = new HashMap<String, Boolean>();


	
	public PrincipalJ() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 460);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar ");
		btnAgregar.setBackground(new Color(153, 180, 209));
		btnAgregar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnAgregar) {
					agregarGastos();
				}
			}
 
			private void agregarGastos() {
				String key = Categoria2.getText();
		        String key2 = Categoria1.getText();
		        String key3 = Categoria3.getText();
		        String key4 = Categoria4.getText(); 
		        
				Boolean value = Categoria2.isSelected();
				Boolean value2 = Categoria1.isSelected();
				Boolean value3 = Categoria3.isSelected();
				Boolean value4 = Categoria4.isSelected();
				
		
				Fecha.put("fecha", textFecha.getText());
				Monto.put("Monto", textMonto.getText());
				Descripcion.put("Descripcion", textDescripcion.getText());
				CategoriEntretenimiento.put(key2, value2);
				CategoriAlimentacion.put(key, value);
				CategoriTransporte.put(key3, value3);
				CategoriOtros.put(key4, value4);
				
	
				JOptionPane.showMessageDialog(null, "Se agrego el gasto de manera exitosa");
				
				 for (String i : Fecha.keySet()){
					 for (String M : Monto.keySet()) {
						 for (String D : Descripcion.keySet()) { 
							 textLista.setText ("Fecha: "+  Fecha.get(i) + "\n" + "Monto: $ " + Monto.get(M) +"\n" + "categorias: "+"\n"+ "Entretenimiento: " + CategoriEntretenimiento.get(key2) + "\n"+ "Alimentacion: " + CategoriAlimentacion.get(key) + "\n"+ "Transporte: " + CategoriTransporte.get(key3) + "\n"+ "Otros: " + CategoriOtros.get(key4) + "\n" + "Descripcion: " + Descripcion.get(D));
						 }
					 }  
					    }
			
			
				 if (Categoria1.isSelected()) {	 
					 categoriaE += Integer.parseInt(Monto.get("Monto"));
				 }
				 if (Categoria2.isSelected()) {
					 categoriaA += Integer.parseInt(Monto.get("Monto"));
					
				 }
				 if (Categoria3.isSelected()) {
					 categoriaT += Integer.parseInt(Monto.get("Monto"));
					
				 }
				 if (Categoria4.isSelected()) {
					 categoriaO += Integer.parseInt(Monto.get("Monto"));
					
				 }
				 
				 result =(categoriaE + categoriaA + categoriaT + categoriaO);
				 
				 textListaTotal.setText ("Entretenimiento: $"+ categoriaE + "\n"+ "Alimentacion: $"+ categoriaA + "\n" + "Transporte: $"+ categoriaT + "\n" + "Otros: $" + categoriaO + "\n"+ "\n"+ "Gasto total: $" + result);
				
			 }	
			
		});
		
		
		
		btnAgregar.setBounds(119, 381, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar ");
		btnEliminar.setBackground(SystemColor.activeCaption);
		btnEliminar.setBounds(20, 381, 89, 23);
		contentPane.add(btnEliminar);
		
		btnEliminar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnEliminar) {
					eliminarGastos();
				
			}
		}
			private void eliminarGastos() {
				textLista.setText("");
				textListaTotal.setText("");
				Fecha.clear();
				Monto.clear();
				Descripcion.clear();
				CategoriAlimentacion.clear();
				CategoriEntretenimiento.clear();
				CategoriTransporte.clear();
				CategoriOtros.clear();
				
				
			}
		});
		
		textFecha = new JTextPane();
		textFecha.setToolTipText("");
		textFecha.setBackground(SystemColor.inactiveCaption);
		textFecha.setBounds(48, 59, 117, 23);
		contentPane.add(textFecha);
		
		JLabel fechaN = new JLabel("Fecha ");
		fechaN.setBounds(83, 42, 46, 14);
		contentPane.add(fechaN);
		
		JLabel lblRegistraTusGastos = new JLabel("REGISTRA TUS GASTOS DIARIOS");
		lblRegistraTusGastos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegistraTusGastos.setForeground(SystemColor.activeCaption);
		lblRegistraTusGastos.setBackground(new Color(255, 0, 0));
		lblRegistraTusGastos.setBounds(20, 11, 356, 23);
		contentPane.add(lblRegistraTusGastos);
		
		JLabel lblNewLabel = new JLabel("Categor\u00EDa de gastos");
		lblNewLabel.setBounds(48, 86, 130, 14);
		contentPane.add(lblNewLabel);
		
		textDescripcion = new JTextPane();
		textDescripcion.setBackground(SystemColor.inactiveCaption);
		textDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textDescripcion.setBounds(28, 232, 150, 138);
		contentPane.add(textDescripcion);
		
		JLabel ibDescripcion = new JLabel("Descripcion");
		ibDescripcion.setBounds(68, 217, 81, 14);
		contentPane.add(ibDescripcion);
		
		textMonto = new JTextPane();
		textMonto.setToolTipText("int");
		textMonto.setBackground(SystemColor.inactiveCaption);
		textMonto.setContentType("number");
		textMonto.setBounds(197, 59, 97, 23);
		contentPane.add(textMonto);
		
		JLabel lblNewLabel_1 = new JLabel("Monto del gasto");
		lblNewLabel_1.setBounds(203, 42, 108, 14);
		contentPane.add(lblNewLabel_1);
		
		textLista = new JTextPane();
		textLista.setBackground(SystemColor.activeCaption);
		textLista.setEditable(false);
		textLista.setBounds(369, 42, 181, 181);
		contentPane.add(textLista);
		
		JLabel lista = new JLabel("Total");
		lista.setBounds(444, 244, 74, 14);
		contentPane.add(lista);
		
		Categoria1 = new JCheckBox("Entretenimiento");
		Categoria1.setBounds(41, 107, 125, 23);
		contentPane.add(Categoria1);
		
		Categoria2 = new JCheckBox("Alimentación");
		Categoria2.setBounds(41, 134, 125, 23);
		contentPane.add(Categoria2);
		
		Categoria3 = new JCheckBox("Transporte");
		Categoria3.setBounds(41, 160, 125, 23);
		contentPane.add(Categoria3);
		
		Categoria4 = new JCheckBox("Otros");
		Categoria4.setBounds(41, 187, 125, 23);
		contentPane.add(Categoria4);
		
		JLabel lblNewLabel_2 = new JLabel("$");
		lblNewLabel_2.setBounds(187, 62, 21, 20);
		contentPane.add(lblNewLabel_2);
		
		textListaTotal = new JTextPane();
		textListaTotal.setBackground(SystemColor.inactiveCaption);
		textListaTotal.setEditable(false);
		textListaTotal.setBounds(369, 259, 181, 145);
		contentPane.add(textListaTotal);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Gasto diario ingresado ");
		lblNewJgoodiesTitle.setBounds(411, 19, 139, 14);
		contentPane.add(lblNewJgoodiesTitle);
		

	}
}
