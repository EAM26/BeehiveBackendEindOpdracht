package nl.beehive.beehivebackendeindopdracht.dtos.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeInputDto {

    // Personal details
    public String firstName;
    public String initials;
    public String preposition;
    public String lastName;
    public String address;
    public LocalDate dob;
    public String phoneNumber;
    public String email;

    // Employment details
//    private ArrayList<Team> teams;
//    private ArrayList<Shift> shifts;
    public LocalDate hireDate;
    public Boolean isEmployed;

}
