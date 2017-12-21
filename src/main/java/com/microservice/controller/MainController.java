package com.microservice.controller;

import com.microservice.model.AppUsers;
import com.microservice.repository.AppUsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

    @Autowired
    AppUsersRepo appRepo;

    @RequestMapping("/appusers")
    public ModelAndView doHome(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("lists",appRepo.findAll());
        return mv;
    }
    @RequestMapping( value = "/appusers/save", method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("id") String id, @RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName){
        ModelAndView mv = new ModelAndView("redirect:/appusers");
        AppUsers users;
        if(!id.isEmpty()){
            users =(AppUsers)appRepo.findOne(Integer.parseInt(id));
        } else {
            users = new AppUsers();
        }
        users.setFirstName(firstName);
        users.setLastName(lastName);
        appRepo.save(users);
        return mv;
    }

    @RequestMapping( value = "/appusers/view/{id}", method = RequestMethod.GET)
    public ModelAndView doView(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("view");
        mv.addObject("lists",appRepo.findOne(id));
        return mv;
    }

    @RequestMapping( value = "/appusers/delete/{id}", method = RequestMethod.GET)
    public ModelAndView doDelete(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("redirect:/appusers");
        appRepo.delete(id);
        return mv;
    }

    @RequestMapping( value = "/appusers/edit/{id}", method = RequestMethod.GET)
    public ModelAndView doEdit(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("lists",appRepo.findOne(id));
        return mv;
    }
}
