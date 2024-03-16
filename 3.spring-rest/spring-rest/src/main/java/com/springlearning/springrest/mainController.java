package com.springlearning.springrest;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class mainController {

    List<Message> messages;

    public mainController() {
        this.messages = new ArrayList<>();
    }

    @GetMapping("/getMessage")
    public Message getMessage(@RequestParam(value = "index", defaultValue = "0") int index){
        System.out.println("index is " + index);
        if(index >= this.messages.size()){
            return new Message();
        }
        return this.messages.get(index);
    }

    @PostMapping(value = "/postMessage")
    public void postMessage(@RequestBody Message requestBody){
        System.out.println(requestBody.toString());
        messages.add(requestBody);
    }

    @PostMapping("/rawData")
    public String handleRawData(HttpServletRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (Exception e) {
            // Handle exception
        }
        String rawData = stringBuilder.toString();
        // Your logic to handle the raw data
        return "Received raw data: " + rawData;
    }

}
