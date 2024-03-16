package com.springlearning.springjdbc;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private long id;
    private String firstName;
    private String lastName;
    private String Address;
}
