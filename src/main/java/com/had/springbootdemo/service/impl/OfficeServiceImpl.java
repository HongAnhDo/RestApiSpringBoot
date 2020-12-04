package com.had.springbootdemo.service.impl;

import com.had.springbootdemo.constains.ApplicationConstants;
import com.had.springbootdemo.entity.OfficeEntity;
import com.had.springbootdemo.exceptions.ResponseException;
import com.had.springbootdemo.repository.OfficeRepository;
import com.had.springbootdemo.service.base.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficeServiceImpl implements OfficeService {
    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public OfficeEntity findById(Long officeId) {

        return officeRepository.findInfoOfficeById(officeId)
                .orElseThrow(() -> new ResponseException(ApplicationConstants.VALIDATION_OFFICE_ID));
    }
}
