/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2017102078_khaerulanwar_uas;
    import java.sql.Connection;
    import java.sql.SQLException;
    import javax.swing.JOptionPane;
    import java.sql.ResultSet;
    import java.sql.Statement;
    import javax.swing.table.DefaultTableModel;
    import net.sf.jasperreports.engine.JasperFillManager;
    import net.sf.jasperreports.engine.JasperPrint;
    import net.sf.jasperreports.view.JasperViewer;
    import java.text.SimpleDateFormat;

/**
 *
 * @author khoer
 */
public class Menu extends javax.swing.JFrame {
    private final DefaultTableModel model;
    private final DefaultTableModel model1;
    private final DefaultTableModel model2;

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        
        model = new DefaultTableModel();
        data.setModel(model);
        
        model.addColumn("Kode Travel");
        model.addColumn("Nama Travel");
        model.addColumn("Keterangan");
        model.addColumn("Harga travel");
        model.addColumn("Jumlah Travel");
        
        getData();
        kosong();
        
        model1 = new DefaultTableModel();
        data1.setModel(model1);
        model1.addColumn("No Sewa");
        model1.addColumn("Nama Penyewa");
        model1.addColumn("Tanggal Sewa");
        model1.addColumn("Kode Travel");
        model1.addColumn("Nama Travel");
        model1.addColumn("Harga Travel");
        model1.addColumn("Jumlah Sewa");
        model1.addColumn("total Bayar");
        
        getData1();
        kosong1();
        
        model2 = new DefaultTableModel();
        data2.setModel(model2);
        model2.addColumn("No Sewa");
        model2.addColumn("Nama Penyewa");
        model2.addColumn("Tanggal Pengembalian");
        model2.addColumn("Kode Travel");
        model2.addColumn("Nama Travel");

