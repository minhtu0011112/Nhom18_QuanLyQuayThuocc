package class_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import class_DAO.KhachHang_DAO;
import class_DAO.QuanLyNV_DAO;
import class_connectDB.ConnectDB;
import class_entity.KhachHang;
import class_entity.NhanVien;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;

public class NhanVien_GUI extends JFrame  {
	private JPanel contentPane;
	private static JTable table;
	private static JComboBox cboDT;
	private static DefaultTableModel model;
	private JButton btnThem, btnSua, btnXoa, btnDong;
	public static List<NhanVien> lstnv;
	public static List<NhanVien> lstnvall;
	private static QuanLyNV_DAO qlnv_DAO;
	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	private static DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private JScrollPane scrollPane;
	private static JCheckBox cbxTT;
	private static JComboBox cboMaNV;
	private static JComboBox cboDiaChi;
	private static JComboBox cboTenNV;
	private static SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien_GUI frame = new NhanVien_GUI();
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
	public NhanVien_GUI() {
		ConnectDB.getInstance().connect();
		qlnv_DAO = new QuanLyNV_DAO();
		DocDLDB();
		DocDLDBall();
		
		setTitle("Quản lí nhân viên");
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 899, 577);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 895, 538);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(0, 0, 895, 71);
		panel.add(horizontalBox);
		
		JLabel lblNewLabel_3 = new JLabel("   ");
		horizontalBox.add(lblNewLabel_3);
		
		JLabel lblQLNV = new JLabel("QUẢN LÍ NHÂN VIÊN");
		lblQLNV.setForeground(Color.BLUE);
		lblQLNV.setFont(new Font("Tahoma", Font.BOLD, 16));
		horizontalBox.add(lblQLNV);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon("data\\icons\\logo3.png"));
