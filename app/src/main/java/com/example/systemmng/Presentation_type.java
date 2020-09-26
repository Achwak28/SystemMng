package com.example.systemmng;

public class Presentation_type {

    public String fullName;
    public String presentation;

    public Presentation_type(){

    }

    public Presentation_type(String fullName,String presentation){
        this.fullName=fullName;
        this.presentation=presentation;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPresentation() {
        return presentation;
    }
}
