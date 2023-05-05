package class_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.border.EmptyBorder;

import class_DAO.DonViTinh_DAO;
import class_DAO.QuanLyNV_DAO;
import class_DAO.DangNhap_DAO;
import class_connectDB.ConnectDB;
import class_entity.DangNhap;
import class_entity.NhanVien;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.*;
import java.awt.*;

public class DangNhap_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private List<DangNhap> ldn;
	private DangNhap_DAO dn_DAO;
	private List<NhanVien> lnv;
	private QuanLyNV_DAO nv_DAO;
	public static String signing;

	/**
	 * Create the frame.
	 */
	public DangNhap_GUI() {
		ConnectDB.getInstance().connect();
		dn_DAO = new DangNhap_DAO();
		nv_DAO = new QuanLyNV_DAO();
		DocDLDB();
		
		JLabel background;
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\pictures\\hospital.png"));
		setTitle("Quản lý nhà thuốc");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 926, 565);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		
		//ImageIcon img = new ImageIcon("data\\pictures\\hospital.png");
		getContentPane().setLayout(null);
		setResizable(false);
		
		txtUser = new JTextField();
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtUser.setBounds(382, 224, 216, 23);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);
		/*
		 * txtUser.addActionListener(new ActionListener() {
		 * 
		 * QuanLiQuayThuoc_NV_GUI nv1; QuanLiQuayThuoc_QL_GUI ql;
		 * 
		 * @Override public void actionPerformed(ActionEvent arg0) { // TODO
		 * Auto-generated method stub int dem=0; try { for(DangNhap dn : ldn) {
		 * if((txtUser.getText().trim().toString().equalsIgnoreCase(dn.getMaTK().trim())
		 * ) && txtPass.getText().trim().equals(dn.getMatKhau().trim())) { for(NhanVien
		 * nv : lnv) {
		 * if(nv.getMaNV().trim().equalsIgnoreCase(txtUser.getText().trim())) {
		 * if(nv.getTinhTrang()==0) { JOptionPane.showMessageDialog(null,
		 * "Tài khoản hết hiệu lực!"); dem++; } else { dem++; signing =
		 * txtUser.getText().trim(); if(dn.getQuanLy()==0) { nv1 = new
		 * QuanLiQuayThuoc_NV_GUI(signing); nv1.setVisible(true); dispose(); } else { ql
		 * = new QuanLiQuayThuoc_QL_GUI(signing); ql.setVisible(true); dispose(); }
		 * dem++; break; } } } } } if(dem==0) throw new Exception(); } catch(Exception
		 * e) { JOptionPane.showMessageDialog(null, "Sai Tài Khoản hoặc Mật Khẩu"); } }
		 * });
		 */
		
		txtPass = new JPasswordField();
		txtPass.setHorizontalAlignment(SwingConstants.CENTER);
		txtPass.setColumns(10);
		txtPass.setBounds(382, 263, 216, 23);
		getContentPane().add(txtPass);
		/*
		 * txtPass.addActionListener(new ActionListener() {
		 * 
		 * private QuanLiQuayThuoc_NV_GUI nv1; private QuanLiQuayThuoc_QL_GUI ql;
		 * 
		 * @Override public void actionPerformed(ActionEvent arg0) { // TODO
		 * Auto-generated method stub int dem=0; try { for(DangNhap dn : ldn) {
		 * if((txtUser.getText().trim().toString().equalsIgnoreCase(dn.getMaTK().trim())
		 * ) && txtPass.getText().trim().equals(dn.getMatKhau().trim())) { for(NhanVien
		 * nv : lnv) {
		 * if(nv.getMaNV().trim().equalsIgnoreCase(txtUser.getText().trim())) {
		 * if(nv.getTinhTrang()==0) { JOptionPane.showMessageDialog(null,
		 * "Tài khoản hết hiệu lực!"); dem++; } else { dem++; signing =
		 * txtUser.getText().trim(); if(dn.getQuanLy()==0) { nv1 = new
		 * QuanLiQuayThuoc_NV_GUI(signing); nv1.setVisible(true); dispose(); } else { ql
		 * = new QuanLiQuayThuoc_QL_GUI(signing); ql.setVisible(true); dispose(); }
		 * dem++; break; } } } } } if(dem==0) throw new Exception(); } catch(Exception
		 * e) { JOptionPane.showMessageDialog(null, "Sai Tài Khoản hoặc Mật Khẩu"); } }
		 * });
		 */
		
		JLabel lblUserName = new JLabel("Tài khoản:");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setToolTipText("User name");
		lblUserName.setForeground(Color.BLUE);
		lblUserName.setBounds(288, 224, 84, 23);
		getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Mật khẩu:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setToolTipText("Password");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setBounds(288, 263, 84, 23);
		getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setIcon(new ImageIcon("data\\icons\\login.png"));
		btnLogin.setToolTipText("Login");
		btnLogin.setForeground(new Color(0, 128, 0));
		btnLogin.setBounds(288, 325, 115, 35);
		btnLogin.setFocusable(false);
		getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			private QuanLiQuayThuoc_NV_GUI nv1;
			private QuanLiQuayThuoc_QL_GUI ql;

			public void actionPerformed(ActionEvent arg0) {
				int dem=0; //bien dem xac thuc so lan thanh cong
				try {
					for(DangNhap dn : ldn) {
						//kiem tra co trung tai khoan hay khong
						if((txtUser.getText().trim().toString().equalsIgnoreCase(dn.getMaTK().trim())) && txtPass.getText().trim().equals(dn.getMatKhau().trim())) {
							for(NhanVien nv : lnv) {
								// kiem tra tinh trang xem tai khoan co con hieu luc hay khong 1 la con 0 la het
								if(nv.getMaNV().trim().equalsIgnoreCase(txtUser.getText().trim())) {
									if(nv.getTinhTrang()==0) {
										JOptionPane.showMessageDialog(null, "Tài khoản hết hiệu lực!");
										dem++;
									}								
									else {
										dem++;
										signing = txtUser.getText().trim();
										if(dn.getQuanLy()==0) {
											nv1 = new QuanLiQuayThuoc_NV_GUI(signing);
											nv1.setVisible(true);
											dispose();
										}
										else {
											ql = new QuanLiQuayThuoc_QL_GUI(signing);
											ql.setVisible(true);
											dispose();
										}								
										dem++;
										break;
									}
								}
							}
						}
					}	
					if(dem==0)
						throw new Exception();
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Sai Tài Khoản hoặc Mật Khẩu");
				}
			}
		});
		
		JButton btnCancel = new JButton("Thoát");
		btnCancel.setIcon(new ImageIcon("data\\icons\\exit.png"));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.setForeground(Color.RED);
		btnCancel.setToolTipText("Cancel");
		btnCancel.setBounds(501, 325, 115, 35);
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		getContentPane().add(btnCancel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(25, 25, 112));
		panel_1.setBounds(252, 139, 402, 70);
		getContentPane().add(panel_1);
		//ImageIcon img2 = new ImageIcon("data\\pictures\\logo3.png");
		
		JLabel lblNewLabel = new JLabel();
		panel_1.add(lblNewLabel);
		//lblNewLabel.setIcon(new ImageIcon("data\\icons\\logo3.png"));
		lblNewLabel.setBackground(new Color(0, 0, 139));
		lblNewLabel.setToolTipText("Phần mềm quản lí nhà thuốc");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(165, 42, 42));
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD, 28));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(252, 207, 402, 198);
		getContentPane().add(panel);
	}
	private void DocDLDB() {
		ldn = dn_DAO.getalltabledangnhap();
		lnv = nv_DAO.getAllNhanVienall();
	}
}
