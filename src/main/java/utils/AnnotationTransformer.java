package utils;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Optional;

public class AnnotationTransformer implements IAnnotationTransformer
{
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
    {
        Integer x = 1;
        x = System.getProperty("iterations") == null ? x : Integer.valueOf(System.getProperty("iterations"));
        annotation.setInvocationCount(x);
    }
}
