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

import class_DAO.LoaiThuoc_DAO;
import class_connectDB.ConnectDB;
import class_entity.LoaiThuoc;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class LoaiThuoc_EDIT_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaLT;
	private static List<LoaiThuoc> lstLT;
	private static LoaiThuoc_DAO LT_dao;
	private JTextField txtLT;
	private String maLoai1;

	public LoaiThuoc_EDIT_GUI(String maLoai) {
		maLoai1=maLoai;
		ConnectDB.getInstance().connect();
		LT_dao = new LoaiThuoc_DAO();

		setTitle("Sửa loại thuốc");
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

		JLabel lblLoaiThuoc = new JLabel("LOẠI THUỐC");
		lblLoaiThuoc.setToolTipText("");
		lblLoaiThuoc.setForeground(Color.BLUE);
		lblLoaiThuoc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoaiThuoc.setBackground(Color.WHITE);
		horizontalBox.add(lblLoaiThuoc);

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
		panel_1.setBounds(10, 23, 426, 127);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMaLT = new JLabel("Mã loại thuốc:");
		lblMaLT.setBounds(20, 27, 103, 27);
		panel_1.add(lblMaLT);

		txtMaLT = new JTextField();
		txtMaLT.setBackground(Color.WHITE);
		txtMaLT.setBounds(133, 27, 256, 27);
		panel_1.add(txtMaLT);
		txtMaLT.setEditable(false);
		txtMaLT.setColumns(10);

		JLabel lblLT = new JLabel("Loại thuốc:");
		lblLT.setBounds(20, 71, 103, 27);
		panel_1.add(lblLT);

		txtLT = new JTextField();
		txtLT.setColumns(10);
		txtLT.setBackground(Color.WHITE);
		txtLT.setBounds(133, 71, 256, 27);
		panel_1.add(txtLT);

		JButton btnLuu = new JButton("Lưu");
		btnLuu.setBackground(Color.WHITE);
		btnLuu.setIcon(new ImageIcon("data\\icons\\save1.png"));
		btnLuu.setBounds(222, 161, 102, 37);
		btnLuu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (kTraDinhDang()) {
					String maLoai,tenLoaiThuoc;
					
					maLoai = txtMaLT.getText().trim();
					tenLoaiThuoc = txtLT.getText().trim();

					try {
						if(!LT_dao.update(maLoai, tenLoaiThuoc))
							throw new Exception();
						else
							LoaiThuoc_GUI.updateDL();
						JOptionPane.showMessageDialog(null, "Lưu thành công!");
						dispose();		
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Lưu không thành công!!");
					}
				}
			}
		});
		panel.add(btnLuu);

		JButton btnBoQua = new JButton("Bỏ qua");
		btnBoQua.setBackground(Color.WHITE);
		btnBoQua.setIcon(new ImageIcon("data\\icons\\exit1.png"));
		btnBoQua.setBounds(334, 161, 102, 37);
		btnBoQua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		panel.add(btnBoQua);
		updateDL();
	}
	private boolean kTraDinhDang() {
		String tenLoai = txtLT.getText();

		if (tenLoai.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Tên loại thuốc không được để trống!");
			txtLT.requestFocus();
			txtLT.selectAll();
			return false;
		} else if (!tenLoai.matches("^[\\p{L}0-9 ]+$")) { // Giới hạn kí tự điền vào tên là 2-25 kí tự!
			JOptionPane.showMessageDialog(this, "Vui lòng điền tên chính xác!");
			txtLT.requestFocus();
			txtLT.selectAll();
			return false;
		}
		return true;

	}
	private void updateDL() {
		for(LoaiThuoc s : LoaiThuoc_GUI.lstLT) {
			if(s.getMaLoai().trim().equals(maLoai1)) {
				txtMaLT.setText(s.getMaLoai().trim());
				txtLT.setText(s.getTenLoaiThuoc().trim());
			}
		}
	}
}
