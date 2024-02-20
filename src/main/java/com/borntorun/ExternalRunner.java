package com.borntorun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalRunner {
    private Long id;
    private String name;
    private String email;
    private boolean active;
    private String gender;
    private int age;
}

