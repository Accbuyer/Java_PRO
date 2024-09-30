package courses.Java_PRO.task_2;

import lombok.Getter;

@Getter
public enum JobTitle {
    ENGINEER("Engineer"),
    MANAGER("Manager"),
    SUPERVISOR("Supervisor");

    private final String title;

    JobTitle(String title) {
        this.title = title;
    }

}
