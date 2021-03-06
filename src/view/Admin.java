/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DAO;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicListUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import model.Bill;
import model.Contract;
import model.Feedback;
import model.HDDienNuoc;
import model.Request;
import model.Room;
import model.Student;
import model.TypeRoom;
import model.User;
import model.Zone;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import static view.DangKyThongTin.converter;

/**
 *
 * @author VanTinh
 */

public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame2
     */
    CardLayout card;
    DefaultTableModel model,modelCard2,model3;
    DefaultTableModel modelCard3;
    DefaultTableModel modelCard4;
    DefaultTableModel modelCard5;
    SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
    private ArrayList<User>listUser=new DAO().getListUser();
    private ArrayList<Zone> listZone;
    private ArrayList<Room> listRoom;
    private ArrayList<TypeRoom>listType=new DAO().getListTypeRoom();
    private ArrayList<Contract>listContract=new DAO().getListContract();
    private ArrayList<Bill>listBillAll=new DAO().getListBillAll();
    private ArrayList<Student> listStudent=new DAO().getListStudent();
    public Admin() {
        initComponents();
        card=(CardLayout)cardRight.getLayout();
        model=(DefaultTableModel) roomTable1.getModel();
        modelCard2=(DefaultTableModel) roomTable2.getModel();
        modelCard3=(DefaultTableModel) studentTable.getModel();
        showTable(model);
        showTable(modelCard2);
        setVisiCheckTT();
        sdt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9')
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
          cmnd.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9')
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
           headIndex.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9')
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
            lastIndex.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9')
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
            tienChi_HDR.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9')
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
            
          showTable_Zone();
          showTable_Type();
          addItem_Zone();
          showTable_Contract();
          content_1.setLineWrap(true);
          content_1.setWrapStyleWord(true);
          content_2.setLineWrap(true);
          content_2.setWrapStyleWord(true);
          noiDung_HD.setLineWrap(true);
          noiDung_HD.setWrapStyleWord(true);
          setSize_DueytDon();
          setSize_RoomDky();
          setSize_RoomTT();
          setSize_DichVu();
          setSize_Zone();
          setSize_Student();
          setSize_Contract();
          setSize_HDDien();
          setSize_Request();
          setSize_TTDien();
          DefaultTableModel dfm1423=(DefaultTableModel) tableDuyet.getModel();
          showTable_DuyetDon(dfm1423);
          dong.setVisible(false);
          Date d=new Date();
          int month=month(d);
          if(month>=8&&month<=12){
              motKiCheck.setVisible(true);
              haiKiCheck.setVisible(true);
              baKiCheck.setVisible(true);
              motKiL.setVisible(true);
              haiKiL.setVisible(true);
              motKiL.setText("H???c k?? 1 - 5 th??ng");
              haiKiL.setText("H???c k?? 1 v?? 2 - 10 th??ng");
          }else if(month>=1&&month<=5){
              motKiCheck.setVisible(true);
              haiKiCheck.setVisible(true);
              baKiCheck.setVisible(false);
              motKiL.setVisible(true);
              haiKiL.setVisible(true);
              motKiL.setText("H???c k?? 3 - 2 th??ng");
              haiKiL.setText("H???c k?? 2 v?? 3 - 7 th??ng");
          }else{
              motKiCheck.setVisible(true);
              haiKiCheck.setVisible(false);
              baKiCheck.setVisible(false);
              motKiL.setVisible(true);
              haiKiL.setVisible(false);
              motKiL.setText("H???c k?? 3 - 2 th??ng");
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jSeparator21 = new javax.swing.JSeparator();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        cardRight = new javax.swing.JPanel();
        carrdDuyet = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tableDuyet = new javax.swing.JTable();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        idBill = new javax.swing.JLabel();
        dateCr = new javax.swing.JLabel();
        mssvB = new javax.swing.JLabel();
        roomB = new javax.swing.JLabel();
        contentB = new javax.swing.JLabel();
        hocKyB = new javax.swing.JLabel();
        tongTienB = new javax.swing.JLabel();
        dong = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        cardIn1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        hoTen = new javax.swing.JTextField();
        mssv = new javax.swing.JTextField();
        lop = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmnd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ngaySinh = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        sdt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        diaChi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        quocTich = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tonGiao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        danToc = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        nganh = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        namCheck = new javax.swing.JCheckBox();
        nuCheck = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        zoneComboBox = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        typeRoomComboBox = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        roomComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomTable1 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        checkTen = new javax.swing.JLabel();
        checkMSSV = new javax.swing.JLabel();
        checkClass = new javax.swing.JLabel();
        checkCMND = new javax.swing.JLabel();
        checkSDT = new javax.swing.JLabel();
        checkEmail = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        motKiCheck = new javax.swing.JCheckBox();
        haiKiCheck = new javax.swing.JCheckBox();
        baKiCheck = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        motKiL = new javax.swing.JLabel();
        haiKiL = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        searchRoom = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        tongTien_Dky = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cardIn2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        roomTable2 = new javax.swing.JTable();
        allRoom = new javax.swing.JCheckBox();
        roomTrong = new javax.swing.JCheckBox();
        roomDay = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        zoneTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        typeTable = new javax.swing.JTable();
        allZone = new javax.swing.JCheckBox();
        zoneTrong = new javax.swing.JCheckBox();
        zoneDay = new javax.swing.JCheckBox();
        jLabel24 = new javax.swing.JLabel();
        zoneSearch = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        card3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        mssvL = new javax.swing.JLabel();
        tenT = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lopT = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        nganhT = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        ngaySinhT = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        sdtT = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        emailT = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel36 = new javax.swing.JLabel();
        diaChiT = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel37 = new javax.swing.JLabel();
        quocTichT = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel38 = new javax.swing.JLabel();
        danTocT = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel39 = new javax.swing.JLabel();
        tonGiaoT = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        chinhSuaSV = new javax.swing.JButton();
        xacNhanSV = new javax.swing.JButton();
        huySV = new javax.swing.JButton();
        card4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        maHD = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        ten_HD = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        lop_HD = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        nganh_HD = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        phong_HD = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        ngayBD_HD = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        ngayKT_HD = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        tongTien_HD = new javax.swing.JLabel();
        dong_CT = new javax.swing.JLabel();
        giaHan = new javax.swing.JButton();
        chuyenPhong_HD = new javax.swing.JButton();
        mssv_HD = new javax.swing.JLabel();
        giaHanPanel = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        ngayKT_HD1 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        tongTien_GH = new javax.swing.JLabel();
        dong2 = new javax.swing.JLabel();
        xacNhan_GH = new javax.swing.JButton();
        huy_GH = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        ngayKT_HD2 = new javax.swing.JLabel();
        kiGH_HD = new javax.swing.JComboBox<>();
        checkLB = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        noiDung_HD = new javax.swing.JTextArea();
        chuyenPhongPanel = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        phong_CP = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        tien_CP = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel65 = new javax.swing.JLabel();
        tt_CP = new javax.swing.JLabel();
        xacNhan_CP = new javax.swing.JButton();
        huy_CP = new javax.swing.JButton();
        tien_CP1 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        contractTable = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        card5 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        roomTable_HDDN = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        headIndex = new javax.swing.JTextField();
        lastIndex = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel50 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        bac1 = new javax.swing.JLabel();
        bac2 = new javax.swing.JLabel();
        bac3 = new javax.swing.JLabel();
        bac4 = new javax.swing.JLabel();
        bac5 = new javax.swing.JLabel();
        bac6 = new javax.swing.JLabel();
        tongTien_chuaVAT = new javax.swing.JLabel();
        VAT = new javax.swing.JLabel();
        tongtien_VAT = new javax.swing.JLabel();
        useE = new javax.swing.JTextField();
        canhbao_HDDN = new javax.swing.JLabel();
        phong_HDDN = new javax.swing.JLabel();
        thangChot = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        namChot = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        ngayChot = new javax.swing.JLabel();
        xacNhan_HDDN = new javax.swing.JButton();
        d2 = new javax.swing.JLabel();
        d3 = new javax.swing.JLabel();
        d1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        phong_HDDN1 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        HDDN_Table = new javax.swing.JTable();
        thanhToanHD_Panel = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        thanhToan_HDDN = new javax.swing.JButton();
        tongTien_HDDN = new javax.swing.JLabel();
        card6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        request_Table = new javax.swing.JTable();
        panel_StatusRe = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        s_check4 = new javax.swing.JCheckBox();
        s_check1 = new javax.swing.JCheckBox();
        s_check2 = new javax.swing.JCheckBox();
        s_check3 = new javax.swing.JCheckBox();
        s_text = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        confirm_s = new javax.swing.JButton();
        cancel_s = new javax.swing.JButton();
        status_L = new javax.swing.JLabel();
        panel_HDRe = new javax.swing.JPanel();
        ngayChi_HDR = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        status_L1 = new javax.swing.JLabel();
        status_L2 = new javax.swing.JLabel();
        noiDungChi_HDR = new javax.swing.JTextField();
        jSeparator19 = new javax.swing.JSeparator();
        status_L3 = new javax.swing.JLabel();
        tienChi_HDR = new javax.swing.JTextField();
        jSeparator20 = new javax.swing.JSeparator();
        createHDRe = new javax.swing.JButton();
        cancel_HDR = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        idsv_1 = new javax.swing.JLabel();
        date_1 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        one1 = new javax.swing.JLabel();
        two1 = new javax.swing.JLabel();
        three1 = new javax.swing.JLabel();
        four1 = new javax.swing.JLabel();
        five1 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        one2 = new javax.swing.JLabel();
        two2 = new javax.swing.JLabel();
        three2 = new javax.swing.JLabel();
        four2 = new javax.swing.JLabel();
        five2 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        one3 = new javax.swing.JLabel();
        two3 = new javax.swing.JLabel();
        three3 = new javax.swing.JLabel();
        four3 = new javax.swing.JLabel();
        five3 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        content_1 = new javax.swing.JTextArea();
        jLabel105 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        idsv_2 = new javax.swing.JLabel();
        date_2 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        one4 = new javax.swing.JLabel();
        two4 = new javax.swing.JLabel();
        three4 = new javax.swing.JLabel();
        four4 = new javax.swing.JLabel();
        five4 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        one5 = new javax.swing.JLabel();
        two5 = new javax.swing.JLabel();
        three5 = new javax.swing.JLabel();
        four5 = new javax.swing.JLabel();
        five5 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        one6 = new javax.swing.JLabel();
        two6 = new javax.swing.JLabel();
        three6 = new javax.swing.JLabel();
        four6 = new javax.swing.JLabel();
        five6 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        content_2 = new javax.swing.JTextArea();
        jLabel126 = new javax.swing.JLabel();
        backF = new javax.swing.JLabel();
        nexttF = new javax.swing.JLabel();
        pageF = new javax.swing.JLabel();
        card7 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        chart1 = new javax.swing.JPanel();
        chart3 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        zoneCombo = new javax.swing.JComboBox<>();
        chart2 = new javax.swing.JPanel();
        card8 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        ky_TK = new javax.swing.JComboBox<>();
        label2 = new javax.swing.JLabel();
        namHoc_TK = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        doanhThu = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        loaiCombo = new javax.swing.JComboBox<>();
        ngayBD_TK = new com.toedter.calendar.JDateChooser();
        ngayKT_TK = new com.toedter.calendar.JDateChooser();
        thongke = new javax.swing.JButton();

        jMenuItem1.setText("Clear All");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(36, 47, 65));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_signing_a_document_20px_1.png")); // NOI18N
        jButton1.setText("????ng K?? Ph??ng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_info_20px.png")); // NOI18N
        jButton2.setText("Chi ti???t ph??ng KTX");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_student_male_20px.png")); // NOI18N
        jButton3.setText("Qu???n L?? Sinh vi??n");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_contract_20px.png")); // NOI18N
        jButton4.setText("H???p ?????ng");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_bill_20px.png")); // NOI18N
        jButton5.setText("QL H??a ????n ??i???n");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_ask_question_20px.png")); // NOI18N
        jButton6.setText("Y??u C???u-Ph???n H???i");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(36, 47, 65));

        jLabel13.setBackground(new java.awt.Color(36, 47, 65));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_manager_40px.png")); // NOI18N
        jLabel13.setText(" ");

        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_exit_20px_1.png")); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(back)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("ADMIN");

        jSeparator21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel82.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_phone_15px_1.png")); // NOI18N
        jLabel82.setText("Contact with us");

        jLabel83.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("0879229094");

        jLabel84.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("0905783245");

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(0, 0, 0));
        jButton14.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_email_document_20px.png")); // NOI18N
        jButton14.setText("Y??u C???u ??K KTX");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(0, 0, 0));
        jButton11.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_ask_question_20px.png")); // NOI18N
        jButton11.setText("Th???ng K?? D??? Li???u");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(255, 255, 255));
        jButton15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(0, 0, 0));
        jButton15.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_ask_question_20px.png")); // NOI18N
        jButton15.setText("Th???ng K?? Doanh Thu");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator21)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel82, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel83)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel84)
                .addGap(182, 182, 182))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        cardRight.setLayout(new java.awt.CardLayout());

        carrdDuyet.setBackground(new java.awt.Color(0, 204, 204));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 0, 0));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("X??t Duy???t ????n ????ng K??");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel80, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        tableDuyet.setForeground(new java.awt.Color(0, 0, 0));
        tableDuyet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "T??n", "MSSV", "L???p", "Ng??nh", "Ng??y ????ng k??", "Ph??ng ????ng k??", "Tr???ng th??i"
            }
        ));
        tableDuyet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDuyetMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableDuyetMousePressed(evt);
            }
        });
        jScrollPane13.setViewportView(tableDuyet);

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("Th??ng Tin H??a ????n");

        jLabel86.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText("M?? h??a ????n:");
        jLabel86.setToolTipText("");

        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("Ng??y ????ng k??:");
        jLabel89.setToolTipText("");

        jLabel90.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setText("MSSV:");
        jLabel90.setToolTipText("");

        jLabel91.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setText("Ph??ng ????ng k??:");
        jLabel91.setToolTipText("");

        jLabel92.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setText("N???i Dung:");
        jLabel92.setToolTipText("");

        jLabel93.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setText("H???c k???:");
        jLabel93.setToolTipText("");

        jLabel95.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setText("T???ng ti???n ph???i thanh to??n:");
        jLabel95.setToolTipText("");

        idBill.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        idBill.setForeground(new java.awt.Color(0, 0, 0));
        idBill.setToolTipText("");

        dateCr.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dateCr.setForeground(new java.awt.Color(0, 0, 0));
        dateCr.setText(" ");
        dateCr.setToolTipText("");

        mssvB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mssvB.setForeground(new java.awt.Color(0, 0, 0));
        mssvB.setText(" ");
        mssvB.setToolTipText("");

        roomB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        roomB.setForeground(new java.awt.Color(0, 0, 0));
        roomB.setText(" ");
        roomB.setToolTipText("");

        contentB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        contentB.setForeground(new java.awt.Color(0, 0, 0));
        contentB.setText(" ");
        contentB.setToolTipText("");

        hocKyB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hocKyB.setForeground(new java.awt.Color(0, 0, 0));
        hocKyB.setText(" ");
        hocKyB.setToolTipText("");

        tongTienB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tongTienB.setForeground(new java.awt.Color(204, 0, 0));
        tongTienB.setText(" ");
        tongTienB.setToolTipText("");

        dong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dong.setForeground(new java.awt.Color(204, 0, 0));
        dong.setText("?????ng");
        dong.setToolTipText("");

        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(0, 0, 0));
        jButton12.setText("Ph?? Duy???t");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(0, 0, 0));
        jButton13.setText("Kh??ng Ph?? Duy???t");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout carrdDuyetLayout = new javax.swing.GroupLayout(carrdDuyet);
        carrdDuyet.setLayout(carrdDuyetLayout);
        carrdDuyetLayout.setHorizontalGroup(
            carrdDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carrdDuyetLayout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(carrdDuyetLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(carrdDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carrdDuyetLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(carrdDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(carrdDuyetLayout.createSequentialGroup()
                                .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tongTienB, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dong, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(carrdDuyetLayout.createSequentialGroup()
                                .addGroup(carrdDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(carrdDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(roomB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mssvB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateCr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(idBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hocKyB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(contentB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(80, 80, 80))
                    .addGroup(carrdDuyetLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(carrdDuyetLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jButton13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        carrdDuyetLayout.setVerticalGroup(
            carrdDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carrdDuyetLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(carrdDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(carrdDuyetLayout.createSequentialGroup()
                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(carrdDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idBill, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(carrdDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateCr, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(carrdDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mssvB, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(carrdDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomB, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(carrdDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contentB, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(carrdDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hocKyB, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(carrdDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tongTienB, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(carrdDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(262, Short.MAX_VALUE))
        );

        cardRight.add(carrdDuyet, "card8");

        cardIn1.setBackground(new java.awt.Color(0, 204, 204));
        cardIn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cardIn1MouseReleased(evt);
            }
        });
        cardIn1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("T??n ?????y ?????:");
        cardIn1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 129, 33));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mssv:");
        cardIn1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 91, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("L???p:");
        cardIn1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 91, 32));

        hoTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        hoTen.setForeground(new java.awt.Color(0, 0, 0));
        cardIn1.add(hoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 390, -1));

        mssv.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mssv.setForeground(new java.awt.Color(0, 0, 0));
        mssv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mssvKeyReleased(evt);
            }
        });
        cardIn1.add(mssv, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 390, 32));

        lop.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lop.setForeground(new java.awt.Color(0, 0, 0));
        cardIn1.add(lop, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 390, 32));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CMND/CCCD:");
        cardIn1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 129, 32));

        cmnd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmnd.setForeground(new java.awt.Color(0, 0, 0));
        cardIn1.add(cmnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 390, 32));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ng??y sinh:");
        cardIn1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 129, 32));

        ngaySinh.setDateFormatString("dd/MM/yyyy");
        cardIn1.add(ngaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 395, 32));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("S??? ??i???n tho???i:");
        cardIn1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 129, 34));

        sdt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sdt.setForeground(new java.awt.Color(0, 0, 0));
        cardIn1.add(sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 395, 32));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email:");
        cardIn1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 129, 32));

        email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        email.setForeground(new java.awt.Color(0, 0, 0));
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailKeyReleased(evt);
            }
        });
        cardIn1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 395, 32));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("?????a ch???:");
        cardIn1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 129, 40));

        diaChi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        diaChi.setForeground(new java.awt.Color(0, 0, 0));
        cardIn1.add(diaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 395, 32));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Qu???c t???ch:");
        cardIn1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 510, 120, 30));

        quocTich.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        quocTich.setForeground(new java.awt.Color(0, 0, 0));
        cardIn1.add(quocTich, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 395, 32));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("T??n gi??o:");
        cardIn1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 129, 30));

        tonGiao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tonGiao.setForeground(new java.awt.Color(0, 0, 0));
        cardIn1.add(tonGiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, 395, 32));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("D??n t???c:");
        cardIn1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 129, 30));

        danToc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        danToc.setForeground(new java.awt.Color(0, 0, 0));
        cardIn1.add(danToc, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 610, 395, 32));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Ng??nh:");
        cardIn1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 129, -1));

        nganh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nganh.setForeground(new java.awt.Color(0, 0, 0));
        cardIn1.add(nganh, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 660, 395, 32));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Gi???i t??nh:");
        cardIn1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 703, 129, 40));

        namCheck.setBackground(new java.awt.Color(0, 204, 204));
        namCheck.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        namCheck.setForeground(new java.awt.Color(0, 0, 0));
        namCheck.setText("Nam");
        namCheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                namCheckMousePressed(evt);
            }
        });
        namCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namCheckActionPerformed(evt);
            }
        });
        cardIn1.add(namCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 710, 124, -1));

        nuCheck.setBackground(new java.awt.Color(0, 204, 204));
        nuCheck.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nuCheck.setForeground(new java.awt.Color(0, 0, 0));
        nuCheck.setText("N???");
        nuCheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nuCheckMousePressed(evt);
            }
        });
        cardIn1.add(nuCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 710, 124, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Khu:");
        cardIn1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, 129, 33));

        zoneComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                zoneComboBoxMousePressed(evt);
            }
        });
        zoneComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoneComboBoxActionPerformed(evt);
            }
        });
        cardIn1.add(zoneComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, 379, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Lo???i ph??ng:");
        cardIn1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 129, 33));

        typeRoomComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "D???ch v??? lo???i 1 - 430k/1 th??ng", "D???ch v??? lo???i 2 - 330k/1 th??ng", "Th?????ng - 120k/1 th??ng" }));
        typeRoomComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                typeRoomComboBoxMousePressed(evt);
            }
        });
        typeRoomComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeRoomComboBoxActionPerformed(evt);
            }
        });
        cardIn1.add(typeRoomComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 160, 379, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("T??m ki???m ph??ng:");
        cardIn1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 243, 110, 40));

        cardIn1.add(roomComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, 379, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        roomTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "T??n ph??ng", "SLT??", "SLHC", "Lo???i ph??ng", "Khu", "Gi?? ti???n", "Tr???ng th??i"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        roomTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                roomTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(roomTable1);

        cardIn1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 620, 271));

        jButton7.setBackground(new java.awt.Color(0, 255, 204));
        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton7.setText("????ng K??");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        cardIn1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 790, 200, -1));

        checkTen.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        checkTen.setForeground(new java.awt.Color(255, 0, 0));
        checkTen.setText("*Th??ng tin kh??ng h???p l???");
        cardIn1.add(checkTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 380, -1));

        checkMSSV.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        checkMSSV.setForeground(new java.awt.Color(255, 0, 0));
        checkMSSV.setText("*Th??ng tin kh??ng h???p l???");
        cardIn1.add(checkMSSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 370, -1));

        checkClass.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        checkClass.setForeground(new java.awt.Color(255, 0, 0));
        checkClass.setText("*Th??ng tin kh??ng h???p l???");
        cardIn1.add(checkClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 370, -1));

        checkCMND.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        checkCMND.setForeground(new java.awt.Color(255, 0, 0));
        checkCMND.setText("*Th??ng tin kh??ng h???p l???");
        cardIn1.add(checkCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 370, -1));

        checkSDT.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        checkSDT.setForeground(new java.awt.Color(255, 0, 0));
        checkSDT.setText("*Th??ng tin kh??ng h???p l???");
        cardIn1.add(checkSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 370, -1));

        checkEmail.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        checkEmail.setForeground(new java.awt.Color(255, 0, 0));
        checkEmail.setText("*Th??ng tin kh??ng h???p l???");
        cardIn1.add(checkEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 370, -1));

        jButton8.setText("Hi???n th??? t???t c??? ph??ng");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        cardIn1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 260, 140, -1));

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));

        motKiCheck.setBackground(new java.awt.Color(0, 204, 204));
        motKiCheck.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        motKiCheck.setForeground(new java.awt.Color(0, 0, 0));
        motKiCheck.setText("1 K??");
        motKiCheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                motKiCheckMousePressed(evt);
            }
        });
        motKiCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motKiCheckActionPerformed(evt);
            }
        });

        haiKiCheck.setBackground(new java.awt.Color(0, 204, 204));
        haiKiCheck.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        haiKiCheck.setForeground(new java.awt.Color(0, 0, 0));
        haiKiCheck.setText("2 K??");
        haiKiCheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                haiKiCheckMousePressed(evt);
            }
        });
        haiKiCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                haiKiCheckActionPerformed(evt);
            }
        });

        baKiCheck.setBackground(new java.awt.Color(0, 204, 204));
        baKiCheck.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        baKiCheck.setForeground(new java.awt.Color(0, 0, 0));
        baKiCheck.setText("3 K??");
        baKiCheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                baKiCheckMousePressed(evt);
            }
        });
        baKiCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baKiCheckActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("K?? ????ng k??:");

        motKiL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        motKiL.setForeground(new java.awt.Color(0, 0, 0));
        motKiL.setText("jLabel97");

        haiKiL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        haiKiL.setForeground(new java.awt.Color(0, 0, 0));
        haiKiL.setText("jLabel97");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(haiKiCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(haiKiL, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(motKiCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(motKiL, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(baKiCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 101, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(motKiCheck)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(motKiL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(haiKiCheck)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(haiKiL, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(baKiCheck)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cardIn1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 590, 470, 150));

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        searchRoom.setEditable(false);
        searchRoom.setBackground(new java.awt.Color(0, 204, 204));
        searchRoom.setForeground(new java.awt.Color(0, 0, 0));
        searchRoom.setBorder(null);
        searchRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchRoomActionPerformed(evt);
            }
        });
        searchRoom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchRoomKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(searchRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(searchRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cardIn1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 260, 270, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Ph??ng:");
        cardIn1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, 129, 33));

        jLabel23.setForeground(new java.awt.Color(255, 51, 51));
        jLabel23.setText("*Vui l??ng ch???n gi???i t??nh tr?????c");
        cardIn1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 750, 270, -1));

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));

        tongTien_Dky.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tongTien_Dky.setForeground(new java.awt.Color(255, 0, 51));
        tongTien_Dky.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("?????ng");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("T???ng ti???n thanh to??n:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tongTien_Dky, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tongTien_Dky, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        cardIn1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 740, 460, 40));

        jButton9.setBackground(new java.awt.Color(0, 255, 204));
        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton9.setText("Reset th??ng tin");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        cardIn1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 770, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("TH??NG TIN SINH VI??N");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        cardIn1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 320, 40));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("TH??NG TIN PH??NG");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        cardIn1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 30, -1, -1));

        cardRight.add(cardIn1, "card2");

        cardIn2.setBackground(new java.awt.Color(0, 204, 204));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        roomTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "T??n ph??ng", "SLT??", "SLHC", "Lo???i ph??ng", "Khu", "Gi?? ti???n", "Tr???ng th??i"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        roomTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomTable2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                roomTable2MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(roomTable2);

        allRoom.setBackground(new java.awt.Color(0, 204, 204));
        allRoom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        allRoom.setForeground(new java.awt.Color(0, 0, 0));
        allRoom.setText("T???t c??? ph??ng");
        allRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                allRoomMousePressed(evt);
            }
        });
        allRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allRoomActionPerformed(evt);
            }
        });

        roomTrong.setBackground(new java.awt.Color(0, 204, 204));
        roomTrong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        roomTrong.setForeground(new java.awt.Color(0, 0, 0));
        roomTrong.setText("Ph??ng tr???ng");
        roomTrong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                roomTrongMousePressed(evt);
            }
        });

        roomDay.setBackground(new java.awt.Color(0, 204, 204));
        roomDay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        roomDay.setForeground(new java.awt.Color(0, 0, 0));
        roomDay.setText("Ph??ng ???? ?????y");
        roomDay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                roomDayMousePressed(evt);
            }
        });

        zoneTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "T??n khu", "M?? t???", "Gi???i t??nh", "Tr???ng th??i"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(zoneTable);

        typeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "T??n lo???i ph??ng", "M?? t???", "Gi?? ti???n"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(typeTable);

        allZone.setBackground(new java.awt.Color(0, 204, 204));
        allZone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        allZone.setForeground(new java.awt.Color(0, 0, 0));
        allZone.setText("T???t c??? khu");
        allZone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                allZoneMousePressed(evt);
            }
        });
        allZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allZoneActionPerformed(evt);
            }
        });

        zoneTrong.setBackground(new java.awt.Color(0, 204, 204));
        zoneTrong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        zoneTrong.setForeground(new java.awt.Color(0, 0, 0));
        zoneTrong.setText("Khu c??n ph??ng");
        zoneTrong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                zoneTrongMousePressed(evt);
            }
        });
        zoneTrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoneTrongActionPerformed(evt);
            }
        });

        zoneDay.setBackground(new java.awt.Color(0, 204, 204));
        zoneDay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        zoneDay.setForeground(new java.awt.Color(0, 0, 0));
        zoneDay.setText("Khu h???t ph??ng");
        zoneDay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                zoneDayMousePressed(evt);
            }
        });
        zoneDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoneDayActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("T??m ki???m ph??ng theo khu:");

        zoneSearch.setBackground(new java.awt.Color(0, 204, 204));
        zoneSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zoneSearchMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                zoneSearchMousePressed(evt);
            }
        });
        zoneSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoneSearchActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_business_building_25px.png")); // NOI18N
        jLabel25.setText("Ph??ng");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_city_buildings_25px_1.png")); // NOI18N
        jLabel26.setText("Khu");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_sleeping_in_bed_25px.png")); // NOI18N
        jLabel27.setText("D???ch v???");

        javax.swing.GroupLayout cardIn2Layout = new javax.swing.GroupLayout(cardIn2);
        cardIn2.setLayout(cardIn2Layout);
        cardIn2Layout.setHorizontalGroup(
            cardIn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardIn2Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(cardIn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardIn2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(cardIn2Layout.createSequentialGroup()
                        .addComponent(allZone, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(cardIn2Layout.createSequentialGroup()
                        .addComponent(roomTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(240, 240, 240)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))
                    .addGroup(cardIn2Layout.createSequentialGroup()
                        .addGroup(cardIn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cardIn2Layout.createSequentialGroup()
                                .addGroup(cardIn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(roomDay, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(allRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(153, 153, 153)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(zoneSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(zoneDay, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cardIn2Layout.createSequentialGroup()
                                .addComponent(zoneTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(216, 216, 216)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        cardIn2Layout.setVerticalGroup(
            cardIn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardIn2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(cardIn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardIn2Layout.createSequentialGroup()
                        .addComponent(allRoom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roomTrong))
                    .addGroup(cardIn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(jLabel27)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardIn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roomDay)
                    .addGroup(cardIn2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(cardIn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zoneSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(cardIn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(allZone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardIn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardIn2Layout.createSequentialGroup()
                        .addComponent(zoneTrong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zoneDay)
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel26))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        cardRight.add(cardIn2, "card3");

        card3.setBackground(new java.awt.Color(0, 204, 204));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_info_40px.png")); // NOI18N
        jLabel28.setText("Th??ng tin sinh vi??n");

        studentTable.setBackground(new java.awt.Color(255, 255, 255));
        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "H??? v?? t??n", "M?? s??? sinh vi??n", "L???p", "Ng??nh", "Ph??ng ??ang ???"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                studentTableMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(studentTable);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("M?? s??? sinh vi??n:");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("H??? v?? t??n:");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("L???p:");

        mssvL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mssvL.setForeground(new java.awt.Color(255, 0, 0));

        tenT.setEditable(false);
        tenT.setBackground(new java.awt.Color(0, 204, 204));
        tenT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tenT.setForeground(new java.awt.Color(0, 0, 0));
        tenT.setBorder(null);

        lopT.setEditable(false);
        lopT.setBackground(new java.awt.Color(0, 204, 204));
        lopT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lopT.setForeground(new java.awt.Color(0, 0, 0));
        lopT.setBorder(null);

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Ng??nh:");

        nganhT.setEditable(false);
        nganhT.setBackground(new java.awt.Color(0, 204, 204));
        nganhT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nganhT.setForeground(new java.awt.Color(0, 0, 0));
        nganhT.setBorder(null);

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Ng??y sinh:");

        ngaySinhT.setEditable(false);
        ngaySinhT.setBackground(new java.awt.Color(0, 204, 204));
        ngaySinhT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ngaySinhT.setForeground(new java.awt.Color(0, 0, 0));
        ngaySinhT.setBorder(null);

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("S??? ??T:");

        sdtT.setEditable(false);
        sdtT.setBackground(new java.awt.Color(0, 204, 204));
        sdtT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sdtT.setForeground(new java.awt.Color(0, 0, 0));
        sdtT.setBorder(null);

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Email:");

        emailT.setEditable(false);
        emailT.setBackground(new java.awt.Color(0, 204, 204));
        emailT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailT.setForeground(new java.awt.Color(0, 0, 0));
        emailT.setBorder(null);

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("?????a ch???:");

        diaChiT.setEditable(false);
        diaChiT.setBackground(new java.awt.Color(0, 204, 204));
        diaChiT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        diaChiT.setForeground(new java.awt.Color(0, 0, 0));
        diaChiT.setBorder(null);

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Qu???c t???ch:");

        quocTichT.setEditable(false);
        quocTichT.setBackground(new java.awt.Color(0, 204, 204));
        quocTichT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quocTichT.setForeground(new java.awt.Color(0, 0, 0));
        quocTichT.setBorder(null);

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("D??n t???c:");

        danTocT.setEditable(false);
        danTocT.setBackground(new java.awt.Color(0, 204, 204));
        danTocT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        danTocT.setForeground(new java.awt.Color(0, 0, 0));
        danTocT.setBorder(null);

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("T??n gi??o:");

        tonGiaoT.setEditable(false);
        tonGiaoT.setBackground(new java.awt.Color(0, 204, 204));
        tonGiaoT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tonGiaoT.setForeground(new java.awt.Color(0, 0, 0));
        tonGiaoT.setBorder(null);

        chinhSuaSV.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_edit_15px.png")); // NOI18N
        chinhSuaSV.setText("Ch???nh s???a");
        chinhSuaSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chinhSuaSVMousePressed(evt);
            }
        });
        chinhSuaSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chinhSuaSVActionPerformed(evt);
            }
        });

        xacNhanSV.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_checked_15px.png")); // NOI18N
        xacNhanSV.setText("X??c nh???n");
        xacNhanSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xacNhanSVActionPerformed(evt);
            }
        });

        huySV.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_cancel_20px.png")); // NOI18N
        huySV.setText("H???y");
        huySV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huySVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout card3Layout = new javax.swing.GroupLayout(card3);
        card3.setLayout(card3Layout);
        card3Layout.setHorizontalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(card3Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card3Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(xacNhanSV, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(huySV, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28))
                                    .addComponent(jSeparator11)
                                    .addComponent(jSeparator10)
                                    .addComponent(jSeparator9)
                                    .addComponent(jSeparator8)
                                    .addComponent(jSeparator7)
                                    .addComponent(jSeparator6)
                                    .addComponent(jSeparator5)
                                    .addComponent(jSeparator4)
                                    .addComponent(jSeparator3)
                                    .addComponent(lopT)
                                    .addComponent(nganhT, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                                    .addComponent(ngaySinhT, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                                    .addComponent(sdtT, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                                    .addComponent(emailT, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                                    .addComponent(diaChiT, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                                    .addComponent(quocTichT, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                                    .addComponent(danTocT, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                                    .addComponent(tonGiaoT, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)))
                            .addGroup(card3Layout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(card3Layout.createSequentialGroup()
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mssvL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(tenT))))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card3Layout.createSequentialGroup()
                .addContainerGap(501, Short.MAX_VALUE)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card3Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(510, 510, 510))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card3Layout.createSequentialGroup()
                        .addComponent(chinhSuaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167))))
        );
        card3Layout.setVerticalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(card3Layout.createSequentialGroup()
                        .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(mssvL, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tenT)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lopT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addGap(1, 1, 1)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(nganhT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(ngaySinhT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(sdtT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailT))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(diaChiT))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(quocTichT))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(danTocT))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(tonGiaoT))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chinhSuaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(huySV, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xacNhanSV, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        cardRight.add(card3, "card4");

        card4.setBackground(new java.awt.Color(0, 204, 204));

        jPanel9.setBackground(new java.awt.Color(0, 204, 204));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("M?? h???p ?????ng:");
        jPanel9.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 100, 28));

        maHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        maHD.setForeground(new java.awt.Color(0, 0, 0));
        jPanel9.add(maHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 48, 40));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("H??? v?? t??n:");
        jPanel9.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 46, 100, 28));

        ten_HD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ten_HD.setForeground(new java.awt.Color(0, 0, 0));
        ten_HD.setText(" ");
        jPanel9.add(ten_HD, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 46, 201, -1));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("MSSV:");
        jPanel9.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 80, 100, 28));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("L???p:");
        jPanel9.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 114, 100, 28));

        lop_HD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lop_HD.setForeground(new java.awt.Color(0, 0, 0));
        lop_HD.setText(" ");
        jPanel9.add(lop_HD, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 114, 201, -1));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Ng??nh:");
        jPanel9.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 148, 100, 28));

        nganh_HD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nganh_HD.setForeground(new java.awt.Color(0, 0, 0));
        nganh_HD.setText(" ");
        jPanel9.add(nganh_HD, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 148, 201, -1));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Ph??ng ????ng k??:");
        jPanel9.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 182, -1, 28));

        phong_HD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phong_HD.setForeground(new java.awt.Color(0, 0, 0));
        phong_HD.setText(" ");
        jPanel9.add(phong_HD, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 182, 195, -1));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Ng??y b???t ?????u:");
        jPanel9.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 216, 100, 28));

        ngayBD_HD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ngayBD_HD.setForeground(new java.awt.Color(0, 0, 0));
        ngayBD_HD.setText(" ");
        jPanel9.add(ngayBD_HD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 195, -1));

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Ng??y k???t th??c:");
        jPanel9.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 250, 100, 28));

        ngayKT_HD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ngayKT_HD.setForeground(new java.awt.Color(0, 0, 0));
        jPanel9.add(ngayKT_HD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 195, 30));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 0, 0));
        jLabel57.setText("T???ng ti???n h???p ?????ng:");
        jPanel9.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(774, 338, 187, 28));

        tongTien_HD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tongTien_HD.setForeground(new java.awt.Color(255, 0, 0));
        tongTien_HD.setText("3500000");
        jPanel9.add(tongTien_HD, new org.netbeans.lib.awtextra.AbsoluteConstraints(967, 342, 95, -1));

        dong_CT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dong_CT.setForeground(new java.awt.Color(255, 0, 0));
        dong_CT.setText("?????ng");
        jPanel9.add(dong_CT, new org.netbeans.lib.awtextra.AbsoluteConstraints(1074, 342, 48, -1));

        giaHan.setText("Gia h???n");
        giaHan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                giaHanMouseClicked(evt);
            }
        });
        giaHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giaHanActionPerformed(evt);
            }
        });
        jPanel9.add(giaHan, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 186, 81, -1));

        chuyenPhong_HD.setText("Chuy???n ph??ng");
        chuyenPhong_HD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chuyenPhong_HDActionPerformed(evt);
            }
        });
        jPanel9.add(chuyenPhong_HD, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 186, -1, -1));

        mssv_HD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mssv_HD.setForeground(new java.awt.Color(0, 0, 0));
        mssv_HD.setText(" ");
        jPanel9.add(mssv_HD, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 80, 201, -1));

        giaHanPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 0));
        jLabel58.setText("Ng??y k???t th??c h???p ?????ng:");

        ngayKT_HD1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ngayKT_HD1.setForeground(new java.awt.Color(0, 0, 0));
        ngayKT_HD1.setText("2");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 0, 0));
        jLabel60.setText("Ch???n k?? gia h???n:");

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 0, 0));
        jLabel62.setText("T???ng ti???n thanh to??n:");

        tongTien_GH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tongTien_GH.setForeground(new java.awt.Color(0, 0, 0));
        tongTien_GH.setText("500000");

        dong2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dong2.setForeground(new java.awt.Color(0, 0, 0));
        dong2.setText("?????ng");

        xacNhan_GH.setText("X??c nh???n");
        xacNhan_GH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xacNhan_GHActionPerformed(evt);
            }
        });

        huy_GH.setText("H???y");
        huy_GH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huy_GHActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 0, 0));
        jLabel63.setText("Ng??y k???t th??c h???p ?????ng m???i:");
        jLabel63.setToolTipText("");

        ngayKT_HD2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ngayKT_HD2.setForeground(new java.awt.Color(0, 0, 0));
        ngayKT_HD2.setText(" ");

        kiGH_HD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kiGH_HDActionPerformed(evt);
            }
        });

        checkLB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        checkLB.setForeground(new java.awt.Color(0, 0, 0));
        checkLB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        checkLB.setText("GIA H???N H???P ?????NG");

        javax.swing.GroupLayout giaHanPanelLayout = new javax.swing.GroupLayout(giaHanPanel);
        giaHanPanel.setLayout(giaHanPanelLayout);
        giaHanPanelLayout.setHorizontalGroup(
            giaHanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(giaHanPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(giaHanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(giaHanPanelLayout.createSequentialGroup()
                        .addGroup(giaHanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(kiGH_HD, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, giaHanPanelLayout.createSequentialGroup()
                                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ngayKT_HD2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, giaHanPanelLayout.createSequentialGroup()
                        .addGroup(giaHanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator13, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, giaHanPanelLayout.createSequentialGroup()
                                .addGroup(giaHanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(giaHanPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tongTien_GH, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dong2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(94, 94, 94)
                                .addComponent(xacNhan_GH, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addComponent(huy_GH, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 16, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, giaHanPanelLayout.createSequentialGroup()
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ngayKT_HD1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(12, 12, 12))))
        );
        giaHanPanelLayout.setVerticalGroup(
            giaHanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(giaHanPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(checkLB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(giaHanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ngayKT_HD1))
                .addGap(18, 18, 18)
                .addGroup(giaHanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kiGH_HD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(giaHanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ngayKT_HD2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(giaHanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tongTien_GH)
                    .addComponent(dong2)
                    .addComponent(xacNhan_GH)
                    .addComponent(huy_GH))
                .addGap(15, 15, 15))
        );

        jPanel9.add(giaHanPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(683, 15, -1, -1));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 0, 0));
        jLabel56.setText("N???i dung h???p ?????ng:");
        jPanel9.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 46, 146, 28));

        noiDung_HD.setBackground(new java.awt.Color(0, 204, 204));
        noiDung_HD.setColumns(20);
        noiDung_HD.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        noiDung_HD.setForeground(new java.awt.Color(0, 0, 0));
        noiDung_HD.setRows(5);
        jScrollPane7.setViewportView(noiDung_HD);

        jPanel9.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 80, 245, -1));

        chuyenPhongPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 0, 0));
        jLabel61.setText("T??n ph??ng mu???n chuy???n:");

        phong_CP.setBackground(new java.awt.Color(255, 255, 255));
        phong_CP.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        phong_CP.setForeground(new java.awt.Color(0, 0, 0));
        phong_CP.setBorder(null);
        phong_CP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong_CPMousePressed(evt);
            }
        });
        phong_CP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phong_CPKeyReleased(evt);
            }
        });

        tien_CP.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tien_CP.setForeground(new java.awt.Color(255, 0, 0));
        tien_CP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tien_CP.setText(" ");

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 0, 0));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("CHUY???N PH??NG");

        tt_CP.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tt_CP.setForeground(new java.awt.Color(255, 0, 0));
        tt_CP.setText(" ");

        xacNhan_CP.setText("X??c nh???n");
        xacNhan_CP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                xacNhan_CPMousePressed(evt);
            }
        });
        xacNhan_CP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xacNhan_CPActionPerformed(evt);
            }
        });

        huy_CP.setText("H???y");
        huy_CP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huy_CPActionPerformed(evt);
            }
        });

        tien_CP1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tien_CP1.setForeground(new java.awt.Color(255, 0, 0));
        tien_CP1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tien_CP1.setText("?????ng");

        javax.swing.GroupLayout chuyenPhongPanelLayout = new javax.swing.GroupLayout(chuyenPhongPanel);
        chuyenPhongPanel.setLayout(chuyenPhongPanelLayout);
        chuyenPhongPanelLayout.setHorizontalGroup(
            chuyenPhongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chuyenPhongPanelLayout.createSequentialGroup()
                .addGroup(chuyenPhongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chuyenPhongPanelLayout.createSequentialGroup()
                        .addContainerGap(12, Short.MAX_VALUE)
                        .addComponent(tien_CP, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))
                    .addGroup(chuyenPhongPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(chuyenPhongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator15)
                            .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(chuyenPhongPanelLayout.createSequentialGroup()
                                .addGroup(chuyenPhongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tt_CP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(chuyenPhongPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel61)
                                        .addGap(10, 10, 10)
                                        .addGroup(chuyenPhongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(phong_CP, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chuyenPhongPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(tien_CP1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(chuyenPhongPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(xacNhan_CP, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(huy_CP, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addContainerGap())
        );
        chuyenPhongPanelLayout.setVerticalGroup(
            chuyenPhongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chuyenPhongPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel65)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chuyenPhongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(phong_CP, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tt_CP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chuyenPhongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tien_CP)
                    .addComponent(tien_CP1))
                .addGap(18, 18, 18)
                .addGroup(chuyenPhongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xacNhan_CP)
                    .addComponent(huy_CP))
                .addGap(13, 13, 13))
        );

        jPanel9.add(chuyenPhongPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 310, 200));

        contractTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "M?? H??", "MSSV", "Ng??y b???t ?????u", "Ng??y k???t th??c", "Ph??ng ????ng k??", "T???ng ti???n"
            }
        ));
        contractTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                contractTableMousePressed(evt);
            }
        });
        jScrollPane6.setViewportView(contractTable);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel96.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 0, 0));
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("H???p ?????ng");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout card4Layout = new javax.swing.GroupLayout(card4);
        card4.setLayout(card4Layout);
        card4Layout.setHorizontalGroup(
            card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1348, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1348, Short.MAX_VALUE)
            .addGroup(card4Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        card4Layout.setVerticalGroup(
            card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );

        cardRight.add(card4, "card5");

        card5.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));

        roomTable_HDDN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "T??n ph??ng", "SLT??", "SLHC", "Lo???i ph??ng", "Khu", "Gi?? ti???n", "Tr???ng th??i"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        roomTable_HDDN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomTable_HDDNMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                roomTable_HDDNMousePressed(evt);
            }
        });
        jScrollPane8.setViewportView(roomTable_HDDN);

        jPanel10.setBackground(new java.awt.Color(0, 204, 204));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("L???p H??a ????n Ti???n ??i???n");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Ph??ng:");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Th??ng ch???t:");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Ch??? s??? ??i???n c?? (KWh):");

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Ch??? s??? ??i???n m???i (KWh):");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("S??? ??i???n s??? d???ng:");

        headIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                headIndexKeyReleased(evt);
            }
        });

        lastIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lastIndexKeyReleased(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("B???c thang 1 (1678 VN??/KWh):");

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("B???c thang 2 (1734 VN??/KWh):");

        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("B???c thang 3 (2014 VN??/KWh):");

        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("B???c thang 4 (2536 VN??/KWh):");

        jLabel68.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("B???c thang 5 (2834 VN??/KWh):");

        jLabel69.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("B???c thang 6 (2937 VN??/KWh):");

        jLabel70.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("T???ng ti???n (Ch??a VAT):");

        jLabel71.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("10% VAT:");

        jLabel72.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("T???ng ti???n:");

        bac1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bac1.setForeground(new java.awt.Color(0, 0, 0));
        bac1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bac1.setText(" ");

        bac2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bac2.setForeground(new java.awt.Color(0, 0, 0));
        bac2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bac2.setText(" ");

        bac3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bac3.setForeground(new java.awt.Color(0, 0, 0));
        bac3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bac3.setText(" ");

        bac4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bac4.setForeground(new java.awt.Color(0, 0, 0));
        bac4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bac4.setText(" ");

        bac5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bac5.setForeground(new java.awt.Color(0, 0, 0));
        bac5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bac5.setText(" ");

        bac6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bac6.setForeground(new java.awt.Color(0, 0, 0));
        bac6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bac6.setText(" ");

        tongTien_chuaVAT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tongTien_chuaVAT.setForeground(new java.awt.Color(0, 0, 0));
        tongTien_chuaVAT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tongTien_chuaVAT.setText(" ");

        VAT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VAT.setForeground(new java.awt.Color(0, 0, 0));
        VAT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        VAT.setText(" ");

        tongtien_VAT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tongtien_VAT.setForeground(new java.awt.Color(255, 0, 0));
        tongtien_VAT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tongtien_VAT.setText(" ");

        useE.setEditable(false);
        useE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useEActionPerformed(evt);
            }
        });
        useE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                useEKeyReleased(evt);
            }
        });

        canhbao_HDDN.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        canhbao_HDDN.setForeground(new java.awt.Color(255, 51, 0));
        canhbao_HDDN.setText("Vui l??ng nh???p ????ng ch??? s??? ??i???n");

        phong_HDDN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phong_HDDN.setForeground(new java.awt.Color(0, 0, 0));
        phong_HDDN.setText(" ");

        thangChot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                thangChotKeyReleased(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("N??m:");

        namChot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                namChotKeyReleased(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Ng??y ch???t ch??? s???:");

        ngayChot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ngayChot.setForeground(new java.awt.Color(0, 0, 0));
        ngayChot.setText(" ");

        xacNhan_HDDN.setText("X??c Nh???n");
        xacNhan_HDDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xacNhan_HDDNActionPerformed(evt);
            }
        });

        d2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        d2.setForeground(new java.awt.Color(0, 0, 0));
        d2.setText("??");

        d3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        d3.setForeground(new java.awt.Color(255, 0, 0));
        d3.setText("??");

        d1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        d1.setForeground(new java.awt.Color(0, 0, 0));
        d1.setText("??");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator16, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bac2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bac1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bac3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bac4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bac5, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bac6, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tongTien_chuaVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tongtien_VAT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(VAT, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(d3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(headIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(phong_HDDN, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(useE, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel74)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(thangChot, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(ngayChot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(77, 77, 77)))
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(canhbao_HDDN, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(namChot, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(xacNhan_HDDN, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(phong_HDDN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thangChot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namChot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(canhbao_HDDN)
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(ngayChot, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(9, 9, 9)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(headIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(useE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bac1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bac2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bac3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bac4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bac5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bac6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tongTien_chuaVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VAT, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tongtien_VAT, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xacNhan_HDDN)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(0, 204, 204));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Th???ng K?? H??a ????n Ti???n ??i???n");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("Ph??ng:");

        phong_HDDN1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phong_HDDN1.setForeground(new java.awt.Color(0, 0, 0));
        phong_HDDN1.setText(" ");

        HDDN_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Th??ng", "N??m", "Ch??? s??? ?????u", "Ch??? s??? cu???i", "S??? d???ng", "T???ng ti???n", "Tr???ng th??i"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        HDDN_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HDDN_TableMousePressed(evt);
            }
        });
        jScrollPane9.setViewportView(HDDN_Table);

        thanhToanHD_Panel.setBackground(new java.awt.Color(0, 204, 204));

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("T???ng ti???n:");

        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 0, 0));
        jLabel78.setText("?????ng");

        thanhToan_HDDN.setText("Thanh To??n");
        thanhToan_HDDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thanhToan_HDDNActionPerformed(evt);
            }
        });

        tongTien_HDDN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tongTien_HDDN.setForeground(new java.awt.Color(255, 0, 51));
        tongTien_HDDN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tongTien_HDDN.setText(" ");

        javax.swing.GroupLayout thanhToanHD_PanelLayout = new javax.swing.GroupLayout(thanhToanHD_Panel);
        thanhToanHD_Panel.setLayout(thanhToanHD_PanelLayout);
        thanhToanHD_PanelLayout.setHorizontalGroup(
            thanhToanHD_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thanhToanHD_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tongTien_HDDN, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thanhToanHD_PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(thanhToan_HDDN, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        thanhToanHD_PanelLayout.setVerticalGroup(
            thanhToanHD_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thanhToanHD_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(thanhToanHD_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(jLabel78)
                    .addComponent(tongTien_HDDN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(thanhToan_HDDN)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 334, Short.MAX_VALUE))
            .addComponent(jScrollPane9)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phong_HDDN1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(thanhToanHD_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(phong_HDDN1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thanhToanHD_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout card5Layout = new javax.swing.GroupLayout(card5);
        card5.setLayout(card5Layout);
        card5Layout.setHorizontalGroup(
            card5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card5Layout.createSequentialGroup()
                .addComponent(jScrollPane8)
                .addContainerGap())
            .addGroup(card5Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        card5Layout.setVerticalGroup(
            card5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card5Layout.createSequentialGroup()
                .addGroup(card5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );

        cardRight.add(card5, "card6");

        card6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(0, 204, 204));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel77.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 0, 0));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("Y??u C???u");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        request_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "MSSV", "Ph??ng", "Ng??y g???i", "N???i dung", "Tr???ng th??i"
            }
        ));
        request_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                request_TableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                request_TableMousePressed(evt);
            }
        });
        jScrollPane10.setViewportView(request_Table);

        panel_StatusRe.setBackground(new java.awt.Color(0, 204, 204));
        panel_StatusRe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton10.setText("C???p nh???t");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        panel_StatusRe.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 100, -1));

        s_check4.setBackground(new java.awt.Color(0, 204, 204));
        s_check4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        s_check4.setForeground(new java.awt.Color(0, 0, 0));
        s_check4.setText("Kh??c");
        s_check4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                s_check4MousePressed(evt);
            }
        });
        s_check4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_check4ActionPerformed(evt);
            }
        });
        panel_StatusRe.add(s_check4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 150, 30));

        s_check1.setBackground(new java.awt.Color(0, 204, 204));
        s_check1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        s_check1.setForeground(new java.awt.Color(0, 0, 0));
        s_check1.setText("???? xem y??u c???u");
        s_check1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                s_check1MousePressed(evt);
            }
        });
        s_check1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_check1ActionPerformed(evt);
            }
        });
        panel_StatusRe.add(s_check1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 150, 30));

        s_check2.setBackground(new java.awt.Color(0, 204, 204));
        s_check2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        s_check2.setForeground(new java.awt.Color(0, 0, 0));
        s_check2.setText("??ang gi???i quy???t");
        s_check2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                s_check2MousePressed(evt);
            }
        });
        s_check2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_check2ActionPerformed(evt);
            }
        });
        panel_StatusRe.add(s_check2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 150, 30));

        s_check3.setBackground(new java.awt.Color(0, 204, 204));
        s_check3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        s_check3.setForeground(new java.awt.Color(0, 0, 0));
        s_check3.setText("???? gi???i quy???t");
        s_check3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                s_check3MousePressed(evt);
            }
        });
        s_check3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_check3ActionPerformed(evt);
            }
        });
        panel_StatusRe.add(s_check3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 150, 30));

        s_text.setBackground(new java.awt.Color(0, 204, 204));
        s_text.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        s_text.setBorder(null);
        s_text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                s_textMousePressed(evt);
            }
        });
        panel_StatusRe.add(s_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 180, 20));
        panel_StatusRe.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 180, 10));

        confirm_s.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_checked_15px.png")); // NOI18N
        confirm_s.setText("X??c nh???n");
        confirm_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_sActionPerformed(evt);
            }
        });
        panel_StatusRe.add(confirm_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 100, 30));

        cancel_s.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_cancel_20px.png")); // NOI18N
        cancel_s.setText("H???y");
        cancel_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_sActionPerformed(evt);
            }
        });
        panel_StatusRe.add(cancel_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 100, 30));

        status_L.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        status_L.setForeground(new java.awt.Color(0, 0, 0));
        status_L.setText("Tr???ng th??i:");
        panel_StatusRe.add(status_L, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        panel_HDRe.setBackground(new java.awt.Color(255, 255, 255));

        ngayChi_HDR.setBackground(new java.awt.Color(255, 255, 255));
        ngayChi_HDR.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ngayChi_HDR.setForeground(new java.awt.Color(0, 0, 0));
        ngayChi_HDR.setBorder(null);

        status_L1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        status_L1.setForeground(new java.awt.Color(0, 0, 0));
        status_L1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status_L1.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_pay_date_15px.png")); // NOI18N
        status_L1.setText("Ng??y chi:");

        status_L2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        status_L2.setForeground(new java.awt.Color(0, 0, 0));
        status_L2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status_L2.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_content_15px.png")); // NOI18N
        status_L2.setText("N???i dung chi:");

        noiDungChi_HDR.setBackground(new java.awt.Color(255, 255, 255));
        noiDungChi_HDR.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        noiDungChi_HDR.setForeground(new java.awt.Color(0, 0, 0));
        noiDungChi_HDR.setBorder(null);

        status_L3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        status_L3.setForeground(new java.awt.Color(0, 0, 0));
        status_L3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status_L3.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_money_15px_1.png")); // NOI18N
        status_L3.setText("T???ng ti???n chi:");

        tienChi_HDR.setBackground(new java.awt.Color(255, 255, 255));
        tienChi_HDR.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tienChi_HDR.setForeground(new java.awt.Color(0, 0, 0));
        tienChi_HDR.setBorder(null);

        createHDRe.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_create_15px.png")); // NOI18N
        createHDRe.setText("L???p h??a ????n");
        createHDRe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createHDReActionPerformed(evt);
            }
        });

        cancel_HDR.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_cancel_20px.png")); // NOI18N
        cancel_HDR.setText("H???y");
        cancel_HDR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_HDRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_HDReLayout = new javax.swing.GroupLayout(panel_HDRe);
        panel_HDRe.setLayout(panel_HDReLayout);
        panel_HDReLayout.setHorizontalGroup(
            panel_HDReLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_HDReLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_HDReLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ngayChi_HDR)
                    .addComponent(jSeparator18)
                    .addComponent(noiDungChi_HDR)
                    .addComponent(jSeparator19)
                    .addComponent(tienChi_HDR)
                    .addComponent(jSeparator20)
                    .addGroup(panel_HDReLayout.createSequentialGroup()
                        .addGroup(panel_HDReLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(status_L1)
                            .addComponent(status_L2)
                            .addComponent(status_L3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panel_HDReLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(createHDRe, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(cancel_HDR, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_HDReLayout.setVerticalGroup(
            panel_HDReLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_HDReLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(status_L1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ngayChi_HDR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(status_L2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noiDungChi_HDR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(status_L3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tienChi_HDR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_HDReLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createHDRe)
                    .addComponent(cancel_HDR))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel_StatusRe, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_HDRe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_StatusRe, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_HDRe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(508, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(0, 204, 204));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 0, 0));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText(" Ph???n H???i - ????nh Gi??");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel13.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 16, -1, -1));

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idsv_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idsv_1.setForeground(new java.awt.Color(0, 0, 0));
        idsv_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idsv_1.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_user_20px.png")); // NOI18N
        idsv_1.setText(" ");
        panel1.add(idsv_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 16, 125, 30));

        date_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        date_1.setForeground(new java.awt.Color(0, 0, 0));
        date_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date_1.setText(" ");
        panel1.add(date_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 16, 96, 30));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        one1.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        one1.setText(" ");

        two1.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        two1.setText(" ");

        three1.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        three1.setText(" ");

        four1.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        four1.setText(" ");

        five1.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        five1.setText(" ");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(one1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(two1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(three1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(four1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(five1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(one1)
                    .addComponent(two1)
                    .addComponent(three1)
                    .addComponent(four1)
                    .addComponent(five1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel1.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 52, -1, -1));

        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 0, 0));
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel87.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_checked_checkbox_20px.png")); // NOI18N
        jLabel87.setText("Vote for Ptit's Dorm");
        panel1.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 54, 160, 30));

        jLabel88.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(0, 0, 0));
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel88.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_checked_checkbox_20px.png")); // NOI18N
        jLabel88.setText("Vote for service");
        panel1.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 92, 160, 30));

        jLabel94.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 0, 0));
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel94.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_checked_checkbox_20px.png")); // NOI18N
        jLabel94.setText("Vote for service");
        panel1.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 130, 160, 30));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        one2.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        one2.setText(" ");

        two2.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        two2.setText(" ");

        three2.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        three2.setText(" ");

        four2.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        four2.setText(" ");

        five2.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        five2.setText(" ");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(one2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(two2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(three2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(four2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(five2))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(one2)
                    .addComponent(two2)
                    .addComponent(three2)
                    .addComponent(four2)
                    .addComponent(five2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel1.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 90, -1, -1));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        one3.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        one3.setText(" ");

        two3.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        two3.setText(" ");

        three3.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        three3.setText(" ");

        four3.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        four3.setText(" ");

        five3.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        five3.setText(" ");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(one3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(two3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(three3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(four3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(five3))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(one3)
                    .addComponent(two3)
                    .addComponent(three3)
                    .addComponent(four3)
                    .addComponent(five3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel1.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 128, -1, -1));

        content_1.setBackground(new java.awt.Color(255, 255, 255));
        content_1.setColumns(20);
        content_1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        content_1.setRows(5);
        jScrollPane11.setViewportView(content_1);

        panel1.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 204, 361, -1));

        jLabel105.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(0, 0, 0));
        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel105.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_comments_20px.png")); // NOI18N
        jLabel105.setText("N???i dung ph???n h???i");
        panel1.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 178, 160, -1));

        jPanel13.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 73, 647, 310));

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idsv_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idsv_2.setForeground(new java.awt.Color(0, 0, 0));
        idsv_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idsv_2.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_user_20px.png")); // NOI18N
        idsv_2.setText("N19DCPT064");
        panel2.add(idsv_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 16, 125, 30));

        date_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        date_2.setForeground(new java.awt.Color(0, 0, 0));
        date_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date_2.setText("03/09/2021");
        panel2.add(date_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 16, 96, 30));

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        one4.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        one4.setText(" ");

        two4.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        two4.setText(" ");

        three4.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        three4.setText(" ");

        four4.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        four4.setText(" ");

        five4.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        five4.setText(" ");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(one4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(two4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(three4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(four4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(five4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(one4)
                    .addComponent(two4)
                    .addComponent(three4)
                    .addComponent(four4)
                    .addComponent(five4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel2.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 52, -1, -1));

        jLabel113.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(0, 0, 0));
        jLabel113.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel113.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_checked_checkbox_20px.png")); // NOI18N
        jLabel113.setText("Vote for Ptit's Dorm");
        panel2.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 54, 160, 30));

        jLabel114.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(0, 0, 0));
        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel114.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_checked_checkbox_20px.png")); // NOI18N
        jLabel114.setText("Vote for service");
        panel2.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 92, 160, 30));

        jLabel115.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(0, 0, 0));
        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel115.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_checked_checkbox_20px.png")); // NOI18N
        jLabel115.setText("Vote for service");
        panel2.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 136, 160, 30));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        one5.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        one5.setText(" ");

        two5.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        two5.setText(" ");

        three5.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        three5.setText(" ");

        four5.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        four5.setText(" ");

        five5.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        five5.setText(" ");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(one5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(two5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(three5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(four5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(five5))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(one5)
                    .addComponent(two5)
                    .addComponent(three5)
                    .addComponent(four5)
                    .addComponent(five5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel2.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 90, -1, -1));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));

        one6.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        one6.setText(" ");

        two6.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        two6.setText(" ");

        three6.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        three6.setText(" ");

        four6.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        four6.setText(" ");

        five6.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_star_20px.png")); // NOI18N
        five6.setText(" ");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(one6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(two6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(three6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(four6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(five6))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(one6)
                    .addComponent(two6)
                    .addComponent(three6)
                    .addComponent(four6)
                    .addComponent(five6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel2.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 134, -1, -1));

        content_2.setBackground(new java.awt.Color(255, 255, 255));
        content_2.setColumns(20);
        content_2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        content_2.setRows(5);
        jScrollPane12.setViewportView(content_2);

        panel2.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 198, 361, -1));

        jLabel126.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(0, 0, 0));
        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel126.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_comments_20px.png")); // NOI18N
        jLabel126.setText("N???i dung ph???n h???i");
        panel2.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 172, 160, -1));

        jPanel13.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 650, 310));

        backF.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        backF.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_back_to_20px.png")); // NOI18N
        backF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backFMousePressed(evt);
            }
        });
        jPanel13.add(backF, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 729, 34, -1));

        nexttF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nexttF.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_next_page_20px.png")); // NOI18N
        nexttF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nexttFMousePressed(evt);
            }
        });
        jPanel13.add(nexttF, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 729, -1, -1));

        pageF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pageF.setForeground(new java.awt.Color(0, 0, 0));
        pageF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pageF.setText("1/1");
        jPanel13.add(pageF, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 719, 96, 30));

        javax.swing.GroupLayout card6Layout = new javax.swing.GroupLayout(card6);
        card6.setLayout(card6Layout);
        card6Layout.setHorizontalGroup(
            card6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        card6Layout.setVerticalGroup(
            card6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        cardRight.add(card6, "card7");

        jPanel23.setBackground(new java.awt.Color(0, 204, 204));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setPreferredSize(new java.awt.Dimension(256, 29));

        jLabel97.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(0, 0, 0));
        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setText("Th???ng K??");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel97, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel97, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        chart1.setLayout(new javax.swing.BoxLayout(chart1, javax.swing.BoxLayout.LINE_AXIS));

        chart3.setLayout(new javax.swing.BoxLayout(chart3, javax.swing.BoxLayout.LINE_AXIS));

        jLabel98.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setText("Ch???n khu:");

        zoneCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoneComboActionPerformed(evt);
            }
        });

        chart2.setLayout(new javax.swing.BoxLayout(chart2, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zoneCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(chart2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(chart3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel98)
                            .addComponent(zoneCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chart3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(337, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout card7Layout = new javax.swing.GroupLayout(card7);
        card7.setLayout(card7Layout);
        card7Layout.setHorizontalGroup(
            card7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        card7Layout.setVerticalGroup(
            card7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card7Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        cardRight.add(card7, "card9");

        card8.setBackground(new java.awt.Color(0, 204, 204));

        jPanel28.setBackground(new java.awt.Color(0, 204, 204));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setPreferredSize(new java.awt.Dimension(256, 29));

        jLabel99.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(0, 0, 0));
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("Th???ng K?? Doanh Thu");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel99, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel99, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        jPanel28.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 29, -1, -1));

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setLayout(new java.awt.BorderLayout());
        jPanel28.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 454, 1342, 406));

        jLabel100.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setText("Lo???i th???i gian");
        jPanel28.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 103, 130, -1));

        label1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText(" Ng??y b???t ?????u");
        jPanel28.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 147, 130, -1));

        ky_TK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HK1", "HK2", "HK3", "C??? N??m" }));
        ky_TK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ky_TKActionPerformed(evt);
            }
        });
        jPanel28.add(ky_TK, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 145, 241, -1));

        label2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("Ng??y k???t th??c");
        jPanel28.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 147, 103, -1));

        namHoc_TK.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        namHoc_TK.setForeground(new java.awt.Color(0, 0, 0));
        namHoc_TK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                namHoc_TKKeyReleased(evt);
            }
        });
        jPanel28.add(namHoc_TK, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 146, 260, -1));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel104.setIcon(new javax.swing.ImageIcon("D:\\imagesProject\\icons8_euro_25px.png")); // NOI18N

        doanhThu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        doanhThu.setForeground(new java.awt.Color(0, 0, 0));
        doanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        doanhThu.setText("0");

        jLabel107.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(0, 0, 0));
        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel107.setText("T???ng Doanh Thu");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(doanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 23, Short.MAX_VALUE))))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel104, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(doanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel107)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        jPanel28.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, -1, -1));

        loaiCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B??o c??o theo ng??y", "B??o c??o theo th??ng", "B??o c??o theo h???c k???" }));
        loaiCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loaiComboActionPerformed(evt);
            }
        });
        jPanel28.add(loaiCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 101, 241, -1));

        ngayBD_TK.setDateFormatString("dd/MM/yyy");
        jPanel28.add(ngayBD_TK, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 240, -1));

        ngayKT_TK.setDateFormatString("dd/MM/yyyy");
        jPanel28.add(ngayKT_TK, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 260, -1));

        thongke.setText("Th???ng K??");
        thongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thongkeActionPerformed(evt);
            }
        });
        jPanel28.add(thongke, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 90, -1));

        javax.swing.GroupLayout card8Layout = new javax.swing.GroupLayout(card8);
        card8.setLayout(card8Layout);
        card8Layout.setHorizontalGroup(
            card8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        card8Layout.setVerticalGroup(
            card8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card8Layout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 114, Short.MAX_VALUE))
        );

        cardRight.add(card8, "card10");

        jSplitPane1.setRightComponent(cardRight);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 976, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namCheckMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_namCheckMousePressed
        // TODO add your handling code here:
        nuCheck.setSelected(false);
        jLabel23.setVisible(false);
        zoneComboBox.removeAllItems();
        listZone=new DAO().getListZone1(1);
        for(int i=0;i<listZone.size();i++)
        {
            zoneComboBox.addItem(listZone.get(i).getNameZone());
        }
        if(namCheck.isSelected()){
            zoneComboBox.removeAllItems();
        }
         removeTable(model);
         showTable3(1,model);
    }//GEN-LAST:event_namCheckMousePressed

    private void nuCheckMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuCheckMousePressed
        // TODO add your handling code here:\
         namCheck.setSelected(false);
         jLabel23.setVisible(false);
         zoneComboBox.removeAllItems();
         listZone=new DAO().getListZone1(2);
         for(int i=0;i<listZone.size();i++)
         {
             zoneComboBox.addItem(listZone.get(i).getNameZone());
         }
          if(nuCheck.isSelected()){
              zoneComboBox.removeAllItems();
          }
          removeTable(model);
          showTable3(2,model);
    }//GEN-LAST:event_nuCheckMousePressed

    private void namCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namCheckActionPerformed

    private void zoneComboBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zoneComboBoxMousePressed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_zoneComboBoxMousePressed

    private void typeRoomComboBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_typeRoomComboBoxMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_typeRoomComboBoxMousePressed

    private void zoneComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoneComboBoxActionPerformed
        // TODO add your handling code here:
        String zone=(String)zoneComboBox.getSelectedItem();
        String typeValue=(String)typeRoomComboBox.getSelectedItem();
        int sex=0,type;
        if(namCheck.isSelected()) sex=1;
        else if(nuCheck.isSelected()) sex=2;
        if(typeValue.equals("D???ch v??? lo???i 1 - 430k/1 th??ng")) type=1;
        else if(typeValue.equals("D???ch v??? lo???i 2 - 330k/1 th??ng")) type =2;
        else type=3;
        setData(sex, zone, type);
        //showTable2();
    }//GEN-LAST:event_zoneComboBoxActionPerformed

    private void typeRoomComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeRoomComboBoxActionPerformed
        // TODO add your handling code here:
         String zone=(String)zoneComboBox.getSelectedItem();
        String typeValue=(String)typeRoomComboBox.getSelectedItem();
        int sex=0,type;
        if(namCheck.isSelected()) sex=1;
        else if(nuCheck.isSelected()) sex=2;
        if(typeValue.equals("D???ch v??? lo???i 1 - 430k/1 th??ng")) type=1;
        else if(typeValue.equals("D???ch v??? lo???i 2 - 330k/1 th??ng")) type =2;
        else type=3;
        setData(sex, zone, type);
    }//GEN-LAST:event_typeRoomComboBoxActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Student s=new Student();
        Contract c=new Contract();
        User u=new User();
        Bill b=new Bill();
         if(hoTen.getText().equals("")||mssv.getText().equals("")||lop.getText().equals("")
                 ||cmnd.getText().equals("")||danToc.getText().equals("")
                 ||tonGiao.getText().equals("")||quocTich.getText().equals("")||diaChi.getText().equals("")||email.getText().equals("")
                 ||sdt.getText().equals("")||ngaySinh.getDate()==null||nganh.getText().equals("")
                 )
         {
             JOptionPane.showMessageDialog(rootPane, "C??n th??ng tin ch??a ???????c nh???p! Vui l??ng ki???m tra l???i");
         }
         else{
             if(zoneComboBox.getSelectedIndex()<0) JOptionPane.showMessageDialog(rootPane, "Vui l??ng ch???n khu mu???n ????ng k??");
             else{
                 if(roomComboBox.getSelectedIndex()<0){
                     JOptionPane.showMessageDialog(rootPane, "Vui l??ng ch???n ph??ng mu???n ????ng k??");
                 }
                 else{
                     if(!(motKiCheck.isSelected()||haiKiCheck.isSelected()||baKiCheck.isSelected()))
                          JOptionPane.showMessageDialog(rootPane, "Vui l??ng ch???n th???i gian mu???n ????ng k??");
                     else{
                         if(checkThongTin()){
                             int x= JOptionPane.showConfirmDialog(rootPane, "X??c nh???n ????ng k?? ph??ng ?");
                             if(x==JOptionPane.YES_OPTION){
                                 if(addUser(u)){
                                     if(addStudent(s)){
                                         if(addContract(c)){
                                             if(addBill(b)){
                                                 new DAO().UpdateAmountInRoom((String)roomComboBox.getSelectedItem());
                                                 new DAO().UpdatStatusRoom((String)roomComboBox.getSelectedItem());
                                                 JOptionPane.showMessageDialog(rootPane, "????ng k?? th??nh c??ng");
                                             }
                                             else{
                                                 new DAO().deleteBill(mssv.getText().toUpperCase());
                                                 JOptionPane.showMessageDialog(rootPane, "T???o h??a ????n l???i");
                                             }
                                         }else{
                                             new DAO().deleteContract(mssv.getText().toUpperCase());
                                             JOptionPane.showMessageDialog(rootPane, "T???o h???p ?????ng l???i");
                                         }
                                     }else{
                                         new DAO().deleteStudent(mssv.getText().toUpperCase());
                                         JOptionPane.showMessageDialog(rootPane, "T???o th??ng tin sinh vi??n l???i");
                                     }
                                 }else {
                                     new DAO().deleteUser(mssv.getText().toUpperCase());
                                     JOptionPane.showMessageDialog(rootPane, "T???o t??i kho???n l???i");
                                 }
                         }
                         }
                          else JOptionPane.showMessageDialog(rootPane, "Vui l??ng ki???m tra l???i th??ng tin ???? nh???p");
                     }
                 }
             }
         }
    }//GEN-LAST:event_jButton7ActionPerformed
