package com.had.springbootdemo.controller;

import com.had.springbootdemo.dto.OfficeDTO;
import com.had.springbootdemo.entity.OfficeEntity;
import com.had.springbootdemo.mapper.OfficeMapper;
import com.had.springbootdemo.mapper.OfficeMapperImpl;
import com.had.springbootdemo.service.base.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/office")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    /**
     *
     * @param officeId
     * @return ResponseEntity<OfficeEntity>
     */
    @GetMapping("/{officeId}")
    public ResponseEntity<OfficeDTO> getInfoOffice(@PathVariable(value = "officeId") Long officeId) {
        System.out.printf("aaaa");
        OfficeMapper officeMapper = new OfficeMapperImpl();
        OfficeEntity office = officeService.findById(officeId);
        return ResponseEntity.ok(officeMapper.toDto(office));
    }
    @GetMapping("/test")
    public String test(){
        return "Hong ANh do";
    }
}
