/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.pxu.view;

import edu.pxu.dialogcheck.sheardatta;
import edu.pxu.connect.ConnectJDBC;
import edu.pxu.dao.ChiTietDatHangDAO;
import edu.pxu.dao.DatHangDAO;
import edu.pxu.dao.KhachHangDAO;
import edu.pxu.dao.SanPhamDAO;
import edu.pxu.model.ChiTietDatHang;
import edu.pxu.model.DatHang;
import edu.pxu.model.KhachHang;
import edu.pxu.model.SanPham;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author uyenu
 */
public class GDBanHangJPanel extends javax.swing.JFrame {

    private ResultSet rs = null, rsCheck = null;
    private DefaultTableModel tblModel1, tblModel2, tblModel3;
    ArrayList<DatHang> lstdh;
    ArrayList<ChiTietDatHang> lstctdh;
    ArrayList<SanPham> lstsanpham;
    ArrayList<KhachHangJPanel> lstKhachhang;
    KhachHangDAO dao = new KhachHangDAO();
    String strfi = "";
    private boolean Add = false, Change = false, Pay = false;
    private TableRowSorter sorter;

    /**
     * Creates new form BanHang
     */
    public GDBanHangJPanel() throws ClassNotFoundException, Exception {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        layhoadon();
        showdate();
        initTable2();
        loadsanpham();
        labletennv.setText(sheardatta.nguoiDangNhap.getHotennv());
        lablevaitro.setText(sheardatta.nguoiDangNhap.getChucvu());
        hh();
        initUI();
    }
    private void initUI() {
 
        ImageIcon webIcon = new ImageIcon("C:\\Users\\User\\OneDrive\\Documents\\NetBeansProjects\\QuanLyPetShopNCKH\\logotitle.png");
 
        setIconImage(webIcon.getImage());
 
        setTitle("Quản lý cửa hàng thú cưng");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void hh() {
        txtTimHoTen.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(txtTimHoTen.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(txtTimHoTen.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(txtTimHoTen.getText());
            }
        });
    }
    private void search(String str) {
        if (str.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(str));
        }
    }

    private void showdate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String dat = s.format(d);
        lbtDate.setText(dat);

    }

    private void layhoadon() {
        String sql = "select MaHoaDon,MANhanVien,NgayBan,TenKhachHang from hoadon left join khachhang on "
                + "hoadon.MaKhachHang = khachhang.MaKhachHang where trangthai=N'Chưa thanh toán'";
        try {
            Connection conn = ConnectJDBC.getConnection();
            String[] aray = {"mahoadon", "manhanvien", "ngayban", "tenkhachhang"};
            DefaultTableModel model = new DefaultTableModel(aray, 0);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vector vector = new Vector();
                vector.add(rs.getInt("MaHoaDon"));
                vector.add(rs.getInt("MANhanVien"));
                vector.add(rs.getDate("NgayBan"));
                vector.add(rs.getString("TenKhachHang"));
                model.addRow(vector);
            }
            tablehd.setModel(model);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

     private void layCTHOADON() throws SQLException, ClassNotFoundException, Exception {
        Connection conn = ConnectJDBC.getConnection();
        try {
            String sqll = "select machitiethoadon,sanpham.tensanpham,chitiethoadon.SoLuongban,sanpham.GiaSP,chitiethoadon.Thanhtien from chitiethoadon left join sanpham "
                    + "on chitiethoadon.MASanpham = sanpham.MAsanpham where MaHoaDon =" + txtmahd.getText() + "";
            String[] aray = {"STT", "Tên sản phẩm", "Số lượng", "Giá bán", "Thành tiền"};
            DefaultTableModel model = new DefaultTableModel(aray, 0);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqll);
            while (rs.next()) {
                Vector vector = new Vector();
                vector.add(rs.getInt("machitiethoadon"));
                vector.add(rs.getString("tensanpham"));
                vector.add(rs.getInt("SoLuongban"));
                vector.add(rs.getFloat("GiaSP"));
                vector.add(rs.getFloat("Thanhtien"));
                model.addRow(vector);
            }
            tablecthoadon.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initTable2() {
        tblModel3 = new DefaultTableModel();
        tblModel3.setColumnIdentifiers(new String[]{"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng còn"});
        tablesp.setModel(tblModel3);
    }
    
    private void loadsanpham() throws SQLException, ClassNotFoundException, Exception{
        lstsanpham = SanPhamDAO.getAll();
        tblModel3.setRowCount(0);
        for(SanPham bnv : lstsanpham){
            Object[] object = new Object[]{bnv.getMasp(),bnv.getTensp(),bnv.getGiasp(),bnv.getSoluong()};
            tblModel3.addRow(object);
        }
        tblModel3.fireTableDataChanged();
    }
    

    private void tongtien() {
        String sql = "select sum(thanhtien) as thanhtien  from chitiethoadon where MaHoaDon =" + txtmahd.getText() + "";
        try {
            Connection conn = ConnectJDBC.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                txttienphaitraa.setText(String.valueOf(rs.getFloat("thanhtien")));
                txtthanhtien.setText(String.valueOf(rs.getFloat("thanhtien")));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void inhoadon() {
        // Tạo chuỗi định dạng văn bản để lưu các giá trị trong bảng
     
        Random rand = new Random();
        int randomNumber = rand.nextInt(1000) + 1;
        StringBuilder sb = new StringBuilder();
        sb.append("\t\tPETSHOP BẢO NGỌC\n");
        sb.append("\t    99 Đặng Huy Trứ - TP Huế\n");
        sb.append("\t\tSĐT: 0913710000\n");
        sb.append("--------------------------------------------------\n");
        sb.append("\t\tHOÁ ĐƠN IN LẠI\n");
        sb.append("\n");
        sb.append("Số HĐ:\t\t\t\t\t00000").append(txtmahd.getText());
        sb.append("\n");
        sb.append("\n");
        sb.append("--------------------------------------------------\n");
        sb.append("STT\tTên sản phẩm\tSL\tGiá bán\tThành tiền\n");
        sb.append("--------------------------------------------------\n");
        for (int i = 0; i < tablecthoadon.getRowCount(); i++) {
            for (int j = 0; j < tablecthoadon.getColumnCount(); j++) {
                sb.append(tablecthoadon.getValueAt(i, j)).append("\t");
            }
            sb.append("\n");
            sb.append("--------------------------------------------------\n");
        }
        sb.append("Tổng tiền: \t\t\t\t").append(txtthanhtien.getText());
        sb.append("\n");
        sb.append("Tiền mặt: \t\t\t\t").append(txttienkhachdua.getText());
        sb.append("\n");
        sb.append("\n");
        sb.append("\tCảm ơn Quý khách. Hẹn gặp lại!\n");
        // Lưu chuỗi định dạng văn bản thành tệp văn bản
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Lưu tệp hóa đơn");
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (FileWriter fileWriter = new FileWriter(fileToSave + ".txt")) {
                fileWriter.write(sb.toString());
                JOptionPane.showMessageDialog(this, "In hoá đơn thành công !!!", "Xuất hóa đơn", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi khi lưu tệp: " + e.getMessage(), "Xuất hóa đơn", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        txtmasp = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btntaohd = new javax.swing.JButton();
        txtmahd = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtthanhtien = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txttienkhachdua = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbHTTT = new javax.swing.JComboBox<>();
        cbHTGH = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        btnthanhtoan = new javax.swing.JButton();
        btntrangchu = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        txttienphaitraa = new javax.swing.JTextField();
        txttienthuaa = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablehd = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        labletennv = new javax.swing.JLabel();
        lablevaitro = new javax.swing.JLabel();
        lbtDate = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablecthoadon = new javax.swing.JTable();
        btnxoaallsp = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btnthemsp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTimHoTen = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablesp = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();

        txtmasp.setForeground(new java.awt.Color(255, 0, 0));

        txtsoluong.setText("jLabel6");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(txtsoluong)
                .addGap(18, 18, 18)
                .addComponent(txtmasp, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(txtsoluong))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(txtmasp, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(199, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Đơn hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        btntaohd.setBackground(new java.awt.Color(102, 255, 102));
        btntaohd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btntaohd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pxu/icon/them.png"))); // NOI18N
        btntaohd.setText("Tạo");
        btntaohd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntaohdActionPerformed(evt);
            }
        });

        txtmahd.setText("...");

        jLabel9.setText("Tổng tiền:");

        jLabel7.setText("Mã hóa đơn:");

        txtthanhtien.setText("...");

        jLabel18.setText("VND");

        jLabel19.setText("VND");

        jLabel10.setText("Giảm giá:");

        jLabel11.setText("Thanh toán:");

        jLabel21.setText("VND");

        jLabel22.setText("VND");

        txttienkhachdua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttienkhachduaKeyReleased(evt);
            }
        });

        jLabel12.setText("Tiền khách đưa:");

        jLabel13.setText("Tiền thừa trả khách:");

        jLabel23.setText("VND");

        jLabel14.setText("Hình thức thanh toán:");

        jLabel15.setText("Hình thức giao hàng:");

        cbHTTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản", "COD" }));

        cbHTGH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tại quầy", "GHTK" }));

        jButton9.setBackground(new java.awt.Color(153, 153, 153));
        jButton9.setText("Hủy hóa đơn");

        jButton10.setBackground(new java.awt.Color(153, 153, 153));
        jButton10.setText("Làm mới");

        btnthanhtoan.setBackground(new java.awt.Color(102, 255, 51));
        btnthanhtoan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnthanhtoan.setText("THANH TOÁN");
        btnthanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthanhtoanActionPerformed(evt);
            }
        });

        btntrangchu.setBackground(new java.awt.Color(102, 153, 255));
        btntrangchu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btntrangchu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pxu/icon/undo.png"))); // NOI18N
        btntrangchu.setText("Trang chủ");
        btntrangchu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntrangchuActionPerformed(evt);
            }
        });

        jTextField1.setText("0");

        txttienphaitraa.setText("...");

        txttienthuaa.setText("...");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtmahd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttienphaitraa)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtthanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTextField1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnthanhtoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btntaohd, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btntrangchu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbHTTT, 0, 139, Short.MAX_VALUE)
                            .addComponent(cbHTGH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttienkhachdua, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(txttienthuaa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtmahd)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtthanhtien))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txttienphaitraa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21)))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel9)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txttienkhachdua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel12)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txttienthuaa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbHTGH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnthanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntrangchu)
                    .addComponent(btntaohd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Hóa đơn chờ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N
        jPanel8.setPreferredSize(new java.awt.Dimension(300, 200));

        tablehd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablehd.setMaximumSize(new java.awt.Dimension(200, 80));
        tablehd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablehdMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablehd);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tài khoản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        labletennv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labletennv.setText("...");

        lablevaitro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lablevaitro.setText("...");

        lbtDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbtDate.setText("...");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lablevaitro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labletennv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(lbtDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labletennv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lablevaitro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbtDate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tablecthoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên sản phẩm", "Số lượng", "Giá bán", "Thành tiền"
            }
        ));
        tablecthoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablecthoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablecthoadon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnxoaallsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pxu/icon/xoa.png"))); // NOI18N
        btnxoaallsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaallspActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnxoaallsp)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnxoaallsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        btnthemsp.setText("Thêm sản phẩm");
        btnthemsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemspActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Tìm kiếm sản phẩm:");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(txtTimHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnthemsp)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnthemsp))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtTimHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        tablesp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablesp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablespMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablesp);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(102, 102, 102));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Cửa hàng thú cưng PETSHOP - 99 Đặng Huy Trứ - Hotline : 0913710000 - Email : petshop@gmail.com.vn ");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));

        jLabel16.setBackground(new java.awt.Color(255, 153, 102));
        jLabel16.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("QUẢN LÝ CỬA HÀNG THÚ CƯNG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tablehdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablehdMouseClicked
        // TODO add your handling code here:
        try {
            int row = tablehd.getSelectedRow();
            if (row >= 0) {
                int madonhang = (int) tablehd.getValueAt(row, 0);
                DatHangDAO nvd = new DatHangDAO();
                DatHang b = nvd.Find(madonhang);
                if (b != null) {
                    txtmahd.setText(Integer.toString(b.getMadh()));
//                    txtmakh.setText(b.getMakh());
//                    cbHTTT.setSelectedItem(b.getHinhThucThanhToan());
//                    cbHTGH.setSelectedItem(b.getHinhThucGiaoHang());
                }
            }
            layCTHOADON();
            tongtien();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tablehdMouseClicked

    private void btntaohdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntaohdActionPerformed
        try {
            StringBuilder sb = new StringBuilder();
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(rootPane, sb);
                return;
            }
            KhachHang kh = new KhachHang();
            kh.setTenkh("Khách hàng");
            kh.setSdt("0");
            kh.setDiemtl(Integer.parseInt("0"));
            KhachHangDAO doo = new KhachHangDAO();
            doo.insert(kh);
            String sql = "select * from nhanvien where tennhanvien=N'" + labletennv.getText() + "'";
            Connection conn = ConnectJDBC.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                DatHang h = new DatHang();
                String makh = "SELECT MaKhachHang FROM khachhang order by MaKhachHang desc limit 1";
                Statement stmtt = conn.createStatement();
                ResultSet rss = stmtt.executeQuery(makh);
                if (rss.next()) {
                    h.setMakh(rss.getInt("Makhachhang"));
                }
                txtmahd.setText(Integer.toString(h.getMadh()));
                h.setManv(rs.getString("manhanvien"));
                h.setNgaydat(java.sql.Date.valueOf(lbtDate.getText())); // Assuming lbtDate.getText() is a valid date string
                h.setTongtien(Float.valueOf(0));
                h.setTrangthai("Chưa thanh toán");
                DatHangDAO dao = new DatHangDAO();
                dao.insertOrder(h);
                layhoadon();
            }
        } catch (Exception ex) {
            Logger.getLogger(GDBanHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btntaohdActionPerformed

    private void tablespMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablespMouseClicked
        int row = tablesp.getSelectedRow();
        if (row >= 0) {
            try {
                int masp = (int) tablesp.getValueAt(row, 0);

                String t = JOptionPane.showInputDialog(this, "Nhập số lượng !!!");
                if (t != null && !t.trim().isEmpty()) {
                    int inputQuantity = Integer.parseInt(t);
                    String sqlchek = "SELECT * FROM SANPHAM WHERE MaSanPham = '" + masp + "'";
                    
                    try {
                        Connection conn = ConnectJDBC.getConnection();
                        Statement stmt = conn.createStatement();
                        rs = stmt.executeQuery(sqlchek);
                        
                        while (rs.next()) {
                            int availableQuantity = rs.getInt("SOLUONG");
                            float unitPrice = rs.getFloat("GIASP");
                            
                            float totalAmount = inputQuantity * unitPrice;

                            if (availableQuantity >= inputQuantity) {
                                ChiTietDatHang bnv = new ChiTietDatHang();
                                bnv.setMasp(masp);
                                bnv.setMahd(Integer.parseInt(txtmahd.getText()));
                                bnv.setSoluong(Integer.parseInt(t));
                                bnv.setGiasp(unitPrice);
                                bnv.setThanhtien(totalAmount);
                                
                                ChiTietDatHangDAO nvdd = new ChiTietDatHangDAO();
                                nvdd.insert(bnv);

                                SanPham sp = new SanPham();
                                sp.setMasp(masp);
                                int soluongcon = availableQuantity - inputQuantity;
                                sp.setSoluong(soluongcon);
                                SanPhamDAO d = new SanPhamDAO();
                                d.update2(sp);
                                     
                                
                                
                                tongtien();
                                layCTHOADON();
                                loadsanpham();
//                                    String formattedTotal = String.format("%.2f", totalAmount); // Format total as desired

                                // Update UI components with the calculated total amount
//                                     txtthanhtien.setText(formattedTotal);
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Số lượng bán ra vượt quá số lượng trong kho !!!");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    // Handle case when input is empty or canceled
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập số lượng hợp lệ !!!");
            } catch (Exception ex) {
                Logger.getLogger(GDBanHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_tablespMouseClicked

    private void txttienkhachduaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttienkhachduaKeyReleased
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        txttienkhachdua.setText(txttienkhachdua.getText());

        if (txttienkhachdua.getText().equals("")) {
            txttienthuaa.setText("0");
        } else {
            txttienkhachdua.setText(txttienkhachdua.getText());
            String s1 = txttienkhachdua.getText().replace("", ""); // Remove commas
            String[] s2 = txttienphaitraa.getText().split("\\s");

            float s1Value = Float.parseFloat(s1);
            float s2Value = Float.parseFloat(s2[0]);

            if (s1Value >= s2Value) {
                txttienthuaa.setText(formatter.format(s1Value - s2Value));
            } else {
                txttienthuaa.setText(formatter.format(s1Value - s2Value));
            }
        }

    }//GEN-LAST:event_txttienkhachduaKeyReleased

    private void btnthanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthanhtoanActionPerformed
        inhoadon();
        try {
            try {
                DatHang hh = new DatHang();
                hh.setMadh(Integer.valueOf(txtmahd.getText()));
                hh.setTongtien(Float.parseFloat(txtthanhtien.getText()));
                hh.setTrangthai("Đã thanh toán");
                DatHangDAO dao = new DatHangDAO();
                dao.update(hh);
                layhoadon();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GDBanHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(GDBanHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtmahd.setText("0");
            layCTHOADON();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GDBanHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(GDBanHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnthanhtoanActionPerformed

    private void btnxoaallspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaallspActionPerformed

        try {
            int maHD = Integer.parseInt(txtmahd.getText());

//            String sql = "SELECT sanpham.SOLUONG AS sl, sanpham.MaSanPham AS masp, chitiethoadon.SoLuongban AS ctsl "
//                    + "FROM chitiethoadon "
//                    + "LEFT JOIN sanpham ON chitiethoadon.MASanPham = sanpham.MASanPham "
//                    + "WHERE MaHoaDon = ?";
//
//            Connection conn = ConnectJDBC.getConnection();
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setInt(1, maHD);
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                SanPham sp = new SanPham();
//                sp.setMasp(rs.getInt("masp"));
//                sp.setSoluong(rs.getInt("ctsl") + rs.getInt("sl"));
//
//                SanPhamDAO doa = new SanPhamDAO();
//                doa.update1(sp);
//            }

            ChiTietDatHang cthd = new ChiTietDatHang();
            cthd.setMahd(maHD);
            ChiTietDatHangDAO daoo = new ChiTietDatHangDAO();
            daoo.delete(cthd);

            layCTHOADON();
            loadsanpham();
        } catch (NumberFormatException ex) {
            Logger.getLogger(GDBanHangJPanel.class.getName()).log(Level.SEVERE, "Invalid MaHD format", ex);
        } catch (SQLException ex) {
            Logger.getLogger(GDBanHangJPanel.class.getName()).log(Level.SEVERE, "SQL error", ex);
        } catch (Exception ex) {
            Logger.getLogger(GDBanHangJPanel.class.getName()).log(Level.SEVERE, "An error occurred", ex);
        }


    }//GEN-LAST:event_btnxoaallspActionPerformed

    private void tablecthoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablecthoadonMouseClicked
        int row = tablecthoadon.getSelectedRow();
        if (row >= 0) {
            try {
                int mact = (int) tablecthoadon.getValueAt(row, 0);
                SanPham sp = new SanPham();
                String sql = "select sanpham.SOLUONG as sl,sanpham.MaSanPham as masp,chitiethoadon.SoLuongban as ctsl "
                        + " from chitiethoadon left join sanpham on chitiethoadon.MASanPham = sanpham.MASanPham  where machitiethoadon = '" + mact + "'";
                Connection conn = ConnectJDBC.getConnection();
                Statement stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    sp.setMasp(rs.getInt("masp"));
                    sp.setSoluong(rs.getInt("ctsl") + rs.getInt("sl"));
                }
                SanPhamDAO doa = new SanPhamDAO();
                doa.update2(sp);

                ChiTietDatHang ct = new ChiTietDatHang();
                ct.setMactdh(mact);
                ChiTietDatHangDAO dao = new ChiTietDatHangDAO();
                dao.deletect(ct);
                layCTHOADON();
                loadsanpham();
                tongtien();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GDBanHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(GDBanHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tablecthoadonMouseClicked

    private void btnthemspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemspActionPerformed
        // TODO add your handling code here:
        SanPhamJPanel h = null;
        try {
            h = new SanPhamJPanel();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(MenuJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnthemspActionPerformed

    private void btntrangchuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntrangchuActionPerformed
        MenuJPanel h = new MenuJPanel();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btntrangchuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GDBanHangJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GDBanHangJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GDBanHangJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GDBanHangJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GDBanHangJPanel().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(GDBanHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btntaohd;
    private javax.swing.JButton btnthanhtoan;
    private javax.swing.JButton btnthemsp;
    private javax.swing.JButton btntrangchu;
    private javax.swing.JButton btnxoaallsp;
    private javax.swing.JComboBox<String> cbHTGH;
    private javax.swing.JComboBox<String> cbHTTT;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton9;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labletennv;
    private javax.swing.JLabel lablevaitro;
    private javax.swing.JLabel lbtDate;
    private javax.swing.JTable tablecthoadon;
    private javax.swing.JTable tablehd;
    private javax.swing.JTable tablesp;
    private javax.swing.JTextField txtTimHoTen;
    private javax.swing.JLabel txtmahd;
    private javax.swing.JLabel txtmasp;
    private javax.swing.JLabel txtsoluong;
    private javax.swing.JLabel txtthanhtien;
    private javax.swing.JTextField txttienkhachdua;
    private javax.swing.JTextField txttienphaitraa;
    private javax.swing.JTextField txttienthuaa;
    // End of variables declaration//GEN-END:variables
}
