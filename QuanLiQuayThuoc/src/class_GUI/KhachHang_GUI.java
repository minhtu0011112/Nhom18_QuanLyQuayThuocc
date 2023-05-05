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
import class_connectDB.ConnectDB;
import class_entity.KhachHang;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.List;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KhachHang_GUI extends JFrame  {
	private JPanel contentPane;
	private static JTable table;

	private static DefaultTableModel model;
	public static ArrayList<KhachHang> lqlkh;
	public static KhachHang_DAO qlkh_DAO;
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	private static SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
	private DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static JComboBox cboMaKH;
	private static JComboBox cboTenKH ;
	private static JComboBox cboDiaChi ;
	private static JComboBox cboDT ;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHang_GUI frame = new KhachHang_GUI();
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
	public KhachHang_GUI() {
		ConnectDB.getInstance().connect();
		qlkh_DAO = new KhachHang_DAO();
		DocDLDB();
		
		setTitle("Quản lí khách hàng");
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 911, 577);
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
		
		JLabel lblQuan = new JLabel("QUẢN LÍ KHÁCH HÀNG");
		lblQuan.setForeground(Color.BLUE);
		lblQuan.setFont(new Font("Tahoma", Font.BOLD, 16));
		horizontalBox.add(lblQuan);
		
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
				"STT","Mã KH", "Loại khách hàng", "Tên khách hàng", "Giới tính", "Ngày sinh", "Số CMND","Địa chỉ", "Tỉnh-TP", "Quận-Huyện", "Số điện thoại", "Ghi chú"
			}, 0);
		int i=1	;
		for(KhachHang s : lqlkh) {
			model.addRow(new Object[] {		
				i++,"  " +s.getMaKH(),"  " +s.getMaLoaiKH(),"  " +s.getTenKH(),"  " +s.getGioiTinh(),"  " + formatter.format(s.getNgaySinh()),"  " +s.getSoCMND(),"  " +s.getDiaChi(),"  " +s.getTinh_TP(),"  " +s.getQuan_Huyen(), "  " + s.getSdt(), "  " + s.getGhiChu()
				});
		}
		//table = new JTable(model);
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setMaxWidth(27);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollPane.setViewportView(table);
		table.setBackground(new Color(240, 248, 255));

		//----------------BUTTON THÃŠM----------------------------------
		
		JButton btnThem = new JButton("Thêm KH");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHang_ADD_GUI them = new KhachHang_ADD_GUI();
				them.setVisible(true);
			}
		});
		btnThem.setFocusable(false);
		btnThem.setBounds(343, 275, 123, 49);
		panel_2.add(btnThem);
		btnThem.setIcon(new ImageIcon("data\\icons\\add1.png"));
		btnThem.setBackground(Color.WHITE);
		
		JButton btnSua = new JButton("Sửa KH");
		btnSua.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if(row != -1) {
					String makh = model.getValueAt(row, 1).toString().trim();
					KhachHang_EDIT_GUI.NewScreen(makh);
					//KhachHang kh = new KhachHang(makh, ten, Date.valueOf("01-05-1999"), diachi, tinhtp, quanhuyen, gioitinh, socmnd, sdt, ghiChu);				
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần sửa!");
				}
			
			}
		});
		btnSua.setFocusable(false);

		
		btnSua.setBounds(476, 275, 123, 49);
		panel_2.add(btnSua);
		btnSua.setIcon(new ImageIcon("data\\icons\\searchsale2.png"));
		btnSua.setBackground(Color.WHITE);
		
		JButton btnXoa = new JButton("Xóa KH");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // TODO add your handling code here:
				int row = table.getSelectedRow();
				if(row != -1) {
					String makh = model.getValueAt(row, 1).toString().trim();
					int nhacnho = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa không?", "Lời nhắc", JOptionPane.YES_NO_OPTION);
					if(nhacnho == JOptionPane.YES_OPTION) {
						try {
							if (!qlkh_DAO.delete(makh))
								throw new Exception();
							updateDL();
							JOptionPane.showMessageDialog(null,"Xóa thành công!");
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Xóa không thành công!");
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn một khách hàng cần xóa!");
				}
		    	
			}
		});
		btnXoa.setFocusable(false);
		btnXoa.setBounds(609, 275, 123, 49);
		panel_2.add(btnXoa);
		btnXoa.setIcon(new ImageIcon("data\\icons\\delete1.png"));
		btnXoa.setBackground(Color.WHITE);
		
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
		
		
		JLabel lblMaKH = new JLabel("Mã KH:");
		lblMaKH.setBounds(44, 24, 52, 14);
		panel_1.add(lblMaKH);
		
		JLabel lblTenKH = new JLabel("Tên KH:");
		lblTenKH.setBounds(44, 49, 52, 20);
		panel_1.add(lblTenKH);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setBounds(387, 52, 64, 14);
		panel_1.add(lblDiaChi);
		
		JLabel lblDT = new JLabel("Điện thoại:");
		lblDT.setBounds(387, 24, 64, 14);
		panel_1.add(lblDT);
		
		
			
		JButton btnTimKH = new JButton("Tìm KH");
		btnTimKH.addActionListener(new ActionListener() {
			
			private ArrayList<KhachHang> lskh;
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String dieuKien = "";
				String dieuKiennew = "";
				String and = "";
				if(cboMaKH.getSelectedIndex()!=-1 && !cboMaKH.getSelectedItem().toString().trim().equals("Không chọn"))
					dieuKien += "MaKH=N'"+cboMaKH.getSelectedItem().toString().trim() + "' and ";
				if(cboTenKH.getSelectedIndex()!=-1 && !cboTenKH.getSelectedItem().toString().equals("Không chọn"))
					dieuKien += "TenKH=N'"+cboTenKH.getSelectedItem().toString().trim() + "' and ";
				if(cboDT.getSelectedIndex()!=-1 && !cboDT.getSelectedItem().toString().trim().equals("Không chọn"))
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
					lskh = qlkh_DAO.searchKH(dieuKiennew);
					if(lskh.size()!=0) {
						XoaHetDuLieuTrenTableModel();
						int i=1	;
						for(KhachHang s : lskh) {
							model.addRow(new Object[] {		
									i++,"  " +s.getMaKH(),"  " +s.getMaLoaiKH(),"  " +s.getTenKH(),"  " +s.getGioiTinh(),"  " + formatter.format(s.getNgaySinh()),"  " +s.getSoCMND(),"  " +s.getDiaChi(),"  " +s.getTinh_TP(),"  " +s.getQuan_Huyen(), "  " + s.getSdt(), "  " + s.getGhiChu()
							});
						}
						table.setModel(model);
					}
					else {
						updateDL();
						JOptionPane.showMessageDialog(null, "Không tìm thấy!");					
					}
				}			
			}
		});
			
		
		btnTimKH.setFocusable(false);
		panel_1.add(btnTimKH);				
		
		btnTimKH.setBackground(Color.WHITE);
		btnTimKH.setIcon(new ImageIcon("data\\icons\\search.png"));
		btnTimKH.setBounds(729, 22, 122, 47);
		panel_1.add(btnTimKH);
		
		cboDT = new JComboBox();
		cboDT.setBackground(Color.WHITE);
		cboDT.setFocusable(false);
		cboDT.setBounds(461, 21, 226, 20);
		panel_1.add(cboDT);
		
		cboMaKH = new JComboBox();
		cboMaKH.setBackground(Color.WHITE);
		cboMaKH.setFocusable(false);
		cboMaKH.setBounds(91, 20, 226, 20);
		panel_1.add(cboMaKH);
		
		cboDiaChi = new JComboBox();
		cboDiaChi.setBackground(Color.WHITE);
		cboDiaChi.setFocusable(false);
		cboDiaChi.setBounds(461, 48, 226, 20);
		panel_1.add(cboDiaChi);
		
		cboTenKH = new JComboBox();
		cboTenKH.setBackground(Color.WHITE);
		cboTenKH.setFocusable(false);
		cboTenKH.setBounds(91, 49, 226, 20);
		panel_1.add(cboTenKH);
			
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 69, 895, 2);
		panel.add(separator);
		
		updateDLCbo();
	
	}

	private static void DocDLDB() {
		lqlkh = qlkh_DAO.getalltbKH();
		
	}
	
	private static void XoaHetDuLieuTrenTableModel() {
		model.getDataVector().removeAllElements();
	}
	
		public static void updateDL() {
			XoaHetDuLieuTrenTableModel();
			DocDLDB();
			updateDLCbo();
			int i=1	;
			for(KhachHang s : lqlkh) {
				model.addRow(new Object[] {		
						i++,"  " +s.getMaKH(),"  " +s.getMaLoaiKH(),"  " +s.getTenKH(),"  " +s.getGioiTinh(),"  " + formatter.format(s.getNgaySinh()),"  " +s.getSoCMND(),"  " +s.getDiaChi(),"  " +s.getTinh_TP(),"  " +s.getQuan_Huyen(), "  " + s.getSdt(), "  " + s.getGhiChu()
				});
			}
			table.setModel(model);
		}
	
	private static void updateDLCbo() {
		cboMaKH.removeAllItems();
		cboTenKH.removeAllItems();
		cboDT.removeAllItems();
		cboDiaChi.removeAllItems();
		
		cboMaKH.addItem("Không chọn");
		cboTenKH.addItem("Không chọn");
		cboDT.addItem("Không chọn");
		cboDiaChi.addItem("Không chọn");
		
		for(KhachHang s : lqlkh) {
			cboMaKH.addItem(s.getMaKH().trim());
			cboTenKH.addItem(s.getTenKH().trim());
			cboDT.addItem(s.getSdt().trim());
			cboDiaChi.addItem(s.getDiaChi().trim()+" - "+s.getQuan_Huyen().trim()+" - "+s.getTinh_TP().trim());
			
		}
			
		cboMaKH.setSelectedIndex(-1);
		cboTenKH.setSelectedIndex(-1);
		cboDT.setSelectedIndex(-1);
		cboDiaChi.setSelectedIndex(-1);
	}
}
