package class_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.swing.Box;
import javax.swing.ButtonGroup;

import java.awt.Color;
import javax.swing.border.MatteBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import class_DAO.DangNhap_DAO;
import class_DAO.KhachHang_DAO;
import class_DAO.QuanLyNV_DAO;
import class_connectDB.ConnectDB;
import class_entity.DangNhap;
import class_entity.KhachHang;
import class_entity.NhanVien;
import class_equipment.DateLabelFormatter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.SpringLayout;

public class NhanVien_EDIT_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtHoTen;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtNgaySinh;
	private JTextField txtCMND;
	private JTextField txtTinhTP;
	private JTextField txtQH;
	private JRadioButton radNu;
	private JRadioButton radNam;
	private QuanLyNV_DAO qlnv_DAO;
	private static DangNhap_DAO dn_DAO;
	private ButtonGroup rb;
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	private DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private Properties p;
	private UtilDateModel model1;
	private JDatePanelImpl datePanel1;
	private JDatePickerImpl datePicker1;
	private UtilDateModel model2;
	private JDatePanelImpl datePanel2;
	private JDatePickerImpl datePicker2;
	private JTextField txtEmail;
	private JTextField txtChucVu;
	private JRadioButton radTT;
	private JComboBox cboChucVu;
	private static String manv1;
	private static int thongtin1;
	/**
	 * Launch the application.
	 */
