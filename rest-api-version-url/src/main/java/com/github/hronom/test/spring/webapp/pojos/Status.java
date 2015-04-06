package com.github.hronom.test.spring.webapp.pojos;

public class Status {
    private String text;
    private boolean status = false;

    public void setText(String textArg) {
        text = textArg;
    }

    public String getText() {
        return text;
    }

    public void setStatus(boolean statusArg) {
        status = statusArg;
    }

    public boolean getStatus() {
        return status;
    }
}
