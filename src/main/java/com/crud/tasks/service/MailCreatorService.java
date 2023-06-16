package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailCreatorService {

    private final AdminConfig adminConfig;

    private final TemplateEngine templateEngine;

    public MailCreatorService(@Qualifier("templateEngine") TemplateEngine templateEngine, AdminConfig adminConfig) {
        this.templateEngine = templateEngine;
        this.adminConfig = adminConfig;
    }

    public String buildTrelloCardEmail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend/");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbye_message", "Good Luck !!");
        context.setVariable("company_name", adminConfig.getCompanyName());
        context.setVariable("company_Goal", adminConfig.getCompanyGoal());
        context.setVariable("company_email", adminConfig.getCompanyEmail());
        context.setVariable("company_phone",adminConfig.getCompanyPhone());
        return templateEngine.process("mail/created-trello-card-mail.html", context);
    }
}