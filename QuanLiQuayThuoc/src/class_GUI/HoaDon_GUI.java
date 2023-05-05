package class_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import class_DAO.CT_HoaDon_DAO;
import class_DAO.HoaDon_DAO;
import class_DAO.KhachHang_DAO;
import class_DAO.QuanLyNV_DAO;
import class_DAO.Thuoc_DAO;
import class_connectDB.ConnectDB;
import class_entity.CTHoaDon;
import class_entity.CTHoaDonCT;
import class_entity.HoaDon;
import class_entity.KhachHang;
import class_entity.NhanVien;
import class_entity.Thuoc;
import class_equipment.DateLabelFormatter;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;

public class HoaDon_GUI extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private Properties p;
	private UtilDateModel model1;
	private JDatePanelImpl datePanel1;
	private JDatePickerImpl datePicker1;
	private UtilDateModel model2;
	private JDatePanelImpl datePanel2;
	private JDatePickerImpl datePicker2;
	private JRadioButton rdbtnTC;
	private JRadioButton rdbtnDB;
	private JRadioButton rdbtnHuy;
	private static JComboBox cboNB;
	private static Thuoc_DAO thuoc_DAO;
	private static DefaultTableModel model;
	private static KhachHang_DAO kh_DAO;
	private static HoaDon_DAO hd_DAO;
	private static CT_HoaDon_DAO cthd_DAO;
	private static QuanLyNV_DAO nv_DAO;
	private static List<KhachHang> lkh;
	private static List<NhanVien> lnv;
	private static List<HoaDon> lhd;
	private static List<Thuoc> lth;
	private static List<CTHoaDon> lcthd;
	private static List<CTHoaDonCT> lcthdct;
	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	private static DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private static String signing1;
	public static DefaultTableModel[] modeladd;
	private String maDN1;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HoaDon_GUI frame = new HoaDon_GUI();
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
	public HoaDon_GUI(String maDN) {
		
		maDN1 = maDN;
		
		ConnectDB.getInstance().connect();
		kh_DAO = new KhachHang_DAO();
		nv_DAO = new QuanLyNV_DAO();
		hd_DAO = new HoaDon_DAO();
		cthd_DAO = new CT_HoaDon_DAO();
		thuoc_DAO = new Thuoc_DAO();
		DocDLDB();

		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setTitle("Quản lí hóa đơn bán hàng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 910, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 894, 561);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(0, 0, 894, 66);
		panel.add(horizontalBox);
		
		JLabel lblNewLabel_1 = new JLabel("   ");
		horizontalBox.add(lblNewLabel_1);
		
		JLabel lblTmKim = new JLabel("HÓA ĐƠN BÁN HÀNG");
		lblTmKim.setForeground(Color.BLUE);
		lblTmKim.setFont(new Font("Tahoma", Font.BOLD, 16));
		horizontalBox.add(lblTmKim);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon("data\\icons\\logo3.png"));
//		horizontalBox.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 77, 894, 478);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin t\u00ECm ki\u1EBFm (\u0111\u1EC3 tr\u1ED1ng ho\u1EB7c \u0111\u1EC3 gi\u00E1 tr\u1ECB m\u1EB7c \u0111\u1ECBnh cho c\u00E1c m\u1EE5c kh\u00F4ng c\u1EA7n th\u00F4ng tin chi ti\u1EBFt)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 11, 874, 119);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTNgy = new JLabel("Từ ngày:");
		lblTNgy.setForeground(Color.BLUE);
		lblTNgy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTNgy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTNgy.setBounds(21, 26, 94, 21);
		panel_2.add(lblTNgy);
		
		JLabel lblnNgy = new JLabel("Đến ngày:");
		lblnNgy.setForeground(Color.BLUE);
		lblnNgy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblnNgy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblnNgy.setBounds(402, 26, 64, 21);
		panel_2.add(lblnNgy);
		
		JLabel lblNgiBn = new JLabel("Người bán:");
		lblNgiBn.setForeground(Color.BLUE);
		lblNgiBn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgiBn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNgiBn.setBounds(50, 72, 64, 21);
		panel_2.add(lblNgiBn);
		
		JLabel lblTrngThiHa = new JLabel("Trạng thái hóa đơn:");
		lblTrngThiHa.setForeground(Color.BLUE);
		lblTrngThiHa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTrngThiHa.setBounds(360, 75, 116, 14);
		panel_2.add(lblTrngThiHa);
		
		ButtonGroup bt = new ButtonGroup();
		
		rdbtnTC = new JRadioButton("Tất cả");
		rdbtnTC.setForeground(Color.BLACK);
		rdbtnTC.setBackground(Color.WHITE);
		rdbtnTC.setBounds(499, 72, 64, 23);
		rdbtnTC.setFocusable(false);
		rdbtnTC.setSelected(true);
		rdbtnTC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model1.setSelected(false);
				model2.setSelected(false);
				//cboSP.setSelectedIndex(-1);
				cboNB.setSelectedIndex(-1);
				model.getDataVector().removeAllElements();
				for(CTHoaDonCT s : create()) {
					if(s.getTrangThai() == 2)
						model.addRow(new Object[] {		
							"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", ""
						});
					if(s.getTrangThai() == 1)
						model.addRow(new Object[] {		
							"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"X", ""
						});
					if(s.getTrangThai() == 0)
						model.addRow(new Object[] {		
								"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", "X"
						});
	
				}
				table.setModel(model);
			}
		});
		panel_2.add(rdbtnTC);
		
		rdbtnDB = new JRadioButton("Đã bán");
		rdbtnDB.setBackground(Color.WHITE);
		rdbtnDB.setBounds(565, 72, 74, 23);
		rdbtnDB.setFocusable(false);
		rdbtnDB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model1.setSelected(false);
				model2.setSelected(false);
				//cboSP.setSelectedIndex(-1);
				cboNB.setSelectedIndex(-1);
				model.getDataVector().removeAllElements();
				int dem=0;
				for(CTHoaDonCT s : create()) {
					if(s.getTrangThai() == 2) {
						dem++;
						model.addRow(new Object[] {		
								"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", ""
						});
					}
						
	
				}
				if(dem==0) {
					model.getDataVector().removeAllElements();
					model.addRow(new Object[] {	});
					table.setModel(model);
				}		
				else
					table.setModel(model);
			}
		});
		panel_2.add(rdbtnDB);
		
		rdbtnHuy = new JRadioButton("Hủy");
		rdbtnHuy.setBackground(Color.WHITE);
		rdbtnHuy.setBounds(641, 72, 54, 23);
		rdbtnHuy.setFocusable(false);
		rdbtnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model1.setSelected(false);
				model2.setSelected(false);
				//cboSP.setSelectedIndex(-1);
				cboNB.setSelectedIndex(-1);
				model.getDataVector().removeAllElements();
				int dem=0;
				for(CTHoaDonCT s : create()) {
					if(s.getTrangThai() == 0) {
						dem++;
						model.addRow(new Object[] {		
								"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", "X"
						});
					}
				}
				if(dem==0) {
					model.getDataVector().removeAllElements();
					model.addRow(new Object[] {	});
					table.setModel(model);
				}		
				else
					table.setModel(model);
			}
		});
		panel_2.add(rdbtnHuy);
		
		bt.add(rdbtnTC);
		bt.add(rdbtnDB);
		bt.add(rdbtnHuy);
		
		cboNB = new JComboBox();
		cboNB.setBackground(Color.WHITE);
		cboNB.setBounds(136, 70, 196, 26);
		cboNB.setFocusable(false);
		panel_2.add(cboNB);
		
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		model1 = new UtilDateModel();
		datePanel1 = new JDatePanelImpl(model1, p);
		datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		datePicker1.setBounds(136, 26, 196, 26);
		datePicker1.setFocusable(false);
		panel_2.add(datePicker1);
		
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		model2 = new UtilDateModel();
		datePanel2 = new JDatePanelImpl(model2, p);
		datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		SpringLayout springLayout = (SpringLayout) datePicker2.getLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, datePicker2.getJFormattedTextField(), 0, SpringLayout.SOUTH, datePicker2);
		datePicker2.setBounds(499, 26, 196, 26);
		datePicker2.setFocusable(false);
		panel_2.add(datePicker2);
		
		JButton btnTimKiem = new JButton("Tìm");
		btnTimKiem.setIcon(new ImageIcon("data\\icons\\search2.png"));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.util.Date start = model1.getValue();
				java.util.Date end = model2.getValue();				
				if(start==null) {
					if(end==null) {
						if(cboNB.getSelectedItem()==null||cboNB.getSelectedItem().toString().equalsIgnoreCase("Không chọn")) {
							updateDL();
							JOptionPane.showMessageDialog(null, "Nhập thông tin tìm kiếm");
						}
						else {
							model.getDataVector().removeAllElements();
							int dem=0;
							if(rdbtnTC.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getHoTenNV().trim().equalsIgnoreCase(cboNB.getSelectedItem().toString().trim())) {
										dem++;
										if(s.getTrangThai() == 2)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", ""
												});
										if(s.getTrangThai() == 1)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"X", ""
												});
										if(s.getTrangThai() == 0)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", "X"
												});
									}	
								}
							}
							if(rdbtnDB.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getHoTenNV().trim().equalsIgnoreCase(cboNB.getSelectedItem().toString().trim())) {
										dem++;
										if(s.getTrangThai() == 2)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", ""
												});
									}	
								}
							}
							if(rdbtnHuy.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getHoTenNV().trim().equalsIgnoreCase(cboNB.getSelectedItem().toString().trim())) {
										dem++;
										if(s.getTrangThai() == 0)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", "X"
												});
									}	
								}
							}
							table.setModel(model);
							if(dem==0) {
								updateDL();
								JOptionPane.showMessageDialog(null, "Không tìm thấy!");
							}
						}
					}
					else {
						if(cboNB.getSelectedItem()==null||cboNB.getSelectedItem().toString().equalsIgnoreCase("Không chọn")) {
							model.getDataVector().removeAllElements();
							int dem=0;
							if(rdbtnTC.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getNgayLapHD().before(end)) {
										dem++;
										if(s.getTrangThai() == 2)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", ""
												});
										if(s.getTrangThai() == 1)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"X", ""
												});
										if(s.getTrangThai() == 0)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", "X"
												});
									}	
								}
							}
							if(rdbtnDB.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getNgayLapHD().before(end)) {
										dem++;
										if(s.getTrangThai() == 2)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", ""
												});
									}	
								}
							}
							if(rdbtnHuy.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getNgayLapHD().before(end)) {
										dem++;
										if(s.getTrangThai() == 0)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", "X"
												});
									}	
								}
							}
							table.setModel(model);
							if(dem==0) {
								updateDL();
								JOptionPane.showMessageDialog(null, "Không tìm thấy!");
							}
						}
						else {
							model.getDataVector().removeAllElements();
							int dem=0;
							if(rdbtnTC.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getNgayLapHD().before(end) && s.getHoTenNV().trim().equalsIgnoreCase(cboNB.getSelectedItem().toString().trim())) {
										dem++;
										if(s.getTrangThai() == 2)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", ""
												});
										if(s.getTrangThai() == 1)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"X", ""
												});
										if(s.getTrangThai() == 0)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", "X"
												});
									}	
								}
							}
							if(rdbtnDB.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getNgayLapHD().before(end)&&s.getHoTenNV().trim().equalsIgnoreCase(cboNB.getSelectedItem().toString().trim())) {
										dem++;
										if(s.getTrangThai() == 2)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", ""
												});
									}	
								}
							}
							if(rdbtnHuy.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getNgayLapHD().before(end)&&s.getHoTenNV().trim().equalsIgnoreCase(cboNB.getSelectedItem().toString().trim())) {
										dem++;
										if(s.getTrangThai() == 0)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", "X"
												});
									}	
								}
							}
							table.setModel(model);
							if(dem==0) {
								updateDL();
								JOptionPane.showMessageDialog(null, "Không tìm thấy!");
							}
						}	
					}
				}
				else {
					if(end==null) {
						if(cboNB.getSelectedItem()==null||cboNB.getSelectedItem().toString().equalsIgnoreCase("Không chọn")) {
							model.getDataVector().removeAllElements();
							int dem=0;
							if(rdbtnTC.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getNgayLapHD().after(start)) {
										dem++;
										if(s.getTrangThai() == 2)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", ""
												});
										if(s.getTrangThai() == 1)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"X", ""
												});
										if(s.getTrangThai() == 0)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", "X"
												});
									}	
								}
							}
							if(rdbtnDB.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getNgayLapHD().after(start)) {
										dem++;
										if(s.getTrangThai() == 2)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", ""
												});
									}	
								}
							}
							if(rdbtnHuy.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getNgayLapHD().after(start)) {
										dem++;
										if(s.getTrangThai() == 0)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", "X"
												});
									}	
								}
							}
							table.setModel(model);
							if(dem==0) {
								updateDL();
								JOptionPane.showMessageDialog(null, "Không tìm thấy!");
							}
						}
						else {
							model.getDataVector().removeAllElements();
							int dem=0;
							if(rdbtnTC.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getNgayLapHD().after(start)&&s.getHoTenNV().trim().equalsIgnoreCase(cboNB.getSelectedItem().toString().trim())) {
										dem++;
										if(s.getTrangThai() == 2)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", ""
												});
										if(s.getTrangThai() == 1)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"X", ""
												});
										if(s.getTrangThai() == 0)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", "X"
												});
									}	
								}
							}
							if(rdbtnDB.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getNgayLapHD().after(start)&&s.getHoTenNV().trim().equalsIgnoreCase(cboNB.getSelectedItem().toString().trim())) {
										dem++;
										if(s.getTrangThai() == 2)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", ""
												});
									}	
								}
							}
							if(rdbtnHuy.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getNgayLapHD().after(start)&&s.getHoTenNV().trim().equalsIgnoreCase(cboNB.getSelectedItem().toString().trim())) {
										dem++;
										if(s.getTrangThai() == 0)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", "X"
												});
									}	
								}
							}
							table.setModel(model);
							if(dem==0) {
								updateDL();
								JOptionPane.showMessageDialog(null, "Không tìm thấy!");
							}
						}
					}
					else {
						if(cboNB.getSelectedItem()==null||cboNB.getSelectedItem().toString().equalsIgnoreCase("Không chọn")) {
							model.getDataVector().removeAllElements();
							int dem=0;
							if(rdbtnTC.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getNgayLapHD().after(start)&&s.getNgayLapHD().before(end)) {
										dem++;
										if(s.getTrangThai() == 2)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", ""
												});
										if(s.getTrangThai() == 1)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"X", ""
												});
										if(s.getTrangThai() == 0)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", "X"
												});
									}	
								}
							}
							if(rdbtnDB.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getNgayLapHD().after(start)&&s.getNgayLapHD().before(end)) {
										dem++;
										if(s.getTrangThai() == 2)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", ""
												});
									}	
								}
							}
							if(rdbtnHuy.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getNgayLapHD().after(start)&&s.getNgayLapHD().before(end)) {
										dem++;
										if(s.getTrangThai() == 0)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", "X"
												});
									}	
								}
							}
							table.setModel(model);
							if(dem==0) {
								updateDL();
								JOptionPane.showMessageDialog(null, "Không tìm thấy!");
							}
						}
						else {
							model.getDataVector().removeAllElements();
							int dem=0;
							if(rdbtnTC.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getNgayLapHD().after(start)&&s.getNgayLapHD().before(end) && s.getHoTenNV().trim().equalsIgnoreCase(cboNB.getSelectedItem().toString().trim())) {
										dem++;
										if(s.getTrangThai() == 2)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", ""
												});
										if(s.getTrangThai() == 1)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"X", ""
												});
										if(s.getTrangThai() == 0)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", "X"
												});
									}	
								}
							}
							if(rdbtnDB.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getNgayLapHD().after(start)&&s.getNgayLapHD().before(end)&&s.getHoTenNV().trim().equalsIgnoreCase(cboNB.getSelectedItem().toString().trim())) {
										dem++;
										if(s.getTrangThai() == 2)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", ""
												});
									}	
								}
							}
							if(rdbtnHuy.isSelected()) {
								for(CTHoaDonCT s : create()) {
									if(s.getNgayLapHD().after(start)&&s.getNgayLapHD().before(end)&&s.getHoTenNV().trim().equalsIgnoreCase(cboNB.getSelectedItem().toString().trim())) {
										dem++;
										if(s.getTrangThai() == 0)
											model.addRow(new Object[] {		
												"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", "X"
												});
									}	
								}
							}
							table.setModel(model);
							if(dem==0) {
								updateDL();
								JOptionPane.showMessageDialog(null, "Không tìm thấy!");
							}
						}	
					}
				}
			}
		});
		btnTimKiem.setFocusable(false);
		btnTimKiem.setBackground(Color.WHITE);
		btnTimKiem.setBounds(721, 21, 101, 33);
		panel_2.add(btnTimKiem);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("data\\icons\\add1.png"));
		btnThem.setFocusable(false);
		btnThem.setBackground(Color.WHITE);
		btnThem.setBounds(721, 67, 101, 33);
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				HoaDon_ADD_GUI hdAdd = new HoaDon_ADD_GUI(maDN1);
				hdAdd.setVisible(true);
			}
		});
		panel_2.add(btnThem);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(null, "Danh s\u00E1ch h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 141, 874, 337);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 854, 250);
		panel_3.add(scrollPane);
		
		model = new DefaultTableModel(new String[] {
				"M\u00E3 h\u00F3a \u0111\u01A1n", "Kh\u00E1ch h\u00E0ng", "T\u1ED5ng ti\u1EC1n", "Ng\u00E0y b\u00E1n", "Ng\u01B0\u1EDDi b\u00E1n", "L\u01B0u t\u1EA1m", "H\u1EE7y"
			}, 0);
		for(CTHoaDonCT s : create()) {
			if(s.getTrangThai() == 2)
				model.addRow(new Object[] {		
					"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", ""
					});
			if(s.getTrangThai() == 1)
				model.addRow(new Object[] {		
					"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"X", ""
					});
			if(s.getTrangThai() == 0)
				model.addRow(new Object[] {		
					"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", "X"
					});
		}
		table = new JTable(model);
//		table.getColumnModel().getColumn(0).setMaxWidth(27);
//		table.getColumnModel().getColumn(2).setPreferredWidth(120);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setBackground(new Color(240, 248, 255));
		//table.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(table);
		
		JButton btnDong = new JButton("Đóng");
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnDong.setIcon(new ImageIcon("data\\icons\\exit1.png"));
		btnDong.setFocusable(false);
		btnDong.setBackground(Color.WHITE);
		btnDong.setBounds(741, 282, 123, 39);
		panel_3.add(btnDong);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("data\\icons\\delete1.png"));
		btnXoa.setFocusable(false);
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setBounds(608, 282, 123, 39);
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if(row != -1) {
					String maLoai = model.getValueAt(row, 0).toString().trim();
					int nhacnho = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?", "Chú ý", JOptionPane.YES_NO_OPTION);
					if(nhacnho == JOptionPane.YES_OPTION) {
						try {
							if (!cthd_DAO.delete(maLoai))
								throw new Exception();
							if (!hd_DAO.delete(maLoai))
								throw new Exception();
							updateDL();
							JOptionPane.showMessageDialog(null,"Xóa thành công!");
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Xóa không thành công!");
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn một Hóa Đơn cần xóa!");
				}
			}
		});
		panel_3.add(btnXoa);
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setIcon(new ImageIcon("data\\icons\\searchsale2.png"));
		btnCapNhat.setFocusable(false);
		btnCapNhat.setBackground(Color.WHITE);
		btnCapNhat.setBounds(475, 282, 123, 39);
		btnCapNhat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if(row != -1) {
					String maHD = model.getValueAt(row, 0).toString().trim();
					HoaDon_EDIT_GUI hdEdit = new HoaDon_EDIT_GUI(maHD);
					hdEdit.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn cần sửa!");
				}
			}
		});
		panel_3.add(btnCapNhat);	
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 64, 894, 2);
		panel.add(separator);
		upDateDLCBO();
	}
	private static void DocDLDB() {
		lkh = kh_DAO.getalltbKH();
		lnv = nv_DAO.getAllNhanVien();
		lhd = hd_DAO.getalltbHD();
		lcthd = cthd_DAO.getalltbCTHD();
		lth = thuoc_DAO.getAlltbThuoc();
		//lcthdct = cthd_DAO.getalltbCTCTHD();
	}
	private static void XoaHetDuLieuTrenTableModel() {
		model.getDataVector().removeAllElements();
	}
	private static void upDateDLCBO() {
		cboNB.addItem("Không chọn");
		for(Thuoc s : lth) {
			//cboSP.addItem(s.getTenThuoc().trim());
		}
		for(NhanVien s : lnv) {
			cboNB.addItem(s.getTenNV().trim());
		}
		cboNB.setSelectedIndex(-1);
	}
	public static void updateDL() {
		XoaHetDuLieuTrenTableModel();
		DocDLDB();
		for(CTHoaDonCT s : create()) {
			if(s.getTrangThai() == 2)
				model.addRow(new Object[] {		
					"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", ""
					});
			if(s.getTrangThai() == 1)
				model.addRow(new Object[] {		
					"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"X", ""
					});
			if(s.getTrangThai() == 0)
				model.addRow(new Object[] {		
					"  " +s.getMaHD(),"  " +s.getTenKH(),"  " +s.getTongCong(),"  " +String.valueOf(LocalDate.parse(formatter.format(s.getNgayLapHD()), formatter1).format(formatter1)),"  " + s.getHoTenNV(),"", "X"
					});
		}
		table.setModel(model);
	}
	private static ArrayList<CTHoaDonCT> create() {
		ArrayList<CTHoaDonCT> lcthdct1 = new ArrayList<CTHoaDonCT>();
		ArrayList<CTHoaDonCT> lcthdct2 = new ArrayList<CTHoaDonCT>();
		String maHD = "";
		String tenKH = "";
		int soLuong = 0;
		float tongCong = 0;
		Date ngayLapHD = new Date(0);
		String hoTenNV = "";
		int trangThai = 0;
		for(CTHoaDon s : lcthd) {
			for(HoaDon s1 : lhd) {
				if(s.getMaHD().trim().equalsIgnoreCase(s1.getMaHD().trim())) {
					maHD = s1.getMaHD();
					for(KhachHang s2 : lkh) {
						if(s1.getMaKH().trim().equalsIgnoreCase(s2.getMaKH().trim())) {
							tenKH = s2.getTenKH();
							break;
						}				
					}
					soLuong = s.getSoLuong();
					tongCong = s.getTongCong();
					ngayLapHD = s1.getNgayLapHD();
					for(NhanVien s3 : lnv) {
						if(s1.getMaNV().trim().equalsIgnoreCase(s3.getMaNV().trim())) {
							hoTenNV = s3.getTenNV();
							break;
						}
							
					}
					trangThai = s.getTrangThai();
					break;
				}
			}
			lcthdct1.add(new CTHoaDonCT(maHD, tenKH, soLuong, tongCong, ngayLapHD, hoTenNV, trangThai));
		}
		for(int i=0; i<lcthdct1.size();i++) {
			for(int j=i+1; j<lcthdct1.size();j++) {
				if(lcthdct1.get(j).getMaHD().trim().equalsIgnoreCase(lcthdct1.get(i).getMaHD().trim())) {
					lcthdct1.get(i).setTongCong(lcthdct1.get(i).getTongCong()+lcthdct1.get(j).getTongCong());
					lcthdct1.remove(j);
				}
			}
		}
		return lcthdct1;
	}
}
