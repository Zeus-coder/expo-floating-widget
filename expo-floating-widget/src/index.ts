// Reexport the native module. On web, it will be resolved to ExpoFloatingWidgetModule.web.ts
// and on native platforms to ExpoFloatingWidgetModule.ts
export { default } from './ExpoFloatingWidgetModule';
export { default as ExpoFloatingWidgetView } from './ExpoFloatingWidgetView';
export * from  './ExpoFloatingWidget.types';
