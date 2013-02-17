import java.util.Random;

import org.jibble.pircbot.*;

public class MagicEightBot extends PircBot {

	public MagicEightBot() {
		this.setName("Magic8");
	}
	protected void onInvite(String targetNick, String sourceNick, String sourceLogin, String sourceHostname, String channel){
    joinChannel(channel);
    sendMessage(channel, "Hello, I am the Magic8 Bot. Thank you for inviting me to your channel! Just tag me to ask me questions.");
	}
	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		String[] magicArray = {
				"Signs point to yes.",
				"Yes.",
				"Reply hazy, try again",
				"Without a doubt.",
				"My sources say no.",
				"As I see it, yes.",
				"You may rely on it.",
				"Concentrate and ask again.",
				"Outlook not so good.",
				"It is decidedly so.",
				"Better not tell you now.",
				"Very doubtful.",
				"Yes - definitely.",
				"It is certain.",
				"Cannot predict now.",
				"Most likely.",
				"Ask again later.",
				"My reply is no.",
				"Outlook good.",
				"Don't count on it."
				};
		if (((message.contains("M8:")) && (message.contains("?"))) || ((message.contains("Magic8:")) && (message.contains("?")))){
		    Random r = new Random();
			sendMessage(channel, magicArray[r.nextInt( magicArray.length)]);
			
		}
	}
}