package com.CGIEXAM.cgiexam.controller;

import com.CGIEXAM.cgiexam.model.CareerModel;
import com.CGIEXAM.cgiexam.model.UsersModel;
import com.CGIEXAM.cgiexam.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CareerController {

    @Autowired
    private final CareerService careerService;

    public CareerController(CareerService careerService) {
        this.careerService = careerService;
    }

    @GetMapping("/addEntry")
    public String addEntry(Model model){
        model.addAttribute("addRequest", new CareerModel());
        return "career_obj_page";
    }

    @PostMapping("/addEntry")
    public String addCareer(@ModelAttribute CareerModel careerModel){
        CareerModel addNewCareer = careerService.addCareer(careerModel.getName(), careerModel.getDescription(),
                careerModel.getTargetDate(), careerModel.getCompletedDate());
        return addNewCareer == null ? "error_message" : "redirect:/career_obj_page";
    }

    @GetMapping("/career_obj_page")
    public String getAll(Model model){
        List<CareerModel> showCareers = careerService.getAll();
        model.addAttribute("showCareers", showCareers);
        return "career_obj_page";
    }

    @GetMapping("/career_goals")
    public String getAllData(Model model){
        List<CareerModel> showCareers = careerService.getAll();
        model.addAttribute("showCareers", showCareers);
        return "career_goals";
    }

    @GetMapping("/career_obj_page_edit")
    public String getAlls(Model model){
        List<CareerModel> showCareers = careerService.getAll();
        model.addAttribute("showCareers", showCareers);
        return "career_obj_page_edit";
    }

    @RequestMapping(value = "/career_obj_page/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        careerService.delete(id);
        return "redirect:/career_obj_page";
    }

    @RequestMapping(value = "/career_obj_page/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(@PathVariable Integer id, CareerModel careerModel){
        CareerModel updateData = careerService.addCareer(careerModel.getName(), careerModel.getDescription(),
                careerModel.getTargetDate(), careerModel.getCompletedDate());
        return "redirect:/career_obj_page";
    }

    @GetMapping("/career_obj_page/editEntry/{id}")
    public String editEntry(@PathVariable Integer id, Model model){
        CareerModel editEntry = careerService.getById(id);
        model.addAttribute("editEntry", editEntry);
        return "career_obj_page";
    }

    @RequestMapping(value = "/career_obj_page/update", method = RequestMethod.POST)
    @ResponseBody
    public String EntryUpdate(Model model,@RequestParam("id") Integer ID, @RequestParam("name") String Name, @RequestParam("desc") String desc, @RequestParam("start") String start, @RequestParam("complete") String complete) {

        CareerModel editEntry = careerService.editEntry(ID, Name,
                desc, start, complete);
//        model.addAttribute("editEntry", editEntry);

        return "career_obj_page";

    }


}
