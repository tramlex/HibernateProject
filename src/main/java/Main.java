
import database.HibernateSessionFactory;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/Main")
public class Main extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            HttpSession session = request.getSession();
           String name = (String) session.getAttribute("fname");
           String sname = (String) session.getAttribute("sname");
           String fname = (String) session.getAttribute("fathername");
            session.invalidate();

            out.print("<html>\n" +
                    "<body>\n" +
                    "<h2>Hello , " + " " + name + " " + sname + " " + fname + "!!!</h2>\n" +
                    "\n" +
                    "</form>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>");


        System.out.println("Hibernate tutorial , START");

        HibernateSessionFactory hibernateSessionFactory = new HibernateSessionFactory();
        hibernateSessionFactory.AddData(name ,sname ,fname);

        System.out.println("Hibernate tutorial , END");
    }


    }
