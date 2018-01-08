package com.drzigman.LockScreenControl;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import android.os.PowerManager;

public class LockScreenControlManager extends ReactContextBaseJavaModule {
    private ReactApplicationContext _context;
    private PowerManager _powerManager;
    private PowerManager.WakeLock _wakeLock;
    private Boolean _locksHeld = false;

    public LockScreenControlManager(ReactApplicationContext context ) {
        super( context );
        this._context = context;

        this._powerManager = (PowerManager)this._context.getSystemService( ReactApplicationContext.POWER_SERVICE );
        this._wakeLock     = this._powerManager.newWakeLock(
            PowerManager.SCREEN_DIM_WAKE_LOCK | PowerManager.ON_AFTER_RELEASE,
            "LockScreenControl"
        );
    }

    @Override
    public String getName() {
        return "LockScreenControl";
    }

    @ReactMethod
    public void preventLock() {
        this._wakeLock.acquire();
        this._locksHeld = true;
    }

    @ReactMethod
    public void allowLock() {
        this._wakeLock.release();
        this._locksHeld = false;
    }
}
