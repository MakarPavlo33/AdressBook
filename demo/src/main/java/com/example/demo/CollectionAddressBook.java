package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CollectionAddressBook implements AddressBook {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public ObservableList<Person> getPersonList(){return personList;}




         public void print(){
         int number = 0;
         System.out.println();
         for (Person person: personList){
                 number++;
                 System.out.println(number+" ПІП: "+person.getPip()+"; Телефон: "+ person.getPhone());
             }
         }
         public void fillTestData(){
             personList.add(new Person("Yulia", "12231"));
             personList.add(new Person("Oksana", "02365"));
             personList.add(new Person("Petro", "465875"));
         }


    @Override
    public void add(Person person) {

    }

    @Override
    public void updata(Person person) {

    }

    @Override
    public void delete(Person person) {

    }
}
