package com.example.FeedbackProject.Service;

import com.example.FeedbackProject.Entity.Result;
import com.example.FeedbackProject.Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public Result storeResult(Result res){
        Result result =this.resultRepository.save(res);
        return res;
    }
}
