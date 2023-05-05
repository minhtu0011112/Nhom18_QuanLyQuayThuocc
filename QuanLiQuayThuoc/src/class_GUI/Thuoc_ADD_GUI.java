package class_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import class_DAO.DonViTinh_DAO;
import class_DAO.LoaiThuoc_DAO;
import class_DAO.NhaSanXuat_DAO;
import class_DAO.QuocGia_DAO;
import class_DAO.Thuoc_DAO;

import javax.swing.JButton;
import java.awt.TextArea;
import javax.swing.JRadioButton;
import java.awt.Checkbox;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.awt.event.ActionEvent;

import class_GUI.DonViTinh_GUI;
import class_connectDB.ConnectDB;
import class_entity.DonViTinh;
import class_entity.LoaiThuoc;
import class_entity.NhaSanXuat;
import class_entity.NhanVien;
import class_entity.QuocGia;
import class_entity.Thuoc;
import javax.swing.border.EtchedBorder;


public class Thuoc_ADD_GUI extends JFrame {

	private JPanel contentPane;
	private static JTextField txtNameSp,txtmasp,txtSoLuong,txtGiaBan,txtNgSX,txtHSD;
	private static JComboBox cboNgH,cboNSX,cboNuocSX,cboDVT;

	public static List<Thuoc> lstT;
	private static List<NhaSanXuat> lstNSX;
	private static List<LoaiThuoc> lstNgh;
	private static List<DonViTinh> lstDVT;
	private static List<QuocGia> lstQG;
	private JTextField txtSLcanhBao;
	private TextArea txaMoTa;
	private static NhaSanXuat_DAO NSX_dao;
	private static QuocGia_DAO QG_dao;
	private static List<LoaiThuoc> lstLT;
	private static LoaiThuoc_DAO LT_dao;
	private static List<DonViTinh> lstDV;
	private static DonViTinh_DAO DV_dao;
	private static Thuoc_DAO th_DAO;

	/**
	 * Create the frame.
	 */
	public Thuoc_ADD_GUI() {

		ConnectDB.getInstance().connect();
		th_DAO = new Thuoc_DAO();
		NSX_dao = new NhaSanXuat_DAO();
		LT_dao = new LoaiThuoc_DAO();
		DV_dao = new DonViTinh_DAO();
		QG_dao = new QuocGia_DAO();
		DocDLDB();
		
		setTitle("Th\u00EAm M\u1EDBi");
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 520);
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

