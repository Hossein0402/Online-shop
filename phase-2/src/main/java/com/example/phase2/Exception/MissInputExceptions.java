package com.example.phase2.Exception;

public class MissInputExceptions extends Exception{
    public MissInputExceptions(){
        super("Miss Input Exception");
    }
    public MissInputExceptions(String massage){
        super("Miss Input Exception "+massage);
    }
}