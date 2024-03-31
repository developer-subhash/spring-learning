package org.springlearning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppTest {

    @Test(expected = NullPointerException.class)
    void contextLoads() {
    }
}
