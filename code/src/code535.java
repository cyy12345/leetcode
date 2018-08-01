import java.util.HashMap;
import java.util.Map;

public class code535 {
    public class Codec {
        Map<Long,String> urls = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            long hashcode = longUrl.hashCode();
            urls.put(hashcode,longUrl);
            String newUrl = "";
            newUrl = "http://" + longUrl.substring(longUrl.lastIndexOf("/")+1,longUrl.length())+".com/"+hashcode;
            return newUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            long hashcode =Long.parseLong(shortUrl.substring(shortUrl.lastIndexOf("/")+1,shortUrl.length()));
            return urls.get(hashcode);
        }
    }
}
