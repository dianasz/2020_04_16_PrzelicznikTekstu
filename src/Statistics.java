public class Statistics {

    static int countWords(String textFromUser){
        return textFromUser.split(" ").length;
    }

    static int countSigns(String textFromUser){
        return textFromUser.length();
    }

    static int countSignsWithoutSpaces(String textFromUser){
        return textFromUser.replace(" ", "").length();
    }

    static boolean isPalindrom(String textFromUser){
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
