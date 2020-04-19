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
        response.getWriter().println(String.format("<h2>Ilość słów: %d</h2>", countWords(textFromUser)));
        response.getWriter().println(String.format("<h2>Ilość znaków: %d</h2>", countSigns(textFromUser)));
        response.getWriter().println(String.format("<h2>Ilość znaków (bez spacji): %d</h2>", countSignsWithoutSpaces(textFromUser)));
        response.getWriter().println(String.format("<h2>Palindrom: %s</h2>", isPalindrom(textFromUser)));

    }

    int countWords(String textFromUser){
        return textFromUser.split(" ").length;
    }

    int countSigns(String textFromUser){
        return textFromUser.length();
    }

    int countSignsWithoutSpaces(String textFromUser){
        return  textFromUser.replace(" ", "").length();
    }

    boolean isPalindrom(String textFromUser){
        int textLenght = countSigns(textFromUser);
        int start = 0;
        int end = (textLenght - 1);
        for (int i = 0; i < textLenght; i++) {
            if (textFromUser.charAt(i) != textFromUser.charAt(end)) {
                start = 1;
                break;
            } end--;
        }
        return start != 1;
    }

}
