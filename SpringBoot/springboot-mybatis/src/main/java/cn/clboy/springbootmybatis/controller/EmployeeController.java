package cn.clboy.springbootmybatis.controller;

import cn.clboy.springbootmybatis.mapper.EmployeeMapper;
import cn.clboy.springbootmybatis.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author cloudlandboy
 * @Date 2019/11/23 上午10:57
 * @Since 1.0.0
 */

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @RequestMapping("/emp/list")
    public List<Employee> getALl() {
        return employeeMapper.selectAll();
    }

    @RequestMapping("/emp/{id}")
    public Employee save(Employee employee) {
        employeeMapper.save(employee);
        return employee;
    }
}