/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


/**
 *
 * @author chauh
 */
public class AddFees extends javax.swing.JFrame {   //inline import

    /**
     * Creates new form AddFees
     */
    public AddFees() {
        initComponents();
        displaycashfirst();
        fillcombobox();
        int recieptno =  getRecieptNo();
        reciept_txt.setText(Integer.toString(recieptno));
    }
    
    public void  displaycashfirst()
    {
        dd_lbl.setVisible(false);
        cheque_lbl.setVisible(false);
        bankname_lbl.setVisible(false);
        
        DDno_txt.setVisible(false);
        chequeno_txt.setVisible(false);
        bankname_txt.setVisible(false);
    
    }
    
    public boolean validation(){
        if(Received_txt.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter Username");
            return false;
        }
        if(datechooser.getDate()==null){
             JOptionPane.showMessageDialog(this, "Please select Date");
             return false;
        }
        if(amount_txt.getText().equals("") || amount_txt.getText().matches("[0-9]+") == false){
             JOptionPane.showMessageDialog(this, "Please Enter Amount(in Numbers)");
             return false;
        }
        if(Combo_mod.getSelectedItem().toString().equalsIgnoreCase("cheque")){
            if(chequeno_txt.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please Enter Cheque number");
                return false;
            }
            if(bankname_txt.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please Enter Bank Name");
                return false;
        }
        }  
        if(Combo_mod.getSelectedItem().toString().equalsIgnoreCase("DD")){
            if(DDno_txt.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please Enter DD number");
                return false;
            }
            if(bankname_txt.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please Enter Bank Name");
                return false;
        }
        }
         if(Combo_mod.getSelectedItem().toString().equalsIgnoreCase("Card")){
            if(bankname_txt.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please Enter Bank Name");
                return false;
        }
        }
        
        return true;
    
    }
    
    public void fillcombobox(){
        
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection con = (Connection)DriverManager.getConnection("jdbc:derby://localhost:1527/fees_managment","admin1","admin");
            PreparedStatement pst= con.prepareStatement("select cname from course");
            ResultSet rs =  pst.executeQuery();
            while(rs.next()){
                combocourse.addItem(rs.getString("cname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.toString();
            System.out.println("e");
        }
    }
    
    public int getRecieptNo(){
        
        int recieptNo = 0;
        try {
            Connection con =DBconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("Select max(reciept_no) from fees_details");
            ResultSet rs =  pst.executeQuery();
            if(rs.next()==true){
                recieptNo = rs.getInt(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recieptNo+1;
    }
    
    public String insertData(){
        
        String status = "";
    
        int recieptNo = Integer.parseInt(reciept_txt.getText());
        String studentname = Received_txt.getText();
        String rollNo = txt_rollNo.getText();
        String paymentMode = Combo_mod.getSelectedItem().toString();
        String chequeNo = chequeno_txt.getText();
        String bankName = bankname_txt.getText();
        String ddNo = DDno_txt.getText();
        String courseName = coursename_txt.getText();
        String gstin = GSTno_lbl.getText();
        float totalAmount = Float.parseFloat(total_txt.getText());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(datechooser.getDate());
        float initialAmount = Float.parseFloat(amount_txt.getText());
        float cgstAmount = Float.parseFloat(cgst_txt.getText());
        float sgstAmount = Float.parseFloat(sgst_txt.getText());
        String totalInWords = txt_totalwords.getText();
        String remark = txt_remark.getText();
        int year1 = Integer.parseInt(Year1_txt.getText());
        int year2 = Integer.parseInt(Year2_txt.getText());
        
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            pst.setInt(1, recieptNo);
            pst.setString(2, studentname);
            pst.setString(3, rollNo);
            pst.setString(4, paymentMode);
            pst.setString(5, chequeNo);
            pst.setString(6, bankName);
            pst.setString(7, ddNo);
            pst.setString(8, courseName);
            pst.setString(9, gstin);
            pst.setFloat(10, totalAmount);
            pst.setString(11, date);
            pst.setFloat(12, initialAmount);
            pst.setFloat(13, cgstAmount);
            pst.setFloat(14, sgstAmount);
            pst.setString(15, totalInWords);
            pst.setString(16, remark);
            pst.setInt(17, year1);
            pst.setInt(18, year2);
            
            int rowCount = pst.executeUpdate();
            if(rowCount==1){
                status = "success";
            }
            else{
                status = "failed";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
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
        parent2 = new javax.swing.JPanel();
        cheque_lbl = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        dd_lbl = new javax.swing.JLabel();
        GSTno_lbl = new javax.swing.JLabel();
        bankname_lbl = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        bankname_txt = new javax.swing.JTextField();
        reciept_txt = new javax.swing.JTextField();
        DDno_txt = new javax.swing.JTextField();
        chequeno_txt = new javax.swing.JTextField();
        Combo_mod = new javax.swing.JComboBox<>();
        datechooser = new com.toedter.calendar.JDateChooser();
        panelchild = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        Year2_txt = new javax.swing.JTextField();
        total_txt = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        combocourse = new javax.swing.JComboBox<>();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        Year1_txt = new javax.swing.JTextField();
        txt_totalwords = new javax.swing.JTextField();
        amount_txt = new javax.swing.JTextField();
        cgst_txt = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        sgst_txt = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        coursename_txt = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_remark = new javax.swing.JTextArea();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel67 = new javax.swing.JLabel();
        btn_print = new javax.swing.JButton();
        Received_txt = new javax.swing.JTextField();
        txt_rollNo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        sidebar.add(panelhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 330, 70));

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

        sidebar.add(panelsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 330, 70));

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

        sidebar.add(paneledit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 330, 70));

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

        sidebar.add(panellist, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 330, 70));

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

        sidebar.add(panelrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, 330, 70));

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

        sidebar.add(panelback, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 640, 330, 70));

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

        sidebar.add(panellogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 750, 330, 70));

