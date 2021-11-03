package jsonarquivo;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class EscreverJSONExample {

	@SuppressWarnings("verificacao")
	public static void main(String[] args) {

		// Dados do primeiro funcionario
		JSONObject funcionarioDetails = new JSONObject();
		funcionarioDetails.put("nome", "Leandro");
		funcionarioDetails.put("sobrenome", "Barros");
		funcionarioDetails.put("idade", "43");
		funcionarioDetails.put("website", "bet.com");

		JSONObject funcionarioObject = new JSONObject();
		funcionarioObject.put("funcionario", funcionarioDetails);

		// Dados do segundo funcionario
		JSONObject funcionarioDetails2 = new JSONObject();
		funcionarioDetails2.put("nome", "Gabriel");
		funcionarioDetails2.put("sobrenome", "Barros");
		funcionarioDetails.put("idade", "21");
		funcionarioDetails2.put("website", "youtube.com");

		JSONObject funcionarioObject2 = new JSONObject();
		funcionarioObject2.put("funcionario", funcionarioDetails2);

		// Adicionar funcionários à lista
		JSONArray funcionarioList = new JSONArray();
		funcionarioList.add(funcionarioObject);
		funcionarioList.add(funcionarioObject2);

		// Grava o arquivo JSON
		try (FileWriter file = new FileWriter("./src/main/java/funcionario.json")) {
			// We can write any JSONArray or JSONObject instance to the file
			file.write(funcionarioList.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
