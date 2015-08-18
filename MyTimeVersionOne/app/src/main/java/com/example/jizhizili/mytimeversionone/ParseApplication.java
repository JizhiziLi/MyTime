package com.example.jizhizili.mytimeversionone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseUser;

/**
 * Created by jizhizili on 16/08/15.
 */
public class ParseApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        //initialization code here
        Parse.initialize(this, "e8LD20ie6JRVwQvMQT4ANcG7Qh7RJK1Nv3DyOMGS", "a5PKxdtNDQgdQLmRk2u5ox7lUzuBgkR07Ggi62LT");

        ParseUser.enableAutomaticUser();








    }
}
