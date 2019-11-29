package cn.clboy.springbootmybatis.controller;

import cn.clboy.springbootmybatis.mapper.DepartmentMapper;
import cn.clboy.springbootmybatis.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author cloudlandboy
 * @Date 2019/11/22 下午8:58
 * @Since 1.0.0
 */

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentMapper departmentMapper;

    @RequestMapping("/dep/{id}")
    public List<Department> getDepById(@PathVariable Integer id) {
        return departmentMapper.selectAll();
    }

    @RequestMapping("/dep")
    public Department getDepById(Department department) {
        departmentMapper.save(department);
        return department;
    }
}