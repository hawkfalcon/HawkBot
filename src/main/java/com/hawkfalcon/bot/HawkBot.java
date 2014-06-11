package com.hawkfalcon.bot;
import java.util.Random;

import org.pircbotx.PircBotX;
import org.pircbotx.User;
import org.pircbotx.hooks.Listener;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.InviteEvent;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

public class HawkBot extends ListenerAdapter implements Listener {
	@Override
	public void onInvite(InviteEvent event){
	event.getBot().joinChannel(event.getChannel());
	event.getBot().sendMessage(event.getChannel(), "Hello, I am HawkBot. Thank you for inviting me to your channel!");
	}
    
	@Override
	public void onMessage(MessageEvent event) throws Exception{
		String delims = "[ ]+";
		String[] args = event.getMessage().split(delims);
		String message = event.getMessage().toLowerCase();
		String sender = event.getUser().getNick();
		
		// [!time]
		if (message.equalsIgnoreCase("!time")) {
			String time = new java.util.Date().toString();
			event.respond("The time is now " + time);
		}
		// [!cookie]
		else if (message.startsWith("!cookie")) {
			if (args.length == 1){
				event.getBot().sendAction(event.getChannel(),  "gives everyone a cookie!");
			}
			else if ((args.length < 3) && (args.length > 1)){
				event.getBot().sendAction(event.getChannel(),  "gives " + args[1] + " a cookie!");
			}
			else {
				StringBuilder sb = new StringBuilder();
				for(int i = 2; i < (args.length); i++) {
					sb.append(args[i]);
					sb.append(" ");
				}
				event.getBot().sendAction(event.getChannel(),  "gives " + args[1] + " a cookie for " + sb);
			}
		}
		// [!whip]
				else if (message.startsWith("!whip")) {
					if (args.length == 1){
						event.getBot().sendAction(event.getChannel(),  "whips everyone!");
					}
					else if ((args.length < 3) && (args.length > 1)){
						event.getBot().sendAction(event.getChannel(),  "whips " + args[1]);
					}
					else {
						StringBuilder sb = new StringBuilder();
						for(int i = 2; i < (args.length); i++) {
							sb.append(args[i]);
							sb.append(" ");
						}
						event.getBot().sendAction(event.getChannel(),  "whips " + args[1] + " because " + sb);
					}
				}
		// [!greet]
		else if (message.startsWith("!greet")) {
            if(args.length==1) {
                event.getBot().sendAction(event.getChannel(), "greets " + args[1] + "!");
            }
            }
		// [!list]
		else if (message.startsWith("!list")) {
			StringBuilder sbs = new StringBuilder();
			for (User user : event.getBot().getUsers(event.getChannel())){
				sbs.append(user.getNick() + ", ");
			}
			event.getBot().sendNotice(sender, "Users: " + sbs.toString());
		}
			
			// [!boringhistuff] 
			else if (message.startsWith("!hi")) {
				 event.getBot().sendMessage(event.getChannel(),"Hello!");
				 event.getBot().sendMessage(event.getChannel(),"How are you today?");
				 event.getBot().sendMessage(event.getChannel(),sender + " is fine!");
				 event.getBot().sendMessage(event.getChannel(),"What's up?");
			}
			// [!boringbyestuff]
			else if (message.startsWith("!bye")) {
				event.getBot().sendMessage(event.getChannel(),"Bye!");
				event.getBot().sendMessage(event.getChannel(), "Have fun!");
				event.getBot().sendMessage(event.getChannel(),"See you soon!");
			}
		    // [!code]
		    else if (message.startsWith("!code")) {
		    event.getBot().sendMessage(event.getChannel(), sender + " wants to see the code!");
		    }
	         // [!link]
	        else if (message.startsWith("!link")) {
	        event.getBot().sendMessage(event.getChannel(),sender + " wants the link!");
	        }
	        // [!brb]
	        else if (message.startsWith("!brb")) {
	        event.getBot().sendMessage(event.getChannel(),sender + " will be right back!");
	        }
		
		
		 	else if (message.contains("hawkbot") && message.contains("?")){
				Random rand = new Random();
				if (rand.nextBoolean()) {
					 event.getBot().sendMessage(event.getChannel(),"Yes.");
				}
				else {
					 event.getBot().sendMessage(event.getChannel(),"No.");
				}
			//sendAction(channel, "doesn't want to!");
			//sendAction(channel, "loves you because you mentioned him!");
				

		}
			else if ((message.contains("meaning") && message.contains("life"))
					|| (message.contains("life") && message.contains("universe") && message.contains("everything"))){
				 event.getBot().sendMessage(event.getChannel(),"42!");
		} 

	}
	@Override
	public void onPrivateMessage(PrivateMessageEvent event) {
		String delims = "[ ]+";
		String[] args = event.getMessage().split(delims);
		String message = event.getMessage().toLowerCase();
		if (message.startsWith("!say")){
			StringBuilder sb = new StringBuilder();
			for(int i = 2; i < (args.length); i++) {
				sb.append(args[i]);
				sb.append(" ");
			}
        event.getBot().sendMessage(args[1], sb.toString());
		}
	}
    public static void main(String[] args) throws Exception {
        Bot bot = new Bot();
        bot.connect("irc.esper.net", 6669, "LOLNOPE");
        bot.joinChannel("#NickIsTesting");
        bot.joinChannel("#Hawkfalcon");
        bot.joinChannel("#shocknetwork");
        bot.setVerbose(true);
        bot.sendMessage("#NickIsTesting", "Testing");
        bot.getListenerManager().addListener(new HawkBot());
    }
}
