package utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class IAnnotationTrans implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation,Class testclass, Constructor testConstructor, Method testMethod)
	{
		annotation.setRetryAnalyzer(utilities.RetryImplClass.class);	
	}
}
