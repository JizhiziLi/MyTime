package com.example.jizhizili.mytimeversionone;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class SignUp extends ActionBarActivity {

    EditText username;
    EditText password;
    EditText email;
    EditText phone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);






        username = (EditText)findViewById(R.id.name);
        password = (EditText)findViewById(R.id.password);
        email = (EditText)findViewById(R.id.email);
        phone = (EditText)findViewById(R.id.phone);

        Button signUp = (Button)findViewById(R.id.signUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString();

                String pass = password.getText().toString();

                String ema = email.getText().toString();

                String pho = phone.getText().toString();


                ParseUser user = new ParseUser();
                user.setUsername(name);
                user.setPassword(pass);

                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            // Show a simple Toast message upon successful registration
                            System.out.println("sign up successfully!");

                            Intent intent = new Intent(SignUp.this,Homepage.class);
                            startActivity(intent);





                        } else {
                            //If signed up failed, user need to sign up again.
                            System.out.println("Sign up failed, please sign up again!");

                            username.setText("");
                            password.setText("");
                            email.setText("");
                            phone.setText("");


                        }
                    }
                });


                ParseObject logIn = new ParseObject("LogIn");
                logIn.put("username", name);
                logIn.put("password", pass);
                logIn.put("email", ema);
                logIn.put("phone", pho);

                logIn.saveInBackground();


            }
        });









    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
