package com.goyeneche.models;

import java.util.Date;

public class Student extends Person{

    private long id;
    private Date inscriptionDate;

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Student(long personId, String firstName, String lastName, String phoneNumber, long studentId, Date inscriptionDate) {
        super(personId, firstName, lastName, phoneNumber);
        this.id = studentId;
        this.inscriptionDate = inscriptionDate;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public Date getInscriptionDate() {
        return inscriptionDate;
    }

    public void setInscriptionDate(Date inscriptionDate) {
        this.inscriptionDate = inscriptionDate;
    }
}
