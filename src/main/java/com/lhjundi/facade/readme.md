## Facade com um exemplo prático de um sistema de envio de emails.

O padrão Facade é útil quando:
1. Você tem um subsistema complexo com várias classes e dependências
2. Deseja simplificar o uso deste subsistema fornecendo uma interface única e mais simples
3. Quer reduzir o acoplamento entre o código cliente e o subsistema


## Os passos principais para implementar um Facade são:

### Identificar o Subsistema

- Identifique as classes complexas que formam o subsistema
- Entenda como essas classes se relacionam
- Determine quais operações são comumente usadas juntas


### Criar a Classe Facade

- Declare os objetos do subsistema como atributos privados
- Crie um construtor que inicialize esses objetos
- Implemente métodos públicos que combinem as operações do subsistema
- Forneça uma interface simples e unificada


### Boas Práticas na Implementação

- Mantenha a Facade simples - ela deve apenas coordenar o subsistema
- Não adicione regras de negócio na Facade
- Considere usar injeção de dependência para os componentes do subsistema
- Mantenha os métodos da Facade focados em casos de uso comuns


## Exemplo:



```java
// Classes do subsistema complexo
class EmailValidator {
    public boolean validateEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}

class TemplateEngine {
    public String generateEmailContent(String template, Map<String, String> params) {
        // Simula um motor de template complexo
        String content = template;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            content = content.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }
        return content;
    }
}

class EmailSender {
    public void send(String to, String subject, String content) {
        // Simula envio de email usando protocolo SMTP
        System.out.println("Sending email to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Content: " + content);
    }
}

// A Facade que simplifica o uso do subsistema
public class EmailFacade {
    private final EmailValidator validator;
    private final TemplateEngine templateEngine;
    private final EmailSender sender;

    public EmailFacade() {
        this.validator = new EmailValidator();
        this.templateEngine = new TemplateEngine();
        this.sender = new EmailSender();
    }

    public void sendWelcomeEmail(String to, String name) {
        if (!validator.validateEmail(to)) {
            throw new IllegalArgumentException("Invalid email address");
        }

        String template = "Welcome {{name}}! Thank you for joining us.";
        Map<String, String> params = new HashMap<>();
        params.put("name", name);

        String content = templateEngine.generateEmailContent(template, params);
        sender.send(to, "Welcome!", content);
    }
}

// Exemplo de uso
public class Main {
    public static void main(String[] args) {
        EmailFacade emailFacade = new EmailFacade();
        
        // Cliente usa uma interface simples, sem conhecer a complexidade por trás
        try {
            emailFacade.sendWelcomeEmail("john@example.com", "John");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

```

Neste exemplo:

1. Temos um subsistema complexo de envio de emails com várias classes:
    - EmailValidator: valida endereços de email
    - TemplateEngine: processa templates de email
    - EmailSender: envia os emails

2. A classe EmailFacade fornece uma interface simplificada para usar todo esse subsistema:
    - Esconde a complexidade interna
    - Gerencia as dependências
    - Fornece métodos de alto nível como sendWelcomeEmail()

3. O código cliente:
    - Não precisa conhecer as classes internas do subsistema
    - Usa apenas a fachada com uma interface simples
    - Está protegido de mudanças no subsistema

Principais benefícios obtidos:
- Simplificação do uso do subsistema
- Desacoplamento entre cliente e subsistema
- Centralização da lógica de coordenação
- Facilidade de manutenção

Use o padrão Facade quando:
- Precisar simplificar o uso de um sistema complexo
- Quiser reduzir dependências e acoplamento
- Tiver um subsistema que precise de uma interface unificada
- Desejar encapsular um conjunto de operações relacionadas

O padrão é especialmente útil quando se trabalha com bibliotecas de terceiros ou sistemas legados complexos.

Padrões Complementares

Considere usar Singleton para a Facade se ela não precisar manter estado
Use Factory Method para criar os componentes do subsistema se necessário
Combine com Builder se precisar construir objetos complexos
