package gov.nyc.dohmh.mosquitotrap.main;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import gov.nyc.dohmh.mosquitotrap.services.IMosquitoTypeService;
import gov.nyc.dohmh.mosquitotrap.services.impl.MosquitoTypesImpl;

import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		
		MosquitoTypesImpl m=new MosquitoTypesImpl();
		m.mosquittoType();
		
		
	}

}
