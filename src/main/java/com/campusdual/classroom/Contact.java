package com.campusdual.classroom;

public class Contact implements ICallActions{
    private String name;
    private String surnames;
    private String phone;
    private String code;

    public Contact(String name, String surnames, String phone) {
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
        this.code = generateCode(name, surnames);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSurnames() {
        return this.surnames;
    }

    public void setSurname(String surnames) {
        this.surnames = surnames;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String generateCode(String name, String surname) {
        String normalizedSurname = surname.toLowerCase()
                .replaceAll("[áàäâ]", "a")
                .replaceAll("[éèëê]", "e")
                .replaceAll("[íìïî]", "i")
                .replaceAll("[óòöô]", "o")
                .replaceAll("[úùüû]", "u")
                .replaceAll("[ñ]", "n");

        String[] surnameParts = normalizedSurname.split(" ");
        StringBuilder codeBuilder = new StringBuilder();
        codeBuilder.append(Character.toLowerCase(name.charAt(0)));

        if (surnameParts.length == 1) {
            codeBuilder.append(surnameParts[0]);
        } else {
            codeBuilder.append(surnameParts[0].charAt(0));
            for (int i = 1; i < surnameParts.length; i++) {
                codeBuilder.append(surnameParts[i]);
            }
        }
        return codeBuilder.toString();
    }

    @Override
    public void callMyNumber() {
        System.out.println(name + " " + surnames + "está llamando a su propio número: " + phone);
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println(name + " " + surnames + "está llamando al número: " + number);
    }

    @Override
    public void showContactDetails() {
        System.out.println("Nombre: " + name + ", Apellidos: " + surnames +
                ", Teléfono: " + phone + ", Código: " + code);
    }

    public String getCode() {
        return code;
    }

}
