package co.edu.uco.nose.crosscuting.helper;

import java.util.UUID;

public final class ObjectHelper {
	
	private ObjectHelper() {
	}
	
	public static <O> boolean isNull(final O object) {
		return object == null;
	}
	
	public static <O> O getDefault(final O object, final O defaultValue) {
		return isNull(object) ? defaultValue : object;
	}

	public static UUID getDefault(UUID value, UUID default1) {
		// TODO Auto-generated method stub
		return null;
	}
}
