package com.UST.SpringSecurtiyV2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobInfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobInfo {
    @Id
    public int id;
    public String jobTitle;
    public String jobDescription;
    public String jobLocation;
    public String jobType;
    public String jobPostedDate;
    public String jobSkills;
    public String jobExperience;
    public String jobPackage;
}
