package com.springlearning.springrest;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Message {
    private String name;
    private int age;
}
