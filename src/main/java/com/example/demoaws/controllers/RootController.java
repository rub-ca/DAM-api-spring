package com.example.demoaws.controllers;

import com.example.demoaws.models.Job;
import com.example.demoaws.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RootController {

    @Autowired
    private JobService jobService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/edit/job")
    public String editJob() {
        return "edit";
    }

    @RequestMapping("/show/job")
    public String showJob(Model model) {
        List<Job> jobs = jobService.getAllJobs();
        model.addAttribute("jobs", jobs);
        return "show";
    }

    @PostMapping("/edit/job")
    public String prueba(@RequestParam String job_title, @RequestParam String min_salary, @RequestParam String max_salary, Model model) {
        try {
            Job nuevoJob = new Job();
            nuevoJob.setJob_title(job_title);
            nuevoJob.setMax_salary(Long.parseLong(max_salary));
            nuevoJob.setMin_salary(Long.parseLong(min_salary));
            jobService.saveJob(nuevoJob);
            model.addAttribute("message", "El Job ha sido posteado");
            return "index";
        } catch (NumberFormatException nfe) {
            model.addAttribute("message", "El salario debe ser un numero");
            return "index";
        }
    }

    @DeleteMapping("/edit/job")
    public String prueba(@RequestParam String idborrar, Model model) {
        // En el metodo delete debemos comprobar si existe o no el id
        // Si el id existe se borra existosamente, si no se informa que no existe
        // Tambien hay que comprobar si el id es un numero
        try {
            Long buscando = Long.parseLong(idborrar);
            if (jobService.getJobById(buscando) == null) {
                model.addAttribute("message", "El Job no existe");
                return "index";
            }

            jobService.deleteJob(buscando);
            model.addAttribute("message", "El Job ha sido eliminado");
            return "index";
        } catch (NumberFormatException nfe) {
            model.addAttribute("message", "El id es un numero");
            return "index";
        }
    }

    @PutMapping("/edit/job")
    public String putJob(@RequestParam String pid, @RequestParam String pjob_title, @RequestParam String pmin_salary,
                         @RequestParam String pmax_salary, Model model) {
        try {
            Long buscando = Long.parseLong(pid);
            Job aSusituir = jobService.getJobById(buscando);

            if (aSusituir == null) {
                model.addAttribute("message", "El Job no existe");
                return "index";
            }

            Job nuevoJob = new Job();
            boolean changed = false;
            if (pjob_title.isEmpty()) {
                nuevoJob.setJob_title(aSusituir.getJob_title());
            } else {
                changed = true;
                nuevoJob.setJob_title(pjob_title);
            }

            if (pmax_salary.isEmpty()) {
                nuevoJob.setMax_salary(aSusituir.getMax_salary());
            } else {
                changed = true;
                nuevoJob.setMax_salary(Long.parseLong(pmax_salary));
            }

            if (pmin_salary.isEmpty()) {
                nuevoJob.setMin_salary(aSusituir.getMin_salary());
            } else {
                changed = true;
                nuevoJob.setMin_salary(Long.parseLong(pmin_salary));
            }

            if (!changed) {
                model.addAttribute("message", "No se ha realizado ningún cambio");
                return "index";
            }

            jobService.updateJob(buscando, nuevoJob);
            model.addAttribute("message", "El job ha sido actualizado");
            return "index";
        } catch (NumberFormatException nfe) {
            model.addAttribute("message", "El valor debe ser un numero");
            return "index";
        }
    }
}
