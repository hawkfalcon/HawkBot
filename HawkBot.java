import org.jibble.pircbot.*;

public class HawkBot extends PircBot {

	public HawkBot() {
		this.setName("HawkBot");
	}
	public void onMessage(String channel, String sender,
			String login, String hostname, String message) {
		String delims = "[ ]+";
		String[] args = message.split(delims);
		// [!time]
		if (message.equalsIgnoreCase("!time")) {
			String time = new java.util.Date().toString();
			sendMessage(channel, sender + ": The time is now " + time);
		}
		// [!cookie]
		else if (message.startsWith("!cookie")) {
			if (args.length == 1){
			sendAction(channel, "gives everyone a cookie!");
			}
		    else if ((args.length < 3) && (args.length > 1)){
			sendAction(channel, "gives " + args[1] + " a cookie!");
			}
			else {
			StringBuilder sb = new StringBuilder();
				for(int i = 2; i < (args.length); i++) {
					sb.append(args[i]);
					sb.append(" ");
			    }
			sendAction(channel, "gives " + args[1] + " a cookie for " + sb);
			}
		}
		// [!whip]
		else if (message.startsWith("!whip")) {
			sendAction(channel, "whips " + args[1] + "!");
		}
		// [!greet]
				else if (message.startsWith("!greet")) {
					sendAction(channel, "greets " + args[1] + "!");
				}
		// [!list]
		else if (message.startsWith("!list")) {
			StringBuilder sbs = new StringBuilder();
			for (User user : getUsers(channel)){
				sbs.append(user.getNick() + ", ");
			}
				sendMessage(channel, "Users: " + sbs.toString());
			
			/*for (User user : getUsers(channel)){
				sendMessage(channel, user.getNick());

			}*/

  		}
		// [!help]
				else if (message.startsWith("!help")) {
					sendAction(channel, "will not help you!");
				}
		// [!hi]
				else if (message.startsWith("!hi")) {
					sendMessage(channel, "!bye");
				}
		// [!bye]
				else if (message.startsWith("!bye")) {
					sendMessage(channel, "!hi");
				}
		// [!bye]
				else if (message.startsWith("!smack")) {
					sendMessage(channel, "Ow!");
					sendMessage(channel, "!smack");

				}
				//else if (message.startsWith("H")) {
					//sendMessage(channel, "Hi, I'm TheEpicMineBot!");
					//for (User user : getUsers(channel)){
					//sendMessage(channel, user.getNick());
				//}
				
	// [!boringhistuff]
	else if (message.startsWith("!boringhistuff")) {
		sendMessage(channel, "Hello!");
		sendMessage(channel, "How are you today?");
		sendMessage(channel, "Hawkfalcon is fine!");
		sendMessage(channel, "What's up?");
	}
		// [!boringbyestuff]
		else if (message.startsWith("!boringbyestuff")) {
			sendMessage(channel, "Bye!");
			sendMessage(channel, "Have fun!");
			sendMessage(channel, "See you soon!");
		}
		else if (message.toLowerCase().contains("hawkbot")){
			sendAction(channel, "HawkBot doesn't want to!");
		}
	}

}