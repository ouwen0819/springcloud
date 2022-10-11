package pers.jmu.springcloud.entities;

public class Person {
    private String ClassCn;
    private String ClassName;
    private String ClassAc;
    private String ClassPe;

    public Person() {
    }

    public Person(String classCn, String className, String classAc, String classPe) {
        ClassCn = classCn;
        ClassName = className;
        ClassAc = classAc;
        ClassPe = classPe;
    }

    public String getClassCn() {
        return ClassCn;
    }

    public void setClassCn(String classCn) {
        ClassCn = classCn;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getClassAc() {
        return ClassAc;
    }

    public void setClassAc(String classAc) {
        ClassAc = classAc;
    }

    public String getClassPe() {
        return ClassPe;
    }

    public void setClassPe(String classPe) {
        ClassPe = classPe;
    }
}