void resetTT(){
    hoTen.setText("");
    mssv.setText("");
    lop.setText("");
    cmnd.setText("");
    ngaySinh.setDate(null);
    sdt.setText("");
    email.setText("");
    diaChi.setText("");
    quocTich.setText("");
    tonGiao.setText("");
    danToc.setText("");
    nganh.setText("");
    namCheck.setSelected(false);
    nuCheck.setSelected(false);
    zoneComboBox.setSelectedIndex(-1);
    roomComboBox.setSelectedIndex(-1);
    motKiCheck.setSelected(false);
    haiKiCheck.setSelected(false);
    baKiCheck.setSelected(false);
    motKiL.setVisible(false);
    haiKiL.setVisible(false);
}
    boolean addStudent(Student s){
    s.setHoTen(chuanHoa(hoTen.getText()));
    s.setMssv(mssv.getText().toUpperCase());
    s.setLop(lop.getText().toUpperCase());
    s.setAddress(diaChi.getText());
    s.setCmnd(cmnd.getText());
    s.setDateOfBirth(ngaySinh.getDate());
    if(namCheck.isSelected()){
        s.setGioiTinh("Male");
    }
    else if(nuCheck.isSelected()){
        s.setGioiTinh("Female");
    }
    s.setSdt(sdt.getText());
    s.setEmail(email.getText().toLowerCase());
    s.setDanToc(danToc.getText());
    s.setTonGiao(tonGiao.getText());
    s.setNganh(nganh.getText());
    s.setIDUs(mssv.getText().toUpperCase());
    s.setQuocTich(quocTich.getText());
    if(new DAO().addStudent(s)) return true;
    else return false;
}
boolean addUser(User u){
    SimpleDateFormat df1=new SimpleDateFormat("ddMMyyyy");
    u.setIDUs(mssv.getText().toUpperCase());
    u.setPass(df1.format(ngaySinh.getDate()));
    u.setIDRole(1);
    u.setStatus("??ang ho???t ?????ng");
    if(new DAO().addUser(u)) return true;
    else return false;
}
boolean addContract(Contract c){
    ArrayList<Contract>list=new DAO().getListContract();
    int size=list.size();
    c.setIDContract(++size);
    c.setIDStudent(mssv.getText().toUpperCase());
    c.setIDStaff(new DangNhap().IDUs);
    c.setIDRoom((String)roomComboBox.getSelectedItem());
    Date d=new Date();
    c.setStartDay(d);
    Date date=new Date();
     int year=year(date);
     String tgDky=kiDangKy;
     if(tgDky.equalsIgnoreCase("HK1")){
         c.setFinishDay(setDate(d, "31-12-2021"));
         c.setAmountOfMonth(5);
     }
     else if(tgDky.equalsIgnoreCase("HK1-2")){
         c.setFinishDay(setDate(d, "31-05-"+String.valueOf(year+1)));
         c.setAmountOfMonth(10);
     }
     else if(tgDky.equalsIgnoreCase("HK2")){
         c.setFinishDay(setDate(d, "31-05-"+String.valueOf(year+1)));
         c.setAmountOfMonth(5);
     }
     else if(tgDky.equalsIgnoreCase("HK3")){
         c.setFinishDay(setDate(d, "31-07-"+String.valueOf(year+1)));
         c.setAmountOfMonth(2);
     }else if(tgDky.equalsIgnoreCase("HK2-3")){
         c.setFinishDay(setDate(d, "31-07-"+String.valueOf(year+1)));
         c.setAmountOfMonth(7);
     }else if(tgDky.equalsIgnoreCase("C??? n??m")){
         c.setFinishDay(setDate(d, "31-07-"+String.valueOf(year+1)));
         c.setAmountOfMonth(12);
     }
    c.setPayment(tienToInt(tongTien_Dky.getText()));
    if(new DAO().addContract(c)) return true;
    else return false;
}
public Date setDate(Date date,String setDate){
  SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
        try {
            date=df.parse(setDate);
        } catch (Exception e) {
        }
  return date;
    }
