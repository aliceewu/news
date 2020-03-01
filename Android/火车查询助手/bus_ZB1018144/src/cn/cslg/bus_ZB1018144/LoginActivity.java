package cn.cslg.bus_ZB1018144;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.litepal.LitePal;

import java.util.List;

/**
 * Created by Alice on 2019/12/3.
 */
public class LoginActivity extends Activity {

    EditText account,pwd;
    Button register,login;
    private List<User> lists;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        init();
        setListener();
        getActionBar().setDisplayHomeAsUpEnabled(true);//启用向上返回按钮

        SharedPreferences sp=getSharedPreferences("userinfo",MODE_PRIVATE);
        String user=sp.getString("username",null);
        String password=sp.getString("password",null);
        account.setText(user);
        pwd.setText(password);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setListener() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=account.getText().toString();
                String password=pwd.getText().toString();
                User user=new User();
                user.setUsername(username);
                user.setPassword(password);
                user.save();//保存数据到数据库中
                Toast.makeText(LoginActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=account.getText().toString();
                String password=pwd.getText().toString();
                lists= LitePal.select("username","password").find(User.class);
                if (username.equals("")||password.equals("")){
                    Toast.makeText(LoginActivity.this,"登录失败，输入框内容为空",Toast.LENGTH_LONG).show();
                }
                else {
                    for(int i=0;i<lists.size();i++){
                        if(lists.get(i).getUsername().equals(username)&&lists.get(i).getPassword().equals(password)){
                            Intent intent = new Intent(LoginActivity.this,MyActivity.class);//登录成功跳转到首页
                            startActivity(intent);
                            SharedPreferences sp = getSharedPreferences("userinfo", MODE_APPEND);
                            SharedPreferences.Editor edit = sp.edit();
                            edit.putString("username",username);//保存用户名
                            edit.putString("password",password);//保存密码
                            edit.commit();//提交数据，将数据保存到文本中
                            Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });


    }


    private void init() {
        account= (EditText) findViewById(R.id.et_account);
        pwd= (EditText) findViewById(R.id.et_password);
        register = (Button) findViewById(R.id.register);
        login = (Button) findViewById(R.id.btn_login);
    }

}