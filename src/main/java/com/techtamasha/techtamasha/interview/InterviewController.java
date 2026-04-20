package com.techtamasha.techtamasha.interview;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InterviewController {

    @GetMapping("/")
    public String startInterview(Model model) {

        List<String> questions = List.of(
                "What is Java?",
                "Explain OOP concepts"
        );

        model.addAttribute("questions", questions);
        return "interview";
    }
    
    List<String> modelAnswers = List.of(
    	    "Java is object oriented programming language",
    	    "Encapsulation inheritance polymorphism abstraction"
    	);

    @PostMapping("/submit")
    @ResponseBody
    public String submit(@RequestBody Map<String, Object> data) {

        List<String> userAnswers = (List<String>) data.get("answers");

        double totalScore = 0;

        for (int i = 0; i < userAnswers.size(); i++) {

            String userAns = userAnswers.get(i);
            String modelAns = modelAnswers.get(i);

            double score = SimilarityUtil.calculate(userAns, modelAns);

            totalScore += score;

            System.out.println("Q" + (i + 1) + " Score: " + score);
        }

        double finalScore = totalScore / userAnswers.size();

        System.out.println("Final Score: " + finalScore);

        return "Your Score: " + finalScore + "%";
    }
}