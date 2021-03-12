package com.ltts.ServletProject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltts.ServletProject.Dao.AuctionDao;
import com.ltts.ServletProject.Dao.TeamDao;
import com.ltts.ServletProject.model.Auction;
import com.ltts.ServletProject.model.Team;

/**
 * Servlet implementation class InsertAuctionServlet
 */
@WebServlet("/InsertAuctionServlet")
public class InsertAuctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAuctionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		int Auctionid=Integer.parseInt(request.getParameter("Auctionid"));
		int Playerid=Integer.parseInt(request.getParameter("Playerid"));
		int Teamid=Integer.parseInt(request.getParameter("Teamid"));
		int year=Integer.parseInt(request.getParameter("year"));
		int amount=Integer.parseInt(request.getParameter("amount"));
		
		Auction a = new Auction(Auctionid,Playerid,Teamid,year,amount);
		
		System.out.println("Inside Auction Servlet: "+a);
		AuctionDao ad=new AuctionDao();
		boolean b=false;
		try {
			b=ad.insertAuction(a); // Control TRanfers to Dao file
			System.out.println("Successfully Inserted...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
