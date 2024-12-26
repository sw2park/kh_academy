package com.lub2code.aopdemo;

public class Account {
    private String name;
    private String level;

    // 기본생성자
    public Account(){}

    // 필드 채워주는 생성자
    public Account(String name, String level){
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }


    public void setLevel(String level) {
        this.level = level;
    }
    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
