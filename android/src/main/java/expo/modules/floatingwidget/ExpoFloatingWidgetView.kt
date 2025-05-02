package expo.modules.floatingwidget

import android.content.Context
import android.graphics.PixelFormat
import android.os.Build
import android.view.Gravity
import android.view.View
import android.view.WindowManager

object FloatingWindowManager {
  private var floatingView: View? = null
  private var windowManager: WindowManager? = null

  fun show(context: Context, view: View) {
    if (floatingView != null) return

    val params = WindowManager.LayoutParams(
      WindowManager.LayoutParams.WRAP_CONTENT,
      WindowManager.LayoutParams.WRAP_CONTENT,
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
      else
        WindowManager.LayoutParams.TYPE_PHONE,
      WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
      PixelFormat.TRANSLUCENT
    )
    params.gravity = Gravity.TOP or Gravity.START
    params.x = 100
    params.y = 300

    windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    windowManager?.addView(view, params)
    floatingView = view
  }

  fun hide(context: Context) {
    floatingView?.let {
      windowManager?.removeView(it)
      floatingView = null
    }
  }
}
