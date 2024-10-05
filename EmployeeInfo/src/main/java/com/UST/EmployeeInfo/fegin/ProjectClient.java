package com.UST.EmployeeInfo.fegin;


import com.UST.EmployeeInfo.client.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ProjectClient {
    @FeignClient(name = "ProjectInfo", url = "http://localhost:2238/project")
    public interface AddressClient {

        @GetMapping("/project/{ccode}")
        List<Project> getProjectByCode(@PathVariable Long ccode);

    }
}
