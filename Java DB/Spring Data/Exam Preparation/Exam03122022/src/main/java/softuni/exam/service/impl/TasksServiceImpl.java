package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constants.enumeration.CarType;
import softuni.exam.models.dto.TaskExportDto;
import softuni.exam.models.dto.TaskImportDto;
import softuni.exam.models.dto.TaskImportRootDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.models.entity.Part;
import softuni.exam.models.entity.Task;
import softuni.exam.repository.CarsRepository;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.repository.PartsRepository;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.TasksService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XMLParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.constants.messages.Messages.*;

@Service
public class TasksServiceImpl implements TasksService {
    private static String TASKS_FILE_PATH = "src/main/resources/files/xml/tasks.xml";

    private final TasksRepository tasksRepository;
    private final MechanicsRepository mechanicsRepository;
    private final PartsRepository partsRepository;
    private final CarsRepository carsRepository;
    private final XMLParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public TasksServiceImpl(TasksRepository tasksRepository, MechanicsRepository mechanicsRepository, PartsRepository partsRepository, CarsRepository carsRepository, XMLParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.tasksRepository = tasksRepository;
        this.mechanicsRepository = mechanicsRepository;
        this.partsRepository = partsRepository;
        this.carsRepository = carsRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return tasksRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {
        final StringBuilder sb = new StringBuilder();

        final List<TaskImportDto> tasks = xmlParser.readFromXml(TASKS_FILE_PATH, TaskImportRootDto.class).getTasks();

        DecimalFormat df = new DecimalFormat("#.00", new DecimalFormatSymbols(Locale.US));

        for (TaskImportDto task : tasks) {
            sb.append(System.lineSeparator());

            if (this.validationUtil.isValid(task)) {
                final Optional<Mechanic> mechanic =
                        this.mechanicsRepository.findFirstByFirstName(task.getMechanic().getFirstName());
                final Optional<Car> car =
                        this.carsRepository.findById(task.getCar().getId());
                final Optional<Part> part =
                        this.partsRepository.findById(task.getPart().getId());

                if (car.isEmpty() || part.isEmpty() || mechanic.isEmpty()) {
                    sb.append(String.format(INVALID_TASK));
                    continue;
                }


                Task taskToSave = modelMapper.map(task, Task.class);
                taskToSave.setMechanic(mechanic.get());
                taskToSave.setCar(car.get());
                taskToSave.setPart(part.get());
                taskToSave.setDate(LocalDateTime.parse(task.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

                tasksRepository.save(taskToSave);
                sb.append(SUCCESSFULLY_IMPORTED).append(TASK).append(String.format(TASK_FORMAT, df.format(task.getPrice())));
            } else {
                sb.append(String.format(INVALID_TASK));
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
        return tasksRepository.findAllByCarCarTypeOrderByPriceDesc(CarType.coupe)
                .stream().map(task -> modelMapper.map(task, TaskExportDto.class))
                .map(TaskExportDto::toString)
                .collect(Collectors.joining())
                .trim();
    }
}
