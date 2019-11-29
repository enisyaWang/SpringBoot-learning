package cn.clboy.springbootmybatis.model;

import java.io.Serializable;

/**
 * @Author cloudlandboy
 * @Date 2019/11/22 下午8:26
 * @Since 1.0.0
 */

public class Department implements Serializable {
    Integer id;
    String departmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}