import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculateDiscountServlet",urlPatterns = "/calculate")
public class CalculateDiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            float price =Float.parseFloat(request.getParameter("price"));
            String product =request.getParameter("product");
            float discout =Float.parseFloat(request.getParameter("discout"));
            double TotalDiscout = price * discout * 0.01;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1> Product Description:"+product+" </h1>");
        writer.println("<h1>Price: " + price+ "</h1>");
        writer.println("<h1>Discount Percent: %" + discout+ "</h1>");
        writer.println("<h1>Discount Amount:$ " + TotalDiscout+ "</h1>");
        writer.println("<h1>Discount Price: $" + (price-TotalDiscout)+ "</h1>");
        writer.println("</html>");
//        Product Discount Calculator
//        Product Description:
//        Price:$
//        Discount Percent:%
//        Discount Amount:$0
//        Discount Price:$0
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
