package tech.jiangtao.support.ui.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import tech.jiangtao.support.ui.view.AudioManager;
import tech.jiangtao.support.ui.view.MediaManager;
import xiaofei.library.hermeseventbus.HermesEventBus;

/**
 * Class: BaseFragment </br>
 * Description: Fragment抽象基类 </br>
 * Creator: kevin </br>
 * Email: jiangtao103cp@gmail.com </br>
 * Date: 04/12/2016 2:46 AM</br>
 * Update: 04/12/2016 2:46 AM </br>
 **/

public abstract class BaseFragment extends Fragment {

  private View mLayoutView;

  @Override public void onStart() {
    super.onStart();
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(layout(), container, false);
    mLayoutView = view;
    ButterKnife.bind(this, view);
    return view;
  }

  public abstract @LayoutRes int layout();

  @Override public void onStop() {
    super.onStop();
  }

  @Override public void onDestroy() {
    super.onDestroy();
    AudioManager.getInstance().release();
    MediaManager.release();
    HermesEventBus.getDefault().destroy();
  }

  @Override public void onResume() {
    super.onResume();
    MediaManager.resume();
  }

  @Override public void onPause() {
    super.onPause();
    AudioManager.getInstance().release();
    MediaManager.pause();
  }

  public View getView() {
    return mLayoutView;
  }
}
