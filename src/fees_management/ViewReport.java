/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.*;
import java.util.Map;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFChartSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Arrays;
import java.util.Set;
import javax.swing.JOptionPane;




/**
 *
 * @author chauh
 */
public class ViewReport extends javax.swing.JFrame {

    /**
     * Creates new form ViewReport
     */
    DefaultTableModel model;
    
    public ViewReport() {
        initComponents();
        fillcombobox();
        
    }
    
     public void fillcombobox(){
        
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection con = (Connection)DriverManager.getConnection("jdbc:derby://localhost:1527/fees_managment","admin1","admin");
            PreparedStatement pst= con.prepareStatement("select cname from course");
            ResultSet rs =  pst.executeQuery();
            while(rs.next()){
                CourseDetails.addItem(rs.getString("cname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.toString();
            System.out.println("e");
        }
    }
     
       public void setRecordstoTable(){
        
           
           String cname = CourseDetails.getSelectedItem().toString();
           
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           String fromdate = dateFormat.format(from_datechooser.getDate());
           String todate = dateFormat.format(to_datechooser.getDate());
        
        Float totalAmount = 0.0f;
        
        
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("Select * from fees_details where date between ? and ? and course_name = ?");
            pst.setString(1, fromdate);
            pst.setString(2, todate);
            pst.setString(3, cname);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                
                String recieptNo = rs.getString("reciept_no");
                String rollNo = rs.getString("roll_no");
                String studentName = rs.getString("Student_name");
                String course = rs.getString("course_name");
                String date = rs.getString("date");
                String paymentMode = rs.getString("payment_mode");
                float amount = rs.getFloat("total_amount");
                String remark = rs.getString("remark");
                
                totalAmount = totalAmount + amount;
                
                Object[] obj = {recieptNo,rollNo,studentName,course,date,paymentMode,amount,remark};
                model = (DefaultTableModel)AllRecords.getModel();
                model.addRow(obj);
            }
            lbl_selectCourse1.setText(cname);
            lbl_amountCollected.setText(totalAmount.toString());
            lbl_amountWords.setText(NumberToWordConvert.convert(totalAmount.intValue()));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       
       public void clearTable(){
         DefaultTableModel model = (DefaultTableModel)AllRecords.getModel();
         model.setRowCount(1);
     }
       
       public void exporttoExcel(){
           XSSFWorkbook wb = new XSSFWorkbook();
           XSSFSheet ws = wb.createSheet();
           DefaultTableModel model = (DefaultTableModel)AllRecords.getModel();
           
           TreeMap<String, Object[]>map = new TreeMap<>();
           
           map.put("0", new Object[]{model.getColumnName(0),model.getColumnName(1),model.getColumnName(2),model.getColumnName(3),model.getColumnName(4),
               model.getColumnName(5),model.getColumnName(6),model.getColumnName(7)} );
               
           for (int i = 1; i < model.getRowCount(); i++) {
               map.put(Integer.toString(i),new Object[]{model.getValueAt(i, 0),model.getValueAt(i, 1),model.getValueAt(i, 2),model.getValueAt(i, 3),model.getValueAt(i, 4),
               model.getValueAt(i, 5),model.getValueAt(i, 6),model.getValueAt(i, 7)} );   
           }
           for (Map.Entry<String, Object[]> entry : map.entrySet()) {
               Object key = entry.getKey();
               Object[] value = entry.getValue();
               System.out.println(Arrays.toString(value));
           }
           
         Set<String> id = map.keySet();
         
         XSSFRow fRow;
         
         int rowId = 0;
         
         for(String key : id){
             fRow = ws.createRow(rowId);
             rowId++;
             Object[] value = map.get(key);
             
             int cellid = 0;
             
             for (Object object : value) {
                 XSSFCell cell = fRow.createCell(cellid);
                 cellid++;
                 cell.setCellValue(object.toString());
             }
         }
           try {
               FileOutputStream fos = new FileOutputStream(new File(txt_filepath.getText()));
               wb.write(fos);
               fos.close();
               JOptionPane.showMessageDialog(this, "File Exported Successfully :"+txt_filepath.getText());
           } catch (Exception e) {
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
        AllRecords = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        CourseDetails = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        to_datechooser = new com.toedter.calendar.JDateChooser();
        from_datechooser = new com.toedter.calendar.JDateChooser();
        btn_print = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txt_filepath = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_amountWords = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_selectCourse1 = new javax.swing.JLabel();
        lbl_amountCollected = new javax.swing.JLabel();

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

        sidebar.add(panelhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 330, 70));

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

        sidebar.add(panelsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 330, 70));

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

        sidebar.add(paneledit, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 330, 70));

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

        sidebar.add(panellist, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 330, 70));

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

