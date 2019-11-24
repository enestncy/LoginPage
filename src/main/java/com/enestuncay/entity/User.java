package com.enestuncay.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String customerId;

    @Column(nullable = false)
    private String hashPassword;

    @Column
    private Date lastLoginTime;

    @Column
    private int state;

    @Column
    private Date lastUpdateTime;

    @Column
    private String hashType;

    @Transient
    private String ctrlPass; //has no column in database


    //Getter and Setter
    public Long getId() {return Id;}

    public void setId(Long id) {Id = id;}

    public String getCustomerId() {return customerId;}

    public void setCustomerId(String customerId) {this.customerId = customerId;}

    public String getHashPassword() {return hashPassword;}

    public void setHashPassword(String hashPassword) {this.hashPassword = hashPassword;}

    public Date getLastLoginTime() {return lastLoginTime;}

    public void setLastLoginTime(Date lastLoginTime) {this.lastLoginTime = lastLoginTime;}

    public int getState() {return state;}

    public void setState(int stat) {this.state = stat;}

    public Date getLastUpdateTime() {return lastUpdateTime;}

    public void setLastUpdateTime(Date lastUpdateTime) {this.lastUpdateTime = lastUpdateTime;}

    public String getHashType() {return hashType;}

    public void setHashType(String hashType) {this.hashType = hashType;}

    public String getCtrlPass() {return ctrlPass;}

    public void setCtrlPass(String ctrlPass) {this.ctrlPass = ctrlPass;}

    //toString
    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", customerId='" + customerId + '\'' +
                ", hashPassword='" + hashPassword + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", state=" + state +
                ", lastUpdateTime=" + lastUpdateTime +
                ", hashType='" + hashType + '\'' +
                ", ctrlPass='" + ctrlPass + '\'' +
                '}';
    }
}
