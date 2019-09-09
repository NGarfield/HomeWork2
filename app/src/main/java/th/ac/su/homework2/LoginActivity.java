package th.ac.su.homework2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import th.ac.su.homework2.model.Auth;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        Toast toast = Toast.makeText(LoginActivity.this,"Welcome to My ToDo application!",Toast.LENGTH_SHORT);
        toast.show();


        //ใช้ตัวแปร loginButton อ้างอิงไปยังปุ่มใน layout
        Button loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                CheckBox rememberPasswordCheckBox = findViewById(R.id.remember_password);
                rememberPasswordCheckBox.isChecked();//จะรีเทินค่ามาเป็น true false เมื่อกดเช็ค
                if(rememberPasswordCheckBox.isChecked()){

                    Toast t = Toast.makeText(
                            LoginActivity.this,
                            R.string.remember_password,
                            Toast.LENGTH_SHORT);
                    t.show();
                }

                //เชื่อมไปยังช่องemail
                EditText emailEditText = findViewById(R.id.email_edit_text);

                //เชื่อมไปยังช่องpassword
                EditText passwordEditText = findViewById(R.id.password_edit_text);

                String inputEmail = emailEditText.getText().toString();

                String inputPassword = passwordEditText.getText().toString();

                Auth auth = new Auth(inputEmail,inputPassword);
                /*auth.setEmail(inputEmail);
                auth.setPassword(inputPassword);*/

                if(auth.check()){
                    Toast t = Toast.makeText(
                            LoginActivity.this,
                            getString(R.string.login_success),
                            Toast.LENGTH_SHORT);
                    t.show();
                }
                else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
                    dialog.setTitle("Error");
                    dialog.setMessage(R.string.login_failed);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //โค๊ดที่ให้ทำงานเมื่อuserกดปุ่มok
                            //todo
                        }
                    });
                    dialog.setNegativeButton("CANCLE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //โค๊ดที่ให้ทำงานเมื่อuserกดปุ่มok
                            //todo
                        }
                    });
                    dialog.show();

                }


            }
        });

    }

}
