package run.yang.app.goldendictfriend.processtext;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import run.yang.app.goldendictfriend.R;
import run.yang.app.goldendictfriend.processtext.bean.ProcessTextInputBean;
import run.yang.app.goldendictfriend.processtext.util.app.ContextHolder;

/**
 * Created by ty on 9/10/16.
 */

public class GoldenDictProcessor {
    private static final String TAG = "GoldenDictProcessor";

    private static final String GOLDEN_DICT_SEARCH_ACTION = "goldendict.intent.action.SEARCH";
    private static final String GOLDEN_DICT_EXTRA_QUERY = "EXTRA_QUERY";

    private Intent mIntent;

    public void gotoGoldenDict(ProcessTextInputBean bean) {
        buildFilterIntentIfNeeded();

        String query;
        if (TextUtils.isEmpty(bean.keyword)) {
            query = "";
            Log.e(TAG, "unexpected empty query");
        } else {
            query = bean.keyword.toString();
        }

        mIntent.putExtra(GOLDEN_DICT_EXTRA_QUERY, query);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Context context = ContextHolder.appContext();
        try {
            context.startActivity(mIntent);
        } catch (Exception e) {
            Toast.makeText(context, R.string.cannot_start_dictionary, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public boolean isGoldenDictInstalled() {
        Context context = ContextHolder.appContext();

        buildFilterIntentIfNeeded();
        ComponentName componentName = mIntent.resolveActivity(context.getPackageManager());
        Log.d(TAG, "resolved component: " + componentName);
        return componentName != null;
    }

    private void buildFilterIntentIfNeeded() {
        if (mIntent == null) {
            mIntent = new Intent(GOLDEN_DICT_SEARCH_ACTION);
        }
    }
}
