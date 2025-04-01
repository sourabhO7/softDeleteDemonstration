package com.app.softDelete.controller;

import com.app.softDelete.dto.request.EmployeeDetailsDto;
import com.app.softDelete.dto.response.GeneralResponseDto;
import com.app.softDelete.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<GeneralResponseDto> saveEmployee(
            @RequestBody EmployeeDetailsDto employeeDetailsDto
    ) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDetailsDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDetailsDto> getEmployeeById(
            @PathVariable Long id
    ) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponseDto> deleteEmployeeById(
            @PathVariable Long id
    ) {
        return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK);
    }
}
