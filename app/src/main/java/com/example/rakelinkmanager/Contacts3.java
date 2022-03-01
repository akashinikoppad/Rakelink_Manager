package com.example.rakelinkmanager;

public class Contacts3 {
    private String arrtime,deptime,rakeno,trainname,trainno;

    public Contacts3(String arrtime, String deptime, String rakeno,String trainname, String trainno)
    {
        this.setArrtime(arrtime);
        this.setDeptime(deptime);
        this.setRakeno(rakeno);
        this.setTrainname(trainname);
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
    public String getTrainno() { return trainno; }
    public String getArrtime() { return arrtime; }
    public String getDeptime() { return deptime; }

    public void setRakeno(String rakeno) { this.rakeno = rakeno; }

    public void setTrainname(String trainname) { this.trainname= trainname; }

    public void setTrainno(String trainno) { this.trainno=trainno; }

    public void setArrtime(String arrtime) { this.arrtime=arrtime; }

    public void setDeptime(String deptime) { this.deptime=deptime; }
}
