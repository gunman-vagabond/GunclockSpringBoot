package com.gunman.Gunclock;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gunman.GunClockBean;

@Controller
@RequestMapping("/gunclocks")
public class GunclockController {
    @Autowired
    private GunclockService gunclockService;

    @GetMapping
    public String index(Model model) {
        List<Gunclock> gunclocks = gunclockService.findAll();
        model.addAttribute("gunclocks", gunclocks);
        return "gunclocks/index";
    }

    @GetMapping("new")
    public String newGunclock(Model model) {
        return "gunclocks/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Gunclock gunclock = gunclockService.findOne(id);
        model.addAttribute("gunclock", gunclock);
        return "gunclocks/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        Gunclock gunclock = gunclockService.findOne(id);
        model.addAttribute("gunclock", gunclock);

        GunClockBean gcBean = new GunClockBean();
        gcBean.setStrNewline("\n");
        gcBean.setClockSize(gunclock.getSize());
        String gunclockString = gcBean.getGunClock();
        model.addAttribute("gunclockString", gunclockString);

        return "gunclocks/show";
    }

    @PostMapping
    public String create(@ModelAttribute Gunclock gunclock) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        gunclock.setCreatedDate(sdf.format(date));

        gunclockService.save(gunclock);
        return "redirect:/gunclocks";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Gunclock gunclock) {
        gunclock.setId(id);
        gunclockService.save(gunclock);
        return "redirect:/gunclocks";
    }

    @PostMapping("{id}/update")
    public String updatePost(@PathVariable Long id, @ModelAttribute Gunclock gunclock) {
        gunclock.setId(id);
        gunclockService.save(gunclock);
        return "redirect:/gunclocks";
    }


    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        gunclockService.delete(id);
        return "redirect:/gunclocks";
    }

    @PostMapping("{id}/delete")
    public String destroyPost(@PathVariable Long id) {
        gunclockService.delete(id);
        return "redirect:/gunclocks";
    }

}