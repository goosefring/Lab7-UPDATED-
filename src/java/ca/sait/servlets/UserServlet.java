/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ca.sait.servlets;

import ca.sait.services.UserService;
import java.util.List;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ca.sait.models.UserdbUser;
import ca.sait.models.UserdbRole;

/**
 *
 * @author Rehan Bhatti
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService us = new UserService();

        try {
            List<UserdbUser> users = us.getAll();

            request.setAttribute("users", users);
        } catch (Exception e) {
            request.setAttribute("message", "No users found");
        }

        String action = request.getParameter("action");

        String email = request.getParameter("email");

        try {
            switch (action) {
                case "edit":
                    UserdbUser user = us.get(email);
                    request.setAttribute("editUser", user);
                    break;
                case "delete":
                    us.delete(email);
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            if (action != null) {
                request.setAttribute("message", "Could not perform action");
            }
        }

        try {
            List<UserdbUser> users = us.getAll();

            request.setAttribute("users", users);
        } catch (Exception e) {
            request.setAttribute("message", "No users found");
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        String email = request.getParameter("email");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String password = request.getParameter("password");
        int roleID = Integer.parseInt(request.getParameter("role"));
        boolean active = false;
        UserdbRole role = null;

        UserService us = new UserService();

        switch (roleID) {
            case 1:
                role = new UserdbRole(1, "System Admin");
                break;
            case 2:
                role = new UserdbRole(2, "Regular User");
                break;
            case 3:
                role = new UserdbRole(3, "Company Admin");
                break;
            default:
                role = new UserdbRole(2, "Regular User");
        }

        try {
            switch (action) {
                case "add":

                    boolean inserted = us.insert(email, active, firstName, lastName, password, role);

                    if (inserted) {
                        request.setAttribute("message", "Added user");
                    } else {
                        request.setAttribute("message", "Encountered error while creating user");
                    }
                    break;

                case "update":

                    boolean updated = us.update(email, active, firstName, lastName, password, role);

                    if (updated) {
                        request.setAttribute("message", "User successfully updated.");
                    } else {
                        request.setAttribute("message", "Encountered error while updating user.");
                    }
                    break;

                default:
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

//                switch (action) {
//                    case "add":
//                        us.create(email, firstName, lastName, password, role);
//                        break;
//                    case "update":
//                {
//                    try {
//                        us.update(email, active, firstName, lastName, password, role);
//                    } catch (Exception ex) {
//                        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                        break;
//
//                    default:
//                        break;
//                }
        try {
            List<UserdbUser> users = us.getAll();

            request.setAttribute("users", users);
        } catch (Exception e) {
            request.setAttribute("message", "No users found");
        }

//        try {
//            switch (action) {
//                case "add":
//                    us.insert(email, active, firstname, lastname, password, role);
//                    break;
//                case "update":
//                    us.update(email, active, firstname, lastname, password, role);
//                    break;
//                default:
//                    break;
//            }
//
//        } catch (Exception e) {
//            request.setAttribute("message", "Could not perform action");
//        }
//        
        this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

}
