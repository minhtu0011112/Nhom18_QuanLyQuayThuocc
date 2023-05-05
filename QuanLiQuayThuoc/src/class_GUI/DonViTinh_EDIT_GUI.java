package class_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.border.LineBorder;

import class_DAO.DonViTinh_DAO;
import class_connectDB.ConnectDB;
import class_entity.DonViTinh;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import class_GUI.DonViTinh_GUI;

public class DonViTinh_EDIT_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenDVT;
	private DonViTinh_DAO dvt_DAO;
	private JTextField txtMaDVT;
	private String madvt1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DonViTinh_EDIT_GUI frame = new DonViTinh_EDIT_GUI();
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
	public DonViTinh_EDIT_GUI(String madvt) {
		ConnectDB.getInstance().connect();
		dvt_DAO = new DonViTinh_DAO();
		madvt1 = madvt;
		
		setTitle("Sửa đơn vị tính");
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 472, 318);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBackground(Color.WHITE);
		contentPane.add(horizontalBox, BorderLayout.NORTH);
		
		JLabel label = new JLabel("   ");
		horizontalBox.add(label);
		
		JLabel label_1 = new JLabel("ĐƠN VỊ TÍNH");
		label_1.setToolTipText("ĐƠN VỊ TÍNH");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBackground(Color.WHITE);
		horizontalBox.add(label_1);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
//		JLabel label_2 = new JLabel("");
//		label_2.setIcon(new ImageIcon("data\\icons\\logo3.png"));
//		label_2.setBackground(Color.WHITE);
//		horizontalBox.add(label_2);
	
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(UIManager.getColor("activeCaption")));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 23, 426, 121);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTenDVT = new JLabel("Tên đơn vị tính:");
		lblTenDVT.setBounds(17, 70, 97, 27);
		panel_1.add(lblTenDVT);
		
		txtTenDVT = new JTextField();
		txtTenDVT.setBackground(Color.WHITE);
		txtTenDVT.setBounds(113, 70, 265, 27);
		panel_1.add(txtTenDVT);
		txtTenDVT.setColumns(10);
		
		JLabel lblMaDVT = new JLabel("Mã đơn vị tính:");
		lblMaDVT.setBounds(17, 27, 97, 27);
		panel_1.add(lblMaDVT);
		
		txtMaDVT = new JTextField();
		txtMaDVT.setColumns(10);
		txtMaDVT.setBackground(Color.WHITE);
		txtMaDVT.setBounds(113, 27, 265, 27);
		panel_1.add(txtMaDVT);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setBackground(Color.WHITE);
		btnLuu.setIcon(new ImageIcon("data\\icons\\save1.png"));
		btnLuu.setBounds(222, 155, 102, 37);
		panel.add(btnLuu);
		btnLuu.addActionListener(new ActionListener() {
			
			private DonViTinh dvt;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(validData()) {
					dvt = new DonViTinh(txtMaDVT.getText().trim(), txtTenDVT.getText().trim());
					try {
						if(!dvt_DAO.update(dvt))
							throw new Exception();
						DonViTinh_GUI.updateDL();
						JOptionPane.showMessageDialog(null, "Sửa thành công!");
						dispose();		
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Sửa không thành công!!");
					}
				}
			}
		});
		
		JButton btnBoQua = new JButton("Bỏ qua");
		btnBoQua.setBackground(Color.WHITE);
		btnBoQua.setIcon(new ImageIcon("data\\icons\\exit1.png"));
		btnBoQua.setBounds(334, 155, 102, 37);
		btnBoQua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		panel.add(btnBoQua);
		DocDL();
	}
	private boolean validData() {
		String MaDVT = txtMaDVT.getText().trim();
		String TenDVT = txtTenDVT.getText().trim();
		if(!(MaDVT.length() > 0)) {
			JOptionPane.showMessageDialog(null, "Mã Đơn Vị Tính không được rỗng!");
			return false;
		}
		if(!(TenDVT.length() > 0)) {
			JOptionPane.showMessageDialog(null, "Tên Đơn Vị Tính không được rỗng!");
			return false;
		}
		return true;
	}
	private void DocDL() {
		for(DonViTinh s : DonViTinh_GUI.ldvt) {
			if(s.getMaDV().trim().equals(madvt1)) {
				txtMaDVT.setText(s.getMaDV().trim());
				txtTenDVT.setText(s.getTenDonVi().trim());
			}
		}
	}
}
