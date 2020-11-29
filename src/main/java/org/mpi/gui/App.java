package org.mpi.gui;


import org.mpi.gui.controller.MyFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {

    public static void main(String[] args){
        ConfigurableApplicationContext context = new SpringApplicationBuilder(App.class).headless(false).run(args);
        MyFrame appFrame = context.getBean(MyFrame.class);
        appFrame.setVisible(true);
    }


}
