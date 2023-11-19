package hospital.service;

import hospital.dao.PatientDao;
import hospital.dao.RegDao;
import hospital.model.Patient;
import hospital.model.Reg;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PatientService {
    //病人注册
    public static void regist(Integer id,String name,String password,Integer sex,Integer age){
        List<Patient> models=PatientDao.select(id,null,null,null,null);
        if(models.size()>0){
            System.out.println("病人账号[" + id + "]已存在.");
        }
        else{
            Patient model=new Patient(id,name,sex,age,password);
            PatientDao.insert(model);
            System.out.println("病人注册成功.");
        }
    }

    //病人登录
    public static Patient login(String name,String password){
        Patient model=null;
        List<Patient> models = PatientDao.select(null,name,null,null,password);
        if(models.size()>0){
            model=models.get(0);
            System.out.println("病人[" + model.getName() + "]登录成功.");
        }
        else{
            System.out.println("病人账号或密码错误，登录失败.");
        }
        return model;
    }

    //病人挂号
    public static void sendReg(Integer patientId,Integer deptId){
        Date curTime=new Date();
        //朝九晚五正常挂号费假设10块，其他时间算加班要20
        SimpleDateFormat sdf=new SimpleDateFormat("HH");
        int hour=Integer.parseInt(sdf.format(curTime));
        Double price=10.0;
        if(hour>17 || hour<9){
            price=20.0;
        }
        Reg reg=new Reg(0,patientId, deptId,curTime,price);
        RegDao.insert(reg);
        System.out.println("挂号成功.");
    }
}
