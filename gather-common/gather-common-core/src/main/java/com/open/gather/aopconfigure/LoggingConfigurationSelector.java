package com.open.gather.aopconfigure;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 装配bean
 */
public class LoggingConfigurationSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
//		importingClassMetadata.getAllAnnotationAttributes(EnableEcho.class.getName());
		return new String[] { 
				"com.open.capacity.autoconfigure.datasource.DataSourceAspect",
				"com.open.capacity.autoconfigure.log.LogAnnotationAspect"
		};
	}

}
