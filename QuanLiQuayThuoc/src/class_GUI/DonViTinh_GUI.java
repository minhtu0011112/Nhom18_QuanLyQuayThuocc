package class_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


import class_DAO.DonViTinh_DAO;
import class_connectDB.ConnectDB;
import class_entity.DonViTinh;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DonViTinh_GUI extends JFrame{

	private JPanel contentPane;
	private static JTable table;
	private static DefaultTableModel model;
	private JScrollPane scrollPane;
	public static List<DonViTinh> ldvt;
	private static DonViTinh_DAO dvt_DAO;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonViTinh_GUI frame = new DonViTinh_GUI();
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
	public DonViTinh_GUI() {
		
		ConnectDB.getInstance().connect();
		dvt_DAO = new DonViTinh_DAO();
		DocDLDB();
		
		setResizable(false);
		setTitle("Đơn Vị Tính");
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 543, 559);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
	
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBackground(Color.WHITE);
		contentPane.add(horizontalBox, BorderLayout.NORTH);
		
		JLabel label = new JLabel("   ");
		horizontalBox.add(label);
		
		JLabel lblnVTnh = new JLabel("\u0110\u01A0N V\u1ECA T\u00CDNH");
		lblnVTnh.setForeground(Color.BLUE);
		lblnVTnh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblnVTnh.setBackground(Color.WHITE);
		lblnVTnh.setToolTipText("\u0110\u01A0N V\u1ECA T\u00CDNH");
		horizontalBox.add(lblnVTnh);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setBackground(Color.WHITE);
//		lblNewLabel.setIcon(new ImageIcon("data\\icons\\logo3.png"));
//		horizontalBox.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 418, 619, 2);
		panel.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 0, 619, 2);
		panel.add(separator);
		
		
		
		String[] headers = {"STT", "Mã Đơn Vị Tính", "Tên Đơn Vị Tính"};
		model = new DefaultTableModel(headers, 0);
		table = new JTable(model);
		table.setBackground(Color.WHITE);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setMaxWidth(35);
		table.getColumnModel().getColumn(1).setPreferredWidth(280);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		JTableHeader Theader = table.getTableHeader();
		Theader.setBackground(Color.white);
		Theader.setFont(new Font("Tahome", Font.BOLD, 13));
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 36, 507, 378);
		panel.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel(">>Danh s\u00E1ch \u0111\u01A1n v\u1ECB t\u00EDnh");
		lblNewLabel_1.setBounds(10, 11, 144, 14);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Th\u00EAm M\u1EDBi");
		btnAdd.setIcon(new ImageIcon("data\\icons\\add.png"));
		btnAdd.setFocusable(false);
		panel_1.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DonViTinh_ADD_GUI dvtadd = new DonViTinh_ADD_GUI();
				dvtadd.setVisible(true);
			}
		});
		
		JButton btnEdit = new JButton("S\u1EEDa");
		btnEdit.setIcon(new ImageIcon("data\\icons\\changeca.png"));
		btnEdit.setFocusable(false);
		panel_1.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if(row != -1) {
					DonViTinh_EDIT_GUI dvtedit = new DonViTinh_EDIT_GUI(model.getValueAt(row, 1).toString().trim());
					dvtedit.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 loại Đơn Vị Tính để sửa!");
				}
			}
		});
		
		JButton btnDelete = new JButton("X\u00F3a");
		btnDelete.setIcon(new ImageIcon("data\\icons\\delete.png"));
		btnDelete.setFocusable(false);
		panel_1.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if(row != -1) {
					String hc = model.getValueAt(row, 1).toString().trim();
					int nhacnho = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa không?", "Chú ý", JOptionPane.YES_NO_OPTION);
					if(nhacnho == JOptionPane.YES_OPTION) {
						try {
							if (!dvt_DAO.delete(hc))
								throw new Exception();
							updateDL();
							JOptionPane.showMessageDialog(null,"Xóa thành công!");
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Xóa không thành công!");
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 đơn vị tính cần xóa!");
				}
			}
		});
		
		JButton btnExit = new JButton("Tho\u00E1t");
		btnExit.setIcon(new ImageIcon("data\\icons\\exit.png"));
		btnExit.setFocusable(false);
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		panel_1.add(btnExit);
		updateDL();
	}
	private static void DocDLDB() {
		ldvt = dvt_DAO.getalltbDVT();
	}
	private static void XoaHetDuLieuTrenTableModel() {
		model.getDataVector().removeAllElements();
	}
	public static void updateDL() {
		XoaHetDuLieuTrenTableModel();
		DocDLDB();
		int i=1;
		for(DonViTinh s : ldvt) {
			model.addRow(new Object[] {
				i++,"  " + s.getMaDV(),"  " + s.getTenDonVi()
			});
		}
		table.setModel(model);
	}
}
