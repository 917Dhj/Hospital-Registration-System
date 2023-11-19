package hospital.model;

public class Dept {
    private Integer id;
    private String name;
    private Integer type;
    private String remark;

    public Dept (){}
    public Dept(Integer id,String name,Integer type,String remark){
        this.id=id;
        this.name=name;
        this.type=type;
        this.remark=remark;
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

    public Integer getType(){
        return type;
    }
    public void setType(Integer type){
        this.type=type;
    }

    public String getRemark(){
        return remark;
    }
    public void setRemark(String remark){
        this.remark=remark;
    }

    public String toString(){
        return "Dept{" +
                "id="+ id +
                ",name='" + name + '\'' +
                ",type='" + type +
                ",remark='" + remark + '\'' +
                '}';
    }
}
