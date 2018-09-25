package com.nisum.reactivescorecard.databinding;
import com.nisum.reactivescorecard.R;
import com.nisum.reactivescorecard.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class RowBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.img_down, 3);
        sViewsWithIds.put(R.id.img_up, 4);
        sViewsWithIds.put(R.id.img_delete, 5);
    }
    // views
    @NonNull
    public final android.widget.ImageView imgDelete;
    @NonNull
    public final android.widget.ImageView imgDown;
    @NonNull
    public final android.widget.ImageView imgUp;
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    public final android.widget.TextView txtPlayername;
    @NonNull
    public final android.widget.TextView txtScore;
    // variables
    @Nullable
    private com.nisum.reactivescorecard.persistance.dto.Player mPlayer;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public RowBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds);
        this.imgDelete = (android.widget.ImageView) bindings[5];
        this.imgDown = (android.widget.ImageView) bindings[3];
        this.imgUp = (android.widget.ImageView) bindings[4];
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.txtPlayername = (android.widget.TextView) bindings[1];
        this.txtPlayername.setTag(null);
        this.txtScore = (android.widget.TextView) bindings[2];
        this.txtScore.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.player == variableId) {
            setPlayer((com.nisum.reactivescorecard.persistance.dto.Player) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPlayer(@Nullable com.nisum.reactivescorecard.persistance.dto.Player Player) {
        this.mPlayer = Player;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.player);
        super.requestRebind();
    }
    @Nullable
    public com.nisum.reactivescorecard.persistance.dto.Player getPlayer() {
        return mPlayer;
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
        java.lang.String stringValueOfPlayerScore = null;
        java.lang.String playerName = null;
        int playerScore = 0;
        com.nisum.reactivescorecard.persistance.dto.Player player = mPlayer;

        if ((dirtyFlags & 0x3L) != 0) {



                if (player != null) {
                    // read player.name
                    playerName = player.getName();
                    // read player.score
                    playerScore = player.getScore();
                }


                // read String.valueOf(player.score)
                stringValueOfPlayerScore = java.lang.String.valueOf(playerScore);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtPlayername, playerName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtScore, stringValueOfPlayerScore);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static RowBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static RowBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<RowBinding>inflate(inflater, com.nisum.reactivescorecard.R.layout.row, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static RowBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static RowBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.nisum.reactivescorecard.R.layout.row, null, false), bindingComponent);
    }
    @NonNull
    public static RowBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static RowBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/row_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new RowBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): player
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}