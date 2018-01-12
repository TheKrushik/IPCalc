package com.example.angelinapulupchyk.ipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditTextIp1, mEditTextIp2, mEditTextIp3, mEditTextIp4,
            mEditTextM1, mEditTextM2, mEditTextM3, mEditTextM4;
    private CheckBox mCheckBoxDec, mCheckBoxBin, mCheckBoxHex;
    private Button mButtonCalc, mButtonClear;
    private LinearLayout ll_dec, ll_bin, ll_hex;
    private TextView tv_dec_ip, tv_dec_netmask, tv_dec_network, tv_dec_broadcast, tv_dec_count,
            tv_bin_ip, tv_bin_netmask, tv_bin_network, tv_bin_broadcast, tv_bin_count,
            tv_hex_ip, tv_hex_netmask, tv_hex_network, tv_hex_broadcast, tv_hex_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
    }

    private void findViewById() {
        mEditTextIp1 = findViewById(R.id.et_ip1);
        mEditTextIp2 = findViewById(R.id.et_ip2);
        mEditTextIp3 = findViewById(R.id.ed_ip3);
        mEditTextIp4 = findViewById(R.id.et_ip4);
        mEditTextM1 = findViewById(R.id.et_m1);
        mEditTextM2 = findViewById(R.id.et_m2);
        mEditTextM3 = findViewById(R.id.et_m3);
        mEditTextM4 = findViewById(R.id.et_m4);

        mCheckBoxDec = findViewById(R.id.cb_dec);
        mCheckBoxBin = findViewById(R.id.cb_bin);
        mCheckBoxHex = findViewById(R.id.cb_hex);

        mButtonClear = findViewById(R.id.btn_clear);
        mButtonCalc = findViewById(R.id.btn_calc);

        ll_dec = findViewById(R.id.ll_dec);
        ll_bin = findViewById(R.id.ll_bin);
        ll_hex = findViewById(R.id.ll_hex);

        tv_dec_ip = findViewById(R.id.tv_dec_ip);
        tv_dec_netmask = findViewById(R.id.tv_dec_netmask);
        tv_dec_network = findViewById(R.id.tv_dec_network);
        tv_dec_broadcast = findViewById(R.id.tv_dec_broadcast);
        tv_dec_count = findViewById(R.id.tv_dec_count);
        tv_bin_ip = findViewById(R.id.tv_bin_ip);
        tv_bin_netmask = findViewById(R.id.tv_bin_netmask);
        tv_bin_network = findViewById(R.id.tv_bin_network);
        tv_bin_broadcast = findViewById(R.id.tv_bin_broadcast);
        tv_bin_count = findViewById(R.id.tv_bin_count);
        tv_hex_ip = findViewById(R.id.tv_hex_ip);
        tv_hex_netmask = findViewById(R.id.tv_hex_netmask);
        tv_hex_network = findViewById(R.id.tv_hex_network);
        tv_hex_broadcast = findViewById(R.id.tv_hex_broadcast);
        tv_hex_count = findViewById(R.id.tv_hex_count);

        mButtonCalc.setOnClickListener(this);
        mButtonClear.setOnClickListener(this);
    }

    public String decToBin(int a) {
        String b = "00000000";
        String c;
        c = Integer.toString(a, 2);
        b = b.substring(0, 8 - c.length()) + c;
        return b;
//        return Integer.toBinaryString(a);
//        return Integer.toHexString(a);
    }

    public String binToDec(int a) {
        String d = Integer.toString(a);
        char[] s = d.toCharArray();
        int res = 0;
        int b;
        int m = 0;
        for (int i = d.length() - 1; i >= 0; i--) {
            int temp = 0;
            b = Character.getNumericValue(s[i]);
            temp = (int) (b * Math.pow(2, m));
            m++;
            res += temp;
        }
        return Integer.toString(res);
    }

    public void Set(String a, EditText b) {
        b.setText(a);
    }

    public boolean checkBin(String a) {
        Pattern pattern = Pattern.compile("[0-1]{8}");
        Matcher matcher = pattern.matcher(a);
        return matcher.matches();
    }

    public boolean checkDec(String a) {
        return a.length() > 0 && a.length() <= 3 && Integer.parseInt(a) < 256;
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_clear:
                clearFields();
                break;
            case R.id.btn_calc:
                calcDec();
                calcBin();
                calcHex();
                if (getValidation()) return;

//                stringToInt();
//                intTo10Int();
//
//                //Перевод в нужный тип
//                if (DECBIN.isChecked() && mEditTextIp1.getText().toString().length() != 8) {
//                    String a;
//                    a = decToBin(ip1);
//                    Set("", mEditTextIp1);
//                    Set(a, mEditTextIp1);
//                    a = decToBin(ip2);
//                    Set("", mEditTextIp2);
//                    Set(a, mEditTextIp2);
//                    a = decToBin(ip3);
//                    Set("", mEditTextIp3);
//                    Set(a, mEditTextIp3);
//                    a = decToBin(ip4);
//                    Set("", mEditTextIp4);
//                    Set(a, mEditTextIp4);
//                    a = decToBin(m1);
//                    Set("", mEditTextM1);
//                    Set(a, mEditTextM1);
//                    a = decToBin(m2);
//                    Set("", mEditTextM2);
//                    Set(a, mEditTextM2);
//                    a = decToBin(m3);
//                    Set("", mEditTextM3);
//                    Set(a, mEditTextM3);
//                    a = decToBin(m4);
//                    Set("", mEditTextM4);
//                    Set(a, mEditTextM4);
//                } /*else {*/
//                if (!DECBIN.isChecked() && mEditTextIp1.getText().toString().length() == 8) {
//                    String a;
//                    a = binToDec(ip1);
//                    Set("", mEditTextIp1);
//                    Set(a, mEditTextIp1);
//                    a = binToDec(ip2);
//                    Set("", mEditTextIp2);
//                    Set(a, mEditTextIp2);
//                    a = binToDec(ip3);
//                    Set("", mEditTextIp3);
//                    Set(a, mEditTextIp3);
//                    a = binToDec(ip4);
//                    Set("", mEditTextIp4);
//                    Set(a, mEditTextIp4);
//                    a = binToDec(m1);
//                    Set("", mEditTextM1);
//                    Set(a, mEditTextM1);
//                    a = binToDec(m2);
//                    Set("", mEditTextM2);
//                    Set(a, mEditTextM2);
//                    a = binToDec(m3);
//                    Set("", mEditTextM3);
//                    Set(a, mEditTextM3);
//                    a = binToDec(m4);
//                    Set("", mEditTextM4);
//                    Set(a, mEditTextM4);
//                    stringToInt();
//                }
//
//
//                //Формирования IP dec and bin
//                ipDec = /*"IP: " +*/ ip1 + "." + ip2 + "." + ip3 + "." + ip4;
//                ipBin = /*"IP: " +*/ decToBin(ip1) + "." + decToBin(ip2) + "." + decToBin(ip3) + "." + decToBin(ip4);
//
//                //Формирования Mask dec and bin
//                maskDec = /*"Mask: " +*/ m1 + "." + m2 + "." + m3 + "." + m4;
//                maskBin = /*"Mask: " +*/ decToBin(m1) + "." + decToBin(m2) + "." + decToBin(m3) + "." + decToBin(m4);
//
//
//                //Формирования Network dec and bin
//                for (int i = maskBin.length() - 1; ; i--) {
//                    if (maskBin.charAt(i) == '0') count++;
//                    if (maskBin.charAt(i) == '.') ;
//                    if (maskBin.charAt(i) == '1') break;
//                }
//
//                networkBin = ipBin.substring(0, ipBin.length() - count - count / 8);
//                for (int i = networkBin.length(); i < 35; i++) {
//                    if (i == 8 || i == 17 || i == 26) networkBin += ".";
//                    else networkBin += "0";
//                }
//
//                networkDec = binToDec(Integer.parseInt(networkBin.substring(0, 8))) + "." +
//                        binToDec(Integer.parseInt(networkBin.substring(9, 17))) + "." +
//                        binToDec(Integer.parseInt(networkBin.substring(18, 26))) + "." +
//                        binToDec(Integer.parseInt(networkBin.substring(27, 35)));
////                networkBin = "Network: " + networkBin;
////                networkDec = "Network: " + networkDec;
//
//                //Формирования Broadcast dec and bin
//                broadcastBin = ipBin.substring(0, ipBin.length() - count - count / 8);
//                for (int i = broadcastBin.length(); i < 35; i++) {
//                    if (i == 8 || i == 17 || i == 26) broadcastBin += ".";
//                    else broadcastBin += "1";
//                }
//                broadcastDec = binToDec(Integer.parseInt(broadcastBin.substring(0, 8))) + "." +
//                        binToDec(Integer.parseInt(broadcastBin.substring(9, 17))) + "." +
//                        binToDec(Integer.parseInt(broadcastBin.substring(18, 26))) + "." +
//                        binToDec(Integer.parseInt(broadcastBin.substring(27, 35)));
////                broadcastBin = "Broadcast: " + broadcastBin;
////                broadcastDec = "Broadcast: " + broadcastDec;
//
//                //Вывод всего на экран
//                mTextViewDec.setText(String.format("%s\n%s\n%s\n%s\nCount: %s",
//                        "IP: " + ipDec, "Mask: " + maskDec, "Network: " + networkDec, "Broadcast: " + broadcastDec, Math.pow(2, count) - 2));
//                mTextViewBin.setText(String.format("%s\n%s\n%s\n%s\nCount: %s",
//                        "IP: " + ipBin, "Mask: " + maskBin, "Network: " + networkBin, "Broadcast: " + broadcastBin, Math.pow(2, count) - 2));


                break;
        }

    }

    private void calcDec() {
        if (mCheckBoxDec.isChecked()) {
            ll_dec.setVisibility(View.VISIBLE);
        } else {
            ll_dec.setVisibility(View.GONE);
        }
    }

    private void calcBin() {
        if (mCheckBoxBin.isChecked()) {
            ll_bin.setVisibility(View.VISIBLE);
        } else {
            ll_bin.setVisibility(View.GONE);
        }
    }

    private void calcHex() {
        if (mCheckBoxHex.isChecked()) {
            ll_hex.setVisibility(View.VISIBLE);
        } else {
            ll_hex.setVisibility(View.GONE);
        }
    }

