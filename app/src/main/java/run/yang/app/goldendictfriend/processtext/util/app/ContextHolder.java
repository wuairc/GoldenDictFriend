package run.yang.app.goldendictfriend.processtext.util.app;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by ty on 9/10/16.
 */

public class ContextHolder {
    private static Context sContext;

    public static void init(@NonNull Context context) {
        sContext = context;
    }

    public static Context appContext() {
        return sContext;
    }
}
