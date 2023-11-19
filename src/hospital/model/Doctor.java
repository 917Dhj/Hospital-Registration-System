package hospital.model;

public class Doctor {
    private Integer id;
    private String name;
    private Integer deptId;
    private Integer sex;
    private String password;

    public Doctor(){}
    public Doctor(Integer id,String name,Integer deptId,Integer sex,String password){
        this.id=id;
        this.name=name;
        this.deptId=deptId;
        this.sex=sex;
        this.password=password;
    }

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public Integer getDeptId(){
        return deptId;
    }
    public void setDeptId(Integer deptId){
        this.deptId=deptId;
    }
    public Integer getSex(){
        return sex;
    }
    public void setSex(Integer sex){
        this.sex=sex;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public String toString(){
        return "Doctor{" +
                "id="+ id +
                ",name='" + name + '\'' +
                ",deptId='" + deptId +
                ",sex='" + sex +
                ",password='" + password + '\'' +
                '}';
    }
}
