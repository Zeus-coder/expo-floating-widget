package expo.modules.floatingwidget

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

class ExpoFloatingWidgetModule : Module() {
  override fun definition() = ModuleDefinition {
    Name("FloatingWidget")

    Function("canDrawOverlays") {
      val context = appContext.reactContext ?: return@Function false
      Settings.canDrawOverlays(context)
    }

    Function("requestOverlayPermission") {
      val context = appContext.reactContext ?: return@Function
      val intent = Intent(
        Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
        Uri.parse("package:" + context.packageName)
      )
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
      context.startActivity(intent)
    }

    Function("show") {
      val context = appContext.reactContext ?: return@Function
      val view = ExpoFloatingWidgetView(context, appContext)
      FloatingWindowManager.show(context, view)
    }

    Function("hide") {
      val context = appContext.reactContext ?: return@Function
      FloatingWindowManager.hide(context)
    }
  }
}
