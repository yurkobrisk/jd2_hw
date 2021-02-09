package jd2_hw.spring_topic3;

import jd2_hw.spring_topic3.task9.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("jd2_hw.spring_topic3.")
public class AppConfig {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        Person person = context.getBean(Person.class);
        System.out.println(person);

    }
}
