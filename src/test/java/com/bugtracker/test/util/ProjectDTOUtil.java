package com.bugtracker.test.util;

import com.bugtracker.dto.ProjectDTO;

public class ProjectDTOUtil {

    public static ProjectDTO createProjectDTO() {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("Issue Tracker");
        projectDTO.setDescription("It's my project");
        return projectDTO;
    }
}
