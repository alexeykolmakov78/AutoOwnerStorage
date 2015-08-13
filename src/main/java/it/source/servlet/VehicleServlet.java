package it.source.servlet;

import it.source.buisiness.dao.VehicleDAO;
import it.source.buisiness.model.Vehicle;
import it.source.buisiness.beans.VehicleBean;

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
public class VehicleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Vehicle> vehicles = loadData();
        List<VehicleBean> vehicleBeans = convertData(vehicles);
        List<String> columns = columnNames();

        session.setAttribute("vrows", vehicleBeans);
        session.setAttribute("vcolls", columns);
        response.sendRedirect("/auto/vehicle.jsp");
    }

    private List<VehicleBean> convertData(List<Vehicle> vehicles) {
        return vehicles.stream()
                .map(VehicleBean::new).collect(Collectors.toList());
    }

    private List<Vehicle> loadData() {
        List<Vehicle> result = new ArrayList<>();
        try {
            result = new VehicleDAO().getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<String> columnNames() {
        return  new ArrayList<>(Arrays.asList("id", "brand", "model", "#registrationNumber",
                "productionDate", "lastServiceDate", "rta", "owner"));
    }

}
