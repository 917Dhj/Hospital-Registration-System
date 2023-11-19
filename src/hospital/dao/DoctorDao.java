package hospital.dao;

import hospital.model.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DoctorDao {
    private static final String Driver_name = "com.mysql.cj.jdbc.Driver";
    private static final String Jdbc_url = "jdbc:mysql://localhost:3306/practice6";
    private static final String Jdbc_username = "root";
    private static final String Jdbc_password = "Ding030917";

    private static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName(Driver_name);
        return DriverManager.getConnection(Jdbc_url,Jdbc_username,Jdbc_password);
    }

    public static void release(PreparedStatement pstmt,Connection conn){
        release(null,pstmt,conn);
    }
    public static void release(ResultSet rs,PreparedStatement pstmt,Connection conn){
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
    /*public static void insert(Integer id,String name,Integer deptId,Integer sex,String password){
        Doctor doctor=new Doctor();
        Doctor.setId(id);
        Doctor.setName(name);
        Doctor.setDeptId(deptId);
        Doctor.setSex(sex);
        Doctor.setPassword(password);
        insert(doctor);
    }*/

    public static void insert(Doctor doctor){
        try{
            String sql="insert into doctor(id,name,deptId,sex,password) values(?,?,?,?,?);";
            Connection conn= getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,doctor.getId());
            pstmt.setString(2,doctor.getName());
            pstmt.setInt(3,doctor.getDeptId());
            pstmt.setInt(4,doctor.getSex());
            pstmt.setString(5,doctor.getPassword());
            pstmt.executeUpdate();
            release(pstmt,conn);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //数据库更新
    /*public static void update(Integer id,String name,Integer deptId,Integer sex,String password){
        Doctor doctor=new Doctor();
        doctor.setId(id);
        doctor.setName(name);
        doctor.setDeptId(deptId);
        doctor.setSex(sex);
        doctor.setPassword(password);
        update(doctor);
    }*/

    public static void update(Doctor doctor){
        try{
            String sql="update doctor set name=?,deptId=?,sex=?,password=? where id=?;";
            Connection conn = getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,doctor.getName());
            pstmt.setInt(2,doctor.getDeptId());
            pstmt.setInt(3,doctor.getSex());
            pstmt.setString(4,doctor.getPassword());
            pstmt.setInt(5,doctor.getId());
            pstmt.executeUpdate();
            release(pstmt,conn);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //数据库的删除
    public static void delete(Integer id){
        try{
            String sql="delete from doctor where id=?;";
            Connection conn = getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            release(pstmt,conn);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //查询
    public static List<Doctor> select(Integer id,String name,Integer deptId,Integer sex,String password){
        try{
            String sql="select id,name,deptId,sex,password from doctor";
            sql+= " where 1=1 ";
            if(id!=null){
                sql+="and id= '" + id+"' ";
            }
            if(name!=null){
                sql+="and name= '" + name + "' ";
            }
            if(deptId!=null){
                sql+="and deptId= '" + deptId + "' ";
            }
            if(sex!=null){
                sql+="and sex= '" + sex + "' ";
            }
            if(password!=null){
                sql+="and password= '" + password + "' ";
            }
            sql+= "order by id desc;";
            return fillDoctor(sql);
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static List<Doctor> fillDoctor(String sql) throws SQLException,ClassNotFoundException{
        List<Doctor> doctors=new LinkedList<>();
        Connection conn= getConnection();
        PreparedStatement pstmt=conn.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            Doctor doctor=new Doctor(rs.getInt("id"),rs.getString("name"),rs.getInt("deptId"),rs.getInt("sex"),rs.getString("password"));
            doctors.add(doctor);
        }
        release(rs,pstmt,conn);
        return doctors;
    }
}
