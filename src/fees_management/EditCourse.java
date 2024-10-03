/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author chauh
 */
public class EditCourse extends javax.swing.JFrame {

    /**
     * Creates new form EditCourse
     */
    DefaultTableModel model;
    
    public EditCourse() {
        initComponents();
        setRecordstoTable();
    }
    
     public void setRecordstoTable(){
        
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("Select * from course");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                
                String cID = rs.getString("id");
                String cName = rs.getString("cName");
                String cost = rs.getString("cost");
                
                
                Object[] obj = {cID, cName, cost};
                model = (DefaultTableModel)CourseDataTable.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     public void clearTable(){
         DefaultTableModel model = (DefaultTableModel)CourseDataTable.getModel();
         model.setRowCount(0);
     }
     
     public void addCourse(int id, String cname, double cost){
         
         try {
             Connection con = DBconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into course values(?,?,?)");
            pst.setInt(1, id);
            pst.setString(2, cname);
            pst.setDouble(3, cost);
            int rowCount  = pst.executeUpdate();
            if(rowCount == 1){
                JOptionPane.showMessageDialog(this, "course added successfully");
                clearTable();
                setRecordstoTable();
                
            }else{
                JOptionPane.showMessageDialog(this, "course insertion failed");
            }
            
         } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "course insertion failed");
             e.printStackTrace();
         }
     }
     
     public void update(int id, String cname, double cost){
          try {
             Connection con = DBconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("update course set cname = ?, cost = ? where id = ?");
            pst.setString(1, cname);
            pst.setDouble(2, cost);
            pst.setInt(3, id);
            int rowCount  = pst.executeUpdate();
            if(rowCount == 1){
                JOptionPane.showMessageDialog(this, "course updated successfully");
                clearTable();
                setRecordstoTable();
                
            }else{
                JOptionPane.showMessageDialog(this, "course updation failed");
            }
            
         } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "course updation failed");
             e.printStackTrace();
         }
     }
     
      public void delete(int id){
          try {
             Connection con = DBconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("delete from course where id = ?");
           
            pst.setInt(1, id);
            int rowCount  = pst.executeUpdate();
            if(rowCount == 1){
                JOptionPane.showMessageDialog(this, "course deleted successfully");
                clearTable();
                setRecordstoTable();
                
            }else{
                JOptionPane.showMessageDialog(this, "course deletion failed");
            }
            
         } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "course deletion failed");
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

        sidebar = new javax.swing.JPanel();
        panelhome = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        panelsearch = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        paneledit = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        panellist = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelrecord = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        panelback = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        panellogout = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CourseDataTable = new javax.swing.JTable();
        courseCost_txt = new javax.swing.JTextField();
        courseID_txt = new javax.swing.JTextField();
        courseName_txt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidebar.setBackground(new java.awt.Color(255, 0, 255));
        sidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelhome.setBackground(new java.awt.Color(255, 51, 255));
        panelhome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelhomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelhomeMouseExited(evt);
            }
        });
        panelhome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Sylfaen", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/my icons/home.png"))); // NOI18N
        jLabel8.setText("  Home");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        panelhome.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 250, -1));

        sidebar.add(panelhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 330, 70));

        panelsearch.setBackground(new java.awt.Color(255, 51, 255));
        panelsearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelsearch.setForeground(new java.awt.Color(255, 255, 255));
        panelsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelsearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelsearchMouseExited(evt);
            }
        });
        panelsearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/my icons/search2.png"))); // NOI18N
        jLabel2.setText("Search Record");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        panelsearch.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 250, 70));

        sidebar.add(panelsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 330, 70));

        paneledit.setBackground(new java.awt.Color(255, 0, 255));
        paneledit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        paneledit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paneleditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneleditMouseExited(evt);
            }
        });
        paneledit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/my icons/edit2.png"))); // NOI18N
        jLabel3.setText("Edit Course");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        paneledit.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 230, -1));

        sidebar.add(paneledit, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 330, 70));

        panellist.setBackground(new java.awt.Color(255, 0, 255));
        panellist.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panellist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panellistMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panellistMouseExited(evt);
            }
        });
        panellist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 26)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/my icons/list_1.png"))); // NOI18N
        jLabel4.setText("Course List");
        panellist.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 230, 70));

        sidebar.add(panellist, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 330, 70));

        panelrecord.setBackground(new java.awt.Color(255, 0, 255));
        panelrecord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelrecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelrecordMouseExited(evt);
            }
        });
        panelrecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 26)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/my icons/view all record.png"))); // NOI18N
        jLabel5.setText("View all Records");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        panelrecord.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 270, 70));

        sidebar.add(panelrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 330, 70));

        panelback.setBackground(new java.awt.Color(255, 0, 255));
        panelback.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelbackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelbackMouseExited(evt);
            }
        });
        panelback.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Sylfaen", 1, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/my icons/back-button.png"))); // NOI18N
        jLabel6.setText("  Back");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        panelback.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 270, 70));

        sidebar.add(panelback, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 620, 330, 70));

        panellogout.setBackground(new java.awt.Color(255, 0, 255));
        panellogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panellogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panellogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panellogoutMouseExited(evt);
            }
        });
        panellogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Sylfaen", 1, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/my icons/logout.png"))); // NOI18N
        jLabel7.setText("  Logout");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        panellogout.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 230, 70));

        sidebar.add(panellogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 730, 330, 70));

        getContentPane().add(sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 976));

        jPanel1.setBackground(new java.awt.Color(255, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CourseDataTable.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        CourseDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course ID", "Course Name", "Course Cost"
            }
        ));
        CourseDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CourseDataTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CourseDataTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 710, 760));

        courseCost_txt.setFont(new java.awt.Font("Arial Narrow", 0, 17)); // NOI18N
        courseCost_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseCost_txtActionPerformed(evt);
            }
        });
        jPanel1.add(courseCost_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 570, 310, 40));

        courseID_txt.setFont(new java.awt.Font("Arial Narrow", 0, 17)); // NOI18N
        jPanel1.add(courseID_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 310, 40));

        courseName_txt.setFont(new java.awt.Font("Arial Narrow", 0, 17)); // NOI18N
        jPanel1.add(courseName_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 310, 40));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Course Cost :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, 120, -1));

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Course ID :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 100, -1));

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Course Name :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 120, -1));

        jButton1.setBackground(new java.awt.Color(255, 0, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/my icons/delete.png"))); // NOI18N
        jButton1.setText("Delete");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 690, 110, 50));

        jButton2.setBackground(new java.awt.Color(255, 0, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/my icons/add2.png"))); // NOI18N
        jButton2.setText(" Add");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 690, 100, 50));

        jButton3.setBackground(new java.awt.Color(255, 0, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/my icons/update.png"))); // NOI18N
        jButton3.setText(" Update");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 690, 120, 50));

        jLabel11.setFont(new java.awt.Font("Arial Narrow", 1, 50)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Edit Course");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 1380, 980));

        setSize(new java.awt.Dimension(1875, 984));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        Home_page home = new Home_page();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void panelhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelhomeMouseEntered

        Color clr = new Color(255,0,204);
        panelhome.setBackground(clr);
    }//GEN-LAST:event_panelhomeMouseEntered

    private void panelhomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelhomeMouseExited
        Color clr = new Color(255,51,255);
        panelhome.setBackground(clr);
    }//GEN-LAST:event_panelhomeMouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        SearchRecord search = new SearchRecord();
        search.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void panelsearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsearchMouseEntered
        Color clr = new Color(255,0,204);
        panelsearch.setBackground(clr);
    }//GEN-LAST:event_panelsearchMouseEntered

    private void panelsearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsearchMouseExited
        Color clr = new Color(255,51,255);
        panelsearch.setBackground(clr);
    }//GEN-LAST:event_panelsearchMouseExited

    private void paneleditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneleditMouseEntered
        Color clr = new Color(255,0,204);
        paneledit.setBackground(clr);
    }//GEN-LAST:event_paneleditMouseEntered

    private void paneleditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneleditMouseExited
        Color clr = new Color(255,51,255);
        paneledit.setBackground(clr);
    }//GEN-LAST:event_paneleditMouseExited

    private void panellistMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panellistMouseEntered
        Color clr = new Color(255,0,204);
        panellist.setBackground(clr);
    }//GEN-LAST:event_panellistMouseEntered

    private void panellistMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panellistMouseExited
        Color clr = new Color(255,51,255);
        panellist.setBackground(clr);
    }//GEN-LAST:event_panellistMouseExited

    private void panelrecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelrecordMouseEntered
        Color clr = new Color(255,0,204);
        panelrecord.setBackground(clr);
    }//GEN-LAST:event_panelrecordMouseEntered

    private void panelrecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelrecordMouseExited
        Color clr = new Color(255,51,255);
        panelrecord.setBackground(clr);
    }//GEN-LAST:event_panelrecordMouseExited

    private void panelbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbackMouseEntered
        Color clr = new Color(255,0,204);
        panelback.setBackground(clr);
    }//GEN-LAST:event_panelbackMouseEntered

    private void panelbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbackMouseExited
        Color clr = new Color(255,51,255);
        panelback.setBackground(clr);
    }//GEN-LAST:event_panelbackMouseExited

    private void panellogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panellogoutMouseEntered
        Color clr = new Color(255,0,204);
        panellogout.setBackground(clr);
    }//GEN-LAST:event_panellogoutMouseEntered

    private void panellogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panellogoutMouseExited
        Color clr = new Color(255,51,255);
        panellogout.setBackground(clr);
    }//GEN-LAST:event_panellogoutMouseExited

    private void courseCost_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseCost_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseCost_txtActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       int id = Integer.parseInt(courseID_txt.getText());
       String cname = courseName_txt.getText();
       double cost = Double.parseDouble(courseCost_txt.getText());
       
        update(id, cname, cost);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void CourseDataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CourseDataTableMouseClicked
        int row = CourseDataTable.getSelectedRow();
        TableModel model = CourseDataTable.getModel();
        
        courseID_txt.setText(model.getValueAt(row, 0).toString());
        courseName_txt.setText((String)model.getValueAt(row, 1));
        courseCost_txt.setText((String)model.getValueAt(row, 2));
    }//GEN-LAST:event_CourseDataTableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int id = Integer.parseInt(courseID_txt.getText());
       String cname = courseName_txt.getText();
       double cost = Double.parseDouble(courseCost_txt.getText());
       
        addCourse(id, cname, cost);
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int id = Integer.parseInt(courseID_txt.getText());
        
        delete(id);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       Home_page home = new Home_page();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        EditCourse edit = new EditCourse();
        edit.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        Login_page login = new Login_page();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
          ViewAllRecords view = new ViewAllRecords();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CourseDataTable;
    private javax.swing.JTextField courseCost_txt;
    private javax.swing.JTextField courseID_txt;
    private javax.swing.JTextField courseName_txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelback;
    private javax.swing.JPanel paneledit;
    private javax.swing.JPanel panelhome;
    private javax.swing.JPanel panellist;
    private javax.swing.JPanel panellogout;
    private javax.swing.JPanel panelrecord;
    private javax.swing.JPanel panelsearch;
    private javax.swing.JPanel sidebar;
    // End of variables declaration//GEN-END:variables
}
