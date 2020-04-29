package com.example.manipalh;

import android.widget.EditText;

public class User2
{
    String link,phno1,phno2,acard;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPhno1() {
        return phno1;
    }

    public void setPhno1(String phno1) {
        this.phno1 = phno1;
    }

    public String getPhno2() {
        return phno2;
    }

    public void setPhno2(String phno2) {
        this.phno2 = phno2;
    }

    public String getAcard() {
        return acard;
    }

    public void setAcard(String acard) {
        this.acard = acard;
    }

    public User2(String link, String phno1, String phno2, String acard) {
        this.link = link;
        this.phno1 = phno1;
        this.phno2 = phno2;
        this.acard = acard;
    }
}
