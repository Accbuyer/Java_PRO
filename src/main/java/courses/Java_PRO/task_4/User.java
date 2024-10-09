package courses.Java_PRO.task_4;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User {
    private final Long id;
    private final String username;
}
