package com.example.app;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.*;
import android.view.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button tinh = (Button) findViewById(R.id.giaipt);
         Button clear = (Button) findViewById(R.id.clear);
         Button exit = (Button) findViewById(R.id.exit);
        final TextView result = (TextView) findViewById(R.id.result);
        TextView tva = (TextView) findViewById(R.id.textViewa);
        TextView tvb = (TextView) findViewById(R.id.textViewb);
        TextView tvc = (TextView) findViewById(R.id.textViewc);

        tinh.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String sa = ((EditText) findViewById(R.id.nhapa)).getText().toString();
                String sb = ((EditText) findViewById(R.id.nhapb)).getText().toString();
                String sc = ((EditText) findViewById(R.id.nhapc)).getText().toString();



                if(sa.equals("") || sb.equals("") || sc.equals(""))
                {
                    result.setText("Lỗi!!!!");
                    if (sa.equals("")){
                        tva.setText("Chưa nhập số a");
                    }else{
                        tva.setText("");
                    }
                    if (sb.equals("")){
                        tvb.setText("Chưa nhập số b");
                    }else{
                        tvb.setText("");
                    }
                    if (sc.equals("")){
                        tvc.setText("Chưa nhập số c");
                    }else{
                        tvc.setText("");
                    }
                }else{
                    tva.setText("");
                    tvb.setText("");
                    tvc.setText("");
                    double a = Double.parseDouble(sa);
                    double b = Double.parseDouble(sb);
                    double c = Double.parseDouble(sc);
                    if (a == 0)
                    {
                        result.setText("Phương trình bậc I: ");
                        if (b == 0)
                        {
                            if (c == 0)
                                result.setText(result.getText() + "Phương trình có vô số nghiệm");
                            else
                                result.setText(result.getText() + "Phương trình vô nghiệm");
                        }
                        else
                        {
                            result.setText(result.getText() +" x = " + String.format("%.6f",(-c/b)));
                        }
                    }
                    else
                    {
                        double delta = b*b-4*a*c;
                        if (delta < 0.0)
                        {
                            result.setText("Phương trình vô nghiệm\n");
                        }
                        else
                        if (delta == 0)
                        {
                            result.setText("Phương trình có nghiệm kép = " +  String.format("%.6f",(-b/(2*a))));
                        }
                        else
                        {
                            double delta_sqrt = Math.sqrt(delta);
                            result.setText("x1 = " + String.format("%.6f",((b*b + delta_sqrt)/(2 * a))) + "\n" +"x2 = " + String.format("%.6f",((b*b-delta_sqrt)/(2 * a))));
                        }
                    }
                }

            }
        });
        clear.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                ((EditText) findViewById(R.id.nhapa)).setText("");
                ((EditText) findViewById(R.id.nhapb)).setText("");
                ((EditText) findViewById(R.id.nhapc)).setText("");
                ((TextView) findViewById(R.id.result)).setText("");
                tva.setText("");
                tvb.setText("");
                tvc.setText("");
            }
        });
        exit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}