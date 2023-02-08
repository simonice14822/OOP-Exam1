import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtconvert;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setType(Type.POPUP);
		setTitle("โปรแกรม Baht to dollar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 629, 578);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(128, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("แปลงค่าเงินตรา");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(171, 34, 290, 96);
		panel.add(lblNewLabel);
		
		JComboBox jcmbcurrency = new JComboBox();
		jcmbcurrency.setModel(new DefaultComboBoxModel(new String[] {"choose.....", "USD", "JPY", "CNY"}));
		jcmbcurrency.setToolTipText("ห");
		jcmbcurrency.setFont(new Font("TH Sarabun New", Font.BOLD, 42));
		jcmbcurrency.setBounds(181, 146, 254, 46);
		panel.add(jcmbcurrency);
		
		JLabel jiblconvert = new JLabel("");
		jiblconvert.setBackground(Color.ORANGE);
		jiblconvert.setHorizontalAlignment(SwingConstants.CENTER);
		jiblconvert.setFont(new Font("TH Sarabun New", Font.BOLD | Font.ITALIC, 40));
		jiblconvert.setBounds(181, 290, 254, 80);
		panel.add(jiblconvert);
		
		txtconvert = new JTextField();
		txtconvert.setHorizontalAlignment(SwingConstants.CENTER);
		txtconvert.setFont(new Font("TH Sarabun New", Font.BOLD, 40));
		txtconvert.setBounds(181, 203, 254, 54);
		panel.add(txtconvert);
		txtconvert.setColumns(10);
		
		
		JButton jbtnreset = new JButton("Reset");
		jbtnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtconvert.setText(null);
				jiblconvert.setText(null);
				jcmbcurrency.setSelectedIndex(0);

			}
		});
		
		
		jbtnreset.setFont(new Font("Tahoma", Font.BOLD, 30));
		jbtnreset.setBounds(233, 459, 157, 54);
		panel.add(jbtnreset);
		
		JButton jbtnconvert = new JButton("Convert");
		jbtnconvert.setFont(new Font("Tahoma", Font.BOLD, 30));
		jbtnconvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double USD_d = 33.50;
				double JPY_d = 0.26;
				double CNY_d = 4.94;
				
				double baht = Double.parseDouble(txtconvert.getText());
				
				if (jcmbcurrency.getSelectedItem().equals("USD"))
				{
					
					String Cconvert = String.format("฿ %.2f ", baht * USD_d);
					jiblconvert.setText(Cconvert);	
				}
				if (jcmbcurrency.getSelectedItem().equals("JPY"))
				{
					
					String Cconvert = String.format("฿ %.2f ", baht * JPY_d);
					jiblconvert.setText(Cconvert);	
				}
				if (jcmbcurrency.getSelectedItem().equals("CNY"))
				{
					
					String Cconvert = String.format("฿ %.2f ", baht * CNY_d);
					jiblconvert.setText(Cconvert);	
				}
			}
		});
		jbtnconvert.setBounds(233, 381, 157, 54);
		panel.add(jbtnconvert);
	}
}
