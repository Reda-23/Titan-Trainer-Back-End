package com.example.colossaltitan.batch;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BatchJobRunner implements CommandLineRunner {


    private JobLauncher jobLauncher;
    private Job job;
    @Override
    public void run(String... args) throws Exception {

        jobLauncher.run(job,new JobParameters());

    }
}
