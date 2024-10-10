package com.UST.SpringSecurtiyV2.repository;

import com.UST.SpringSecurtiyV2.entity.JobInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobInfoRepository extends MongoRepository<JobInfo, Integer>{

}
