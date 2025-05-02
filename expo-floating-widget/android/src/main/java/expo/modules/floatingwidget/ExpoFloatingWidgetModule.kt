package expo.modules.floatingwidget

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import expo.modules.kotlin.views.ViewManagers

class ExpoFloatingWidgetModule : Module() {
  override fun definition() = ModuleDefinition {
    Name("FloatingWidget")

    // Function to check if overlay permission is granted
    Function("canDrawOverlays") {
      val context = appContext.reactContext ?: return@Function false
      Settings.canDrawOverlays(context)  // This returns a boolean
    }

    // Function to request overlay permission
    Function("requestOverlayPermission") {
      val context = appContext.reactContext ?: return@Function
      val intent = Intent(
        Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
        Uri.parse("package:" + context.packageName)
      )
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
      context.startActivity(intent)
    }

    // Function to show the floating view
    Function("show") {
      val context = appContext.reactContext ?: return@Function
      val view = ExpoFloatingWidgetView(context, appContext)
      FloatingWindowManager.show(context, view)
      return@Function Unit  // Explicitly return Unit (Void in JS)
    }

    // Function to hide the floating view
    Function("hide") {
      val context = appContext.reactContext ?: return@Function
      FloatingWindowManager.hide(context)
      return@Function Unit  // Explicitly return Unit (Void in JS)
    }
  }
}
