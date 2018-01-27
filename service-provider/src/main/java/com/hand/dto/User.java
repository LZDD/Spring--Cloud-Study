package com.hand.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by 亮着的灯 on 2018/1/3.
 */
@Entity(name="User")
public class User {

    //使用该注解描述属性信息，当hidden=true时，该属性不会做在api中显示
    @ApiModelProperty(value = "主键",hidden = false,notes = "主键，隐藏",required = true,dataType = "Long")
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    @Column
    private String username;

    @ApiModelProperty(value = "用户名字")
    @Column
    private String name;

    @ApiModelProperty(value = "年龄")
    @Column
    private Integer age;

    @ApiModelProperty(value = "薪资")
    @Column
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", balance=" + balance +
                '}';
    }
}
