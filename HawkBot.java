import org.jibble.pircbot.*;

public class HawkBot extends PircBot {

	public HawkBot() {
		this.setName("HawkBot");
	}
	public void onMessage(String channel, String sender,
			String login, String hostname, String message) {
		String delims = "[ ]+";
		String[] args = message.split(delims);
		if (message.equalsIgnoreCase("!time")) {
			String time = new java.util.Date().toString();
			sendMessage(channel, sender + ": The time is now " + time);
		}
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
		else if (message.startsWith("!whip")) {
			sendAction(channel, "whips " + args[1] + "!");
		}
	}

}