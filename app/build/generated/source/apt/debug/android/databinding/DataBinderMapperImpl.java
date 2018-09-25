
package android.databinding;
import com.nisum.reactivescorecard.BR;
class DataBinderMapperImpl extends android.databinding.DataBinderMapper {
    public DataBinderMapperImpl() {
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.nisum.reactivescorecard.R.layout.activity_scorecard:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_scorecard_0".equals(tag)) {
                            return new com.nisum.reactivescorecard.databinding.ActivityScorecardBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_scorecard is invalid. Received: " + tag);
                }
                case com.nisum.reactivescorecard.R.layout.row:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/row_0".equals(tag)) {
                            return new com.nisum.reactivescorecard.databinding.RowBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for row is invalid. Received: " + tag);
                }
        }
        return null;
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    @Override
    public int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case 2069714024: {
                if(tag.equals("layout/activity_scorecard_0")) {
                    return com.nisum.reactivescorecard.R.layout.activity_scorecard;
                }
                break;
            }
            case 853995494: {
                if(tag.equals("layout/row_0")) {
                    return com.nisum.reactivescorecard.R.layout.row;
                }
                break;
            }
        }
        return 0;
    }
    @Override
    public String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"player"};
    }
}