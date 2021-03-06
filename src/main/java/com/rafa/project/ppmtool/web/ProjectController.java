package com.rafa.project.ppmtool.web;

import com.rafa.project.ppmtool.domain.Project;
import com.rafa.project.ppmtool.services.MapValidationErrorService;
import com.rafa.project.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){

        ResponseEntity<?> responseEntityErrors = mapValidationErrorService.mapValidationService(result);
        if(responseEntityErrors != null) return responseEntityErrors;
        return new ResponseEntity<>(projectService.saveOrUpdate(project), HttpStatus.CREATED);
    }

}
