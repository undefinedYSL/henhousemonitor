package com.example.fr.sanxing1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static com.example.fr.sanxing1.Constant.path;

public class AutocmdActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout home_img_bn_Layout, style_img_bn_layout, cam_img_bn_layout,
            shopping_img_bn_layout, show_img_bn_layout;

    private Button btn1,btn2,btn3;
    private Button btn_temp,btn_humi,btn_nh3,btn_h2s;
    private PickerView pickerViewmax,pickerViewmin;
    private String str1_1 = "";
    private String str1_2 = "";
    private String str1_3 = "";
    private String str1_4 = "";
    private String str2_1 = "";
    private String str2_2 = "";
    private String str2_3 = "";
    private String str2_4 = "";
    private int tag = 0;
    private EditText et_1,et_2,et_3,et_4;

    private URL url;
    HttpURLConnection urlConn=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_autocmd);


        home_img_bn_Layout = (LinearLayout) findViewById(R.id.bottom_home_layout_ly);
        home_img_bn_Layout.setOnClickListener(clickListener_home);


        style_img_bn_layout = (LinearLayout) findViewById(R.id.bottom_style_layout_ly);
        style_img_bn_layout.setOnClickListener(clickListener_style);

        cam_img_bn_layout = (LinearLayout) findViewById(R.id.bottom_cam_layout_ly);
        cam_img_bn_layout.setOnClickListener(clickListener_cam);
        cam_img_bn_layout.setSelected(true);

        shopping_img_bn_layout = (LinearLayout) findViewById(R.id.bottom_shopping_layout_ly);
        shopping_img_bn_layout.setOnClickListener(clickListener_shopping);

        show_img_bn_layout = (LinearLayout) findViewById(R.id.bottom_show_layout_ly);
        show_img_bn_layout.setOnClickListener(clickListener_show);

        btn1 = (Button)this.findViewById(R.id.btn_reset);
        btn1.setOnClickListener(this);
        btn2 = (Button)this.findViewById(R.id.btn_open);
        btn2.setOnClickListener(this);
        btn3 = (Button)this.findViewById(R.id.btn_close);
        btn3.setOnClickListener(this);
        btn_temp = (Button)this.findViewById(R.id.tv_temp1);
        btn_temp.setOnClickListener(this);
        btn_humi = (Button)this.findViewById(R.id.tv_humi1);
        btn_humi.setOnClickListener(this);
        btn_nh3 = (Button)this.findViewById(R.id.tv_NH31);
        btn_nh3.setOnClickListener(this);
        btn_h2s = (Button)this.findViewById(R.id.tv_H2S1);
        btn_h2s.setOnClickListener(this);
        et_1 = (EditText) findViewById(R.id.et_temp2);
        et_2 = (EditText) findViewById(R.id.et_humi2);
        et_3 = (EditText) findViewById(R.id.et_NH32);
        et_4 = (EditText) findViewById(R.id.et_H2S2);
        et_1.setFocusable(false);
        et_1.setFocusableInTouchMode(false);
        et_2.setFocusable(false);
        et_2.setFocusableInTouchMode(false);
        et_3.setFocusable(false);
        et_3.setFocusableInTouchMode(false);
        et_4.setFocusable(false);
        et_4.setFocusableInTouchMode(false);
    }

    private View.OnClickListener clickListener_home = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            home_img_bn_Layout.setSelected(true);
            style_img_bn_layout.setSelected(false);
            cam_img_bn_layout.setSelected(false);
            shopping_img_bn_layout.setSelected(false);
            show_img_bn_layout.setSelected(false);
            Intent intent = new Intent();
            intent.setClass(AutocmdActivity.this,MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.zoommin, R.anim.zoomout);
            finish();
        }
    };
    private View.OnClickListener clickListener_style = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            home_img_bn_Layout.setSelected(false);
            style_img_bn_layout.setSelected(true);
            cam_img_bn_layout.setSelected(false);
            shopping_img_bn_layout.setSelected(false);
            show_img_bn_layout.setSelected(false);
            Intent intent = new Intent();
            intent.setClass(AutocmdActivity.this, VideoActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.zoommin, R.anim.zoomout);
            finish();
        }
    };
    private View.OnClickListener clickListener_cam = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            home_img_bn_Layout.setSelected(false);
            style_img_bn_layout.setSelected(false);
            cam_img_bn_layout.setSelected(true);
            shopping_img_bn_layout.setSelected(false);
            show_img_bn_layout.setSelected(false);

        }
    };
    private View.OnClickListener clickListener_shopping = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            home_img_bn_Layout.setSelected(false);
            style_img_bn_layout.setSelected(false);
            cam_img_bn_layout.setSelected(false);
            shopping_img_bn_layout.setSelected(true);
            show_img_bn_layout.setSelected(false);
            Intent intent = new Intent();
            intent.setClass(AutocmdActivity.this,   ControlActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.zoommin, R.anim.zoomout);
            finish();
        }
    };
    private View.OnClickListener clickListener_show = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            home_img_bn_Layout.setSelected(false);
            style_img_bn_layout.setSelected(false);
            cam_img_bn_layout.setSelected(false);
            shopping_img_bn_layout.setSelected(false);
            show_img_bn_layout.setSelected(true);
            Intent intent = new Intent();
            intent.setClass(AutocmdActivity.this, ContactActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.zoommin, R.anim.zoomout);
            finish();
        }
    };

    public boolean onKeyDown(int keyCode,KeyEvent event)
    {
        if(keyCode== KeyEvent.KEYCODE_BACK)
        {
            dialog();
            return true;
        }
        else
        {
            return super.onKeyDown(keyCode, event);
        }
    }

    protected void dialog()
    {
        Dialog dialog = new AlertDialog.Builder(this).setTitle("温室管理终端").setMessage(
                "确认退出应用程序？").setPositiveButton("退出",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
                AutocmdActivity.this.finish();
            }
        }).setNegativeButton("取消",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        }).create();
        dialog.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_reset:
                et_1.setText("");
                et_2.setText("");
                et_3.setText("");
                et_4.setText("");
                break;
            case R.id.btn_close:
                sendMessage_toServer("CLOSE@");
                Toast.makeText(this, "已发送", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_open:
                if ((!"".equals(str1_1))&&(!"".equals(str1_2))&& (!"".equals(str1_3))&&(!"".equals(str1_4))){
                    sendMessage_toServer("OPEN@"+str1_1+"@"+str1_2+"@"+str1_3+"@"+str1_4+"@");
                    delay(750);
                    sendMessage_toServer("OPEN@"+str1_1+"@"+str1_2+"@"+str1_3+"@"+str1_4+"@");
                }
                Toast.makeText(this,"已发送",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_temp1:
                tag = 1;
                dialog1();
                break;
            case R.id.tv_humi1:
                tag = 2;
                dialog1();
                break;
            case R.id.tv_NH31:
                tag = 3;
                dialog1();
                break;
            case R.id.tv_H2S1:
                tag = 4;
                dialog1();
                break;
        }
    }

    private void dialog1() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //初始化自定义布局
        LayoutInflater layoutInflater = getLayoutInflater();
        final View customLayout = layoutInflater.inflate(R.layout.mypicker,(ViewGroup)findViewById(R.id.customDialog));
        //为对话框设置视图
        builder.setView(customLayout);
        pickerViewmax = (PickerView)customLayout.findViewById(R.id.picker1);
