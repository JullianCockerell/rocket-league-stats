
package jsonparser;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.util.Iterator;
import org.json.*;
import java.lang.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseInfo {
    public PlayerInfo ParseInfo()
    {
        //steam id: 76561198068821663
       //game id: 1
       //API Key: MF3US9NVKJ7D53EN2AO6FHFJCO7TZ8BP
       String jsonOutput= "Didn't assign";
       try
        {
            //URL url = new URL("https://api.rocketleaguestats.com/v1/player?unique_id=76561198068821663&platform_id=1");
            URL url = new URL("https://api.rocketleaguestats.com/v1/player?unique_id=Pouchetta&platform_id=1");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "MF3US9NVKJ7D53EN2AO6FHFJCO7TZ8BP");
            con.connect();
            BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) 
            {
                content.append(inputLine);
            }
            in.close();
            jsonOutput = content.toString();
        }
       catch(MalformedURLException e)
        {
            System.out.println("Malformed Error");
        }
       catch(ProtocolException e)
       {
           System.out.println("Protocol Error");
       }
       catch(IOException e)
       {
           System.out.println("IOException");
       }
       //Prints response to GET request>
       //System.out.println(jsonOutput);
       JSONParser parser = new JSONParser();
      
        String uniqueId = " ";
        String displayName = " ";
        String platform = " ";
        long wins = 0;
        long goals = 0;
        long mvps = 0;
        long saves = 0;
        long shots = 0;
        long assists = 0;
        long sRankPoints = 0;
        long sTier = 0;
        long sDiv = 0;
        long dRankPoints = 0;
        long dTier = 0;
        long dDiv = 0;
        long tRankPoints = 0;
        long tTier = 0;
        long tDiv = 0;
       try
       {
            JSONObject playerInfo = (JSONObject) parser.parse(jsonOutput);
            uniqueId = (String) playerInfo.get("uniqueId");
            displayName = (String) playerInfo.get("displayName");
            JSONObject platformInfo = (JSONObject) playerInfo.get("platform");
            platform = (String) platformInfo.get("name");
            JSONObject stats = (JSONObject) playerInfo.get("stats");
            wins = (long) stats.get("wins");
            goals = (long) stats.get("goals");
            mvps = (long) stats.get("mvps");
            saves = (long) stats.get("saves");
            shots = (long) stats.get("shots");
            assists = (long) stats.get("assists");
            JSONObject rankedStats = (JSONObject) playerInfo.get("rankedSeasons");
            JSONObject season7 = (JSONObject) rankedStats.get("7"); 
            JSONObject soloStats = (JSONObject) season7.get("10");
            JSONObject duoStats = (JSONObject) season7.get("11");
            JSONObject stanStats = (JSONObject) season7.get("13");
            sRankPoints = (long) soloStats.get("rankPoints");
            dRankPoints = (long) duoStats.get("rankPoints");
            tRankPoints = (long) stanStats.get("rankPoints");
            sTier = (long) soloStats.get("tier");
            dTier = (long) duoStats.get("tier");
            tTier = (long) stanStats.get("tier");
            sDiv = (long) soloStats.get("division");
            dDiv = (long) duoStats.get("division");
            tDiv = (long) stanStats.get("division");


       }
       catch(ParseException e)
       {
           System.out.println("Parse Error");
       }
       
       PlayerInfo p1 = new PlayerInfo(uniqueId, displayName, platform, wins, goals, mvps, saves, shots, assists, sRankPoints, sTier, sDiv, dRankPoints, dTier, dDiv, tRankPoints, tTier, tDiv);
       return p1;
    }  
    
    public String tierString(long input)
    {
        String output = "N/A";
        int inputI = (int) input;
        switch(inputI)
        {
            case 0: output = "Unranked"; break;
            case 1: output = "Bronze I"; break;
            case 2: output = "Bronze II"; break;
            case 3: output = "Bronze III"; break;
            case 4: output = "Silver I"; break;
            case 5: output = "Silver II"; break;
            case 6: output = "Silver III"; break;
            case 7: output = "Gold I"; break;
            case 8: output = "Gold II"; break;
            case 9: output = "Gold III"; break;
            case 10: output = "Platinum I"; break;
            case 11: output = "Platinum II"; break;
            case 12: output = "Platinum III"; break;
            case 13: output = "Diamond I"; break;
            case 14: output = "Diamond II"; break;
            case 15: output = "Diamond III"; break;
            case 16: output = "Champion I"; break;
            case 17: output = "Champion II"; break;
            case 18: output = "Champion III"; break;
            case 19: output = "Grand Champion"; break;
        }
        return output;
    }
    
    public void printURL()
    {
        try
        {
            URL oracle = new URL("https://en.wikipedia.org/wiki/%22Hello%2C_World!%22_program");
            BufferedReader in = new BufferedReader(
            new InputStreamReader(oracle.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                System.out.println(inputLine);
            }
            in.close();
        }
        catch(MalformedURLException e)
        {
            System.out.println("Malformed Error");
        }
        catch(IOException e)
       {
           System.out.println("IOException");
       }
    }
    
    public String useJsoup()
    {
        String output = " ", url = "https://en.wikipedia.org/wiki/%22Hello%2C_World!%22_program";
        try
        {
        Document document = Jsoup.connect(url).get();
        output = document.select("#firstHeading").text();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return output;
    }
}
