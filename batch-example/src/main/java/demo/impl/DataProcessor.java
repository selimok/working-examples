package demo.impl;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import demo.model.SourceData;
import demo.model.TargetData;

@Component
public class DataProcessor implements ItemProcessor<SourceData, TargetData> {

    public DataProcessor() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public TargetData process(SourceData sourceData) throws Exception {
        TargetData targetData = null;
        if (sourceData != null) {
            Long sourceValue = sourceData.getValue();
            System.out.println("Processing source data " + sourceValue);
            Long targetValue = 0 - sourceValue;
            targetData = new TargetData(targetValue);
        }
        return targetData;
    }

}
