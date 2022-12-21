//TESTS

package com.example.effectivetask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

public class QRActivity extends AppCompatActivity {
    //0
    AppCompatButton qradd;
    List<View> allEds;

    //1
    ProgressBar progressbarQR1;
    ProgressBar progressbarHorizontalQR1;
    Button stopProgressbarHorizontalQR1Stop;
    //2
    TextView textViewQR2;
    Button Button0QR2;
    //3
    TextView textView0QR3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qractivity);
        //0

        qradd = findViewById(R.id.qradd);
        allEds = new ArrayList<View>();

        final LinearLayout qrlinear = (LinearLayout) findViewById(R.id.qrlinear);

        qradd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View view = getLayoutInflater().inflate(R.layout.custom_layout0, null);//custom layout
                Button deleteField = (Button) view.findViewById(R.id.button2);
                EditText text = (EditText) view.findViewById(R.id.editText);
                text.setText("Some text");
                allEds.add(view);//add to list
                qrlinear.addView(view);//add to page
            }
        });
        //Delete
        /*Button deleteField = (Button) view.findViewById(R.id.button2);
        deleteField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //получаем родительский view и удаляем его
                    ((LinearLayout) view.getParent()).removeView(view);
                    //удаляем эту же запись из массива что бы не оставалось мертвых записей
                    allEds.remove(view);
                } catch(IndexOutOfBoundsException ex) {
                    ex.printStackTrace();
                }
            }
        });*/





        //1
        progressbarQR1 = findViewById(R.id.progressbarQR1);
        progressbarHorizontalQR1 = findViewById(R.id.progressbarHorizontalQR1);
        stopProgressbarHorizontalQR1Stop = findViewById(R.id.stopProgressbarHorizontalQR1Stop);
        new QR0Background().execute();
        new QR1Background().execute();
        //stopProgressbarHorizontalQR1Stop.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        QR1Background.cancel(true);
        //    }
        //});


        //2
        //2.1
        textViewQR2 = findViewById(R.id.textViewQR2);
        //io.reactivex.Observable.range(1,100)
         //       .flatMap(I -> Observable.just(I)
           //             //.map(App::Sleep.Sec(I))
             //           .subscribeOn(Schedulers.computation()))
               //         .subscribe(I -> textViewQR2.setText(I.toString()));//, TimeUnit.SECONDS.sleep(1););
        //2.2
        Button0QR2 = findViewById(R.id.Button0QR2);


        //3
        textView0QR3 = findViewById(R.id.textView0QR3);





    }

    private void startAsyncTaskInParallel(QR0Background qr0B) {
    }

    //1.0
    class QR0Background extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressbarQR1.setVisibility(View.VISIBLE);
        }
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            progressbarQR1.setVisibility(View.INVISIBLE);
        }
    }
    //1.1
    class QR1Background extends AsyncTask<Void, Integer, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressbarHorizontalQR1.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressbarHorizontalQR1.setProgress(values[0]);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                //int counter = 0;

                for (int i = 0; i < 100; i++) {
                    if (isCancelled())
                        return null;
                    TimeUnit.SECONDS.sleep(1);
                    publishProgress(i);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            progressbarHorizontalQR1.setVisibility(View.INVISIBLE);
        }
        //@Override
        //protected void onCancelled() {
        //    super.onCancelled();
        //}
    }


    //2.0
    static class Sleep {
        public static int Sec(int val) throws InterruptedException {
            TimeUnit.SECONDS.sleep(5);
            return val;
        }
    }




}