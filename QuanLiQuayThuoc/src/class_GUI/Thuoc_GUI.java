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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import class_DAO.DangNhap_DAO;
import class_DAO.DonViTinh_DAO;

import class_DAO.LoaiThuoc_DAO;
import class_DAO.NhaSanXuat_DAO;
import class_DAO.QuocGia_DAO;
import class_DAO.Thuoc_DAO;
import class_connectDB.ConnectDB;
import class_entity.DonViTinh;
import class_entity.LoaiThuoc;
import class_entity.NhaSanXuat;
import class_entity.QuocGia;
import class_entity.Thuoc;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

public class Thuoc_GUI extends JFrame {

	public static List<Thuoc> lstT;
	private static Thuoc_DAO Thuoc_dao;
	private static List<NhaSanXuat> lstNSX;
	private static NhaSanXuat_DAO NSX_dao;
	private static List<QuocGia> lstQG;
	private static QuocGia_DAO QG_dao;
	private static List<LoaiThuoc> lstLT;
	private static LoaiThuoc_DAO LT_dao;
	private static List<DonViTinh> lstDV;
	private static DonViTinh_DAO DV_dao;

	private JPanel contentPane;
	private static DefaultTableModel model;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thuoc_GUI frame = new Thuoc_GUI();
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
	public Thuoc_GUI() {
		ConnectDB.getInstance().connect();
		Thuoc_dao = new Thuoc_DAO();
		NSX_dao = new NhaSanXuat_DAO();
		DV_dao = new DonViTinh_DAO();
		QG_dao = new QuocGia_DAO();
		LT_dao = new LoaiThuoc_DAO();
		DocDLDB();

		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setBackground(Color.WHITE);
		setTitle("Quản lí sản phẩm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		horizontalBox.setBackground(Color.WHITE);
		contentPane.add(horizontalBox, BorderLayout.NORTH);

		JLabel label = new JLabel("   ");
		horizontalBox.add(label);

		JLabel lblNameTag = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblNameTag.setToolTipText("QUẢN LÝ SẢN PHẨM");
		lblNameTag.setForeground(Color.BLUE);
		lblNameTag.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNameTag.setBackground(Color.WHITE);
		horizontalBox.add(lblNameTag);

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

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 51, 974, 320);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 954, 288);
		panel_2.add(scrollPane);

		model = new DefaultTableModel(new String[] {
				"STT", "Mã sản phẩm", "Tên sản phẩm", "Giá bán", "Số lượng",
				"Nhà sản xuất", "Loại thuốc", "Đơn vị tính", "Mô tả"
		}, 0);
		table = new JTable(model);
		table.setBackground(Color.WHITE);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setMaxWidth(27);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		JTableHeader Theader = table.getTableHeader();
		Theader.setBackground(Color.white);
		Theader.setFont(new Font("Tahome", Font.BOLD, 11));
		scrollPane.setViewportView(table);

		JButton btnUpdate = new JButton("Cập Nhật");
		btnUpdate.setIcon(new ImageIcon("data\\icons\\searchsale2.png"));
		btnUpdate.setFocusable(false);
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(309, 381, 123, 39);
		btnUpdate.addActionListener(new ActionListener() { //xu ly su kien button sua thong tin thuoc

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if(row != -1) {
					String maThuoc = model.getValueAt(row, 1).toString().trim();
					Thuoc_EDIT_GUI tEdit = new Thuoc_EDIT_GUI(maThuoc);
					tEdit.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn thuốc cần sửa!");
				}
			}
		});
		panel.add(btnUpdate);

		JButton btnDel = new JButton("Xóa");
		btnDel.setIcon(new ImageIcon("data\\icons\\delete1.png"));
		btnDel.setFocusable(false);
		btnDel.setBackground(Color.WHITE);
		btnDel.setBounds(479, 381, 123, 39);
		btnDel.addActionListener(new ActionListener() { //xu ly su kien button xoa thuoc

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if(row != -1) {
					String maThuoc = model.getValueAt(row, 1).toString().trim();
					int nhacnho = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?", "Chú ý", JOptionPane.YES_NO_OPTION);
					if(nhacnho == JOptionPane.YES_OPTION) {
						try {
							if (!Thuoc_dao.xoa(maThuoc))
								throw new Exception();
							else
								updateDL();
							JOptionPane.showMessageDialog(null,"Xóa thành công!");
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Xóa không thành công!");
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn một thuốc cần xóa!");
				}
			}
		});
		panel.add(btnDel);

		JButton btnClose = new JButton("Đóng");
		btnClose.setIcon(new ImageIcon("data\\icons\\exit1.png"));
		btnClose.setFocusable(false);
		btnClose.setBackground(Color.WHITE);
		btnClose.setBounds(636, 381, 123, 39);
		btnClose.addActionListener(new ActionListener() { //xu ly su kien button Dong

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		panel.add(btnClose);
		
				JButton btnAdd = new JButton("Thêm mới");
				btnAdd.setBounds(146, 381, 125, 38);
				panel.add(btnAdd);
				btnAdd.setIcon(new ImageIcon("data\\icons\\add1.png"));
				btnAdd.setBackground(Color.WHITE);
				btnAdd.setFocusable(false);
				btnAdd.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Thuoc_ADD_GUI tADD = new Thuoc_ADD_GUI();
						tADD.setVisible(true);
					}
				});
		updateDL();
	
	}

	private static void DocDLDB() {
		//maThuoc,tenThuoc,giaBan,soLuong,moTa,NSX,loaiThuoc,donViTinh,QG,HoatChat
		lstT = Thuoc_dao.getAlltbThuoc();
		lstNSX = NSX_dao.docTuBang();
		lstDV = DV_dao.getalltbDVT();
		lstQG = QG_dao.getAllQuocGia();
		lstLT = LT_dao.getAllLoaiThuoc();
	}

	private static void XoaHetDuLieuTrenTableModel() {
		model.getDataVector().removeAllElements();
	}

	public static void updateDL() {
		XoaHetDuLieuTrenTableModel();
		DocDLDB();
		
		int i=1;
		for(Thuoc t : lstT) {
			model.addRow(new Object[] {i++, t.getMaThuoc(), t.getTenThuoc(), t.getGiaBan(), t.getSoLuong(),
				 getNSX(t.getMaNSX()), getLT(t.getMaLoai()), getDV(t.getMaDV()), t.getMoTa() });
		}
		table.setModel(model);
	}

	
	public static String getNSX(String ma) {
		for(NhaSanXuat s : lstNSX) {
			if(s.getMaNSX().trim().equalsIgnoreCase(ma.trim())) {
				return s.getTenNSX().trim();
			}
		}
		return "";
	}
	public static String getDV(String ma) {
		for(DonViTinh s : lstDV) {
			if(s.getMaDV().trim().equalsIgnoreCase(ma.trim())) {
				return s.getTenDonVi().trim();
			}
		}
		return "";
	}
	public static String getLT(String ma) {
		for(LoaiThuoc s : lstLT) {
			if(s.getMaLoai().trim().equalsIgnoreCase(ma.trim())) {
				return s.getTenLoaiThuoc().trim();
			}
		}
		return "";
	}
	public static String getQG(String ma) {
		for(QuocGia s : lstQG) {
			if(s.getMaQG().trim().equalsIgnoreCase(ma.trim())) {
				return s.getTenQuocGia().trim();
			}
		}
		return "";
	}
}
