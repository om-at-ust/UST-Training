package com.UST.SpringSecurtiyV2.services;


import com.UST.SpringSecurtiyV2.entity.JobInfo;
import com.UST.SpringSecurtiyV2.repository.JobInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobInfoService {

    @Autowired

    private JobInfoRepository projectInfoRepository;

    public JobInfo addJobInfo(JobInfo jobInfo) {
        projectInfoRepository.insert(jobInfo);
        return jobInfo ;
    }
    public JobInfo getJobInfo(int id) {
        return projectInfoRepository.findById(id).orElse(null);
    }
    public List<JobInfo> getAllJobInfo() {
        return projectInfoRepository.findAll();
    }
}
