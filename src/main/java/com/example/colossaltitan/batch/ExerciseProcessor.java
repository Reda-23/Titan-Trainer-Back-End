package com.example.colossaltitan.batch;

import com.example.colossaltitan.model.Exercise;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ExerciseProcessor implements ItemProcessor<Exercise,Exercise> {
    @Override
    public Exercise process(Exercise item) throws Exception {
        return item;
    }
}
