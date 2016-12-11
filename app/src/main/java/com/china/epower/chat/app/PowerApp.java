package com.china.epower.chat.app;

import android.app.Application;
import android.content.Intent;
import android.support.multidex.MultiDex;
import com.china.epower.chat.service.XmppService;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.pgyersdk.crash.PgyCrashManager;
import com.squareup.leakcanary.LeakCanary;
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.XMPPConnection;
import tech.jiangtao.support.kit.init.SupportIM;
import work.wanghao.simplehud.SimpleHUD;

/**
 * Class: PowerApp </br>
 * Description: whole application  </br>
 * Creator: kevin </br>
 * Email: jiangtao103cp@gmail.com </br>
 * Date: 10/11/2016 1:06 AM</br>
 * Update: 10/11/2016 1:06 AM </br>
 **/

public class PowerApp extends Application {

  private static XMPPConnection mXmppConnect;
  private static final String TAG = PowerApp.class.getSimpleName();
  @Override public void onCreate() {
    super.onCreate();
    LeakCanary.install(this);
    Fresco.initialize(this);
    MultiDex.install(this);
    PgyCrashManager.register(this);
    SimpleHUD.backgroundHexColor="#FF4081";
    SupportIM.initialize(this,"desktop-9o1rifc","desktop-9o1rifc","139.162.73.105",5222);
    startXMPPService();
  }

  private void startXMPPService() {
    Intent intent = new Intent(this, XmppService.class);
    startService(intent);
  }

  @Override public void onTerminate() {
    super.onTerminate();
  }

  public static XMPPConnection getmXmppConnect(){
    if (mXmppConnect==null){
      throw  new NullPointerException("AbstractXMPPConnection can not be null");
    }
    return mXmppConnect;
  }

  public static void setmXmppConnect(XMPPConnection connect){
    mXmppConnect = connect;
  }
}