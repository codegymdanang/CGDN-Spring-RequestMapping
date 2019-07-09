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


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(){
        List<Student> students = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("index","students",students);
        return modelAndView;
    }

    //in requestMapping method.get is default
    @RequestMapping(value = "/Student/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create","student",new Student());
        return modelAndView;
    }

    @RequestMapping(value="/Student/create",method = RequestMethod.POST)
    public String create(@ModelAttribute("student") Student student, RedirectAttributes redirect){
        int id = (int) (Math.random() * 10000);
        student.setId(id);
        studentService.save(student);
        redirect.addFlashAttribute("success", "Created student successfully!");
        return "redirect:/";
    }

    @RequestMapping(value = "/Student/edit/{id}")
    public ModelAndView edit(@PathVariable int id, Model model) {
        ModelAndView modelAndView = new ModelAndView("edit", "student",studentService.findById(id) );
        return modelAndView;
    }

    @RequestMapping(value="/Student/edit/{id}",method = RequestMethod.POST)
    public String edit(@ModelAttribute("student") Student student,RedirectAttributes redirect){
        studentService.update(student.getId(), student);
        redirect.addFlashAttribute("success", "Edited student successfully!");
        return "redirect:/";
    }

    @RequestMapping("/Student/delete/{id}")
    public ModelAndView delete(@PathVariable int id, Model model) {
        ModelAndView modelAndView = new ModelAndView("delete","student",studentService.findById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/Student/delete/{id}", method = RequestMethod.POST)
    public String delete(Student student, RedirectAttributes redirect) {
        studentService.remove(student.getId());
        redirect.addFlashAttribute("success", "Removed student successfully!");
        return "redirect:/";
    }

}