		JLabel lblQLSP = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblQLSP.setToolTipText("QUẢN LÝ SẢN PHẨM");
		lblQLSP.setForeground(Color.BLUE);
		lblQLSP.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQLSP.setBackground(Color.WHITE);
		horizontalBox.add(lblQLSP);

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
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 474, 324);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNameSp = new JLabel("Tên sản phẩm:");
		lblNameSp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameSp.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNameSp.setBounds(10, 28, 106, 24);
		panel_1.add(lblNameSp);

		txtNameSp = new JTextField();
		txtNameSp.setBounds(126, 28, 280, 24);
		panel_1.add(txtNameSp);
		txtNameSp.setColumns(10);

		JLabel lblMaSp = new JLabel("Mã sản phẩm:");
		lblMaSp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaSp.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMaSp.setBounds(10, 63, 106, 24);
		panel_1.add(lblMaSp);

		txtmasp = new JTextField();
		//txtmasp.setEditable(false);
		txtmasp.setColumns(10);
		txtmasp.setBounds(126, 63, 127, 24);
		panel_1.add(txtmasp);

		JLabel lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoLuong.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSoLuong.setBounds(254, 63, 77, 24);
		panel_1.add(lblSoLuong);

		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(341, 63, 65, 24);
		panel_1.add(txtSoLuong);

		cboNgH = new JComboBox();
		cboNgH.setBackground(Color.WHITE);
		cboNgH.setBounds(126, 98, 280, 24);
		cboNgH.setFocusable(false);
		panel_1.add(cboNgH);

		JLabel lblNgH = new JLabel("Loại thuốc:");
		lblNgH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgH.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNgH.setBounds(10, 98, 106, 24);
		panel_1.add(lblNgH);

		JLabel lblNSX = new JLabel("Nhà sản xuất:");
		lblNSX.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNSX.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNSX.setBounds(10, 132, 106, 24);
		panel_1.add(lblNSX);

		JLabel lblNuocSX = new JLabel("Nước sản xuất:");
		lblNuocSX.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNuocSX.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNuocSX.setBounds(10, 169, 106, 24);
		panel_1.add(lblNuocSX);

		JLabel lblDVT = new JLabel("Đơn vị tính:");
		lblDVT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDVT.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDVT.setBounds(10, 216, 106, 24);
		panel_1.add(lblDVT);

		cboNSX = new JComboBox();
		cboNSX.setBackground(Color.WHITE);
		cboNSX.setBounds(126, 132, 280, 24);
		cboNSX.setFocusable(false);
		//cboNSX.addItem("United International Pharma");
		panel_1.add(cboNSX);

		cboNuocSX = new JComboBox();
		cboNuocSX.setBackground(Color.WHITE);
		cboNuocSX.setBounds(126, 169, 280, 24);
		cboNuocSX.setFocusable(false);
		panel_1.add(cboNuocSX);

		cboDVT = new JComboBox();
		cboDVT.setBackground(Color.WHITE);
		cboDVT.setBounds(126, 216, 280, 24);
		cboDVT.setFocusable(false);
		panel_1.add(cboDVT);

		//		model = new DefaultTableModel() {
		//			public Class<?> getColumnClass(int column) {
		//				switch (column) {
		//				case 0:
		//					return Boolean.class;
		//				case 1:
		//					return String.class;
		//				default:
		//					return String.class;
		//				}
		//			}
		//		};
		//		model.addColumn("Chọn");
		//		model.addColumn("Điều kiện bảo quản");

		JButton btnSearchHC = new JButton("");
		btnSearchHC.setIcon(new ImageIcon("data\\icons\\search1.png"));
		btnSearchHC.setBackground(Color.WHITE);
		btnSearchHC.setBorder(null);
		btnSearchHC.setFocusPainted(false);
		btnSearchHC.setBounds(442, 133, 16, 23);
		panel_1.add(btnSearchHC);

		JButton btnSearchNSX = new JButton("");
		btnSearchNSX.setIcon(new ImageIcon("data\\icons\\search1.png"));
		btnSearchNSX.setBorder(null);
		btnSearchNSX.setBackground(Color.WHITE);
		btnSearchNSX.setFocusPainted(false);
		btnSearchNSX.setBounds(442, 169, 16, 23);
		panel_1.add(btnSearchNSX);

		JButton btnSearchNuocSX = new JButton("");
		btnSearchNuocSX.setIcon(new ImageIcon("data\\icons\\search1.png"));
		btnSearchNuocSX.setBorder(null);
		btnSearchNuocSX.setBackground(Color.WHITE);
		btnSearchNuocSX.setFocusPainted(false);
		btnSearchNuocSX.setBounds(442, 204, 16, 23);
		panel_1.add(btnSearchNuocSX);

		JButton btnSearchDVT = new JButton("");
		btnSearchDVT.setIcon(new ImageIcon("data\\icons\\search1.png"));
		btnSearchDVT.setBorder(null);
		btnSearchDVT.setBackground(Color.WHITE);
		btnSearchDVT.setFocusPainted(false);
		btnSearchDVT.setBounds(442, 239, 16, 23);
		panel_1.add(btnSearchDVT);

		JButton btnAddNgH = new JButton("");
		btnAddNgH.setIcon(new ImageIcon("data\\icons\\add.png"));
		//button_6.setFocusPainted(false);
		btnAddNgH.setFocusable(false);
		btnAddNgH.setBorder(null);
		btnAddNgH.setBackground(Color.WHITE);
		btnAddNgH.setBounds(416, 99, 16, 23);
		panel_1.add(btnAddNgH);

		JButton btnAddHC = new JButton("");
		btnAddHC.setIcon(new ImageIcon("data\\icons\\add.png"));
		btnAddHC.setFocusPainted(false);
		btnAddHC.setBorder(null);
		btnAddHC.setBackground(Color.WHITE);
		btnAddHC.setBounds(416, 134, 16, 23);
		panel_1.add(btnAddHC);

		JButton btnAddNSX = new JButton("");
		btnAddNSX.setIcon(new ImageIcon("data\\icons\\add.png"));
		btnAddNSX.setFocusPainted(false);
		btnAddNSX.setBorder(null);
		btnAddNSX.setBackground(Color.WHITE);
		btnAddNSX.setBounds(416, 169, 16, 23);
		panel_1.add(btnAddNSX);

		JButton btnAddDVT = new JButton("");
		btnAddDVT.setIcon(new ImageIcon("data\\icons\\add.png"));
		btnAddDVT.setFocusPainted(false);
		btnAddDVT.setBorder(null);
		btnAddDVT.setBackground(Color.WHITE);
		btnAddDVT.setBounds(416, 239, 16, 23);
		panel_1.add(btnAddDVT);

		JButton btnAddNuocSX = new JButton("");
		btnAddNuocSX.setIcon(new ImageIcon("data\\icons\\add.png"));
		btnAddNuocSX.setFocusPainted(false);
		btnAddNuocSX.setBorder(null);
		btnAddNuocSX.setBackground(Color.WHITE);
		btnAddNuocSX.setBounds(416, 204, 16, 23);
		panel_1.add(btnAddNuocSX);

		JButton btnSearchNgH = new JButton("");
		btnSearchNgH.setIcon(new ImageIcon("data\\icons\\search1.png"));
		btnSearchNgH.setFocusPainted(false);
		btnSearchNgH.setBorder(null);
		btnSearchNgH.setBackground(Color.WHITE);
		btnSearchNgH.setBounds(442, 99, 16, 23);
		panel_1.add(btnSearchNgH);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Th\u00F4ng tin gi\u00E1 (C\u00F3 th\u1EC3 c\u1EADp nh\u1EADt th\u00F4ng tin gi\u00E1 khi nh\u1EADp h\u00E0ng)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(494, 11, 319, 110);
		panel.add(panel_4);
		panel_4.setLayout(null);

		txtGiaBan = new JTextField();
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(94, 34, 186, 24);
		txtGiaBan.setHorizontalAlignment(JTextField.RIGHT);
		//txtGiaBan.setFocusable(false);
		txtGiaBan.setForeground(Color.BLACK);
		panel_4.add(txtGiaBan);

		JLabel lblGiaLe = new JLabel("Giá bán:");
		lblGiaLe.setHorizontalAlignment(SwingConstants.LEFT);
		lblGiaLe.setFont(new Font("Arial", Font.PLAIN, 12));
		lblGiaLe.setBounds(20, 34, 64, 24);
		panel_4.add(lblGiaLe);

		JLabel lblGhiChu = new JLabel("Ghi chú:");
		lblGhiChu.setHorizontalAlignment(SwingConstants.LEFT);
		lblGhiChu.setFont(new Font("Arial", Font.PLAIN, 12));
		lblGhiChu.setBounds(494, 132, 48, 24);
		panel.add(lblGhiChu);

		txaMoTa = new TextArea();
		txaMoTa.setBackground(Color.WHITE);
		txaMoTa.setBounds(490, 162, 319, 120);
		panel.add(txaMoTa);

		JButton btnExit = new JButton("Bỏ qua");
		btnExit.setIcon(new ImageIcon("data\\icons\\back.png"));
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(702, 356, 111, 37);
		btnExit.setFocusPainted(false);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		panel.add(btnExit);

		JButton btnSave = new JButton("Lưu");
		btnSave.setIcon(new ImageIcon("data\\icons\\save1.png"));
		btnSave.setBackground(Color.WHITE);
		btnSave.setBounds(581, 356, 111, 37);
		btnSave.setFocusPainted(false);
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (kTraDinhDang()) {
					String maThuoc, tenThuoc, tenLoaiThuoc, tenNSX,quocGia,donViTinh, moTa;
					Float giaBan;
					int soLuong;
					maThuoc = txtmasp.getText().trim();
					tenThuoc = txtNameSp.getText().trim();
					tenLoaiThuoc = cboNgH.getSelectedItem().toString().trim();
					tenNSX = cboNSX.getSelectedItem().toString().trim();
					quocGia = cboNuocSX.getSelectedItem().toString().trim();
					donViTinh = cboDVT.getSelectedItem().toString().trim();
					moTa = txaMoTa.getText().trim();
					giaBan = Float.valueOf(txtGiaBan.getText().trim());
					soLuong = Integer.valueOf(txtSoLuong.getText().trim());
					Thuoc t = new Thuoc(maThuoc, tenThuoc, giaBan, soLuong, moTa, getNSX(tenNSX), getLT(tenLoaiThuoc), getDV(donViTinh), getQG(quocGia));
					try {
						if(!th_DAO.themThuoc(t))
							throw new Exception();
						Thuoc_GUI.updateDL();
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
						dispose();		
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Thêm không thành công!!");
					}
				}
			}
		});
		panel.add(btnSave);

		JLabel label_1 = new JLabel("Số lượng cảnh báo:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(494, 301, 125, 24);
		panel.add(label_1);

		txtSLcanhBao = new JTextField();
		txtSLcanhBao.setText("30");
		txtSLcanhBao.setColumns(10);
		txtSLcanhBao.setBounds(616, 301, 46, 24);
		panel.add(txtSLcanhBao);
		
		updateDLCbo();
	}
	private static void DocDLDB() {
		lstNSX = NSX_dao.docTuBang();
		lstLT = LT_dao.getAllLoaiThuoc();
		lstDVT = DV_dao.getalltbDVT();
		lstQG = QG_dao.getAllQuocGia();
	}
	private static void updateDLCbo() {
		
		
		cboNSX.removeAllItems();
		cboNgH.removeAllItems();
		cboDVT.removeAllItems();
		cboNuocSX.removeAllItems();
		

		for(NhaSanXuat nsx : lstNSX) {
			cboNSX.addItem(nsx.getTenNSX().trim());
		}
		for(LoaiThuoc ng : lstLT) {
			cboNgH.addItem(ng.getTenLoaiThuoc().trim());
		}
		for(DonViTinh dvt:lstDVT) {
			cboDVT.addItem(dvt.getTenDonVi().trim());
		}
		for(QuocGia qg : lstQG) {
			cboNuocSX.addItem(qg.getTenQuocGia().trim());
		}
		cboNSX.setSelectedIndex(-1);
		cboNgH.setSelectedIndex(-1);
		cboNuocSX.setSelectedIndex(-1);
		cboDVT.setSelectedIndex(-1);
	}

	private boolean kTraDinhDang() {
		String tenThuoc = txtNameSp.getText();
		String soLuong = txtSoLuong.getText();
		String giaBan = txtGiaBan.getText();
		if (tenThuoc.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Tên thuốc không được để trống!");
			txtNameSp.requestFocus();
			txtNameSp.selectAll();
			return false;
		} else if (soLuong.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Số lượng không được để trống!");
			txtSoLuong.requestFocus();
			txtSoLuong.selectAll();
			return false;
		} else if (giaBan.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Giá bán không được để trống!");
			txtGiaBan.requestFocus();
			txtGiaBan.selectAll();
			return false;
		} else if (!tenThuoc.matches("^[\\p{L}0-9 ]+$")) { // Giới hạn kí tự điền vào tên là 2-25 kí tự!
			JOptionPane.showMessageDialog(this, "Vui lòng điền tên chính xác!");
			txtNameSp.requestFocus();
			txtNameSp.selectAll();
			return false;
		} else if (!soLuong.matches("[0-9]+$")) {
			JOptionPane.showMessageDialog(this, "Số lượng phải là số!");
			txtSoLuong.requestFocus();
			txtSoLuong.selectAll();
			return false;
		} else if (!giaBan.matches("[0-9.]+$")) {
			JOptionPane.showMessageDialog(this, "Giá bán phải là số !");
			txtGiaBan.requestFocus();
			txtGiaBan.selectAll();
			return false;
		}
		Double donGia;
		int so;
		donGia = Double.valueOf(txtGiaBan.getText());
		so = Integer.valueOf(txtSoLuong.getText());
		if (so < 0) {
			JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn hoặc bằng 0 !");
			txtSoLuong.requestFocus();
			txtSoLuong.selectAll();
			return false;
		}
		if (donGia < 0) {
			JOptionPane.showMessageDialog(this, "Giá bán phải hơn hoặc bằng 0 !");
			txtGiaBan.requestFocus();
			txtGiaBan.selectAll();
			return false;
		}
		return true;

	}
	private static String getNSX(String ten) {
		for(NhaSanXuat s : lstNSX) {
			if(s.getTenNSX().trim().equalsIgnoreCase(ten.trim())) {
				return s.getMaNSX().trim();
			}
		}
		return "";
	}
	private static String getDV(String ten) {
		for(DonViTinh s : lstDVT) {
			if(s.getTenDonVi().trim().equalsIgnoreCase(ten.trim())) {
				return s.getMaDV().trim();
			}
		}
		return "";
	}
	private static String getLT(String ten) {
		for(LoaiThuoc s : lstLT) {
			if(s.getTenLoaiThuoc().trim().equalsIgnoreCase(ten.trim())) {
				return s.getMaLoai().trim();
			}
		}
		return "";
	}
	private static String getQG(String ten) {
		for(QuocGia s : lstQG) {
			if(s.getTenQuocGia().trim().equalsIgnoreCase(ten.trim())) {
				return s.getMaQG().trim();
			}
		}
		return "";
	}
}
