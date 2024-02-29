package com.Accio;

import com.Accio.DatabaseConnection;
import com.Accio.SearchResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Search")
public class Search extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Getting keyword from frontend
        String keyword = request.getParameter("keyword");
        //building connection to database
        String query = "SELECT pageTitle, pageLink, " +
                "(LENGTH(LOWER(pageText)) - LENGTH(REPLACE(LOWER(pageText), ?, ''))) / LENGTH(?) AS countoccurrence " +
                "FROM searchengine.pages " +
                "ORDER BY countoccurrence DESC " +
                "LIMIT 30";
        Connection connection = DatabaseConnection.getConnection();

            //Store the keyword entered by user
            try (PreparedStatement preparedStatement = connection.prepareStatement("insert into history values(?, ?);")) {
                preparedStatement.setString(1, keyword);
                preparedStatement.setString(2, "http://localhost:8080/SearchEngine/Search?keyword=" + keyword);
                preparedStatement.executeUpdate();


                // results after running the ranking query
                ResultSet resultSet = connection.createStatement().executeQuery(query);
                ArrayList<SearchResult> results = new ArrayList<>();
                //transferring results from resultset to results arraylist
                while (resultSet.next()) {
                    SearchResult searchresult = new SearchResult();
                    searchresult.setTitle(resultSet.getString("pageTitle"));
                    searchresult.setLink(resultSet.getString(("pageLink")));
                    results.add(searchresult);
                }
                //printing the results in console
                for (SearchResult result : results) {
                    System.out.println(result.getTitle() + "/n" + result.getLink() + "/n");
                }

                // requesting objects to jsp file

                request.setAttribute("results", results);
                request.getRequestDispatcher("Search.jsp").forward(request, response);

                response.setContentType("text/html");
                PrintWriter out = response.getWriter();


            } catch (SQLException | ServletException e) {
                // Consider logging the exception details
                e.printStackTrace();
            }


        }
    }