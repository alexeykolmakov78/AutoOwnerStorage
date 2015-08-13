package it.source.servlet;

import it.source.buisiness.dao.RTADAO;
import it.source.buisiness.model.RTA;
import it.source.buisiness.beans.RTABean;

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
public class RTAServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<RTA> rtaList = loadData();
        List<RTABean> rtaBeans = convertData(rtaList);
        List<String> rcolls = new ArrayList<>(Arrays.asList("id","date","code"));

        session.setAttribute("rrows", rtaBeans);
        session.setAttribute("rcolls", rcolls);
        response.sendRedirect("/auto/rta.jsp");
    }

    private List<RTABean> convertData(List<RTA> vehicles) {
        return vehicles.stream()
                .map(RTABean::new).collect(Collectors.toList());
    }

    private List<RTA> loadData() {
        List<RTA> result = new ArrayList<>();
        try {
            result = new RTADAO().getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
