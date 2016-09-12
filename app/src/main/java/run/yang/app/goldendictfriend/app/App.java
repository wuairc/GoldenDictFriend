package run.yang.app.goldendictfriend.app;

import android.app.Application;

/**
 * Created by ty on 9/10/16.
 */

public class App extends Application {
    // execute before constructor
    {
        ContextHolder.init(this);
    }
}

