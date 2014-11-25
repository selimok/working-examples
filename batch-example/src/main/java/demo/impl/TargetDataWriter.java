package demo.impl;

import java.util.List;

import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import demo.model.TargetData;

@JobScope
@Component
public class TargetDataWriter implements ItemWriter<TargetData> {

    @Override
    public void write(List<? extends TargetData> targetDataList) throws Exception {
        for (TargetData targetData : targetDataList) {
            System.out.println("Writing target data " + targetData.getValue());
        }
    }

}
