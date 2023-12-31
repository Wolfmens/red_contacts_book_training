package org.application;

import org.application.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        WorkerWithBook workerWithBook = context.getBean(WorkerWithBook.class);
        workerWithBook.startWork();

        ((AbstractApplicationContext) context).close();
    }
}