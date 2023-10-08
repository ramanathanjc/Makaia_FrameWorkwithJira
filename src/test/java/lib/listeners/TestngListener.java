package lib.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class TestngListener implements IAnnotationTransformer,IRetryAnalyzer{

	int maxcount = 2;
	int count = 1;
	public void transform(ITestAnnotation annotation,Class testClass, Constructor testConstructor,Method testMethod) {
		annotation.setRetryAnalyzer(this.getClass());
		if(testClass.getName().contains("incident")) {
			annotation.setThreadPoolSize(2);
		}
	}

	public boolean retry(ITestResult result) {
		if((!result.isSuccess()) && count <= maxcount) {// ! => Not
			count++;
			return true;
		} else {
			return false;
		}		
	}
}
























