package com.rest.apm;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import co.elastic.apm.attach.ElasticApmAttacher;

@ApplicationPath("/")
public class APMDemoApplication extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		
		
		System.out.println("---> attaching apm");
		ElasticApmAttacher.attach();
		System.out.println("---> attached apm");
		
		Set<Class<?>> resources = new HashSet<Class<?>>();
		resources.add(APMDemoRS.class);
		
		return resources;
	}
}