package net.osmand.plus.plugins.weather;

import static net.osmand.plus.views.mapwidgets.WidgetType.WEATHER_PRECIPITATION_WIDGET;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.osmand.core.jni.WeatherBand;
import net.osmand.plus.activities.MapActivity;
import net.osmand.util.Algorithms;

public class PrecipitationWidget extends WeatherWidget {

	public PrecipitationWidget(@NonNull MapActivity mapActivity, @NonNull WeatherPlugin weatherPlugin) {
		super(mapActivity, weatherPlugin, WEATHER_PRECIPITATION_WIDGET, (short) WeatherBand.Precipitation.swigValue());
	}

	@Override
	public void onValueObtained(boolean succeeded, double value, @Nullable String formattedValue) {
		getMyApplication().runInUIThread(() -> {
			if (succeeded && !Algorithms.isEmpty(formattedValue)) {
				setText(formattedValue, "mm");
			} else {
				setText(null, null);
			}
		});
	}
}
