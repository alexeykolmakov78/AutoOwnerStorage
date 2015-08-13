package it.source.servlet;

import it.source.buisiness.dao.OffenceDAO;
import it.source.buisiness.model.Offence;
import it.source.buisiness.beans.OffenceBean;

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
public class OffenceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Offence> offences = loadData();
        List<OffenceBean> offenceBeans = convertData(offences);
        List<String> ocolls = new ArrayList<>(Arrays.asList("id", "date", "type"));

        session.setAttribute("orows", offenceBeans);
        session.setAttribute("ocolls", ocolls);
        response.sendRedirect("/auto/offence.jsp");
    }

    private List<OffenceBean> convertData(List<Offence> vehicles) {
        return vehicles.stream()
                .map(OffenceBean::new).collect(Collectors.toList());
    }

    private List<Offence> loadData() {
        List<Offence> result = new ArrayList<>();
        try {
            result = new OffenceDAO().getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
