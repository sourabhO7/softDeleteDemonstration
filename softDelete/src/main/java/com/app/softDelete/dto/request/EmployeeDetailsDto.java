package com.app.softDelete.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailsDto {
    private String name;
    private String email;
    private String phoneNo;
    private ZonedDateTime dateOfBirth;
}
