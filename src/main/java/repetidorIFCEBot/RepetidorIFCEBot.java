package repetidorIFCEBot;


import java.text.DecimalFormat;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.google.common.primitives.Doubles;

public class RepetidorIFCEBot extends TelegramLongPollingBot {
	public void onUpdateReceived(Update update) {
		
		DecimalFormat df = new DecimalFormat("#,###,###0.0");
		double peso,altura;
		double imc;
		
		 
		
		// Chegando se a atualizacao (update) tem uma mensagem e se a mensagem tem texto
		String s = update.getMessage().getText();
		String[] a =s.split(" ") ;
		
		peso = Double.parseDouble(a[0]);
		altura = Double.parseDouble(a[1]);
		
		imc = peso/Math.pow(altura, 2);
		imc *=10000;
		
			// Instancia um objeto SendMessage com os campos que são OBRIGATORIOS
			SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
					.setText("Seu imc eh: "+df.format(imc));
					
			 
			
			try {

				// Chama o metodo para enviar mensagem
				execute(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	

	// Esse metodo deve sermpre retornar o username do seu Bot
	public String getBotUsername() {

		return "imc_bot_ifce_01_bot";
	}

	// Esse metodo deve sempre retornar o token do seu bot
	@Override
	public String getBotToken() {

		return "776557056:AAEYK6hJS2gr9MHtIKZMQS-s4e2ZZsxO84c";
	}
}
