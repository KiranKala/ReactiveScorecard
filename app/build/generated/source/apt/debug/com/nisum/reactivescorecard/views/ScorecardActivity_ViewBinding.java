// Generated code from Butter Knife. Do not modify!
package com.nisum.reactivescorecard.views;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.nisum.reactivescorecard.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ScorecardActivity_ViewBinding implements Unbinder {
  private ScorecardActivity target;

  @UiThread
  public ScorecardActivity_ViewBinding(ScorecardActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ScorecardActivity_ViewBinding(ScorecardActivity target, View source) {
    this.target = target;

    target.etPlayerName = Utils.findRequiredViewAsType(source, R.id.et_playername, "field 'etPlayerName'", EditText.class);
    target.imgSave = Utils.findRequiredViewAsType(source, R.id.img_save, "field 'imgSave'", ImageView.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ScorecardActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etPlayerName = null;
    target.imgSave = null;
    target.recyclerView = null;
  }
}
