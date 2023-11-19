package hospital.dao;

import hospital.model.Reg;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RegDao {
    private static final String Driver_name = "com.mysql.cj.jdbc.Driver";
    private static final String Jdbc_url = "jdbc:mysql://localhost:3306/practice6";
    private static final String Jdbc_username = "root";
    private static final String Jdbc_password = "Ding030917";

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(Driver_name);
        return DriverManager.getConnection(Jdbc_url,Jdbc_username,Jdbc_password);
    }

    public static void release(PreparedStatement pstmt, Connection conn){
        release(null,pstmt,conn);
    }
    public static void release(ResultSet rs, PreparedStatement pstmt, Connection conn){
        try{
            if(rs!=null){
                rs.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //数据库插入功能
    /*public static void insert(Integer patientId, Integer deptId, Date regTime, Double price){
        Reg reg=new Reg();
        Reg.setPatientId(patientId);
        Reg.setDeptId(deptId);
        Reg.setRegTime(regTime);
        Reg.setPrice(price);
        insert(reg);
    }*/

    public static void insert(Reg reg){
        try{
            String sql="insert into reg(id,patientId,deptId,regTime,price) values(?,?,?,?,?);";
            Connection conn= getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1,reg.getId());
            pstmt.setInt(2,reg.getPatientId());
            pstmt.setInt(3,reg.getDeptId());
            pstmt.setTimestamp(4,new Timestamp(reg.getRegTime().getTime()));
            pstmt.setDouble(5,reg.getPrice());
            pstmt.executeUpdate();
            release(pstmt,conn);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //数据库更新
    /*public static void update(Integer id,Integer patientId, Integer deptId, Date regTime, Double price){
        Reg reg=new Reg();
        Reg.setId(id);
        Reg.setPatientId(patientId);
        Reg.setDeptId(deptId);
        Reg.setRegTime(regTime);
        Reg.setPrice(price);
        update(reg);
    }*/

    public static void update(Reg reg){
        try{
            String sql="update reg set patientId=?,deptId=?,regTime=?,price=? where id=?;";
            Connection conn = getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,reg.getPatientId());
            pstmt.setInt(2,reg.getDeptId());
            pstmt.setTimestamp(3,new Timestamp(reg.getRegTime().getTime()));
            pstmt.setDouble(4,reg.getPrice());
            pstmt.setInt(5,reg.getId());
            pstmt.executeUpdate();
            release(pstmt,conn);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //数据库的删除
    public static void delete(Integer patientId){
        try{
            String sql="delete from reg where patientId=?;";
            Connection conn = getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,patientId);
            pstmt.executeUpdate();
            release(pstmt,conn);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //数据库的查询
    public static List<Reg> select(Integer id,Integer patientId,Integer deptId,String regTime,Integer price){
        try{
            String sql="select id,patientId,deptId,regTime,price from reg";
            sql+= " where 1=1 ";
            if(id!=null){
                sql+="and id= '" + id+"' ";
            }
            if(patientId!=null){
                sql+="and patientId= '" + patientId + "' ";
            }
            if(deptId!=null){
                sql+="and deptId= '" + deptId + "' ";
            }
            if(regTime!=null){
                sql+="and regTime= '" + regTime + "' ";
            }
            if(price!=null){
                sql+="and price= '" + price + "' ";
            }
            sql+= "order by id desc;";
            return fillReg(sql);
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    private static List<Reg> fillReg(String sql) throws SQLException,ClassNotFoundException{
        List<Reg> regs=new LinkedList<>();
        Connection conn= getConnection();
        PreparedStatement pstmt=conn.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            Reg reg=new Reg(rs.getInt("id"),rs.getInt("patientId"),rs.getInt("deptId"),rs.getDate("regTime"),rs.getDouble("price"));
            regs.add(reg);
        }
        release(rs,pstmt,conn);
        return regs;
    }
}
