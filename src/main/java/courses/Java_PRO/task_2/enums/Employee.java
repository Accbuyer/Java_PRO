package courses.Java_PRO.task_2.enums;

import courses.Java_PRO.task_2.JobTitle;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class Employee {

    private final String name;
    private final int age;
    private final JobTitle jobTitle;

}