//	public static void NewScreen(String manv, int thongtin) {
//		manv1 = manv;
//		thongtin1 = thongtin;
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NhanVien_EDIT_GUI frame = new NhanVien_EDIT_GUI();
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
	public NhanVien_EDIT_GUI(String manv, int thongtin) {
		
		manv1 = manv;
		thongtin1 = thongtin;
		
		ConnectDB.getInstance().connect();
		qlnv_DAO = new QuanLyNV_DAO();
		dn_DAO = new DangNhap_DAO();
		
		setBackground(Color.WHITE);
		setTitle("Cập nhật nhân viên");
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 676, 494);
		setLocationRelativeTo(null);
		setResizable(false);
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
		
		JLabel lblThongtinnv = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblThongtinnv.setToolTipText("");
		lblThongtinnv.setForeground(Color.BLUE);
		lblThongtinnv.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongtinnv.setBackground(Color.WHITE);
		horizontalBox.add(lblThongtinnv);
		
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
		panel_1.setBounds(10, 11, 629, 312);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtMaNV = new JTextField();
		txtMaNV.setBounds(111, 34, 457, 27);
		txtMaNV.setEditable(false);
		panel_1.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		JLabel lblMaNV = new JLabel("Mã NV:");
		lblMaNV.setToolTipText("");
		lblMaNV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaNV.setBounds(10, 34, 91, 27);
		panel_1.add(lblMaNV);
		
		JLabel lblHVTn = new JLabel("H\u1ECD v\u00E0 t\u00EAn:");
		lblHVTn.setToolTipText("H\u1ECD v\u00E0 t\u00EAn");
		lblHVTn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHVTn.setBounds(10, 72, 91, 27);
		panel_1.add(lblHVTn);
		
		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(111, 72, 173, 27);
		panel_1.add(txtHoTen);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(111, 148, 457, 27);
		panel_1.add(txtDiaChi);
		
		txtTinhTP = new JTextField();
		txtTinhTP.setBackground(Color.WHITE);
		txtTinhTP.setBounds(111, 224, 173, 27);
		panel_1.add(txtTinhTP);
		
		txtQH = new JTextField();
		txtQH.setBackground(Color.WHITE);
		txtQH.setBounds(395, 224, 173, 27);
		panel_1.add(txtQH);
		
		JLabel lblinThoi = new JLabel("\u0110i\u1EC7n tho\u1EA1i:");
		lblinThoi.setToolTipText("\u0110i\u1EC7n tho\u1EA1i");
		lblinThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblinThoi.setBounds(10, 110, 91, 27);
		panel_1.add(lblinThoi);
		
		JLabel lblSCmnd = new JLabel("S\u1ED1 CMND:");
		lblSCmnd.setToolTipText("S\u1ED1 CMND");
		lblSCmnd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSCmnd.setBounds(294, 186, 91, 27);
		panel_1.add(lblSCmnd);
		
		JLabel lblNgaySinh = new JLabel("Ng\u00E0y sinh:");
		lblNgaySinh.setToolTipText("Ng\u00E0y sinh");
		lblNgaySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgaySinh.setBounds(294, 72, 91, 27);
		panel_1.add(lblNgaySinh);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblaCh.setToolTipText("\u0110\u1ECBa ch\u1EC9");
		lblaCh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblaCh.setBounds(36, 148, 65, 27);
		panel_1.add(lblaCh);
		
		JLabel lblTinhTP = new JLabel("T\u1EC9nh/TP:");
		lblTinhTP.setToolTipText("T\u1EC9nh/TP");
		lblTinhTP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTinhTP.setBounds(10, 224, 91, 28);
		panel_1.add(lblTinhTP);
		
		JLabel lblQun = new JLabel("Qu\u1EADn/Huy\u1EC7n:");
		lblQun.setToolTipText("Qu\u1EADn/Huy\u1EC7n");
		lblQun.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQun.setBounds(294, 224, 91, 27);
		panel_1.add(lblQun);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(111, 110, 173, 27);
		panel_1.add(txtSDT);

		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		model1 = new UtilDateModel();
		datePanel1 = new JDatePanelImpl(model1, p);
		datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		SpringLayout springLayout_1 = (SpringLayout) datePicker1.getLayout();
		springLayout_1.putConstraint(SpringLayout.SOUTH, datePicker1.getJFormattedTextField(), 0, SpringLayout.SOUTH, datePicker1);
		datePicker1.setBounds(395, 72, 173, 27);
		datePicker1.setFocusable(false);
		panel_1.add(datePicker1);

		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		model2 = new UtilDateModel();
		datePanel2 = new JDatePanelImpl(model2, p);
		datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		SpringLayout springLayout = (SpringLayout) datePicker2.getLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, datePicker2.getJFormattedTextField(), 0, SpringLayout.SOUTH, datePicker2);
		datePicker2.setBounds(395, 110, 173, 27);
		datePicker2.setFocusable(false);
		panel_1.add(datePicker2);
		
		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(395, 186, 173, 27);
		panel_1.add(txtCMND);
		
		rb = new ButtonGroup();
		
		radNu = new JRadioButton("  Nữ");
		radNu.setBackground(Color.WHITE);
		radNu.setBounds(185, 182, 65, 27);
		radNu.setFocusable(false);
		panel_1.add(radNu);
		
		radNam = new JRadioButton("  Nam");
		radNam.setBackground(Color.WHITE);
		radNam.setBounds(107, 182, 76, 27);
		radNam.setFocusable(false);
		radNam.setSelected(true);
		
		rb.add(radNam);
		rb.add(radNu);
		
		panel_1.add(radNam);
		
		JLabel label_1 = new JLabel("Giới tính:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(10, 182, 91, 27);
		panel_1.add(label_1);
		
		JLabel lblNVL = new JLabel("Ngày vào làm:");
		lblNVL.setToolTipText("");
		lblNVL.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNVL.setBounds(294, 110, 91, 27);
		panel_1.add(lblNVL);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setToolTipText("");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(10, 262, 91, 28);
		panel_1.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(111, 262, 173, 27);
		panel_1.add(txtEmail);
		
		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setToolTipText("");
		lblChucVu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChucVu.setBounds(294, 262, 91, 27);
		panel_1.add(lblChucVu);
		
		cboChucVu = new JComboBox();
		cboChucVu.setBackground(Color.WHITE);
		cboChucVu.setBounds(395, 262, 173, 27);
		cboChucVu.setFocusable(false);
		cboChucVu.addItem("Nhân Viên");
		cboChucVu.addItem("Quản Lí");
		cboChucVu.setSelectedIndex(-1);
		panel_1.add(cboChucVu);
		
		JButton btnLuu = new JButton("L\u01B0u");
		btnLuu.setIcon(new ImageIcon("data\\icons\\save1.png"));
		btnLuu.setToolTipText("L\u01B0u");
		btnLuu.setFocusable(false);
		btnLuu.setBackground(Color.WHITE);
		btnLuu.setBounds(380, 334, 123, 39);
		btnLuu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(kiemTraDinhDang()) {
					String maNV = txtMaNV.getText().trim(); 
					String tenNV = txtHoTen.getText().trim();
					String chucVu = cboChucVu.getSelectedItem().toString();
					String gioiTinh;
					if (radNam.isSelected())
						gioiTinh = "Nam";
					else
						gioiTinh = "Nữ";
					Date ngaySinh = Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth() + 1, model1.getDay()));
					Date ngayLamViec = Date.valueOf(LocalDate.of(model2.getYear(), model2.getMonth() + 1, model2.getDay()));
					String cMND = txtCMND.getText().trim();
					String diaChi = txtDiaChi.getText().trim();
					String quanHuyen = txtQH.getText().trim();
					String tinhTP = txtTinhTP.getText().trim();
					String email = txtEmail.getText().trim();
					String sdt = txtSDT.getText().trim();
					int tinhTrang;
					if(radTT.isSelected())
						tinhTrang=0;
					else
						tinhTrang=1;
					NhanVien nv = new NhanVien(maNV, tenNV, chucVu, gioiTinh, ngaySinh, ngayLamViec, cMND, diaChi, quanHuyen, tinhTP, email, sdt, tinhTrang);
					DangNhap dn;
					int quanLi;
					if(chucVu.trim().equals("Nhân Viên"))
						quanLi=0;
					else
						quanLi=1;
					dn = new DangNhap(maNV, "000000", quanLi);
					try {
						if(!qlnv_DAO.updateNV(nv))
							throw new Exception();
						else {
							if(!dn_DAO.updateCV(maNV, quanLi)) {
								throw new Exception();
							}
							if(thongtin1==1)
								NhanVien_GUI.updateDLall();
							else
								NhanVien_GUI.updateDL();
							JOptionPane.showMessageDialog(null, "Lưu thành công!");
							dispose();
						}
//						if(thongtin1==1)
//							NhanVien_GUI.updateDLall();
//						else
//							NhanVien_GUI.updateDL();
//						JOptionPane.showMessageDialog(null, "Lưu thành công!");
//						dispose();		
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Lưu không thành công!!");
					}
				}
				
			}
		});
		panel.add(btnLuu);
		
		JButton btnDong = new JButton("Đóng");
		btnDong.setIcon(new ImageIcon("data\\icons\\exit1.png"));
		btnDong.setToolTipText("\u0110\u00F3ng");
		btnDong.setFocusable(false);
		btnDong.setBackground(Color.WHITE);
		btnDong.setBounds(515, 334, 124, 39);
		btnDong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		panel.add(btnDong);
		
		JLabel lblTT = new JLabel("Tình trạng:");
		lblTT.setToolTipText("");
		lblTT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTT.setBounds(168, 340, 91, 27);
		panel.add(lblTT);
		
		radTT = new JRadioButton("Đã nghỉ");
		radTT.setBackground(Color.WHITE);
		radTT.setBounds(265, 342, 109, 23);
		radTT.setFocusable(false);
		panel.add(radTT);
		docDLfromTable();
		cboChucVu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Bạn chắc chắn muốn sửa chức vụ?");
			}
		});
	}
	private boolean kiemTraDinhDang() {
		String ma = txtMaNV.getText().trim();
		String ten = txtHoTen.getText().trim();
		int namSinh = model1.getYear();
		Date ngayLam = Date.valueOf(LocalDate.of(model2.getYear(), model2.getMonth() + 1, model2.getDay()));
		String cCCD = txtCMND.getText().trim();
		String sdt = txtSDT.getText().trim();
		String diachi = txtDiaChi.getText().trim();
		String email = txtEmail.getText().trim();
		// String ghi = txtghiChu.getText();
		if (ma.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Mã NV không được để trống!");
			txtMaNV.requestFocus();
			txtMaNV.selectAll();
			return false;
		} else if (!ma.matches("^NV[0-9]{3}$")) {
			JOptionPane.showMessageDialog(this, "Mã nhân viên có định dạng: NV + 3 kí tự số. Ví dụ: NV111,...");
			txtHoTen.requestFocus();
			txtHoTen.selectAll();
			return false;
		} else if (ten.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Tên NV không được để trống!");
			txtHoTen.requestFocus();
			txtHoTen.selectAll();
			return false;
		} else if (!ten.matches("^[\\p{L} ]+$")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tên chính xác!");
			txtHoTen.requestFocus();
			txtHoTen.selectAll();
			return false;
		} else if (cCCD.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "CCCD/CMND không được để trống!");
			txtCMND.requestFocus();
			txtCMND.selectAll();
			return false;
		} else if (!cCCD.matches("[0-9]{9}") && !cCCD.matches("[0-9]{12}")) {
			JOptionPane.showMessageDialog(this, "CCCD phải là số và có 12 số / CMND phải là số và có 9 số !");
			txtCMND.requestFocus();
			txtCMND.selectAll();
			return false;
		} else if (sdt.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được trống!");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		} else if (!sdt.matches("[0-9]{10}")) {
			JOptionPane.showMessageDialog(this, "Định dạng số điện thoại không đúng! \\n(Phải có 10 kí tự và bắt đầu bằng số 0. Vd: 0339xxxxxx)!");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		} else if (email.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Email không được để trống!");
			txtEmail.requestFocus();
			txtEmail.selectAll();
			return false;
		} else if (!email.matches("^([a-z0-9_])+@([\\da-z])+\\.([a-z\\.]{2,6})$")) {
			JOptionPane.showMessageDialog(this, "Email có định dạng: abc@xyz(.com hoặc .vn)!");
			txtEmail.requestFocus();
			txtEmail.selectAll();
			return false;
		} else if (diachi.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống!");
			txtDiaChi.requestFocus();
			txtDiaChi.selectAll();
			return false;
		} else if (!diachi.matches("^[\\p{L}0-9 -/]+$")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng địa chỉ!");
			txtDiaChi.requestFocus();
			txtDiaChi.selectAll();
			return false;
		} else if (namSinh >= 2002) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tuổi trên 18!");
			return false;
		} else if (ngayLam.after(Date.valueOf(LocalDate.now()))) {
			JOptionPane.showMessageDialog(this, "Ngày làm phải trước ngày hiện tại!");
			return false;
		}
		return true;
	}
	private void docDLfromTable() {
		txtMaNV.setText(manv1.trim());
		for(NhanVien s : NhanVien_GUI.lstnvall) {
			if(s.getMaNV().trim().equalsIgnoreCase(manv1.trim())) {
				txtHoTen.setText(s.getTenNV().trim());
				model1.setValue(s.getNgaySinh());
				model2.setValue(s.getNgayLamViec());
				txtSDT.setText(s.getSdt().trim());
				txtDiaChi.setText(s.getDiaChi().trim());
				if(s.getGioiTinh().trim().equalsIgnoreCase("Nam"))
					radNam.setSelected(true);
				else
					radNu.setSelected(true);
				txtCMND.setText(s.getcMND().trim());
				txtQH.setText(s.getQuanHuyen().trim());
				txtTinhTP.setText(s.getTinhTP().trim());
				txtEmail.setText(s.getEmail().trim());
				cboChucVu.setSelectedItem(s.getChuVu());
				if(s.getTinhTrang()==0)
					radTT.setSelected(true);
			}
		}	
	}
}
