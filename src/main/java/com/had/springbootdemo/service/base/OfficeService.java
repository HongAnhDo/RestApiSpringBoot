package com.had.springbootdemo.service.base;

import com.had.springbootdemo.entity.OfficeEntity;

public interface OfficeService {
    OfficeEntity findById(Long officeId);
}
