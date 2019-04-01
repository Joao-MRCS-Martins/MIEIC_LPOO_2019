package com.aor.refactoring.example6;

public class Location {
    private final String locationLatitude;
    private final String locationLongitude;
    private final String locationName;

    public Location(String locationLatitude, String locationLongitude, String locationName) {
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.locationName = locationName;
    }

    public String getLatitude() {
        return locationLatitude;
    }

    public String getLongitude() {
        return locationLongitude;
    }

    public String getName() {
        return locationName;
    }
}
