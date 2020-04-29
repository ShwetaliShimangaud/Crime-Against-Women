package com.example.manipalh;

public class User1
{
    String fname,emailid,phno,address;

    public User1(String fname, String emailid, String phno, String address) {
        this.fname = fname;
        this.emailid = emailid;
        this.phno = phno;
        this.address = address;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
