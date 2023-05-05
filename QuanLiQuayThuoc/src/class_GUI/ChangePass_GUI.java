package class_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import class_DAO.DangNhap_DAO;
import class_connectDB.ConnectDB;
import class_entity.DangNhap;
import class_entity.DonViTinh;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ChangePass_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtOldPass;
	private JTextField txtNewPass;
	private JTextField txtXN;
	private DangNhap_DAO dn_DAO;
	private List<DangNhap> ldn;
	private String maTK1;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChangePass frame = new ChangePass();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ChangePass_GUI(String maTK) {
		
		maTK1 = maTK;
		
		ConnectDB.getInstance().connect();
		dn_DAO = new DangNhap_DAO();
		DocDLDB();
		
		setTitle("Thay \u0111\u1ED5i m\u1EADt kh\u1EA9u");
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 533, 312);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		horizontalBox.setBackground(Color.WHITE);
		contentPane.add(horizontalBox, BorderLayout.NORTH);
		
		JLabel label = new JLabel("   ");
		horizontalBox.add(label);
		
		JLabel lblThayiMt = new JLabel("THAY \u0110\u1ED4I M\u1EACT KH\u1EA8U");
		lblThayiMt.setToolTipText("");
		lblThayiMt.setForeground(Color.BLUE);
		lblThayiMt.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThayiMt.setBackground(Color.WHITE);
		horizontalBox.add(lblThayiMt);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
		//JLabel label_2 = new JLabel("");
		//label_2.setIcon(new ImageIcon("data\\icons\\logo3.png"));
		//label_2.setBackground(Color.WHITE);
		//horizontalBox.add(label_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblOldPass = new JLabel("M\u1EADt kh\u1EA9u c\u0169:");
		lblOldPass.setBounds(45, 33, 85, 23);
		panel.add(lblOldPass);
		
		txtOldPass = new JTextField();
		txtOldPass.setBounds(140, 33, 321, 23);
		panel.add(txtOldPass);
		txtOldPass.setColumns(10);
		
		JLabel lblNewPass = new JLabel("M\u1EADt kh\u1EA9u m\u1EDBi:");
		lblNewPass.setBounds(45, 67, 85, 23);
		panel.add(lblNewPass);
		
		txtNewPass = new JTextField();
		txtNewPass.setColumns(10);
		txtNewPass.setBounds(140, 67, 321, 23);
		panel.add(txtNewPass);
		
		JLabel lblXN = new JLabel("X\u00E1c nh\u1EADn:");
		lblXN.setBounds(45, 101, 85, 23);
		panel.add(lblXN);
		
		txtXN = new JTextField();
		txtXN.setColumns(10);
		txtXN.setBounds(140, 101, 321, 23);
		txtXN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(validData()) {
					String oldpass = txtOldPass.getText().trim();
					String newpass = txtNewPass.getText().trim();
					String confirm = txtXN.getText().trim();
					DangNhap dn = null;
					for(DangNhap s : ldn) {
						if(s.getMaTK().trim().equalsIgnoreCase(maTK1.trim())) {
							if(!oldpass.equals(s.getMatKhau().trim())) {
								JOptionPane.showMessageDialog(null, "Mật khẩu cũ không đúng!");
							}
							else {
								try {
									if(!dn_DAO.update(maTK1, newpass))
										throw new Exception();
									ThongTinTaiKhoan.DocDLDB();
									JOptionPane.showMessageDialog(null, "Cập nhật mật khẩu thành công!");
									dispose();		
								}
								catch(Exception e1) {
									JOptionPane.showMessageDialog(null, "Cập nhật mật khẩu không thành công!!");
								}
								break;
							}
						}
					}
				}
			}
		});
		panel.add(txtXN);
		
		JButton btnLuu = new JButton("L\u01B0u");
		btnLuu.setIcon(new ImageIcon("data\\icons\\save1.png"));
		btnLuu.setBackground(Color.WHITE);
		btnLuu.setBounds(253, 145, 99, 36);
		btnLuu.setFocusable(false);
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(validData()) {
					String oldpass = txtOldPass.getText().trim();
					String newpass = txtNewPass.getText().trim();
					String confirm = txtXN.getText().trim();
					DangNhap dn = null;
					for(DangNhap s : ldn) {
						if(s.getMaTK().trim().equalsIgnoreCase(maTK1.trim())) {
							if(!oldpass.equals(s.getMatKhau().trim())) {
								JOptionPane.showMessageDialog(null, "Mật khẩu cũ không đúng!");
							}
							else {
								try {
									if(!dn_DAO.update(maTK1, newpass))
										throw new Exception();
									ThongTinTaiKhoan.DocDLDB();
									JOptionPane.showMessageDialog(null, "Cập nhật mật khẩu thành công!");
									dispose();		
								}
								catch(Exception e1) {
									JOptionPane.showMessageDialog(null, "Cập nhật mật khẩu không thành công!!");
								}
								break;
							}
						}
					}
				}
			}
		});
		panel.add(btnLuu);
		
		JButton btnClose = new JButton("\u0110\u00F3ng");
		btnClose.setIcon(new ImageIcon("data\\icons\\exit1.png"));
		btnClose.setBackground(Color.WHITE);
		btnClose.setBounds(362, 145, 99, 36);
		btnClose.setFocusable(false);
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		panel.add(btnClose);
	}
	private void DocDLDB() {
		ldn = dn_DAO.getalltabledangnhap();
	}
	private boolean validData() {
		String oldpass = txtOldPass.getText().trim();
		String newpass = txtNewPass.getText().trim();
		String confirm = txtXN.getText().trim();
		if(!(oldpass.length() > 0)) {
			JOptionPane.showMessageDialog(null, "Mật khẩu cũ không được rỗng!");
			return false;
		}
		if(!(newpass.length() > 0) || newpass.length()<6) {
			JOptionPane.showMessageDialog(null, "Mật khẩu mới không được rỗng và ít nhất 6 kí tự!");
			return false;
		}
		if(!newpass.equals(confirm)) {
			JOptionPane.showMessageDialog(null, "Xác nhận mật khẩu không đúng!");
			return false;
		}
		return true;
	}
}
