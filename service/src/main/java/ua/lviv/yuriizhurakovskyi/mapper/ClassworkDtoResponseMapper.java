package ua.lviv.yuriizhurakovskyi.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.lviv.yuriizhurakovskyi.dto.classwork.ClassworkDtoResponse;
import ua.lviv.yuriizhurakovskyi.dto.task.TaskDtoResponse;
import ua.lviv.yuriizhurakovskyi.dto.user.UserDtoResponse;
import ua.lviv.yuriizhurakovskyi.entity.Classwork;

@Component
@AllArgsConstructor
public class ClassworkDtoResponseMapper {
    private final TaskDtoResponseMapper taskDtoResponseMapper;
    private final UserDtoResponseMapper userDtoResponseMapper;

    public ClassworkDtoResponse map(Classwork classwork) {
        TaskDtoResponse taskDtoResponse = taskDtoResponseMapper.map(classwork.getTask());
        UserDtoResponse teacherDtoResponse = userDtoResponseMapper.map(classwork.getTeacher());
        UserDtoResponse studentDtoResponse = userDtoResponseMapper.map(classwork.getStudent());

        return ClassworkDtoResponse.builder()
                .id(classwork.getId())
                .date(classwork.getDate())
                .result(classwork.getResult())
                .solution(classwork.getSolution())
                .task(taskDtoResponse)
                .student(studentDtoResponse)
                .teacher(teacherDtoResponse)
                .build();
    }

}
