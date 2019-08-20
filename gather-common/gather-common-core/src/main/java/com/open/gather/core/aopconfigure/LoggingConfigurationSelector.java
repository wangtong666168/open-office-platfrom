package com.open.gather.core.aopconfigure;

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
				"com.open.gather.autoconfigure.datasource.DataSourceAspect",
				"com.open.gather.autoconfigure.log.LogAnnotationAspect"
		};
	}

}
