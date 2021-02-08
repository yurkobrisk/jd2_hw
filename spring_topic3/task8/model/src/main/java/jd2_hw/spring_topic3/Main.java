package jd2_hw.spring_topic3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext annotationConfigContext =
                new AnnotationConfigApplicationContext("jd2_hw.spring_topic3.task8");
        for (String definitionName : annotationConfigContext.getBeanDefinitionNames()) {
            System.out.println(definitionName);
        }
    }
}