//        pickerViewmin = (PickerView)customLayout.findViewById(R.id.picker2);
        //定义滚动选择器的选项
        ArrayList<String> max = new ArrayList<>();
//        ArrayList<String> min = new ArrayList<>();
        max.clear();
//        min.clear();
        switch (tag){
            case 1:
                for (int i = 0;i<35;i++){
                    max.add(i+"");
                }
//                for (int j = 0;j<10;j++){
//                    min.add(j+"");
//                }
                break;
            case 2:
                for (int i = 0;i<=100;i+=5){
                    max.add(i+"");
                }
//                for (int j = 20;j<=50;j+=10){
//                    min.add("00"+j);
//                }
                break;
            case 3:
                for (int i = 0;i<10;i++){
                    max.add(i+"");
                }
//                for (int j = 0;j<10;j++){
//                    min.add(j+"");
//                }
                break;
            case 4:
                for (int i = 0;i<=10;i++){
                    max.add(i+"");
                }
//                for (int j = 20;j<=50;j+=10){
//                    min.add("00"+j);
//                }
                break;
        }
        //为滚动选择器设置数据
        pickerViewmax.setData(max);
//        pickerViewmin.setData(min);
        pickerViewmax.setOnSelectListener(new PickerView.onSelectListener() {
            @Override
            public void onSelect(String text) {
                switch (tag){
                    case 1:
                        str1_1 = text;
                        break;
                    case 2:
                        str1_2 = text;
                        break;
                    case 3:
                        str1_3 = text;
                        break;
                    case 4:
                        str1_4 = text;
                        break;
                }

            }
        });
//        pickerViewmin.setOnSelectListener(new PickerView.onSelectListener() {
//            @Override
//            public void onSelect(String text1) {
//                switch (tag){
//                    case 1:
//                        str2_1 = text1;
//                        break;
//                    case 2:
//                        str2_2 = text1;
//                        break;
//                    case 3:
//                        str2_3 = text1;
//                        break;
//                    case 4:
//                        str2_4 = text1;
//                        break;
//                }
//            }
//        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (tag == 1){
                    et_1.setText(str1_1);
                }else if (tag == 2){
                    et_2.setText(str1_2);
                }else if (tag == 3){
                    et_3.setText(str1_3);
                }else if (tag == 4){
                    et_4.setText(str1_4);
                }

            }
        });
        builder.setNegativeButton("取消",null);
        builder.show();
    }

    public void  sendMessage_toServer(String str){
        final String command_String =str;
        Thread myThread=new Thread(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try{
                    url = new URL(path);

                    urlConn=(HttpURLConnection) url.openConnection();
                    urlConn.setConnectTimeout(5000);
                    urlConn.setDoOutput(true);
                    urlConn.setDoInput(true);
                    urlConn.setRequestMethod("GET");
                    // TODO Auto-generated method stub
                    OutputStream out =urlConn.getOutputStream();
                    out.write(command_String.getBytes());
                    //count--;
                    out.flush();
                    while(urlConn.getContentLength()!=-1){
                        int code=urlConn.getResponseCode();
                        if(code==200)
                        {
                            Toast.makeText(AutocmdActivity.this, "控制指令已发送",Toast.LENGTH_LONG ).show();
                            urlConn.disconnect();
                            break;
                        }
                    }
                }catch (MalformedURLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }catch(Exception e2)
                {
                    e2.printStackTrace();
                }

            }
        });
        myThread.start();

    }

    private void delay(int ms){
        try {
            Thread.currentThread();
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
