package com.ranstats.ui;

import org.apache.commons.jcs.engine.control.CompositeCacheManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.util.Properties;

@SpringBootApplication
public class UiApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(UiApplication.class);
	}

	public static void main(String[] args) throws Exception {
        configureCache();
		SpringApplication.run(UiApplication.class, args);
		
	}

	public static void configureCache(){
        CompositeCacheManager ccm = CompositeCacheManager.getUnconfiguredInstance();
        Properties props = new Properties();

        props.put("jcs.default","");
        props.put("jcs.default.cacheattributes",
                "org.apache.jcs.engine.CompositeCacheAttributes");

        props.put("jcs.default.cacheattributes.MaxObjects",10000);

        props.put("jcs.default.cacheattributes.MemoryCacheName",
                "org.apache.commons.jcs.engine.memory.lru.LRUMemoryCache");

        props.put("jcs.default.cacheattributes.UseMemoryShrinker","true");
        props.put("jcs.default.cacheattributes.MaxMemoryIdleTime","3600");
        props.put("jcs.default.cacheattributes.ShrinkerInterval","60");
        props.put("jcs.default.elementattributes","org.apache.commons.jcs.engine.ElementAttributes");
        props.put("jcs.default.elementattributes.IsEternal","false");
        props.put("jcs.default.elementattributes.MaxLife","3600");
        props.put("jcs.default.elementattributes.IsSpool","false");
        props.put("jcs.default.elementattributes.IsRemote","false");
        props.put("jcs.default.elementattributes.IsLateral","false");

        ccm.configure(props);
        
	}
}
