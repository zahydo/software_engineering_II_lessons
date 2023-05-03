package co.edu.unicauca.openmarket.infra;

import javax.swing.JOptionPane;

/**
 *
 * @author Alex Torres
 */
public class Messages {

    public static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public static int showConfirmDialog(String message, String title) {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

}
