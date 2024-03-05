package com.example.ballet.service;

import com.example.ballet.data.entity.ScheduleEntity;
import com.example.ballet.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public List<ScheduleEntity> findAll() {
        return scheduleRepository.findAll();
    }
}
