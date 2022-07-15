import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PizzaOrderServlet", urlPatterns = "/pizza-order")
public class PizzaOrderServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        req.getRequestDispatcher("/WEB-INF/pizza-order.jsp").forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        PrintWriter out = res.getWriter();

        String choice1 = req.getParameter("tossed");
        String choice2 = req.getParameter("thin");
        String choice3 = req.getParameter("marinara");
        String choice4 = req.getParameter("pesto");
        String choice5 = req.getParameter("12");
        String choice6 = req.getParameter("14");
        String choice7 = req.getParameter("extra-cheese");
        String choice8 = req.getParameter("peperoni");
        String choice9 = req.getParameter("pineapple");
        String choice10 = req.getParameter("address");


        req.setAttribute("tossed", choice1);
        req.setAttribute("thin", choice2);
        req.setAttribute("marinara", choice3);
        req.setAttribute("pesto", choice4);
        req.setAttribute("12\"", choice5);
        req.setAttribute("14\"", choice6);
        req.setAttribute("extra-cheese", choice7);
        req.setAttribute("peperoni", choice8);
        req.setAttribute("pineapple", choice9);
        req.setAttribute("address", choice10);

        if (choice1 != null) {
            out.println("Pizza Crust: " + choice1);
        }
        if (choice2 != null) {
            out.println("Pizza Crust: " + choice2);
        }
        if (choice3 != null) {
            out.println("Pizza Sauce: " + choice3);
        }
        if (choice4 != null) {
            out.println("Pizza Sauce: " + choice4);
        }
        if (choice5 != null) {
            out.println("Pizza Size: " + choice5);
        }
        if (choice6 != null) {
            out.println("Pizza Size: " + choice6);
        }
        if (choice7 != null) {
            out.println("Pizza Toppings: " + choice7);
        }
        if (choice8 != null) {
            out.println("Pizza Toppings: " + choice8);
        }
        if (choice9 != null) {
            out.println("Pizza Toppings: " + choice9);
        }
        if (choice10 != null) {
            out.println("Address: " + choice10);
        }
    }
}
