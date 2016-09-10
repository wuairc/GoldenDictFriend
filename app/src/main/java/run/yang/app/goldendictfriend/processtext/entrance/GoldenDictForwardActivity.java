package run.yang.app.goldendictfriend.processtext.entrance;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import run.yang.app.goldendictfriend.R;
import run.yang.app.goldendictfriend.processtext.GoldenDictProcessor;
import run.yang.app.goldendictfriend.processtext.bean.ProcessTextInputBean;


@TargetApi(Build.VERSION_CODES.M)
public class GoldenDictForwardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handleIntent(getIntent());
        finish();
    }

    private void handleIntent(Intent intent) {
        final GoldenDictProcessor processor = new GoldenDictProcessor();

        if (!processor.isGoldenDictInstalled()) {
            Toast.makeText(this, R.string.goldendict_not_installed, Toast.LENGTH_SHORT).show();
            return;
        }

        if (Intent.ACTION_PROCESS_TEXT.equals(intent.getAction())) {
            CharSequence keyword = intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT);
            boolean readonly = intent.getBooleanExtra(Intent.EXTRA_PROCESS_TEXT_READONLY, false);

            final ProcessTextInputBean bean = new ProcessTextInputBean(keyword, readonly);
            processor.gotoGoldenDict(bean);
        }
    }
}
