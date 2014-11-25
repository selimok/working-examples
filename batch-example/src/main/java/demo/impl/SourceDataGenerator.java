package demo.impl;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import demo.model.SourceData;

public class SourceDataGenerator implements ItemReader<SourceData> {

    private Integer readerPosition = 0;

    private List<SourceData> sourceDataList = new ArrayList<SourceData>();

    public SourceDataGenerator(Long startValue, Long endValue) {

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