boolean addBill(Bill b){
    ArrayList<Bill>list=new DAO().getListBillAll();
    int x=list.size();
    b.setIDBill(++x);
    b.setIDStaff(new DangNhap().IDUs);
    b.setStatus("???? thanh to??n");
    Date d=new Date();
    b.setDateCreate(d);
    b.setIDStudent(mssv.getText().toUpperCase());
    Date ngayBD=new DAO().startDate(mssv.getText().toUpperCase());
    Date ngayKT=new DAO().finishDate(mssv.getText().toUpperCase());
    b.setNoiDung("Ti???n ??? ktx t??? "+df.format(ngayBD)+" ?????n "+df.format(ngayKT));
    b.setTypeBill("Thu?? ph??ng");
    b.setSemester(kiDangKy);
    b.setPayment(tienToInt(tongTien_Dky.getText()));
    if(new DAO().addBill(b)) return true;
    else return false;
}
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
       namCheck.setSelected(false);
       nuCheck.setSelected(false);
       zoneComboBox.removeAllItems();
       roomComboBox.removeAllItems();
       removeTable(model);
       showTable(model);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void roomTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomTable1MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_roomTable1MouseClicked

    private void roomTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomTable1MousePressed
        // TODO add your handling code here:
        String room=(String) roomTable1.getValueAt(roomTable1.getSelectedRow(), 1);
        String type=(String) roomTable1.getValueAt(roomTable1.getSelectedRow(), 4);
        String zone=(String) roomTable1.getValueAt(roomTable1.getSelectedRow(), 5);
        if(namCheck.isSelected()||nuCheck.isSelected()){
             jLabel23.setVisible(false);
            if(type.equals("d???ch v??? lo???i 1")) typeRoomComboBox.setSelectedIndex(0);
            else if(type.equals("d???ch v??? lo???i 2")) typeRoomComboBox.setSelectedIndex(1);
            else typeRoomComboBox.setSelectedIndex(2);
            roomComboBox.setSelectedItem(room);
            zoneComboBox.setSelectedItem(zone);
            roomComboBox.setSelectedItem(room);
        }
        else jLabel23.setVisible(true);
        motKiCheck.setSelected(false);
        haiKiCheck.setSelected(false);
        baKiCheck.setSelected(false);
        tongTien_Dky.setText("");
        
    }//GEN-LAST:event_roomTable1MousePressed

    private void motKiCheckMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_motKiCheckMousePressed
        // TODO add your handling code here:
        haiKiCheck.setSelected(false);
        baKiCheck.setSelected(false);
       
    }//GEN-LAST:event_motKiCheckMousePressed
