package demo.impl;

import org.springframework.batch.item.ItemProcessor;

import demo.model.SourceData;
import demo.model.TargetData;

public class DataProcessor implements ItemProcessor<SourceData, TargetData> {

    // Actually result not belongs here!!! It should be created each time if
    // process() called.
    private TargetData targetData = new TargetData();


    @Override
    public TargetData process(SourceData sourceData) throws Exception {
        // TargetData targetData = null;
        if (sourceData != null) {
            Long sourceValue = sourceData.getValue();
            System.out.println("Processing source data " + sourceValue);
            Thread.sleep(1000);
            Long targetValue = 0 - sourceValue;
            targetData.setValue(targetValue);
        }
        return targetData;
    }

}
