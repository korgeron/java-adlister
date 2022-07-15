import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GuessServlet", urlPatterns = "/guess")
public class GuessServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        req.getRequestDispatcher("/WEB-INF/guess.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int random = (int)(Math.random() * 3) + 1;



        int answer = Integer.parseInt(req.getParameter("number"));


        if (answer == random){
            res.sendRedirect("/correct");
        }
        else if(answer >= 4){
            res.sendRedirect("/guess");
        }
        else {
            res.sendRedirect("/incorrect");
        }

    }
}
