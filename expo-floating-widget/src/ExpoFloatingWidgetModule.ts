import { NativeModule, requireNativeModule } from 'expo';

import { ExpoFloatingWidgetModuleEvents } from './ExpoFloatingWidget.types';

declare class ExpoFloatingWidgetModule extends NativeModule<ExpoFloatingWidgetModuleEvents> {
  PI: number;
  hello(): string;
  setValueAsync(value: string): Promise<void>;
}

// This call loads the native module object from the JSI.
export default requireNativeModule<ExpoFloatingWidgetModule>('ExpoFloatingWidget');
