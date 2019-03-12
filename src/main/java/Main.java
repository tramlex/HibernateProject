
import database.HibernateSessionFactory;
import database.RegistrationEntity;
import org.hibernate.Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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


        System.out.println("Hibernate tutorial");

        Session session1 = HibernateSessionFactory.getSessionFactory().openSession();

        session1.beginTransaction();

        RegistrationEntity registrationEntity = new RegistrationEntity();

        registrationEntity.setId(1);
        registrationEntity.setFirst(name);
        registrationEntity.setLast(sname);
        registrationEntity.setFather(fname);

        session1.save(registrationEntity);
        session1.getTransaction().commit();
        session1.close();

      /*  ConnectionDB a = new ConnectionDB();
            try
            {
                a.connect(name,sname,fname);
            }
            catch(ClassNotFoundException q){
                System.out.println("1");
            }
            catch(SQLException q){
                System.out.println("2");
            }*/

                }

    }
