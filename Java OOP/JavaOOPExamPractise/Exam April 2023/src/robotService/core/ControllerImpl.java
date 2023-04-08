package robotService.core;

import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        if (!typeIsValid(type)) {
            throw new NullPointerException(INVALID_SERVICE_TYPE);
        }

        Service service;

        if (type.equals("MainService")) {
            service = new MainService(name);
        }   else {
            service = new SecondaryService(name);
        }

        services.add(service);
        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    private boolean typeIsValid(String type) {
        return type.equals("MainService") || type.equals("SecondaryService");
    }

    @Override
    public String addSupplement(String type) {
        if (!supplementTypeIsValid(type)) {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }

        Supplement supplement;
        if (type.equals("PlasticArmor")) {
            supplement = new PlasticArmor();
        }   else {
            supplement = new MetalArmor();
        }

        supplements.addSupplement(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    private boolean supplementTypeIsValid(String type) {
        return type.equals("PlasticArmor") || type.equals("MetalArmor");
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement supplement = supplements.findFirst(supplementType);
        if (supplement == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        Service service = services.stream().filter(e -> e.getName().equals(serviceName)).findFirst().orElse(null);
        assert service != null;
        service.addSupplement(supplement);
        supplements.removeSupplement(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        if (!robotTypeIsValid(robotType)) {
            throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }
        Service service = services.stream().filter(e -> e.getName().equals(serviceName)).findFirst().orElse(null);
        assert service != null;
        String serviceType = service.getClass().getSimpleName();

        Robot robot;
        if (robotType.equals("MaleRobot")) {
            robot = new MaleRobot(robotName, robotKind, price);
            if (!serviceType.equals("MainService")) {
                return UNSUITABLE_SERVICE;
            }
        } else {
            robot = new FemaleRobot(robotName, robotKind, price);
            if (!serviceType.equals("SecondaryService")) {
                return UNSUITABLE_SERVICE;
            }
        }

        service.addRobot(robot);
        return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
    }

    private boolean robotTypeIsValid(String robotType) {
        return robotType.equals("MaleRobot") || robotType.equals("FemaleRobot");
    }

    @Override
    public String feedingRobot(String serviceName) {
        Service service = services.stream().filter(e -> e.getName().equals(serviceName)).findFirst().orElse(null);
        assert service != null;
        service.feeding();
        return String.format(FEEDING_ROBOT, service.getRobots().size());
    }

    @Override
    public String sumOfAll(String serviceName) {
        Service service = services.stream().filter(e -> e.getName().equals(serviceName)).findFirst().orElse(null);
        assert service != null;
        double robotsPrice = service.getRobots().stream().mapToDouble(Robot::getPrice).sum();
        double supplementsPrice = service.getSupplements().stream().mapToDouble(Supplement::getPrice).sum();
        double serviceValue = robotsPrice + supplementsPrice;
        return String.format(VALUE_SERVICE, serviceName, serviceValue);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        for (Service service : services) {
            sb.append(service.getStatistics());
        }
        return sb.toString().trim();
    }
}
