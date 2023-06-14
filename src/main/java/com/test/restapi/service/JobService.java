package com.test.restapi.service;

import com.test.restapi.dto.JobResponse;
import com.test.restapi.exception.BadRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
public class JobService {

    private final String JOB_LIST_URL="http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
    private final String JOB_DETAIL_URL="http://dev3.dansmultipro.co.id/api/recruitment/positions/";

    public List<JobResponse> findListJobData(){
        RestTemplate rest = new RestTemplate();
        ResponseEntity<List> response;
        List<JobResponse> jobResponseList = new ArrayList<>();
        try {
            response = rest.getForEntity(JOB_LIST_URL, List.class);
            if (response.getStatusCodeValue() == 200) {
                jobResponseList = response.getBody();
            }
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BadRequest(e.getMessage());
        }
        return jobResponseList;
    }

    public JobResponse findJobDetail(String jobId){
        RestTemplate rest = new RestTemplate();
        ResponseEntity<JobResponse> response;
        JobResponse jobResponse = new JobResponse();
        try {
            response = rest.getForEntity(JOB_DETAIL_URL+jobId, JobResponse.class);
            if (response.getStatusCodeValue() == 200) {
                jobResponse = response.getBody();
            }
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BadRequest(e.getMessage());
        }
        return jobResponse;
    }
}
