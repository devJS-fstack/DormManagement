
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.User;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import model.Bill;
import model.Contract;
import model.Feedback;
import model.HDDienNuoc;
import model.Request;
import model.Room;
import model.SexOfZone;
import model.Student;
import model.TypeRoom;
import model.Zone;

public class DAO {
    private Connection conn;
    
    public DAO(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QuanLyKTX;"
                    + "username=sa;password=215531622");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean addUser(User u)
    {
        String sql="INSERT INTO TaiKhoan(IDUs,Pass,IDRole,Status)" + "VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,u.getIDUs());
            ps.setString(2,u.getPass());
            ps.setInt(3,u.getIDRole());
            ps.setString(4,u.getStatus());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
        public boolean addRoom(Room r)
    {
        String sql="INSERT INTO Room(IDRoom,Max,AmountOfNow,Status,NameRoom,IDType,NameZone)" + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1,r.getIDRoom());
           ps.setInt(2,r.getMax());
           ps.setInt(3,r.getAmountOfNow());
           ps.setString(4,r.getStatus());
           ps.setString(5,r.getNameRoom());
           ps.setInt(6, r.getIDType());
           ps.setString(7, r.getIDZone());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
        
    public ArrayList <User> getListUser()
    {
        ArrayList <User> list =new ArrayList<>();
        String sql="SELECT * FROM TaiKhoan";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User us = new User();
                us.setIDUs(rs.getString("IDUs"));
                us.setPass(rs.getString("Pass"));
                us.setIDRole(rs.getInt("IDRole"));
                us.setStatus(rs.getString("Status"));
                list.add(us);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList <Room> getListRoom()
    {
        ArrayList <Room> listRoom =new ArrayList<>();
        String sql="SELECT * FROM Room";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                r.setIDRoom(rs.getString("IDRoom"));
                r.setMax(rs.getInt("Max"));
                r.setAmountOfNow(rs.getInt("AmountOfNow"));
                r.setStatus(rs.getString("Status"));
                r.setNameRoom(rs.getString("NameRoom"));
                r.setIDType(rs.getInt("IDType"));
                r.setIDZone(rs.getString("NameZone"));
                listRoom.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRoom;
    }
        public ArrayList <Room> getListRoom2(String typeRoom,int gia)
    {
        ArrayList <Room> listRoom =new ArrayList<>();
        String sql="SELECT * FROM Room as r,TypeRoom as t WHERE r.IDType=t.ID";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                r.setIDRoom(rs.getString("IDRoom"));
                r.setMax(rs.getInt("Max"));
                r.setAmountOfNow(rs.getInt("AmountOfNow"));
                r.setStatus(rs.getString("Status"));
                r.setNameRoom(rs.getString("NameRoom"));
                r.setIDType(rs.getInt("IDType"));
                r.setIDZone(rs.getString("NameZone"));
                listRoom.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRoom;
    }
          public ArrayList <Room> getListRoom_Zone(String nameZone)
    {
        ArrayList <Room> listRoom =new ArrayList<>();
        String sql="SELECT * FROM Room WHERE NameZone='"+nameZone+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                r.setIDRoom(rs.getString("IDRoom"));
                r.setMax(rs.getInt("Max"));
                r.setAmountOfNow(rs.getInt("AmountOfNow"));
                r.setStatus(rs.getString("Status"));
                r.setNameRoom(rs.getString("NameRoom"));
                r.setIDType(rs.getInt("IDType"));
                r.setIDZone(rs.getString("NameZone"));
                listRoom.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRoom;
    }
           public ArrayList <Room> getListRoom4(int idSex)
    {
        ArrayList <Room> listRoom =new ArrayList<>();
        String sql="SELECT * FROM Room as r, Zone as z WHERE r.NameZone=z.NameZone AND z.IDSex="+idSex;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                r.setIDRoom(rs.getString("IDRoom"));
                r.setMax(rs.getInt("Max"));
                r.setAmountOfNow(rs.getInt("AmountOfNow"));
                r.setStatus(rs.getString("Status"));
                r.setNameRoom(rs.getString("NameRoom"));
                r.setIDType(rs.getInt("IDType"));
                r.setIDZone(rs.getString("NameZone"));
                listRoom.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRoom;
    }
           public ArrayList <Room> getListRoom_Status(String status)
    {
        ArrayList <Room> listRoom =new ArrayList<>();
        String sql="SELECT * FROM Room WHERE Status=N'"+status+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                r.setIDRoom(rs.getString("IDRoom"));
                r.setMax(rs.getInt("Max"));
                r.setAmountOfNow(rs.getInt("AmountOfNow"));
                r.setStatus(rs.getString("Status"));
                r.setNameRoom(rs.getString("NameRoom"));
                r.setIDType(rs.getInt("IDType"));
                r.setIDZone(rs.getString("NameZone"));
                listRoom.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRoom;
    }
        public ArrayList <Zone> getListZone_Status(String status)
    {
        ArrayList <Zone> listZone =new ArrayList<>();
        String sql="SELECT * FROM Zone WHERE Status=N'"+status+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Zone z=new Zone();
                z.setNameZone(rs.getString("NameZone"));
                z.setDescription(rs.getString("Description"));
                z.setStatus(rs.getString("Status"));
                listZone.add(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listZone;
    }   
        public String typeRoom(String nameRoom){
            String sql="SELECT TypeOfRoom FROM TypeRoom as t, Room as r WHERE r.IDType=t.ID AND IDRoom='"
                    + nameRoom+"'";
            String type="";
            try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                type=rs.getString("TypeOfRoom");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return type;
        }
        public int costRoom(String nameRoom){
            String sql="SELECT Cost FROM TypeRoom as t, Room as r WHERE r.IDType=t.ID AND IDRoom='"
                    + nameRoom+"'";
            int gia=0;
            try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                gia=rs.getInt("Cost");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gia;
        }
        public String gioiTinh_Zone(String nameZone){
            String sql="SELECT Sex FROM SexOfZone as s , Zone as z WHERE z.IDSex=s.IDSex AND z.NameZone='"+nameZone+"'";
            String gioiTinh="";
            try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                gioiTinh=rs.getString("Sex");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gioiTinh;
        }
        public int costRoom_Type(String typeRoom){
            String sql="SELECT Cost FROM TypeRoom WHERE TypeOfRoom=N'"
                    + typeRoom+"'";
            int gia=0;
            try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                gia=rs.getInt("Cost");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gia;
        }
        public Date startDate(String mssv){
            String sql="SELECT StartDay FROM Contract WHERE IDStudent='"+mssv+"'";
            Date d=null;
             try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                d=rs.getDate("StartDay");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
        }
          public Date finishDate(String mssv){
            String sql="SELECT FinishDay FROM Contract WHERE IDStudent='"+mssv+"'";
            Date d=null;
             try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                d=rs.getDate("FinishDay");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
        }
          public Date getDateCreate_Bill(int idBill){
              String sql="SELECT DateCreate From Bill WHERE IDBill="+idBill;
              Date d=null;
              try {
                  PreparedStatement ps = conn.prepareStatement(sql);
                  ResultSet rs = ps.executeQuery();
                  while (rs.next()) {
                d=rs.getDate("DateCreate");
                  }
              } catch (Exception e) {
                  e.printStackTrace();
              }
              return d;
          }
    public ArrayList <Zone> getListZone()
    {
        ArrayList <Zone> listZone =new ArrayList<>();
        String sql="SELECT * FROM Zone";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Zone z=new Zone();
                z.setNameZone(rs.getString("NameZone"));
                z.setDescription(rs.getString("Description"));
                z.setStatus(rs.getString("Status"));
                listZone.add(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listZone;
    }
    public ArrayList <TypeRoom> getListTypeRoom()
    {
        ArrayList <TypeRoom> listType =new ArrayList<>();
        String sql="SELECT * FROM TypeRoom";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               TypeRoom t=new TypeRoom();
                t.setID(rs.getInt("ID"));
                t.setTypeOfRoom(rs.getString("TypeOfRoom"));
                t.setDescription(rs.getString("Description"));
                t.setCost(rs.getInt("Cost"));
                listType.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listType;
    }
    public ArrayList<Zone> getListZoneNam()
    {
        ArrayList <Zone> listZoneThuong =new ArrayList<>();
        String sql="SELECT * FROM Zone as z,SexOfZone as s WHERE  s.IDSex=z.IDSex AND Sex=N'Nam' " ;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Zone z=new Zone();
                z.setNameZone(rs.getString("NameZone"));
                z.setDescription(rs.getString("Description"));
                z.setStatus(rs.getString("Status"));
                z.setIDSex(rs.getInt("IDSex"));
                listZoneThuong.add(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listZoneThuong;
    }
     public ArrayList<Zone> getListZoneNu()
    {
        ArrayList <Zone> listZoneDV1 =new ArrayList<>();
        String sql="SELECT * FROM Zone as z,SexOfZone as s WHERE  s.IDSex=z.IDSex AND Sex=N'Nữ'" ;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Zone z=new Zone();
                z.setNameZone(rs.getString("NameZone"));
                z.setDescription(rs.getString("Description"));
                z.setStatus(rs.getString("Status"));
                z.setIDSex(rs.getInt("IDSex"));
                listZoneDV1.add(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listZoneDV1;
    }
      public ArrayList <Zone> getListZone1(int gioiTinh)
    {
        ArrayList <Zone> listZone =new ArrayList<>();
        String sql="SELECT * FROM Zone WHERE IDSex="+gioiTinh;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Zone z=new Zone();
                z.setNameZone(rs.getString("NameZone"));
                z.setDescription(rs.getString("Description"));
                z.setStatus(rs.getString("Status"));
                listZone.add(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listZone;
    }
           public ArrayList<Room> getDataRoom(int sex, String zone, int typeRoom){
        ArrayList<Room> room = new ArrayList<Room>();
        String sql = "SELECT * "
                + "FROM Room room JOIN Zone zone "
                + "ON room.NameZone = zone.NameZone "
                + "WHERE zone.IDSex = "+sex+" AND zone.NameZone = N'"+zone
                +"' AND room.IDType = "+typeRoom+ "AND room.Status=N'còn chỗ'";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                r.setIDRoom(rs.getString("IDRoom"));
                r.setMax(rs.getInt("Max"));
                r.setStatus(rs.getString("Status"));
                r.setNameRoom(rs.getString("NameRoom"));
                r.setIDType(rs.getInt("IDType"));
                r.setIDZone(rs.getString("NameZone"));
                room.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return room;
    }
           public Contract getContract(String mssv){
               String sql="SELECT * FROM Contract c JOIN Student s ON c.IDStudent=s.MSSV WHERE s.MSSV='"+mssv+"'";
               Contract c=new Contract();
               try {
                   PreparedStatement ps = conn.prepareStatement(sql);
                   ResultSet rs = ps.executeQuery();
                   while (rs.next()) {
                c.setIDContract(rs.getInt("IDContract"));
                c.setIDStudent(rs.getString("IDStudent"));
                c.setIDStaff(rs.getString("IDStaff"));
                c.setIDRoom(rs.getString("IDRoom"));
                c.setStartDay(rs.getDate("StartDay"));
                c.setFinishDay(rs.getDate("FinishDay"));
                c.setPayment(rs.getInt("Payment"));
                c.setAmountOfMonth(rs.getInt("AmountOfMonth"));
            }
               } catch (Exception e) {
               }
               return c;
           }
           public String nameSV(String mssv){
               String sql="SELECT * FROM Student WHERE MSSV='"+mssv+"'";
               String nameSV="";
               try {
                   PreparedStatement ps = conn.prepareStatement(sql);
                   ResultSet rs = ps.executeQuery();
                   while(rs.next()){
                       nameSV=rs.getString("Name");
                   }
               } catch (Exception e) {
               }
               return nameSV;
           }
           public String lopSV(String mssv){
               String sql="SELECT * FROM Student WHERE MSSV='"+mssv+"'";
               String lopSV="";
               try {
                   PreparedStatement ps = conn.prepareStatement(sql);
                   ResultSet rs = ps.executeQuery();
                   while(rs.next()){
                       lopSV=rs.getString("Class");
                   }
               } catch (Exception e) {
               }
               return lopSV;
           }
             public String nganhSV(String mssv){
               String sql="SELECT * FROM Student WHERE MSSV='"+mssv+"'";
               String nganh="";
               try {
                   PreparedStatement ps = conn.prepareStatement(sql);
                   ResultSet rs = ps.executeQuery();
                   while(rs.next()){
                       nganh=rs.getString("Nganh");
                   }
               } catch (Exception e) {
               }
               return nganh;
           }
            public ArrayList <TypeRoom> getCost(String type)
    {
        ArrayList <TypeRoom> cost =new ArrayList<>();
        String sql="SELECT * FROM Room as r,TypeRoom as t WHERE r.IDType=t.ID AND t.TypeOfRoom=N'"+type+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               TypeRoom t=new TypeRoom();
                t.setCost(rs.getInt("Cost"));
                cost.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cost;
    }
            public int  getCost_NameRoom(String nameRoom)
    {
        int cost=0;
        String sql="SELECT Cost From TypeRoom as t, Room as r WHERE IDType=ID AND IDRoom='"+nameRoom+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cost=rs.getInt("Cost");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cost;
    }
            public int amountOfNow_Zone(String nameZone){
                String sql="SELECT AmountOfNow FROM Room WHERE NameZone=N'"+nameZone+"'";
                int amount=0;
                try {
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        amount+=rs.getInt("AmountOfNow");
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
        return amount;
    }
     public boolean addStudent(Student s)
    {
        String sql="INSERT INTO Student(MSSV,Name,Class,DayOfBirth,Sex,Numberphone,Email,Address,danToc,tonGiao,Nationality,IDUs,CMND,Nganh)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1,s.getMssv());
            ps.setString(2,s.getHoTen());
            ps.setString(3, s.getLop());
            ps.setDate(4,(java.sql.Date) new java.sql.Date(s.getDateOfBirth().getTime()));
            ps.setString(5,s.getGioiTinh());
            ps.setString(6,s.getSdt());
            ps.setString(7,s.getEmail());
            ps.setString(8,s.getAddress());
            ps.setString(9,s.getDanToc());
            ps.setString(10,s.getTonGiao());
            ps.setString(11,s.getQuocTich());
            ps.setString(12,s.getIDUs());
            ps.setString(13, s.getCmnd());
            ps.setString(14, s.getNganh());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
     public boolean addContract(Contract c){
         String sql="INSERT INTO Contract(IDContract,IDStudent,IDStaff,IDRoom,StartDay,FinishDay,Payment,AmountOfMonth)"
                 +"VALUES(?,?,?,?,?,?,?,?)";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setInt(1,c.getIDContract());
             ps.setString(2, c.getIDStudent());
             ps.setString(3,c.getIDStaff());
             ps.setString(4,c.getIDRoom());
             ps.setDate(5,(java.sql.Date) new java.sql.Date(c.getStartDay().getTime()));
             ps.setDate(6,(java.sql.Date) new java.sql.Date(c.getFinishDay().getTime()));
             ps.setInt(7, c.getPayment());
             ps.setInt(8,c.getAmountOfMonth());
             return ps.executeUpdate() > 0;
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
     }
     public ArrayList <Contract> getListContract()
     {
         ArrayList <Contract> listContract =new ArrayList<Contract>();
        String sql="SELECT * FROM Contract";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Contract c=new Contract();
                c.setIDContract(rs.getInt("IDContract"));
                c.setIDStudent(rs.getString("IDStudent"));
                c.setIDStaff(rs.getString("IDStaff"));
                c.setIDRoom(rs.getString("IDRoom"));
                c.setStartDay(rs.getDate("StartDay"));
                c.setFinishDay(rs.getDate("FinishDay"));
                c.setPayment(rs.getInt("Payment"));
                c.setAmountOfMonth(rs.getInt("AmountOfMonth"));
                listContract.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listContract;
     }
     public boolean UpdateAmountInRoom(String idRoom){
         String sql="UPDATE Room SET AmountOfNow+=1 WHERE IDRoom='"+idRoom.trim()+"' AND AmountOfNow<Room.Max";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
     }
     public boolean update_IncreaseAmount(String idRoom){
         String sql="UPDATE Room SET AmountOfNow-=1 WHERE IDRoom='"+idRoom.trim()+"'";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return false;
     }
     public boolean updateContract_FinishDay(String mssv,String date){
         String sql="UPDATE Contract SET FinishDay='"+date+"' WHERE IDStudent='"+mssv+"'";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
     }
     public boolean updateContract_Payment(String mssv,int paymentUpdate){
         String sql="UPDATE Contract SET Payment=Payment+"+paymentUpdate+"WHERE IDStudent='"+mssv+"'";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
     }
     public boolean UpdatStatusRoom(String idRoom){
         String sql="UPDATE Room SET Status=N'đủ người' WHERE IDRoom='"+idRoom+"' AND AmountOfNow=Room.Max";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
     }
     public boolean update_ContentHD(int idBill,String idSv){
         Date d=new Date();
         SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
         SimpleDateFormat dfm=new SimpleDateFormat("dd/MM/yyyy");
         String sql="UPDATE Bill SET NoiDung=N'Tiền ở ktx từ "+dfm.format(d)+" đến "+dfm.format(new DAO().finishDate(idSv))+"' WHERE IDBill='"+idBill+"'";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return false;
     }
     public boolean update_statusHD(int idbill){
         String sql="UPDATE Bill SET Status=N'Đã thanh toán' WHERE IDBill="+idbill;
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return false;
     }
     public boolean update_dateCreateHD(int idBill){
         Date d=new Date();
         SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
         String sql="UPDATE Bill SET DateCreate='"+df.format(d)+"' WHERE IDBill='"+idBill+"'";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return false;
     }
     public boolean upDate_StaffHD(String idStaff,int idBill){
         String sql="UPDATE Bill SET IDStaff='"+idStaff+"' WHERE IDBill="+idBill;
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return false;
     }
     public boolean upDate_StaffContract(String idStaff,String idSv){
         String sql="UPDATE Contract SET IDStaff='"+idStaff+"' WHERE IDStudent='"+idSv+"'";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return false;
     }
     public boolean upDate_StartDay(String idSv){
         Date d=new Date();
         SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
         String sql="UPDATE Contract SET StartDay='"+df.format(d)+"'WHERE IDStudent='"+idSv+"'";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return false;
     }
     public boolean upDate_StatusUser(String idUs,String status){
         String sql="UPDATE TaiKhoan SET Status=N'"+status+"' WHERE IDUs='"+idUs+"'";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return false;
     }
     public String status_user(String idus){
         String sql="SELECT Status FROM TaiKhoan WHERE IDUs='"+idus+"'";
         String status="";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 status=rs.getString("Status");
             }
         } catch (Exception e) {
         }
         return status;
     }
     public Student getStudent(String idUS){
          Student s=new Student();
         String sql="SELECT * FROM Student WHERE IDUs='"+idUS+"'";
           try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               s.setMssv(rs.getString("MSSV"));
               s.setHoTen(rs.getString("Name"));
               s.setLop(rs.getString("Class"));
               s.setDateOfBirth(rs.getDate("DayOfBirth"));
               s.setGioiTinh(rs.getString("Sex"));
               s.setSdt(rs.getString("Numberphone"));
               s.setEmail(rs.getString("Email"));
               s.setAddress(rs.getString("Address"));
               s.setDanToc(rs.getString("danToc"));
               s.setTonGiao(rs.getString("tonGiao"));
               s.setQuocTich(rs.getString("Nationality"));
               s.setIDUs(rs.getString("IDUs"));
               s.setCmnd(rs.getString("CMND"));
               s.setNganh(rs.getString("Nganh"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
     }
     public Bill getBill(String date,String mssv){
         Bill b=new Bill();
         String sql="SELECT * FROM Bill WHERE DateCreate='"+date+"' AND IDStudent='"+mssv+"'";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 b.setIDBill(rs.getInt("IDBill"));
                 b.setIDStaff(rs.getString("IDStaff"));
                 b.setStatus(rs.getString("Status"));
                 b.setDateCreate(rs.getDate("DateCreate"));
                 b.setIDStudent(rs.getString("IDStudent"));
                 b.setNoiDung(rs.getString("NoiDung"));
                 b.setTypeBill(rs.getString("TypeBill"));
                 b.setPayment(rs.getInt("Payment"));
                 b.setSemester(rs.getString("Semester"));
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return b;
     }
     public Bill getBill_ID(String idBill){
         Bill b=new Bill();
         String sql="SELECT * FROM Bill WHERE IDBill="+idBill;
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 b.setIDBill(rs.getInt("IDBill"));
                 b.setIDStaff(rs.getString("IDStaff"));
                 b.setStatus(rs.getString("Status"));
                 b.setDateCreate(rs.getDate("DateCreate"));
                 b.setIDStudent(rs.getString("IDStudent"));
                 b.setNoiDung(rs.getString("NoiDung"));
                 b.setTypeBill(rs.getString("TypeBill"));
                 b.setPayment(rs.getInt("Payment"));
                 b.setSemester(rs.getString("Semester"));
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return b;
     }
     public String getSemester(String idSv){
         String sql="SELECT Semester FROM Bill WHERE IDStudent='"+idSv+"'"+"AND TypeBill=N'Thuê Phòng'";
         String semester="";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 semester=rs.getString("Semester");
             }
         } catch (Exception e) {
         }
         return semester;
     }
     public ArrayList <Student> getListStudent(){
         String sql="SELECT * FROM Student";
         ArrayList <Student>listStudent=new ArrayList<Student>();
           try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s=new Student();
               s.setMssv(rs.getString("MSSV"));
               s.setHoTen(rs.getString("Name"));
               s.setLop(rs.getString("Class"));
               s.setDateOfBirth(rs.getDate("DayOfBirth"));
               s.setGioiTinh(rs.getString("Sex"));
               s.setSdt(rs.getString("Numberphone"));
               s.setEmail(rs.getString("Email"));
               s.setAddress(rs.getString("Address"));
               s.setDanToc(rs.getString("danToc"));
               s.setTonGiao(rs.getString("tonGiao"));
               s.setQuocTich(rs.getString("Nationality"));
               s.setIDUs(rs.getString("IDUs"));
               s.setCmnd(rs.getString("CMND"));
               s.setNganh(rs.getString("Nganh"));
               listStudent.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudent;
     }
      public ArrayList <Student> getListStudent_DuyetDon(){
         String sql="SELECT * FROM Student as s, TaiKhoan as t WHERE s.IDUs=t.IDUs AND t.Status=N'Đang đợi duyệt'";
         ArrayList <Student>listStudent=new ArrayList<Student>();
           try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s=new Student();
               s.setMssv(rs.getString("MSSV"));
               s.setHoTen(rs.getString("Name"));
               s.setLop(rs.getString("Class"));
               s.setDateOfBirth(rs.getDate("DayOfBirth"));
               s.setGioiTinh(rs.getString("Sex"));
               s.setSdt(rs.getString("Numberphone"));
               s.setEmail(rs.getString("Email"));
               s.setAddress(rs.getString("Address"));
               s.setDanToc(rs.getString("danToc"));
               s.setTonGiao(rs.getString("tonGiao"));
               s.setQuocTich(rs.getString("Nationality"));
               s.setIDUs(rs.getString("IDUs"));
               s.setCmnd(rs.getString("CMND"));
               s.setNganh(rs.getString("Nganh"));
               listStudent.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudent;
     }
      
     public boolean updateStudent(Student s){
         String sql="UPDATE Student SET "
                 +"Name=N'"+s.getHoTen()+"',"
                 + "Class='"+s.getLop()+"',"
                 +"DayOfBirth='"+s.getDateOfBirth()+"',"
                 +"Sex=N'"+s.getGioiTinh()+"',"
                 +"Numberphone='"+s.getSdt()+"',"
                 +"Email='"+s.getEmail()+"',"
                 +"Address=N'"+s.getAddress()+"',"
                 +"danToc=N'"+s.getDanToc()+"',"
                 +"tonGiao=N'"+s.getTonGiao()+"',"
                 +"Nationality=N'"+s.getQuocTich()+"',"
                 +"CMND='"+s.getCmnd()+"',"
                 +"Nganh=N'"+s.getNganh()+"'"
                 +"WHERE IDUs='"+s.getMssv().trim()+"'";
           try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
     }
           return false;
     }
     
     public boolean addRequest(Request r){
         String sql="INSERT INTO Request(IDRequest,NoiDung,DateRequest,Status,IDUs)"
                 + "VALUES(?,?,?,?,?)";
          try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setInt(1,r.getIDRequest());
             ps.setString(2,r.getNameRequest());
              ps.setDate(3,(java.sql.Date) new java.sql.Date(r.getDateRequest().getTime()));
             ps.setString(4,r.getStatus());
             ps.setString(5,r.getIDUs());
             return ps.executeUpdate() > 0;
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
     }
     public ArrayList<Request> getListRequest(String IDUs){
         ArrayList <Request> listRequest =new ArrayList<Request>();
        String sql="SELECT * FROM Request WHERE IDUs='"+IDUs+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Request r=new Request();
                r.setIDRequest(rs.getInt("IDRequest"));
                r.setNameRequest(rs.getString("NoiDung"));
                r.setDateRequest(rs.getDate("DateRequest"));
                r.setStatus(rs.getString("Status"));
                r.setIDUs(rs.getString("IDUs"));
                listRequest.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRequest;
     }
      public ArrayList<Request> getListRequest_All(){
         ArrayList <Request> listRequest =new ArrayList<>();
        String sql="SELECT * FROM Request";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Request r=new Request();
                r.setIDRequest(rs.getInt("IDRequest"));
                r.setNameRequest(rs.getString("NoiDung"));
                r.setDateRequest(rs.getDate("DateRequest"));
                r.setStatus(rs.getString("Status"));
                r.setIDUs(rs.getString("IDUs"));
                listRequest.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRequest;
     }
     public boolean deleteUser(String idUs) {
        String sql = "DELETE TaiKhoan WHERE IDUs = '" + idUs.trim() + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
     public boolean deleteContract(String idUs) {
        String sql = "DELETE Contract WHERE IDstudent = '" + idUs.trim() + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
      public boolean deleteBill(String idUs) {
        String sql = "DELETE Bill WHERE IDstudent = '" + idUs.trim() + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
       public boolean deleteStudent(String idUs) {
        String sql = "DELETE Student WHERE MSSV = '" + idUs.trim() + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
     public boolean addBill(Bill b){
         String sql="INSERT INTO Bill(IDBill,IDStaff,Status,DateCreate,IDStudent,NoiDung,TypeBill,Semester,Payment)"
                 + "VALUES(?,?,?,?,?,?,?,?,?)";
           try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setInt(1,b.getIDBill());
             ps.setString(2,b.getIDStaff());
             ps.setString(3,b.getStatus());
             ps.setDate(4,(java.sql.Date) new java.sql.Date(b.getDateCreate().getTime()));
             ps.setString(5,b.getIDStudent());
             ps.setString(6,b.getNoiDung());
             ps.setString(7,b.getTypeBill());
             ps.setString(8, b.getSemester());
             ps.setInt(9,b.getPayment());
             return ps.executeUpdate() > 0;
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
     }
       public ArrayList<Bill> getListBillAll(){
          String sql="SELECT * FROM Bill";
          ArrayList<Bill> listBill=new ArrayList<Bill>();
           try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bill b=new Bill();
                b.setIDBill(rs.getInt("IDBill"));
                b.setIDStaff(rs.getString("IDStaff"));
                b.setStatus(rs.getString("Status"));
                b.setDateCreate(rs.getDate("DateCreate"));
                b.setIDStudent(rs.getString("IDStudent"));
                b.setNoiDung(rs.getString("NoiDung"));
                b.setTypeBill(rs.getString("TypeBill"));
                b.setPayment(rs.getInt("Payment"));
                b.setSemester(rs.getString("Semester"));
                listBill.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBill;
     }
     public ArrayList<Bill> getListBill(String IDStudent){
          String sql="SELECT * FROM Bill WHERE IDStudent='"+IDStudent.trim()+"'";
          ArrayList<Bill> listBill=new ArrayList<Bill>();
           try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bill b=new Bill();
                b.setIDBill(rs.getInt("IDBill"));
                b.setIDStaff(rs.getString("IDStaff"));
                b.setStatus(rs.getString("Status"));
                b.setDateCreate(rs.getDate("DateCreate"));
                b.setIDStudent(rs.getString("IDStudent"));
                b.setNoiDung(rs.getString("NoiDung"));
                b.setTypeBill(rs.getString("TypeBill"));
                b.setPayment(rs.getInt("Payment"));
                b.setSemester(rs.getString("Semester"));
                listBill.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBill;
     }
     public String nameRoom(String id){
         String sql="SELECT IDRoom From Contract as c,Student as s WHERE c.IDStudent=s.MSSV AND s.MSSV='"+id+"'";
         String nameRoom="";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            nameRoom=rs.getString("IDRoom");
            }
         } catch (Exception e) {
         }
         return nameRoom;
     }
     public String zone(String id){
         String sql="SELECT NameZone FROM Room WHERE IDRoom='"+id+"'";
         String zone="";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            zone=rs.getString("NameZone");
            }
         } catch (Exception e) {
         }
         return zone;
     }

     public ArrayList<HDDienNuoc> getListHDDienNuoc_NameRoom(String nameRoom){
         String sql="SELECT * FROM HDDienNuoc WHERE IDRoom='"+nameRoom+"'";
         ArrayList<HDDienNuoc> listHD=new ArrayList<>();
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HDDienNuoc h=new HDDienNuoc();
                h.setIDHD(rs.getInt("IDHD"));
                h.setClosingDate(rs.getDate("ClosingDate"));
                h.setHeadIndexE(rs.getInt("HeadIndexE"));
                h.setLastIndexE(rs.getInt("LastIndexE"));
                h.setUseE(rs.getInt("UseE"));
                h.setCostE(rs.getInt("CostE"));
                h.setTotalPayment(rs.getInt("TotalPayment"));
                h.setStatus(rs.getString("Status"));
                h.setMonth(rs.getInt("Month"));
                h.setYear(rs.getInt("Year"));
                h.setIdStaff(rs.getString("IDStaff"));
                listHD.add(h);
            }
         } catch (Exception e) {
              e.printStackTrace();
         }
         return listHD;
     }
     public HDDienNuoc getHDDienNuoc(String idBill){
         String sql="SELECT * FROM HDDienNuoc WHERE IDHD="+idBill;
         HDDienNuoc h=new HDDienNuoc();
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                h.setIDHD(rs.getInt("IDHD"));
                h.setClosingDate(rs.getDate("ClosingDate"));
                h.setHeadIndexE(rs.getInt("HeadIndexE"));
                h.setLastIndexE(rs.getInt("LastIndexE"));
                h.setUseE(rs.getInt("UseE"));
                h.setCostE(rs.getInt("CostE"));
                h.setTotalPayment(rs.getInt("TotalPayment"));
                h.setStatus(rs.getString("Status"));
                h.setMonth(rs.getInt("Month"));
                h.setYear(rs.getInt("Year"));
                h.setIdStaff(rs.getString("IDStaff"));
            }
         } catch (Exception e) {
         }
         return h;
     }
     
     public ArrayList<HDDienNuoc> getListHDDienNuoc(){
         String sql="SELECT * FROM HDDienNuoc";
         ArrayList<HDDienNuoc> listHD=new ArrayList<>();
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HDDienNuoc h=new HDDienNuoc();
                h.setIDHD(rs.getInt("IDHD"));
                h.setClosingDate(rs.getDate("ClosingDate"));
                h.setHeadIndexE(rs.getInt("HeadIndexE"));
                h.setLastIndexE(rs.getInt("LastIndexE"));
                h.setUseE(rs.getInt("UseE"));
                h.setCostE(rs.getInt("CostE"));
                h.setTotalPayment(rs.getInt("TotalPayment"));
                h.setStatus(rs.getString("Status"));
                h.setMonth(rs.getInt("Month"));
                h.setYear(rs.getInt("Year"));
                h.setIdStaff(rs.getString("IDStaff"));
                listHD.add(h);
            }
         } catch (Exception e) {
              e.printStackTrace();
         }
         return listHD;
     }
     public boolean addHDDN(HDDienNuoc hd){
         String sql="INSERT INTO HDDienNuoc(IDHD,ClosingDate,HeadIndexE,LastIndexE,UseE,CostE,TotalPayment,Status,Month,Year,IDRoom,IDStaff)"
                 + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
         try {
             PreparedStatement ps=conn.prepareStatement(sql);
             ps.setInt(1,hd.getIDHD());
             ps.setDate(2,(java.sql.Date) new java.sql.Date(hd.getClosingDate().getTime()));
             ps.setInt(3,hd.getHeadIndexE());
             ps.setInt(4,hd.getLastIndexE());
             ps.setInt(5,hd.getUseE());
             ps.setInt(6,hd.getCostE());
             ps.setInt(7,hd.getTotalPayment());
             ps.setString(8,hd.getStatus());
             ps.setInt(9,hd.getMonth());
             ps.setInt(10,hd.getYear());
             ps.setString(11,hd.getIDRoom());
             ps.setString(12,hd.getIdStaff());
             return ps.executeUpdate() > 0;
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
     }
     public int count_Room(String idRoom){
         String sql="SELECT COUNT(IDRoom) as Count FROM Contract WHERE IDRoom='"+idRoom+"'";
         int count=0;
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 count=rs.getInt("Count");
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return count;
     }
     public int count_TypeRoomInZone(String nameZone,int idType){
         String sql="SELECT COUNT(IDRoom) as Count FROM Room WHERE NameZone=N'"+nameZone+"' AND IDType="+idType;
         int count=0;
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 count=rs.getInt("Count");
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return count;
     }
     public int max_Room(String idRoom){
         String sql="SELECT Max FROM Room WHERE IDRoom='"+idRoom+"'";
         int sl=0;
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 sl=rs.getInt("Max");
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return sl;
     }
     public int amountStudent_Type(int idType){
         String sql="SELECT AmountOfNow FROM Room WHERE IDType="+idType;
         int amount=0;
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 amount+=rs.getInt("AmountOfNow");
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return amount;
     }
     public boolean update_NameRoom(String idsv,String idRoom){
         String sql="UPDATE Contract SET IDRoom='"+idRoom+"' WHERE IDStudent='"+idsv+"'";
          try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
     }
     public boolean update_StatusRequest(String noiDung,String idsv,String status){
         String sql="UPDATE Request SET Status=N'"+status+"' WHERE NoiDung=N'"+noiDung+"' AND IDUs='"+idsv+"'";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
     }
     public int getAmoutOfMonth(String idsv){
         String sql="SELECT AmountOfMonth FROM Contract WHERE IDStudent='"+idsv+"'";
         int amount=0;
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 amount=rs.getInt("AmountOfMonth");
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return amount;
     }
     public int idsex(String nameRoom){
         String sql="SELECT IDSex FROM Zone as z, Room as r WHERE r.NameZone=z.NameZone AND NameRoom='"+nameRoom+"'";
         int idSex=0;
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 idSex=rs.getInt("IDSex");
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return idSex;
     }
     public boolean update_StatusHDDN(String idRoom,int month,int year){
         String sql="UPDATE HDDienNuoc SET Status=N'Đã thanh toán' WHERE IDRoom='"+idRoom+"' AND Month="+month+"AND Year="+year;
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
     }
     public boolean update_Bill(String idsv,int payment,String semester,String noiDung,String date){
         String sql="UPDATE Bill SET "
                 + "Payment="+payment+","
                 +"Semester=N'"+semester+"'"+","
                 +"NoiDung=N'"+noiDung+"'"+","
                 +"DateCreate='"+date+"'"
                 + "WHERE IDStudent='"+idsv+"' AND TypeBill=N'thuê phòng'" ;
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
     }
     public boolean update_Contract(String idsv,String startDate,String finishDate,String nameRoom,int payment,int month){
         String sql="UPDATE Contract SET StartDay='"+startDate+"',"
                 + "FinishDay='"+finishDate+"',"
                 + "IDRoom='"+nameRoom+"',"
                 +"Payment="+payment+","
                 +"AmountOfMonth="+month
                 + "WHERE IDStudent='"+idsv+"'";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
     }
     public boolean addFeedBack(Feedback f){
         String sql="INSERT INTO Feedback (IDF,IDStudent,DateCreate,EvaP,EvaS,EvaA,Content_F) "
                 + "VALUES(?,?,?,?,?,?,?)";
         try {
             PreparedStatement ps=conn.prepareStatement(sql);
             ps.setInt(1, f.getIdFeedback());
             ps.setString(2, f.getIdStudent());
             ps.setDate(3, (java.sql.Date) new java.sql.Date(f.getDateCreate().getTime()));
             ps.setInt(4,f.getEvaP());
             ps.setInt(5,f.getEvaS());
             ps.setInt(6, f.getEvaA());
             ps.setString(7,f.getContent());
             return ps.executeUpdate() > 0;
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
     }
     public ArrayList<Feedback> getListFeedback(){
         String sql="SELECT * FROM Feedback";
         ArrayList<Feedback>listF=new ArrayList<>();
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 Feedback f=new Feedback();
                 f.setIdFeedback(rs.getInt("IDF"));
                 f.setIdStudent(rs.getString("IDStudent"));
                 f.setDateCreate(rs.getDate("DateCreate"));
                 f.setEvaP(rs.getInt("EvaP"));
                 f.setEvaS(rs.getInt("EvaS"));
                 f.setEvaA(rs.getInt("EvaA"));
                 f.setContent(rs.getString("Content_F"));
                 listF.add(f);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return listF;
     }
     public String nameStaff(String idUs){
         String name="";
         String sql="SELECT Name FROM Staff WHERE IDUs='"+idUs+"'";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 name=rs.getString("Name");
             }
         } catch (Exception e) {
         }
         return name;
     }
     public String nameStudent(String idUs){
         String name="";
         String sql="SELECT Name FROM Student WHERE IDUs='"+idUs+"'";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 name=rs.getString("Name");
             }
         } catch (Exception e) {
         }
         return name;
     }
     public int totalPayment(String idUs){
         String sql="SELECT Payment FROM Bill WHERE IDStudent='"+idUs+"' AND TypeBill=N'thuê phòng'";
         int tien=0;
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 tien=rs.getInt("Payment");
             }
         } catch (Exception e) {
         }
         return tien;
     }
     public boolean check_Us(String idsv){
         String sql="SELECT IDUs FROM TaiKhoan WHERE IDUs='"+idsv+"'";
         String check="";
         try {
             
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 check=rs.getString("IDUs");
             }
         } catch (Exception e) {
         }
         if(check.equals(idsv)) return true;
         return false;
     }
    public static void main(String[] args) {
        SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(df.format(new DAO().getDateCreate_Bill(1)));
    }

    
}
