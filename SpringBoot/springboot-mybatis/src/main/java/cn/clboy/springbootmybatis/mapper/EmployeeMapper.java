package cn.clboy.springbootmybatis.mapper;

import cn.clboy.springbootmybatis.model.Employee;

import java.util.List;

/**
 * @Author cloudlandboy
 * @Date 2019/11/23 上午10:38
 * @Since 1.0.0
 */

public interface EmployeeMapper {

    List<Employee> selectAll();

    int save(Employee employee);
}