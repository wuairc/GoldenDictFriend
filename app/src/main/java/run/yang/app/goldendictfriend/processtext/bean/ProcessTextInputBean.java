package run.yang.app.goldendictfriend.processtext.bean;

/**
 * Created by ty on 9/10/16.
 */

public class ProcessTextInputBean {
    public final CharSequence keyword;
    public final boolean readonly;

    public ProcessTextInputBean(CharSequence keyword, boolean readonly) {
        this.keyword = keyword;
        this.readonly = readonly;
    }

    @Override
    public String toString() {
        return "ProcessTextInputBean{" +
                "keyword=" + keyword +
                ", readonly=" + readonly +
                '}';
    }
}
