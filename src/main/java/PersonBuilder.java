class PersonBuilder {

    private String name;
    private String surname;
    private int age = 0;
    private String city;


    public PersonBuilder setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Не задано имя!");
        } else {
            this.name = name;
        }

        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalStateException("Не задана фамилия!");
        } else {
            this.surname = surname;
        }
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age <= 0) {
            throw new IllegalStateException("Указан некорректный возраст!");
        } else {
            this.age = age;
        }

        return this;
    }

    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    public Person build() throws IllegalStateException {
        Person person;
        if (name == null || surname == null) {
            throw new IllegalStateException("Не задано имя(фамилия)!");
        }

        if (age <= 0) {
            person = new Person(name, surname);
        } else {
            person = new Person(name, surname, age);
        }

        return person;
    }
}