        sidebar.add(panelrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 570, 330, 70));

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

        sidebar.add(panelback, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 680, 330, 70));

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

        sidebar.add(panellogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 790, 330, 70));

        getContentPane().add(sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 1020));

        jPanel1.setBackground(new java.awt.Color(255, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AllRecords.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        AllRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Reciept No", "Roll No", "Student Name", "Course Opted", "Date", "Payment Mode", "Amount Submitted", "Remark"
            }
        ));
        jScrollPane1.setViewportView(AllRecords);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 1132, 650));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("From Date :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        CourseDetails.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        CourseDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseDetailsActionPerformed(evt);
            }
        });
        jPanel1.add(CourseDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 42, 360, 30));

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Select Course :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Select Date :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial Narrow", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("To Date :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, -1, -1));
        jPanel1.add(to_datechooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 150, 30));
        jPanel1.add(from_datechooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 102, 160, 30));

        btn_print.setBackground(new java.awt.Color(255, 0, 255));
        btn_print.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_print.setForeground(new java.awt.Color(255, 255, 255));
        btn_print.setText("Print");
        btn_print.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_printMouseClicked(evt);
            }
        });
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        jPanel1.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 100, 40));

        jButton2.setBackground(new java.awt.Color(255, 0, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Export to excel");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 170, 40));
        jPanel1.add(txt_filepath, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 232, 310, 40));

        jButton3.setBackground(new java.awt.Color(255, 0, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Submit");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 100, 40));

        jButton4.setBackground(new java.awt.Color(255, 0, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Browse");
        jButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 100, 40));

        jPanel2.setBackground(new java.awt.Color(255, 153, 255));
        jPanel2.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_amountWords.setFont(new java.awt.Font("Arial Narrow", 2, 20)); // NOI18N
        lbl_amountWords.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(lbl_amountWords, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 410, 30));

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Course Selected :");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial Narrow", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Total Amount Collected :");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial Narrow", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Total Amount in Words :");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        lbl_selectCourse1.setFont(new java.awt.Font("Arial Narrow", 2, 20)); // NOI18N
        lbl_selectCourse1.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(lbl_selectCourse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 220, 30));

        lbl_amountCollected.setFont(new java.awt.Font("Arial Narrow", 2, 20)); // NOI18N
        lbl_amountCollected.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(lbl_amountCollected, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 220, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 450, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, -2, 1230, 1030));

        setSize(new java.awt.Dimension(1730, 1030));
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

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        EditCourse edit = new EditCourse();
        edit.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

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

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        ViewAllRecords view = new ViewAllRecords();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void panelrecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelrecordMouseEntered
        Color clr = new Color(255,0,204);
        panelrecord.setBackground(clr);
    }//GEN-LAST:event_panelrecordMouseEntered

    private void panelrecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelrecordMouseExited
        Color clr = new Color(255,51,255);
        panelrecord.setBackground(clr);
    }//GEN-LAST:event_panelrecordMouseExited

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Home_page home = new Home_page();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

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

    private void CourseDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourseDetailsActionPerformed
        
    }//GEN-LAST:event_CourseDetailsActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        clearTable();
        setRecordstoTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseClicked
         
    }//GEN-LAST:event_btn_printMouseClicked

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        String datefrom =  Date_Format.format(from_datechooser.getDate());
      String dateto=  Date_Format.format(to_datechooser.getDate());
       
        MessageFormat header=new MessageFormat("Report From "+datefrom+" To " +dateto);
        MessageFormat footer=new MessageFormat("page{0,number,integer}");
        try {
            AllRecords.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            
        } catch (Exception e) {
            e.getMessage();
        } 
    }//GEN-LAST:event_btn_printActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFileChooser fileChooser = new  JFileChooser();
        fileChooser.showOpenDialog(this);
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd ");
        String date = dateFormat.format(new Date());
        
        try {
            File f = fileChooser.getSelectedFile();
            String path = f.getAbsolutePath();
            path = path+"_"+date+".xlsx";
            txt_filepath.setText(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        exporttoExcel();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
         Login_page login = new Login_page();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

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
            java.util.logging.Logger.getLogger(ViewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AllRecords;
    private javax.swing.JComboBox<String> CourseDetails;
    private javax.swing.JButton btn_print;
    private com.toedter.calendar.JDateChooser from_datechooser;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_amountCollected;
    private javax.swing.JLabel lbl_amountWords;
    private javax.swing.JLabel lbl_selectCourse1;
    private javax.swing.JPanel panelback;
    private javax.swing.JPanel paneledit;
    private javax.swing.JPanel panelhome;
    private javax.swing.JPanel panellist;
    private javax.swing.JPanel panellogout;
    private javax.swing.JPanel panelrecord;
    private javax.swing.JPanel panelsearch;
    private javax.swing.JPanel sidebar;
    private com.toedter.calendar.JDateChooser to_datechooser;
    private javax.swing.JTextField txt_filepath;
    // End of variables declaration//GEN-END:variables
}
