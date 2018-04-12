package com.tracker.db;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tracker.model.TrackerDevice;

public class DBApplication {

	
	public static int addTrackerToDB(TrackerDevice objTracker) {
		int retval = 0;
		DBDataAccessObject dbDao = new DBDataAccessObject();
		try {
			retval = dbDao.addTrackerToDB(objTracker);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retval;
	}
	
	public static ArrayList<TrackerDevice> getAllCycleData(){

		ArrayList<TrackerDevice>arrOfCycleLocations = new ArrayList<TrackerDevice>();
		DBDataAccessObject objDBAccess = new DBDataAccessObject();
		try {
			arrOfCycleLocations = objDBAccess.getAllTrackerData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrOfCycleLocations;
	}
}
