package class_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import class_DAO.NhaSanXuat_DAO;
import class_connectDB.ConnectDB;
import class_entity.DonViTinh;
import class_entity.LoaiThuoc;
import class_entity.NhaSanXuat;
import class_entity.NhanVien;
import class_entity.QuocGia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class NhaSanXuat_EDIT_GUI extends JFrame {

	private JPanel contentPane;
	private JButton btnLuu, btnDong;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtSdt;
	private JTextField txtEmail;
	private JTextField txtFax, txtMail;
	private static List<NhaSanXuat> lstNSX;
	private static NhaSanXuat_DAO qlNSX_dao;

	public NhaSanXuat_EDIT_GUI(String ma) {
		ConnectDB.getInstance().connect();
		qlNSX_dao = new NhaSanXuat_DAO();

		setTitle("Cập nhật nhà sản xuất");
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 612, 460);
		setLocationRelativeTo(null);
		setBackground(Color.WHITE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBackground(Color.WHITE);
		horizontalBox.setBounds(0, 0, 596, 60);
		contentPane.add(horizontalBox);

		JLabel lblEditNCC = new JLabel("  CẬP NHẬT NHÀ SÀN XUẤT");
		lblEditNCC.setForeground(Color.BLUE);
		lblEditNCC.setFont(new Font("Tahoma", Font.BOLD, 14));
		horizontalBox.add(lblEditNCC);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);

//		JLabel label_9 = new JLabel("");
//		label_9.setIcon(new ImageIcon("data\\icons\\logo3.png"));
//		horizontalBox.add(label_9);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 72, 596, 349);
		contentPane.add(panel);
		panel.setLayout(null);

		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("data\\icons\\save.png"));
		btnLuu.setBackground(Color.WHITE);
		btnLuu.setBounds(330, 299, 123, 39);
		panel.add(btnLuu);
		btnLuu.addActionListener(new ActionListener() { 

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (kiemTraDinhDang()) {
					String maNSX, tenNSX,sDT,fax, eMail;
					
					maNSX = ma;
					tenNSX = txtTen.getText().trim();
					sDT = txtSdt.getText().trim();
					fax = txtFax.getText().trim();
					eMail = txtEmail.getText().trim();
					
					try {
						if(!qlNSX_dao.capNhapNSX(maNSX, tenNSX, sDT, fax, eMail))
							throw new Exception();
						else
							NhaSanXuat_GUI.updateDL();
						JOptionPane.showMessageDialog(null, "Lưu thành công!");
						dispose();		
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Lưu không thành công!!");
					}
				}
			}
		});

		btnDong = new JButton("Bỏ qua");
		btnDong.setIcon(new ImageIcon("data\\icons\\exit1.png"));
		btnDong.setBackground(Color.WHITE);
		btnDong.setBounds(463, 299, 123, 39);
		panel.add(btnDong);
		btnDong.addActionListener(new ActionListener() { // XÃ¡Â»Â­ lÃƒÂ½ sÃ¡Â»Â± kiÃ¡Â»â€¡n cho button Ã„ï¿½ÃƒÂ³ng

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
		panel_1.setBounds(10, 9, 576, 279);
		panel.add(panel_1);

		JLabel lblMa = new JLabel("Mã NSX:");
		lblMa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMa.setBounds(10, 24, 80, 17);
		panel_1.add(lblMa);

		txtMa = new JTextField();
		txtMa.setBackground(Color.WHITE);
		txtMa.setEditable(false);
		txtMa.setColumns(10);
		txtMa.setBounds(100, 20, 409, 25);
		panel_1.add(txtMa);

		JLabel lblTen = new JLabel("Tên NSX:");
		lblTen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTen.setBounds(10, 74, 80, 17);
		panel_1.add(lblTen);

		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(100, 70, 409, 25);
		panel_1.add(txtTen);

		JLabel lblSdt = new JLabel("SDT:");
		lblSdt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSdt.setBounds(10, 124, 80, 17);
		panel_1.add(lblSdt);

		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBounds(100, 120, 409, 25);
		panel_1.add(txtSdt);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(10, 174, 80, 17);
		panel_1.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(100, 170, 409, 25);
		panel_1.add(txtEmail);

		JLabel lblFax = new JLabel("Fax:");
		lblFax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFax.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFax.setBounds(10, 224, 80, 17);
		panel_1.add(lblFax);

		txtFax = new JTextField();
		txtFax.setColumns(10);
		txtFax.setBounds(100, 220, 409, 25);
		panel_1.add(txtFax);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 65, 596, 2);
		contentPane.add(separator);
		dienThongTin(ma);
	}
	
	private void dienThongTin(String ma) {
		qlNSX_dao = new NhaSanXuat_DAO();
		// JOptionPane.showMessageDialog(this, ma);
		// String ma="123";
		lstNSX = qlNSX_dao.docTuBang();
		for (NhaSanXuat n : lstNSX) {
			if (ma.trim().equals(n.getMaNSX().trim())) {
				// JOptionPane.showMessageDialog(this, "Chay dc");
				txtMa.setText(ma.trim().trim());
				txtTen.setText(n.getTenNSX().trim());
				txtSdt.setText(n.getsDT().trim());
				txtFax.setText(n.getFax().trim());
				txtEmail.setText(n.getEmail().trim());
			}
		}
	}
	private boolean kiemTraDinhDang() {
		String ten = txtTen.getText();
		String sdt = txtSdt.getText();
		String email = txtEmail.getText();
		String fax = txtFax.getText();

		if (ten.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "TÃªn nhÃ  cung cáº¥p khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng!");
			txtTen.requestFocus();
			txtTen.selectAll();
			return false;
		} else if (!ten.matches("^[\\p{L}0-9 ]+$")) {
			JOptionPane.showMessageDialog(this, "Vui lÃ²ng nháº­p há»� tÃªn chÃ­nh xÃ¡c!");
			txtTen.requestFocus();
			txtTen.selectAll();
			return false;
		} else if (sdt.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Sá»‘ Ä‘iá»‡n thoáº¡i khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng!");
			txtSdt.requestFocus();
			txtSdt.selectAll();
			return false;
		} else if (!sdt.matches("[0-9]{10}")) {
			JOptionPane.showMessageDialog(this, "Ä�á»‹nh dáº¡ng sá»‘ Ä‘iá»‡n thoáº¡i khÃ´ng Ä‘Ãºng! \n(Pháº£i cÃ³ 10 kÃ­ tá»± vÃ  báº¯t Ä‘áº§u báº±ng sá»‘ 0. Vd: 0339xxxxxx)!");
			txtSdt.requestFocus();
			txtSdt.selectAll();
			return false;
		} else if (email.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Email khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng!");
			txtEmail.requestFocus();
			txtEmail.selectAll();
			return false;
		} else if (!email.matches("^([a-z0-9_])+@([\\da-z])+\\.([a-z\\.]{2,6})$")) {
			JOptionPane.showMessageDialog(this, "Email cÃ³ Ä‘á»‹nh dáº¡ng: abc@xyz(.com hoáº·c .vn)");
			txtEmail.requestFocus();
			txtEmail.selectAll();
			return false;
		} else if (fax.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Fax khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng!");
			txtFax.requestFocus();
			txtFax.selectAll();
			return false;
		} else if (!fax.matches("[0-9]{10}")) {
			JOptionPane.showMessageDialog(this, "Ä�á»‹nh dáº¡ng sá»‘ fax khÃ´ng Ä‘Ãºng! \n(Pháº£i cÃ³ 10 kÃ­ tá»± sá»‘ .)!");
			txtFax.requestFocus();
			txtFax.selectAll();
			return false;
		}
		return true;
	}
}
