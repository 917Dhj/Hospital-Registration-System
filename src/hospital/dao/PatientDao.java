package hospital.dao;

import hospital.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PatientDao {
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
    /*public static void insert(Integer id,String name,Integer sex,Integer age,String password){
        Patient patient=new Patient();
        Patient.setId(id);
        Patient.setName(name);
        Patient.setSex(sex);
        Patient.setAge(age);
        Patient.setPassword(password);
        insert(patient);
    }*/

    public static void insert(Patient patient){
        try{
            String sql="insert into patient(id,name,sex,age,password) values(?,?,?,?,?);";
            Connection conn= getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,patient.getId());
            pstmt.setString(2,patient.getName());
            pstmt.setInt(3,patient.getSex());
            pstmt.setInt(4,patient.getAge());
            pstmt.setString(5,patient.getPassword());
            pstmt.executeUpdate();
            release(pstmt,conn);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //数据库更新
    /*public static void update(Integer id,String name,Integer sex,Integer age,String password){
        Patient patient=new Patient();
        Patient.setId(id);
        Patient.setName(name);
        Patient.setSex(sex);
        Patient.setAge(age);
        Patient.setPassword(password);
        update(patient);
    }*/

    public static void update(Patient patient){
        try{
            String sql="update patient set name=?,sex=?,age=?,password=? where id=?;";
            Connection conn = getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,patient.getName());
            pstmt.setInt(2,patient.getSex());
            pstmt.setInt(3,patient.getAge());
            pstmt.setString(4,patient.getPassword());
            pstmt.setInt(5,patient.getId());
            pstmt.executeUpdate();
            release(pstmt,conn);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //数据库的删除
    public static void delete(Integer id){
        try{
            String sql="delete from patient where id=?;";
            Connection conn = getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            release(pstmt,conn);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //数据库的查询
    public static List<Patient> select(Integer id, String name,Integer sex,Integer age, String password){
        try{
            String sql="select id,name,sex,age,password from patient";
            sql+= " where 1=1 ";
            if(id!=null){
                sql+="and id= '" + id+"' ";
            }
            if(name!=null){
                sql+="and name= '" + name + "' ";
            }
            if(sex!=null){
                sql+="and sex= '" + sex + "' ";
            }
            if(age!=null){
                sql+="and age= '" + age + "' ";
            }
            if(password!=null){
                sql+="and password= '" + password + "' ";
            }
            sql+= "order by id desc;";
            return fillPatient(sql);
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static List<Patient> fillPatient(String sql) throws SQLException,ClassNotFoundException{
        List<Patient> patients=new LinkedList<>();
        Connection conn= getConnection();
        PreparedStatement pstmt=conn.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            Patient patient=new Patient(rs.getInt("id"),rs.getString("name"),rs.getInt("sex"),rs.getInt("age"),rs.getString("password"));
            patients.add(patient);
        }
        release(rs,pstmt,conn);
        return patients;
    }
}
