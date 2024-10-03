/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management;

import java.sql.DriverManager;
import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author chauh
 */
public class Signup_page extends javax.swing.JFrame {

    /**
     * Creates new form Signup_page
     */
    String fname, lname, username, password, confirmpass, contact;
        Date dob;
        int id=0;
        
    
    public Signup_page() {
        initComponents();
        
    }
    
    public int getId()
    {
        ResultSet rs=null;
        try {
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
             Connection con=(Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/fees_managment","admin1","admin");
             String sql="select max(id)from signup_page";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next())
            {
                id=rs.getInt(1);
                id++;
            }
         
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
       return id;
    }
    
    
    boolean validation(){
        
        
        fname = txt_fname.getText();
        lname = txt_lname.getText();
        username = txt_username.getText();
        password = txt_pass.getText();   //method deprecated
        confirmpass = txt_confirm.getText();
        contact = txt_contact.getText();
        dob = txt_dob.getDate();
        
        
        if (fname.equals("")){
            JOptionPane.showMessageDialog(this,"please enter Firstname" );  //open popup window
            return false;
    }
         if (lname.equals("")){
            JOptionPane.showMessageDialog(this,"please enter Lastname" );  //open popup window
            return false;
    }
          if (username.equals("")){
            JOptionPane.showMessageDialog(this,"please enter Username" );  //open popup window
            return false;
    }
           if (password.equals("")){
            JOptionPane.showMessageDialog(this,"please enter Password" );  //open popup window
            return false;
    }
            if (confirmpass.equals("")){
            JOptionPane.showMessageDialog(this,"please confirm the password" );  //open popup window
            return false;
    }
             if (dob == null){
            JOptionPane.showMessageDialog(this," enter your DOB" );  //open popup window
            return false;
    }
             if(!password.equals(confirmpass)){
                JOptionPane.showMessageDialog(this,"password does not match" );  //open popup window
                return false;
             }
            
             return true;
    }
    
    public void checkpassword(){
                password = txt_pass.getText();   //method deprecated
                if(password.length() <8){
                    lbl_pass_error.setText("Password must be of 8 digits");
                }
                else{
                    lbl_pass_error.setText("");
                }

    }
    public void checkContact(){
                contact = txt_contact.getText();
                if(contact.length()==10){
                    lbl_contact_error.setText("");
                }
                else{
                    lbl_contact_error.setText("Number must be 10 digits");
                }
    }
    
    void insertdetails(){
        
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String myDob = dt1.format(dob);
    try{
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         Connection con=(Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/fees_managment","admin1","admin");
         String sql="insert into signup_page values(?,?,?,?,?,?,?)";
         PreparedStatement stmt= con.prepareStatement(sql);
         stmt.setInt(1,getId());
         stmt.setString(2,fname);
         stmt.setString(3,lname);
         stmt.setString(4,username);
         stmt.setString(5,password);
         stmt.setString(6,myDob);
         stmt.setString(7,contact);
         System.out.println("sddx "+ myDob);
         int i=stmt.executeUpdate();
                 if(i>0)
                 {
                     JOptionPane.showMessageDialog(this, "record inserted");
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(this, "record not inserted");
                 }
                 
    }
    catch(Exception e){
        e.printStackTrace();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_lname = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_fname = new javax.swing.JTextField();
        txt_contact = new javax.swing.JTextField();
        txt_pass = new javax.swing.JPasswordField();
        txt_confirm = new javax.swing.JPasswordField();
        txt_dob = new com.toedter.calendar.JDateChooser();
        btn_signup = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        lbl_pass_error = new javax.swing.JLabel();
        lbl_contact_error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 51, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 45)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Signup");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(395, 395, 395)
                .addComponent(jLabel1)
                .addContainerGap(442, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 130));

        jPanel2.setBackground(new java.awt.Color(255, 153, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel2.setText("Firstname :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel3.setText("Lastname :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel4.setText("Password :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel5.setText("Confirm Password :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel6.setText("Username :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel7.setText("D.O.B :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel8.setText("Contact no :");

        txt_lname.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_lname.setBorder(null);
        txt_lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lnameActionPerformed(evt);
            }
        });

        txt_username.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_username.setBorder(null);
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });

        txt_fname.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fname.setBorder(null);
        txt_fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fnameActionPerformed(evt);
            }
        });

        txt_contact.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_contact.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_contact.setBorder(null);
        txt_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactActionPerformed(evt);
            }
        });
        txt_contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_contactKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_contactKeyReleased(evt);
            }
        });

        txt_pass.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pass.setBorder(null);
        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });
        txt_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_passKeyReleased(evt);
            }
        });

        txt_confirm.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_confirm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_confirm.setBorder(null);

        txt_dob.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_signup.setBackground(new java.awt.Color(255, 0, 255));
        btn_signup.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_signup.setText("Signup\n");
        btn_signup.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signupActionPerformed(evt);
            }
        });

        btn_login.setBackground(new java.awt.Color(255, 0, 255));
        btn_login.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_login.setText("Login");
        btn_login.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
        });
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        lbl_pass_error.setBackground(new java.awt.Color(255, 153, 255));
        lbl_pass_error.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_pass_error.setForeground(new java.awt.Color(255, 0, 0));

        lbl_contact_error.setBackground(new java.awt.Color(255, 102, 255));
        lbl_contact_error.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_contact_error.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(btn_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168)
                .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_contact_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_pass_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_fname, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                    .addComponent(txt_lname)
                    .addComponent(txt_username)
                    .addComponent(txt_pass)
                    .addComponent(txt_confirm)
                    .addComponent(txt_contact)
                    .addComponent(txt_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_lname, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_username, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(lbl_pass_error)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_dob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txt_contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_contact_error)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_signup)
                    .addComponent(btn_login))
                .addGap(31, 31, 31))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 970, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fnameActionPerformed
         
    }//GEN-LAST:event_txt_fnameActionPerformed

    private void txt_lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lnameActionPerformed
        
    }//GEN-LAST:event_txt_lnameActionPerformed

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactActionPerformed

    private void btn_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signupActionPerformed
      if( validation())
      {
          insertdetails();
      }
    }//GEN-LAST:event_btn_signupActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_loginActionPerformed

    private void txt_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passKeyPressed
        checkpassword();
    }//GEN-LAST:event_txt_passKeyPressed

    private void txt_passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passKeyReleased
        checkpassword();
    }//GEN-LAST:event_txt_passKeyReleased

    private void txt_contactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactKeyReleased
        checkContact();
    }//GEN-LAST:event_txt_contactKeyReleased

    private void txt_contactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactKeyPressed
        checkContact();
    }//GEN-LAST:event_txt_contactKeyPressed

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked
        Login_page login = new Login_page();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_loginMouseClicked

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
            java.util.logging.Logger.getLogger(Signup_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Signup_page().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_signup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_contact_error;
    private javax.swing.JLabel lbl_pass_error;
    private javax.swing.JPasswordField txt_confirm;
    private javax.swing.JTextField txt_contact;
    private com.toedter.calendar.JDateChooser txt_dob;
    private javax.swing.JTextField txt_fname;
    private javax.swing.JTextField txt_lname;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
