package com.exercicioJson2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.json.CDL;
import org.json.Cookie;
import org.json.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;
import org.json.JSONWriter;
import org.json.Property;
import org.json.XML;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExercicioJson2Application {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SpringApplication.run(ExercicioJson2Application.class, args);
		JSONObjectToArray();
		JSONExampleArray1();
		JSONExampleArray2();
		JSONExampleStringer();
		JSONExampleObject1();
		JSONExampleObject2();
		JSONExampleObject3();
		JSONExamplWriter();
		XMLToExampleConversion();
		XMLFromExampleConversion();
		CookieToExampleConversion();
		CookieFromExampleConversion();
		HTTPToExampleConversion();
		HTTPFromExampleConversion();
		CDLToExampleConversion();
		CDLFromExampleConversion();
		PropertyToExampleConversion();

	}

	private static void JSONExampleArray1() {
		// Criamos um JSONObject a partir de uma String contendo uma matriz usando
		// JSONArray
		// Em primeiro lugar, declaramos um Array em uma String

		String arrayStr = "[" + "true," + "false," + "\"true\"," + "\"false\"," + "\"hello\"," + "23.45e-4,"
				+ "\"23.45\"," + "42," + "\"43\"," + "[" + "\"world\"" + "]," + "{" + "\"key1\":\"value1\","
				+ "\"key2\":\"value2\"," + "\"key3\":\"value3\"," + "\"key4\":\"value4\"" + "}," + "0," + "\"-1\""
				+ "]";

		// Então, inicializamos o JSONArray graças ao seu construtor

		JSONArray array = new JSONArray(arrayStr);
		System.out.println("Values array: " + array);

		// Convertemos esse array em um JSONObject, mas primeiro, precisamos dos
		// rótulos, portanto, precisamos de outro JSONArray com os rótulos.
		// Aqui usaremos uma função auxiliar para obter uma para o exemplo.

		JSONArray list = listNumberArray(array.length());
		System.out.println("Label Array: " + list.toString());
		// Agora, construímos o JSONObject usando a matriz de valor e a matriz de
		// rótulo.
		JSONObject object = array.toJSONObject(list);
		System.out.println("Final JSONOBject: " + object);
	}

	// This method creates an JSONArray of labels in which those are generated by
	// their positions

	private static JSONArray listNumberArray(int max) {
		JSONArray res = new JSONArray();
		for (int i = 0; i < max; i++) {
			// Este método cria um JSONArray de rótulos nos quais aqueles são gerados por
			// suas posições
			res.put(String.valueOf(i));
		}
		return res;
	}

	private static void JSONExampleArray2() {

		// Também podemos criar um Array sem String criando um array vazio e adicionando
		// elementos a ele
		JSONArray array = new JSONArray();

		// Adicionando elementos com .put ()

		array.put("value");
		array.put(5);
		array.put(-23.45e67);
		array.put(true);

		// Nós o convertemos em JSONObject fornecendo uma matriz de rótulo como da
		// última vez

		JSONArray list = listNumberArray(array.length());
		JSONObject object = array.toJSONObject(list);
		System.out.println("Final JSONOBject: " + object);
	}

	private static void JSONExampleStringer() {

		// Inicializamos o JSONStringer

		JSONStringer jsonStringer = new JSONStringer();

		// Agora começamos o processo de adição de elementos com .object ()

		jsonStringer.object();

		// Agora podemos adicionar elementos como chaves e valores com .values () e .key
		// ()

		jsonStringer.key("trueValue").value(true);
		jsonStringer.key("falseValue").value(false);
		jsonStringer.key("nullValue").value(null);
		jsonStringer.key("stringValue").value("hello world!");
		jsonStringer.key("complexStringValue").value("h\be\tllo w\u1234orld!");
		jsonStringer.key("intValue").value(42);
		jsonStringer.key("doubleValue").value(-23.45e67);

		// Terminamos este procedimento com .Object

		jsonStringer.endObject();

		// Uma vez que temos um JSONStringer, nós o convertemos em JSONObject gerando
		// uma String e usando o construtor JSONObject.

		String str = jsonStringer.toString();
		JSONObject jsonObject = new JSONObject(str);

		System.out.println("Final JSONOBject: " + jsonObject);
	}

	private static void JSONExampleObject1() {

		// Podemos criar um JSONObject a partir de uma String com o construtor de
		// classes

		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";
		JSONObject example = new JSONObject(string);
		System.out.println("Final JSONObject: " + example);

	}

	private static void JSONExampleObject2() {

		// Também podemos criar um JSONObject diretamente, sem mexer em nenhuma das
		// outras funções.

		JSONObject example = new JSONObject();

		// Agora adicionamos as chaves e os valores de maneira semelhante ao método
		// Stringer
		example.put("key", "value");

		// Como você pode ver, a primeira entrada é a chave e a segunda seria seu valor
		// associado.
		example.put("key2", 5);
		example.put("key3", -23.45e67);
		example.put("trueValue", true);

		// Não podemos adicionar valores nulos, pensamos

		// example.put("nullValue ", null); //Isso não é possível

		System.out.println("Final JSONOBject: " + example);
	}

	private static void JSONExampleObject3() {

		// Também podemos criar um JSONObject com um mapa Java
		// Você precisará de um Mapa cujas chaves são Strings. Os valores podem ser o
		// que você quiser

		Map<String, Double> map = new HashMap<String, Double>();

		map.put("key1", 1.0);
		map.put("key2", -23.45e67);

		// Criamos o JSONObject com o mapa com seu construtor de classe

		JSONObject example = new JSONObject(map);
		System.out.println("Final JSONOBject: " + example);
	}

	private static void JSONExamplWriter() {

		// Este método funciona de forma muito semelhante a Object e Stringer na
		// construção do JSON.
		// A diferença é que ele precisa de um objeto Java chamado "Appendable" como
		// StringBuilder

		StringBuilder write = new StringBuilder();
		JSONWriter jsonWriter = new JSONWriter(write);

		// Agora nos comportamos da mesma maneira que Stringer
		jsonWriter.object();

		jsonWriter.key("trueValue").value(true);
		jsonWriter.key("falseValue").value(false);
		jsonWriter.key("nullValue").value(null);
		jsonWriter.key("stringValue").value("hello world!");
		jsonWriter.key("complexStringValue").value("h\be\tllo w\u1234orld!");
		jsonWriter.key("intValue").value(42);
		jsonWriter.key("doubleValue").value(-23.45e67);

		jsonWriter.endObject();

		// O resultado deve estar no objeto "escrever"

		System.out.println("JSON: " + write.toString());

		// A diferença é que não obtemos um JSONObject neste.

	}

	private static void JSONExampleTokener() {

		// A partir de una String podemos crear un JSONTokener, que lo podemos usar
		// alternativamente para JSONArray,JSONObject

		String string = "this is not a valid JSON string";
		JSONTokener token = new JSONTokener(string);

		// Agora você pode usar o token em JSONObject e Array da mesma forma que um
		// String

		JSONObject object = new JSONObject(token);
		JSONArray array = new JSONArray(token);

	}

	private static void JSONObjectToArray() {
		// Começamos com um JSONObject

		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";

		JSONObject example = new JSONObject(string);

		// Precisamos de uma lista de strings de chave como a operação reversa

		JSONArray keyStrings = listNumberArray(example.length());

		// Em seguida, convertemos para o Array usando os dois elementos

		JSONArray array = example.toJSONArray(keyStrings);

		System.out.println("Final JSONArray: " + array);
	}

	private static void XMLToExampleConversion() {

		// Começamos com um JSONObject

		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";
		JSONObject example = new JSONObject(string);

		// Obtemos uma String com formato XML com toString ()

		String output = XML.toString(example);
		System.out.println("Final XML: " + output);
	}

	private static void XMLFromExampleConversion() {

		// Começamos com uma string com o formato XML

		String string = "<0>value</0><1>5</1><2>-2.345E+68</2><3>true</3>";

		// Obtemos um JSONObject com toJSONOBject ()

		JSONObject output = XML.toJSONObject(string);

		System.out.println("Final JSONObject: " + output);
	}

	private static void CookieToExampleConversion() {

		// Começamos com um JSONObject
		// O JSONOBject precisa de entradas que dão ao cookie um nome e ao campo "nome"
		// também.
		// O formato Cokkie não suporta booleanos

		String string = "{\"name\":\"Cookie-Name\",\"value\":\"name\",\"1\":5,\"2\":-2.345E68,\"3\":'true'}";
		JSONObject example = new JSONObject(string);

		// Obtemos uma String com formato Cookie com toString ()

		String output = Cookie.toString(example);
		System.out.println("Final Cookie: " + output);
	}

	private static void CookieFromExampleConversion() {

		// Começamos com uma string com o formato Cookie

		String string = "Cookie-Name=name;1=5;2=-2.345E%2b68;3=true";

		// Obtemos um JSONObject com toJSONOBject ()

		JSONObject output = Cookie.toJSONObject(string);
		System.out.println("Final JSONObject: " + output);
	}

	private static void HTTPToExampleConversion() {

		// Começamos com um JSONObject
		// O JSONObject deve ter o cabeçalho mínimo para uma solicitação HTTP ou
		// cabeçalho

		String string = "{\"Method\":\"POST\",\"Request-URI\":'/',\"HTTP-Version\":'HTTP/1.1',\"Value1\":true,\"Value2\":2,\"Value3\":-2.345E68}";

		JSONObject example = new JSONObject(string);

		// Obtemos uma String com formato HTTP com toString ()

		String output = HTTP.toString(example);
		System.out.println("Final HTTP: " + output);
	}

	private static void HTTPFromExampleConversion() {

		// Começamos com uma string com o formato HTTP

		String string = "Final HTTP: POST '/' HTTP/1.1 Value3: -2.345E+68 Value1: true Value2: 2";

		// Obtemos um JSONObject com toJSONOBject ()

		JSONObject output = HTTP.toJSONObject(string);
		System.out.println("Final JSONObject: " + output);
	}

	private static void CDLToExampleConversion() {

		// Começamos com alguns JSONObjects com os mesmos valores nas chaves, mas
		// valores diferentes nos "valores"

		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";
		JSONObject example = new JSONObject(string);

		String string2 = "{\"0\":\"value2\",\"1\":6,\"2\":-8.345E68,\"3\":false}";
		JSONObject example2 = new JSONObject(string2);

		// Precisamos agora de um JSONArray com esses JSONObjects

		JSONArray array = new JSONArray();
		array.put(example);
		array.put(example2);

		// Obtemos uma String com formato XML com toString ()

		String output = CDL.toString(array);
		System.out.println("Final CDL: \r\n" + output);
	}

	private static void CDLFromExampleConversion() {

		// Começamos com uma String com o formato CDL

		String string = "0,1,2,3\n" + "value,5,-2.345E+68,true\n" + "value2,6,-8.345E+68,false";

		// Obtemos um JSONArray com toJSONOBject ()

		JSONArray output = CDL.toJSONArray(string);
		System.out.println("Final JSONArray: " + output);
	}

	private static Properties PropertyToExampleConversion() {

		// Começamos com um JSONObject

		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";
		JSONObject example = new JSONObject(string);

		// Obtemos uma String com formato de Propriedades com toString ()

		Properties output = Property.toProperties(example);
		System.out.println("Final Properties: " + output);

		return output;
	}

}
