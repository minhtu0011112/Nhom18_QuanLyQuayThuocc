package class_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.border.TitledBorder;

import class_DAO.NhaSanXuat_DAO;
import class_connectDB.ConnectDB;
import class_entity.HoaDon;
import class_entity.NhaSanXuat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class NhaSanXuat_ADD_GUI extends JFrame {

	private JPanel contentPane;
	private JButton btnThem, btnDong;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtSdt;
	private JTextField txtEmail;
	private JTextField txtFax;
	private static List<NhaSanXuat> lstNSX;
	private static NhaSanXuat_DAO qlNSX_dao;
	private static String maNSX, tenNSX, diaChi, sDT, fax, mail;
	int i=1;
	/**
	 * Create the frame.
	 */
	public NhaSanXuat_ADD_GUI() {
		ConnectDB.getInstance().connect();
		qlNSX_dao = new NhaSanXuat_DAO();

		setTitle("Thêm nhà sản xuất");
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 612, 460);
		setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(0, 0, 596, 60);
		horizontalBox.setBackground(Color.WHITE);
		contentPane.add(horizontalBox);

		JLabel lblAddNCC = new JLabel("  THÊM NHÀ SẢN XUẤT");
		lblAddNCC.setForeground(Color.BLUE);
		lblAddNCC.setFont(new Font("Tahoma", Font.BOLD, 14));
		horizontalBox.add(lblAddNCC);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);

//		JLabel label_9 = new JLabel("");
//		label_9.setIcon(new ImageIcon("data\\icons\\logo3.png"));
//		horizontalBox.add(label_9);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 71, 596, 349);
		contentPane.add(panel);
		panel.setLayout(null);

		btnThem = new JButton("Lưu");
		//btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setIcon(new ImageIcon("data\\icons\\save.png"));
		btnThem.setBackground(Color.WHITE);
		btnThem.setBounds(330, 301, 123, 39);
		panel.add(btnThem);
		btnThem.addActionListener(new ActionListener() { 

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(kiemTraDinhDang()) {	
					String ma= tuDongLayMa();
					String ten= txtTen.getText().trim();
					String so= txtSdt.getText().trim();
					String fax= txtFax.getText().trim();
					String email = txtEmail.getText().trim();
					
					try {
						if(!qlNSX_dao.themNSX(ma, ten, so, fax, email))
							throw new Exception();
						NhaSanXuat_GUI.updateDL();
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
						dispose();		
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Thêm không thành công!!");
					}
				}
			}
		});

		btnDong = new JButton("Bỏ qua");
		//btnDong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDong.setIcon(new ImageIcon("data\\icons\\exit1.png"));
		btnDong.setBackground(Color.WHITE);
		btnDong.setBounds(463, 301, 123, 39);
		panel.add(btnDong);
		btnDong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0110i\u1EC1n th\u00F4ng tin nh\u00E0 s\u1EA3n xu\u1EA5t", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 576, 279);
		panel.add(panel_1);

		JLabel lblMNsx = new JLabel("Mã NSX:");
		lblMNsx.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMNsx.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMNsx.setBounds(10, 24, 80, 17);
		panel_1.add(lblMNsx);

		txtMa = new JTextField();
		txtMa.setEditable(false);
		txtMa.setBackground(Color.WHITE);
		//txtMa.setEditable(false);
		txtMa.setColumns(10);
		txtMa.setBounds(100, 20, 444, 25);
		panel_1.add(txtMa);

		JLabel lblTnNsx = new JLabel("Tên NSX:");
		lblTnNsx.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnNsx.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTnNsx.setBounds(10, 74, 80, 17);
		panel_1.add(lblTnNsx);

		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(100, 70, 444, 25);
		panel_1.add(txtTen);

		JLabel label_3 = new JLabel("SDT:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(10, 124, 80, 17);
		panel_1.add(label_3);

		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBounds(100, 120, 444, 25);
		panel_1.add(txtSdt);

		JLabel lblMail = new JLabel("Email:");
		lblMail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMail.setBounds(10, 174, 80, 17);
		panel_1.add(lblMail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(100, 170, 444, 25);
		panel_1.add(txtEmail);

		JLabel label_8 = new JLabel("Fax:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_8.setBounds(10, 224, 80, 17);
		panel_1.add(label_8);

		txtFax = new JTextField();
		txtFax.setColumns(10);
		txtFax.setBounds(100, 220, 444, 25);
		panel_1.add(txtFax);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 69, 596, 2);
		contentPane.add(separator);
		
	}

	private boolean kiemTraDinhDang() {
		String ten = txtTen.getText();
		String sdt = txtSdt.getText();
		String email = txtEmail.getText();
		String fax = txtFax.getText();

		if (ten.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Tên Nhà sản xuất không được để trống!");
			txtTen.requestFocus();
			txtTen.selectAll();
			return false;
		} else if (!ten.matches("^[\\p{L}0-9 ]+$")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tên chính xác!");
			txtTen.requestFocus();
			txtTen.selectAll();
			return false;
		} else if (sdt.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống!");
			txtSdt.requestFocus();
			txtSdt.selectAll();
			return false;
		} else if (!sdt.matches("[0-9]{10}")) {
			JOptionPane.showMessageDialog(this, "Định dạng số điện thoại không đúng! \\\\n(Phải có 10 kí tự và bắt đầu bằng số 0. Vd: 0339xxxxxx)!");
			txtSdt.requestFocus();
			txtSdt.selectAll();
			return false;
		} else if (email.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Email không được để trống!");
			txtEmail.requestFocus();
			txtEmail.selectAll();
			return false;
		} else if (!email.matches("^([a-z0-9_])+@([\\da-z])+\\.([a-z\\.]{2,6})$")) {
			JOptionPane.showMessageDialog(this, "Email có định dạng: abc@xyz(.com hoặc .vn)");
			txtEmail.requestFocus();
			txtEmail.selectAll();
			return false;
		} else if (fax.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Fax không được để trống!");
			txtFax.requestFocus();
			txtFax.selectAll();
			return false;
		} else if (!fax.matches("[0-9]{10}")) {
			JOptionPane.showMessageDialog(this, "Định dạng số fax không đúng! \n(Phải có 10 kí tự)!");
			txtFax.requestFocus();
			txtFax.selectAll();
			return false;
		}
		return true;
	}
	private String tuDongLayMa() {
		String maHD;
		String stt1 = "";
		int sott1;
		int max=0;
		for(NhaSanXuat s : NhaSanXuat_GUI.lstNSX) {		
			maHD = s.getMaNSX().trim();
			for(int i=3; i<maHD.length();i++) {
				stt1 += maHD.charAt(i);
			}
			sott1 = Integer.valueOf(stt1);
			if(max < sott1)
				max=sott1;
			stt1="";
		}
		String ma = "NSX" + String.valueOf(max + 1);
		return ma;
	}
}
