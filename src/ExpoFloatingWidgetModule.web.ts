import { registerWebModule, NativeModule } from 'expo';

import { ExpoFloatingWidgetModuleEvents } from './ExpoFloatingWidget.types';

class ExpoFloatingWidgetModule extends NativeModule<ExpoFloatingWidgetModuleEvents> {
  PI = Math.PI;
  async setValueAsync(value: string): Promise<void> {
    this.emit('onChange', { value });
  }
  hello() {
    return 'Hello world! 👋';
  }
}

export default registerWebModule(ExpoFloatingWidgetModule, 'ExpoFloatingWidgetModule');