//		horizontalBox.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 82, 895, 456);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 98, 875, 347);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(10, 21, 855, 243);
		panel_2.add(scrollPane);

		model = new DefaultTableModel(new String[] {
				"STT","Mã nhân viên", "Tên nhân viên", "Chức vụ", "Giới tính", "Ngày sinh", "Ngày vào làm", "Số CMND", "Địa chỉ", "Email", "Số điện thoại", "Tinh trang"
			}, 0);
		int i=1;
		for(NhanVien nv : lstnv) {
			model.addRow(new Object[] {i++, nv.getMaNV(), nv.getTenNV(), nv.getChuVu(), nv.getGioiTinh(),
					String.valueOf(LocalDate.parse(formatter.format(nv.getNgaySinh()), formatter1).format(formatter1)),
					String.valueOf(LocalDate.parse(formatter.format(nv.getNgayLamViec()), formatter1).format(formatter1)),
					nv.getcMND(), nv.getDiaChi(), nv.getEmail(), nv.getSdt(), nv.getTinhTrang() });
		}
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setMaxWidth(27);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollPane.setViewportView(table);
		table.setBackground(new Color(240, 248, 255));
		
		JButton btnThem = new JButton("Thêm NV");
		btnThem.setFocusable(false);
		btnThem.setBounds(343, 275, 123, 49);
		btnThem.setIcon(new ImageIcon("data\\icons\\add1.png"));
		btnThem.setBackground(Color.WHITE);
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//NhanVien_ADD_GUI nvadd = new NhanVien_ADD_GUI();
				if(cbxTT.isSelected())
					NhanVien_ADD_GUI.NewScreen(1);
				else
					NhanVien_ADD_GUI.NewScreen(0);
			}
		});
		panel_2.add(btnThem);
		
		
		JButton btnSua = new JButton("Sửa NV");
		btnSua.setFocusable(false);
		btnSua.setBounds(476, 275, 123, 49);
		btnSua.setIcon(new ImageIcon("data\\icons\\searchsale2.png"));
		btnSua.setBackground(Color.WHITE);
		btnSua.addActionListener(new ActionListener() {
			
			NhanVien_EDIT_GUI nvedit;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if(row != -1) {
					String manv = model.getValueAt(row, 1).toString().trim();
					if(cbxTT.isSelected()) {
						nvedit = new NhanVien_EDIT_GUI(manv, 1);
						nvedit.setVisible(true);
					}
					else {
						nvedit = new NhanVien_EDIT_GUI(manv, 0);
						nvedit.setVisible(true);
					}
					//NhanVien_EDIT_GUI.NewScreen(manv, 0);
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 Nhân Viên cần sửa!");
				}
			}
		});
		panel_2.add(btnSua);
			
		JButton btnXoa = new JButton("Xóa NV");
		btnXoa.setFocusable(false);
		btnXoa.setBounds(609, 275, 123, 49);
		btnXoa.setIcon(new ImageIcon("data\\icons\\delete1.png"));
		btnXoa.setBackground(Color.WHITE);
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if(row != -1) {
					int tinhTrang = Integer.parseInt(model.getValueAt(row, 11).toString().trim());
					if(tinhTrang == 1) {
						String manv = model.getValueAt(row, 1).toString().trim();
						int nhacnho = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa không?", "Chú ý", JOptionPane.YES_NO_OPTION);
						if(nhacnho == JOptionPane.YES_OPTION) {
							try {
								if (!qlnv_DAO.deleteNV(manv, 0))
									throw new Exception();
								if(cbxTT.isSelected())
									updateDLall();
								else
									updateDL();
								JOptionPane.showMessageDialog(null,"Xóa thành công!");
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null, "Xóa không thành công! Vui lòng xóa thông tin lịch sử nhân viên!");
							}
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Nhân viên đã nghỉ rồi!");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 loại Nhân Viên cần xóa!");
				}
			}
		});
		panel_2.add(btnXoa);
		
		JButton btnDong = new JButton("Đóng");
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnDong.setBounds(742, 275, 123, 49);
		panel_2.add(btnDong);
		btnDong.setIcon(new ImageIcon("data\\icons\\exit1.png"));
		btnDong.setBackground(Color.WHITE);
		
		cbxTT = new JCheckBox("Hiện thông tin nhân viên đã nghỉ");
		cbxTT.setBackground(Color.WHITE);
		cbxTT.setBounds(10, 288, 205, 23);
		cbxTT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(cbxTT.isSelected())
					updateDLall();
				else
					updateDL();
			}
		});
		panel_2.add(cbxTT);
		
		
		JLabel lblMaNV = new JLabel("Mã NV:");
		lblMaNV.setBounds(44, 24, 52, 14);
		panel_1.add(lblMaNV);
		
		JLabel lblTenNV = new JLabel("TênNV:");
		lblTenNV.setBounds(44, 49, 52, 20);
		panel_1.add(lblTenNV);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setBounds(387, 52, 64, 14);
		panel_1.add(lblDiaChi);
		
		JLabel lblDT = new JLabel("Điện thoại:");
		lblDT.setBounds(387, 24, 64, 14);
		panel_1.add(lblDT);
		
		cboDT = new JComboBox();
		cboDT.setEditable(true);
		cboDT.setBounds(461, 21, 226, 20);
		panel_1.add(cboDT);
		
			
		JButton btnTimNV = new JButton("Tìm NV");
		btnTimNV.setFocusable(false);
		panel_1.add(btnTimNV);				
		
		btnTimNV.setBackground(Color.WHITE);
		btnTimNV.setIcon(new ImageIcon("data\\icons\\search.png"));
		btnTimNV.setBounds(729, 22, 122, 47);
		btnTimNV.addActionListener(new ActionListener() {
			
			private ArrayList<NhanVien> lnv;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String dieuKien = "";
				String dieuKiennew = "";
				String and = "";
				if(cboMaNV.getSelectedIndex()!=-1 && !cboMaNV.getSelectedItem().toString().trim().equals("Không chọn"))
					dieuKien += "MaNV=N'"+cboMaNV.getSelectedItem().toString().trim() + "' and ";
				if(cboTenNV.getSelectedIndex()!=-1 && !cboTenNV.getSelectedItem().toString().equals("Không chọn"))
					dieuKien += "HoTenNV=N'"+cboTenNV.getSelectedItem().toString().trim() + "' and ";
				if(cboDT.getSelectedIndex()!=-1 && !cboDT.getSelectedItem().toString().equals("Không chọn"))
					dieuKien += "SDT=N'"+cboDT.getSelectedItem().toString().trim() + "' and ";
				if(cboDiaChi.getSelectedIndex()!=-1 && !cboDiaChi.getSelectedItem().toString().equals("Không chọn")) {
					dieuKien += "DiaChi=N'"+((cboDiaChi.getSelectedItem().toString().trim()).split("\\-"))[0] + "' and ";
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
					lnv = qlnv_DAO.searchNV(dieuKiennew);
					System.out.println(dieuKiennew);
					if(lnv.size()!=0) {
						XoaHetDuLieuTrenTableModel();
						int i=1	;
						for(NhanVien nv : lnv) {
							model.addRow(new Object[] {i++, nv.getMaNV(), nv.getTenNV(), nv.getChuVu(), nv.getGioiTinh(),
									String.valueOf(LocalDate.parse(formatter.format(nv.getNgaySinh()), formatter1).format(formatter1)),
									String.valueOf(LocalDate.parse(formatter.format(nv.getNgayLamViec()), formatter1).format(formatter1)),
									nv.getcMND(), nv.getDiaChi(), nv.getEmail(), nv.getSdt(), nv.getTinhTrang() });
						}
						table.setModel(model);
					}
					else {
						if(cbxTT.isSelected())
							NhanVien_GUI.updateDLall();
						else
							NhanVien_GUI.updateDL();
						JOptionPane.showMessageDialog(null, "Không tìm thấy!");
					}
				}
			}
		});
		panel_1.add(btnTimNV);
		
		cboMaNV = new JComboBox();
		cboMaNV.setEditable(true);
		cboMaNV.setBounds(91, 20, 226, 20);
		panel_1.add(cboMaNV);
		
		cboDiaChi = new JComboBox();
		cboDiaChi.setEditable(true);
		cboDiaChi.setBounds(461, 48, 226, 20);
		panel_1.add(cboDiaChi);
		
		cboTenNV = new JComboBox();
		cboTenNV.setEditable(true);
		cboTenNV.setBounds(91, 49, 226, 20);
		panel_1.add(cboTenNV);
					
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 69, 895, 2);
		panel.add(separator);
		updateDLCbx();
		
	}
	
	private static void DocDLDB() {
		lstnv = qlnv_DAO.getAllNhanVien();
	}
	private static void DocDLDBall() {
		lstnvall = qlnv_DAO.getAllNhanVienall();
	}
	private static void XoaHetDuLieuTrenTableModel() {
		model.getDataVector().removeAllElements();
	}
	public static void updateDL() {
		XoaHetDuLieuTrenTableModel();
		DocDLDB();
		DocDLDBall();
		updateDLCbx();
		int i=1;
		for(NhanVien nv : lstnv) {
			model.addRow(new Object[] {i++, nv.getMaNV(), nv.getTenNV(), nv.getChuVu(), nv.getGioiTinh(),
					String.valueOf(LocalDate.parse(formatter.format(nv.getNgaySinh()), formatter1).format(formatter1)),
					String.valueOf(LocalDate.parse(formatter.format(nv.getNgayLamViec()), formatter1).format(formatter1)),
					nv.getcMND(), nv.getDiaChi(), nv.getEmail(), nv.getSdt(), nv.getTinhTrang() });
		}
		table.setModel(model);
	}
	public static void updateDLall() {
		XoaHetDuLieuTrenTableModel();
		DocDLDB();
		DocDLDBall();
		updateDLCbx();
		int i=1;
		for(NhanVien nv : lstnvall) {
			model.addRow(new Object[] {i++, nv.getMaNV(), nv.getTenNV(), nv.getChuVu(), nv.getGioiTinh(),
					String.valueOf(LocalDate.parse(formatter.format(nv.getNgaySinh()), formatter1).format(formatter1)),
					String.valueOf(LocalDate.parse(formatter.format(nv.getNgayLamViec()), formatter1).format(formatter1)),
					nv.getcMND(), nv.getDiaChi(), nv.getEmail(), nv.getSdt(), nv.getTinhTrang() });
		}
		table.setModel(model);
	}
	private static void updateDLCbx() {
		cboMaNV.removeAllItems();
		cboTenNV.removeAllItems();
		cboDT.removeAllItems();
		cboDiaChi.removeAllItems();
		
		cboMaNV.addItem("Không chọn");
		cboTenNV.addItem("Không chọn");
		cboDT.addItem("Không chọn");
		cboDiaChi.addItem("Không chọn");
		
		for(NhanVien s : lstnvall) {
			cboMaNV.addItem(s.getMaNV().trim());
			cboTenNV.addItem(s.getTenNV().trim());
			cboDT.addItem(s.getSdt().trim());
			cboDiaChi.addItem(s.getDiaChi().trim());	
		}
					
		cboMaNV.setSelectedIndex(-1);
		cboTenNV.setSelectedIndex(-1);
		cboDT.setSelectedIndex(-1);
		cboDiaChi.setSelectedIndex(-1);
	}
}
