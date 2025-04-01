package com.app.softDelete.service.impl;

import com.app.softDelete.dto.response.GeneralResponseDto;
import com.app.softDelete.dto.request.EmployeeDetailsDto;
import com.app.softDelete.exception.ResourceNotFoundException;
import com.app.softDelete.model.Employee;
import com.app.softDelete.repository.EmployeeRepository;
import com.app.softDelete.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.app.softDelete.util.ConstantUtility.BOOLEAN_VALUE_TRUE;
import static com.app.softDelete.util.ConstantUtility.EMPLOYEE;
import static com.app.softDelete.util.ConstantUtility.EMPLOYEE_CREATED;
import static com.app.softDelete.util.ConstantUtility.EMPLOYEE_DELETED;
import static com.app.softDelete.util.ConstantUtility.EMPLOYEE_ID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public GeneralResponseDto createEmployee(EmployeeDetailsDto employeeRequestDto) {
        Employee employee = objectMapper.convertValue(employeeRequestDto, Employee.class);
        Employee created = employeeRepository.save(employee);
        return new GeneralResponseDto(created.getId(), EMPLOYEE_CREATED);
    }

    @Override
    public GeneralResponseDto deleteEmployee(Long id) {
        Employee employee = employeeRepository.findByIdAndArchivedFalse(id).orElseThrow(
                () -> new ResourceNotFoundException(EMPLOYEE, EMPLOYEE_ID, id)
        );
        employee.setArchived(BOOLEAN_VALUE_TRUE);
        employeeRepository.save(employee);
        return new GeneralResponseDto(id,EMPLOYEE_DELETED);
    }

    @Override
    public EmployeeDetailsDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(EMPLOYEE, EMPLOYEE_ID, id)
        );
        return objectMapper.convertValue(employee, EmployeeDetailsDto.class);
    }

}
