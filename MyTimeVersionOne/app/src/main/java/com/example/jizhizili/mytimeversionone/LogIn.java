package com.example.jizhizili.mytimeversionone;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class LogIn extends ActionBarActivity {


    EditText logname;
    EditText logpw;
    TextView logInResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);



        logname = (EditText)findViewById(R.id.logName);
        logpw = (EditText)findViewById(R.id.logPw);











//when pressing the button of signin
        Button logSignIn = (Button)findViewById(R.id.LogSignIn);


        logSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("press me!");

                logInResult = (TextView)findViewById(R.id.logInResult);
                logInResult.setText("Try to log in ......");

                System.out.println(getFilesDir().getAbsolutePath());
                System.out.println(getFilesDir().getPath());
                System.out.println(getFilesDir().getTotalSpace());



                String name = logname.getText().toString();

                String pass = logpw.getText().toString();


                ParseUser.logInInBackground(name, pass,
                        new LogInCallback() {
                            public void done(ParseUser user, ParseException e) {
                                if (user != null) {

                                    //if user exist and authenticated, jump to homepage
                                 System.out.println("login successfully!");

                                    logInResult.setText("LogIn Successfully!");



                                    Intent intent = new Intent(LogIn.this,Homepage.class);
                                    startActivity(intent);


                                } else {

                                    //when logIn failed, set the text to blank for user to enter again.

                                    logInResult.setText("Login Failed! Please try again!");
                                    System.out.println("LogIn failed!");

                                  logname.setText("");
                                    logpw.setText("");




                                }
                            }
                        });
            }
        });







//                ParseQuery<ParseObject> query = ParseQuery.getQuery("LogIn");
//
//
//                query.getInBackground("ENok67W5UU", new GetCallback<ParseObject>() {
//                    public void done(ParseObject object, ParseException e) {
//                        if (e == null) {
//                            System.out.println(object.getString("username"));
//                            // object will be your game score
//                        } else {
//                            System.out.println("wrong");
//                            // something went wrong
//                        }
//                    }
//                });





//when pressing the button Signup




        Button signUp = (Button)findViewById(R.id.LogSignUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(LogIn.this,SignUp.class);
                startActivity(intent);





            }
        });








    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
