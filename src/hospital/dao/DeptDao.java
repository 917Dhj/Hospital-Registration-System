package hospital.dao;

import hospital.model.Dept;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class DeptDao {
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
                pstmt.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //数据库插入功能
    public static void insert(Integer id,String name,Integer type,String remark){
        Dept dept=new Dept();
        dept.setId(id);
        dept.setName(name);
        dept.setType(type);
        dept.setRemark(remark);
        insert(dept);
    }

    public static void insert(Dept dept){
        try{
            String sql="insert into dept(id,name,type,remark) values(?,?,?,?);";
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,dept.getId());
            pstmt.setString(2,dept.getName());
            pstmt.setInt(3,dept.getType());
            pstmt.setString(4,dept.getRemark());
            pstmt.executeUpdate();
            release(pstmt,conn);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //数据库更新
    public static void update(Integer id,String name,Integer type,String remark){
        Dept dept=new Dept();
        dept.setId(id);
        dept.setName(name);
        dept.setType(type);
        dept.setRemark(remark);
        update(dept);
    }

    public static void update(Dept dept){
        try{
            String sql="update dept set name=?,type=?,remark=? where id=?;";
            Connection conn= getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,dept.getName());
            pstmt.setInt(2,dept.getType());
            pstmt.setString(3,dept.getRemark());
            pstmt.setInt(4,dept.getId());
            pstmt.executeUpdate();
            release(pstmt,conn);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //数据库的删除
    public static void delete(Integer id){
        try{
            String sql="delete from dept where id=?;";
            Connection conn= getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            release(pstmt,conn);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //查询
    public static List<Dept> select(Integer id,String name,Integer type){
        try{
            String sql="select id,name,type,remark from dept";
            sql+= " where 1=1 ";
            if(id!=null){
                sql+="and id= '" + id +"' ";
            }
            if(name!=null){
                sql+="and name= '" + name + "' ";
            }
            if(type!=null){
                sql+="and type= '" + type + "' ";
            }
            sql += "order by id desc;";
            return fillDept(sql);
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static List<Dept> fillDept(String sql) throws SQLException,ClassNotFoundException{
        List<Dept> depts=new LinkedList<>();
        Connection conn= getConnection();
        PreparedStatement pstmt=conn.prepareStatement(sql);
        //System.out.println(pstmt);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            Dept dept=new Dept(rs.getInt("id"),rs.getString("name"),rs.getInt("type"),rs.getString("remark"));
            depts.add(dept);
        }
        release(rs,pstmt,conn);
        return depts;
    }
}
