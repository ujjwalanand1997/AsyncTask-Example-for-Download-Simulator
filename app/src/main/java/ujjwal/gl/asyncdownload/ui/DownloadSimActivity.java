package ujjwal.gl.asyncdownload.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import ujjwal.gl.asyncdownload.R;
import ujjwal.gl.asyncdownload.async.DownloadAsync;

public class DownloadSimActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mStatusTxt;
    Button mDownload;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_sim);

        if(getSupportActionBar()!=null)
            getSupportActionBar().hide();

        initViews();

        mDownload.setOnClickListener(this);
    }

    private void initViews() {

        mStatusTxt = findViewById(R.id.status_txt);
        mDownload = findViewById(R.id.start_download);
        mProgressBar = findViewById(R.id.progress_bar);
    }

    @Override
    public void onClick(View view) {
        DownloadAsync async = new DownloadAsync(DownloadSimActivity.this,mStatusTxt,mProgressBar,mDownload);
        async.execute();
    }
}
