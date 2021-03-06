/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockit;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ahmed
 */
public class managerLogin extends javax.swing.JFrame {

    private final String definedManager = "manager"; //hardcoded values for manage
    private final String definedPassword = "secret";
    private static String title;

    /**
     * Creates new form LoginGUI
     */
    public managerLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        usernameField = new javax.swing.JTextPane();
        passwordField1 = new javax.swing.JPasswordField();
        login_Button = new javax.swing.JButton();
        headerText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(title);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setName("loginframe"); // NOI18N
        setResizable(false);

        username.setText("Username:");
        username.setToolTipText("Enter your username");

        password.setText("Password:");
        password.setToolTipText("Enter your password");

        jScrollPane2.setViewportView(usernameField);

        passwordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordField1KeyPressed(evt);
            }
        });

        login_Button.setText("Login");
        login_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_ButtonActionPerformed(evt);
            }
        });

        headerText.setText("StockIt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(passwordField1))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(login_Button)
                        .addGap(157, 157, 157))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(headerText)
                        .addGap(173, 173, 173))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {password, username});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane2, passwordField1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(headerText)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password)
                    .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(login_Button)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {password, username});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane2, passwordField1});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void login_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_ButtonActionPerformed
        loginAction();
    }//GEN-LAST:event_login_ButtonActionPerformed

    private void passwordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordField1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            loginAction();
        }

    }//GEN-LAST:event_passwordField1KeyPressed

    private void loginAction() {
        try {
            // TODO add your handling code here:
            String usname = usernameField.getText();
            //System.out.println(usname);
            char[] str = passwordField1.getPassword();
            String newStr = new String(str);
            //System.out.println(str);
            DBConnection dbcon = new DBConnection();
            dbcon.establishConnection();
            Statement stmt = dbcon.con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT username, password FROM manager_account WHERE username= '" + usname + "' AND password = '" + newStr + "'");
            boolean hasValue = false;
            String[] array = new String[2];
            while (rs.next()) {
                hasValue = true;
                System.out.println("Username: " + rs.getString("username"));
                System.out.println("Password: " + rs.getString("password"));
                array[0] = rs.getString("username");
            }
            ResultSet rs1 = stmt.executeQuery("SELECT investment_company.Name FROM investment_company, manager, manager_account WHERE manager_account.username = \"" + array[0] + "\" AND manager.Manager_SSN = manager_account.Manager_SSN AND investment_company.Id = manager.Investment_Company_ID");
            while (rs1.next()) {
                System.out.println("Company Name: " + rs1.getString("Name"));
                array[1] = rs1.getString("Name");
            }
            dbcon.con.close();
            //for manager, same goes for trader and clients
            if (hasValue) { //get information from database and see if it exist
                dispose();
                Manager.main(array);
            } else {
                JOptionPane.showMessageDialog(getContentPane(), "Incorrect Username or Password", "Login Error", JOptionPane.ERROR_MESSAGE);
                usernameField.setText("");
                passwordField1.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(clientLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(managerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            title = args[0];
            new managerLogin().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel headerText;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton login_Button;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JLabel username;
    private javax.swing.JTextPane usernameField;
    // End of variables declaration//GEN-END:variables
}
