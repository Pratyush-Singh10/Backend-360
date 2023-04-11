package com.example.FeedbackProject.Controller;

import com.example.FeedbackProject.Entity.Employee;
import com.example.FeedbackProject.Entity.Result;
import com.example.FeedbackProject.Repository.ResultRepository;
import com.example.FeedbackProject.Service.EmployeeService;
import com.example.FeedbackProject.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/result/")
public class ResultController {

    @Autowired
    private ResultService resultService;
    @Autowired
    private ResultRepository resultRepository;

    @PostMapping("/")
    public ResponseEntity<Result> insertResult(@RequestBody Result res) {
        Result result = this.resultService.storeResult(res);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @GetMapping("/res")
    public List<Result> getResult(){
        List<Result> res= resultRepository.findAll();
        return res;
    }


}
