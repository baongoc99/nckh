
package edu.pxu.view;

import edu.pxu.dialogcheck.sheardatta;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class MenuJPanel extends javax.swing.JFrame {

    public MenuJPanel() {
        initComponents();
        setTitle("");
        initUI();
        lbltendangnhap.setText(sheardatta.nguoiDangNhap.getHotennv());
        lblchucvu.setText(sheardatta.nguoiDangNhap.getChucvu());
        
    }
    
    private void initUI() {
 
        ImageIcon webIcon = new ImageIcon("C:\\Users\\User\\OneDrive\\Documents\\NetBeansProjects\\QuanLyPetShopNCKH\\logotitle.png");
 
        setIconImage(webIcon.getImage());
 
        setTitle("Quản lý cửa hàng thú cưng");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnnhanvien = new javax.swing.JButton();
        btnsanpham = new javax.swing.JButton();
        btnkhachang = new javax.swing.JButton();
        btnhoadon = new javax.swing.JButton();
        btnbanhang = new javax.swing.JButton();
        btnthongke = new javax.swing.JButton();
        btndoimk = new javax.swing.JButton();
        btndangxuat = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lbltendangnhap = new javax.swing.JLabel();
        lblchucvu = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        btnnhanvien.setBackground(new java.awt.Color(255, 204, 204));
        btnnhanvien.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnnhanvien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pxu/icon/Nhân viên.png"))); // NOI18N
        btnnhanvien.setText("NHÂN VIÊN");
        btnnhanvien.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnnhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnhanvienActionPerformed(evt);
            }
        });

        btnsanpham.setBackground(new java.awt.Color(255, 204, 204));
        btnsanpham.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnsanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pxu/icon/Sản phẩm.png"))); // NOI18N
        btnsanpham.setText("SẢN PHẨM");
        btnsanpham.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnsanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsanphamActionPerformed(evt);
            }
        });

        btnkhachang.setBackground(new java.awt.Color(255, 204, 204));
        btnkhachang.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnkhachang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pxu/icon/Khách hàng.png"))); // NOI18N
        btnkhachang.setText("KHÁCH HÀNG");
        btnkhachang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnkhachang.setMaximumSize(new java.awt.Dimension(190, 76));
        btnkhachang.setMinimumSize(new java.awt.Dimension(190, 76));
        btnkhachang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkhachangActionPerformed(evt);
            }
        });

        btnhoadon.setBackground(new java.awt.Color(255, 204, 204));
        btnhoadon.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnhoadon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pxu/icon/hoadon.png"))); // NOI18N
        btnhoadon.setText("HÓA ĐƠN");
        btnhoadon.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhoadonActionPerformed(evt);
            }
        });

        btnbanhang.setBackground(new java.awt.Color(255, 204, 204));
        btnbanhang.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnbanhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pxu/icon/giaodien.png"))); // NOI18N
        btnbanhang.setText("GIAO DIỆN");
        btnbanhang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnbanhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbanhangActionPerformed(evt);
            }
        });

        btnthongke.setBackground(new java.awt.Color(255, 204, 204));
        btnthongke.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnthongke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pxu/icon/thongke.png"))); // NOI18N
        btnthongke.setText("THỐNG KÊ");
        btnthongke.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnthongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthongkeActionPerformed(evt);
            }
        });

        btndoimk.setBackground(new java.awt.Color(255, 204, 204));
        btndoimk.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btndoimk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pxu/icon/mk.png"))); // NOI18N
        btndoimk.setText("MẬT KHẨU");
        btndoimk.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btndoimk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndoimkActionPerformed(evt);
            }
        });

        btndangxuat.setBackground(new java.awt.Color(255, 204, 204));
        btndangxuat.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btndangxuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pxu/icon/dangxuat.png"))); // NOI18N
        btndangxuat.setText("THOÁT");
        btndangxuat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btndangxuat.setMaximumSize(new java.awt.Dimension(190, 76));
        btndangxuat.setMinimumSize(new java.awt.Dimension(190, 76));
        btndangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndangxuatActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 204, 204));
        jPanel5.setMaximumSize(new java.awt.Dimension(190, 76));
        jPanel5.setMinimumSize(new java.awt.Dimension(190, 76));

        lbltendangnhap.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbltendangnhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblchucvu.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        lblchucvu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbltendangnhap, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
            .addComponent(lblchucvu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lbltendangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblchucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btndoimk, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btndangxuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnhoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnnhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnbanhang, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnkhachang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnnhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnhoadon)
                    .addComponent(btnbanhang)
                    .addComponent(btnkhachang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnthongke)
                    .addComponent(btndoimk)
                    .addComponent(btndangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));

        jLabel2.setBackground(new java.awt.Color(255, 153, 153));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÝ CỬA HÀNG THÚ CƯNG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cửa hàng thú cưng PETSHOP - 99 Đặng Huy Trứ - Hotline : 0913710000 - Email : petshop@gmail.com.vn ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(50, 50, 50))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(758, 466));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btndoimkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndoimkActionPerformed
        DoiMatKhauJPanel h = null;
        try {
            h = new DoiMatKhauJPanel();
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MenuJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            h.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btndoimkActionPerformed

    private void btnnhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnhanvienActionPerformed
      
            NhanVienJPanel h = null;
        try {
            h = new NhanVienJPanel();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(MenuJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            h.setVisible(true);
            this.dispose();
        
    }//GEN-LAST:event_btnnhanvienActionPerformed

    private void btnkhachangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkhachangActionPerformed
       KhachHangJPanel h = null;
        try {
            h = new KhachHangJPanel();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(MenuJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            h.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnkhachangActionPerformed

    private void btnsanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsanphamActionPerformed
   
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
       
    }//GEN-LAST:event_btnsanphamActionPerformed

    private void btnbanhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbanhangActionPerformed
        
        String makh=null;
        GDBanHangJPanel h = null;
        try {
            h = new GDBanHangJPanel();
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MenuJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            h.setVisible(true);
         this.dispose();

    }//GEN-LAST:event_btnbanhangActionPerformed

    private void btnhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhoadonActionPerformed
        HoaDonJPanel h = null;
        try {
            h = new HoaDonJPanel();
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MenuJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            h.setVisible(true);
            this.dispose();
       
    }//GEN-LAST:event_btnhoadonActionPerformed

    private void btnthongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthongkeActionPerformed
        
            ThongKeJPanel h = null;
        try {
            h = new ThongKeJPanel();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MenuJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            h.setVisible(true);
            this.dispose();
        
    }//GEN-LAST:event_btnthongkeActionPerformed

    private void btndangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndangxuatActionPerformed
        // TODO add your handling code here:
        DangNhapJPanel h = new DangNhapJPanel();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btndangxuatActionPerformed
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
            java.util.logging.Logger.getLogger(KhachHangJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHangJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHangJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHangJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuJPanel().setVisible(true);
                
            }
        });
    }
   /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbanhang;
    private javax.swing.JButton btndangxuat;
    private javax.swing.JButton btndoimk;
    private javax.swing.JButton btnhoadon;
    private javax.swing.JButton btnkhachang;
    private javax.swing.JButton btnnhanvien;
    private javax.swing.JButton btnsanpham;
    private javax.swing.JButton btnthongke;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblchucvu;
    private javax.swing.JLabel lbltendangnhap;
    // End of variables declaration//GEN-END:variables
}
