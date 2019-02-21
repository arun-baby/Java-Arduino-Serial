/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motortest;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import communicaton.ArduinoSerial;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Arun
 */
public class UI extends javax.swing.JFrame {

    /**
     * Creates new form UITest
     */
    ArduinoSerial arduino;
    private SerialPort ports[], selectedPort;

    public UI() {
        initComponents();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }

        refreshPorts();
    }

    private void refreshPorts() {
        COMPort.removeAllItems();
        arduino = new ArduinoSerial();
        try {
            ports = arduino.getComPorts();
            if (ports.length > 0) {
                for (SerialPort port : ports) {
                    COMPort.addItem(port.getSystemPortName());
                }
                System.out.println(Arrays.toString(ports));
                log.setText(log.getText() + ports.length + " Ports detected: " + Arrays.toString(ports) + "\n");
            } else {
                log.setText(log.getText() + "No Ports detected.\n");
            }

            selectedPort.addDataListener(new SerialPortDataListener() {
                @Override
                public int getListeningEvents() {
                    return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
                }

                @Override
                public void serialEvent(SerialPortEvent event) {
                    if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {

                        if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
                            return;
                        }
                        byte[] newData = new byte[selectedPort.bytesAvailable()];
                        int numRead = selectedPort.readBytes(newData, newData.length);
                        String text = new String(newData);
                        System.out.println("Read " + numRead + " bytes.");
                        System.out.println(text);
                        log.setText(text);
                    }
                }

            });

        } catch (NullPointerException e) {
            System.out.println("No COM Ports detected.");
            log.setText(log.getText() + "No Ports detected, Plug an Arduino and try again.\n");
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

        jPanel1 = new javax.swing.JPanel();
        Home = new javax.swing.JButton();
        homeText = new javax.swing.JTextField();
        downText = new javax.swing.JTextField();
        Down = new javax.swing.JButton();
        Right = new javax.swing.JButton();
        Left = new javax.swing.JButton();
        leftText = new javax.swing.JTextField();
        UP = new javax.swing.JButton();
        rightText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextPane();
        upText = new javax.swing.JTextField();
        COMPort = new javax.swing.JComboBox<>();
        Connect = new javax.swing.JButton();
        refresh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arduino Motor Serial Test");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Home.setBackground(new java.awt.Color(0, 153, 204));
        Home.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        Home.setForeground(new java.awt.Color(255, 255, 255));
        Home.setText("HOME");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        homeText.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        downText.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        Down.setBackground(new java.awt.Color(0, 153, 204));
        Down.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        Down.setForeground(new java.awt.Color(255, 255, 255));
        Down.setText("DOWN");
        Down.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DownActionPerformed(evt);
            }
        });

        Right.setBackground(new java.awt.Color(0, 153, 204));
        Right.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        Right.setForeground(new java.awt.Color(255, 255, 255));
        Right.setText("RIGHT");
        Right.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RightActionPerformed(evt);
            }
        });

        Left.setBackground(new java.awt.Color(0, 153, 204));
        Left.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        Left.setForeground(new java.awt.Color(255, 255, 255));
        Left.setText("LEFT");
        Left.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeftActionPerformed(evt);
            }
        });

        leftText.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        UP.setBackground(new java.awt.Color(0, 153, 204));
        UP.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        UP.setForeground(new java.awt.Color(255, 255, 255));
        UP.setText("UP");
        UP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPActionPerformed(evt);
            }
        });

        rightText.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jScrollPane1.setViewportView(log);

        upText.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        COMPort.setBackground(new java.awt.Color(0, 153, 204));
        COMPort.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        COMPort.setForeground(new java.awt.Color(255, 255, 255));

        Connect.setBackground(new java.awt.Color(0, 153, 204));
        Connect.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        Connect.setForeground(new java.awt.Color(255, 255, 255));
        Connect.setText("Connect");
        Connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectActionPerformed(evt);
            }
        });

        refresh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/motortest/refresh_small_icon.png"))); // NOI18N
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 49, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Left, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Connect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(COMPort, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                            .addComponent(leftText))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(upText)
                                .addComponent(UP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(downText)
                                .addComponent(Down, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Right, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rightText, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(homeText, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(upText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(homeText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(COMPort, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(refresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Connect, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leftText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(downText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rightText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Left, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Down, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Right, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectActionPerformed
        // TODO add your handling code here:
        selectedPort = SerialPort.getCommPort((String) COMPort.getSelectedItem());
        selectedPort.openPort();
        System.out.println(selectedPort.isOpen());
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
        selectedPort.setBaudRate(115200);
        selectedPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 0, 0);
        if (selectedPort.isOpen()) {
            System.out.println("Arduino connected.");
            log.setText(log.getText() + "Arduino Connected.\n");

        } else {
            System.out.println("Arduino not connected.");
            log.setText(log.getText() + "Arduino not Connected.\n");
        }
    }//GEN-LAST:event_ConnectActionPerformed

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        // TODO add your handling code here:
        refreshPorts();
    }//GEN-LAST:event_refreshMouseClicked

    private void UPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPActionPerformed
        // TODO add your handling code here:
        if(upText.getText().equals("")){
            System.out.println("No Text sent");
            log.setText(log.getText() + "No Text sent.\n");
        } else {
            selectedPort.writeBytes(upText.getText().getBytes(), upText.getText().length());
            log.setText(log.getText() + "Text sent: "+upText.getText()+".\n");
        }
    }//GEN-LAST:event_UPActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // TODO add your handling code here:
        if(homeText.getText().equals("")){
            System.out.println("No Text sent");
            log.setText(log.getText() + "No Text sent.\n");
        } else {
            selectedPort.writeBytes(homeText.getText().getBytes(), homeText.getText().length());
            log.setText(log.getText() + "Text sent: "+homeText.getText()+".\n");
        }
    }//GEN-LAST:event_HomeActionPerformed

    private void LeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeftActionPerformed
        // TODO add your handling code here:
        if(leftText.getText().equals("")){
            System.out.println("No Text sent");
            log.setText(log.getText() + "No Text sent.\n");
        } else {
            selectedPort.writeBytes(leftText.getText().getBytes(), leftText.getText().length());
            log.setText(log.getText() + "Text sent: "+leftText.getText()+".\n");
        }
    }//GEN-LAST:event_LeftActionPerformed

    private void DownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DownActionPerformed
        // TODO add your handling code here:
        if(downText.getText().equals("")){
            System.out.println("No Text sent");
            log.setText(log.getText() + "No Text sent.\n");
        } else {
            selectedPort.writeBytes(downText.getText().getBytes(), downText.getText().length());
            log.setText(log.getText() + "Text sent: "+downText.getText()+".\n");
        }
    }//GEN-LAST:event_DownActionPerformed

    private void RightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightActionPerformed
        // TODO add your handling code here:
        if(rightText.getText().equals("")){
            System.out.println("No Text sent");
            log.setText(log.getText() + "No Text sent.\n");
        } else {
            selectedPort.writeBytes(rightText.getText().getBytes(), rightText.getText().length());
            log.setText(log.getText() + "Text sent: "+rightText.getText()+".\n");
        }
    }//GEN-LAST:event_RightActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         *//*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UITest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UITest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UITest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UITest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> COMPort;
    private javax.swing.JButton Connect;
    private javax.swing.JButton Down;
    private javax.swing.JButton Home;
    private javax.swing.JButton Left;
    private javax.swing.JButton Right;
    private javax.swing.JButton UP;
    private javax.swing.JTextField downText;
    private javax.swing.JTextField homeText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField leftText;
    private javax.swing.JTextPane log;
    private javax.swing.JLabel refresh;
    private javax.swing.JTextField rightText;
    private javax.swing.JTextField upText;
    // End of variables declaration//GEN-END:variables
}
