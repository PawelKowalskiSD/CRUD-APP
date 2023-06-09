package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    private final AdminConfig adminConfig;

    private final TemplateEngine templateEngine;

    public MailCreatorService(@Qualifier("templateEngine") TemplateEngine templateEngine, AdminConfig adminConfig) {
        this.templateEngine = templateEngine;
        this.adminConfig = adminConfig;
    }

    public String buildTrelloCardEmail(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend/");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_config", adminConfig);
        context.setVariable("goodbye_message", "Good Luck !!");
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail.html", context);
    }

    public String buildingAnEmailTaskCounter(String message) {
        Context context = new Context();

        context.setVariable("message", message);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("goodbye_message", "Have a nice day:)");
        context.setVariable("is_friend", true);
        return templateEngine.process("mail/database-task-counter-mail.html", context);
    }
}
