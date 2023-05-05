package class_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import class_DAO.NhaSanXuat_DAO;
import class_connectDB.ConnectDB;
import class_entity.NhaSanXuat;
import class_entity.NhanVien;

import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class NhaSanXuat_GUI extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private static JButton btnThem, btnXa, btnCpNht, btnDong;
	private static JComboBox cboTimKiem;
	private static DefaultTableModel model;
	public static List<NhaSanXuat> lstNSX;
	private static NhaSanXuat_DAO qlNSX_DAO;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NhaSanXuat_GUI frame = new NhaSanXuat_GUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public NhaSanXuat_GUI() {
		ConnectDB.getInstance().connect();
		qlNSX_DAO = new NhaSanXuat_DAO();

		setResizable(false);
		setTitle("Quản lý nhà sản xuất");
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 911, 577);
		setBackground(Color.WHITE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(0, 0, 905, 71);
		horizontalBox.setBackground(Color.WHITE);
		contentPane.add(horizontalBox);

		JLabel lblNewLabel = new JLabel("  QUẢN LÝ NHÀ SẢN XUẤT");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		horizontalBox.add(lblNewLabel);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setBackground(Color.WHITE);
		horizontalBox.add(horizontalGlue);

//		JLabel label = new JLabel("");
//		label.setIcon(new ImageIcon("data\\icons\\logo3.png"));
//		horizontalBox.add(label);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch nh\u00E0 s\u1EA3n xu\u1EA5t", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(0, 82, 905, 466);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTmKimNcc = new JLabel("Tìm kiếm NSX:");
		lblTmKimNcc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTmKimNcc.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTmKimNcc.setBounds(110, 21, 111, 20);
		panel.add(lblTmKimNcc);

		cboTimKiem = new JComboBox();
		cboTimKiem.setBackground(Color.WHITE);
		cboTimKiem.setBounds(231, 16, 444, 33);
		cboTimKiem.setFocusable(false);
		panel.add(cboTimKiem);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 885, 338);
		scrollPane.setBackground(Color.WHITE);
		panel.add(scrollPane);

		model = new DefaultTableModel(new String[] { "Mã NSX", "Tên NSX", "SDT", "Fax", "Mail" }, 0);
	
		table = new JTable(model);
		//table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBackground(Color.WHITE);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setMaxWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//		JTableHeader Theader = table.getTableHeader();
//		Theader.setBackground(Color.white);
//		Theader.setFont(new Font("Tahome", Font.BOLD, 11));
		scrollPane.setViewportView(table);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("data\\icons\\add1.png"));
		btnThem.setBackground(Color.WHITE);
		btnThem.setBounds(373, 416, 123, 39);
		btnThem.setFocusable(false);
		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(null, ma);
				NhaSanXuat_ADD_GUI add =new NhaSanXuat_ADD_GUI();
				add.setVisible(true);
			}
		});
		panel.add(btnThem);

		btnCpNht = new JButton("Cập nhật");
		btnCpNht.setIcon(new ImageIcon("data\\icons\\write.png"));
		btnCpNht.setBackground(Color.WHITE);
		btnCpNht.setBounds(506, 416, 123, 39);
		btnCpNht.setFocusable(false);
		btnCpNht.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if (row != -1) {
					String ma = model.getValueAt(row, 0).toString().trim();
					//JOptionPane.showMessageDialog(null, ma);
					NhaSanXuat_EDIT_GUI edit =new NhaSanXuat_EDIT_GUI(ma);
					edit.setVisible(true);
					updateDL();
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 nhà sản xuất cần sửa!");
				}
			}
		});
		panel.add(btnCpNht);

		btnXa = new JButton("Xóa");
		btnXa.setIcon(new ImageIcon("data\\icons\\delete1.png"));
		btnXa.setBackground(Color.WHITE);
		btnXa.setBounds(639, 416, 123, 39);
		btnXa.setFocusable(false);
		btnXa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if (row != -1) {
					String ma = model.getValueAt(row, 0).toString().trim();
					int nhacnho = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không?", "Chú ý",
							JOptionPane.YES_NO_OPTION);
					if (nhacnho == JOptionPane.YES_OPTION) {
						if (qlNSX_DAO.deleteNSX(ma)) {
							updateDL();
							JOptionPane.showMessageDialog(null, "Xóa thành công!");
						} else {
							JOptionPane.showMessageDialog(null, "Xóa không thành công!");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 nhà sản xuất cần xóa!");
				}
			}
		});
		panel.add(btnXa);
		
		btnDong = new JButton("Đóng");
		btnDong.setIcon(new ImageIcon("data\\icons\\exit1.png"));
		btnDong.setBackground(Color.WHITE);
		btnDong.setBounds(772, 416, 123, 39);
		btnDong.setFocusable(false);
		btnDong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		panel.add(btnDong);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon("data\\icons\\search1.png"));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setBackground(Color.WHITE);
		btnTimKiem.setBounds(697, 18, 111, 28);
		btnTimKiem.addActionListener(new ActionListener() {
			
			private ArrayList<NhaSanXuat> lnsx;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String dieuKien = "";
				String dieuKiennew = "";
				String and = "";
				if(cboTimKiem.getSelectedIndex()!=-1 && !cboTimKiem.getSelectedItem().toString().trim().equals("Không chọn")) {
					dieuKien += "TenNSX=N'"+cboTimKiem.getSelectedItem().toString().trim() + "' and ";
				}		
				dieuKien = dieuKien.trim();
				if(dieuKien.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn thông tin tìm kiếm!");
				}
				else {
					for(int i=3; i>0; i--) {
						and+=dieuKien.trim().charAt(dieuKien.length()-i);
					}
					if(and.equalsIgnoreCase("and")) {
						for(int i=0; i<dieuKien.length()-4; i++) {
							dieuKiennew += dieuKien.charAt(i);
						}
					}
					lnsx = qlNSX_DAO.searchNSX(dieuKiennew);
					//System.out.println(dieuKiennew);
					if(lnsx.size()!=0) {
						XoaHetDuLieuTrenTableModel();
						int i=1;
						for (NhaSanXuat s : lnsx) {
							model.addRow(new Object[] { s.getMaNSX(), " " + s.getTenNSX(), " " + s.getsDT(),
									" " + s.getFax(), " " + s.getEmail() });
						}
						table.setModel(model);
					}
					else {
						NhaSanXuat_GUI.updateDL();
						JOptionPane.showMessageDialog(null, "Không tìm thấy!");
					}
				}
			}
		});
		panel.add(btnTimKiem);
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 70, 895, 2);
		contentPane.add(separator);
		
		updateDL();
	}
	
	private static void DocDLDB() {
		lstNSX = qlNSX_DAO.docTuBang();
	}

	private static void XoaHetDuLieuTrenTableModel() {
		model.getDataVector().removeAllElements();
	}

	public static void updateDL() {
		XoaHetDuLieuTrenTableModel();
		DocDLDB();
		updateDLCbo();
		int i=1;

		for (NhaSanXuat s : lstNSX) {
			model.addRow(new Object[] { s.getMaNSX(), " " + s.getTenNSX(), " " + s.getsDT(),
					" " + s.getFax(), " " + s.getEmail() });
		}
		table.setModel(model);
	}

	private static void updateDLCbo() {
		cboTimKiem.removeAllItems();

		cboTimKiem.addItem("Không chọn");

		for(NhaSanXuat n : lstNSX) {
			cboTimKiem.addItem(n.getTenNSX().trim());
		}

		cboTimKiem.setSelectedIndex(-1);
	}
}
