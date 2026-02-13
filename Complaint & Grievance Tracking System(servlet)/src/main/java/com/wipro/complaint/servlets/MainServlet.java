package com.wipro.complaint.servlets;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.wipro.complaint.bean.ComplaintBean;
import com.wipro.complaint.service.Administrator;
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String operation = request.getParameter("operation");
        if (operation == null) {
            response.sendRedirect("error.html");
            return;
        }
        if (operation.equals("newRecord")) {
            String result = addComplaint(request);
            if (result == null
                    || result.equals("INVALID INPUT")
                    || result.equals("ALREADY EXISTS")
                    || result.equals("FAIL")
                    || result.contains("INVALID")) {
                response.sendRedirect("error.html");
            } 
            else {
                response.sendRedirect("success.html");
            }
        }
        else if (operation.equals("viewRecord")) {
            ComplaintBean bean = viewComplaint(request);
            if (bean == null) {
                request.setAttribute("message",
                        "No matching records exists! Please try again!");
            } 
            else {
                request.setAttribute("complaint", bean);
            }
            RequestDispatcher rd =
                    request.getRequestDispatcher("displayComplaint.jsp");
            rd.forward(request, response);
        }
        else if (operation.equals("viewAllRecords")) {
            List<ComplaintBean> list = viewAllComplaints();
            if (list == null || list.isEmpty()) {
                request.setAttribute("message", "No records available!");
            } 
            else {
                request.setAttribute("complaintList", list);
            }
            RequestDispatcher rd =
                    request.getRequestDispatcher("displayAllComplaints.jsp");
            rd.forward(request, response);
        }
    }
    public String addComplaint(HttpServletRequest request) {
        try {
            String complainant = request.getParameter("complainant");
            String title = request.getParameter("title");
            String department = request.getParameter("department");
            String dateStr = request.getParameter("complaintDate");
            String remarks = request.getParameter("remarks");
            if (complainant == null || complainant.trim().length() < 2 ||
                title == null || title.trim().length() < 2 ||
                department == null || department.trim().length() < 2 ||
                dateStr == null || dateStr.isEmpty()) {
                return "INVALID INPUT";
            }
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            ComplaintBean bean = new ComplaintBean();
            bean.setComplainant(complainant.trim());
            bean.setTitle(title.trim());
            bean.setDepartment(department.trim());
            bean.setComplaintDate(date);
            bean.setRemarks(remarks);
            Administrator admin = new Administrator();
            return admin.addRecord(bean);
        } 
        catch (Exception e) {
            e.printStackTrace();
            return "FAIL";
        }
    }
    public ComplaintBean viewComplaint(HttpServletRequest request) {
        try {
            String title = request.getParameter("title");
            String dateStr = request.getParameter("complaintDate");
            if (title == null || dateStr == null)
                return null;
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            Administrator admin = new Administrator();
            return admin.viewRecord(title, date);
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<ComplaintBean> viewAllComplaints() {
        Administrator admin = new Administrator();
        return admin.viewAllRecords();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
