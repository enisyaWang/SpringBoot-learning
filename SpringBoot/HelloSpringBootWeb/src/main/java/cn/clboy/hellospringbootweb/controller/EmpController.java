package cn.clboy.hellospringbootweb.controller;

import cn.clboy.hellospringbootweb.dao.DepartmentDao;
import cn.clboy.hellospringbootweb.dao.EmployeeDao;
import cn.clboy.hellospringbootweb.entities.Department;
import cn.clboy.hellospringbootweb.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @Author cloudlandboy
 * @Date 2019/11/17 下午12:44
 * @Since 1.0.0
 */

@Controller
public class EmpController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //准备部门下拉框数据
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @GetMapping("/emps")
    public String emps(Model model) {
        Collection<Employee> empList = employeeDao.getAll();
        model.addAttribute("emps", empList);
        return "emp/list";
    }

    @PostMapping("/emp")
    public String add(Employee employee) {
        System.out.println(employee);
        //模拟添加到数据库
        employeeDao.save(employee);
        //添加成功重定向到列表页面
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        //准备部门下拉框数据
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("emp", employee).addAttribute("departments", departments);
        return "emp/edit";
    }

    @PutMapping("/emp")
    public String update(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable String id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}