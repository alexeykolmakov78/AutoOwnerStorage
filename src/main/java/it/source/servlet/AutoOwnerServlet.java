package it.source.servlet;

import it.source.buisiness.dao.AutoOwnerDAO;
import it.source.buisiness.model.AutoOwner;
import it.source.buisiness.beans.AutoOwnerBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kolmakov Alexey on 07.08.2015.
 */
public class AutoOwnerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<AutoOwner> autoOwners = loadData();
        List<AutoOwnerBean> autoOwnerBeans = convertData(autoOwners);
        List<String> columns = columnNames();

        session.setAttribute("arows", autoOwnerBeans);
        session.setAttribute("acolls", columns);
        response.sendRedirect("/auto/autoowner.jsp");
    }

    private List<AutoOwnerBean> convertData(List<AutoOwner> vehicles) {
        return vehicles.stream()
                .map(AutoOwnerBean::new).collect(Collectors.toList());
    }

    private List<AutoOwner> loadData() {
        List<AutoOwner> result = new ArrayList<>();
        try {
            result = new AutoOwnerDAO().getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<String> columnNames() {
        return new ArrayList<>(Arrays.asList("id", "address", "passport", "licence",
                "vehicles", "offences"));
    }

}

