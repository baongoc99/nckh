
package edu.pxu.view;

import java.sql.SQLException;
import javax.swing.ImageIcon;

public class MenuJPanel extends javax.swing.JFrame {

    public MenuJPanel() {
        initComponents();
        setTitle("");
        initUI();
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
        btntaikhoan = new javax.swing.JButton();
        btnthongke = new javax.swing.JButton();
        btndoimk = new javax.swing.JButton();
        btndangxuat = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new java.awt.GridBagLayout());

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(btnnhanvien, gridBagConstraints);

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.weighty = 20.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(btnsanpham, gridBagConstraints);

        btnkhachang.setBackground(new java.awt.Color(255, 204, 204));
        btnkhachang.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnkhachang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pxu/icon/Khách hàng.png"))); // NOI18N
        btnkhachang.setText("KHÁCH HÀNG");
        btnkhachang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnkhachang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkhachangActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.weighty = 20.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(btnkhachang, gridBagConstraints);

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.weighty = 20.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(btnhoadon, gridBagConstraints);

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.weighty = 20.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(btnbanhang, gridBagConstraints);

        btntaikhoan.setBackground(new java.awt.Color(255, 204, 204));
        btntaikhoan.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btntaikhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pxu/icon/taikhoan.png"))); // NOI18N
        btntaikhoan.setText("TÀI KHOẢN");
        btntaikhoan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btntaikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntaikhoanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.weighty = 20.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(btntaikhoan, gridBagConstraints);

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.weighty = 20.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(btnthongke, gridBagConstraints);

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.weighty = 20.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(btndoimk, gridBagConstraints);

        btndangxuat.setBackground(new java.awt.Color(255, 204, 204));
        btndangxuat.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btndangxuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pxu/icon/dangxuat.png"))); // NOI18N
        btndangxuat.setText("THOÁT");
        btndangxuat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btndangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndangxuatActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.weighty = 20.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(btndangxuat, gridBagConstraints);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
                .addContainerGap())
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
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(797, 466));
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

    private void btntaikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntaikhoanActionPerformed
        
        
        
    }//GEN-LAST:event_btntaikhoanActionPerformed

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
    private javax.swing.JButton btntaikhoan;
    private javax.swing.JButton btnthongke;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
