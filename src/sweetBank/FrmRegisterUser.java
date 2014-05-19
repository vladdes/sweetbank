/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweetBank;

import java.security.MessageDigest;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author davidmunro && vladimir
 */
public class FrmRegisterUser extends javax.swing.JFrame {

    private static DBcon con;
    private String fName, lName, pNumber, pNumber2, aNumber, address, userName, password, email, phone, title;
    private Message mess;

    /**
     * Creates new form FrmRegisterUser
     */
    public FrmRegisterUser(DBcon c) {

        initComponents();
        this.con = c;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtFname = new javax.swing.JTextField();
        TxtLname = new javax.swing.JTextField();
        BtnCancle = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtAddress = new javax.swing.JTextArea();
        BtnSave = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        titleChoice = new javax.swing.JComboBox();
        phoneNo = new javax.swing.JLabel();
        phoneText = new javax.swing.JTextField();
        personNumTextField = new javax.swing.JFormattedTextField();
        personNumTextTwo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register New User");
        setResizable(false);

        jLabel1.setText("First Name :");

        jLabel2.setText("Last Name :");

        jLabel4.setText("Person Number :");

        TxtFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFnameActionPerformed(evt);
            }
        });
        TxtFname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtFnameKeyTyped(evt);
            }
        });

        TxtLname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtLnameKeyTyped(evt);
            }
        });

        BtnCancle.setText("Cancel");
        BtnCancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancleActionPerformed(evt);
            }
        });

        TxtAddress.setColumns(20);
        TxtAddress.setRows(5);
        TxtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtAddressKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(TxtAddress);

        BtnSave.setText("Register");
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });

        jLabel6.setText("Address : ");

        jLabel8.setText("Password: ");

        jLabel9.setText("Email");

        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });
        emailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailFieldKeyTyped(evt);
            }
        });

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyTyped(evt);
            }
        });

        jLabel3.setText("Title");

        titleChoice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mr", "Mrs", "Ms", "Dr" }));
        titleChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleChoiceActionPerformed(evt);
            }
        });

        phoneNo.setText("Phone number");

        phoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTextActionPerformed(evt);
            }
        });
        phoneText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneTextKeyTyped(evt);
            }
        });

        personNumTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("######.####"))));
        personNumTextField.setMaximumSize(new java.awt.Dimension(11, 10));
        personNumTextField.setMinimumSize(new java.awt.Dimension(10, 10));
        personNumTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personNumTextFieldActionPerformed(evt);
            }
        });
        personNumTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                personNumTextFieldKeyTyped(evt);
            }
        });

        personNumTextTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personNumTextTwoActionPerformed(evt);
            }
        });
        personNumTextTwo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                personNumTextTwoKeyTyped(evt);
            }
        });

        jLabel5.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addComponent(personNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(personNumTextTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(phoneNo)
                                .addGap(18, 18, 18)
                                .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtLname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(38, 38, 38)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BtnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                    .addComponent(BtnCancle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(393, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(TxtFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(TxtLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(personNumTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(personNumTextTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNo))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel6)))
                .addGap(30, 30, 30)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnSave)
                .addGap(18, 18, 18)
                .addComponent(BtnCancle)
                .addGap(59, 59, 59))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed


        if (injectionCheck()) {
            sendToDB();
            sendEmail();
            JOptionPane.showMessageDialog(this, "User registered! Email with credentials sent!");
            try {
                Thread.sleep(5000);
                this.dispose();
            } catch (InterruptedException ex) {
                Logger.getLogger(FrmRegisterUser.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            setEmptyField();
            TxtFname.requestFocus();
            JOptionPane.showMessageDialog(this, "No special signs allowed! \n "
                    + "at person-number and phone only numerics are allowed");
        }

    }//GEN-LAST:event_BtnSaveActionPerformed
    private void setEmptyField() {
        TxtFname.setText("");
        TxtLname.setText("");
        TxtAddress.setText("");
        personNumTextField.setText("");
        personNumTextTwo.setText("");
        emailField.setText("");
        jPasswordField1.setText("");
        phoneText.setText("");

    }

    //Vladimir
    private boolean injectionCheck() {
        fName = TxtFname.getText();
        lName = TxtLname.getText();
        pNumber = personNumTextField.getText();
        pNumber2 = personNumTextTwo.getText();
        email = emailField.getText();
        password = new String(jPasswordField1.getPassword());
        phone = phoneText.getText();
        address = TxtAddress.getText();

        int countToOk = 0;
        int countOK = 6;
        if (SQLInjections.variableSecureFromSQLInjection_Letters(fName)) {
            countToOk++;

        }
        if (SQLInjections.variableSecureFromSQLInjection_Letters(lName)) {
            countToOk++;
        }
        if (SQLInjections.variableSecureFromSQLInjection_Numeric(pNumber)) {
            countToOk++;

        }
        if (SQLInjections.variableSecureFromSQLInjection_Numeric(pNumber2)) {
            countToOk++;

        }
        if (SQLInjections.variableSecureFromSQLInjection(password, true)) {
            countToOk++;
        }
        if (SQLInjections.variableSecureFromSQLInjection_Numeric(phone)) {
            countToOk++;
        }

        return countToOk == countOK;
    }

    //David && Hassan
    private void sendEmail() {
        String to = email;

        if (sendMail("sweetbank123@gmail.com", "hkr12345", ("You can log in by using this email address: "
                + email + "\n Your password for logging in is: " + password), to)) {
            System.out.println("Email sent");
        } else {
            System.out.println("Failed");
        }
    }

    private String md5(char[] c) {
        try {
            MessageDigest digestMD5 = MessageDigest.getInstance("MD5");
            digestMD5.update((new String(c)).getBytes("UTF8"));
            return new String(digestMD5.digest());
        } catch (Exception e) {
            return "";
        }
    }

    private void sendToDB() {
        try {
            String[] info = new String[10];
            info[0] = TxtFname.getText();
            info[1] = TxtLname.getText();
            info[2] = personNumTextField.getText();
            info[3] = TxtAddress.getText();
            info[4] = emailField.getText();
            info[8] = personNumTextTwo.getText();
            info[5] = phoneText.getText();
            info[6] = titleChoice.getSelectedItem().toString();
            info[7] = md5((jPasswordField1.getPassword()));
            con.addPerson(info);

        } catch (Exception e) {
        }
    }
    
    //David && Hassan
    public boolean sendMail(String from, String password, String message, String to) {
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage mm = new MimeMessage(session);
        try {
            mm.setFrom(new InternetAddress(from));
            InternetAddress toAddress = new InternetAddress(to);
            mm.addRecipient(Message.RecipientType.TO, toAddress);
            mm.setSubject("Welcome to SweetBank");

            mm.setText(message);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, password);
            transport.sendMessage(mm, mm.getAllRecipients());
            transport.close();
            return true;

        } catch (MessagingException ex) {
            Logger.getLogger(FrmRegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private void BtnCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancleActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnCancleActionPerformed

    private void TxtFnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtFnameKeyTyped
        jProgressBar1.setValue(15);
    }//GEN-LAST:event_TxtFnameKeyTyped

    private void TxtLnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtLnameKeyTyped
        jProgressBar1.setValue(30);
    }//GEN-LAST:event_TxtLnameKeyTyped

    private void TxtAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtAddressKeyTyped
        jProgressBar1.setValue(100);
    }//GEN-LAST:event_TxtAddressKeyTyped

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void titleChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleChoiceActionPerformed
    }//GEN-LAST:event_titleChoiceActionPerformed

    private void phoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneTextActionPerformed

    private void personNumTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personNumTextFieldActionPerformed
    }//GEN-LAST:event_personNumTextFieldActionPerformed

    private void personNumTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_personNumTextFieldKeyTyped
        jProgressBar1.setValue(45);
        String value = personNumTextField.getText();
        if (value.length() == 5) {
            personNumTextTwo.requestFocus();
        }
    }//GEN-LAST:event_personNumTextFieldKeyTyped

    private void TxtFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFnameActionPerformed

    private void emailFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailFieldKeyTyped
        jProgressBar1.setValue(60);
    }//GEN-LAST:event_emailFieldKeyTyped

    private void jPasswordField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyTyped
        jProgressBar1.setValue(75);
    }//GEN-LAST:event_jPasswordField1KeyTyped

    private void phoneTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneTextKeyTyped
        jProgressBar1.setValue(90);
    }//GEN-LAST:event_phoneTextKeyTyped

    private void personNumTextTwoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_personNumTextTwoKeyTyped
        String value = personNumTextTwo.getText();
        if (value.length() == 3) {
            emailField.requestFocus();
        }
    }//GEN-LAST:event_personNumTextTwoKeyTyped

    private void personNumTextTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personNumTextTwoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personNumTextTwoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmRegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegisterUser(con).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancle;
    private javax.swing.JButton BtnSave;
    private javax.swing.JTextArea TxtAddress;
    private javax.swing.JTextField TxtFname;
    private javax.swing.JTextField TxtLname;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField personNumTextField;
    private javax.swing.JTextField personNumTextTwo;
    private javax.swing.JLabel phoneNo;
    private javax.swing.JTextField phoneText;
    private javax.swing.JComboBox titleChoice;
    // End of variables declaration//GEN-END:variables
}