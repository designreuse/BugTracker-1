package com.bugtracker.controller;

import com.bugtracker.entity.Issue;
import com.bugtracker.service.IssueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Vlados on 3/30/2016.
 */
@Controller
public class IssueController {

    @Resource
    private IssueService issueService;

    @RequestMapping(value = "/createIssue", method = RequestMethod.POST)
    public ModelAndView createIssue(Issue issue, String[] NAME) {
        System.out.println(issue.getName());
        System.out.println(issue.getIssueType());
        System.out.println(issue.getSummary());
        System.out.println(issue.getPriority());
        if (NAME != null)
        for(int i = 0; i < NAME.length; i++) {
            System.out.println(NAME[i]);
        }
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
}
