package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    private Map<String, Contact> contacts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void addContact(Contact contact) {
        contacts.put(contact.getCode(), contact);
    }

    public void deleteContact(String code) {
        contacts.remove(code.toLowerCase());
    }

    public void showPhonebook() {
        for (Contact contact : contacts.values()) {
            contact.showContactDetails();
        }
    }

    public Map<String, Contact> getData() {
        return contacts;
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Ver todos los contactos");
            System.out.println("3. Seleccionar contacto");
            System.out.println("4. Borrar contacto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch(option) {
                case 1: addContactFromInput(); break;
                case 2: showPhonebook(); break;
                case 3: selectContact(); break;
                case 4: deleteContactFromInput(); break;
                case 5: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción incorrecta, elija otra");
            }
        } while(option != 5);
    }

    private void addContactFromInput() {
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Apellidos: ");
        String surnames = scanner.nextLine();
        System.out.print("Número de telefono: ");
        String phone = scanner.nextLine();

        Contact newContact = new Contact(name, surnames, phone);
        addContact(newContact);
        System.out.println("Contacto añadido con el código: " + newContact.getCode());
    }

    private void selectContact() {
        System.out.print("Introducir código de contacto: ");
        String code = scanner.nextLine().toLowerCase();
        Contact selected = contacts.get(code);

        if(selected == null) {
            System.out.println("Contacto no encontrado");
            return;
        }

        int action;
        do {
            System.out.println("\nMenú de Contactos:");
            System.out.println("1. Llamar a mi número");
            System.out.println("2. Llamar a otro número");
            System.out.println("3. Show details");
            System.out.println("4. Volver a Menú Principal");
            System.out.print("Seleccione una opción: ");
            action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 1: selected.callMyNumber(); break;
                case 2:
                    System.out.print("Introduzca número para llamar: ");
                    String number = scanner.nextLine();
                    selected.callOtherNumber(number);
                    break;
                case 3: selected.showContactDetails(); break;
                case 4: System.out.println("Regresando a Menu Principal..."); break;
                default: System.out.println("Opcion incorrecta");
            }
        } while(action != 4);
    }

    private void deleteContactFromInput() {
        System.out.print("Introduzca codigo del contacto a eliminar: ");
        String code = scanner.nextLine().toLowerCase();
        if(contacts.containsKey(code)) {
            deleteContact(code);
            System.out.println("Contacto eliminado");
        } else {
            System.out.println("Contact no encontrado");
        }
    }
}
