
package edu.pxu.view;

import edu.pxu.connect.ConnectJDBC;
import edu.pxu.dialogcheck.sheardatta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class DoiMatKhauJPanel extends javax.swing.JFrame {

    
    public DoiMatKhauJPanel() throws SQLException, ClassNotFoundException, Exception {
        initComponents();
//        laytendn();
        initUI();
        jlbTendn.setText(sheardatta.nguoiDangNhap.getTendangnhap());
    }
    private void initUI() {
 
        ImageIcon webIcon = new ImageIcon("C:\\Users\\User\\OneDrive\\Documents\\NetBeansProjects\\QuanLyPetShopNCKH\\logotitle.png");
 
        setIconImage(webIcon.getImage());
 
        setTitle("Quản lý cửa hàng thú cưng");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
//    private void laytendn() throws SQLException, ClassNotFoundException, Exception{
//         Connection conn = ConnectJDBC.getConnection();
//        try {
//                Statement stmt = conn.createStatement();
//                
//                String sql = "select tendangnhap from nhanvien";
//                ResultSet rs = stmt.executeQuery(sql);
//                while(rs.next()){
//                   combotendn.addItem(rs.getString(1));
//                }
//                rs.close();
//                stmt.close();
//                conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    private boolean checktk() throws SQLException, ClassNotFoundException, Exception{
        boolean kq=false;
        String sql="select * from nhanvien where tendangnhap=? and matkhau=?";
        Connection conn = ConnectJDBC.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, jlbTendn.getText());
        pst.setString(2, String.valueOf(mk.getPassword()));
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            return  true;
        }
        return kq;
    }
     private boolean checkdoimk(){
        boolean kq=true;
        if(String.valueOf(mk.getPassword()).length()==0){
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập mật khẩu cũ !!!");
            return false;
        }
        if(String.valueOf(mk1.getPassword()).length()==0){
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập mật khẩu mới !!!");
            return false;
        }
        if(String.valueOf(mk2.getPassword()).length()==0){
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập lại mật khẩu mới !!!");
            return false;
        }
        return kq;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mk = new javax.swing.JPasswordField();
        mk1 = new javax.swing.JPasswordField();
        mk2 = new javax.swing.JPasswordField();
        jlbTendn = new javax.swing.JTextField();
        btndangnhap = new javax.swing.JButton();
        btndoimk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pxu/icon/edu.pxu.icon.png"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Tên đăng nhập:");
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setText("Mật khẩu cũ:");
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Mật khẩu mới:");
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Nhập lại mật khẩu mới:");
        jLabel5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        mk.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        mk1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        mk2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jlbTendn.setEditable(false);
        jlbTendn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlbTendnActionPerformed(evt);
            }
        });

        btndangnhap.setBackground(new java.awt.Color(255, 204, 204));
        btndangnhap.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btndangnhap.setText("Đăng nhập");
        btndangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndangnhapActionPerformed(evt);
            }
        });
        btndangnhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btndangnhapKeyPressed(evt);
            }
        });

        btndoimk.setBackground(new java.awt.Color(255, 204, 204));
        btndoimk.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btndoimk.setText("Đổi mật khẩu");
        btndoimk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndoimkActionPerformed(evt);
            }
        });
        btndoimk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btndoimkKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlbTendn)
                            .addComponent(mk1)
                            .addComponent(mk)
                            .addComponent(mk2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btndoimk)
                .addGap(38, 38, 38)
                .addComponent(btndangnhap)
                .addGap(97, 97, 97))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbTendn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mk2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndangnhap)
                    .addComponent(btndoimk))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(489, 501));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jlbTendnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlbTendnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbTendnActionPerformed

    private void btndangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndangnhapActionPerformed
        DangNhapJPanel h = new DangNhapJPanel();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btndangnhapActionPerformed

    private void btndangnhapKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btndangnhapKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btndangnhapKeyPressed

    private void btndoimkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndoimkActionPerformed
        // TODO add your handling code here:
        if(checkdoimk())
        try {
            if(checktk()){
                if( String.valueOf(mk1.getPassword()).equals(String.valueOf(mk2.getPassword()))){
                    String sqlChange="UPDATE nhanvien SET matkhau=? WHERE tendangnhap=N'"+jlbTendn.getText()+"'";
                    try{
                        Connection conn = ConnectJDBC.getConnection();
                        PreparedStatement pst=conn.prepareStatement(sqlChange);
                        pst.setString(1, String.valueOf(mk1.getPassword()));
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(rootPane, "Đổi mật khẩu thành công !!!");
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
                else JOptionPane.showMessageDialog(rootPane, "Nhập lại mật khẩu mới không chính xác !!!");
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Mật khẩu cũ không chính xác !!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoiMatKhauJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoiMatKhauJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DoiMatKhauJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btndoimkActionPerformed

    private void btndoimkKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btndoimkKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btndoimkKeyPressed

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
            java.util.logging.Logger.getLogger(DoiMatKhauJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DoiMatKhauJPanel().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DoiMatKhauJPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(DoiMatKhauJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndangnhap;
    private javax.swing.JButton btndoimk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jlbTendn;
    private javax.swing.JPasswordField mk;
    private javax.swing.JPasswordField mk1;
    private javax.swing.JPasswordField mk2;
    // End of variables declaration//GEN-END:variables
}
