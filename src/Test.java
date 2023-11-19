import hospital.dao.DeptDao;
import hospital.model.Dept;
import hospital.dao.RegDao;
import hospital.model.Reg;
import java.util.List;
import java.sql.Timestamp;
import hospital.model.Doctor;
import hospital.dao.DoctorDao;

public class Test {
    public static void main(String[] args){
        //增
        //DeptDao.insert(new Dept(202200011,"皮肤科",0,"皮肤科门诊"));
        //DoctorDao.insert(new Doctor(1,"Alfred",202200011,1,"20212113036"));
        //PatientDao.insert(new Patient(202100011,"灰太狼",1,3,"101010"));
        //RegDao.insert(new Reg(11,202100011,202200011, Timestamp.valueOf("2022-11-20 00:00:00"),130.0));

        //删
        //DeptDao.delete(202200011);
        //DoctorDao.delete(202200031);
        //PatientDao.delete(202100011);
        //RegDao.delete(202100011);

        //改
        //DeptDao.update(new Dept(202200003,"骨科",0,"修改"));
        //DoctorDao.update(new Doctor(202200011,"海绵宝宝",202200001,1,"88888888"));
        //PatientDao.update(new Patient(202100010,"暖羊羊",1,3,"999999"));
        //RegDao.update(new Reg(1,202100001,202200001,Timestamp.valueOf("2022-10-01 00:00:00"),111.0));

        //查
        //List<Dept> res=DeptDao.select(null,null,null);
        //res.forEach(System.out::println);
        //List<Doctor> res=DoctorDao.select(null,"泡芙老师",null,null,null);
        //res.forEach(System.out::println);
        //List<Patient> res=PatientDao.select(202100001,null,null,null,null);
        //res.forEach(System.out::println);
        List<Reg> res=RegDao.select(null,null,202200010,"2022-12-28",null);
        res.forEach(System.out::println);
    }
}
