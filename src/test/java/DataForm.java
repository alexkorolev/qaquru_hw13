import com.github.javafaker.Faker;
import java.util.Locale;

public class DataForm {
    Faker faker = new Faker(new Locale("en"));

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            eMail = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            streetAdress = faker.address().streetAddress(),
            phoneNumber = faker.number().digits(10),
            dayOfBirth = Integer.toString(faker.number().numberBetween(1,28)),
            mounthOfBirth = faker.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December"),
            yearhOfBirth = Integer.toString(faker.number().numberBetween(1970,2005)),
            subjects = faker.options().option("Maths", "Accounting", "Arts", "Biology",
                    "Chemistry", "Commerce" , "Economics", "Civics" , "Hindi" , "History" ,"Physics"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            pictureName = "my.png",
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = setCity(state);


    public  String setCity(String value){
        switch (value){
            case "NCR": value = faker.options().option("Delhi", "Gurgaon", "Noida");
                break;
            case "Uttar Pradesh": value = faker.options().option("Agra", "Lucknow", "Merrut");
                break;
            case "Haryana": value = faker.options().option("Karnal", "Panipat");
                break;
            case "Rajasthan": value = faker.options().option("Jaipur", "Jaiselmer");
                break;
        }
        return value;
    }
}