package com.had.springbootdemo.mapper;

import com.had.springbootdemo.dto.OfficeDTO;
import com.had.springbootdemo.dto.UserDTO;
import com.had.springbootdemo.entity.OfficeEntity;
import com.had.springbootdemo.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class OfficeMapperImpl implements OfficeMapper {
    private final UserMapper userMapper = UserMapper.INSTANCE;
    private final CompanyMapper companyMapper = CompanyMapper.INSTANCE;

    @Override
    public OfficeDTO toDto(OfficeEntity office) {
        if (office == null) {
            return null;
        }

        OfficeDTO officeDTO = new OfficeDTO();

        officeDTO.setId(office.getId());
        officeDTO.setUsers(listUserEntityToDTO(office.getUsers()));
        officeDTO.setCompanyDTO(companyMapper.getCompanyFromEntity(office.getCompany()));
        return  officeDTO;
    }

    protected List<UserDTO> listUserEntityToDTO(List<UserEntity> list) {
        if (list == null) {
            return null;
        }
        return list.stream().map(item -> userMapper.getUserFromEntity(item))
                .collect(Collectors.toList());
    }


}
