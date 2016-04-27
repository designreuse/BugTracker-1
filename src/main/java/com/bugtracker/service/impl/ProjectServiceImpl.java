package com.bugtracker.service.impl;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.dto.ProjectVersionDTO;
import com.bugtracker.entity.ProjectComponent;
import com.bugtracker.entity.ProjectVersion;
import com.bugtracker.mapper.IssueMapper;
import com.bugtracker.mapper.ProjectComponentMapper;
import com.bugtracker.mapper.ProjectMapper;
import com.bugtracker.mapper.ProjectVersionMapper;
import com.bugtracker.repository.IssueRepository;
import com.bugtracker.repository.ProjectComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bugtracker.repository.ProjectRepository;
import com.bugtracker.service.ProjectService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private ProjectComponentRepository projectComponentRepository;

    @Autowired
    private ProjectMapper mapper;

    @Autowired
    private IssueMapper issueMapper;

    @Autowired
    private ProjectComponentMapper projectComponentMapper;

    @Autowired
    private ProjectVersionMapper projectVersionMapper;

    @Override
    public ProjectDTO addProject(MultipartFile image, ProjectDTO projectDTO) {
        try {
            if (image != null) {
                projectDTO.setAvatar(image.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ProjectDTO savedProject = mapper.projectToProjectDTO(projectRepository.saveAndFlush(mapper.projectDTOToProject(projectDTO)));

        return savedProject;
    }


    @Override
    public void delete(long id) {
        projectRepository.delete(id);
    }

    @Override
    public void delete(String name) {
        projectRepository.delete(projectRepository.findByName(name).getId());
    }

    @Override
    public ProjectDTO getByName(String name) {
        return mapper.projectToProjectDTO(projectRepository.findByName(name));
    }

    @Override
    public ProjectDTO getById(long id) {
        return mapper.projectToProjectDTO(projectRepository.findById(id));
    }

    @Override
    public ProjectDTO getByIssueId(long id) {
        return mapper.projectToProjectDTO(issueRepository.getById(id).getProject());
    }


    @Override
    public ProjectDTO getByProjectComponentId(long id) {
        return mapper.projectToProjectDTO(projectComponentRepository.getById(id).getProject());
    }


    @Override
    public ProjectDTO editProject(MultipartFile image, String name, ProjectDTO editedProjectDTO) {

        ProjectDTO projectDTO = getByName(name);
        projectDTO.setName(editedProjectDTO.getName());
        projectDTO.setDescription(editedProjectDTO.getDescription());
        projectDTO.setPrivacy(editedProjectDTO.isPrivacy());

        try {
            if (image.getBytes().length != 0) {
                projectDTO.setAvatar(image.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapper.projectToProjectDTO(projectRepository.saveAndFlush(mapper.projectDTOToProject(projectDTO)));
    }

    @Override
    public List<String> getAllNames() {
        return projectRepository.findAllNames();
    }

    @Override
    public Map<Long, String> getAllComponentsNameAndId(String projectName) {
        Map<Long, String> componentNames = new HashMap<Long, String>();
        Set<ProjectComponent> components = projectRepository.findByName(projectName).getComponents();
        for(ProjectComponent projectComponent : components) {
            componentNames.put(projectComponent.getId(), projectComponent.getName());
        }
        return componentNames;
    }

    @Override
    public Map<Long, String> getAllVersionsNameAndId(String projectName) {
        Map<Long, String>  versionNames = new HashMap<Long, String>();
        Set<ProjectVersion> versions = projectRepository.findByName(projectName).getVersions();
        for(ProjectVersion projectVersion : versions) {
            versionNames.put(projectVersion.getId(), projectVersion.getName());
        }
        return versionNames;
    }

    @Override
    public Set<IssueDTO> getIssues(String projectName) {
        return issueMapper.issuesToIssueDTOs(projectRepository.findByName(projectName).getIssues());
    }

    @Override
    public Set<ProjectComponentDTO> getProjectComponents(String projectName) {
        return projectComponentMapper.projectComponentsToProjectComponentDTOs(projectRepository.findByName(projectName).getComponents());
    }

    @Override
    public Set<ProjectVersionDTO> getProjectVersions(String projectName) {
        return projectVersionMapper.projectVersionsToProjectVersionDTOs(projectRepository.findByName(projectName).getVersions());
    }
}
