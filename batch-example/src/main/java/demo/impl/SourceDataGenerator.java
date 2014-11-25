package demo.impl;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Position;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import demo.model.SourceData;

@Component
@StepScope
public class SourceDataGenerator implements ItemReader<SourceData> {

    private Integer readerPosition = 0;

    @Value("#{jobParameters['startValue']}")
    private Long startValue = 1L;

    @Value("#{jobParameters[endValue]}")
    private Long endValue = 23L;

    private List<SourceData> sourceDataList = new ArrayList<SourceData>();

    public SourceDataGenerator() {

        if (startValue > endValue) {
            throw new InvalidParameterException("Start value cannot be greater than end value.");
        }

        for (long i = startValue; i <= endValue; i++) {
            sourceDataList.add(new SourceData(i));
        }
    }

    @Override
    public SourceData read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        if (sourceDataList.size() > readerPosition) {
            System.out.println("Reading data position " + readerPosition);
            return sourceDataList.get(readerPosition++);
        } else {
            return null;
        }

    }

}
