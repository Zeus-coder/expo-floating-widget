// Reexport the native module. On web, it will be resolved to ExpoFloatingWidgetModule.web.ts
// and on native platforms to ExpoFloatingWidgetModule.ts
export { default } from './ExpoFloatingWidgetModule';
export { default as ExpoFloatingWidgetView } from './ExpoFloatingWidgetView';
export * from  './ExpoFloatingWidget.types';

import  FloatingWidgetModule from './ExpoFloatingWidgetModule';

export async function canDrawOverlays(): Promise<boolean> {
  return await FloatingWidgetModule.canDrawOverlays();
}

export function requestOverlayPermission() {
  FloatingWidgetModule.requestOverlayPermission();
}

export function showFloatingWidget() {
  FloatingWidgetModule.show();
}

export function hideFloatingWidget() {
  FloatingWidgetModule.hide();
}