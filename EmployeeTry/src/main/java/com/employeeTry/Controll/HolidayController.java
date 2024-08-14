package com.employeeTry.Controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.employeeTry.Repo.HolidayRepository;
import com.employeeTry.entity.Holiday;

import java.util.List;

@RestController
@RequestMapping("/holidays")
public class HolidayController {

    @Autowired
    private HolidayRepository holidayRepository;

    @GetMapping
    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }

    @PostMapping
    public Holiday createHoliday(@RequestBody Holiday holiday) {
        return holidayRepository.save(holiday);
    }
}