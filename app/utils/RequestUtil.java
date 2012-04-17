package utils;

import play.mvc.Http;

/**
 * Created with IntelliJ IDEA.
 * User: Alexis
 * Date: 17/04/12
 * Time: 23:34
 * To change this template use File | Settings | File Templates.
 */
public class RequestUtil {

    public static boolean acceptsJson(Http.Request request) {
        return request.headers.get("accept") != null && (request.headers.get("accept").value().contains("text/json") || request.headers.get("accept").value().contains("application/json"));
    }

    public static boolean acceptsXml(Http.Request request) {
        return request.headers.get("accept") != null && (request.headers.get("accept").value().equals("text/xml") || request.headers.get("accept").value().equals("application/xml"));
    }
}
