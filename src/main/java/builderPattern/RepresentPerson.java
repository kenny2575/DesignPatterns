package builderPattern;

public class RepresentPerson {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        try {
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new PersonBuilder()
                    .setName("Анна")
                    .setSurname("Вольф")
                    .setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            Person momWithTwoNames = new PersonBuilder()
                    .setName("Анна")
                    .setSurname("Вольф")
                    .setAge(31)
                    .setName("Мария")
                    .setAddress("Сидней")
                    .build();
            System.out.println(momWithTwoNames);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
