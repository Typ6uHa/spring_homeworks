package ru.kpfu.itis.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.model.Operation;


@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionHistory {

    private Operation previousOperation = new Operation();

    public Operation getPreviousOperation() {
        return previousOperation;
    }

    public void setPreviousOperation(Operation previousOperation) {
        this.previousOperation = previousOperation;
    }
}
