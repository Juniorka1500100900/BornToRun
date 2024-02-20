package com.borntorun;

import lombok.Data;

@Data
public class RunnerDto {
    private String name;
    private String email;
    private String gender;
    private boolean active;
    private int age;

}
