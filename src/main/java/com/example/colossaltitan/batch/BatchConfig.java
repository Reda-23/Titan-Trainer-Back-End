package com.example.colossaltitan.batch;

import com.example.colossaltitan.model.Exercise;
import com.example.colossaltitan.repository.ExerciseRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@AllArgsConstructor
@Configuration
public class BatchConfig {

    private ExerciseRepository exerciseRepository;
    private JobRepository jobRepository;
    private PlatformTransactionManager platformTransactionManager;



    @Bean
    public FlatFileItemReader<Exercise> itemReader(){
        FlatFileItemReader<Exercise> fileItemReader = new FlatFileItemReader<>();
        fileItemReader.setResource(new FileSystemResource("src/main/resources/Gym Exercises Dataset.csv"));
        fileItemReader.setName("exerciseReader");
        fileItemReader.setLinesToSkip(1);
        fileItemReader.setLineMapper(lineMapper());
        return fileItemReader ;
    }

    @Bean
    public Step step(){
        return new StepBuilder("exerciseImport",jobRepository)
                .<Exercise,Exercise>chunk(100,platformTransactionManager)
                .reader(itemReader())
                .writer(itemWriter())
                .processor(processor())
                .build();

    }

    @Bean
    public Job runJob(){
        return new JobBuilder("importExercises",jobRepository)
                .start(step())
                .build();
    }

    @Bean
    public ExerciseProcessor processor(){
        return new ExerciseProcessor();
    }

    @Bean
    public RepositoryItemWriter<Exercise> itemWriter(){
        RepositoryItemWriter<Exercise> writer = new RepositoryItemWriter<>();
        writer.setRepository(exerciseRepository);
        writer.setMethodName("save");
        return writer;
    }
    @Bean
    public LineMapper<Exercise> lineMapper() {
        DefaultLineMapper<Exercise> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("exercise_name"
        , "description_url"
        ,"exercise_image"
        , "muscle_group"
        , "equipment"
        , "rating"
       , "description");

        BeanWrapperFieldSetMapper<Exercise> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Exercise.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }

}
