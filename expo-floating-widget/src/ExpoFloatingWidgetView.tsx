import { requireNativeView } from 'expo';
import * as React from 'react';

import { ExpoFloatingWidgetViewProps } from './ExpoFloatingWidget.types';

const NativeView: React.ComponentType<ExpoFloatingWidgetViewProps> =
  requireNativeView('ExpoFloatingWidget');

export default function ExpoFloatingWidgetView(props: ExpoFloatingWidgetViewProps) {
  return <NativeView {...props} />;
}
