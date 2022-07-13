import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    private int counter = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //TODO: SETS PARAMS
        String firstName = req.getParameter("n");
        String resetCount = req.getParameter("c");

        //TODO: RESET COUNTER IF PARAM IS USED
        if (resetCount != null) {
            res.sendRedirect("/hello");
            counter = -1;
        }

        //TODO: SETS CONTENT TYPE
        res.setContentType("text/html");

        //TODO: SETS WRITER
        PrintWriter out = res.getWriter();

        //TODO: SETS COUNTER TO INCREMENT
        counter++;

        //TODO: PRINTS TO THE PAGE
        out.println("<p>Site visited: " + counter + " times</p>");

        //TODO: CONDITIONS FOR IF NAME PARAM EXISTS OR NOT
        if (firstName == null) {
            out.println("<h1>Hello World!</h1>");
        }
        if (firstName != null) {
            //    TODO: BONUS
            out.println("<h1>Hello " + firstName + "</h1>");
        }
    }
}
