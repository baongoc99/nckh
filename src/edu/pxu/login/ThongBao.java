
package edu.pxu.login;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ThongBao {
     public static void showMessageDialog(Component parent, String content, String title){
        JOptionPane.showMessageDialog(parent,  title,content, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void showErrorDialog(Component parent, String content, String title){
        JOptionPane.showMessageDialog(parent,  title, content,JOptionPane.ERROR_MESSAGE);
    }
    public static int showConfirmDialog(Component parent, String content, String title){
       int chooser= JOptionPane.showConfirmDialog(parent, title, content,JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       return chooser;
    }
}
