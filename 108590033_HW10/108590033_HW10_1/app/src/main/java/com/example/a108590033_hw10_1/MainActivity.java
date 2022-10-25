package com.example.a108590033_hw10_1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    // Key for saving the state of the TextView
    private static final String TEXT_STATE = "currentText";

    // The TextView where we will show results
    private TextView mTextView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView1);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);

        // Restore TextView if there is a savedInstanceState bundle.
        if (savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    /**
     * Handles the onClick for the "Start Task" button. Launches the AsyncTask
     * which performs work off of the UI thread.
     *
     * @param view The view (Button) that was clicked.
     */
    public void startTask(View view) {
        ExampleAsyncTask task = new ExampleAsyncTask(this);
        task.execute(10);
        // Put a message in the text view.
        mTextView.setText(R.string.napping);
        // Start the AsyncTask.
        // The AsyncTask has a callback that will update the text view.
        new SimpleAsyncTask(mTextView).execute();
    }
    private static class ExampleAsyncTask extends AsyncTask<Integer,Integer,String>{
        private WeakReference<MainActivity> activityWeakReference;

        public ExampleAsyncTask(MainActivity activity){
            activityWeakReference = new WeakReference<MainActivity>(activity);
        }
        

        @Override
        protected  String doInBackground(Integer... integers){
            for (int i =0;i<integers[0];i++){
                publishProgress((i*100)/integers[0]);
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            return "Finished";
        }
        @Override
        protected  void onPreExecute(){
            super.onPreExecute();
            MainActivity activity = activityWeakReference.get();
            if(activity == null || activity.isFinishing()){
                return;
            }
            activity.progressBar.setVisibility(View.VISIBLE);
        }
        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            MainActivity activity = activityWeakReference.get();
            if(activity == null || activity.isFinishing()){
                return;
            }
            activity.progressBar.setProgress(0);
            activity.progressBar.setVisibility(View.INVISIBLE);
        }
        @Override
        protected void onProgressUpdate(Integer... values){
            super.onProgressUpdate(values);
            MainActivity activity = activityWeakReference.get();
            if(activity == null || activity.isFinishing()){
                return;
            }
            activity.progressBar.setProgress(values[0]);
        }
    }

    /**
     * Saves the contents of the TextView to restore on configuration change.
     *
     * @param outState The bundle in which the state of the activity is saved when
     *                 it is spontaneously destroyed.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the state of the TextView
        outState.putString(TEXT_STATE, mTextView.getText().toString());
    }
}
