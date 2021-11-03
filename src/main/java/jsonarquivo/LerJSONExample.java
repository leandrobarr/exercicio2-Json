package jsonarquivo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LerJSONExample {
	public static void main(String[] args) {
		// Objeto analisador JSON para analisar o arquivo lido
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("./src/main/java/funcionario.json")) {
			// Leia o arquivo JSON
			Object obj = jsonParser.parse(reader);

			JSONArray funcionarioList = (JSONArray) obj;
			System.out.println(funcionarioList);

			// Iterar sobre a matriz de funcionários
			funcionarioList.forEach(emp -> parseFuncionarioObject((JSONObject) emp));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void parseFuncionarioObject(JSONObject funcionario) {
		// Obter objeto de funcionário dentro da lista
		JSONObject funcionarioObject = (JSONObject) funcionario.get("funcionario");

		// Obter o nome do funcionário
		String nome = (String) funcionarioObject.get("nome");
		System.out.println(nome);

		// Obter o sobrenome do funcionário
		String sobrenome = (String) funcionarioObject.get("sobrenome");
		System.out.println(sobrenome);

		// Obter a idade do funcionário
		String idade = (String) funcionarioObject.get("idade");
		System.out.println(idade);

		// Obter o nome do site do funcionário
		String website = (String) funcionarioObject.get("website");
		System.out.println(website);
	}
}
