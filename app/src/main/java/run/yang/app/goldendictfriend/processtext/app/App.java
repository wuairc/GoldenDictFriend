package run.yang.app.goldendictfriend.processtext.app;

import android.app.Application;

import run.yang.app.goldendictfriend.processtext.util.app.ContextHolder;

/**
 * Created by ty on 9/10/16.
 */

public class App extends Application {
    {
        ContextHolder.init(this);
    }
}

