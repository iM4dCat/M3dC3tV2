package dev.madcat.m3dc3t.util;



import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.lang.management.ManagementFactory;


public class FrameUtil {

    public static void Display(String neam,String neam2 ,String HWIDS) {
        Frame frame = new Frame(neam,neam2,HWIDS);
        frame.setVisible(false);
        throw new NOI("Verify HWID Failed!");

    }



    public static class Frame extends JFrame {

        public Frame(String naem, String nema2,String HWIDS) {

            this.setTitle("Hwid Detect");
            this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            this.setLocationRelativeTo(null);

            String message = naem + "\n" + "HWID: " + HWIDS + "\n(Copied to clipboard)";
            copyToClipboard(HWIDS);
            JOptionPane.showMessageDialog(this, message, nema2, JOptionPane.PLAIN_MESSAGE, UIManager.getIcon("OptionPane.warningIcon"));
            try {
                Runtime.getRuntime().exec("cmd.exe /c taskkill /F /PID " + ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            throw new NOI("Verify HWID Failed!");
        }




        public static void copyToClipboard(String s) {
            StringSelection selection = new StringSelection(s);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
        }
    }
}