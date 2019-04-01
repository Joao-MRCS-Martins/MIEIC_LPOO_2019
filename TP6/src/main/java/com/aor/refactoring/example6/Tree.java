package com.aor.refactoring.example6;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Tree {
    public Date plantedAt;

    private Location location;

    private List<Date> appraisalDates;

    public Tree(Date plantedAt, Location location){
        this.plantedAt = plantedAt;
        this.location = location;
        this.appraisalDates = new ArrayList<>();
    }
    public String toString() {
        return "Tree planted at " + this.plantedAt.toString() + " in location " + this.location.getLatitude() + "," + this.location.getLongitude() + " (" + this.location.getName() + ")";
    }

    void addAppraisal(Date appraisalDate) {
        this.appraisalDates.add(appraisalDate);
    }

    public List<Date> getAppraisals(){
        return this.appraisalDates;
    }

    public boolean isNextAppraisalOverdue(){
        Date latestAppraisalDate = getLatestAppraisalDate(new Date());
        Calendar calendar = calculateNextAppraisalDate(latestAppraisalDate);
        return calendar.getTime().before(new Date());
    }

    private Calendar calculateNextAppraisalDate(Date latestAppraisalDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(latestAppraisalDate);
        calendar.add(Calendar.MONTH, 3);

        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 2);
        return calendar;
    }

    private Date getLatestAppraisalDate(Date today) {
        Date latestAppraisalDate = today;

        if (this.appraisalDates.size() > 0) {
            latestAppraisalDate = this.appraisalDates.get(0);
        }
        for(Date appraisalDate : this.appraisalDates) {
            if (latestAppraisalDate.before(appraisalDate)) {
                latestAppraisalDate = appraisalDate;
            }
        }
        return latestAppraisalDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(String locationLatitude, String locationLongitude, String locationName) {
        this.location = new Location(locationLatitude, locationLongitude, locationName);
    }
}