        parent2.setBackground(new java.awt.Color(255, 153, 255));
        parent2.setPreferredSize(new java.awt.Dimension(1310, 1040));
        parent2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cheque_lbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cheque_lbl.setText("Cheque no :");
        parent2.add(cheque_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, 40));

        jLabel49.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel49.setText("Reciept no. :  RJIT");
        parent2.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel50.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel50.setText("Mode of Payment :");
        parent2.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        dd_lbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        dd_lbl.setText("DD no :");
        parent2.add(dd_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, 40));

        GSTno_lbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        GSTno_lbl.setText("GSTIN :    07AAATI3929A1Z7");
        parent2.add(GSTno_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, -1, 40));

        bankname_lbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bankname_lbl.setText("Bank Name :");
        parent2.add(bankname_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, 40));

        jLabel54.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel54.setText("Date :");
        parent2.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, -1, 40));

        bankname_txt.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        parent2.add(bankname_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 360, -1));

        reciept_txt.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        reciept_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reciept_txtActionPerformed(evt);
            }
        });
        parent2.add(reciept_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 230, -1));

        DDno_txt.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        parent2.add(DDno_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 220, -1));

        chequeno_txt.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        parent2.add(chequeno_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 220, -1));

        Combo_mod.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        Combo_mod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "Cheque", "Cash", "Card" }));
        Combo_mod.setSelectedIndex(2);
        Combo_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_modActionPerformed(evt);
            }
        });
        parent2.add(Combo_mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 160, -1));

        datechooser.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        parent2.add(datechooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 160, -1));

        panelchild.setBackground(new java.awt.Color(255, 153, 255));
        panelchild.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel55.setText("-");
        panelchild.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 10, 40));

        jLabel56.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel56.setText("Academic Year ");
        panelchild.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, 40));

        jLabel57.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel57.setText("Amount");
        panelchild.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 230, 80, 40));

        jLabel58.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel58.setText("Roll No :");
        panelchild.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, -1, 40));

        Year2_txt.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        panelchild.add(Year2_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 100, -1));

        total_txt.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        total_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_txtActionPerformed(evt);
            }
        });
        panelchild.add(total_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 480, 220, -1));

        jLabel59.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel59.setText("Student Name :");
        panelchild.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 40));

        combocourse.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        combocourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocourseActionPerformed(evt);
            }
        });
        panelchild.add(combocourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 360, -1));

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        panelchild.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 1190, 40));

        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        panelchild.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 1190, 40));

        jLabel60.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel60.setText("SGST : 9%");
        panelchild.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 110, 40));

        jLabel61.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel61.setText("Sr No.");
        panelchild.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 80, 40));

        jLabel62.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel62.setText("Head");
        panelchild.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 80, 40));

        Year1_txt.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        panelchild.add(Year1_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 100, -1));

        txt_totalwords.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_totalwords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalwordsActionPerformed(evt);
            }
        });
        panelchild.add(txt_totalwords, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, 340, -1));

        amount_txt.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        amount_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amount_txtActionPerformed(evt);
            }
        });
        panelchild.add(amount_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 300, 220, -1));

        cgst_txt.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        cgst_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cgst_txtActionPerformed(evt);
            }
        });
        panelchild.add(cgst_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 360, 220, -1));

        jLabel63.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel63.setText("Receiver Signature");
        panelchild.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 590, 150, 40));

        jLabel64.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel64.setText("CGST : 9%");
        panelchild.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 110, 40));

        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));
        panelchild.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 590, 260, 30));

        sgst_txt.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        sgst_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sgst_txtActionPerformed(evt);
            }
        });
        panelchild.add(sgst_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 420, 220, -1));

        jLabel65.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel65.setText("Course :");
        panelchild.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 80, 40));

        jLabel66.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel66.setText("Total in Words :");
        panelchild.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 150, 40));

        coursename_txt.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        panelchild.add(coursename_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 340, -1));

        txt_remark.setColumns(20);
        txt_remark.setRows(5);
        jScrollPane3.setViewportView(txt_remark);

        panelchild.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 590, 340, -1));

        jSeparator12.setForeground(new java.awt.Color(255, 255, 255));
        panelchild.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 470, 260, 20));

        jLabel67.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel67.setText("Remark :");
        panelchild.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, 150, 40));

        btn_print.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        panelchild.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 660, -1, -1));
        panelchild.add(Received_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 22, 360, 30));

        txt_rollNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rollNoActionPerformed(evt);
            }
        });
        panelchild.add(txt_rollNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(891, 82, 220, 30));

        parent2.add(panelchild, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 1450, 790));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parent2, javax.swing.GroupLayout.PREFERRED_SIZE, 1445, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent2, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
            .addComponent(sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(2064, 1075));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void panelhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelhomeMouseEntered
        
        Color clr = new Color(255,0,204);
        panelhome.setBackground(clr);
    }//GEN-LAST:event_panelhomeMouseEntered

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

    private void panelhomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelhomeMouseExited
         Color clr = new Color(255,51,255);
        panelhome.setBackground(clr);
    }//GEN-LAST:event_panelhomeMouseExited

    private void total_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total_txtActionPerformed

    private void amount_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amount_txtActionPerformed
        Float amount = Float.parseFloat(amount_txt.getText());
        
        Float cgst = (float)(amount * 0.09);
        Float sgst = (float)(amount * 0.09);
        
        cgst_txt.setText(cgst.toString());
        sgst_txt.setText(sgst.toString());
        
        float total = amount + cgst + sgst;
        
        total_txt.setText(Float.toString(total));
        
        NumberToWordConvert.convert((int)total);
        txt_totalwords.setText(NumberToWordConvert.convert((int)total) + " only");
    }//GEN-LAST:event_amount_txtActionPerformed

    private void cgst_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cgst_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cgst_txtActionPerformed

    private void sgst_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sgst_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sgst_txtActionPerformed

    private void reciept_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reciept_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reciept_txtActionPerformed

    private void txt_totalwordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalwordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalwordsActionPerformed

    private void Combo_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_modActionPerformed
        if(Combo_mod.getSelectedIndex()== 0)
        {
            dd_lbl.setVisible(true);
            DDno_txt.setVisible(true);
            bankname_lbl.setVisible(true);
            bankname_txt.setVisible(true);
            cheque_lbl.setVisible(false);
            chequeno_txt.setVisible(false);
        }
        
        if(Combo_mod.getSelectedIndex()== 1)
        {
            dd_lbl.setVisible(false);
            DDno_txt.setVisible(false);
            bankname_lbl.setVisible(true);
            bankname_txt.setVisible(true);
            cheque_lbl.setVisible(true);
            chequeno_txt.setVisible(true);
        }
        
        if(Combo_mod.getSelectedIndex()== 2)
        {
            dd_lbl.setVisible(false);
            DDno_txt.setVisible(false);
            bankname_lbl.setVisible(false);
            bankname_txt.setVisible(false);
            cheque_lbl.setVisible(false);
            chequeno_txt.setVisible(false);
        }
        
        if(Combo_mod.getSelectedIndex()== 3)
        {
            dd_lbl.setVisible(false);
            DDno_txt.setVisible(false);
            bankname_lbl.setVisible(true);
            bankname_txt.setVisible(true);
            cheque_lbl.setVisible(false);
            chequeno_txt.setVisible(false);
        }
    }//GEN-LAST:event_Combo_modActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
       if(validation()== true){
            
            String result = insertData();
            if(result.equals("success")){
                JOptionPane.showMessageDialog(this, "Record inserted successfully");
                Print_Reciept p = new Print_Reciept();
                p.setVisible(true);
                this.dispose();
                
            }else{
                 JOptionPane.showMessageDialog(this, "Record insertion failed");
            }
       }
    }//GEN-LAST:event_btn_printActionPerformed

    private void combocourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocourseActionPerformed
        coursename_txt.setText(combocourse.getSelectedItem().toString());
    }//GEN-LAST:event_combocourseActionPerformed

    private void txt_rollNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rollNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rollNoActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        SearchRecord search = new SearchRecord();
        search.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        Home_page home = new Home_page();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

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
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combo_mod;
    private javax.swing.JTextField DDno_txt;
    private javax.swing.JLabel GSTno_lbl;
    private javax.swing.JTextField Received_txt;
    private javax.swing.JTextField Year1_txt;
    private javax.swing.JTextField Year2_txt;
    private javax.swing.JTextField amount_txt;
    private javax.swing.JLabel bankname_lbl;
    private javax.swing.JTextField bankname_txt;
    private javax.swing.JButton btn_print;
    private javax.swing.JTextField cgst_txt;
    private javax.swing.JLabel cheque_lbl;
    private javax.swing.JTextField chequeno_txt;
    private javax.swing.JComboBox<String> combocourse;
    private javax.swing.JTextField coursename_txt;
    private com.toedter.calendar.JDateChooser datechooser;
    private javax.swing.JLabel dd_lbl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel panelback;
    private javax.swing.JPanel panelchild;
    private javax.swing.JPanel paneledit;
    private javax.swing.JPanel panelhome;
    private javax.swing.JPanel panellist;
    private javax.swing.JPanel panellogout;
    private javax.swing.JPanel panelrecord;
    private javax.swing.JPanel panelsearch;
    private javax.swing.JPanel parent2;
    private javax.swing.JTextField reciept_txt;
    private javax.swing.JTextField sgst_txt;
    private javax.swing.JPanel sidebar;
    private javax.swing.JTextField total_txt;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_rollNo;
    private javax.swing.JTextField txt_totalwords;
    // End of variables declaration//GEN-END:variables
}
