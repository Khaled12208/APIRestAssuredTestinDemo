package file;

public class payload {

    public static String AddPlace() {
	String payload = "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n"
		+ "    \"lng\": 33.427362\r\n" + "  },\r\n" + "  \"accuracy\": 50,\r\n"
		+ "  \"name\": \"Abdo Store\",\r\n" + "  \"phone_number\": \"(+ssdd) 983 893 3937\",\r\n"
		+ "  \"address\": \"29, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n" + "    \"shoe park\",\r\n"
		+ "    \"shop\"\r\n" + "  ],\r\n" + "  \"website\": \"http://wewwwe.com\",\r\n"
		+ "  \"language\": \"French-IN\"\r\n" + "}";

	return payload;
    }

    public static String UpdatePlace(String PlaceID, String Newadd) {
	String payload = "{\r\n" + "\"place_id\":\"" + PlaceID + "\",\r\n" + "\"address\":\"" + Newadd + "\",\r\n"
		+ "\"key\":\"qaclick123\"\r\n" + "}\r\n" + "";

	return payload;
    }

}