//    private void intTo10Int() {
//        //Перевод в 10 вид для дальнейшей работы
//        if (DECBIN.isChecked() && mEditTextIp1.getText().toString().length() == 8) {
//            ip1 = Integer.parseInt(binToDec(ip1));
//            ip2 = Integer.parseInt(binToDec(ip2));
//            ip3 = Integer.parseInt(binToDec(ip3));
//            ip4 = Integer.parseInt(binToDec(ip4));
//            m1 = Integer.parseInt(binToDec(m1));
//            m2 = Integer.parseInt(binToDec(m2));
//            m3 = Integer.parseInt(binToDec(m3));
//            m4 = Integer.parseInt(binToDec(m4));
//        }
//    }

//    private void stringToInt() {
//        ip1 = Integer.parseInt(mEditTextIp1.getText().toString());
//        ip2 = Integer.parseInt(mEditTextIp2.getText().toString());
//        ip3 = Integer.parseInt(mEditTextIp3.getText().toString());
//        ip4 = Integer.parseInt(mEditTextIp4.getText().toString());
//        m1 = Integer.parseInt(mEditTextM1.getText().toString());
//        m2 = Integer.parseInt(mEditTextM2.getText().toString());
//        m3 = Integer.parseInt(mEditTextM3.getText().toString());
//        m4 = Integer.parseInt(mEditTextM4.getText().toString());
//    }

    private boolean getValidation() {
        //Миллион проверок
        if ((TextUtils.isEmpty(mEditTextIp1.getText().toString()) || TextUtils.isEmpty(mEditTextIp2.getText().toString()) ||
                TextUtils.isEmpty(mEditTextIp3.getText().toString()) || TextUtils.isEmpty(mEditTextIp4.getText().toString()) ||
                TextUtils.isEmpty(mEditTextM1.getText().toString()) || TextUtils.isEmpty(mEditTextM2.getText().toString()) ||
                TextUtils.isEmpty(mEditTextM3.getText().toString()) || TextUtils.isEmpty(mEditTextM4.getText().toString())) ||
                !((checkDec(mEditTextIp1.getText().toString()) || checkBin(mEditTextIp1.getText().toString())) &&
                        (checkDec(mEditTextIp2.getText().toString()) || checkBin(mEditTextIp2.getText().toString())) &&
                        (checkDec(mEditTextIp3.getText().toString()) || checkBin(mEditTextIp3.getText().toString())) &&
                        (checkDec(mEditTextIp4.getText().toString()) || checkBin(mEditTextIp4.getText().toString())) &&
                        (checkDec(mEditTextM1.getText().toString()) || checkBin(mEditTextM1.getText().toString())) &&
                        (checkDec(mEditTextM2.getText().toString()) || checkBin(mEditTextM2.getText().toString())) &&
                        (checkDec(mEditTextM3.getText().toString()) || checkBin(mEditTextM3.getText().toString())) &&
                        (checkDec(mEditTextM4.getText().toString()) || checkBin(mEditTextM4.getText().toString())))) {
            return true;
        }
        return false;
    }

    private void clearFields() {
        mEditTextIp1.setText("");
        mEditTextIp2.setText("");
        mEditTextIp3.setText("");
        mEditTextIp4.setText("");
        mEditTextM1.setText("");
        mEditTextM2.setText("");
        mEditTextM3.setText("");
        mEditTextM4.setText("");
//        mTextViewBin.setText("");
//        mTextViewDec.setText("");
        tv_dec_ip.setText("");
        tv_dec_netmask.setText("");
        tv_dec_network.setText("");
        tv_dec_broadcast.setText("");
        tv_dec_count.setText("");
        tv_bin_ip.setText("");
        tv_bin_netmask.setText("");
        tv_bin_network.setText("");
        tv_bin_broadcast.setText("");
        tv_bin_count.setText("");
        tv_hex_ip.setText("");
        tv_hex_netmask.setText("");
        tv_hex_network.setText("");
        tv_hex_broadcast.setText("");
        tv_hex_count.setText("");
    }


}
