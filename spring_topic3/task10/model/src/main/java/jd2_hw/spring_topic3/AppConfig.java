package jd2_hw.spring_topic3;

import jd2_hw.spring_topic3.task10.PersonAnnotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// исключение классов помеченных аннотацией Component и включение классов помеченных аннотацией PersonAnnotation
// формирование контекста Spring-ом
@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Component.class),
                includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = PersonAnnotation.class),
                basePackages = "jd2_hw.spring_topic3")
public class AppConfig {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        //Список всех создаваемых бинов в контексте
//        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
//            System.out.println(beanDefinitionName);
//        }

        List<String> list = Arrays.stream(context.getBeanDefinitionNames())
                .filter(s -> !s.contains("org.springframework.context."))
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
