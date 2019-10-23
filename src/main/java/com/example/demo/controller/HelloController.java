package com.example.demo.controller;

import com.example.demo.dao.NamesDAO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private final NamesDAO namesDAO;

    public HelloController(NamesDAO namesDAO) {
        this.namesDAO = namesDAO;
    }

    // Use curl -H "Content-Type: application/json" localhost:8080/hello/getNames
    @GetMapping("/getNames")
    public List<String> getNames() {
        return namesDAO.getNames();
    }

    // Use curl -H "Content-Type: application/json" -d "[\"Adil\",\"John\"]" localhost:8080/hello/addNames
    @PostMapping("/addNames")
    public List<String> addNames(@RequestBody List<String> names) {
        namesDAO.addNames(names);

        return names;
    }

    // Use curl -H "Content-Type: application/json" -d "[\"One\",\"Two\",\"Three\",\"Four\",\"Five\"]" localhost:8080/hello/reverse
    @PostMapping("/reverse")
    public List<String> reverseList(@RequestBody List<String> stringList) {
        return IntStream.range(0, stringList.size())
                .mapToObj(i -> stringList.get(stringList.size() - 1 - i))
                .collect(Collectors.toList());
    }

    // Use curl -H "multipart/form-data: Multipart form data (multipart/form-data)" -d "file: <your file>" localhost:8080/hello/readFile
    @PostMapping("/readFile")
    public String readFile(@RequestBody MultipartFile file) {
        return "Read file: " + file.getOriginalFilename();
    }
}
