package com.simpoint_enterprice.simpoint.Controller;

import com.simpoint_enterprice.simpoint.Dto.ModuleResponse;
import com.simpoint_enterprice.simpoint.ServiceInterface.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.simpoint_enterprice.simpoint.EndPoint.ApiEndpoints.MODULE;
import static com.simpoint_enterprice.simpoint.EndPoint.ApiEndpoints.MODULE_ID;

@RestController
@RequestMapping(MODULE)
@Slf4j
public class ModuleController {

    @Autowired
     private ModuleService moduleService;

    @GetMapping
    ResponseEntity<List<ModuleResponse>>GetAllModule(){
        log.info("Get/Module- Fetch All Module");
        List<ModuleResponse>moduleList=moduleService.GetAllList();
        log.info("Get/Module- All Module size:{}",moduleList.size());
        return ResponseEntity.ok(moduleList);
    }
    @GetMapping(MODULE_ID)
    ResponseEntity<ModuleResponse>GetModuleById(@PathVariable Long id){
        log.info("Get/Module- Fetch module with id");
        ModuleResponse moduleById=moduleService.GetById(id);
        log.info("Get/Module -Find module with id:{}",id);
        return ResponseEntity.ok(moduleById);
    }
}
