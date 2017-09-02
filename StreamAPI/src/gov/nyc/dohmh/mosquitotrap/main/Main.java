package gov.nyc.dohmh.mosquitotrap.main;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import gov.nyc.dohmh.mosquitotrap.dto.MosquitoTypeDTO;
import gov.nyc.dohmh.mosquitotrap.restapi.RestCallData;
import gov.nyc.dohmh.mosquitotrap.services.IMosquitoTypeService;
import gov.nyc.dohmh.mosquitotrap.services.impl.MosquitoTypesImpl;

import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		
		JSONObject obj=new JSONObject();
		obj.put("detectionTime",1497267485);
		obj.put("deviceId",1);
		obj.put("humidity",60);
		obj.put("light",5);
		obj.put("sequenceNum",1);
		obj.put("temp",98);
		obj.put("type","A");
		JSONObject obj1=new JSONObject();
		obj1.put("detectionTime",1497267485);
		obj1.put("deviceId",2);
		obj1.put("humidity",60);
		obj1.put("light",5);
		obj1.put("sequenceNum",1);
		obj1.put("temp",98);
		obj1.put("type","B");
		JSONObject obj2=new JSONObject();
		obj2.put("detectionTime",1297267485);
		obj2.put("deviceId",3);
		obj2.put("humidity",60);
		obj2.put("light",5);
		obj2.put("sequenceNum",1);
		obj2.put("temp",98);
		obj2.put("type","C");
		JSONObject obj3=new JSONObject();
		obj3.put("detectionTime",1397267485);
		obj3.put("deviceId",4);
		obj3.put("humidity",60);
		obj3.put("light",5);
		obj3.put("sequenceNum",1);
		obj3.put("temp",98);
		obj3.put("type","D");
		JSONObject obj4=new JSONObject();
		obj4.put("detectionTime",1497267485);
		obj4.put("deviceId",5);
		obj4.put("humidity",60);
		obj4.put("light",5);
		obj4.put("sequenceNum",1);
		obj4.put("temp",98);
		obj4.put("type","B");
		
		Gson gson = new Gson();
  
		JSONArray ar1=new JSONArray();
		ar1.add(obj);
		
		JSONArray ar2=new JSONArray();
		ar2.add(obj1);
		JSONArray ar3=new JSONArray();
		ar3.add(obj2);
		JSONArray ar4=new JSONArray();
		ar4.add(obj3);
		JSONArray ar5=new JSONArray();
		ar5.add(obj4);
		
		
		List<MosquitoTypeDTO> mqtType=new ArrayList<MosquitoTypeDTO>();
		
		//MosquitoTypeDTO[] m1=new MosquitoTypeDTO();
		
		List<String> typeFilter=new ArrayList<>();
		typeFilter.add("A");
		typeFilter.add("B");
		typeFilter.add("C");
		
		//List<String> typesFilter={"a","b","c"};
		
		//MosquitoTypeDTO[] m1=new MosquitoTypeDTO();
		MosquitoTypeDTO[] m1=gson.fromJson(ar1.toJSONString(),MosquitoTypeDTO[].class);
		MosquitoTypeDTO[] m2=gson.fromJson(ar2.toJSONString(),MosquitoTypeDTO[].class);
		MosquitoTypeDTO[] m3=gson.fromJson(ar3.toJSONString(),MosquitoTypeDTO[].class);
		MosquitoTypeDTO[] m4=gson.fromJson(ar4.toJSONString(),MosquitoTypeDTO[].class);
		MosquitoTypeDTO[] m5=gson.fromJson(ar5.toJSONString(),MosquitoTypeDTO[].class);
		
		mqtType.add(m1[0]);
		mqtType.add(m2[0]);
		mqtType.add(m3[0]);
		mqtType.add(m4[0]);
		mqtType.add(m5[0]);
        //System.out.println(mqtType.get(2).getType());
		
      ///////////////////////////////////////////////////////////////  
       /* List<MosquitoTypeDTO> listOutput =
        		mqtType.stream()
        	           .filter(e -> typeFilter.stream().map(String::valueOf).anyMatch(name -> name.equals(e.getType())))
        	           .collect(Collectors.toList());*/
        
        Set<String> typeFileterNames = 
        	    typeFilter.stream()
        	               .map(String::valueOf)
        	               .collect(Collectors.toSet());

        	List<MosquitoTypeDTO> listOutput =
        			mqtType.stream()
        	            .filter(e -> typeFileterNames.contains(e.getType()))
        	            .collect(Collectors.toList());  
        	
        	 Map<String, Long> result =
        			 listOutput.stream().map(x->x.getType()).collect(
                             Collectors.groupingBy(
                                     Function.identity(), Collectors.counting()
                             )
                     );
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        	
        	
        //MosquitoTypeDTO m=mqtType.stream().filter(x->"B".equals(x.getType())).findAny().orElse(null);
        System.out.println(result);
		//MosquitoTypesImpl m=new MosquitoTypesImpl();
		//m.mosquittoType();
		
		//RestCallData rdata=new RestCallData();
		//rdata.getRestData();
        /////////////////////////////////////////////////////////////////////////
       /* List<Month> result =
              mqtType.stream().map(x->monthFinder(x.getDetectionTime()));*/
                
        
        Map<Month, Long> result1 =
   			 mqtType.stream().map(x->monthFinder(x.getDetectionTime())).collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
        
        Map<Month, Long> result2 =
      			 listOutput.stream().map(x->monthFinder(x.getDetectionTime())).collect(
                           Collectors.groupingBy(
                                  Function.identity(), Collectors.counting()
                           )
                   );
        
        Set<Month> monthNames = 
        		mqtType.stream()
        	               .map(x->monthFinder(x.getDetectionTime()))
        	               .collect(Collectors.toSet());

        	List<MosquitoTypeDTO> monthwiseList =
        			mqtType.stream()
        	            .filter(e -> monthNames.contains(monthFinder(e.getDetectionTime())))
        	            .collect(Collectors.toList());  
        	
        
        ////////////////////////////////////////////////////////////////////////
        
       System.out.println(result2);
	
		/*String epochString = "1497604760";
		long epoch = Long.parseLong( epochString );
		Date expiry = new Date( epoch * 1000 );
		System.out.println(expiry);*/
		monthFinder(1497604760);
	}
	
	static Month monthFinder(long epoch)
	{
		LocalDateTime date =
			    LocalDateTime.ofInstant(Instant.ofEpochSecond(epoch), ZoneId.systemDefault());
		//System.out.println(date.getMonth());
		return date.getMonth();
	}

}
