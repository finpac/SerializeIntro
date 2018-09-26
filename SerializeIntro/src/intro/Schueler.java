/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intro;

import java.time.LocalDate;

/**
 *
 * @author Patrick
 */
public class Schueler {
    private String name;
    private int age;
    private LocalDate birthday;

    public Schueler(String name, int age, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
        this.age = LocalDate.now().getYear() - birthday.getYear();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
    
    
    
    
}
