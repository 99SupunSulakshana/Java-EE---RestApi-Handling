package com.restful.projects.ABCHospitalProject_BusinessTier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import pkg.sample.GetPrices;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserServlet() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> listItemName = new ArrayList<String>();
		List<Integer> listItemqty = new ArrayList<Integer>();
		List<Double> listItemamt = new ArrayList<Double>();
		double totalbill = 0;
		
		String chkboxsoap = request.getParameter("chboxsoap");
		String chkboxchoc = request.getParameter("chboxchoc");
		String chkboxchips = request.getParameter("chboxchips");
		String chkboxshampoo = request.getParameter("chboxShampoo");
		String chkboxMilkpwder = request.getParameter("chboxmilkpwdr");
		
		String txtsoapqty = request.getParameter("txtsoapqty");
		String txtchocqty = request.getParameter("txtChocqty");
		String txtchipsqty = request.getParameter("txtChipsqty");
		String txtshampooqty = request.getParameter("txtShampooqty");
		String txtMilkpwderqty = request.getParameter("txtMilkpwdrqty");
		
		
		
		GetPrices prices = new GetPrices();//Access the GetPrices Class in the servelet..............
		
		if(chkboxsoap != null)
		{
			int qty = Integer.valueOf(txtsoapqty);
			double price = prices.getSoapPrice();
			double totalamt = price*qty;
			totalbill = totalbill + totalamt;
			
			
			listItemName.add("soap");
			listItemqty.add(qty);
			listItemamt.add(totalamt);
			
		}
		
		if(chkboxchoc != null)
		{
			int qty = Integer.valueOf(txtchocqty);
			double price = prices.getChocPrice();
			double totalamt = price*qty;
			totalbill = totalbill + totalamt;
			
			listItemName.add("chocolate");
			listItemqty.add(qty);
			listItemamt.add(totalamt);
		}
		
		if(chkboxchips != null)
		{
			int qty = Integer.valueOf(txtchipsqty);
			double price = prices.getChipsPrice();
			double totalamt = price*qty;
			totalbill = totalbill + totalamt;
			
			listItemName.add("chips");
			listItemqty.add(qty);
			listItemamt.add(totalamt);
		}
		
		if(chkboxshampoo != null)
		{
			int qty = Integer.valueOf(txtshampooqty);
			double price = prices.getShampooPrice();
			double totalamt = price*qty;
			totalbill = totalbill + totalamt;
			
			listItemName.add("shampoo");
			listItemqty.add(qty);
			listItemamt.add(totalamt);
		}
		
		if(chkboxMilkpwder != null)
		{
			int qty = Integer.valueOf(txtMilkpwderqty);
			double price = prices.getMilkPrice();
			double totalamt = price*qty;
			totalbill = totalbill + totalamt;
			
			listItemName.add("milk powder");
			listItemqty.add(qty);
			listItemamt.add(totalamt);
		}

		HttpSession session = (HttpSession) request.getSession();
		session.setAttribute("ItemName", listItemName);
		session.setAttribute("ItemQty", listItemqty);
		session.setAttribute("ItemTotalAmt",listItemamt);
		session.setAttribute("TotalAmount", totalbill);
		
		response.sendRedirect("Users.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
