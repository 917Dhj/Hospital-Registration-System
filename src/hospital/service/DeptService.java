package hospital.service;

import hospital.dao.DeptDao;
import hospital.model.Dept;

import java.util.List;

public class DeptService {

    public static List<Dept> showAllDept(){
        List<Dept> list = DeptDao.select(null,null,null);
        //System.out.println("当前部门如下：");
        //list.forEach(item->System.out.println(item));
        return list;
    }

    public static void add(Integer id,String name,Integer type,String remark){
        Dept model=new Dept(id,name,type,remark);
        DeptDao.insert(model);
        System.out.println("添加部门成功：" + model);
    }

    public static void update(Integer id,String name,Integer type,String remark){
        Dept model=new Dept(id,name,type,remark);
        DeptDao.update(model);
        System.out.println("修改完成.");
    }

    public static void del(Integer id){
        DeptDao.delete(id);
        System.out.println("删除完成.");
    }
}