int getCost(String typeRoom){
    int cost=0;
    for(TypeRoom t:listType){
        if(t.getTypeOfRoom().equals(typeRoom)){
            cost= t.getCost();
        }
    }
    return cost;
}
    private void haiKiCheckMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_haiKiCheckMousePressed
        // TODO add your handling code here:
        motKiCheck.setSelected(false);
        baKiCheck.setSelected(false);
        
    }//GEN-LAST:event_haiKiCheckMousePressed

    private void baKiCheckMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baKiCheckMousePressed
        // TODO add your handling code here:
        motKiCheck.setSelected(false);
        haiKiCheck.setSelected(false);
        
    }//GEN-LAST:event_baKiCheckMousePressed

    private void emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_emailKeyReleased

    private void mssvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mssvKeyReleased
        // TODO add your handling code here:
        if(!nganh.getText().equals(""))
        email.setText(mssv.getText().toLowerCase()+"@student.ptithcm.edu.vn");
        String check1="N[1-9]{2}DCPT";
        String check2="N[1-9]{2}DCCN";
        String check3="N[1-9]{2}DCMR";
        String check4="N[1-9]{2}DCAT";
        String check5="N[1-9]{2}DCKT";
        String check6="N[1-9]{2}DCQT";
        String check7="N[1-9]{2}DCVT";
        String checkSo="[0-9]{1,3}";
        if(mssv.getText().toUpperCase().matches(check1)||mssv.getText().toUpperCase().matches(check1+checkSo))
            nganh.setText("C??ng Ngh??? ??a Ph????ng Ti???n");
        else if(mssv.getText().toUpperCase().matches(check2)||mssv.getText().toUpperCase().matches(check2+checkSo))
            nganh.setText("C??ng Ngh??? Th??ng Tin");
        else if(mssv.getText().toUpperCase().matches(check3)||mssv.getText().toUpperCase().matches(check3+checkSo))
            nganh.setText("Marketing");
        else if(mssv.getText().toUpperCase().matches(check4)||mssv.getText().toUpperCase().matches(check4+checkSo))
            nganh.setText("An To??n Th??ng Tin");
        else if(mssv.getText().toUpperCase().matches(check5)||mssv.getText().toUpperCase().matches(check5+checkSo))
            nganh.setText("K??? To??n");
        else if(mssv.getText().toUpperCase().matches(check6)||mssv.getText().toUpperCase().matches(check6+checkSo))
            nganh.setText("Qu???n Tr??? Kinh Doanh");
        else if(mssv.getText().toUpperCase().matches(check7)||mssv.getText().toUpperCase().matches(check7+checkSo))
            nganh.setText("??i???n T??? Vi???n Th??ng");
       else nganh.setText("");
    }//GEN-LAST:event_mssvKeyReleased

    private void searchRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchRoomActionPerformed

    private void searchRoomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchRoomKeyReleased
        // TODO add your handling code here:
        search(searchRoom.getText(),roomTable1);
    }//GEN-LAST:event_searchRoomKeyReleased

    private void baKiCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baKiCheckActionPerformed
        // TODO add your handling code here:
        String room=(String)roomComboBox.getSelectedItem();
        int cost=new DAO().getCost_NameRoom(room);
        if(baKiCheck.isSelected()){
            kiDangKy="C??? n??m";
            cost=cost*12;
        }
        else cost=0;
        tongTien_Dky.setText(converter(cost));
    }//GEN-LAST:event_baKiCheckActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        resetTT();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        card.show(cardRight, "card2");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         card.show(cardRight, "card3");
         allRoom.setSelected(true);
         roomDay.setSelected(false);
         roomTrong.setSelected(false);
         removeTable(modelCard2);
         showTable(modelCard2);
         zoneSearch.setSelectedIndex(-1);
         allZone.setSelected(true);
         zoneDay.setSelected(false);
         zoneTrong.setSelected(false);
         DefaultTableModel mod=(DefaultTableModel) zoneTable.getModel();
         removeTable(mod);
         showTable_Zone();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void roomTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_roomTable2MouseClicked

    private void roomTable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomTable2MousePressed
        // TODO add your handling code here:
   
    }//GEN-LAST:event_roomTable2MousePressed

    private void allRoomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allRoomMousePressed
        // TODO add your handling code here:
        allRoom.setSelected(false);
        roomTrong.setSelected(false);
        roomDay.setSelected(false);
        removeTable(modelCard2);
        showTable(modelCard2);
        zoneSearch.setSelectedIndex(-1);
    }//GEN-LAST:event_allRoomMousePressed

    private void roomTrongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomTrongMousePressed
        // TODO add your handling code here:
        roomTrong.setSelected(false);
        allRoom.setSelected(false);
        roomDay.setSelected(false);
        removeTable(modelCard2);
        showTable_TrangThai("c??n ch???", modelCard2);
        zoneSearch.setSelectedIndex(-1);
    }//GEN-LAST:event_roomTrongMousePressed

    private void roomDayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomDayMousePressed
        // TODO add your handling code here:
        roomDay.setSelected(false);
        roomTrong.setSelected(false);
        allRoom.setSelected(false);
        removeTable(modelCard2);
        showTable_TrangThai("????? ng?????i", modelCard2);
        zoneSearch.setSelectedIndex(-1);
    }//GEN-LAST:event_roomDayMousePressed

    private void allRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_allRoomActionPerformed

    private void allZoneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allZoneMousePressed
        // TODO add your handling code here:
        allZone.setSelected(false);
        zoneTrong.setSelected(false);
        zoneDay.setSelected(false);
        DefaultTableModel mod=(DefaultTableModel)zoneTable.getModel();
        removeTable(mod);
        showTable_Zone();
    }//GEN-LAST:event_allZoneMousePressed

    private void allZoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allZoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_allZoneActionPerformed

    private void zoneTrongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zoneTrongMousePressed
        // TODO add your handling code here:
        zoneTrong.setSelected(false);
        allZone.setSelected(false);
        zoneDay.setSelected(false);
       DefaultTableModel mod=(DefaultTableModel)zoneTable.getModel();
        removeTable(mod);
        showTable_Zone_TT("c??n ph??ng");
    }//GEN-LAST:event_zoneTrongMousePressed

    private void zoneTrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoneTrongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zoneTrongActionPerformed

    private void zoneDayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zoneDayMousePressed
        // TODO add your handling code here:
        zoneDay.setSelected(false);
        allZone.setSelected(false);
        zoneTrong.setSelected(false);
        DefaultTableModel mod=(DefaultTableModel)zoneTable.getModel();
        removeTable(mod);
        showTable_Zone_TT("h???t ph??ng");
    }//GEN-LAST:event_zoneDayMousePressed

    private void zoneDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoneDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zoneDayActionPerformed

    private void zoneSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoneSearchActionPerformed
        // TODO add your handling code here:
        if(zoneSearch.getSelectedIndex()>=0){
        allRoom.setSelected(false);
        roomDay.setSelected(false);
        roomTrong.setSelected(false);
        showTable_Zone(modelCard2,zoneSearch);
        }
    }//GEN-LAST:event_zoneSearchActionPerformed

    private void zoneSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zoneSearchMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_zoneSearchMousePressed

    private void zoneSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zoneSearchMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_zoneSearchMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        card.show(cardRight,"card4");
        xacNhanSV.setVisible(false);
        huySV.setVisible(false);
        DefaultTableModel dfm=(DefaultTableModel)studentTable.getModel();
        removeTable(dfm);
        showTable_Student();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void studentTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentTableMousePressed
        // TODO add your handling code here:
        String mssv=(String) studentTable.getValueAt(studentTable.getSelectedRow(), 2);
        showTT_Student(mssv);        
    }//GEN-LAST:event_studentTableMousePressed

    private void chinhSuaSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chinhSuaSVActionPerformed
        // TODO add your handling code here:
        tenT.requestFocus();
        chinhSuaSV.setVisible(false);
        huySV.setVisible(true);
        setEdit_TTStudent(true);
    }//GEN-LAST:event_chinhSuaSVActionPerformed
