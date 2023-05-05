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

import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import class_DAO.CT_HoaDon_DAO;
import class_DAO.DonViTinh_DAO;
import class_DAO.HoaDon_DAO;
import class_DAO.KhachHang_DAO;
import class_DAO.Thuoc_DAO;
import class_connectDB.ConnectDB;
import class_entity.CTBan;
import class_entity.CTHoaDon;
import class_entity.CTHoaDonCT;
import class_entity.DonViTinh;
import class_entity.HoaDon;
import class_entity.Thuoc;
import class_entity.KhachHang;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class HoaDon_EDIT_GUI extends JFrame {

	private JPanel contentPane;
	private final Box horizontalBox = Box.createHorizontalBox();
	private JTextField txtMaThuoc;
	private JTextField txtDVT;
	private JTextField txtSL;
	private JTextField txtTon;
	private JTextField txtTonLo;
	private JTextField txtDonGia;
	private JTextField txtTT;
	private JTable table;
	private JTextField txtTongCong;
	private JTextField txtChietKhau;
	private JTextField txtTKD;
	private JTextField txtTienTra;
	private JTextField txtDT;
	private JComboBox cbxTenSP;
	private JComboBox cbxHT;
	private static DefaultTableModel model;
	private float tongCong=0;
	private int i=1;
	private JComboBox cbxTenKH;
	private List<KhachHang> lkh;
	private List<Thuoc> lth;
	private KhachHang_DAO kh_DAO;
	private JComboBox cbxMaKH;
	private HoaDon_DAO hd_DAO;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	private DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private JButton btnThanhToan;
	private List<HoaDon> lhd;
	private CT_HoaDon_DAO cthd_DAO;
	private Thuoc_DAO th_DAO;
	private DonViTinh_DAO dvt_DAO;
	private List<DonViTinh> ldvt;
	private List<CTHoaDon> lcthd;
	private Thuoc_DAO thuoc_DAO;
	private static String signing1;
	private ArrayList<Thuoc> ListUpDThuoc;
	private ArrayList<Thuoc> ListThuoc = new ArrayList<Thuoc>();
	private int soLuongTC=0;
	private int soLuongKhoTam = 0;
	private List<CTBan> lctb;
	private String maHD1;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HoaDon_EDIT_GUI frame = new HoaDon_EDIT_GUI();
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
	public HoaDon_EDIT_GUI(String maHD) {
		
		maHD1=maHD;
		
		ConnectDB.getInstance().connect();
		kh_DAO = new KhachHang_DAO();
		hd_DAO = new HoaDon_DAO();
		cthd_DAO = new CT_HoaDon_DAO();
		thuoc_DAO = new Thuoc_DAO();
		dvt_DAO = new DonViTinh_DAO();
		ListUpDThuoc = new ArrayList<Thuoc>();
		DocDLDB();
		
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setResizable(false);
		setTitle("Bán hàng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 679);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		horizontalBox.setBounds(0, 0, 994, 71);
		contentPane.add(horizontalBox);
		
		JLabel label = new JLabel("   ");
		horizontalBox.add(label);
		
		JLabel lblQunLBn = new JLabel("QU\u1EA2N L\u00DD B\u00C1N H\u00C0NG");
		lblQunLBn.setForeground(new Color(30, 144, 255));
		lblQunLBn.setFont(new Font("Tahoma", Font.BOLD, 14));
		horizontalBox.add(lblQunLBn);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
		JLabel lblIconHere = new JLabel("");
		lblIconHere.setIcon(null);
		horizontalBox.add(lblIconHere);
		
//		JLabel label_1 = new JLabel("   ");
//		label_1.setIcon(new ImageIcon("data\\icons\\logo3.png"));
//		horizontalBox.add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 70, 994, 570);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(UIManager.getColor("InternalFrame.activeTitleBackground")));
		panel_1.setBounds(10, 11, 813, 71);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTenSP = new JLabel("T\u00EAn s\u1EA3n ph\u1EA9m:");
		lblTenSP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenSP.setBounds(0, 10, 88, 21);
		panel_1.add(lblTenSP);
		
		JLabel lblMaThuoc = new JLabel("Mã thuốc:");
		lblMaThuoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaThuoc.setBounds(0, 39, 88, 24);
		panel_1.add(lblMaThuoc);
		
		cbxTenSP = new JComboBox();
		cbxTenSP.setBackground(Color.WHITE);
		cbxTenSP.setBounds(97, 8, 336, 24);
		cbxTenSP.setFocusable(false);
		cbxTenSP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(cbxTenSP.getSelectedIndex()!=-1) {
					for(Thuoc s : ListThuoc) {
						if(s.getTenThuoc().trim().equals(cbxTenSP.getSelectedItem().toString().trim())) {
							txtMaThuoc.setText(s.getMaThuoc().trim());
							for(DonViTinh dvt : ldvt) {
								if(dvt.getMaDV().trim().equalsIgnoreCase(s.getMaDV().trim())) {
									txtDVT.setText(dvt.getTenDonVi().trim());
								}
							}
							txtTon.setText(String.valueOf(s.getSoLuong()));
							txtDonGia.setText(String.valueOf(s.getGiaBan()));
						}
					}
					txtSL.setEditable(true);
				}
				else {
					txtMaThuoc.setText("");
					txtDVT.setText("");
					txtTon.setText("");
					txtDonGia.setText("");
					txtSL.setEditable(false);
				}
			}
		});
		panel_1.add(cbxTenSP);
		
		txtMaThuoc = new JTextField();
		txtMaThuoc.setBounds(97, 39, 151, 24);
		txtMaThuoc.setForeground(Color.black);
		txtMaThuoc.setEditable(false);
		panel_1.add(txtMaThuoc);
		txtMaThuoc.setColumns(10);
		
		JLabel lblHT = new JLabel("Hình thức:");
		lblHT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHT.setBounds(271, 40, 71, 23);
		panel_1.add(lblHT);
		
		cbxHT = new JComboBox();
		cbxHT.setEditable(true);
		cbxHT.setBackground(Color.WHITE);
		cbxHT.setBounds(352, 39, 81, 24);
		cbxHT.setFocusable(false);
		cbxHT.disable();
		panel_1.add(cbxHT);
		
		JLabel lblvt = new JLabel("\u0110VT:");
		lblvt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblvt.setBounds(443, 11, 35, 21);
		panel_1.add(lblvt);
		
		txtDVT = new JTextField();
		txtDVT.setBounds(488, 9, 65, 24);
		txtDVT.setEditable(false);
		panel_1.add(txtDVT);
		txtDVT.setColumns(10);
		
		JLabel lblSl = new JLabel("SL:");
		lblSl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSl.setBounds(441, 38, 37, 21);
		panel_1.add(lblSl);
		
		txtSL = new JTextField();
		txtSL.setBounds(488, 36, 65, 24);
		panel_1.add(txtSL);
		txtSL.setColumns(10);
		txtSL.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(txtSL.getText().trim().equals("") || Integer.parseInt(txtSL.getText().trim()) > Integer.parseInt(txtTon.getText().trim())) {
					JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ!");
				}
				else {
					float TT = Integer.parseInt(txtSL.getText().trim())*Float.parseFloat(txtDonGia.getText().trim());					
					txtTT.setText(String.valueOf(TT));
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		txtSL.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				txtSL.selectAll();
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		txtTon = new JTextField();
		txtTon.setBounds(619, 9, 71, 24);
		txtTon.setEditable(false);
		panel_1.add(txtTon);
		txtTon.setColumns(10);
		
		JLabel lblTn = new JLabel("T\u1ED3n:");
		lblTn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTn.setBounds(563, 11, 46, 21);
		panel_1.add(lblTn);
		
		JLabel lblTnl = new JLabel("T\u1ED3n (l\u00F4):");
		lblTnl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnl.setBounds(563, 38, 46, 21);
		panel_1.add(lblTnl);
		
		txtTonLo = new JTextField();
		txtTonLo.setBounds(619, 36, 71, 24);
		panel_1.add(txtTonLo);
		txtTonLo.setColumns(10);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setIcon(new ImageIcon("data\\icons\\buy.png"));
		btnAdd.setBounds(700, 10, 106, 50);
		btnAdd.setFocusable(false);
		panel_1.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int ton = 0;
				Thuoc thuoc;
				if(cbxTenSP.getSelectedIndex()!=-1 && !txtSL.getText().trim().equals("")) {
					if(Integer.parseInt(txtSL.getText().trim())>Integer.parseInt(txtTon.getText().trim())) {
						JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ!");
					}
					else {
						for(Thuoc s : lth) {
							if(s.getTenThuoc().trim().equals(cbxTenSP.getSelectedItem().toString().trim())) {
								for(DonViTinh dvt : ldvt) {
									if(s.getMaDV().trim().equalsIgnoreCase(dvt.getMaDV().trim())) {
										model.addRow(new Object[] {
												i++, s.getMaThuoc(), s.getTenThuoc(), cbxHT.getSelectedItem().toString().trim(), 
												dvt.getTenDonVi().trim(), String.valueOf(s.getGiaBan()), txtSL.getText().toString().trim(), txtTT.getText().toString().trim()
											});
										break;
									}
								}		
								ton = Integer.parseInt(txtTon.getText().trim()) - Integer.parseInt(txtSL.getText().trim());
								txtTon.setText(String.valueOf(ton));	
								//soLuongKhoTam = ton;
								tongCong += Float.parseFloat(txtTT.getText().trim());
								txtTongCong.setText(String.valueOf(tongCong));								
								soLuongTC += Integer.parseInt(txtSL.getText().trim());
								thuoc = new Thuoc(s.getMaThuoc(), s.getTenThuoc(), s.getGiaBan(), ton, s.getMoTa(), s.getMaNSX(), s.getMaLoai(), s.getMaDV(), s.getMaQG());
								capNhatSLThuoc(ListThuoc, thuoc);
								//ListUpDThuoc.add(s);
								break;
							}
						}
					}		
				}
				else {
					JOptionPane.showMessageDialog(null, "Chưa chọn sản phẩm hoặc chưa nhập số lượng!");
				}
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new LineBorder(UIManager.getColor("InternalFrame.activeTitleBackground")));
		panel_2.setBounds(833, 11, 151, 71);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblnGi = new JLabel("\u0110\u01A1n gi\u00E1:");
		lblnGi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblnGi.setBounds(10, 11, 57, 24);
		panel_2.add(lblnGi);
		
		JLabel lblThnhTin = new JLabel("TT:");
		lblThnhTin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThnhTin.setBounds(10, 39, 57, 21);
		panel_2.add(lblThnhTin);
		
		txtDonGia = new JTextField();
		txtDonGia.setBounds(75, 11, 66, 24);
		txtDonGia.setEditable(false);
		txtDonGia.setHorizontalAlignment(JLabel.RIGHT);
		txtDonGia.setText("0");
		panel_2.add(txtDonGia);
		txtDonGia.setColumns(10);
		
		txtTT = new JTextField();
		txtTT.setBounds(75, 37, 66, 24);
		txtTT.setEditable(false);
		txtTT.setHorizontalAlignment(JLabel.RIGHT);
		txtTT.setText("0");
		panel_2.add(txtTT);
		txtTT.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(null, "Th\u00F4ng tin s\u1EA3n ph\u1EA9m b\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 85, 706, 415);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 686, 374);
		panel_3.add(scrollPane);
		
		String[] headers = {"STT", "M\u00E3 thuốc", "T\u00EAn s\u1EA3n ph\u1EA9m", "Hình thức", "\u0110\u01A1n v\u1ECB", "\u0110\u01A1n gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng", "Th\u00E0nh ti\u1EC1n"};
		model = new DefaultTableModel(headers, 0);
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setMaxWidth(27);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if(row != -1) {
					String maThuoc = model.getValueAt(row, 1).toString().trim();
					String tenThuoc = model.getValueAt(row, 2).toString().trim();
					String donVi = model.getValueAt(row, 4).toString().trim();
					String donGia = model.getValueAt(row, 5).toString().trim();
					String soLuong = model.getValueAt(row, 6).toString().trim();
					String thanhTien = model.getValueAt(row, 7).toString().trim();
					txtMaThuoc.setText(maThuoc);
					cbxTenSP.setSelectedItem(tenThuoc);
					txtDVT.setText(donVi);
					txtSL.setText(soLuong);
					for(Thuoc s : ListThuoc) {
						if(s.getMaThuoc().trim().equalsIgnoreCase(maThuoc)) {
							txtTon.setText(String.valueOf(s.getSoLuong()));
						}
					}
					txtDonGia.setText(donGia);
					txtTT.setText(thanhTien);
				}
			}
		});
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		panel_5.setBounds(10, 504, 974, 66);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnDong = new JButton("Đóng");
		btnDong.setBackground(Color.WHITE);
		btnDong.setIcon(new ImageIcon("data\\icons\\exit1.png"));
		btnDong.setBounds(862, 11, 102, 44);
		btnDong.setFocusable(false);
		btnDong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int nhacnho = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn thoát không?", "Lời nhắc", JOptionPane.YES_NO_OPTION);
				if(nhacnho == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
		panel_5.add(btnDong);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBackground(Color.WHITE);
		btnHuy.setIcon(new ImageIcon("data\\icons\\back.png"));
		btnHuy.setBounds(763, 11, 89, 44);
		btnHuy.setFocusable(false);
		//btnHuy.setEnabled(false);
		panel_5.add(btnHuy);
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if(row != -1) {
					String thanhTien = model.getValueAt(row, 7).toString().trim();
					txtTongCong.setText(String.valueOf(Float.valueOf(txtTongCong.getText().trim()) - Float.valueOf(thanhTien)));
					txtChietKhau.setText("0");
					txtTKD.setText("0");
					txtTienTra.setText("0");
					model.removeRow(row);
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn loại thuốc mua cần hủy!");
				}
			}
		});
		
		JButton btnLuuTam = new JButton("Lưu tạm");
		btnLuuTam.setBackground(Color.WHITE);
		btnLuuTam.setIcon(new ImageIcon("data\\icons\\save1.png"));
		btnLuuTam.setBounds(636, 11, 117, 44);
		btnLuuTam.setFocusable(false);
		panel_5.add(btnLuuTam);
		btnLuuTam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validData()) {
					String maHD = maHD1;
					String maNV = "NV111";
					String tenThuoc = cbxTenSP.getSelectedItem().toString().trim();
					String maThuoc="";
					for(Thuoc s : lth) {
						if(s.getTenThuoc().trim().equalsIgnoreCase(tenThuoc))
							maThuoc=s.getMaThuoc().trim();
					}
					String maKH = cbxMaKH.getSelectedItem().toString().trim();
					Date ngayTao = Date.valueOf(LocalDate.now());
					int soLuong = soLuongTC;
					String hinhThucBan = cbxHT.getSelectedItem().toString().trim();
					float tongCong1 = Float.parseFloat(txtTongCong.getText().trim());
					int chietKhau = Integer.parseInt(txtChietKhau.getText().trim());
					float khachDua = Float.parseFloat(txtTKD.getText().trim());
					float traKhach = Float.parseFloat(txtTienTra.getText().trim());
					HoaDon hd = new HoaDon(maHD, maNV, maKH, ngayTao);
					CTHoaDon cthd = new CTHoaDon(maHD, maThuoc, soLuong, hinhThucBan, tongCong1, chietKhau, khachDua, traKhach, 1);
					try {
//						if(!hd_DAO.create(hd))
//							throw new Exception();
						//DocDLDB();
						if(!cthd_DAO.update(cthd))
							throw new Exception();	
						
						//DocDLDB();
						//HoaDon_GUI.updateDL();
						JOptionPane.showMessageDialog(null, "Tạo hóa đơn thành công!");
						for(Thuoc s : ListThuoc) {
							try {
								if(!thuoc_DAO.capnhat(s))
									throw new Exception();
								HoaDon_GUI.updateDL();
							}
							catch(Exception e1) {
								JOptionPane.showMessageDialog(null, "Không thể cập nhật số lượng thuốc!!");
							}
						}
						DocDLDB();
						dispose();		
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Tạo hóa đơn không thành công!!");
					}
				}
			}
		});
		
		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setIcon(new ImageIcon("data\\icons\\sale2.png"));
		btnThanhToan.setBackground(Color.WHITE);
		btnThanhToan.setFocusable(false);
		btnThanhToan.setBounds(468, 11, 158, 44);
		panel_5.add(btnThanhToan);
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validData()) {
					String maHD = tuDongLayMaHD();
					String maNV = "NV111";
					String tenThuoc = cbxTenSP.getSelectedItem().toString().trim();
					String maThuoc="";
					for(Thuoc s : lth) {
						if(s.getTenThuoc().trim().equalsIgnoreCase(tenThuoc))
							maThuoc=s.getMaThuoc().trim();
					}
					String maKH = cbxMaKH.getSelectedItem().toString().trim();
					Date ngayTao = Date.valueOf(LocalDate.now());
					int soLuong = soLuongTC;
					String hinhThucBan = cbxHT.getSelectedItem().toString().trim();
					float tongCong1 = Float.parseFloat(txtTongCong.getText().trim());
					int chietKhau = Integer.parseInt(txtChietKhau.getText().trim());
					float khachDua = Float.parseFloat(txtTKD.getText().trim());
					float traKhach = Float.parseFloat(txtTienTra.getText().trim());
					HoaDon hd = new HoaDon(maHD, maNV, maKH, ngayTao);
					CTHoaDon cthd = new CTHoaDon(maHD, maThuoc, soLuong, hinhThucBan, tongCong1, chietKhau, khachDua, traKhach, 2);
					try {
						if(!hd_DAO.create(hd))
							throw new Exception();
						//DocDLDB();
						if(!cthd_DAO.create(cthd))
							throw new Exception();	
						
						//DocDLDB();
						//HoaDon_GUI.updateDL();
						JOptionPane.showMessageDialog(null, "Tạo hóa đơn thành công!");
						for(Thuoc s : ListThuoc) {
							try {
								if(!thuoc_DAO.capnhat(s))
									throw new Exception();
								HoaDon_GUI.updateDL();
							}
							catch(Exception e1) {
								JOptionPane.showMessageDialog(null, "Không thể cập nhật số lượng thuốc!!");
							}
						}
						DocDLDB();
						dispose();		
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Tạo hóa đơn không thành công!!");
					}
				}
			}
		});
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new LineBorder(UIManager.getColor("InternalFrame.activeTitleBackground")));
		panel_4.setBounds(726, 93, 258, 136);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblTongCong = new JLabel("T\u1ED5ng c\u1ED9ng:");
		lblTongCong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTongCong.setBounds(10, 11, 116, 29);
		panel_4.add(lblTongCong);
		
		JLabel lblChietKhau = new JLabel("Ti\u1EC1n chi\u1EBFt kh\u1EA5u:");
		lblChietKhau.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChietKhau.setBounds(10, 38, 116, 29);
		panel_4.add(lblChietKhau);
		
		JLabel lblTKD = new JLabel("Ti\u1EC1n kh\u00E1ch \u0111\u01B0a (F4):");
		lblTKD.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTKD.setBounds(10, 67, 116, 29);
		panel_4.add(lblTKD);
		
		JLabel lblTienTra = new JLabel("Ti\u1EC1n tr\u1EA3 l\u1EA1i:");
		lblTienTra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTienTra.setBounds(10, 96, 116, 29);
		panel_4.add(lblTienTra);
		
		txtTongCong = new JTextField();
		txtTongCong.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTongCong.setBounds(136, 13, 112, 25);
		txtTongCong.setEditable(false);
		txtTongCong.setText("0");
		panel_4.add(txtTongCong);
		txtTongCong.setColumns(10);
		
		txtChietKhau = new JTextField();
		txtChietKhau.setHorizontalAlignment(SwingConstants.RIGHT);
		txtChietKhau.setBounds(136, 40, 85, 25);
		//txtChietKhau.setEditable(false);
		txtChietKhau.setText("0");
		panel_4.add(txtChietKhau);
		txtChietKhau.setColumns(10);
		txtChietKhau.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				float tienThua = Float.parseFloat(txtTKD.getText().trim()) - Float.parseFloat(txtTongCong.getText().trim())*((100-Float.parseFloat(txtChietKhau.getText().trim()))/100);
				if(tienThua > 0)
					txtTienTra.setText(String.valueOf(tienThua));
				else
					JOptionPane.showMessageDialog(null, "Tiền khách đưa không hợp lệ!");
			}
		});
		txtChietKhau.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				txtChietKhau.selectAll();
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		txtTKD = new JTextField();
		txtTKD.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTKD.setBounds(136, 69, 112, 25);
		txtTKD.setText("0");
		panel_4.add(txtTKD);
		txtTKD.setColumns(10);
		txtTKD.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				txtTKD.selectAll();
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		txtTKD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				float tienThua = Float.parseFloat(txtTKD.getText().trim()) - Float.parseFloat(txtTongCong.getText().trim())*((100-Float.parseFloat(txtChietKhau.getText().trim()))/100);
				if(tienThua > 0)
					txtTienTra.setText(String.valueOf(tienThua));
				else
					JOptionPane.showMessageDialog(null, "Tiền khách đưa không hợp lệ!");
			}
		});
		
		txtTienTra = new JTextField();
		txtTienTra.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTienTra.setBounds(136, 100, 112, 25);
		txtTienTra.setEditable(false);
		txtTienTra.setText("0");
		panel_4.add(txtTienTra);
		txtTienTra.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("%");
		lblNewLabel.setBounds(231, 45, 17, 14);
		panel_4.add(lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(726, 233, 258, 151);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblTenKH = new JLabel("T\u00EAn KH:");
		lblTenKH.setForeground(Color.BLUE);
		lblTenKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenKH.setBounds(10, 21, 66, 23);
		panel_6.add(lblTenKH);
		
		JLabel lblDT = new JLabel("\u0110i\u1EC7n tho\u1EA1i:");
		lblDT.setForeground(Color.BLUE);
		lblDT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDT.setBounds(10, 55, 66, 22);
		panel_6.add(lblDT);
		
		JLabel lblMaKH = new JLabel("M\u00E3 KH:");
		lblMaKH.setForeground(Color.BLUE);
		lblMaKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaKH.setBounds(10, 91, 66, 20);
		panel_6.add(lblMaKH);
		
		txtDT = new JTextField();
		txtDT.setBounds(86, 53, 122, 26);
		panel_6.add(txtDT);
		txtDT.setColumns(10);
		txtDT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!txtDT.getText().trim().equals("")) {
					for(KhachHang s : lkh) {
						if(s.getSdt().trim().equalsIgnoreCase(txtDT.getText().trim())) {
							cbxMaKH.setSelectedItem(s.getMaKH());
							txtDT.setText(s.getSdt());
							break;
						}
						else {
							cbxTenKH.setSelectedIndex(-1);
							cbxMaKH.setSelectedIndex(-1);
						}
					}
				}
				else {
					cbxTenKH.setSelectedIndex(-1);
					cbxMaKH.setSelectedIndex(-1);
				}
			}
		});
		
		cbxTenKH = new JComboBox();
		cbxTenKH.setBackground(Color.WHITE);
		cbxTenKH.setBounds(86, 19, 122, 26);
		cbxTenKH.setFocusable(false);
		cbxTenKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cbxTenKH.getSelectedIndex()!=-1) {
					for(KhachHang s : lkh) {
						if(cbxTenKH.getSelectedItem().equals(s.getTenKH())) {
							cbxTenKH.setSelectedItem(s.getTenKH());
							cbxMaKH.setSelectedItem(s.getMaKH());
							break;
						}				
					}
				}
			}
		});
		panel_6.add(cbxTenKH);
		
		cbxMaKH = new JComboBox();
		cbxMaKH.setBackground(Color.WHITE);
		cbxMaKH.setBounds(86, 88, 122, 26);
		cbxMaKH.setFocusable(false);
		cbxMaKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cbxMaKH.getSelectedIndex()!=-1) {
					for(KhachHang s : lkh) {
						if(cbxMaKH.getSelectedItem().equals(s.getMaKH())) {
							cbxTenKH.setSelectedItem(s.getTenKH());
							txtDT.setText(s.getSdt());
							break;
						}
					}
				}
			}
		});
		panel_6.add(cbxMaKH);
		
		JButton btnEditKH = new JButton("");
		btnEditKH.setBackground(Color.WHITE);
		btnEditKH.setIcon(new ImageIcon("data\\icons\\write.png"));
		btnEditKH.setBounds(218, 19, 30, 25);
		btnEditKH.setFocusable(false);
		panel_6.add(btnEditKH);
		
		JButton btnSearchKH = new JButton("");
		btnSearchKH.setBackground(Color.WHITE);
		btnSearchKH.setIcon(new ImageIcon("data\\icons\\search.png"));
		btnSearchKH.setBounds(218, 52, 30, 25);
		btnSearchKH.setFocusable(false);
		panel_6.add(btnSearchKH);
		
		JButton btnAddKH = new JButton("");
		btnAddKH.setBackground(Color.WHITE);
		btnAddKH.setIcon(new ImageIcon("data\\icons\\add.png"));
		btnAddKH.setBounds(218, 88, 30, 25);
		btnAddKH.setFocusable(false);
		panel_6.add(btnAddKH);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 69, 994, 2);
		contentPane.add(separator);
		updateDL();
		cbxTenSP.setSelectedIndex(-1);
		updateDLCbx();
		tuDongLayMaHD();
		updateModel();
	}
	private void updateDLCbx() {
		
		for(KhachHang s : lkh) {
			cbxTenKH.addItem(s.getTenKH());
			cbxMaKH.addItem(s.getMaKH());
		}
		cbxTenKH.setSelectedIndex(-1);
		cbxMaKH.setSelectedIndex(-1);
		txtDT.setText("");
	}
	private void DocDLDB() {
		lkh = kh_DAO.getalltbKH();
		lth = thuoc_DAO.getAlltbThuoc();
		lhd = hd_DAO.getalltbHD();
		lcthd = cthd_DAO.getalltbCTHD();
		ldvt = dvt_DAO.getalltbDVT();
		ListThuoc = thuoc_DAO.getAlltbThuoc();
		lctb = hd_DAO.getalltbCTBan(maHD1);
	}
	private static void XoaHetDuLieuTrenTableModel() {
		model.getDataVector().removeAllElements();
	}
	private void updateDL() {
		cbxTenSP.removeAllItems();
		for(Thuoc s : ListThuoc) {
			cbxTenSP.addItem(s.getTenThuoc().trim());
		}
		cbxHT.addItem("Lẻ");
		cbxHT.addItem("Sỉ");
	}
	private boolean validData() {
		
		String nameKH = (String) cbxTenKH.getSelectedItem();
		String nameTh = (String) cbxTenSP.getSelectedItem();
		String sdt = txtDT.getText().toString().trim();
		float tongCong = Float.parseFloat(txtTongCong.getText().trim());
		float traKhach = Float.parseFloat(txtTienTra.getText().trim());
		if(nameTh == null) {
			JOptionPane.showMessageDialog(null, "Chưa chọn thuốc!");
			return false;
		}
		if(txtSL.getText().trim().equals("") || txtTT.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Chưa nhập số lượng thuốc!");
			return false;
		}
		if(!(tongCong > 0)) {
			JOptionPane.showMessageDialog(null, "Chưa thêm thuốc vào danh sách bán!");
			return false;
		}
		if(!(traKhach > 0)) {
			JOptionPane.showMessageDialog(null, "Khách chưa trả tiền?");
			return false;
		}
		if(nameKH == null) {
			JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng!");
			return false;
		}	
		if(!(sdt.length() > 0)) {
			JOptionPane.showMessageDialog(null, "Chưa nhập số điện thoại khách!");
			return false;
		}
		
		return true;
	}
	private void capNhatSLThuoc(ArrayList<Thuoc> lt, Thuoc t) {
		for(Thuoc s : lt) {
			if(s.getMaThuoc().trim().equals(t.getMaThuoc().trim())) {
				s.setSoLuong(t.getSoLuong());
				break;
			}			
		}
	}
	private String tuDongLayMaHD() {
		String maHD;
		String stt1 = "";
		int sott1;
		int max=0;
		for(HoaDon s : lhd) {		
			maHD = s.getMaHD().trim();
			for(int i=2; i<maHD.length();i++) {
				stt1 += maHD.charAt(i);
			}
			sott1 = Integer.valueOf(stt1);
			if(max < sott1)
				max=sott1;
			stt1="";
		}
		String ma = "HD" + String.valueOf(max + 1);
		return ma;
	}
	private void updateModel() {
		System.out.println(maHD1);
		XoaHetDuLieuTrenTableModel();
		int i=1;
		float TC=0;
		for(CTBan s : lctb) {
			for(Thuoc t : lth) {
				if(s.getMaThuoc().trim().equalsIgnoreCase(t.getMaThuoc().trim())) {
					model.addRow(new Object[] {		
							i++,"  " +s.getMaThuoc(),"  " +t.getTenThuoc(),"  " +"Lẻ","  " +getDV(t.getMaDV().trim()),"  " + t.getGiaBan(),s.getSoLuong(), t.getGiaBan()*s.getSoLuong()
							});	
					TC+=t.getGiaBan()*s.getSoLuong();
				}
			}
		}
		txtTongCong.setText(String.valueOf(TC));
		for(CTHoaDon c : lcthd) {
			if(c.getMaHD().trim().equalsIgnoreCase(maHD1.trim())) {
				txtChietKhau.setText(String.valueOf(c.getChietKhau()));
				txtTKD.setText(String.valueOf(c.getKhachDua()));
				txtTienTra.setText(String.valueOf(c.getTraKhach()));
				break;
			}
		}
		for(HoaDon c : lhd) {
			if(c.getMaHD().trim().equalsIgnoreCase(maHD1.trim())) {
				for(KhachHang k : lkh) {
					if(k.getMaKH().trim().equalsIgnoreCase(c.getMaKH().trim())) {
						cbxMaKH.setSelectedItem(k.getMaKH().trim());
						cbxTenKH.setSelectedItem(k.getTenKH().trim());
						txtDT.setText(k.getSdt().trim());
					}
				}
				break;
			}
		}
		table.setModel(model);
	}
	public String getDV(String ma) {
		for(DonViTinh s : ldvt) {
			if(s.getMaDV().trim().equalsIgnoreCase(ma.trim())) {
				return s.getTenDonVi().trim();
			}
		}
		return "";
	}
}
