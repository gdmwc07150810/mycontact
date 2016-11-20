package cn.edu.gdmec.a07150810.mycontact;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by qaq on 2016/11/15.
 */
public class ContactsMessageActivity extends AppCompatActivity{
    private TextView nameEditText;
    private TextView mobileEditText;
    private TextView qqEditText;
    private TextView danweiEditText;
    private TextView addressEditText;
    private User user;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_message);
        nameEditText= (TextView) findViewById(R.id.name);
        mobileEditText= (TextView) findViewById(R.id.mobile);
        danweiEditText= (TextView) findViewById(R.id.danwei);
        qqEditText= (TextView) findViewById(R.id.qq);
        addressEditText= (TextView) findViewById(R.id.address);
        Bundle localBundle=getIntent().getExtras();
        int id=localBundle.getInt("user_ID");
        ContactsTable ct=new ContactsTable(this);
        user = ct.getUserByID(id);
        nameEditText.setText("姓名："+user.getName());
        mobileEditText.setText("电话："+user.getMobile());
        qqEditText.setText("QQ："+user.getQq());
        danweiEditText.setText("单位："+user.getDanwei());
        addressEditText.setText("地址："+user.getAddress());
    }
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,1,0,"返回");
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case 1:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