void setEdit_TTStudent(boolean b){
    tenT.setEditable(b);
    lopT.setEditable(b);
    nganhT.setEditable(b);
    sdtT.setEditable(b);
    ngaySinhT.setEditable(b);
    emailT.setEditable(b);
    diaChiT.setEditable(b);
    quocTichT.setEditable(b);
    tonGiaoT.setEditable(b);
    danTocT.setEditable(b);
    xacNhanSV.setVisible(b);
}
    private void xacNhanSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xacNhanSVActionPerformed
        // TODO add your handling code here:
        int x=JOptionPane.showConfirmDialog(rootPane, "X??c nh???n c???p nh???t th??ng tin sinh vi??n?");
        DefaultTableModel mod=(DefaultTableModel) studentTable.getModel();
        if(x==JOptionPane.YES_OPTION){
            updateTT_Student();
            removeTable(mod);
            showTable_Student();
        } 
    }//GEN-LAST:event_xacNhanSVActionPerformed

    private void huySVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huySVActionPerformed
        // TODO add your handling code here:
        huySV.setVisible(false);
        xacNhanSV.setVisible(false);
        setEdit_TTStudent(false);
        chinhSuaSV.setVisible(true);
    }//GEN-LAST:event_huySVActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        card.show(cardRight, "card5");
        giaHanPanel.setVisible(false);
        dong2.setVisible(false);
        chuyenPhongPanel.setVisible(false);
        resetTT_Contract();
        giaHan.setVisible(false);
        chuyenPhong_HD.setVisible(false);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void contractTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contractTableMousePressed
        // TODO add your handling code here:
        String mssv=(String) contractTable.getValueAt(contractTable.getSelectedRow(), 2);
        showTT_Contract(mssv);
        giaHanPanel.setVisible(false);
        giaHan.setVisible(true);
        chuyenPhongPanel.setVisible(false);
        phong_CP.setText("");
        tien_CP.setText(" ");
        tt_CP.setText(" ");
        giaHan.setVisible(true);
        chuyenPhong_HD.setVisible(true);
    }//GEN-LAST:event_contractTableMousePressed

    private void giaHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giaHanActionPerformed
        // TODO add your handling code here:
       if(ngayKT_HD.getText().equals("31/12/2021")){
           giaHanPanel.setVisible(true);
           ngayKT_HD1.setText(ngayKT_HD.getText());
           kiGH_HD.removeAllItems();
           kiGH_HD.addItem("HK2");
           kiGH_HD.addItem("HK2-3");
       }
       else if(ngayKT_HD.getText().equals("31/05/2022")){
           giaHanPanel.setVisible(true);
           kiGH_HD.removeAllItems();
           ngayKT_HD1.setText(ngayKT_HD.getText());
           kiGH_HD.addItem("HK3");
       }
       else{
           giaHanPanel.setVisible(false);
           JOptionPane.showMessageDialog(rootPane, "Hi???n t???i ch??a cho ph??p gia h???n h???p ?????ng");
       }
    }//GEN-LAST:event_giaHanActionPerformed

    private void xacNhan_GHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xacNhan_GHActionPerformed
        // TODO add your handling code here:
        Date d=null;
        try {
           d=df.parse(ngayKT_HD2.getText());
        } catch (Exception e) {
        }
        SimpleDateFormat df1=new SimpleDateFormat("yyyyMMdd");
        int x=JOptionPane.showConfirmDialog(rootPane, "X??c nh???n gia h???n h???p ?????ng?");
        if(x==JOptionPane.YES_OPTION){
            Bill b=new Bill();
            if(addBill_Card4(b)){
                if(new DAO().updateContract_FinishDay(mssv_HD.getText(),df1.format(d))){
                    if(new DAO().updateContract_Payment(mssv_HD.getText(),tienToInt(tongTien_GH.getText()))){
                        giaHanPanel.setVisible(false);
                        int sum=tienToInt(tongTien_GH.getText())+tienToInt(tongTien_HD.getText());
                        JOptionPane.showMessageDialog(rootPane,"Gia h???n h???p ?????ng th??nh c??ng");
                        tongTien_HD.setText(converter(sum));
                    }else{
                        JOptionPane.showMessageDialog(rootPane,"Gia h???n h???p ?????ng kh??ng th??nh c??ng");
                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane,"C???p nh???t ng??y h???t h???n h???p ?????ng kh??ng th??nh c??ng");
                }
            }else{
                 JOptionPane.showMessageDialog(rootPane,"Gia h???n h???p ?????ng kh??ng th??nh c??ng!");
            }
        }
    }//GEN-LAST:event_xacNhan_GHActionPerformed

    private void giaHanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_giaHanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_giaHanMouseClicked

    private void huy_GHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huy_GHActionPerformed
        // TODO add your handling code here:
        giaHanPanel.setVisible(false);
        giaHan.setVisible(true);
    }//GEN-LAST:event_huy_GHActionPerformed

    private void kiGH_HDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kiGH_HDActionPerformed
        // TODO add your handling code here:
        dong2.setVisible(true);
        String check=(String)kiGH_HD.getSelectedItem();
        int a=kiGH_HD.getSelectedIndex();
        int cost=new DAO().getCost_NameRoom(phong_HD.getText());
        int tongTien=0;
        if(a==0){
        if(check.equals("HK2")){
            cost=cost*5;
            tongTien_GH.setText(converter(cost));
            ngayKT_HD2.setText("31/05/2022");
        }
        else if(check.equals("HK3")){
            cost=cost*2;
            tongTien_GH.setText(converter(cost));
            ngayKT_HD2.setText("31/07/2022");
        }
        }
        else if(a==1){
            if(check.equals("HK2-3")){
                cost=cost*7;
                tongTien_GH.setText(converter(cost));
                ngayKT_HD2.setText("31/07/2022");
         }
        }
    }//GEN-LAST:event_kiGH_HDActionPerformed

    private void chuyenPhong_HDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chuyenPhong_HDActionPerformed
        // TODO add your handling code here:
         chuyenPhongPanel.setVisible(true);
         tien_CP1.setVisible(false);
         tt_CP.setText(" ");
         phong_CP.setText("");
    }//GEN-LAST:event_chuyenPhong_HDActionPerformed

    private void xacNhan_CPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xacNhan_CPActionPerformed
        // TODO add your handling code here:
        int slhc=new DAO().count_Room(phong_CP.getText());
        int sltd=new DAO().max_Room(phong_CP.getText());
        int idSexCu=new DAO().idsex(phong_HD.getText());
        int idSexMoi=new DAO().idsex(phong_CP.getText());
        Bill b=new Bill();
        if(tt_CP.getText().equals("Ph??ng chuy???n kh??ng ???????c tr??ng ph??ng c??")){
            JOptionPane.showMessageDialog(rootPane, "Vui l??ng ch???n ph??ng kh??c v???i ph??ng c?? ");
        }
        else{
        if(idSexCu==idSexMoi){
        if(slhc==sltd){
            JOptionPane.showMessageDialog(rootPane, "Ph??ng n??y ???? ????? ng?????i vui l??ng ch???n ph??ng kh??c");
        }
        else if(slhc<sltd){
            int x=JOptionPane.showConfirmDialog(rootPane, "X??c nh???n chuy???n ph??ng?");
            if(x==JOptionPane.YES_OPTION){
            if(addBill_ChuyenPhong(b)){
                new DAO().update_IncreaseAmount(phong_HD.getText());
                new DAO().UpdateAmountInRoom(phong_CP.getText());
                new DAO().update_NameRoom(mssv_HD.getText(),phong_CP.getText());
                new DAO().UpdatStatusRoom(phong_CP.getText());
                update_Payment(mssv_HD.getText());
                JOptionPane.showMessageDialog(rootPane,"Chuy???n ph??ng th??nh c??ng");
                chuyenPhongPanel.setVisible(false);
                //phong_HD.setText(phong_CP.getText());
                showTT_Contract(mssv_HD.getText());
            }
            else{
                JOptionPane.showMessageDialog(rootPane,"C?? l???i vui l??ng th??? l???i sau");
            }
            }
        }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Vui l??ng ch???n khu ph?? h???p v???i gi???i t??nh sinh vi??n");
        }
        }
    }//GEN-LAST:event_xacNhan_CPActionPerformed

    private void huy_CPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huy_CPActionPerformed
        // TODO add your handling code here:
        chuyenPhongPanel.setVisible(false);
    }//GEN-LAST:event_huy_CPActionPerformed

    private void phong_CPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phong_CPKeyReleased
        // TODO add your handling code here:
        if(checkExist(phong_CP.getText())){
            if(phong_CP.getText().equals(phong_HD.getText())){
                tt_CP.setText("Ph??ng chuy???n kh??ng ???????c tr??ng ph??ng c??");
            }
            else{
                showTT_CP();
                tien_CP1.setVisible(true);
            }
        }
        else{
            tien_CP.setText(" ");
            tt_CP.setText(" ");
            tien_CP1.setVisible(false);
        }
    }//GEN-LAST:event_phong_CPKeyReleased

    private void phong_CPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong_CPMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong_CPMousePressed

    private void roomTable_HDDNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomTable_HDDNMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_roomTable_HDDNMouseClicked

    private void roomTable_HDDNMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomTable_HDDNMousePressed
        // TODO add your handling code here:
        String room=(String) roomTable_HDDN.getValueAt(roomTable_HDDN.getSelectedRow(), 1);
        DefaultTableModel dfm=(DefaultTableModel)HDDN_Table.getModel();
        phong_HDDN.setText(room);
        phong_HDDN1.setText(room);
        removeTable(dfm);
        showTable_HDDN(dfm);
    }//GEN-LAST:event_roomTable_HDDNMousePressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        card.show(cardRight, "card6");
        DefaultTableModel dfm=(DefaultTableModel)roomTable_HDDN.getModel();
        DefaultTableModel dfm2=(DefaultTableModel)HDDN_Table.getModel();
        removeTable(dfm);
        removeTable(dfm2);
        showTable(dfm);
        showTable_HDDN(dfm2);
        canhbao_HDDN.setVisible(false);
        thanhToanHD_Panel.setVisible(false);
        d1.setVisible(false);
        d2.setVisible(false);
        d3.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void headIndexKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_headIndexKeyReleased
        // TODO add your handling code here:
        int head=0;
        int last=0;
        if(!headIndex.getText().equals(""))
        head=Integer.valueOf(headIndex.getText());
        if(!lastIndex.getText().equals(""))
        last=Integer.valueOf(lastIndex.getText());
        //int use=0;
       int use=last-head;
        if(use>0){
            useE.setText(String.valueOf(use));
            showTT_TienDien();
            canhbao_HDDN.setVisible(false);
        }
        else if(use<=0){
            canhbao_HDDN.setVisible(true);
            useE.setText("");
            resetTT_HDDN();
        }
    }//GEN-LAST:event_headIndexKeyReleased

    private void lastIndexKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastIndexKeyReleased
        // TODO add your handling code here:
        int head=0;
        int last=0;
        if(!headIndex.getText().equals(""))
        head=Integer.valueOf(headIndex.getText());
        if(!lastIndex.getText().equals(""))
        last=Integer.valueOf(lastIndex.getText());
        //int use=0;
       int use=last-head;
        if(use>0){
            useE.setText(String.valueOf(use));
            showTT_TienDien();
            canhbao_HDDN.setVisible(false);
        }
        else if(use<=0){
            canhbao_HDDN.setVisible(true);
            useE.setText("");
            resetTT_HDDN();
        }
    }//GEN-LAST:event_lastIndexKeyReleased

    private void useEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_useEActionPerformed

    private void useEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_useEKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_useEKeyReleased

    private void thangChotKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_thangChotKeyReleased
        // TODO add your handling code here:
        showTT_NgayChot();
        showTT_HeadIndex();
    }//GEN-LAST:event_thangChotKeyReleased

    private void namChotKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namChotKeyReleased
        // TODO add your handling code here:
        showTT_NgayChot();
        showTT_HeadIndex();
    }//GEN-LAST:event_namChotKeyReleased

    private void xacNhan_HDDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xacNhan_HDDNActionPerformed
        // TODO add your handling code here:
        HDDienNuoc hd=new HDDienNuoc();
        if(phong_HDDN.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane,"Vui l??ng ch???n ph??ng tr?????c khi l???p h??a ????n");
        }
        else{
            if(thangChot.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane,"Vui l??ng nh???p th??ng ch???t ch??? s???");
            }
            else{
                if(namChot.getText().equals("")){
                    JOptionPane.showMessageDialog(rootPane,"Vui l??ng nh???p n??m ch???t ch??? s???");
                }
                else{
                    if(headIndex.getText().equals("")){
                        JOptionPane.showMessageDialog(rootPane,"Vui l??ng nh???p ch??? s??? ??i???n c??");
                    }
                    else{
                        if(lastIndex.getText().equals("")){
                            JOptionPane.showMessageDialog(rootPane,"Vui l??ng nh???p ch??? s??? ??i???n m???i");
                        }
                        else{
                            if(ngayChot.getText().equals("")) JOptionPane.showMessageDialog(rootPane,"Vui l??ng ki???m tra l???i th???i gian l???p h??a ????n");
                            else{
                                int a=Integer.valueOf(lastIndex.getText());
                                int b=Integer.valueOf(headIndex.getText());
                                if(a-b<=0) JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh???p ????ng ch??? s??? ??i???n");
                                else{
                            if(checkDuplicate_HDDN()) {
                                JOptionPane.showMessageDialog(rootPane,"H??a ????n trong th???i gian n??y ???? t???n t???i! Vui l??ng ki???m tra l???i");
                            }
                            else{
                                int x=JOptionPane.showConfirmDialog(rootPane,"X??c nh???n l???p h??a ????n?" );
                                if(x==JOptionPane.YES_OPTION){
                                if(addTT_HDDN(hd)) {
                                    DefaultTableModel dfm=(DefaultTableModel)HDDN_Table.getModel();
                                    JOptionPane.showMessageDialog(rootPane,"L???p h??a ????n ??i???n th??nh c??ng");
                                    removeTable(dfm);
                                    showTable_HDDN(dfm);
                                }
                                else JOptionPane.showMessageDialog(rootPane, "L???p h??a ????n th???t b???i! Vui l??ng th??? l???i sau");
                                }
                            }
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_xacNhan_HDDNActionPerformed

    private void HDDN_TableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HDDN_TableMousePressed
        // TODO add your handling code here:
        int tien=(int) HDDN_Table.getValueAt(HDDN_Table.getSelectedRow(),6);
        String trangThai=(String) HDDN_Table.getValueAt(HDDN_Table.getSelectedRow(),7);
        if(trangThai.equalsIgnoreCase("Ch??a Thanh To??n")){
            thanhToanHD_Panel.setVisible(true);
            tongTien_HDDN.setText(converter(tien));
        }
        else {
            thanhToanHD_Panel.setVisible(false);
        }
        
    }//GEN-LAST:event_HDDN_TableMousePressed

    private void thanhToan_HDDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thanhToan_HDDNActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dfm=(DefaultTableModel)HDDN_Table.getModel();
        int x=JOptionPane.showConfirmDialog(rootPane,"X??c nh???n thanh to??n?");
        if(x==JOptionPane.YES_OPTION){
            if(thanhToan_HDDN()){
                removeTable(dfm);
                showTable_HDDN(dfm);
                JOptionPane.showMessageDialog(rootPane,"Thanh to??n th??nh c??ng");
            }
            else JOptionPane.showMessageDialog(rootPane,"Thanh to??n th???t b???i! Vui l??ng th??? l???i sau");
        }
    }//GEN-LAST:event_thanhToan_HDDNActionPerformed
int indexFeedback=0;
int indexPage=1;
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        card.show(cardRight, "card7");
        DefaultTableModel dfm=(DefaultTableModel)request_Table.getModel();
        removeTable(dfm);
        showTable_Request(dfm);
        status_L.setVisible(false);
        jButton10.setVisible(false);
        s_check1.setVisible(false);
        s_check2.setVisible(false);
        s_check3.setVisible(false);
        s_check4.setVisible(false);
        s_text.setVisible(false);
        jSeparator17.setVisible(false);
        confirm_s.setVisible(false);
        cancel_s.setVisible(false);
        panel_HDRe.setVisible(false);
        //                                 show feedback                            //
        ArrayList <Feedback>listF=new DAO().getListFeedback();
        int size=listF.size();
        indexFeedback=0;
        if(size==0) {
            panel1.setVisible(false);
            panel2.setVisible(false);
        }
        else if(size==1){
            panel2.setVisible(false);
            addThongTin_Star(one1, two1, three1, four1, five1,
                    one2, two2, three2, four2, five2, 
                    one3, two3, three3, four3, five3,
                    idsv_1,date_1,content_1
                    ,0);
        }
        else{
            panel1.setVisible(true);
            panel2.setVisible(true);
            addThongTin_Star(one1, two1, three1, four1, five1,
                    one2, two2, three2, four2, five2, 
                    one3, two3, three3, four3, five3,
                    idsv_1,date_1,content_1
                    ,0);
            addThongTin_Star(one4, two4, three4, four4, five4,
                    one5, two5, three5, four5, five5, 
                    one6, two6, three6, four6, five6, 
                    idsv_2,date_2,content_2
                    ,1);
        }
        int a=size;
        int b=a/2;
        if(a%2!=0) b+=1;
        pageF.setText("1/"+String.valueOf(b));
        indexPage=1;
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        jButton10.setVisible(false);
        status_L.setVisible(true);
        s_check1.setVisible(true);
        s_check2.setVisible(true);
        s_check3.setVisible(true);
        s_check4.setVisible(true);
        s_text.setVisible(true);
        jSeparator17.setVisible(true);
        confirm_s.setVisible(true);
        cancel_s.setVisible(true);
        s_check1.setSelected(false);
        s_check2.setSelected(false);
        s_check3.setSelected(false);
        s_check4.setSelected(false);
        s_text.setVisible(false);
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void request_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_request_TableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_request_TableMouseClicked

    private void request_TableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_request_TableMousePressed
        // TODO add your handling code here:
        jButton10.setVisible(true);
        status_L.setVisible(false);
        s_check1.setVisible(false);
        s_check2.setVisible(false);
        s_check3.setVisible(false);
        s_check4.setVisible(false);
        s_text.setVisible(false);
        jSeparator17.setVisible(false);
        confirm_s.setVisible(false);
        cancel_s.setVisible(false);
    }//GEN-LAST:event_request_TableMousePressed

    private void s_check1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s_check1MousePressed
        // TODO add your handling code here:
        s_check2.setSelected(false);
        s_check3.setSelected(false);
        s_check4.setSelected(false);
        s_text.setVisible(false);
        confirm_s.setVisible(true);
        cancel_s.setVisible(true);
    }//GEN-LAST:event_s_check1MousePressed

    private void s_check2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s_check2MousePressed
        // TODO add your handling code here:
        s_check1.setSelected(false);
        s_check3.setSelected(false);
        s_check4.setSelected(false);
        s_text.setVisible(false);
        confirm_s.setVisible(true);
        cancel_s.setVisible(true);
    }//GEN-LAST:event_s_check2MousePressed

    private void s_check3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s_check3MousePressed
        // TODO add your handling code here:
        s_check2.setSelected(false);
        s_check1.setSelected(false);
        s_check4.setSelected(false);
        s_text.setVisible(false);
        confirm_s.setVisible(false);
        cancel_s.setVisible(false);
    }//GEN-LAST:event_s_check3MousePressed

    private void s_check4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s_check4MousePressed
        // TODO add your handling code here:
        s_check2.setSelected(false);
        s_check3.setSelected(false);
        s_check1.setSelected(false);
        s_text.setVisible(true);
        s_text.requestFocus();
        confirm_s.setVisible(true);
        cancel_s.setVisible(true);
    }//GEN-LAST:event_s_check4MousePressed

    private void chinhSuaSVMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chinhSuaSVMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_chinhSuaSVMousePressed

    private void cancel_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_sActionPerformed
        // TODO add your handling code here:
        jButton10.setVisible(true);
        status_L.setVisible(false);
        s_check1.setVisible(false);
        s_check2.setVisible(false);
        s_check3.setVisible(false);
        s_check4.setVisible(false);
        s_text.setVisible(false);
        jSeparator17.setVisible(false);
        confirm_s.setVisible(false);
        cancel_s.setVisible(false);
    }//GEN-LAST:event_cancel_sActionPerformed

    private void confirm_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_sActionPerformed
      // TODO add your handling code her
        if(update_Request()){
            JOptionPane.showMessageDialog(rootPane, "C???p nh???t th??nh c??ng");
            DefaultTableModel dfm=(DefaultTableModel)request_Table.getModel();
            removeTable(dfm);
            showTable_Request(dfm);
            jButton10.setVisible(false);
            status_L.setVisible(false);
            s_check1.setVisible(false);
            s_check2.setVisible(false);
            s_check3.setVisible(false);
            s_check4.setVisible(false);
            s_text.setVisible(false);
            jSeparator17.setVisible(false);
            confirm_s.setVisible(false);
            cancel_s.setVisible(false);
        }
        
    }//GEN-LAST:event_confirm_sActionPerformed

    private void s_check3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_check3ActionPerformed
        // TODO add your handling code here:
        panel_HDRe.setVisible(true);
        Date d=new Date();
        ngayChi_HDR.setText(df.format(d));
    }//GEN-LAST:event_s_check3ActionPerformed

    private void cancel_HDRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_HDRActionPerformed
        // TODO add your handling code here:
        panel_HDRe.setVisible(false);
        s_check3.setSelected(false);
    }//GEN-LAST:event_cancel_HDRActionPerformed

    private void s_check1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_check1ActionPerformed
        // TODO add your handling code here:
        panel_HDRe.setVisible(false);
    }//GEN-LAST:event_s_check1ActionPerformed

    private void s_check2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_check2ActionPerformed
        // TODO add your handling code here:
        panel_HDRe.setVisible(false);
    }//GEN-LAST:event_s_check2ActionPerformed

    private void s_check4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_check4ActionPerformed
        // TODO add your handling code here:
        panel_HDRe.setVisible(false);
    }//GEN-LAST:event_s_check4ActionPerformed

    private void s_textMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s_textMousePressed
        // TODO add your handling code here:
       // s_check4.setSelected(true);
    }//GEN-LAST:event_s_textMousePressed

    private void createHDReActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createHDReActionPerformed
        // TODO add your handling code here:
        Bill b=new Bill();
        if(!checkDateFormat(ngayChi_HDR.getText())) JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh???p ????ng ?????nh d???ng ng??y/th??ng/n??m");
        else{
            if(noiDungChi_HDR.getText().equals("")) JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh???p n???i dung chi");
            else{
                if(tienChi_HDR.getText().equals(""))JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh???p ti???n ???? chi");
                else{
                    int x=JOptionPane.showConfirmDialog(rootPane,"X??c nh???n l???p h??a ????n?");
                    if(x==JOptionPane.YES_OPTION){
                        if(addHDRe(b)) {
                            JOptionPane.showMessageDialog(rootPane, "L???p h??a ????n th??nh c??ng");
                            panel_HDRe.setVisible(false);
                            update_Request();
                            jButton10.setVisible(false);
                            status_L.setVisible(false);
                            s_check1.setVisible(false);
                            s_check2.setVisible(false);
                            s_check3.setVisible(false);
                            s_check4.setVisible(false);
                            s_text.setVisible(false);
                            jSeparator17.setVisible(false);
                            confirm_s.setVisible(false);
                            cancel_s.setVisible(false);
                        }
                        else JOptionPane.showMessageDialog(rootPane, "L???p h??a ????n th???t b???i");
                    }
                }
            }
        }
    }//GEN-LAST:event_createHDReActionPerformed

    private void nexttFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nexttFMousePressed
        // TODO add your handling code here:
        ArrayList <Feedback>listF=new DAO().getListFeedback();
        int size=listF.size();
        if(indexFeedback<size-2){
            indexFeedback+=2;
            addThongTin_Star(one1, two1, three1, four1, five1,
                    one2, two2, three2, four2, five2, 
                    one3, two3, three3, four3, five3,
                    idsv_1,date_1,content_1
                    ,indexFeedback);
            if(indexFeedback==size-1) panel2.setVisible(false);
            else
            {
            addThongTin_Star(one4, two4, three4, four4, five4,
                    one5, two5, three5, four5, five5, 
                    one6, two6, three6, four6, five6, 
                    idsv_2,date_2,content_2
                    ,++indexFeedback);
            indexFeedback--;
            }
        }
       int a=size;
        int b=a/2;
        if(a%2!=0) b+=1;
        if(indexPage<b)
        pageF.setText(String.valueOf(++indexPage)+"/"+String.valueOf(b)); 
    }//GEN-LAST:event_nexttFMousePressed
void addThongTin_Star(JLabel one,JLabel two,JLabel three,JLabel four,JLabel five,
        JLabel one2,JLabel two2,JLabel three2,JLabel four2,JLabel five2,
        JLabel one3,JLabel two3,JLabel three3,JLabel four3,JLabel five3,
        JLabel idsv,JLabel date,JTextArea content
        ,int index){
    ArrayList <Feedback>listF=new DAO().getListFeedback();
    idsv.setText(listF.get(index).getIdStudent());
    date.setText(df.format(listF.get(index).getDateCreate()));
    content.setText(listF.get(index).getContent());
    if(listF.get(index).getEvaP()==1){
                    setIcon_1Star(one, two, three, four, five);
                }else if(listF.get(index).getEvaP()==2){
                    setIcon_2Star(one, two, three, four, five);
                }else if(listF.get(index).getEvaP()==3){
                    setIcon_3Star(one, two, three, four, five);
                }else if(listF.get(index).getEvaP()==4){
                setIcon_4Star(one, two, three, four, five);
            }else if(listF.get(index).getEvaP()==5){
                setIcon_5Star(one, two, three, four, five);
            }
                
               if(listF.get(index).getEvaS()==1){
                    setIcon_1Star(one2, two2, three2, four2, five2);
               }else if(listF.get(index).getEvaS()==2){
                    setIcon_2Star(one2, two2, three2, four2, five2);
               }else if(listF.get(index).getEvaS()==3){
                    setIcon_3Star(one2, two2, three2, four2, five2);
               }else if(listF.get(index).getEvaS()==4){
                    setIcon_4Star(one2, two2, three2, four2, five2);
               }else if(listF.get(index).getEvaS()==5){
                    setIcon_5Star(one2, two2, three2, four2, five2);
               }
                
               if(listF.get(index).getEvaA()==1){
                    setIcon_1Star(one3, two3, three3, four3, five3);
               }else if(listF.get(index).getEvaA()==2){
                   setIcon_2Star(one3, two3, three3, four3, five3);
               }else if(listF.get(index).getEvaA()==3){
                   setIcon_3Star(one3, two3, three3, four3, five3);
               }else if(listF.get(index).getEvaA()==4){
                   setIcon_4Star(one3, two3, three3, four3, five3);
               }else if(listF.get(index).getEvaA()==5){
                   setIcon_5Star(one3, two3, three3, four3, five3);
               }
}
    private void backFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backFMousePressed
        // TODO add your handling code here:
         ArrayList <Feedback>listF=new DAO().getListFeedback();
        int size=listF.size();
        if(indexFeedback>1){
            indexFeedback-=2;
            panel1.setVisible(true);
            panel2.setVisible(true);
            addThongTin_Star(one1, two1, three1, four1, five1,
                    one2, two2, three2, four2, five2, 
                    one3, two3, three3, four3, five3,
                    idsv_1,date_1,content_1
                    ,indexFeedback);  
            addThongTin_Star(one4, two4, three4, four4, five4,
                    one5, two5, three5, four5, five5, 
                    one6, two6, three6, four6, five6, 
                    idsv_2,date_2,content_2
                    ,++indexFeedback);
            indexFeedback--;
        }
        int a=size;
        int b=a/2;
        if(a%2!=0) b+=1;
        if(indexPage>=2)
        pageF.setText(String.valueOf(--indexPage)+"/"+String.valueOf(b)); 
    }//GEN-LAST:event_backFMousePressed

    private void xacNhan_CPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xacNhan_CPMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_xacNhan_CPMousePressed

    private void cardIn1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cardIn1MouseReleased
        // TODO add your handling code here:
        jPopupMenu1.show(this,evt.getX()+100,evt.getY()+20);
    }//GEN-LAST:event_cardIn1MouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        resetTT();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tableDuyetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDuyetMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableDuyetMouseClicked

    private void tableDuyetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDuyetMousePressed
        // TODO add your handling code here:
        showTT_Bill();
    }//GEN-LAST:event_tableDuyetMousePressed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        if(idBill.getText().equals("")) JOptionPane.showMessageDialog(rootPane, "Vui l??ng ch???n ????n ????ng k?? tr?????c khi ph?? duy???t");
        else{
            int x=JOptionPane.showConfirmDialog(rootPane, "X??c nh???n ph?? duy???t ph??ng?");
            if(x==JOptionPane.YES_OPTION){
                boolean check=false;
                if(new DAO().UpdatStatusRoom(roomB.getText()))check =true;
                else check=false;
                if(new DAO().UpdateAmountInRoom(roomB.getText())) check =true;
                else check=false;
                if(new DAO().update_statusHD(Integer.valueOf(idBill.getText()))) check=true;
                else check=false;
                if(new DAO().update_dateCreateHD(Integer.valueOf(idBill.getText()))) check=true;
                else check=false;
                if(new DAO().upDate_StaffHD(new DangNhap().IDUs, Integer.valueOf(idBill.getText()))) check=true;
                else check=false;
                if(new DAO().upDate_StaffContract(new DangNhap().IDUs,mssvB.getText())) check=true;
                else check=false;
                if(new DAO().upDate_StartDay(mssvB.getText())) check=true;
                else check=false;
                if(new DAO().upDate_StatusUser(mssvB.getText(),"??ang ho???t ?????ng")) check=true;
                else check=false;
                new DAO().update_ContentHD(Integer.valueOf(idBill.getText()),mssvB.getText());
                if(check){
                    JOptionPane.showMessageDialog(rootPane, "Duy???t th??nh c??ng");
                    reset_FormDuyet();
                    DefaultTableModel dfm=(DefaultTableModel) tableDuyet.getModel();
                    removeTable(dfm);
                    showTable_DuyetDon(dfm);
                }
                else JOptionPane.showMessageDialog(rootPane, "Duy???t kh??ng th??nh c??ng. Vui l??ng ki???m tra l???i");
            }
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    void reset_FormDuyet(){
        idBill.setText("");
        dateCr.setText("");
        roomB.setText("");
        contentB.setText("");
        hocKyB.setText("");
        tongTienB.setText("");
        mssvB.setText("");
    }
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        if(idBill.getText().equals("")) JOptionPane.showMessageDialog(rootPane, "Vui l??ng ch???n ????n ????ng k?? tr?????c khi kh??ng ph?? duy???t");
        else{
            int x=JOptionPane.showConfirmDialog(rootPane, "X??c nh???n kh??ng ph?? duy???t?");
            if(x==JOptionPane.YES_OPTION){
                if(new DAO().upDate_StatusUser(mssvB.getText(), "Kh??ng ph?? duy???t")) JOptionPane.showMessageDialog(rootPane, "Th??nh c??ng");
                DefaultTableModel dfm=(DefaultTableModel) tableDuyet.getModel();
                removeTable(dfm);
                showTable_DuyetDon(dfm);
                reset_FormDuyet();
            }
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        card.show(cardRight, "card8");
        dong.setVisible(false);
        DefaultTableModel dfm1423=(DefaultTableModel) tableDuyet.getModel();
        removeTable(dfm1423);
          showTable_DuyetDon(dfm1423);
    }//GEN-LAST:event_jButton14ActionPerformed
int cost=0;
String kiDangKy="";
    private void motKiCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motKiCheckActionPerformed
        // TODO add your handling code here:
        String room=(String)roomComboBox.getSelectedItem();
         cost=new DAO().getCost_NameRoom(room);
        if(motKiCheck.isSelected()){
            if(motKiL.getText().equals("H???c k?? 1 - 5 th??ng")){
                kiDangKy="HK1";
                cost=cost*5;
            }else if(motKiL.getText().equals("H???c k?? 2 - 5 th??ng")){
                kiDangKy="HK2";
                cost=cost*5;
            }else if(motKiL.getText().equals("H???c k?? 3 - 2 th??ng")){
                kiDangKy="HK3";
                cost=cost*2;
            }
        }
        else cost=0;
        tongTien_Dky.setText(converter(cost));
    }//GEN-LAST:event_motKiCheckActionPerformed

    private void haiKiCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_haiKiCheckActionPerformed
        // TODO add your handling code here:
        String room=(String)roomComboBox.getSelectedItem();
        cost=new DAO().getCost_NameRoom(room);
        if(haiKiCheck.isSelected()){
            if(haiKiL.getText().equals("H???c k?? 1 v?? 2 - 10 th??ng")){
                cost=cost*10;
                kiDangKy="HK1-2";
            }else if(haiKiL.getText().equals("H???c k?? 2 v?? 3 - 7 th??ng")){
                kiDangKy="HK2-3";
                cost=cost*7;
            }
        }
        else cost=0;
        tongTien_Dky.setText(converter(cost));
    }//GEN-LAST:event_haiKiCheckActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        card.show(cardRight, "card9");
        show3DChart();
        ArrayList<Zone> list=new DAO().getListZone();
        zoneCombo.removeAllItems();
        for(Zone x : list){
            zoneCombo.addItem(x.getNameZone());
        }
        showLoaiPhong_Khu("Khu A");
        showAmountStudent_Type();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void zoneComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoneComboActionPerformed
        // TODO add your handling code here:
        String zone=(String)zoneCombo.getSelectedItem();
        showLoaiPhong_Khu(zone);
    }//GEN-LAST:event_zoneComboActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        card.show(cardRight, "card10");
        ky_TK.setVisible(false);
        namHoc_TK.setVisible(false);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void ky_TKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ky_TKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ky_TKActionPerformed

    private void namHoc_TKKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namHoc_TKKeyReleased
        // TODO add your handling code here:
