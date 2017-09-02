package gov.nyc.dohmh.mosquitotrap.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import gov.nyc.dohmh.mosquitotrap.services.IMosquitoTypeService;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;


public class MosquitoTypesImpl implements IMosquitoTypeService {

	public void mosquittoType() {
		
		 //3 apple, 2 banana, others 1
        List<String> items = Arrays.asList("ades", "ades", "anoples","anoples", "mosqA", "ades", "mosqA");
		
        //return items;
 
        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
		  System.out.println(result);

        //System.out.println(result);

		
	}

}
