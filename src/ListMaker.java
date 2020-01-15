

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListMaker
 */
@WebServlet("/ListMaker")
public class ListMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListMaker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		Enumeration<String> parameterNames = request.getParameterNames();
		Integer i = 0;
		String parameterName;

		/* Create the start of the output */
		out.append("<body>");
		out.append("<h3>List of things</h3>");
		out.append("<form action=\"ListMaker\">");

		/* Add an input for every previously added item */
		while (parameterNames.hasMoreElements()) {
			parameterName = parameterNames.nextElement();
			out.append("<input type=\"text\" name=\"");
			out.append(parameterName);
			out.append("\" value=\"");
			out.append(request.getParameter(parameterName));
			out.append("\"><br>");
			i += 1;
		}
		
		/* Add input for adding a new entry to the list */
		out.append("<input type=\"text\" name=\"");
		out.append(i.toString());
		out.append("\"><br>");
		
		/* Create the end of the output */
		out.append("<input type=\"submit\" value=\"Add item/update list\">");
		out.append("</form></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
