package com.bugtracker.service;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.dto.ProjectVersionDTO;

import java.util.Set;

public interface IssueService {

    IssueDTO addIssue(IssueDTO issueDTO, long[] components, long[] versions, String projectName);
    IssueDTO getByName(String name);
    IssueDTO getById(long id);
    IssueDTO editIssue(IssueDTO issue);
    void delete(long id);

    Set<ProjectComponentDTO> getProjectComponents(long id);
    Set<ProjectVersionDTO> getProjectVersions(long id);



}
