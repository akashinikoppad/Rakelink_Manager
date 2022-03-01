package com.example.rakelinkmanager;

public class Contacts2 {
    private String lieoverduration,rakeno,trainname,trainno;

    public Contacts2(String lieoverduration, String rakeno,String trainname, String trainno)
    {
        this.setRakeno(rakeno);
        this.setTrainname(trainname);
        this.setLieoverduration(lieoverduration);
        this.setTrainno(trainno);
    }
    public String getRakeno()
    {
        return rakeno;
    }
    public String getTrainname()
    {
        return trainname;
    }
    public String getLieoverduration()
    {
        return lieoverduration;
    }
    public String getTrainno() { return trainno; }

    public void setRakeno(String rakeno) { this.rakeno = rakeno; }

    public void setTrainname(String trainname) { this.trainname= trainname; }

    public void setLieoverduration(String lieoverduration) { this.lieoverduration=lieoverduration; }

    public void setTrainno(String trainno) { this.trainno=trainno; }
}
