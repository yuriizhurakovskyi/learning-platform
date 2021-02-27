package ua.lviv.yuriizhurakovskyi.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.lviv.yuriizhurakovskyi.dto.classwork.ClassworkDtoRequest;
import ua.lviv.yuriizhurakovskyi.entity.Classwork;
import ua.lviv.yuriizhurakovskyi.entity.Task;
import ua.lviv.yuriizhurakovskyi.entity.User;
import ua.lviv.yuriizhurakovskyi.exception.DataNotFoundException;
import ua.lviv.yuriizhurakovskyi.repository.TaskRepository;
import ua.lviv.yuriizhurakovskyi.repository.UserRepository;

@Component
@AllArgsConstructor
public class ClassworkDtoRequestMapper {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public Classwork map(ClassworkDtoRequest classworkDtoRequest) {
        Long taskId = classworkDtoRequest.getTaskId();
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new DataNotFoundException("Task with id=" + taskId + " not found exception "));
        Long teacherId = classworkDtoRequest.getTeacherId();
        User teacher = userRepository.findById(teacherId)
                .orElseThrow(() -> new DataNotFoundException("User with id=" + teacherId + " not found exception "));
        Long studentId = classworkDtoRequest.getStudentId();
        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new DataNotFoundException("User with id=" + studentId + " not found exception "));

        return Classwork.builder()
                .id(classworkDtoRequest.getId())
                .date(classworkDtoRequest.getDate())
                .result(classworkDtoRequest.getResult())
                .solution(classworkDtoRequest.getSolution())
                .task(task)
                .teacher(teacher)
                .student(student)
                .build();
    }
}
