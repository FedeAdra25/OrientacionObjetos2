import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HolaMundo extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE> Hola Mundo </TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<CENTER><H1> Hola Mundo! </H1> </CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
        out.close();
    }

}
