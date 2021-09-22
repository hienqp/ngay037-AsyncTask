package com.hienqp.asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;


public class UpdateTextView extends AsyncTask<Void, String, String> {
    private Activity activity;
    private TextView textViewUpdate;

    public UpdateTextView(Activity activity) {
        this.activity = activity;
        textViewUpdate = (TextView) activity.findViewById(R.id.textView_update);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        textViewUpdate.setText("Bắt đầu...\n");
    }

    @Override
    protected String doInBackground(Void... voids) {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(String.valueOf(i));
        }
        return "Kết thúc...\n";
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        textViewUpdate.append("Thực hiện công việc " + values[0] + "\n");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textViewUpdate.append(s);
    }
}