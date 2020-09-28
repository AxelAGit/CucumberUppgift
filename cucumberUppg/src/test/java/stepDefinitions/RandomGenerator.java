package stepDefinitions;
//this class creates a random string using uppercase letters and numbers.

//The length of the string depends on the value of the stringLength int.

public class RandomGenerator {
	static String getRandomString(int stringLength) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
		StringBuilder randomString = new StringBuilder(stringLength);
		for (int i = 0; i < stringLength; i++) {
			int index = (int) (characters.length() * Math.random());
			randomString.append(characters.charAt(index));
		}
		return randomString.toString();
	}
}
