package com.had.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OfficeDTO implements Serializable {
    private Long id;
    private String name;
    private String address;
    private String code;
    private  CompanyDTO companyDTO;

    private List<UserDTO> users;
}
