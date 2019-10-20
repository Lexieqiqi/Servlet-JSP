package mypackage;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Example using servlet initialization. 
 * Here, the message to print and the number of times the message should be repeated is taken 
 * from the init parameters. 
 * 
 * To open this example, please check:
 * if the servlet is defined in web.xml and also has url mapping,<p>
 * open with: http://localhost:8080/message 
 * 
 * if the servlet is defined in web.xml, but not defined url mapping
 * open with: http://localhost:8080/servlet/coreservlets.ShowMessage
 */
public class ShowMessage extends HttpServlet
{
   private String message;

   private String defaultMessage = "No message.";

   private int repeats = 1;

   /**
    * Called by the servlet container to indicate to a servlet that the servlet is being 
    * placed into service. 
    * The servlet container calls the init method exactly once after instantiating the
    * servlet. The init method must complete successfully before the servlet can receive any
    * requests. 
    * The servlet container cannot place the servlet into service if the init method
    * Throws a ServletException Does not return within a time period defined by the Web server
    * 
    * Parameters: config - a ServletConfig object containing the servlet's configuration and
    * initialization parameters 
    * 
    * Overrides method to
    * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
    */
   public void init(ServletConfig config) throws ServletException
   {
      // Always call super.init
      super.init(config);
      message = config.getInitParameter("message");
      if ( message == null )
      {
         message = defaultMessage;
      }
      try
      {
         String repeatString = config.getInitParameter("repeats");
         repeats = Integer.parseInt(repeatString);
      }
      catch (NumberFormatException nfe)
      {
         // NumberFormatException handles case where repeatString
         // is null *and* case where it is something in an
         // illegal format. Either way, do nothing in catch,
         // as the previous value (1) for the repeats field will
         // remain valid because the Integer.parseInt throws
         // the exception *before* the value gets assigned
         // to repeats.
      }
   }

   /**
    * 
    * Overrides method to 
    * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
    */
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "The ShowMessage Servlet";
      String str = ServletUtilities.headWithTitle(title) 
               + "<BODY BGCOLOR=\"#FDF5E6\">\n" 
               + "<H1 ALIGN=CENTER>" + title
               + "</H1>";
      
      out.println(str);
      for (int i = 0; i < repeats; i++)
      {
         out.println(message + "<BR>");
      }
      out.println("</BODY></HTML>");
   }
}
