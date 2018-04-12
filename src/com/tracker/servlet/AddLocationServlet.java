package com.tracker.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracker.db.DBApplication;
import com.tracker.model.TrackerDevice;

/**
 * Servlet implementation class AddLocationServlet
 */
@WebServlet(description = "Add Location", urlPatterns = { "/AddLocationServlet" })
public class AddLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLocationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrackerDevice tracker = new TrackerDevice();
		
		tracker.setDeviceID(request.getParameter("TrackerID"));
		tracker.setTimestamp(request.getParameter("Date"));
		tracker.setLatitude(request.getParameter("Latitude"));
		tracker.setLongtitude(request.getParameter("Longtitude"));
//		PrintWriter out = response.getWriter();
//		   out.println("Hello World");
//		   out.flush();

		//DBApplication.addCycleToDB(objCycleToAdd);
	//	addCycleToDB(objCycleToAdd);
		int nInsertSuccess = DBApplication.addTrackerToDB(tracker);
		
		if (nInsertSuccess == 0){
			request.setAttribute("bWasInserted", "false");
		} else {
			request.setAttribute("bWasInserted", "true");

		}
	
		response.sendRedirect("MyTracker.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); 
	}

}
