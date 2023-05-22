package co.edu.unicauca.openmarket.presentation.ui;

import javax.swing.JOptionPane;

/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class Messages {

    private Messages() {
    }

    public static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static int showConfirmDialog(String message, String title) {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

}
