package com.example.ballet.controller;

import com.example.ballet.data.entity.ScheduleEntity;
import com.example.ballet.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/users/list")
    public List<ScheduleEntity> GetUserList(){
        return scheduleService.findAll();
    }
}
