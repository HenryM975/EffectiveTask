//TESTS

package com.example.effectivetask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.AsyncTask;
import android.os.Bundle;
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
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
    TextView textView1QR2;
    TextView textView2QR2;
    Button Button0QR2;
    //3
    TextView textView0QR3;
    TextView textView1QR3;
    TextView textView2QR3;
    TextView textView3QR3;
    TextView textView4QR3;
    TextView textView5QR3;



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


        //2RX
        //2.1
        /*ArrayList<Integer> QR2List = new ArrayList<Integer>();
        for(int i = 0; i < 100; i++)
            QR2List.add(i);
        Observable O1QR2 = Observable.fromIterable(QR2List);
        O1QR2.map(i -> Integer.parseInt((String) i) * 2);
        Observable O2QR2 = Observable.fromIterable(QR2List);
        O2QR2.map(i -> Integer.parseInt((String) i) * 2);
        Observable O3QR2 = (Observable) Observable.merge(O1QR2, O2QR2)
                .debounce(10, TimeUnit.MILLISECONDS);
                //.subscribe(i -> textViewQR2.setText(((Integer) i).toString()));//? io.reactivex.internal.observers.LambdaObserver cannot be cast to io.reactivex.Observable
        /*Observable.fromIterable(QR2List)
                .filter(i -> i % 2 == 0)
                .subscribe(i ->textViewQR2.setText(i.toString()));

        Observable o4QR2 = Observable.fromIterable(QR2List);
        //io.reactivex.Observable.range(1,100)
        o4QR2.flatMap(I -> Observable.just(I) //+
                        //.map(App::Sleep.Sec(I))
                        //.timeInterval()
                        .subscribeOn(Schedulers.computation()));
                        //.subscribe(I -> textViewQR2.setText(I.toString()));//, TimeUnit.SECONDS.sleep(1););*/



        ArrayList<Integer> QR2List = new ArrayList<Integer>();
        for(int i = 0; i < 100; i++)
            QR2List.add(i);
        textViewQR2 = findViewById(R.id.textViewQR2);
        //Observable O5QR2 = Observable.fromArray(QR2List);
        //Observable O5QR2 = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Observable O5QR2 = Observable.just(1);//.range(1, 10);
        O5QR2.subscribeOn(Schedulers.newThread())
                .delay(2, TimeUnit.SECONDS)//первичная задержка
                .interval(10, TimeUnit.SECONDS)//промежуточный интервал без пропусков бесконечный
                .takeWhile(I -> I < 10)
                .subscribe(I ->
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textViewQR2.append(I.toString());
                                // Stuff that updates the UI
                            }
                        }));







        Integer timeQR2 = 10;
        textView1QR2 = findViewById(R.id.textView1QR2);
        Observable O6QR2 = Observable.interval(timeQR2, TimeUnit.SECONDS)
                .map(I -> " .+" + I);
        Observable O7QR2 = Observable.interval(timeQR2, TimeUnit.SECONDS)
                .map(I -> " .-" + I);
        Observable O8QR2 = Observable.merge(O6QR2, O7QR2);
        O8QR2.subscribeOn(Schedulers.newThread())
                .subscribe(I ->
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textView1QR2.append(I.toString());
                                // Stuff that updates the UI
                            }
                        }));
        textView2QR2 = findViewById(R.id.textView2QR2);
        Observable O9QR2 = Observable.timer(10, TimeUnit.SECONDS);
        O9QR2.repeat()
        .subscribe(I ->
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView2QR2.append(I.toString());
                        // Stuff that updates the UI
                    }
                }));


        //2.2
        Button0QR2 = findViewById(R.id.Button0QR2);
        //Observable O10QR2 = Observable

















        //3RF
        textView0QR3 = findViewById(R.id.textView0QR3);
        textView1QR3 = findViewById(R.id.textView1QR3);
        textView2QR3 = findViewById(R.id.textView2QR3);
        textView3QR3 = findViewById(R.id.textView3QR3);
        textView4QR3 = findViewById(R.id.textView4QR3);
        textView5QR3 = findViewById(R.id.textView5QR3);
        /*URL BASE_URL = "https://run.mocky.io/v3/53539a72-3c5f-4f30-bbb1-6ca10d42c149"
        Retrofit retrofitQR3 = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TestRetrofit server = retrofit.create(TestRetrofit.class);
        Call<QR3Data> apiQR3 = server.getList();

        apiQR3.enqueue(new Callback<QR3Data>() {
            @Override
            public void onResponse(Call<QR3Data> call, Response<QR3Data> response) {
                textView0QR3.setText(response.body().getDelivery()); //+
                textView1QR3.setText(response.body().getId());
                textView2QR3.setText(response.body().getBasket().get(0).getTitle());
                textView3QR3.setText(Integer.toString(response.body().getBasket().get(0).getPrice()));
                textView4QR3.setText(response.body().getBasket().get(1).getTitle());
                textView5QR3.setText(Integer.toString(response.body().getBasket().get(1).getPrice()));
            }

            @Override
            public void onFailure(Call<QR3Data> call, Throwable t) {
                textView0QR3.setText(t.getMessage());
                textView1QR3.setText(t.getMessage());
                textView2QR3.setText(t.getMessage());
                textView3QR3.setText(t.getMessage());
                textView4QR3.setText(t.getMessage());
                textView5QR3.setText(t.getMessage());
            }
        });


        //4RF+RXQR4
        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")//https://run.mocky.io/v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();






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