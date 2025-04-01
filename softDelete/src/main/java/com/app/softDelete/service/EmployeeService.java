package com.app.softDelete.service;

import com.app.softDelete.dto.response.GeneralResponseDto;
import com.app.softDelete.dto.request.EmployeeDetailsDto;

public interface EmployeeService {
    GeneralResponseDto createEmployee(EmployeeDetailsDto employeeResponseDto);
    GeneralResponseDto deleteEmployee(Long id);
    EmployeeDetailsDto getEmployeeById(Long id);
}
