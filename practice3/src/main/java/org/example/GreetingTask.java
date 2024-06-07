package org.example;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

public class GreetingTask extends DefaultTask {
    private String greeting;

    @Input
    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @TaskAction
    public void toGreet() {
        getLogger().quiet("Grettings "+greeting);
    }
}
