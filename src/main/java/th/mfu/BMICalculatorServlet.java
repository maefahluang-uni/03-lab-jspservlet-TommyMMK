package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
        //TODO: get parameter from request: "weight" and "height"
        double weight = Double.parseDouble(request.getParameter("weight"));
        double height = Double.parseDouble(request.getParameter("height"));        
        
        //TODO: calculate bmi
        double bmi = Math.round(weight / (height * height));
        

        //TODO: determine the built from BMI
        String result = "null";
        if(bmi < 18.5) {
            result = "underweight";
        }else if (bmi < 25) {
            result = "normal";
        }else if (bmi < 30) {
            result = "overweight";
        }else if (bmi < 35) {
            result = "obese";
        }else if (bmi >= 35) {
            result = "extremely obese";
        }
      
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("BMI", bmi);
        request.setAttribute("result", result);

        //TODO: forward to jsp
        request.getRequestDispatcher("bmi_result.jsp").forward(request, response);
           
    }
    
}
