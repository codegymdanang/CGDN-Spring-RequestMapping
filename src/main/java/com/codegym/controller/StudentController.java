package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.StudentService;
import com.codegym.service.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService = new StudentServiceImpl();

    //Phương thức index() hiển thị trang index với danh sách cho sẵn
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(){
        List<Student> students = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("index","students",students);
        return modelAndView;
    }

    //Trong requestMapping method.get là mặc định
    @RequestMapping(value = "/Student/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create","student",new Student());
        return modelAndView;
    }

    //Xử lý request method post từ Student/create
    @RequestMapping(value="/Student/create",method = RequestMethod.POST)
    public String create(@ModelAttribute("student") Student student, RedirectAttributes redirect){
        int id = (int) (Math.random() * 10000);
        student.setId(id);
        studentService.save(student);
        redirect.addFlashAttribute("success", "Created student successfully!");
        return "redirect:/";
    }

    //hiển thị trang edit
    @RequestMapping(value = "/Student/edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit", "student",studentService.findById(id) );
        return modelAndView;
    }

    //update thông tin student 
    @RequestMapping(value="/Student/edit/{id}",method = RequestMethod.POST)
    public String edit(@ModelAttribute("student") Student student,RedirectAttributes redirect){
        studentService.update(student.getId(), student);
        redirect.addFlashAttribute("success", "Edited student successfully!");
        return "redirect:/";
    }

    //Hiện thị trang delete
    @RequestMapping("/Student/delete/{id}")
    public ModelAndView delete(@PathVariable int id, Model model) {
        ModelAndView modelAndView = new ModelAndView("delete","student",studentService.findById(id));
        return modelAndView;
    }

    //delete student
    @RequestMapping(value = "/Student/delete/{id}", method = RequestMethod.POST)
    public String delete(Student student, RedirectAttributes redirect) {
        studentService.remove(student.getId());
        redirect.addFlashAttribute("success", "Removed student successfully!");
        return "redirect:/";
    }

}
