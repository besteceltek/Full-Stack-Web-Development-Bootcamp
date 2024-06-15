package Core;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static void setTheme() {
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
    }

    public static void showMessage(String str) {
        String title;
        String message = switch (str) {
            case "fill" -> {
                title = "Error";
                yield "Please fill out all the fields!";
            }
            case "done" -> {
                title = "Sucess";
                yield "Successful";
            }
            case "notFound" -> {
                title = "Error";
                yield "Not found";
            }
            case "error" -> {
                title = "Error";
                yield "Bad request";
            }
            default -> {
                title = "Error";
                yield str;
            }
        };

        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static boolean isFieldListEmpty(JTextField[] fieldList) {
        for (JTextField field : fieldList) {
            if (isFieldEmpty(field)) return true;
        }
        return false;
    }

    public static boolean isComboBoxEmpty(JComboBox comboBox) {
        return comboBox.getSelectedItem() == null;
    }

    public static boolean isComboBoxListEmpty(JComboBox[] comboList) {
        for (JComboBox comboBox : comboList) {
            if (isComboBoxEmpty(comboBox)) return true;
        }
        return false;
    }

    public static int getLocationPoint(String type, Dimension size) {
        return switch (type) {
            case "x" -> (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
            case "y" -> (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
            default -> 0;
        };
    }

    public static boolean confirm(String str) {
        String msg;
        if(str.equals("sure")) {
            msg = "Are you sure?";
        } else {
            msg = str;
        }
        return JOptionPane.showConfirmDialog(null, msg, "Are your sure?", JOptionPane.YES_NO_OPTION) == 0;
    }
}
