import * as React from 'react';

import { ExpoFloatingWidgetViewProps } from './ExpoFloatingWidget.types';

export default function ExpoFloatingWidgetView(props: ExpoFloatingWidgetViewProps) {
  return (
    <div>
      <iframe
        style={{ flex: 1 }}
        src={props.url}
        onLoad={() => props.onLoad({ nativeEvent: { url: props.url } })}
      />
    </div>
  );
}
