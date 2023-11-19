package hospital.service;

import hospital.dao.DoctorDao;
import hospital.model.Doctor;

import java.util.List;

public class DoctorService {

    //医生注册
    public static void regist(Integer id,String name,String password,Integer sex,Integer deptId){
        List<Doctor> models = DoctorDao.select(null, name,null,null,null);
        if(models.size()>0){
            System.out.println("医生[" + name + "]已存在.");
            System.out.println(name);
        }
        else{
            Doctor model=new Doctor(id,name,deptId,sex,password);
            DoctorDao.insert(model);
            System.out.println("医生注册成功.");
        }
    }

    //医生登陆
    public static Doctor login(String username,String password){
        Doctor model=null;
        List<Doctor> models=DoctorDao.select(null,username,null,null,password);
        if(models.size()>0){
            model = models.get(0);
            System.out.println("医生[" + model.getName() + "]登陆成功.");
        }
        else{
            System.out.println("医生账号或密码错误，登陆失败.");
        }
        return model;
    }
}
