package com.demo.ownspringannotation.aop;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.demo.ownspringannotation.util.FileUtil;

@Component
@Aspect
public class SaveInFileAspect {

	// We tell to spring that he should intercept the annotation
	@After("@annotation(com.demo.ownspringannotation.aop.SaveInFile)")
	public void saveInFile(JoinPoint joinPoint) {
		StringBuilder sb = new StringBuilder();
		String methodName = joinPoint.getSignature().getName();
		List<Object> params = List.of(joinPoint.getArgs());
		LocalDateTime now = LocalDateTime.now();

		String toWrite = sb.append(methodName).append(", ").append(params.toString()).append(" at: ")
				.append(now.toString()).toString();
		try {
			FileUtil.write(toWrite, getAnnotationParams(joinPoint));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getAnnotationParams(JoinPoint joinPoint) {
		// Method name is gotten
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();

		// Method is gotten
		Method method = signature.getMethod();
		SaveInFile annotation = method.getAnnotation(SaveInFile.class);
		return annotation.value();
	}
}
