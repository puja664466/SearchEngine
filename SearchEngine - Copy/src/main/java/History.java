package com.Accio;

import com.Accio.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/History")
public class History extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try{
            Connection connection = DatabaseConnection.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("Select * from searchengine.history");
            ArrayList<com.Accio.HistoryResult> results = new ArrayList<com.Accio.HistoryResult>();
            while(resultSet.next()){
                com.Accio.HistoryResult historyResult = new com.Accio.HistoryResult();
                historyResult.setKeyword(resultSet.getString("keyword"));
                historyResult.setLink(resultSet.getString("link"));
                results.add(historyResult);
            }
            request.setAttribute("results", results);
            request.getRequestDispatcher("/history.jsp").forward(request, response);
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        catch (ServletException servletException){
            servletException.printStackTrace();
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }

    }
}