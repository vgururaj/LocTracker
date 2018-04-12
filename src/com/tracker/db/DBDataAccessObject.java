package com.tracker.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;

import com.tracker.model.TrackerDevice;

public class DBDataAccessObject {

	private Connection connection;
	private Statement statement;

	public DBDataAccessObject() {
	}

	public void createDatabase(String dbName) throws DBApplicationException {
		String query = "CREATE DATABASE IF NOT EXISTS " + dbName;
		try {
			connection = DBConnection.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
			SQLWarning warning = statement.getWarnings();
			if (warning != null)
				throw new DBApplicationException(warning.getMessage());
		} catch (SQLException e) {
			DBApplicationException exception = new DBApplicationException(
					e.getMessage(), e);
			throw exception;
		} finally {
			DBUtils.close(statement);
			DBUtils.close(connection);
		}
	}

	public int addTrackerToDB(TrackerDevice objTracker)  throws SQLException{
		int output=0;
		String query = "INSERT INTO trackerData (TrackerID, Timestamp, Latitude, Longtitude) VALUES ('" 
				+ objTracker.getDeviceID() + "','" 
				+ objTracker.getTimestamp() + "','"
				+ objTracker.getLatitude()+ "','"
				+ objTracker.getLongtitude() + "')";

		System.out.println("SQL Query: " + query);
		ResultSet rs = null;
		try {
			connection = DBConnection.getConnection();
			statement = connection.createStatement();
			output = statement.executeUpdate(query);
			System.out.println("Output is: " + output);
			if(output >= 1){
				System.out.println("Success");
			}
		} finally {
			DBUtils.close(rs);
			DBUtils.close(statement);
			DBUtils.close(connection);
		}
		return output;
	}

	public ArrayList<TrackerDevice> getAllTrackerData()  throws SQLException{
		String query = "SELECT * FROM trackerData";
		ResultSet rs = null;
		TrackerDevice device = null;
		ArrayList<TrackerDevice> arrOfDataForDevice = new ArrayList<TrackerDevice>();
		try {
			connection = DBConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()) {
				device = new TrackerDevice();
				device.setDeviceID(rs.getString("TrackerID"));
				device.setTimestamp(rs.getString("Timestamp"));
				device.setLatitude(rs.getString("Latitude"));
				device.setLongtitude(rs.getString("Longtitude"));

				arrOfDataForDevice.add(device);
			}
		} finally {
			DBUtils.close(rs);
			DBUtils.close(statement);
			DBUtils.close(connection);
		}
		return arrOfDataForDevice;
	}
	
	public ArrayList<TrackerDevice> getTracker(String trackerID) throws SQLException {
		String query = "SELECT * FROM trackerData WHERE TrackerID = '" + trackerID + "'";
		ResultSet rs = null;
		TrackerDevice tracker = null;
		ArrayList<TrackerDevice> arrOfDataForCycle = new ArrayList<TrackerDevice>();
		try {
			connection = DBConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()) {
				tracker = new TrackerDevice();
				tracker.setDeviceID(rs.getString("TrackerID"));
				tracker.setTimestamp(rs.getString("Timestamp"));
				tracker.setLatitude(rs.getString("Latitude"));
				tracker.setLongtitude(rs.getString("Longtitude"));

				arrOfDataForCycle.add(tracker);
			}
		} finally {
			DBUtils.close(rs);
			DBUtils.close(statement);
			DBUtils.close(connection);
		}
		return arrOfDataForCycle;
	}

}
