import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/textCounter")
public class TextCounterServlet extends HttpServlet {
    private static final String MIME_TYPE_TEXT_HTML = "text/html";
    private static final String CHARACTER_ENCODING = "UTF-8";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding(CHARACTER_ENCODING);
        response.setContentType(MIME_TYPE_TEXT_HTML);
        response.setCharacterEncoding(CHARACTER_ENCODING);

        String textFromUser = request.getParameter("text");

        response.getWriter().println(String.format("%s ", textFromUser));
        response.getWriter().println(String.format("<h2>Ilość słów: %d</h2>", Statistics.countWords(textFromUser)));
        response.getWriter().println(String.format("<h2>Ilość znaków: %d</h2>", Statistics.countSigns(textFromUser)));
        response.getWriter().println(String.format("<h2>Ilość znaków (bez spacji): %d</h2>", Statistics.countSignsWithoutSpaces(textFromUser)));
        response.getWriter().println(String.format("<h2>Palindrom: %s</h2>", Statistics.isPalindrom(textFromUser)));

    }

}
