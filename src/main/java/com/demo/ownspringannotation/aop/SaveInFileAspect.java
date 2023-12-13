package com.demo.ownspringannotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SaveInFileAspect {

	// We tell to spring that he should intercept the annotation
	@After("@annotation(com.demo.ownspringannotation.aop.SaveInFile)")
	public void saveInFile(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName());
	}
}
