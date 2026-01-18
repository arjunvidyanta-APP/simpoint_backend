package com.simpoint_enterprice.simpoint.Controller;

import com.simpoint_enterprice.simpoint.Dto.AssessmentResponse;
import com.simpoint_enterprice.simpoint.ServiceInterface.AssessmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.simpoint_enterprice.simpoint.EndPoint.ApiEndpoints.ASSESSMENT;
import static com.simpoint_enterprice.simpoint.EndPoint.ApiEndpoints.ASSESSMENT_ID;

@RestController
@Slf4j
@RequestMapping(ASSESSMENT)
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @GetMapping
    ResponseEntity<List<AssessmentResponse>>GetAllAssessment(){
          log.info("Get/Assessment- Fetch all Assessment");
          List<AssessmentResponse>assessmentResponses=assessmentService.getAllList();
          log.info("Get/Assessment - Total number of Assessment: {}",assessmentResponses.size());
          return ResponseEntity.ok(assessmentResponses);

    }
    @GetMapping(ASSESSMENT_ID)
    ResponseEntity<AssessmentResponse>GetByid(@PathVariable Long id){
         log.info("Get/Assessment- Fetch assessment with id: {}",id);
         AssessmentResponse assessmentResponseByid=assessmentService.getById(id,null);
         log.info("Get/Assessment - success assessment with id: {}",id);
         return ResponseEntity.ok(assessmentResponseByid);
    }
}
