package hospital.model;

public class Patient {
    private Integer id;
    private String name;
    private Integer sex;
    private Integer age;
    private String password;

    public Patient(){}
    public Patient(Integer id,String name,Integer sex,Integer age,String password){
        this.id=id;
        this.name=name;
        this.sex=sex;
        this.age=age;
        this.password=password;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getSex() {
        return sex;
    }
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
