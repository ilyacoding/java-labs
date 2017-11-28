package by.bsuir.ilyacoding.Server.controller.command.util;



public class Parser {

    public static String[] parse(String request) {
        /*List<String> parts = new LinkedList<>();
        Matcher matcher = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(request);
        while (matcher.find()) {
            parts.add(matcher.group(1).replace("\"", ""));
        }
        return parts.toArray(new String[parts.size()]);*/
        return request.split(";");
    }
}
