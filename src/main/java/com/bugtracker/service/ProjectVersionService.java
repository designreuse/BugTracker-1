package com.bugtracker.service;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.dto.ProjectVersionDTO;

import java.util.Set;

public interface ProjectVersionService {

    ProjectVersionDTO addProjectVersion(String projectName, ProjectVersionDTO projectVersionDTO);
    ProjectVersionDTO getByName(String name);
    ProjectVersionDTO getById(long id);
    ProjectVersionDTO editProjectVersion(ProjectVersionDTO projectVersionDTO);
    void delete(long id);

    Set<IssueDTO> getIssues(long id);
    ProjectDTO getProject(long id);
}