//        String hocKy=(String)ky_TK.getSelectedItem();
//        String namHoc=namHoc_TK.getText();
//        if(namHoc.length()==4){
//        if(hocKy.equals("HK1")){
//            showTKDoanhThu_HK1(Integer.valueOf(namHoc_TK.getText()));
//        }else if(hocKy.equals("HK2")){
//            showTKDoanhThu_HK2(Integer.valueOf(namHoc_TK.getText()));
//        }else if(hocKy.equals("HK3")){
//            showTKDoanhThu_HK3(Integer.valueOf(namHoc_TK.getText()));
//        }else if(hocKy.equals("C??? N??m")){
//            showTKDoanhThu_CaNam(Integer.valueOf(namHoc_TK.getText()));
//        }
//            }
    }//GEN-LAST:event_namHoc_TKKeyReleased

    private void loaiComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loaiComboActionPerformed
        // TODO add your handling code here:
        if(loaiCombo.getSelectedIndex()==0){
            ky_TK.setVisible(false);
            namHoc_TK.setVisible(false);
            ngayBD_TK.setVisible(true);
            ngayKT_TK.setVisible(true);
            ngayBD_TK.setDate(null);
            ngayKT_TK.setDate(null);
            ngayBD_TK.setDateFormatString("dd/MM/yyyy");
            ngayKT_TK.setDateFormatString("dd/MM/yyyy");
            label1.setText("Ng??y b???t ?????u");
            label2.setText("Ng??y k???t th??c");
            
        }else if(loaiCombo.getSelectedIndex()==1){
            ky_TK.setVisible(false);
            namHoc_TK.setVisible(false);
            ngayBD_TK.setVisible(true);
            ngayKT_TK.setVisible(true);
            ngayBD_TK.setDate(null);
            ngayKT_TK.setDate(null);
            ngayBD_TK.setDateFormatString("MM/yyyy");
            ngayKT_TK.setDateFormatString("MM/yyyy");
            label1.setText("Th??ng b???t ?????u");
            label2.setText("Th??ng k???t th??c");
        }else{
            ky_TK.setVisible(true);
            namHoc_TK.setVisible(true);
            ngayBD_TK.setVisible(false);
            ngayKT_TK.setVisible(false);
            ky_TK.setSelectedIndex(0);
            namHoc_TK.setText("");
            label1.setText("H???c K???");
            label2.setText("N??m h???c");
        }
    }//GEN-LAST:event_loaiComboActionPerformed

    private void thongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thongkeActionPerformed
        // TODO add your handling code here:
        if(loaiCombo.getSelectedIndex()==0){
            Date dateBD=ngayBD_TK.getDate();
            Date dateKT=ngayKT_TK.getDate();
            int dayBD=day(dateBD);
            int dayKT=day(dateKT);
            int monthBD=month(dateBD);
            int monthKT=month(dateKT);
            int yearBD=year(dateBD);
            int yearKT=year(dateKT);
            if(monthBD==monthKT&&yearBD==yearKT){
                if(dayBD<dayKT)
                showTK_Ngay();
                else if(dayBD>dayKT)
                    JOptionPane.showMessageDialog(rootPane, "Vui l??ng ch??? ch???n ng??y k???t th??c l???n h??n ng??y b???t ?????u");
            }
            else JOptionPane.showMessageDialog(rootPane, "Vui l??ng ch??? ch???n ng??y c??ng th??ng");
        }else if(loaiCombo.getSelectedIndex()==1){
            Date dateBD=ngayBD_TK.getDate();
            Date dateKT=ngayKT_TK.getDate();
            int monthBD=month(dateBD);
            int monthKT=month(dateKT);
            int yearBD=year(dateBD);
            int yearKT=year(dateKT);
            if(yearBD==yearKT){
                if(monthBD<monthKT){
                showTK_Thang();
                }else if(monthBD>monthKT)
                    JOptionPane.showMessageDialog(rootPane, "Vui l??ng ch??? ch???n th??ng k???t th??c l???n h??n th??ng b???t ?????u");
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Vui l??ng ch??? ch???n th??ng c??ng n??m");
            }
        }
        else if(loaiCombo.getSelectedIndex()==2){
            String hocKy=(String)ky_TK.getSelectedItem();
            String namHoc=namHoc_TK.getText();
            if(namHoc.length()==4){
                if(hocKy.equals("HK1")){
                    showTKDoanhThu_HK1(Integer.valueOf(namHoc_TK.getText()));
                }else if(hocKy.equals("HK2")){
                    showTKDoanhThu_HK2(Integer.valueOf(namHoc_TK.getText()));
                }else if(hocKy.equals("HK3")){
                    showTKDoanhThu_HK3(Integer.valueOf(namHoc_TK.getText()));
                }else if(hocKy.equals("C??? N??m")){
                    showTKDoanhThu_CaNam(Integer.valueOf(namHoc_TK.getText()));
                }
            }
        }
    }//GEN-LAST:event_thongkeActionPerformed

    private void backMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMousePressed
        // TODO add your handling code here:
        setVisible(false);
        new DangNhap().setVisible(true);
    }//GEN-LAST:event_backMousePressed
