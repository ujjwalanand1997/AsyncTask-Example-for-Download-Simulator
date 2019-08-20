package ujjwal.gl.asyncdownload.async;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DownloadAsync extends AsyncTask<Void,Integer,String> {

    Context mContext;
    TextView mStatusTxt;
    Button mDownload;
    ProgressBar mProgressBar;

    public DownloadAsync(Context mContext, TextView mStatusTxt, ProgressBar mProgressBar, Button mDownload) {
        this.mContext = mContext;
        this.mStatusTxt = mStatusTxt;
        this.mProgressBar = mProgressBar;
        this.mDownload = mDownload;
    }

    @Override
    protected String doInBackground(Void... voids) {
        int i = 0;

        synchronized (this) {
            while (i <= 10) {
                try {
                    wait(1500);
                    i++;
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return "Download Complete";
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressBar.setVisibility(View.VISIBLE);
        mDownload.setVisibility(View.INVISIBLE);
        mProgressBar.setMax(10);
        mProgressBar.setProgress(0);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        mProgressBar.setVisibility(View.INVISIBLE);
        mDownload.setVisibility(View.VISIBLE);
        mStatusTxt.setText(result);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mProgressBar.setProgress(values[0]);
        mStatusTxt.setText("Download in progress...");
    }
}
