package hospital.model;

import java.util.Date;

public class Reg {
    private Integer id;
    private Integer patientId;
    private Integer deptId;
    private Date regTime;
    private Double price;

    public Reg(){}
    public Reg(Integer id, Integer patientId, Integer deptId, Date regTime, Double price) {
        this.id = id;
        this.patientId = patientId;
        this.deptId = deptId;
        this.regTime = regTime;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Reg{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", deptId=" + deptId +
                ", regTime=" + regTime +
                ", price=" + price +
                '}';
    }
}