void showTKDoanhThu_HK1(int year){
    DefaultCategoryDataset df=new DefaultCategoryDataset();
    ArrayList <Bill> listBill=new DAO().getListBillAll();
    int cost1=0,cost2=0,cost3=0,cost4=0,cost5=0;
        for(Bill x : listBill){
            Date d=new DAO().getDateCreate_Bill(x.getIDBill());
            if(year(d)==year){
            if(month(d)>=8&&month(d)<=12){
                if(month(d)==8){
                    cost1+=x.getPayment();
                }else if(month(d)==9){
                    cost2+=x.getPayment();
                }else if(month(d)==10){
                    cost3+=x.getPayment();
                }else if(month(d)==11){
                    cost4+=x.getPayment();
                }else if(month(d)==12){
                    cost5+=x.getPayment();
                }
            }
        }
        }
        if(cost1==0) JOptionPane.showMessageDialog(rootPane, "Kh??ng t???n t???i h??a ????n trong th???i gian n??y");
        else{
        df.setValue(cost1, "Amount", "Th??ng 8");
        df.setValue(cost2, "Amount", "Th??ng 9");
        df.setValue(cost3, "Amount", "Th??ng 10");
        df.setValue(cost4, "Amount", "Th??ng 11");
        df.setValue(cost5, "Amount", "Th??ng 12");
        JFreeChart lineChart=ChartFactory.createLineChart("Th???ng K?? Doanh Thu KTX","Th??ng","T???ng Ti???n",df, PlotOrientation.VERTICAL,false,true,false);
    CategoryPlot lineCate=lineChart.getCategoryPlot();
    lineCate.setBackgroundPaint(Color.white);
    LineAndShapeRenderer line=(LineAndShapeRenderer)lineCate.getRenderer();
    Color lineChartColor=new Color(204,0,51);
    line.setSeriesPaint(0, lineChartColor);
    ChartPanel charPanel=new ChartPanel(lineChart);
    panel.removeAll();
    panel.add(charPanel,BorderLayout.CENTER);
    panel.validate();
        }
}
void showTK_Ngay(){
    DefaultCategoryDataset df=new DefaultCategoryDataset();
    Date dateBD=ngayBD_TK.getDate();
    Date dateKT=ngayKT_TK.getDate();
    int dayBD=day(dateBD);
    int dayKT=day(dateKT);
    int monthBD=month(dateBD);
    ArrayList <Bill> listBill=new DAO().getListBillAll();
    int tien=0;
    int i=dayBD;
    int j=0;
    int pos=0;
    int tongDoanhThu=0;
     while(i<=dayKT){
         while(j<listBill.size()){
             int day=day(listBill.get(j).getDateCreate());
             int month=month(listBill.get(j).getDateCreate());
             if(day==i&&month==monthBD){
                 tien+=listBill.get(j).getPayment();
                 pos=j;
                 tongDoanhThu+=listBill.get(j).getPayment();
             }
             j++;
         }
         df.addValue(tien,"","Ng??y "+i);
         tien=0;
         j=pos;
         i++;
    }
    JFreeChart chart=ChartFactory.createBarChart3D("Th???ng k?? doanh thu theo ng??y", "Ng??y", "Ti???n", df,PlotOrientation.VERTICAL,true,true,true);
        CategoryPlot plot=chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        ChartPanel chartPanel=new ChartPanel(chart);
        panel.removeAll();
        panel.add(chartPanel);
        panel.validate();
        doanhThu.setText(converter(tongDoanhThu));
}
void showTK_Thang(){
    DefaultCategoryDataset df=new DefaultCategoryDataset();
    Date dateBD=ngayBD_TK.getDate();
    Date dateKT=ngayKT_TK.getDate();
    int monthBD=month(dateBD);
    int monthKT=month(dateKT);
    ArrayList <Bill> listBill=new DAO().getListBillAll();
    int tien=0;
    int i=monthBD;
    int j=0;
    int pos=0;
    int tongDoanhThu=0;
    while(i<=monthKT){
        while(j<listBill.size()){
            int month=month(listBill.get(j).getDateCreate());
            if(month==i){
                tien+=listBill.get(j).getPayment();
                pos=j;
                tongDoanhThu+=listBill.get(j).getPayment();
            }
            j++;
        }
        df.addValue(tien,"","Th??ng "+i);
         tien=0;
         j=pos;
         i++;
    }
    JFreeChart chart=ChartFactory.createBarChart3D("Th???ng k?? doanh thu theo th??ng", "Th??ng", "Ti???n", df,PlotOrientation.VERTICAL,true,true,true);
        CategoryPlot plot=chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        ChartPanel chartPanel=new ChartPanel(chart);
        panel.removeAll();
        panel.add(chartPanel);
        panel.validate();
        doanhThu.setText(converter(tongDoanhThu));
}
void showTKDoanhThu_HK2(int year){
    DefaultCategoryDataset df=new DefaultCategoryDataset();
    ArrayList <Bill> listBill=new DAO().getListBillAll();
    int cost1=0,cost2=0,cost3=0,cost4=0,cost5=0;
        for(Bill x : listBill){
            Date d=new DAO().getDateCreate_Bill(x.getIDBill());
            if(year(d)==year){
            if(month(d)>=8&&month(d)<=12){
                if(month(d)==1){
                    cost1+=x.getPayment();
                }else if(month(d)==2){
                    cost2+=x.getPayment();
                }else if(month(d)==3){
                    cost3+=x.getPayment();
                }else if(month(d)==4){
                    cost4+=x.getPayment();
                }else if(month(d)==5){
                    cost5+=x.getPayment();
                }
            }
        }
        }
        if(cost1==0) JOptionPane.showMessageDialog(rootPane, "Kh??ng t???n t???i h??a ????n trong th???i gian n??y");
        else{
        df.setValue(cost1, "Amount", "Th??ng 1");
        df.setValue(cost2, "Amount", "Th??ng 2");
        df.setValue(cost3, "Amount", "Th??ng 3");
        df.setValue(cost4, "Amount", "Th??ng 4");
        df.setValue(cost5, "Amount", "Th??ng 5");
        JFreeChart lineChart=ChartFactory.createLineChart("Th???ng K?? Doanh Thu KTX","Th??ng","T???ng Ti???n",df, PlotOrientation.VERTICAL,false,true,false);
    CategoryPlot lineCate=lineChart.getCategoryPlot();
    lineCate.setBackgroundPaint(Color.white);
    LineAndShapeRenderer line=(LineAndShapeRenderer)lineCate.getRenderer();
    Color lineChartColor=new Color(204,0,51);
    line.setSeriesPaint(0, lineChartColor);
    ChartPanel charPanel=new ChartPanel(lineChart);
    panel.removeAll();
    panel.add(charPanel,BorderLayout.CENTER);
    panel.validate();
        }
}
void showTKDoanhThu_HK3(int year){
    DefaultCategoryDataset df=new DefaultCategoryDataset();
    ArrayList <Bill> listBill=new DAO().getListBillAll();
    int cost1=0,cost2=0,cost3=0,cost4=0,cost5=0;
        for(Bill x : listBill){
            Date d=new DAO().getDateCreate_Bill(x.getIDBill());
            if(year(d)==year){
            if(month(d)>=8&&month(d)<=12){
                if(month(d)==6){
                    cost1+=x.getPayment();
                }else if(month(d)==7){
                    cost2+=x.getPayment();
                }
            }
        }
        }
        if(cost1==0) JOptionPane.showMessageDialog(rootPane, "Kh??ng t???n t???i h??a ????n trong th???i gian n??y");
        else{
        df.setValue(cost1, "Amount", "Th??ng 6");
        df.setValue(cost2, "Amount", "Th??ng 7");
        JFreeChart lineChart=ChartFactory.createLineChart("Th???ng K?? Doanh Thu KTX","Th??ng","T???ng Ti???n",df, PlotOrientation.VERTICAL,false,true,false);
    CategoryPlot lineCate=lineChart.getCategoryPlot();
    lineCate.setBackgroundPaint(Color.white);
    LineAndShapeRenderer line=(LineAndShapeRenderer)lineCate.getRenderer();
    Color lineChartColor=new Color(204,0,51);
    line.setSeriesPaint(0, lineChartColor);
    ChartPanel charPanel=new ChartPanel(lineChart);
    panel.removeAll();
    panel.add(charPanel,BorderLayout.CENTER);
    panel.validate();
        }
}
void showTKDoanhThu_CaNam(int year){
    DefaultCategoryDataset df=new DefaultCategoryDataset();
    ArrayList <Bill> listBill=new DAO().getListBillAll();
    int cost1=0,cost2=0,cost3=0,cost4=0,cost5=0,cost6=0,cost7=0,cost8=0,cost9=0,cost10=0,cost11=0,cost12=0;
        for(Bill x : listBill){
            Date d=new DAO().getDateCreate_Bill(x.getIDBill());
            if(year(d)==year){
            if(month(d)>=8&&month(d)<=12){
                if(month(d)==1){
                    cost1+=x.getPayment();
                }else if(month(d)==2){
                    cost2+=x.getPayment();
                }else if(month(d)==3){
                    cost3+=x.getPayment();
                }else if(month(d)==4){
                    cost4+=x.getPayment();
                }else if(month(d)==5){
                    cost5+=x.getPayment();
                }else if(month(d)==6){
                    cost6+=x.getPayment();
                }else if(month(d)==7){
                    cost7+=x.getPayment();
                }else if(month(d)==8){
                    cost8+=x.getPayment();
                }else if(month(d)==9){
                    cost9+=x.getPayment();
                }else if(month(d)==10){
                    cost10+=x.getPayment();
                }else if(month(d)==11){
                    cost11+=x.getPayment();
                }else if(month(d)==12){
                    cost12+=x.getPayment();
                }
            }
        }
        }
        if(cost1==0&&cost2==0&&cost3==0&&cost4==0&&cost5==0&&cost6==0&&cost7==0&&cost8==0&&cost9==0&&cost10==0&&
                cost11==0&&cost12==0){
            JOptionPane.showMessageDialog(rootPane, "Kh??ng t???n t???i h??a ????n trong th???i gian n??y");
        }
        else{
        df.setValue(cost1, "Amount", "Th??ng 1");
        df.setValue(cost2, "Amount", "Th??ng 2");
        df.setValue(cost3, "Amount", "Th??ng 3");
        df.setValue(cost4, "Amount", "Th??ng 4");
        df.setValue(cost5, "Amount", "Th??ng 5");
        df.setValue(cost6,"Amount", "Th??ng 6");
        df.setValue(cost7, "Amount", "Th??ng 7");
        df.setValue(cost8, "Amount", "Th??ng 8");
        df.setValue(cost9, "Amount", "Th??ng 9");
        df.setValue(cost10, "Amount", "Th??ng 10");
        df.setValue(cost11, "Amount", "Th??ng 11");
        df.setValue(cost12, "Amount", "Th??ng 12");
        JFreeChart lineChart=ChartFactory.createLineChart("Th???ng K?? Doanh Thu KTX","Th??ng","T???ng Ti???n",df, PlotOrientation.VERTICAL,false,true,false);
    CategoryPlot lineCate=lineChart.getCategoryPlot();
    lineCate.setBackgroundPaint(Color.white);
    LineAndShapeRenderer line=(LineAndShapeRenderer)lineCate.getRenderer();
    Color lineChartColor=new Color(204,0,51);
    line.setSeriesPaint(0, lineChartColor);
    ChartPanel charPanel=new ChartPanel(lineChart);
    panel.removeAll();
    panel.add(charPanel,BorderLayout.CENTER);
    panel.validate();
        }
}
    void show3DChart(){
    ArrayList<Zone> list=new DAO().getListZone();
    DefaultCategoryDataset df=new DefaultCategoryDataset();
    for(Zone x:list){
        int amount=new DAO().amountOfNow_Zone(x.getNameZone());
        df.addValue(amount, "",x.getNameZone());
    }
        JFreeChart chart=ChartFactory.createBarChart3D("Th???ng k?? sinh vi??n theo khu", "T??n khu", "S??? l?????ng", df,PlotOrientation.VERTICAL,true,true,true);
        CategoryPlot plot=chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        
        ChartPanel chartPanel=new ChartPanel(chart);
        chart1.removeAll();
        chart1.add(chartPanel);
        chart1.validate();
}
void showAmountStudent_Type(){
    ArrayList<TypeRoom> list=new DAO().getListTypeRoom();
    DefaultCategoryDataset df=new DefaultCategoryDataset();
    for(TypeRoom r:list){
        int amount=new DAO().amountStudent_Type(r.getID());
        df.addValue(amount, r.getTypeOfRoom(),r.getTypeOfRoom());
    }
        JFreeChart chart=ChartFactory.createBarChart3D("Th???ng k?? sinh vi??n theo lo???i ph??ng", "Lo???i d???ch v???", "S??? l?????ng", df,PlotOrientation.VERTICAL,true,true,true);
        CategoryPlot plot=chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        
        ChartPanel chartPanel=new ChartPanel(chart);
        chart3.removeAll();
        chart3.add(chartPanel);
        chart3.validate();
}
void showLoaiPhong_Khu(String nameZone){
    ArrayList <TypeRoom> list=new DAO().getListTypeRoom();
    DefaultPieDataset bar=new DefaultPieDataset();
    for(TypeRoom t:list){
        int count=new DAO().count_TypeRoomInZone(nameZone, t.getID());
        bar.setValue(t.getTypeOfRoom(), count);
    }
    JFreeChart pieChart=ChartFactory.createPieChart("Th???ng k?? lo???i ph??ng trong t???ng khu", bar,false,true,false);
    ChartPanel barChanel=new ChartPanel(pieChart);
    chart2.removeAll();
    chart2.add(barChanel,BorderLayout.CENTER);
    chart2.validate();
}
    void showTT_Bill(){
        String date=(String)tableDuyet.getValueAt(tableDuyet.getSelectedRow(),5);
        String idsv=(String)tableDuyet.getValueAt(tableDuyet.getSelectedRow(),2);
        Date d=null;
        try {
            d=df.parse(date);
        } catch (Exception e) {
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String dateC=sdf.format(d);
        Bill b=new DAO().getBill(dateC, idsv);
        idBill.setText(String.valueOf(b.getIDBill()));
        dateCr.setText(df.format(b.getDateCreate()));
        roomB.setText(new DAO().nameRoom(idsv));
        contentB.setText(b.getNoiDung());
        hocKyB.setText(b.getSemester());
        tongTienB.setText(converter(b.getPayment()));
        mssvB.setText(b.getIDStudent());
    }
    public static String converter(int n){
           String data = String.valueOf(n);
           char[] arrData = data.toCharArray();
           String result = "";
           int length = arrData.length;
           int count =1;
           for(int i=length-1;i>=0;i--){
               result+=arrData[i];
              if(count++ == 3){
                  if(i!=0){
                  result+='.';
                  count=1;
                  }
              }
           }
           String finalResult = "";
           char[] resultData = result.toCharArray();
           for(int i=resultData.length-1;i>=0;i--){
               finalResult += resultData[i];
           }           
           return finalResult;
    }
    void setIcon_1Star(JLabel lb1,JLabel lb2,JLabel lb3, JLabel lb4,JLabel lb5){
      ImageIcon icon=new ImageIcon("D:\\imagesProject\\icons8_star_20px_1.png");
      ImageIcon icon2=new ImageIcon("D:\\imagesProject\\icons8_star_20px.png");
      lb1.setIcon(icon);
      lb2.setIcon(icon2);
      lb3.setIcon(icon2);
      lb4.setIcon(icon2);
      lb5.setIcon(icon2);
    }
    void setIcon_2Star(JLabel lb1,JLabel lb2,JLabel lb3, JLabel lb4,JLabel lb5){
      ImageIcon icon=new ImageIcon("D:\\imagesProject\\icons8_star_20px_1.png");
      ImageIcon icon2=new ImageIcon("D:\\imagesProject\\icons8_star_20px.png");
      lb1.setIcon(icon);
      lb2.setIcon(icon);
      lb3.setIcon(icon2);
      lb4.setIcon(icon2);
      lb5.setIcon(icon2);
    }
    void setIcon_3Star(JLabel lb1,JLabel lb2,JLabel lb3, JLabel lb4,JLabel lb5){
      ImageIcon icon=new ImageIcon("D:\\imagesProject\\icons8_star_20px_1.png");
      ImageIcon icon2=new ImageIcon("D:\\imagesProject\\icons8_star_20px.png");
      lb1.setIcon(icon);
      lb2.setIcon(icon);
      lb3.setIcon(icon);
      lb4.setIcon(icon2);
      lb5.setIcon(icon2);
    }
    void setIcon_4Star(JLabel lb1,JLabel lb2,JLabel lb3, JLabel lb4,JLabel lb5){
      ImageIcon icon=new ImageIcon("D:\\imagesProject\\icons8_star_20px_1.png");
      ImageIcon icon2=new ImageIcon("D:\\imagesProject\\icons8_star_20px.png");
      lb1.setIcon(icon);
      lb2.setIcon(icon);
      lb3.setIcon(icon);
      lb4.setIcon(icon);
      lb5.setIcon(icon2);
    }
    void setIcon_5Star(JLabel lb1,JLabel lb2,JLabel lb3, JLabel lb4,JLabel lb5){
      ImageIcon icon=new ImageIcon("D:\\imagesProject\\icons8_star_20px_1.png");
      ImageIcon icon2=new ImageIcon("D:\\imagesProject\\icons8_star_20px.png");
      lb1.setIcon(icon);
      lb2.setIcon(icon);
      lb3.setIcon(icon);
      lb4.setIcon(icon);
      lb5.setIcon(icon);
    }
    boolean addHDRe(Bill b){
        String idsv=(String)request_Table.getValueAt(request_Table.getSelectedRow(),1);
        ArrayList<Bill>list=new DAO().getListBillAll();
        ArrayList <Bill> listB=new DAO().getListBill(idsv);
        int size=list.size();
        b.setIDBill(++size);
        b.setIDStaff(new DangNhap().IDUs);
        b.setStatus("???? thanh to??n");
        Date d=null;
        try {
            d=df.parse(ngayChi_HDR.getText());
        } catch (Exception e) {
        }
        b.setDateCreate(d);
        b.setIDStudent(idsv);
        b.setNoiDung(noiDungChi_HDR.getText());
        b.setTypeBill("l??? ph?? ph??t sinh");
        b.setSemester(listB.get(listB.size()-1).getSemester());
        b.setPayment(Integer.valueOf(tienChi_HDR.getText()));
        if(new DAO().addBill(b)) return true;
        return false;
    }
    boolean update_Request(){
        DefaultTableModel dfm=(DefaultTableModel)request_Table.getModel();
        String noiDung=(String)request_Table.getValueAt(request_Table.getSelectedRow(),4);
        String idsv=(String)request_Table.getValueAt(request_Table.getSelectedRow(),1);
         String status="";
        boolean check=false;
        if(s_check1.isSelected()||s_check2.isSelected()||s_check3.isSelected()){
            if(s_check1.isSelected()){
                check=true;
                status=s_check1.getText();
            }else if(s_check2.isSelected()){
                check=true;
                status=s_check2.getText();
            }else if(s_check3.isSelected()){
                check=true;
                status=s_check3.getText();
            }
        }else if(s_check4.isSelected()){
            if(s_text.getText().equals("")) JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh???p th??ng tin tr???ng th??i");
            else{
                check=true;
                status=s_text.getText();
            }
        }else {
            JOptionPane.showMessageDialog(rootPane, "Vui l??ng ch???n tr???ng th??i ????? c???p nh???t");
             check=false;
             status="";
        }
        if(check&&!status.equals("")){
            int x=JOptionPane.showConfirmDialog(rootPane, "X??c nh???n c???p nh???t tr???ng th??i?");
            if(x==JOptionPane.YES_OPTION){
            if(update_StatusRequest(status, noiDung, idsv)) return true;
            }
        }
        return false;
    }
    boolean update_StatusRequest(String status,String noiDung,String idsv){
        if(new DAO().update_StatusRequest(noiDung, idsv,status)) return true;
        return false;
    }
    
    boolean thanhToan_HDDN(){
    int month=(int) HDDN_Table.getValueAt(HDDN_Table.getSelectedRow(),1);
    int year=(int) HDDN_Table.getValueAt(HDDN_Table.getSelectedRow(),2);
    String room=phong_HDDN1.getText();
    if(new DAO().update_StatusHDDN(room, month, year)) return true;
    return false;
}
    void showTT_HeadIndex(){
        ArrayList<HDDienNuoc> listHD=new DAO().getListHDDienNuoc_NameRoom(phong_HDDN.getText());
        boolean check=false;
        if(!(thangChot.getText().equals("")&&namChot.getText().equals(""))){
            int thangC=0,namC=0;
            if(!thangChot.getText().equals(""))
            {
                thangC=Integer.valueOf(thangChot.getText());
            }
            if(!namChot.getText().equals("")){
                namC=Integer.valueOf(namChot.getText());
            }
            int thang=0,nam=0;
            if(thangC>=2&&thangC<=12){
                thang=thangC-1;
                nam=namC;
            }
            else if(thangC==1){
                thang=12;
                nam=namC-1;
            }
            for(int i=0;i<listHD.size();i++){
                if(listHD.get(i).getMonth()==thang&&listHD.get(i).getYear()==nam){
                    check=true;
                    headIndex.setText(String.valueOf(listHD.get(i).getLastIndexE()));
                }
            }
        }
        if(check==false) headIndex.setText("");
    }
public boolean checkDateFormat(String date){
    String check="\\d{1,2}/\\d{1,2}/\\d{4}";
    if(date.matches(check)) return true;
    else return false;
}
    boolean checkDuplicate_HDDN(){
        ArrayList<HDDienNuoc> listHD=new DAO().getListHDDienNuoc_NameRoom(phong_HDDN.getText());
        int thangC=0,namC=0;
        if(!thangChot.getText().equals(""))
         {
              thangC=Integer.valueOf(thangChot.getText());
         }
          if(!namChot.getText().equals("")){
              namC=Integer.valueOf(namChot.getText());
          } 
        for(HDDienNuoc hd:listHD){
            if(thangC==hd.getMonth()&&namC==hd.getYear()) return true;
        }
        return false;
    }
 void showTable_DuyetDon(DefaultTableModel mod){
     ArrayList <Student>list=new DAO().getListStudent_DuyetDon();
     for(Student s:list){
         Date d=new DAO().startDate(s.getMssv());
         String room=new DAO().nameRoom(s.getMssv());
         mod.addRow(new Object[]{
             mod.getRowCount()+1,s.getHoTen(),s.getMssv(),s.getLop(),s.getNganh(),df.format(d),room,"??ang ?????i duy???t"
         });
     }
 }
    void showTT_NgayChot(){
     if(!(thangChot.getText().equals("")&&namChot.getText().equals(""))){
         int thangC=0,namC=0;
         if(!thangChot.getText().equals(""))
         {
              thangC=Integer.valueOf(thangChot.getText());
         }
          if(!namChot.getText().equals("")){
              namC=Integer.valueOf(namChot.getText());
          }          
         if(namC>=2021&&namC<=2025){
         if(thangC==2){
         ngayChot.setText("28"+"/0"+thangChot.getText()+"/"+namChot.getText());
         }
         else if(thangC==1||thangC==3||thangC==5||thangC==7||thangC==8){
             ngayChot.setText("31"+"/0"+thangChot.getText()+"/"+namChot.getText());
         }
         else if(thangC==10||thangC==12){
             ngayChot.setText("31"+"/"+thangChot.getText()+"/"+namChot.getText());
         }
         else if(thangC==4||thangC==6||thangC==9){
             ngayChot.setText("30"+"/0"+thangChot.getText()+"/"+namChot.getText());
         }
         else if(thangC==11){
              ngayChot.setText("30"+"/"+thangChot.getText()+"/"+namChot.getText());
         }
         else {
             ngayChot.setText("");
         }
         }
         else{
             ngayChot.setText(" ");
         }
     }
      if(thangChot.getText().equals("")||namChot.getText().equals("")){
          ngayChot.setText(" ");
      }
 }
    void showTable_HDDN(DefaultTableModel mod){
        ArrayList<HDDienNuoc> listHD=new DAO().getListHDDienNuoc_NameRoom(phong_HDDN1.getText());
        for(HDDienNuoc hd:listHD){
            mod.addRow(new Object[]{
                mod.getRowCount()+1,hd.getMonth(),hd.getYear(),hd.getHeadIndexE(),hd.getLastIndexE(),hd.getUseE(),hd.getTotalPayment(),hd.getStatus()
            });
        }
    }
    void setSize_DueytDon(){
        DefaultTableModel df=new DefaultTableModel();
        df=(DefaultTableModel) tableDuyet.getModel();
        tableDuyet.getColumnModel().getColumn(0).setPreferredWidth(20);
        tableDuyet.getColumnModel().getColumn(1).setPreferredWidth(100);
        tableDuyet.getColumnModel().getColumn(4).setPreferredWidth(125);
        DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        tableDuyet.getColumnModel().getColumn(0).setCellRenderer(r);
        tableDuyet.getColumnModel().getColumn(1).setCellRenderer(r);
        tableDuyet.getColumnModel().getColumn(2).setCellRenderer(r);
        tableDuyet.getColumnModel().getColumn(3).setCellRenderer(r);
        tableDuyet.getColumnModel().getColumn(4).setCellRenderer(r);
        tableDuyet.getColumnModel().getColumn(5).setCellRenderer(r);
        tableDuyet.getColumnModel().getColumn(6).setCellRenderer(r);
        tableDuyet.getColumnModel().getColumn(7).setCellRenderer(r);
        JTableHeader t=tableDuyet.getTableHeader();
        t.setFont(new Font("Segoe UI",Font.BOLD,12));
        ((DefaultTableCellRenderer)t.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);  
    }
    void setSize_RoomDky(){
        DefaultTableModel df=(DefaultTableModel) roomTable1.getModel();
        JTableHeader t=roomTable1.getTableHeader();
        DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        roomTable1.getColumnModel().getColumn(0).setCellRenderer(r);
        roomTable1.getColumnModel().getColumn(1).setCellRenderer(r);
        roomTable1.getColumnModel().getColumn(2).setCellRenderer(r);
        roomTable1.getColumnModel().getColumn(3).setCellRenderer(r);
        roomTable1.getColumnModel().getColumn(4).setCellRenderer(r);
        roomTable1.getColumnModel().getColumn(5).setCellRenderer(r);
        roomTable1.getColumnModel().getColumn(6).setCellRenderer(r);
        roomTable1.getColumnModel().getColumn(7).setCellRenderer(r);
        t.setFont(new Font("Segoe UI",Font.BOLD,12));
        ((DefaultTableCellRenderer)t.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        roomTable1.getColumnModel().getColumn(0).setPreferredWidth(25);
    }
    void setSize_RoomTT(){
        DefaultTableModel df=(DefaultTableModel) roomTable2.getModel();
        JTableHeader t=roomTable2.getTableHeader();
        DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        roomTable2.getColumnModel().getColumn(0).setCellRenderer(r);
        roomTable2.getColumnModel().getColumn(1).setCellRenderer(r);
        roomTable2.getColumnModel().getColumn(2).setCellRenderer(r);
        roomTable2.getColumnModel().getColumn(3).setCellRenderer(r);
        roomTable2.getColumnModel().getColumn(4).setCellRenderer(r);
        roomTable2.getColumnModel().getColumn(5).setCellRenderer(r);
        roomTable2.getColumnModel().getColumn(6).setCellRenderer(r);
        roomTable2.getColumnModel().getColumn(7).setCellRenderer(r);
        t.setFont(new Font("Segoe UI",Font.BOLD,12));
        ((DefaultTableCellRenderer)t.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        roomTable2.getColumnModel().getColumn(0).setPreferredWidth(25);
    }
    void setSize_DichVu(){
        DefaultTableModel df=(DefaultTableModel) typeTable.getModel();
        JTableHeader t=typeTable.getTableHeader();
         t.setFont(new Font("Segoe UI",Font.BOLD,12));
          ((DefaultTableCellRenderer)t.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
         typeTable.getColumnModel().getColumn(0).setPreferredWidth(25);
         typeTable.getColumnModel().getColumn(2).setPreferredWidth(100);
         typeTable.getColumnModel().getColumn(3).setPreferredWidth(50);
         DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        typeTable.getColumnModel().getColumn(0).setCellRenderer(r);
        typeTable.getColumnModel().getColumn(1).setCellRenderer(r);
        typeTable.getColumnModel().getColumn(2).setCellRenderer(r);
        typeTable.getColumnModel().getColumn(3).setCellRenderer(r);
    }
    void setSize_Zone(){
        //DefaultTableModel df=(DefaultTableModel) zoneTable.getModel();
        JTableHeader t=zoneTable.getTableHeader();
        t.setFont(new Font("Segoe UI",Font.BOLD,12));
        ((DefaultTableCellRenderer)t.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        zoneTable.getColumnModel().getColumn(0).setCellRenderer(r);
        zoneTable.getColumnModel().getColumn(1).setCellRenderer(r);
        zoneTable.getColumnModel().getColumn(2).setCellRenderer(r);
        zoneTable.getColumnModel().getColumn(3).setCellRenderer(r);
        zoneTable.getColumnModel().getColumn(4).setCellRenderer(r);
        zoneTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        zoneTable.getColumnModel().getColumn(3).setPreferredWidth(5);
        zoneTable.getColumnModel().getColumn(1).setPreferredWidth(5);  
    }
    void setSize_Student(){
      JTableHeader t=studentTable.getTableHeader();
      t.setFont(new Font("Segoe UI",Font.BOLD,12));  
      ((DefaultTableCellRenderer)t.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
      DefaultTableCellRenderer r=new DefaultTableCellRenderer();
      r.setHorizontalAlignment(JLabel.CENTER);
      studentTable.getColumnModel().getColumn(0).setCellRenderer(r);
      studentTable.getColumnModel().getColumn(1).setCellRenderer(r);
      studentTable.getColumnModel().getColumn(2).setCellRenderer(r);
      studentTable.getColumnModel().getColumn(3).setCellRenderer(r);
      studentTable.getColumnModel().getColumn(4).setCellRenderer(r);
      studentTable.getColumnModel().getColumn(5).setCellRenderer(r);
      studentTable.getColumnModel().getColumn(0).setPreferredWidth(5);
      studentTable.getColumnModel().getColumn(5).setPreferredWidth(30);
    }
    void setSize_Contract(){
        JTableHeader t=contractTable.getTableHeader();
      t.setFont(new Font("Segoe UI",Font.BOLD,12));  
      ((DefaultTableCellRenderer)t.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
      DefaultTableCellRenderer r=new DefaultTableCellRenderer();
      r.setHorizontalAlignment(JLabel.CENTER);
      contractTable.getColumnModel().getColumn(0).setCellRenderer(r);
      contractTable.getColumnModel().getColumn(1).setCellRenderer(r);
      contractTable.getColumnModel().getColumn(2).setCellRenderer(r);
      contractTable.getColumnModel().getColumn(3).setCellRenderer(r);
      contractTable.getColumnModel().getColumn(4).setCellRenderer(r);
      contractTable.getColumnModel().getColumn(5).setCellRenderer(r);
      contractTable.getColumnModel().getColumn(6).setCellRenderer(r);
      contractTable.getColumnModel().getColumn(0).setPreferredWidth(1);
      contractTable.getColumnModel().getColumn(1).setPreferredWidth(1);
      contractTable.getColumnModel().getColumn(5).setPreferredWidth(1);
    }
    
    void setSize_HDDien(){
        DefaultTableModel df=(DefaultTableModel) roomTable_HDDN.getModel();
        JTableHeader t=roomTable_HDDN.getTableHeader();
        DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        roomTable_HDDN.getColumnModel().getColumn(0).setCellRenderer(r);
        roomTable_HDDN.getColumnModel().getColumn(1).setCellRenderer(r);
        roomTable_HDDN.getColumnModel().getColumn(2).setCellRenderer(r);
        roomTable_HDDN.getColumnModel().getColumn(3).setCellRenderer(r);
        roomTable_HDDN.getColumnModel().getColumn(4).setCellRenderer(r);
        roomTable_HDDN.getColumnModel().getColumn(5).setCellRenderer(r);
        roomTable_HDDN.getColumnModel().getColumn(6).setCellRenderer(r);
        roomTable_HDDN.getColumnModel().getColumn(7).setCellRenderer(r);
        t.setFont(new Font("Segoe UI",Font.BOLD,12));
        ((DefaultTableCellRenderer)t.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        roomTable_HDDN.getColumnModel().getColumn(0).setPreferredWidth(5);
    }
    void setSize_TTDien(){
        JTableHeader t=HDDN_Table.getTableHeader();
        DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        HDDN_Table.getColumnModel().getColumn(0).setCellRenderer(r);
        HDDN_Table.getColumnModel().getColumn(1).setCellRenderer(r);
        HDDN_Table.getColumnModel().getColumn(2).setCellRenderer(r);
        HDDN_Table.getColumnModel().getColumn(3).setCellRenderer(r);
        HDDN_Table.getColumnModel().getColumn(4).setCellRenderer(r);
        HDDN_Table.getColumnModel().getColumn(5).setCellRenderer(r);
        HDDN_Table.getColumnModel().getColumn(6).setCellRenderer(r);
        HDDN_Table.getColumnModel().getColumn(7).setCellRenderer(r);
        t.setFont(new Font("Segoe UI",Font.BOLD,12));
        ((DefaultTableCellRenderer)t.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        HDDN_Table.getColumnModel().getColumn(0).setPreferredWidth(30);
        HDDN_Table.getColumnModel().getColumn(1).setPreferredWidth(40);
        HDDN_Table.getColumnModel().getColumn(2).setPreferredWidth(40);
        HDDN_Table.getColumnModel().getColumn(3).setPreferredWidth(50);
        HDDN_Table.getColumnModel().getColumn(4).setPreferredWidth(50);
        HDDN_Table.getColumnModel().getColumn(5).setPreferredWidth(60);
        HDDN_Table.getColumnModel().getColumn(6).setPreferredWidth(60);
    }
    void setSize_Request(){
        JTableHeader t=request_Table.getTableHeader();
        DefaultTableCellRenderer r=new DefaultTableCellRenderer();
         r.setHorizontalAlignment(JLabel.CENTER);
        t.setFont(new Font("Segoe UI",Font.BOLD,12));
        ((DefaultTableCellRenderer)t.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        request_Table.getColumnModel().getColumn(0).setCellRenderer(r);
        request_Table.getColumnModel().getColumn(1).setCellRenderer(r);
        request_Table.getColumnModel().getColumn(2).setCellRenderer(r);
        request_Table.getColumnModel().getColumn(3).setCellRenderer(r);
        request_Table.getColumnModel().getColumn(4).setCellRenderer(r);
        request_Table.getColumnModel().getColumn(5).setCellRenderer(r);
        request_Table.getColumnModel().getColumn(0).setPreferredWidth(5);
        request_Table.getColumnModel().getColumn(2).setPreferredWidth(5);
        request_Table.getColumnModel().getColumn(3).setPreferredWidth(10);
        
    }
boolean addTT_HDDN(HDDienNuoc hd){
     ArrayList<HDDienNuoc> listHD=new DAO().getListHDDienNuoc();
     int size=listHD.size();
     hd.setIDHD(++size);
     Date d=null;
     try {
         d=df.parse(ngayChot.getText());
     } catch (Exception e) {
     }
     hd.setClosingDate(d);
     hd.setHeadIndexE(Integer.valueOf(headIndex.getText()));
     hd.setLastIndexE(Integer.valueOf(lastIndex.getText()));
     hd.setUseE(Integer.valueOf(useE.getText()));
     hd.setCostE(Integer.valueOf(tienToInt(tongTien_chuaVAT.getText())));
     hd.setTotalPayment(Integer.valueOf(tienToInt(tongtien_VAT.getText())));
     hd.setStatus("Ch??a thanh to??n");
     hd.setMonth(Integer.valueOf(thangChot.getText()));
     hd.setYear(Integer.valueOf(namChot.getText()));
     hd.setIDRoom(phong_HDDN.getText());
     hd.setIdStaff(new DangNhap().IDUs);
     if(new DAO().addHDDN(hd)) return true;
     else return false;
 }
int tienToInt(String tien){
    String arr[]=tien.split("\\.");
    int a=0;
    String result="";
    for(int i=0;i<arr.length;i++){
        result+=arr[i];
    }
    a=Integer.valueOf(result);
    return a;
}
    void showTT_TienDien(){
        int soDien=0;
        if(!useE.getText().equals("")){
            soDien=Integer.valueOf(useE.getText());
        }
        int soTien=0;
        int soTien1=83900;
        int soTien2=86700;
        int soTien3=201400;
        int soTien4=253600;
        int soTien5=283400;
        int soTien6=0;
        if(soDien<=50){
                soTien1=soDien*1678;
                bac1.setText(converter(soTien1)+" ??");
                bac2.setText(String.valueOf(0));
                bac3.setText(String.valueOf(0));
                bac4.setText(String.valueOf(0));
                bac5.setText(String.valueOf(0));
                bac6.setText(String.valueOf(0));
                soTien=soTien1;
            }
            else if(soDien<=100){
                soTien2=(soDien-50)*1734;
                bac1.setText(converter(soTien1)+" ??");
                bac2.setText(converter(soTien2)+" ??");
                bac3.setText(String.valueOf(0));
                bac4.setText(String.valueOf(0));
                bac5.setText(String.valueOf(0));
                bac6.setText(String.valueOf(0));
                soTien=soTien1+soTien2;
            }
            else if(soDien<=200){
                soTien3=(soDien-100)*2014;
                bac1.setText(converter(soTien1)+" ??");
                bac2.setText(converter(soTien2)+" ??");
                bac3.setText(converter(soTien3)+" ??");
                bac4.setText("0");
                bac5.setText("0");
                bac6.setText("0");
                soTien=soTien1+soTien2+soTien3;
            }
            else if(soDien<=300){
                soTien4=(soDien-200)*2536;
                bac1.setText(converter(soTien1)+" ??");
                bac2.setText(converter(soTien2)+" ??");
                bac3.setText(converter(soTien3)+" ??");
                bac4.setText(converter(soTien4)+" ??");
                bac5.setText("0");
                bac6.setText("0");
                soTien=soTien1+soTien2+soTien3+soTien4;
            }
            else if(soDien<=400){
                soTien5=(soDien-300)*2834;
                bac1.setText(converter(soTien1)+" ??");
                bac2.setText(converter(soTien2)+" ??");
                bac3.setText(converter(soTien3)+" ??");
                bac4.setText(converter(soTien4)+" ??");
                bac5.setText(converter(soTien5)+" ??");
                bac6.setText("0");
                soTien=soTien1+soTien2+soTien3+soTien4+soTien5;
            }
             else if(soDien>400){
                 soTien6=(soDien-400)*2927;
                 bac1.setText(converter(soTien1)+" ??");
                 bac2.setText(converter(soTien2)+" ??");
                 bac3.setText(converter(soTien3)+" ??");
                 bac4.setText(converter(soTien4)+" ??");
                 bac5.setText(converter(soTien5)+" ??");
                 bac6.setText(converter(soTien6)+" ??");
                 soTien=soTien1+soTien2+soTien3+soTien4+soTien5+soTien6;
            }
        tongTien_chuaVAT.setText(converter(soTien));
        int tienVAT=(soTien*10)/100;
        VAT.setText(converter(tienVAT));
        int tongTien=tienVAT+soTien;
        tongtien_VAT.setText(converter(tongTien));
        d1.setVisible(true);
        d2.setVisible(true);
        d3.setVisible(true);
    }
    void resetTT_HDDN(){
        bac1.setText(" ");
        bac2.setText(" ");
        bac3.setText(" ");
        bac4.setText(" ");
        bac5.setText(" ");
        bac6.setText(" ");
        tongTien_chuaVAT.setText(" ");
        VAT.setText(" ");
        tongtien_VAT.setText(" ");
        d1.setVisible(false);
        d2.setVisible(false);
        d3.setVisible(false);
    }
    boolean addBill_ChuyenPhong(Bill b){
     ArrayList <Bill> listB=new DAO().getListBill(mssv_HD.getText());
     ArrayList<Bill> listAll=new DAO().getListBillAll();
    int size=listAll.size();
    b.setIDBill(++size);
    b.setIDStaff(new DangNhap().IDUs);
    Date d=new Date();
    b.setDateCreate(d);
    b.setIDStudent(mssv_HD.getText());
    b.setNoiDung("Chuy???n t??? "+phong_HD.getText()+" sang ph??ng "+phong_CP.getText()+" v??o ng??y "+df.format(d));
    b.setTypeBill("Chuy???n Ph??ng");
    b.setSemester(listB.get(listB.size()-1).getSemester());
    //int tien=Integer.valueOf(tien_CP.getText());
    if(tt_CP.getText().equals("S??? ti???n ph???i tr??? l???i(???? bao g???m ph?? CP):")){
        b.setStatus("???? ho??n tr???");
        b.setPayment(-tienToInt(tien_CP.getText()));
    }
    else if(tt_CP.getText().equals("Thanh to??n th??m(???? bao g???m ph?? CP):"))
    {
        b.setStatus("???? thanh to??n");
        b.setPayment(tienToInt(tien_CP.getText()));
    }
    else{
        b.setStatus("???? thanh to??n");
        b.setPayment(tienToInt(tien_CP.getText()));
    }
    if(new DAO().addBill(b)){
        return true;
    }
    return false;
 }
 void resetTT_Contract(){
     maHD.setText(" ");
     ten_HD.setText(" ");
     lop_HD.setText(" ");
     nganh_HD.setText(" ");
     mssv_HD.setText(" ");
     phong_HD.setText(" ");
     ngayBD_HD.setText(" ");
     ngayKT_HD.setText(" ");
     phong_CP.setText("");
     tt_CP.setText(" ");
     tien_CP.setText(" ");
     tien_CP1.setVisible(false);
     noiDung_HD.setText("");
     tongTien_HD.setText("");
     dong_CT.setVisible(false);
     DefaultTableModel dfm=(DefaultTableModel)contractTable.getModel();
     removeTable(dfm);
     showTable_Contract();
 }
 void update_Payment(String idsv){
     int month=0;
     month =new DAO().getAmoutOfMonth(mssv_HD.getText());
     int giaPhongCu=month*new DAO().getCost_NameRoom(phong_HD.getText());
     int giaPhongMoi=month*new DAO().getCost_NameRoom(phong_CP.getText());
     int tien=giaPhongCu-giaPhongMoi-50000;
     if(tien==-50000){
    new DAO().updateContract_Payment(idsv,50000);
     }
     else if(tien>50000){
         new DAO().updateContract_Payment(idsv,-tien);
     }
     else if(tien<0){
         new DAO().updateContract_Payment(idsv,-tien);
     }
      
 }
 public void showTT_CP(){
    int month=0;
    Date d=new Date();
    Date finishDate=new DAO().finishDate(mssv_HD.getText());
    int monthFinish=month(finishDate);
    month=month(d);
    if(monthFinish==12){
        if(month>=8){
            month=12-month+1;
        }
    }else if(monthFinish==5){
        if(month>=8){
            month=12-month+6;
        }else if(month<=5){
            month=5-month+1;
        }
    }else if(monthFinish==7){
        if(month>=8){
            month=12-month+8;
        }else if(month<=7){
            month=7-month+1;
        }
    }
    int giaPhongCu=month*new DAO().getCost_NameRoom(phong_HD.getText());
    int giaPhongMoi=month*new DAO().getCost_NameRoom(phong_CP.getText());
    int tien=giaPhongCu-giaPhongMoi-50000;
    if(tien>50000){
        tt_CP.setText("S??? ti???n ph???i tr??? l???i(???? bao g???m ph?? CP):");       
        tien_CP.setText(converter(tien));
    }
    else if(tien<0){
        tt_CP.setText("Thanh to??n th??m(???? bao g???m ph?? CP):");
        tien_CP.setText(converter(-tien));
    }
    else if(tien==50000){
        tt_CP.setText("Tr??? th??m l??? ph?? CP:");
        tien_CP.setText("50.000");
    }
}
    boolean addBill_Card4(Bill b){
        ArrayList<Bill>list=new DAO().getListBillAll();
        int size=list.size();
        b.setIDBill(++size);
        b.setIDStaff(new DangNhap().IDUs);
        b.setStatus("???? thanh to??n");
        Date d=new Date();
        b.setDateCreate(d);
        b.setIDStudent(mssv_HD.getText());
        b.setNoiDung("Gia h???n KTX t??? "+ngayKT_HD1.getText()+" ?????n "+ngayKT_HD2.getText());
        b.setTypeBill("Gia h???n");
        b.setSemester((String)kiGH_HD.getSelectedItem());
        b.setPayment(Integer.valueOf(tienToInt(tongTien_GH.getText())));
        if(new DAO().addBill(b)){
            return true;
        }
        return false;
    }
    
    public void setData(int sex, String zone, int typeRoom){
        roomComboBox.removeAllItems();
        ArrayList<Room> arr = new DAO().getDataRoom(sex, zone, typeRoom);
        for (Room room: arr){
            roomComboBox.addItem(room.getNameRoom());
        }
    }
 boolean checkTT_addRoom(String room){
     listRoom=new DAO().getListRoom();
     for(Room r:listRoom){
         if(r.getIDRoom().equals(room)){
             return true;
         }
     }
     return false;
 }
 int i=0;
 void removeTable(DefaultTableModel mod){
     int count=mod.getRowCount();
     for(int i=count-1;i>=0;i--){
         mod.removeRow(i);
     }
 }
 void removeTable_Rqquest(){
     DefaultTableModel dfm=(DefaultTableModel)request_Table.getModel();
     int count=dfm.getRowCount();
     ArrayList<Request> list =new DAO().getListRequest_All();
     for(int i=list.size()-1;i>=0;i--){
         dfm.removeRow(i);
     }
 }
 void showTable(DefaultTableModel mod){
     String typeRoom="";
     int gia=0;
     listRoom=new DAO().getListRoom();
     for(Room r:listRoom){
         mod.addRow(new Object[]{
             mod.getRowCount()+1,r.getNameRoom(),r.getMax(),r.getAmountOfNow(),
             typeRoom=new DAO().typeRoom(r.getNameRoom()),r.getIDZone()
                 ,gia=new DAO().costRoom(r.getNameRoom()),r.getStatus()
         });
     }
 }
 public void showTable3(int idSex,DefaultTableModel mod){
     String typeRoom="";
     int gia=0;
    ArrayList<Room> list=new DAO().getListRoom4(idSex);
     for(Room r:list){
         mod.addRow(new Object[]{
             mod.getRowCount()+1,r.getNameRoom(),r.getMax(),r.getAmountOfNow(),
             typeRoom=new DAO().typeRoom(r.getNameRoom()),r.getIDZone()
                 ,gia=new DAO().costRoom(r.getNameRoom()),r.getStatus()
         });
     }
 }
 void showTable_TrangThai(String status,DefaultTableModel mod){
     String typeRoom="";
     int gia=0;
    ArrayList<Room> list=new DAO().getListRoom_Status(status);
    for(Room r:list){
         mod.addRow(new Object[]{
             mod.getRowCount()+1,r.getNameRoom(),r.getMax(),r.getAmountOfNow(),
             typeRoom=new DAO().typeRoom(r.getNameRoom()),r.getIDZone()
                 ,gia=new DAO().costRoom(r.getNameRoom()),r.getStatus()
         });
     }
 }
 int j=0;
 void showTable_Zone(DefaultTableModel mod,JComboBox combo){
     String zoneValue=(String)combo.getSelectedItem();
     ArrayList<Room> listR=new DAO().getListRoom_Zone(zoneValue);
     int count=mod.getRowCount();
     for(int i=count-1;i>=0;i--){
         mod.removeRow(i);
     }
     String typeRoom="";
     int gia=0;
     for(Room r:listR){
         mod.addRow(new Object[]{
             mod.getRowCount()+1,r.getNameRoom(),r.getMax(),r.getAmountOfNow(),
             typeRoom=new DAO().typeRoom(r.getNameRoom()),r.getIDZone()
                 ,gia=new DAO().costRoom(r.getNameRoom()),r.getStatus()
         });
     }
 }
 void showTable_Zone(){
     DefaultTableModel mod=new DefaultTableModel();
     mod=(DefaultTableModel) zoneTable.getModel();
     String gioiTinh="";
     listZone=new DAO().getListZone();
     for(Zone z:listZone){
         mod.addRow(new Object[]{
             mod.getRowCount()+1,z.getNameZone(),z.getDescription(),
             gioiTinh=new DAO().gioiTinh_Zone(z.getNameZone()),z.getStatus()
         });
     }
 }
  void showTable_Zone_TT(String status){
     DefaultTableModel mod=new DefaultTableModel();
     mod=(DefaultTableModel) zoneTable.getModel();
     String gioiTinh="";
     listZone=new DAO().getListZone_Status(status);
     for(Zone z:listZone){
         mod.addRow(new Object[]{
             mod.getRowCount()+1,z.getNameZone(),z.getDescription(),
             gioiTinh=new DAO().gioiTinh_Zone(z.getNameZone()),z.getStatus()
         });
     }
 }

 void showTable_Type(){
     DefaultTableModel mod=new DefaultTableModel();
      mod=(DefaultTableModel) typeTable.getModel();
      listType=new DAO().getListTypeRoom();
      for(TypeRoom t:listType){
          mod.addRow(new Object[]{
              mod.getRowCount()+1,t.getTypeOfRoom(),t.getDescription(),t.getCost()
          });
      }
 }
 void showTable_Student(){
     ArrayList<Student>list=new DAO().getListStudent();
     String room="";
     for(Student s:list){
         modelCard3.addRow(new Object[]{
             modelCard3.getRowCount()+1,s.getHoTen(),s.getMssv(),s.getLop(),s.getNganh(),
             room=new DAO().nameRoom(s.getMssv())
         });
     }
 }
 void showTT_Student(String mssv){
     Student s=new DAO().getStudent(mssv);
     mssv_HD.setText(mssv);
     tenT.setText(s.getHoTen());
     lopT.setText(s.getLop());
     nganhT.setText(s.getNganh());
     sdtT.setText(s.getSdt());
     ngaySinhT.setText(df.format(s.getDateOfBirth()));
     emailT.setText(s.getEmail());
     diaChiT.setText(s.getAddress());
     quocTichT.setText(s.getQuocTich());
     tonGiaoT.setText(s.getTonGiao());
     danTocT.setText(s.getDanToc());
 }
 void showTT_Contract(String mssv){
     String nameSV=new DAO().nameSV(mssv),
             lop=new DAO().lopSV(mssv),
             nganh=new DAO().nganhSV(mssv);
     Contract c=new DAO().getContract(mssv);
     mssv_HD.setText(mssv);
     maHD.setText(String.valueOf(c.getIDContract()));
     ten_HD.setText(nameSV);
     lop_HD.setText(lop);
     nganh_HD.setText(nganh);
     phong_HD.setText(c.getIDRoom());
     ngayBD_HD.setText(df.format(c.getStartDay()));
     ngayKT_HD.setText(df.format(c.getFinishDay()));
     tongTien_HD.setText(converter(c.getPayment()));
     dong_CT.setVisible(true);
     ArrayList <Bill>listBill=new DAO().getListBill(mssv);
     String chuoi="";
     for(int i=0;i<listBill.size();i++){
         if(listBill.size()==1){
             noiDung_HD.setText(listBill.get(0).getNoiDung());
         }
         else{
             chuoi=chuoi+listBill.get(i).getNoiDung()+"\n";
             noiDung_HD.setText(chuoi);
         }
     }
 }
 void updateTT_Student(){
     SimpleDateFormat df1=new SimpleDateFormat("dd/MM/yyyy");
     Student s=new Student();
     s.setHoTen(tenT.getText());
     s.setLop(lopT.getText());
     s.setNganh(nganhT.getText());
     s.setSdt(sdtT.getText());
     Date d=null;
     try {
         d=df1.parse(ngaySinhT.getText());
     } catch (Exception e) {
     }
     s.setDateOfBirth((java.sql.Date) new java.sql.Date(d.getTime()));
     s.setEmail(emailT.getText());
     s.setAddress(diaChiT.getText());
     s.setQuocTich(quocTichT.getText());
     s.setTonGiao(tonGiaoT.getText());
     s.setDanToc(danTocT.getText());
     s.setMssv(mssvL.getText());
     if(new DAO().updateStudent(s)){
         xacNhanSV.setVisible(false);
         huySV.setVisible(false);
         chinhSuaSV.setVisible(true);
         setEdit_TTStudent(false);
         JOptionPane.showMessageDialog(rootPane, "C???p nh???t th??nh c??ng");
     }
     else{
         JOptionPane.showMessageDialog(rootPane, "C???p nh???t th???t b???i! Vui l??ng th??? l???i sau");
     }
 
 }
 int month(Date d){
        SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        String date=df.format(d);
        String arr[]=date.split("/");
        int month=Integer.valueOf(arr[1]);
        return month;
    }
int year(Date d){
        SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        String date=df.format(d);
        String arr[]=date.split("/");
        int year=Integer.valueOf(arr[2]);
        return year;
    }
int day(Date d){
    SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        String date=df.format(d);
        String arr[]=date.split("/");
        int day=Integer.valueOf(arr[0]);
        return day;
}
void setVisiCheckTT(){
    checkTen.setVisible(false);
    checkClass.setVisible(false);
    checkCMND.setVisible(false);
    checkEmail.setVisible(false);
    checkSDT.setVisible(false);
    checkMSSV.setVisible(false);
    jLabel23.setVisible(false);
    LinkedList <Contract> list=new LinkedList<Contract>();
}
void showTable_Contract(){
    modelCard4=(DefaultTableModel) contractTable.getModel();
    for(Contract c:listContract){
        modelCard4.addRow(new Object[]{
            modelCard4.getRowCount()+1,c.getIDContract(),c.getIDStudent(),df.format(c.getStartDay()),
            df.format(c.getFinishDay()),c.getIDRoom(),c.getPayment()
        });
    }
}
void showTable_Request(DefaultTableModel dfm){
    ArrayList<Request> listRequest=new DAO().getListRequest_All();
    for(Request r:listRequest){
        dfm.addRow(new Object[]{
            dfm.getRowCount()+1,r.getIDUs(),new DAO().nameRoom(r.getIDUs()),df.format(r.getDateRequest()),r.getNameRequest(),r.getStatus()
        });
    }
}

boolean checkMSSV(String mssv){
    
    String check="^N[0-9]{2}\\w{4}[0-9]{3}";
    if(mssv.matches(check)) return true;
    else return false;
}
public boolean checkLop(String chuoi){
    String check="^D[0-9]{2}\\w{4}[0-9]{2}-N";
    if(chuoi.matches(check)) return true;
    else return false;
}
public boolean checkCMND(String chuoi){
    String check="\\d{9}";
    if(chuoi.matches(check)) return true;
    else return false;
}
public boolean checkEmail(String chuoi){
    String check="^n[0-9]{2}\\w{4}[0-9]{3}@student.ptithcm.edu.vn";
    if(chuoi.matches(check)) return true;
    else return false;
}
public boolean checkSDT(String chuoi){
    String check="0\\d{9,10}";
    if(chuoi.matches(check)) return true;
    else return false;
}
boolean checkMSSV_Duplicate(String mssv){
    
    for(User u:listUser){
        if(u.getIDUs().equals(mssv))
            return false;
    }
    return true;
}
public boolean checkHoTen(String ten){
        String check="(\\w{2,10}\\s)+\\w{2,10}";
    if(ten.matches(check)) return true;
    else return false;
}
public String chuanHoa(String s) {
        s = s.trim();
        s = s.replaceAll("\\s+", " ");

        String a[] = s.split(" ");
        String kq = "";
        for (String x : a) {
            kq = kq + x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase();
            kq += " ";
        }
        kq = kq.trim();
        return kq;
    }
boolean checkThongTin(){
    boolean check1=false;
    boolean check2=false;
    boolean check3=false;
    boolean check4=false;
    boolean check5=false;
    boolean check6=false;
    boolean check7=false;
    if(checkMSSV(mssv.getText().toUpperCase())&&checkMSSV_Duplicate(mssv.getText().toUpperCase())){
        check1=true;
        checkMSSV.setVisible(false);
    }
    else checkMSSV.setVisible(true);
    if(checkLop(lop.getText().toUpperCase())){
        check2=true;
        checkClass.setVisible(false);
    }
    else checkClass.setVisible(true);
    if(checkCMND(cmnd.getText())){
        check3=true;
        checkCMND.setVisible(false);
    }
    else checkCMND.setVisible(true);
    if(checkEmail(email.getText().toLowerCase())){
        check4=true;
        checkEmail.setVisible(false);
    }
    else checkEmail.setVisible(true);
     if(checkSDT(sdt.getText())){
        check5=true;
        checkSDT.setVisible(false);
    }
    else checkSDT.setVisible(true);
//     if(checkHoTen(chuanHoa(hoTen.getText()))){
//        check6=true;
//        checkTen.setVisible(false);
//    }
//    else checkTen.setVisible(true);

     if(check1==true&&check2==true&&check3==true&&check4==true&&check5==true)
         return true;
     else return false;
}
boolean checkExist(String nameRoom){
    ArrayList <Room> list=new DAO().getListRoom();
    for(Room r:listRoom){
        if(nameRoom.equals(r.getIDRoom())) return true;
    }
    return false;
}
void search(String txt,JTable table){
        TableRowSorter<DefaultTableModel> sorter=new TableRowSorter<DefaultTableModel>(model);
        table.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(txt));
    }
void addItem_Zone(){
    listZone=new DAO().getListZone();
    for(Zone z:listZone){
        zoneSearch.addItem(z.getNameZone());
    }
}
String type(){
    String type="";
    if(typeRoomComboBox.getSelectedIndex()==0){
        type="d???ch v??? lo???i 1";
    }else if(typeRoomComboBox.getSelectedIndex()==1){
        type="d???ch v??? lo???i 2";
    }
    else if(typeRoomComboBox.getSelectedIndex()==2){
        type="th?????ng";
    }
    return type;
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable HDDN_Table;
    private javax.swing.JLabel VAT;
    private javax.swing.JCheckBox allRoom;
    private javax.swing.JCheckBox allZone;
    private javax.swing.JCheckBox baKiCheck;
    private javax.swing.JLabel bac1;
    private javax.swing.JLabel bac2;
    private javax.swing.JLabel bac3;
    private javax.swing.JLabel bac4;
    private javax.swing.JLabel bac5;
    private javax.swing.JLabel bac6;
    private javax.swing.JLabel back;
    private javax.swing.JLabel backF;
    private javax.swing.JButton cancel_HDR;
    private javax.swing.JButton cancel_s;
    private javax.swing.JLabel canhbao_HDDN;
    private javax.swing.JPanel card3;
    private javax.swing.JPanel card4;
    private javax.swing.JPanel card5;
    private javax.swing.JPanel card6;
    private javax.swing.JPanel card7;
    private javax.swing.JPanel card8;
    private javax.swing.JPanel cardIn1;
    private javax.swing.JPanel cardIn2;
    private javax.swing.JPanel cardRight;
    private javax.swing.JPanel carrdDuyet;
    private javax.swing.JPanel chart1;
    private javax.swing.JPanel chart2;
    private javax.swing.JPanel chart3;
    private javax.swing.JLabel checkCMND;
    private javax.swing.JLabel checkClass;
    private javax.swing.JLabel checkEmail;
    private javax.swing.JLabel checkLB;
    private javax.swing.JLabel checkMSSV;
    private javax.swing.JLabel checkSDT;
    private javax.swing.JLabel checkTen;
    private javax.swing.JButton chinhSuaSV;
    private javax.swing.JPanel chuyenPhongPanel;
    private javax.swing.JButton chuyenPhong_HD;
    private javax.swing.JTextField cmnd;
    private javax.swing.JButton confirm_s;
    private javax.swing.JLabel contentB;
    private javax.swing.JTextArea content_1;
    private javax.swing.JTextArea content_2;
    private javax.swing.JTable contractTable;
    private javax.swing.JButton createHDRe;
    private javax.swing.JLabel d1;
    private javax.swing.JLabel d2;
    private javax.swing.JLabel d3;
    private javax.swing.JTextField danToc;
    private javax.swing.JTextField danTocT;
    private javax.swing.JLabel dateCr;
    private javax.swing.JLabel date_1;
    private javax.swing.JLabel date_2;
    private javax.swing.JTextField diaChi;
    private javax.swing.JTextField diaChiT;
    private javax.swing.JLabel doanhThu;
    private javax.swing.JLabel dong;
    private javax.swing.JLabel dong2;
    private javax.swing.JLabel dong_CT;
    private javax.swing.JTextField email;
    private javax.swing.JTextField emailT;
    private javax.swing.JLabel five1;
    private javax.swing.JLabel five2;
    private javax.swing.JLabel five3;
    private javax.swing.JLabel five4;
    private javax.swing.JLabel five5;
    private javax.swing.JLabel five6;
    private javax.swing.JLabel four1;
    private javax.swing.JLabel four2;
    private javax.swing.JLabel four3;
    private javax.swing.JLabel four4;
    private javax.swing.JLabel four5;
    private javax.swing.JLabel four6;
    private javax.swing.JButton giaHan;
    private javax.swing.JPanel giaHanPanel;
    private javax.swing.JCheckBox haiKiCheck;
    private javax.swing.JLabel haiKiL;
    private javax.swing.JTextField headIndex;
    private javax.swing.JTextField hoTen;
    private javax.swing.JLabel hocKyB;
    private javax.swing.JButton huySV;
    private javax.swing.JButton huy_CP;
    private javax.swing.JButton huy_GH;
    private javax.swing.JLabel idBill;
    private javax.swing.JLabel idsv_1;
    private javax.swing.JLabel idsv_2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel126;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
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
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JComboBox<String> kiGH_HD;
    private javax.swing.JComboBox<String> ky_TK;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JTextField lastIndex;
    private javax.swing.JComboBox<String> loaiCombo;
    private javax.swing.JTextField lop;
    private javax.swing.JTextField lopT;
    private javax.swing.JLabel lop_HD;
    private javax.swing.JLabel maHD;
    private javax.swing.JCheckBox motKiCheck;
    private javax.swing.JLabel motKiL;
    private javax.swing.JTextField mssv;
    private javax.swing.JLabel mssvB;
    private javax.swing.JLabel mssvL;
    private javax.swing.JLabel mssv_HD;
    private javax.swing.JCheckBox namCheck;
    private javax.swing.JTextField namChot;
    private javax.swing.JTextField namHoc_TK;
    private javax.swing.JLabel nexttF;
    private javax.swing.JTextField nganh;
    private javax.swing.JTextField nganhT;
    private javax.swing.JLabel nganh_HD;
    private javax.swing.JLabel ngayBD_HD;
    private com.toedter.calendar.JDateChooser ngayBD_TK;
    private javax.swing.JTextField ngayChi_HDR;
    private javax.swing.JLabel ngayChot;
    private javax.swing.JLabel ngayKT_HD;
    private javax.swing.JLabel ngayKT_HD1;
    private javax.swing.JLabel ngayKT_HD2;
    private com.toedter.calendar.JDateChooser ngayKT_TK;
    private com.toedter.calendar.JDateChooser ngaySinh;
    private javax.swing.JTextField ngaySinhT;
    private javax.swing.JTextField noiDungChi_HDR;
    private javax.swing.JTextArea noiDung_HD;
    private javax.swing.JCheckBox nuCheck;
    private javax.swing.JLabel one1;
    private javax.swing.JLabel one2;
    private javax.swing.JLabel one3;
    private javax.swing.JLabel one4;
    private javax.swing.JLabel one5;
    private javax.swing.JLabel one6;
    private javax.swing.JLabel pageF;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel_HDRe;
    private javax.swing.JPanel panel_StatusRe;
    private javax.swing.JTextField phong_CP;
    private javax.swing.JLabel phong_HD;
    private javax.swing.JLabel phong_HDDN;
    private javax.swing.JLabel phong_HDDN1;
    private javax.swing.JTextField quocTich;
    private javax.swing.JTextField quocTichT;
    private javax.swing.JTable request_Table;
    private javax.swing.JLabel roomB;
    private javax.swing.JComboBox<String> roomComboBox;
    private javax.swing.JCheckBox roomDay;
    private javax.swing.JTable roomTable1;
    private javax.swing.JTable roomTable2;
    private javax.swing.JTable roomTable_HDDN;
    private javax.swing.JCheckBox roomTrong;
    private javax.swing.JCheckBox s_check1;
    private javax.swing.JCheckBox s_check2;
    private javax.swing.JCheckBox s_check3;
    private javax.swing.JCheckBox s_check4;
    private javax.swing.JTextField s_text;
    private javax.swing.JTextField sdt;
    private javax.swing.JTextField sdtT;
    private javax.swing.JTextField searchRoom;
    private javax.swing.JLabel status_L;
    private javax.swing.JLabel status_L1;
    private javax.swing.JLabel status_L2;
    private javax.swing.JLabel status_L3;
    private javax.swing.JTable studentTable;
    private javax.swing.JTable tableDuyet;
    private javax.swing.JTextField tenT;
    private javax.swing.JLabel ten_HD;
    private javax.swing.JTextField thangChot;
    private javax.swing.JPanel thanhToanHD_Panel;
    private javax.swing.JButton thanhToan_HDDN;
    private javax.swing.JButton thongke;
    private javax.swing.JLabel three1;
    private javax.swing.JLabel three2;
    private javax.swing.JLabel three3;
    private javax.swing.JLabel three4;
    private javax.swing.JLabel three5;
    private javax.swing.JLabel three6;
    private javax.swing.JTextField tienChi_HDR;
    private javax.swing.JLabel tien_CP;
    private javax.swing.JLabel tien_CP1;
    private javax.swing.JTextField tonGiao;
    private javax.swing.JTextField tonGiaoT;
    private javax.swing.JLabel tongTienB;
    private javax.swing.JLabel tongTien_Dky;
    private javax.swing.JLabel tongTien_GH;
    private javax.swing.JLabel tongTien_HD;
    private javax.swing.JLabel tongTien_HDDN;
    private javax.swing.JLabel tongTien_chuaVAT;
    private javax.swing.JLabel tongtien_VAT;
    private javax.swing.JLabel tt_CP;
    private javax.swing.JLabel two1;
    private javax.swing.JLabel two2;
    private javax.swing.JLabel two3;
    private javax.swing.JLabel two4;
    private javax.swing.JLabel two5;
    private javax.swing.JLabel two6;
    private javax.swing.JComboBox<String> typeRoomComboBox;
    private javax.swing.JTable typeTable;
    private javax.swing.JTextField useE;
    private javax.swing.JButton xacNhanSV;
    private javax.swing.JButton xacNhan_CP;
    private javax.swing.JButton xacNhan_GH;
    private javax.swing.JButton xacNhan_HDDN;
    private javax.swing.JComboBox<String> zoneCombo;
    private javax.swing.JComboBox<String> zoneComboBox;
    private javax.swing.JCheckBox zoneDay;
    private javax.swing.JComboBox<String> zoneSearch;
    private javax.swing.JTable zoneTable;
    private javax.swing.JCheckBox zoneTrong;
    // End of variables declaration//GEN-END:variables
}
