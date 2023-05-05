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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.Properties;

import javax.swing.Box;
import javax.swing.ButtonGroup;

import java.awt.Color;
import javax.swing.border.MatteBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import class_DAO.KhachHang_DAO;
import class_connectDB.ConnectDB;
import class_entity.KhachHang;
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

public class KhachHang_EDIT_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaKH;
	private JTextField txtHoTen;
	private JTextField txtLoaiKH;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtngaySinh;
	private JTextField txtCMND;
	private JTextField txtTinhTP;
	private JTextField txtQH;
	private JRadioButton radNu;
	private JRadioButton radNam;
	private KhachHang_DAO kh_DAO;
	private ButtonGroup rb;
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	private DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private Properties p;
	private UtilDateModel model1;
	private JDatePanelImpl datePanel1;
	private JDatePickerImpl datePicker1;
	
	private static String makh1;
	/**
	 * Launch the application.
	 */
	public static void NewScreen(String makh) {
		makh1 = makh;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHang_EDIT_GUI frame = new KhachHang_EDIT_GUI();
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
	public KhachHang_EDIT_GUI() {
		ConnectDB.getInstance().connect();
		kh_DAO = new KhachHang_DAO();
		
		setBackground(Color.WHITE);
		setTitle("Cập nhật khách hàng");
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 676, 483);
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
		
		JLabel lblThngTinKhch = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblThngTinKhch.setToolTipText("THÔNG TIN KHÁCH HÀNG");
		lblThngTinKhch.setForeground(Color.BLUE);
		lblThngTinKhch.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThngTinKhch.setBackground(Color.WHITE);
		horizontalBox.add(lblThngTinKhch);
		
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
		panel_1.setBounds(10, 11, 629, 301);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(111, 34, 173, 27);
		panel_1.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lblMaKH = new JLabel("Mã KH:");
		lblMaKH.setToolTipText("Mã KH:");
		lblMaKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaKH.setBounds(10, 34, 91, 27);
		panel_1.add(lblMaKH);
		
		JLabel lblHVTn = new JLabel("Tên khách hàng:");
		lblHVTn.setToolTipText("Tên khách hàng");
		lblHVTn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHVTn.setBounds(10, 72, 91, 27);
		panel_1.add(lblHVTn);
		
		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(111, 72, 173, 27);
		panel_1.add(txtHoTen);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(331, 148, 237, 27);
		panel_1.add(txtDiaChi);
		
		txtTinhTP = new JTextField();
		txtTinhTP.setBackground(Color.WHITE);
		txtTinhTP.setBounds(111, 186, 173, 27);
		panel_1.add(txtTinhTP);
		
		txtQH = new JTextField();
		txtQH.setBackground(Color.WHITE);
		txtQH.setBounds(395, 186, 173, 27);
		panel_1.add(txtQH);
		
		JTextArea txaGhiChu = new JTextArea();
		txaGhiChu.setLineWrap(true);
		txaGhiChu.setWrapStyleWord(true);
		txaGhiChu.setBackground(SystemColor.controlHighlight);
		txaGhiChu.setBounds(111, 225, 457, 64);
		panel_1.add(txaGhiChu);
		
		JLabel lblinThoi = new JLabel("Điện thoại:");
		lblinThoi.setToolTipText("Điện thoại");
		lblinThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblinThoi.setBounds(10, 110, 91, 27);
		panel_1.add(lblinThoi);
		
		JLabel lblSCmnd = new JLabel("Số CMND:");
		lblSCmnd.setToolTipText("Số CMND");
		lblSCmnd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSCmnd.setBounds(294, 110, 91, 27);
		panel_1.add(lblSCmnd);
		
		JLabel lblNgySinh = new JLabel("Ngày sinh:");
		lblNgySinh.setToolTipText("Ngày sinh");
		lblNgySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgySinh.setBounds(294, 72, 91, 27);
		panel_1.add(lblNgySinh);
		
		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setToolTipText("Địa chỉ");
		lblaCh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblaCh.setBounds(256, 148, 65, 27);
		panel_1.add(lblaCh);
		
		JLabel lblTinhTP = new JLabel("Tỉnh/TP:");
		lblTinhTP.setToolTipText("Tỉnh/TP");
		lblTinhTP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTinhTP.setBounds(10, 186, 91, 28);
		panel_1.add(lblTinhTP);
		
		JLabel lblGhiCh = new JLabel("Ghi chú:");
		lblGhiCh.setToolTipText("Ghi chú");
		lblGhiCh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGhiCh.setBounds(10, 224, 91, 27);
		panel_1.add(lblGhiCh);
		
		JLabel lblQun = new JLabel("Quận/Huyện:");
		lblQun.setToolTipText("Quận/Huyện");
		lblQun.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQun.setBounds(294, 186, 91, 27);
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
		datePicker1.setBounds(395, 72, 173, 27);
		datePicker1.setFocusable(false);
		panel_1.add(datePicker1);
		//panel_1.add(txtNgaySinh);
		
		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(395, 110, 173, 27);
		panel_1.add(txtCMND);
		
		rb = new ButtonGroup();
		
		radNu = new JRadioButton("  Nữ");
		radNu.setBackground(Color.WHITE);
		radNu.setBounds(185, 148, 65, 27);
		radNu.setFocusable(false);
		panel_1.add(radNu);
		
		radNam = new JRadioButton("  Nam");
		radNam.setBackground(Color.WHITE);
		radNam.setBounds(107, 148, 76, 27);
		radNam.setFocusable(false);
		radNam.setSelected(true);
		
		rb.add(radNam);
		rb.add(radNu);
		
		panel_1.add(radNam);
		
		JLabel label_1 = new JLabel("Giới tính:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(10, 148, 91, 27);
		panel_1.add(label_1);
		
		JLabel lblLoaiKH = new JLabel("Loại KH:");
		lblLoaiKH.setToolTipText("");
		lblLoaiKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoaiKH.setBounds(294, 34, 91, 27);
		panel_1.add(lblLoaiKH);
		
		txtLoaiKH = new JTextField();
		txtLoaiKH.setColumns(10);
		txtLoaiKH.setBounds(395, 34, 173, 27);
		panel_1.add(txtLoaiKH);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(validData()) {
					String maKH = txtMaKH.getText().trim();
					String maLoaiKH = txtLoaiKH.getText().trim();
					String tenKH = txtHoTen.getText().trim();
					String gioiTinh;
					Date ngaySinh = Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth() + 1, model1.getDay()));	
					//String soCMND;
					String soCMND = txtCMND.getText().trim();
					String diaChi = txtDiaChi.getText().trim();
					String tinh_TP = txtTinhTP.getText().trim();
					String quan_Huyen = txtQH.getText().trim();
					
					if(radNam.isSelected())
						gioiTinh="Nam";
					else
						gioiTinh="Nữ";
				
					String sdt = txtSDT.getText().trim();
					String ghiChu = txaGhiChu.getText().trim();
					KhachHang kh =  new KhachHang(maKH, maLoaiKH, tenKH, gioiTinh, ngaySinh, soCMND, diaChi, tinh_TP, quan_Huyen, sdt, ghiChu);
					try {
						if(!kh_DAO.update(kh))
							throw new Exception();
						KhachHang_GUI.updateDL();
						JOptionPane.showMessageDialog(null, "Sửa thành công!");
						dispose();		
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Sửa không thành công!");
					}
				}
			
			}
		});
		btnLuu.setIcon(new ImageIcon("data\\icons\\save1.png"));
		btnLuu.setToolTipText("Lưu");
		btnLuu.setFocusable(false);
		btnLuu.setBackground(Color.WHITE);
		btnLuu.setBounds(382, 323, 123, 39);
		panel.add(btnLuu);
		
		JButton btnDong = new JButton("Đóng");
		btnDong.setIcon(new ImageIcon("data\\icons\\exit1.png"));
		btnDong.setToolTipText("Đóng");
		btnDong.setFocusable(false);
		btnDong.setBackground(Color.WHITE);
		btnDong.setBounds(515, 323, 124, 39);
		btnDong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		panel.add(btnDong);
		docDLfromTable();
	}
	
	private boolean validData() {
		String tenKH = txtHoTen.getText().trim();
		int ngaySinh = model1.getYear();
		String soCMND = txtCMND.getText().trim();
		String sdt = txtSDT.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		String tinhtp = txtTinhTP.getText().trim();
		String quanhuyen = txtQH.getText().trim();

		if (tenKH.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Tên khách hàng không được rỗng!");
			txtHoTen.requestFocus();
			txtHoTen.selectAll();
			return false;
		} else if (!tenKH.matches("^[\\p{L} ]+$")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tên chính xác!");
			txtHoTen.requestFocus();
			txtHoTen.selectAll();
			return false;
		} else if (soCMND.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "CCCD/CMND không được trống!");
			txtCMND.requestFocus();
			txtCMND.selectAll();
			return false;
		} else if (!soCMND.matches("[0-9]{9}") && !soCMND.matches("[0-9]{12}")) {
			JOptionPane.showMessageDialog(this, "CCCD phải là số có 12 chữ số / CMND phải là số có 9 chữ số!");
			txtCMND.requestFocus();
			txtCMND.selectAll();
			return false;
		} else if (sdt.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được trống!");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		} else if (!sdt.matches("[0-9]{10}")) {
			JOptionPane.showMessageDialog(this, "Định dạng số điện thoại không đúng! \\n( phải có 10 chữ số và bắt đầu bằng số 0. Vd: 0339xxxxxx)!");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		} else if (diaChi.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được trống!");
			txtDiaChi.requestFocus();
			txtDiaChi.selectAll();
			return false;
		}  else if (tinhtp.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Tỉnh/TP không được trống!");
			txtTinhTP.requestFocus();
			txtTinhTP.selectAll();
			return false;
		}  else if (quanhuyen.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Quận huyện không được trống!");
			txtQH.requestFocus();
			txtQH.selectAll();
			return false;
		}	else if (ngaySinh >= 2003) {
			JOptionPane.showMessageDialog(this, "Tuổi không được dưới 16!");
			txtQH.requestFocus();
			txtQH.selectAll();
			return false;
		}
		return true;
	}
	private void docDLfromTable() {
		for(KhachHang s : KhachHang_GUI.lqlkh) {
			if(s.getMaKH().trim().equalsIgnoreCase(makh1.trim())) {
				txtMaKH.setText(s.getMaKH().trim());
				txtLoaiKH.setText(s.getMaLoaiKH().trim());
				txtHoTen.setText(s.getTenKH().trim());
				model1.setValue(s.getNgaySinh());
				txtCMND.setText(s.getSoCMND().trim());
				txtDiaChi.setText(s.getDiaChi().trim());
				txtTinhTP.setText(s.getTinh_TP().trim());
				txtQH.setText(s.getQuan_Huyen().trim());
				txtSDT.setText(s.getSdt().trim());
				if(s.getGioiTinh().trim().equalsIgnoreCase("Nam"))
					radNam.setSelected(true);
				else
					radNu.setSelected(true);
				break;
			}			
		}		
	}
}
