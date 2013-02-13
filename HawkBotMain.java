import org.jibble.pircbot.*;

public class HawkBotMain {
    
    public static void main(String[] args) throws Exception {
        
        // Now start our bot up.
    	HawkBot bot = new HawkBot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        //bot.connect("irc.esper.net");
        bot.connect("irc.freenode.net");


        // Join the #mctag channel.
        bot.joinChannel("#hawkfalcon");
       // bot.joinChannel("#infinitenight");
      // // bot.joinChannel("#mctag");
        bot.joinChannel("#gomeow");

    }
    
}