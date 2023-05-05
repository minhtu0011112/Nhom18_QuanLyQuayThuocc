package class_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import class_ThongKeExcel.InThongKeExcel;
import class_connectDB.ConnectDB;
import class_equipment.DateLabelFormatter;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class ThongKeDoanhThu_GUI extends JFrame implements ActionListener,MouseListener{

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private Properties p;
	private UtilDateModel model1, model2;
	private JDatePanelImpl datePanel1, datePanel2;
	private JDatePickerImpl datePicker1, datePicker2;
	private JLabel lblthongKeTuan;
	private JLabel lbltongCong,lblngay,lblt;
	private JButton btninBaoCao,btnDong,btnthongKe;
	
	
	
	public ThongKeDoanhThu_GUI() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/about.png")));
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setTitle("Giao Diện Thống Kê Doanh Thu ");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 692, 705);
		setLocationRelativeTo(null);
		taoGiaoDien();
	}
	public void taoGiaoDien() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] headers="STT;Ngày;Tổng Số Hóa Đơn;Tổng Tiền Bán".split(";");
		tableModel =new DefaultTableModel(headers, 0);
		JScrollPane scrollPane = new JScrollPane(table=new JTable(tableModel), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.addMouseListener(this);
		scrollPane.setBounds(10, 113, 656, 419);
		contentPane.add(scrollPane);
		
		JLabel lbltuNgay = new JLabel("Từ Ngày :");
		lbltuNgay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbltuNgay.setBounds(135, 76, 133, 27);
		contentPane.add(lbltuNgay);
		
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		model1 = new UtilDateModel(Date.valueOf(LocalDate.now()));
		datePanel1 = new JDatePanelImpl(model1, p);
		datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		datePicker1.getJFormattedTextField().setBackground(Color.WHITE);
		datePicker1.setBackground(Color.WHITE);
		contentPane.add(datePicker1);
		datePicker1.setBounds(236, 76, 119, 21);

		
		JLabel label = new JLabel("-");
		label.setBounds(365, 84, 23, 13);
		contentPane.add(label);
		
		model2 = new UtilDateModel(Date.valueOf(LocalDate.now()));
		datePanel2 = new JDatePanelImpl(model2, p);
		datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		datePicker2.getJFormattedTextField().setBackground(Color.WHITE);
		datePicker2.setBackground(Color.WHITE);
		contentPane.add(datePicker2);
		datePicker2.setBounds(379, 76, 119, 21);
		
		lblthongKeTuan = new JLabel("THỐNG KÊ DOANH THU ");
		lblthongKeTuan.setForeground(Color.BLUE);
		lblthongKeTuan.setHorizontalAlignment(SwingConstants.LEFT);
		lblthongKeTuan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblthongKeTuan.setBounds(231, 10, 233, 36);
		contentPane.add(lblthongKeTuan);
		
		lbltongCong = new JLabel("Tổng Cộng :");
		lbltongCong.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbltongCong.setBounds(10, 542, 99, 27);
		contentPane.add(lbltongCong);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(77, 580, 544, 79);
		contentPane.add(panel);
		
		btninBaoCao = new JButton("In Báo Cáo");
		//btninBaoCao.setIcon(new ImageIcon(getClass().getResource("/printer.png")));
		btninBaoCao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btninBaoCao.setBackground(Color.WHITE);
		btninBaoCao.setBounds(274, 25, 126, 31);
		panel.add(btninBaoCao);
		
		btnDong = new JButton("Đóng");
		btnDong.setToolTipText("Đóng");
		//btntroVe.setIcon(new ImageIcon(getClass().getResource("/exit.png")));
		btnDong.setIcon(new ImageIcon("data\\icons\\exit1.png"));
		btnDong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDong.setBackground(Color.WHITE);
		btnDong.setBounds(410, 25, 124, 31);
		panel.add(btnDong);
		
		btnthongKe = new JButton("Thống Kê");
		btnthongKe.setToolTipText("Thống Kê");
		//btnthongKe.setIcon(new ImageIcon(getClass().getResource("/analytics1.png")));
		btnthongKe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnthongKe.setBackground(Color.WHITE);
		btnthongKe.setBounds(529, 72, 119, 31);
		contentPane.add(btnthongKe);
		
		lblt = new JLabel("");
		lblt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblt.setBounds(112, 542, 99, 27);
		contentPane.add(lblt);
		
		JLabel lblNgy = new JLabel("Ngày :");
		lblNgy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgy.setBounds(529, 0, 64, 27);
		contentPane.add(lblNgy);
		
		lblngay = new JLabel("\r\n");
		lblngay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblngay.setBounds(572, 0, 99, 27);
		contentPane.add(lblngay);
		LocalDate ngay=LocalDate.now();
		lblngay.setText(ngay+"");
		btninBaoCao.addActionListener(this);
		btnDong.addActionListener(this);
		btnthongKe.addActionListener(this);
		//capNhatBangDuLieu();
	}
	public void capNhatBangDuLieu() {	
		
		int dem = 1;
		int rowCount=table.getRowCount();
		for (int i = rowCount; i >0; i--) {
			tableModel.removeRow(i-1);
		}
		try {
			Date ngayBD = Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth() +1, model1.getDay()));
			Date ngayEnd = Date.valueOf(LocalDate.of(model2.getYear(), model2.getMonth() +1, model2.getDay()));
			ConnectDB.getInstance();
			Connection con=ConnectDB.getConnection();
			String sql="select * from [dbo].[ThongKeDoanhThuTheoNgay]('"+ngayBD+"','"+ngayEnd+"')";
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while (rs.next()) {
				String ngay = rs.getString(1);
				int tong = rs.getInt(2);
				double tongTien = rs.getDouble(3);
				String[] rowData= {dem+"",ngay,tong+"",tongTien+""};
				tableModel.addRow(rowData);
				dem++;
			}
			table.setModel(tableModel);
			tinhTong();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void tinhTong() {
		double t=0;
		int rowCount=table.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			String tong=(String) table.getValueAt(i, 3);
			Double tien=Double.parseDouble(tong);
			t+=tien;
		}
		lblt.setText(t+" VND");
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o.equals(btnthongKe)) {
			capNhatBangDuLieu();
		} else if(o.equals(btninBaoCao)) {
			Date ngayBD = Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth() +1, model1.getDay()));
			Date ngayEnd = Date.valueOf(LocalDate.of(model2.getYear(), model2.getMonth() +1, model2.getDay()));
			InThongKeExcel tk = new InThongKeExcel();
			tk.xuatFileExcelDoanhThu(ngayBD, ngayEnd);
		}else if(o.equals(btnDong)) {
			setVisible(false);
		}
		
	}
}

