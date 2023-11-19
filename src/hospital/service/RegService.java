package hospital.service;

import hospital.dao.RegDao;
import hospital.model.Reg;

import java.util.List;

public class RegService {
    //查看全部挂号记录
    public static void showAllRecord(){
        List<Reg> regs=RegDao.select(null,null,null,null,null);
        System.out.println("全部挂号记录查询如下：");
        regs.forEach(System.out::println);
    }

    //查看病人的挂号记录
    public static void showPatientRecord(Integer patientId,String beginTime,Integer price){
        List<Reg> regs=RegDao.select(null,patientId,null,beginTime,price);
        System.out.println("当前病人的挂号记录如下：");
        regs.forEach(System.out::println);
    }

    //查看医生所在部门挂号记录
    public static void showDoctorRecord(Integer deptId,String beginTime,Integer price){
        List<Reg> regs=RegDao.select(null,null,deptId,beginTime,null);
        System.out.println("本科室挂号记录如下：");
        regs.forEach(System.out::println);
    }

    //查询指定时间段内的挂号记录
    public static void showRecord(String timeString){
        String[] timeRange=timeString.split("-");
        List<Reg> regs=RegDao.select(null,null,null, timeString,null);
        System.out.println("该时间段内的挂号记录如下：");
        regs.forEach(System.out::println);
    }
}
