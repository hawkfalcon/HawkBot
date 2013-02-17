import org.jibble.pircbot.*;

public class MagicEightBotMain {
    
    public static void main(String[] args) throws Exception {
        
        // Now start our bot up.
    	MagicEightBot bot = new MagicEightBot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        //bot.connect("irc.esper.net");
        bot.connect("irc.esper.net");


        // Join the #mctag channel.
        //bot.joinChannel("#hawkfalcon");
       // bot.joinChannel("#infinitenight");
        bot.joinChannel("#mctag");
        bot.joinChannel("#gomeow");

    }
    
}