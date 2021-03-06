package com.nisum.reactivescorecard.databinding;
import com.nisum.reactivescorecard.R;
import com.nisum.reactivescorecard.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityScorecardBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.txt_scoreboard, 1);
        sViewsWithIds.put(R.id.divider1, 2);
        sViewsWithIds.put(R.id.et_playername, 3);
        sViewsWithIds.put(R.id.img_save, 4);
        sViewsWithIds.put(R.id.txt_players, 5);
        sViewsWithIds.put(R.id.divider2, 6);
        sViewsWithIds.put(R.id.recyclerview, 7);
    }
    // views
    @NonNull
    public final android.view.View divider1;
    @NonNull
    public final android.view.View divider2;
    @NonNull
    public final android.widget.EditText etPlayername;
    @NonNull
    public final android.widget.ImageView imgSave;
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    @NonNull
    public final android.support.v7.widget.RecyclerView recyclerview;
    @NonNull
    public final android.widget.TextView txtPlayers;
    @NonNull
    public final android.widget.TextView txtScoreboard;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityScorecardBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds);
        this.divider1 = (android.view.View) bindings[2];
        this.divider2 = (android.view.View) bindings[6];
        this.etPlayername = (android.widget.EditText) bindings[3];
        this.imgSave = (android.widget.ImageView) bindings[4];
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.recyclerview = (android.support.v7.widget.RecyclerView) bindings[7];
        this.txtPlayers = (android.widget.TextView) bindings[5];
        this.txtScoreboard = (android.widget.TextView) bindings[1];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityScorecardBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityScorecardBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityScorecardBinding>inflate(inflater, com.nisum.reactivescorecard.R.layout.activity_scorecard, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityScorecardBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityScorecardBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.nisum.reactivescorecard.R.layout.activity_scorecard, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityScorecardBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityScorecardBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_scorecard_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityScorecardBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}