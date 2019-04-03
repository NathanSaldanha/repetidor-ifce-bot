package repetidorIFCEBot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ApiContextInitializer.init();

		TelegramBotsApi botsApi = new TelegramBotsApi();
		
		
		

		try {
			botsApi.registerBot(new RepetidorIFCEBot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}

}
