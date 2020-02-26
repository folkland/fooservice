package ru.folkland.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/")
public class FooController {

    @Value("${foo}")
    private String foo;

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from " + foo);
    }

    @GetMapping("/say/{some}")
    public ResponseEntity<String> saySome(@PathVariable("some") String some) {
        return ResponseEntity.ok(foo + " get message: " + some);
    }

    @GetMapping("/param")
    public ResponseEntity<String> getParam(@RequestParam("params") int param) {
        return ResponseEntity.ok(foo + " get message: " + param);
    }

    @GetMapping("/response")
    public ResponseEntity<Response> getResponse(@RequestParam("name") String name, @RequestParam("age") int age) {
        Response response = new Response();
        response.setName(foo + " get " + name);
        response.setAge(age);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/request")
    public ResponseEntity<Response> getRequest(@RequestBody Request request) {
        Response response = new Response();
        response.setName(request.getMessage());
        response.setAge(request.getCount());
        response.setBool(request.isBool());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/exception")
    public ResponseEntity<Integer> getException() {
        return ResponseEntity.ok(getStringResponseEntity());
    }

    private int getStringResponseEntity() {
//        if (true) throw new IllegalArgumentException("Test test");
        int i = 10;
        i = i / 0;
        return 15;
    }

    @GetMapping("/model")
    public ResponseEntity<FooPeopleRequest> getModel(@ModelAttribute FooPeopleRequest fooPeopleRequest) {
        return ResponseEntity.ok(fooPeopleRequest);
    }

    @GetMapping("/date")
    public ResponseEntity<Date> getToday() {
        return ResponseEntity.ok(new Date());
    }
}
