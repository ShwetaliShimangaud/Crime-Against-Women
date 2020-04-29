package com.example.manipalh;

import android.content.Intent;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class Introduction extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.newInstance("Sign Up","Fill the required details and you are ready to use the app!!!",
                R.drawable.signup, ContextCompat.getColor(getApplicationContext(),R.color.gradientColor)));

        addSlide(AppIntroFragment.newInstance("Just Shake!","When you are in a danger situation,just shake the phone!The app is there to take care of the rest",
                R.drawable.shake, ContextCompat.getColor(getApplicationContext(),R.color.gradientColor)));

        addSlide(AppIntroFragment.newInstance("Don't worry,we are coming!","Your location will be notified to police station,emergency contacts and other women users",
                R.drawable.coming, ContextCompat.getColor(getApplicationContext(),R.color.gradientColor)));

        addSlide(AppIntroFragment.newInstance("Communication had never been so easy!","In-App group of all nearby users will be formed at that instant for better co-ordination",
                R.drawable.chatgroup, ContextCompat.getColor(getApplicationContext(),R.color.gradientColor)));

        addSlide(AppIntroFragment.newInstance("Hello!Yes ,You!","You can see your profile and other details too in the navbar",
                R.drawable.profile, ContextCompat.getColor(getApplicationContext(),R.color.gradientColor)));

        addSlide(AppIntroFragment.newInstance("Ready Steady Go....!","Dear User,You are now ready to use the app.",
                R.drawable.ready, ContextCompat.getColor(getApplicationContext(),R.color.gradientColor)));

    }

    @Override
    public void onDonePressed(Fragment currentFragment)
    {
        super.onDonePressed(currentFragment);
        Intent intent= new Intent(getApplicationContext(),NewUser.class);
        startActivity(intent);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment)
    {
        super.onSkipPressed(currentFragment);
        Intent intent= new Intent(getApplicationContext(),NewUser.class);
        startActivity(intent);

    }

}
