package net.osmand.plus.track;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

import net.osmand.plus.R;

public enum Gpx3DVisualizationType {

	NONE("none", R.string.shared_string_none),
	ALTITUDE("altitude", R.string.altitude),
	FIXED_HEIGHT("fixed_height", R.string.fixed_height);

	private final String typeName;
	private final int displayNameResId;

	Gpx3DVisualizationType(@NonNull String type, @StringRes int displayNameResId) {
		this.typeName = type;
		this.displayNameResId = displayNameResId;
	}

	@NonNull
	public static Gpx3DVisualizationType get3DVisualizationType(@Nullable String typeName) {
		for (Gpx3DVisualizationType type : values()) {
			if (type.name().equalsIgnoreCase(typeName)) {
				return type;
			}
		}
		return NONE;
	}

	public String getTypeName() {
		return typeName;
	}

	@StringRes
	public int getDisplayNameResId() {
		return displayNameResId;
	}
}