        getData2();
        kosong2();
    }
    
    private void kosong(){
        kd_travel.setText("");
        nm_travel.setText("");
        keterangan.setText("");
        harga_travel.setText("");
        jml_travel.setText("");
    }
     private void getData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            String sql = "Select * from tbl_travel_2017102078";
            Statement stat =(Statement)koneksi.koneksi().createStatement();
            ResultSet res = stat.executeQuery (sql);
            
            while (res.next()){
                Object[] obj = new Object[5];
                obj[0] = res.getString("kd_travel");
                obj[1] = res.getString("nm_kendaraan");
                obj[2] = res.getString("keterangan");
                obj[3] = res.getString("harga");
                obj[4] = res.getString("jumlah_travel");
                
                model.addRow(obj);
                kd_travel1.addItem((String) obj[0]);
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
     
     private void kosong1(){
        no_sewa.setText("");
        nm_penyewa.setText("");
        kd_travel1.setSelectedItem("(-- Pilih Kode Travel --)");
        nm_travel1.setText("");
        harga_travel1.setText("");
        jml_sewa.setText("");
        total.setText("");
    }
     private void getData1(){
        model1.getDataVector().removeAllElements();
        model1.fireTableDataChanged();
        
        try{
            String sql = "Select tbl_travel_2017102078.*, tbl_travel_sewa_2017102078.* from tbl_travel_2017102078 Join tbl_travel_sewa_2017102078 on "
                    + "(tbl_travel_2017102078.kd_travel = tbl_travel_sewa_2017102078.kd_travel)";
            Statement stat =(Statement)koneksi.koneksi().createStatement();
            ResultSet res = stat.executeQuery (sql);
            
            while (res.next()){
                Object[] obj = new Object[8];
                obj[0] = res.getString("no_sewa");
                obj[1] = res.getString("nm_penyewa");
                obj[2] = res.getString("tgl_sewa");
                obj[3] = res.getString("kd_travel");
                obj[4] = res.getString("nm_kendaraan");
                obj[5] = res.getString("harga");
                obj[6] = res.getString("jumlah_sewa");
                obj[7] = res.getString("total_bayar");
                
                model1.addRow(obj);
                no_sewa1.addItem((String) obj[0]);
               
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
     
     private void kosong2(){
        no_sewa1.setSelectedItem("(-- Pilih No Sewa --)");
        tgl_kembali.setDate(null);
        dari1.setDate(null);
        sampai1.setDate(null);    
        cari2.setText("");
        
    }
     
     public void getData2(){
        model2.getDataVector().removeAllElements();
        model2.fireTableDataChanged();
        
        try{
            String sql = "Select tbl_travel_2017102078.*, tbl_travel_sewa_2017102078.*, tbl_travel_kembali_2017102078.* from tbl_travel_sewa_2017102078 INNER JOIN tbl_travel_2017102078 on tbl_travel_sewa_2017102078.kd_travel = tbl_travel_2017102078.kd_travel INNER JOIN tbl_travel_kembali_2017102078 on tbl_travel_sewa_2017102078.no_sewa = tbl_travel_kembali_2017102078.no_sewa";
            Statement stat =(Statement)koneksi.koneksi().createStatement();
            ResultSet res = stat.executeQuery (sql);
            
            while (res.next()){
                Object[] obj = new Object[5];
                obj[0] = res.getString("no_sewa");
                obj[1] = res.getString("nm_penyewa");
                obj[2] = res.getString("tgl_kembali");
                obj[3] = res.getString("kd_travel");
                obj[4] = res.getString("nm_kendaraan");
                
                model2.addRow(obj);
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        travel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        kd_travel = new javax.swing.JTextField();
        nm_travel = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        keterangan = new javax.swing.JTextArea();
        harga_travel = new javax.swing.JTextField();
        jml_travel = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        update = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        cetak = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        data = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        sewa = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        no_sewa = new javax.swing.JTextField();
        nm_penyewa = new javax.swing.JTextField();
        kd_travel1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        nm_travel1 = new javax.swing.JTextField();
        harga_travel1 = new javax.swing.JTextField();
        jml_sewa = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        tgl_sewa = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        cari1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        data1 = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        tgl_dari = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        tgl_sampai = new com.toedter.calendar.JDateChooser();
        pengembalian = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        no_sewa1 = new javax.swing.JComboBox<>();
        simpan2 = new javax.swing.JButton();
        hapus2 = new javax.swing.JButton();
        tgl_kembali = new com.toedter.calendar.JDateChooser();
        refresh2 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        data2 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        cari2 = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        dari1 = new com.toedter.calendar.JDateChooser();
        sampai1 = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Welcome to Anwar Travel Dashboard");

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel1)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel1)
                .addContainerGap(246, Short.MAX_VALUE))
        );

        jPanel1.add(home, "card2");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Data Travel"));

        jLabel2.setText("Kode Travel : ");

        jLabel3.setText("Nama Travel : ");

        jLabel4.setText("Keterangan :");

        jLabel5.setText("Harga Travel : ");

        jLabel6.setText("Jumlah Travel : ");

        keterangan.setColumns(20);
        keterangan.setRows(5);
        jScrollPane1.setViewportView(keterangan);

        harga_travel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harga_travelActionPerformed(evt);
            }
        });

        simpan.setText("Simpan Data");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        update.setText("Update Data");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        hapus.setText("Hapus Data");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        refresh.setText("Refresh Data");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        keluar.setText("Keluar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(harga_travel)
                    .addComponent(jml_travel)
                    .addComponent(kd_travel, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nm_travel)
                    .addComponent(jScrollPane1))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kd_travel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simpan))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nm_travel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(hapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(refresh)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(harga_travel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jml_travel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(keluar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setText("Cari Travel : ");

        cetak.setText("Cetak Laporan");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });

        data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Travel", "Nama Travel", "Keterangan", "Harga Travel", "Jumlah Travel"
            }
        ));
        data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(data);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cetak)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout travelLayout = new javax.swing.GroupLayout(travel);
        travel.setLayout(travelLayout);
        travelLayout.setHorizontalGroup(
            travelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(travelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        travelLayout.setVerticalGroup(
            travelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(travelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(travel, "card2");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Sewa Travel"));

        jLabel8.setText("No Sewa : ");

        jLabel9.setText("Nama Penyewa : ");

        jLabel10.setText("Kode Travel : ");

        jLabel11.setText("Nama Travel :");

        jLabel12.setText("Harga Travel :");

        jLabel13.setText("Jumlah Sewa : ");

        jLabel14.setText("Total Bayar : ");

        kd_travel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(-- Pilih Kode Travel --)" }));
        kd_travel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kd_travel1ActionPerformed(evt);
            }
        });

        jLabel15.setText("Tanggal Sewa :");

        jml_sewa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jml_sewaKeyReleased(evt);
            }
        });

        jButton7.setText("Simpan Data");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Update Data");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Hapus Data");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Refresh Data");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Keluar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total)
                    .addComponent(jml_sewa)
                    .addComponent(harga_travel1)
                    .addComponent(nm_travel1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(kd_travel1, javax.swing.GroupLayout.Alignment.LEADING, 0, 235, Short.MAX_VALUE)
                            .addComponent(nm_penyewa, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tgl_sewa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(no_sewa))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(4, 4, 4)
                        .addComponent(jButton8)
                        .addGap(12, 12, 12)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10)
                        .addGap(40, 40, 40)
                        .addComponent(jButton11))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(no_sewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(nm_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(kd_travel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tgl_sewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(nm_travel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(harga_travel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jml_sewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Sewa"));

        jLabel16.setText("Cari Sewa :");

        cari1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cari1KeyReleased(evt);
            }
        });

        data1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No Sewa", "Nama Penyewa", "Tanggal Sewa", "Kode Travel", "Nama Travel", "Harga Travel", "Jumlah Sewa", "Total Bayar"
            }
        ));
        data1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                data1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(data1);

        jButton12.setText("Cetak Laporan");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel20.setText("Dari :");

        jLabel21.setText("Sampai :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cari1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tgl_dari, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tgl_sampai, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton12))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(cari1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton12)
                                .addComponent(jLabel20))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel21)
                                .addComponent(tgl_dari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tgl_sampai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout sewaLayout = new javax.swing.GroupLayout(sewa);
        sewa.setLayout(sewaLayout);
        sewaLayout.setHorizontalGroup(
            sewaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sewaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sewaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sewaLayout.setVerticalGroup(
            sewaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sewaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(sewa, "card2");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Pengembalian"));

        jLabel17.setText("No. Sewa : ");

        jLabel18.setText("Tanggal Kembali : ");

        no_sewa1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(-- Pilih No Sewa --)" }));

        simpan2.setText("Simpan Data");
        simpan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpan2ActionPerformed(evt);
            }
        });

        hapus2.setText("Hapus Data");
        hapus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus2ActionPerformed(evt);
            }
        });

        refresh2.setText("Refresh Data");
        refresh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(no_sewa1, 0, 462, Short.MAX_VALUE)
                    .addComponent(tgl_kembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(simpan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hapus2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refresh2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(101, 101, 101))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(no_sewa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simpan2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(hapus2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refresh2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(tgl_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Pengembalian"));

        data2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No Sewa", "Nama Penyewa", "Tanggal Pengembalian", "Kode Travel", "Nama Travel"
            }
        ));
        jScrollPane4.setViewportView(data2);

        jLabel19.setText("Cari  : ");

        cari2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cari2KeyReleased(evt);
            }
        });

        jButton15.setText("Cetak Laporan");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel22.setText("Dari : ");

        jLabel23.setText("Sampai :");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(cari2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dari1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(sampai1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton15))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sampai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(cari2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton15)
                        .addComponent(jLabel22))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel23)
                        .addComponent(dari1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pengembalianLayout = new javax.swing.GroupLayout(pengembalian);
        pengembalian.setLayout(pengembalianLayout);
        pengembalianLayout.setHorizontalGroup(
            pengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengembalianLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pengembalianLayout.setVerticalGroup(
            pengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengembalianLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(pengembalian, "card2");

        jMenu1.setText("Home");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Travel");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Sewa");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Pengembalian");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void harga_travelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harga_travelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_harga_travelActionPerformed

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        // TODO add your handling code here:
        try{
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("laporan_travel.jasper"),
                    null, koneksi.koneksi());
            JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_cetakActionPerformed

    private void simpan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpan2ActionPerformed
        // TODO add your handling code here:
        String tampilan ="yyyy-MM-dd" ;
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(tgl_kembali.getDate()));
        
        try{
            String sql = "INSERT INTO tbl_travel_kembali_2017102078 (no_sewa, tgl_kembali) "
            + "VALUES ('"+no_sewa1.getSelectedItem()+"',"
            + "'"+tanggal+"')";
            java.sql.Connection con = (Connection) pkg2017102078_khaerulanwar_uas.koneksi.koneksi();
            java.sql.PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
            
            getData2();
            kosong2();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }    
        
    }//GEN-LAST:event_simpan2ActionPerformed

    private void hapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hapus2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        home.setVisible(false);
        travel.setVisible(true);
        sewa.setVisible(false);
        pengembalian.setVisible(false);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        home.setVisible(false);
        travel.setVisible(false);
        sewa.setVisible(true);
        pengembalian.setVisible(false);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        home.setVisible(false);
        travel.setVisible(false);
        sewa.setVisible(false);
        pengembalian.setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        try{
            // TODO add your handling code here:
            String sql = "INSERT INTO tbl_travel_2017102078 (kd_travel,nm_kendaraan,keterangan,harga,jumlah_travel)VALUES ('"+kd_travel.getText()+"',"
            + "'" +nm_travel.getText()+"','"+keterangan.getText()+"','"+harga_travel.getText()+"','"+jml_travel.getText()+"')";
            java.sql.Connection con = (Connection) pkg2017102078_khaerulanwar_uas.koneksi.koneksi();
            java.sql.PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
            getData();
            kosong();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_simpanActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "UPDATE tbl_travel_2017102078 SET nm_kendaraan='"+nm_travel.getText()+"',"
            + "keterangan='"+keterangan.getText()+"',harga='"+harga_travel.getText()+"',jumlah_travel='"+jml_travel.getText()+"'"
                    + " where kd_travel ='"+ kd_travel.getText()+"'";
            java.sql.Connection con = (Connection) pkg2017102078_khaerulanwar_uas.koneksi.koneksi();
            java.sql.PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            JOptionPane.showMessageDialog(null,"Data Berhasil Diupdate");
            getData();
            kosong();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_updateActionPerformed

    private void dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataMouseClicked
        // TODO add your handling code here:
        try{
            int row = data.getSelectedRow();
            String tabel_klik = (data.getModel().getValueAt(row,0).toString());
            java.sql.Connection con = (Connection)pkg2017102078_khaerulanwar_uas.koneksi.koneksi();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("select * from tbl_travel_2017102078 where kd_travel='"+tabel_klik+"'");
            if(sql.next()){
                String kode_travel = sql.getString("kd_travel");
                kd_travel.setText(kode_travel);
                String nama_travel = sql.getString("nm_kendaraan");
                nm_travel.setText(nama_travel);
                String keterangan_travel = sql.getString("keterangan");
                keterangan.setText(keterangan_travel);
                String harga = sql.getString("harga");
                harga_travel.setText(harga);
                String jumlah_travel = sql.getString("jumlah_travel");
                jml_travel.setText(jumlah_travel);
            }
        } catch (SQLException e){}
    }//GEN-LAST:event_dataMouseClicked

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Yakin Ingin Menghapus Data Ini = '"+kd_travel.getText()+"'",
            ".:: Konfirmasi ::.", JOptionPane.YES_NO_OPTION);
        if (ok==0){
            try{
                String sql = "Delete from tbl_travel_2017102078 where kd_travel='"+kd_travel.getText()+"'";
                java.sql.Connection con = (Connection)pkg2017102078_khaerulanwar_uas.koneksi.koneksi();
                java.sql.PreparedStatement stm = con.prepareStatement(sql);
                stm.execute();

                getData();
                kosong();

            }catch (SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        kosong();
    }//GEN-LAST:event_refreshActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try{
            String sql = "select* from tbl_travel_2017102078 WHERE kd_travel like '%"+cari.getText()+"' " 
                    + "OR nm_kendaraan like '%"+cari.getText()+"%' " + "OR keterangan like '%"+cari.getText()+"%' "
                    + "OR harga like '%"+cari.getText()+"%' " + "OR jumlah_travel like '%"+cari.getText()+"%' ";
            Statement stat = (Statement) koneksi.koneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while (res.next()){
                Object[] obj = new Object[6];
                obj[0] = res.getString("kd_travel");
                obj[1] = res.getString("nm_kendaraan");
                obj[2] = res.getString("keterangan");
                obj[3] = res.getString("harga");
                obj[4] = res.getString("jumlah_travel");
                
                model.addRow(obj);
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void kd_travel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kd_travel1ActionPerformed
        // TODO add your handling code here:
        try{
            java.sql.Connection con = (Connection) pkg2017102078_khaerulanwar_uas.koneksi.koneksi();
            java.sql.Statement stm  = con.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("select * from tbl_travel_2017102078 where "
                    + "kd_travel='"+kd_travel1.getSelectedItem()+"'");

            if(sql.next()){
                String nama1 = sql.getString("nm_kendaraan");
                nm_travel1.setText(nama1);
                String hrg = sql.getString("harga");
                harga_travel1.setText(hrg);
            }
        }
        catch (Exception e){}
    }//GEN-LAST:event_kd_travel1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String tampilan ="yyyy-MM-dd" ;
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(tgl_sewa.getDate()));
        
        try{
            String sql1 = "INSERT INTO tbl_travel_sewa_2017102078 (no_sewa, tgl_sewa, nm_penyewa, kd_travel, jumlah_sewa, total_bayar) "
            + "VALUES ('"+no_sewa.getText()+"',"
            + "'"+tanggal+"',"
            + "'"+nm_penyewa.getText()+"','"+kd_travel1.getSelectedItem()+"','"+jml_sewa.getText()+"','"+total.getText()+"')";
            java.sql.Connection con = (Connection)pkg2017102078_khaerulanwar_uas.koneksi.koneksi();
            java.sql.PreparedStatement stm = con.prepareStatement(sql1);

            java.sql.Statement stm1  = con.createStatement();
            java.sql.ResultSet sql = stm1.executeQuery("select * from tbl_travel_2017102078 where "
                + "kd_travel='"+kd_travel1.getSelectedItem()+"'");

            if(sql.next()){
                String jml_sewa = sql.getString("jumlah_travel");
            }

            int jumlah_sewa = Integer.parseInt(jml_sewa.getText());
            int travel_Awal = sql.getInt("jumlah_travel");
            int sisa_travel = jumlah_sewa - travel_Awal;

            String sql2 = "Update tbl_travel_2017102078 SET jumlah_travel ='"+sisa_travel+"' "
            + "where kd_travel ='"+kd_travel1.getSelectedItem()+"'";
            java.sql.Connection con1 = (Connection) pkg2017102078_khaerulanwar_uas.koneksi.koneksi();
            java.sql.PreparedStatement stm2 = con1.prepareStatement(sql2);

            stm.execute();
            stm2.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            getData1();
            getData();
            kosong1();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jml_sewaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jml_sewaKeyReleased
        // TODO add your handling code here:
        Double harga_travel = Double.parseDouble(harga_travel1.getText());
        Double jumlah_sewa = Double.parseDouble(jml_sewa.getText());
        Double hasil_total = harga_travel * jumlah_sewa;
        total.setText(String.valueOf(hasil_total));
    }//GEN-LAST:event_jml_sewaKeyReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "UPDATE tbl_travel_sewa_2017102078 SET nm_penyewa='"+nm_penyewa.getText()+"',kd_travel='"+kd_travel1.getSelectedItem()+"',"
            + "jumlah_sewa='"+jml_sewa.getText()+"',total_bayar='"+total.getText()+"' where no_sewa ='"+ no_sewa.getText()+"'";
            java.sql.Connection con = (Connection) pkg2017102078_khaerulanwar_uas.koneksi.koneksi();
            java.sql.PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            JOptionPane.showMessageDialog(null,"Data Berhasil Diupdate");
            getData1();
            kosong1();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void data1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data1MouseClicked
        // TODO add your handling code here:
        try{
            int row = data1.getSelectedRow();
            String tabel_klik = (data1.getModel().getValueAt(row,0).toString());
            java.sql.Connection con = (Connection)pkg2017102078_khaerulanwar_uas.koneksi.koneksi();
            java.sql.Statement stm  = con.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT * FROM tbl_travel_sewa_2017102078 JOIN tbl_travel_2017102078 ON tbl_travel_sewa_2017102078.kd_travel=tbl_travel_2017102078.kd_travel WHERE tbl_travel_sewa_2017102078.no_sewa='"+tabel_klik+"'");
            
            if(sql.next()){
                String no = sql.getString("tbl_travel_sewa_2017102078.no_sewa");
                no_sewa.setText(no);
                String nama_pemsn = sql.getString("tbl_travel_sewa_2017102078.nm_penyewa");
                nm_penyewa.setText(nama_pemsn);
                String tg_cekin = sql.getString("tbl_travel_sewa_2017102078.tgl_sewa");
                tgl_sewa.setDateFormatString(tg_cekin);
                String kd = sql.getString("tbl_travel_sewa_2017102078.kd_travel");
                kd_travel1.setSelectedItem(kd);
                String jmlh = sql.getString("tbl_travel_sewa_2017102078.jumlah_sewa");
                jml_sewa.setText(jmlh);
                String total_byr = sql.getString("tbl_travel_sewa_2017102078.total_bayar");
                total.setText(total_byr);
            }
        }
        catch (Exception e){}
    }//GEN-LAST:event_data1MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Anda Yakin Ingin Menghapus Data Ini = '"+no_sewa.getText()+"'",
            ".:: Konfirmasi ::.", JOptionPane.YES_NO_OPTION);
        if (ok==0){
            try{
                String sql = "Delete from tbl_travel_sewa_2017102078 where no_sewa='"+no_sewa.getText()+"'";
                java.sql.Connection con = (Connection)pkg2017102078_khaerulanwar_uas.koneksi.koneksi();
                java.sql.PreparedStatement stm = con.prepareStatement(sql);
                stm.execute();

                getData1();
                kosong1();

            }catch (SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }   
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        kosong1();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void cari1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cari1KeyReleased
        // TODO add your handling code here:
        model1.getDataVector().removeAllElements();
        model1.fireTableDataChanged();
        
        try{
            String sql = "SELECT * FROM tbl_travel_sewa_2017102078 JOIN tbl_travel_2017102078 ON tbl_travel_sewa_2017102078.kd_travel=tbl_travel_2017102078.kd_travel WHERE tbl_travel_sewa_2017102078.tgl_sewa LIKE '%"+cari1.getText()+"%'"
            + "OR tbl_travel_sewa_2017102078.no_sewa like'%"+cari1.getText()+"%'"+ "OR tbl_travel_sewa_2017102078.nm_penyewa like'%"+cari1.getText()+"%'"+ "OR tbl_travel_sewa_2017102078.kd_travel like'%"+cari1.getText()+"%'";
            Statement stat =(Statement)koneksi.koneksi().createStatement();
            ResultSet res = stat.executeQuery (sql);
            
            while (res.next()){
                Object[] obj = new Object[8];
                obj[0] = res.getString("no_sewa");
                obj[1] = res.getString("nm_penyewa");
                obj[2] = res.getString("tgl_sewa");
                obj[3] = res.getString("kd_travel");
                obj[4] = res.getString("nm_kendaraan");
                obj[5] = res.getString("harga");
                obj[6] = res.getString("jumlah_sewa");
                obj[7] = res.getString("total_bayar");
                
                model1.addRow(obj);
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_cari1KeyReleased

    private void refresh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh2ActionPerformed
        // TODO add your handling code here:
        kosong2();
    }//GEN-LAST:event_refresh2ActionPerformed

    private void cari2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cari2KeyReleased
        // TODO add your handling code here:
        model2.getDataVector().removeAllElements();
        model2.fireTableDataChanged();
        
        try{
            String sql = "SELECT * FROM tbl_travel_2017102078 INNER JOIN tbl_travel_sewa_2017102078 ON tbl_travel_2017102078.kd_travel=tbl_travel_sewa_2017102078.kd_travel INNER JOIN tbl_travel_kembali_2017102078 on tbl_travel_kembali_2017102078.no_sewa=tbl_travel_sewa_2017102078.no_sewa WHERE tbl_travel_kembali_2017102078.tgl_kembali LIKE '%"+cari2.getText()+"%'"
            + "OR tbl_travel_kembali_2017102078.no_sewa like'%"+cari2.getText()+"%'"+ "OR tbl_travel_sewa_2017102078.no_sewa like'%"+cari2.getText()+"%'"+ "OR tbl_travel_sewa_2017102078.kd_travel like'%"+cari2.getText()+"%'"+ "OR tbl_travel_2017102078.kd_travel like'%"+cari2.getText()+"%'";
            Statement stat =(Statement)koneksi.koneksi().createStatement();
            ResultSet res = stat.executeQuery (sql);
            
            while (res.next()){
                Object[] obj = new Object[5];
                obj[0] = res.getString("no_sewa");
                obj[1] = res.getString("nm_penyewa");
                obj[2] = res.getString("tgl_kembali");
                obj[3] = res.getString("kd_travel");
                obj[4] = res.getString("nm_kendaraan");
                
                model2.addRow(obj);
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_cari2KeyReleased

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        try{
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("laporan_sewa.jasper"),
                    null, koneksi.koneksi());
            JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        try{
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("laporan_pengembalian.jasper"),
                    null, koneksi.koneksi());
            JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JTextField cari1;
    private javax.swing.JTextField cari2;
    private javax.swing.JButton cetak;
    private com.toedter.calendar.JDateChooser dari1;
    private javax.swing.JTable data;
    private javax.swing.JTable data1;
    private javax.swing.JTable data2;
    private javax.swing.JButton hapus;
    private javax.swing.JButton hapus2;
    private javax.swing.JTextField harga_travel;
    private javax.swing.JTextField harga_travel1;
    private javax.swing.JPanel home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jml_sewa;
    private javax.swing.JTextField jml_travel;
    private javax.swing.JTextField kd_travel;
    private javax.swing.JComboBox<String> kd_travel1;
    private javax.swing.JButton keluar;
    private javax.swing.JTextArea keterangan;
    private javax.swing.JTextField nm_penyewa;
    private javax.swing.JTextField nm_travel;
    private javax.swing.JTextField nm_travel1;
    private javax.swing.JTextField no_sewa;
    private javax.swing.JComboBox<String> no_sewa1;
    private javax.swing.JPanel pengembalian;
    private javax.swing.JButton refresh;
    private javax.swing.JButton refresh2;
    private com.toedter.calendar.JDateChooser sampai1;
    private javax.swing.JPanel sewa;
    private javax.swing.JButton simpan;
    private javax.swing.JButton simpan2;
    private com.toedter.calendar.JDateChooser tgl_dari;
    private com.toedter.calendar.JDateChooser tgl_kembali;
    private com.toedter.calendar.JDateChooser tgl_sampai;
    private com.toedter.calendar.JDateChooser tgl_sewa;
    private javax.swing.JTextField total;
    private javax.swing.JPanel travel;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
