package com.had.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompanyDTO implements Serializable {
    private Long id;
    private String name;
    private String address;
    private String code;
    private List<OfficeDTO> offices;
}
