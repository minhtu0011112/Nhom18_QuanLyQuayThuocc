package class_ThongKeExcel;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import class_DAO.ThongKeDoanhThu_DAO;
import class_entity.ThongKeDoanhThu;


public class InThongKeExcel {
	FileDialog fd = new FileDialog(new JFrame(), "Xuất excel", FileDialog.SAVE);

    private String getFile() {
        fd.setFile("untitled.xls");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("nullnull")) {
            return null;
        }
        return url;
    }

	// Xuất file Excel Doanh Thu   
    public void xuatFileExcelDoanhThu(java.sql.Date ngayBD,java.sql.Date ngayEnd) {
        fd.setTitle("Xuất dữ liệu doanh thu ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Doanh thu");

            ThongKeDoanhThu_DAO qlDT = new ThongKeDoanhThu_DAO();
            ArrayList<ThongKeDoanhThu> list = qlDT.getAllDoanhThu(ngayBD, ngayEnd);

            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Ngày");
            row.createCell(2, CellType.STRING).setCellValue("Tổng Số Hóa Đơn");
            row.createCell(3, CellType.STRING).setCellValue("Tổng Tiền Bán");

            for (ThongKeDoanhThu dt : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(String.valueOf(dt.getNgayLapHD()));
                row.createCell(2, CellType.STRING).setCellValue(dt.getTongSoHoaDon());
                row.createCell(3, CellType.STRING).setCellValue(dt.getTongSoTienBan());
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(InThongKeExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InThongKeExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(InThongKeExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
		HSSFFont font = workbook.createFont();
		font.setBold(true);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		return style;
	}
 
}
