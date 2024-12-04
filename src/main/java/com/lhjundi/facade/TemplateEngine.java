package com.lhjundi.facade;

import java.util.Map;

public class TemplateEngine {
    public String generateEmailContent(String template, Map<String, String> params){
        // Simula um motor de template complexo
        String content = template;
        for (Map.Entry<String, String> entry : params.entrySet()){
            content = content.replace(STR."{{\{entry.getKey()}}}", entry.getValue());
        }
        return content;
    }
}
