package demo.impl;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import demo.model.SourceData;

@Component
//@Scope("step")
public class SourceDataGenerator implements ItemReader<SourceData> {

	private Integer readerPosition = 0;
	
	//@Value("#{jobParameters['startValue']}")
	private Integer startValue = 5;

	//@Value("#{jobParameters['endValue']}")
	private Integer endValue = 25; 
	
	private List<SourceData> sourceDataList = new ArrayList<SourceData>();
	
	public SourceDataGenerator(){
		
		if(startValue > endValue) {
			throw new InvalidParameterException("Start value cannot be greater than end value.");
		}
		
		for(int i = startValue; i <= endValue; i++){
			sourceDataList.add(new SourceData(i));
		}
	}
	
	@Override
	public SourceData read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		if(sourceDataList.size() > readerPosition){
			return sourceDataList.get(readerPosition++);
		} else {
			return null;
		}
		
	}

}
