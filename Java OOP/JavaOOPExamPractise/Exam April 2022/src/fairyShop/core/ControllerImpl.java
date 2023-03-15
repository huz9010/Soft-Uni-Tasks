package fairyShop.core;

import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;
import fairyShop.repositories.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Helper> helperRepository;
    private Repository<Present> presentRepository;
    private int presentsDone;

    public ControllerImpl() {
        helperRepository = new HelperRepository();
        presentRepository = new PresentRepository();
        presentsDone = 0;
    }

    @Override
    public String addHelper(String type, String helperName) {
        Map<String, Helper> helperMap = new HashMap<>();
        helperMap.put("Happy", new Happy(helperName));
        helperMap.put("Sleepy", new Sleepy(helperName));

        if (!helperMap.containsKey(type))   {
            throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }

        this.helperRepository.add(helperMap.get(type));

        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = helperRepository.findByName(helperName);
        if (helper == null)    {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        helper.addInstrument(new InstrumentImpl(power));
        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        this.presentRepository.add(present);
        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        List<Helper> readyHelpers = helperRepository.getModels().stream().filter(e -> e.getEnergy() > 50).collect(Collectors.toList());
        if (readyHelpers.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }

        Present present = presentRepository.findByName(presentName);
        Shop shop = new ShopImpl();

        int start = 0;
        while (!present.isDone()) {
            if (!readyHelpers.get(start).canWork()) {
                start++;
            }
            if (start >= readyHelpers.size())   {
                break;
            }
            shop.craft(present, readyHelpers.get(start));
        }

        String done;

        if (present.isDone())   {
            done = "done";
            presentsDone++;
        }   else {
            done = "not done";
        }

        int instrumentsBroken = 0;
        for (Helper helper : readyHelpers)  {
            for (Instrument instrument : helper.getInstruments())   {
                if (instrument.isBroken())  {
                    instrumentsBroken++;
                }
            }
        }

        return String.format(PRESENT_DONE + COUNT_BROKEN_INSTRUMENTS, presentName, done, instrumentsBroken);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d presents are done!", presentsDone)).append(System.lineSeparator())
                .append("Helpers info:").append(System.lineSeparator());
        for (Helper helper : helperRepository.getModels())  {
            long instrumentsNotBroken = helper.getInstruments().stream().filter(e -> !e.isBroken()).count();
            sb.append(String.format("Name: %s", helper.getName())).append(System.lineSeparator())
                    .append(String.format("Energy: %d", helper.getEnergy())).append(System.lineSeparator())
                    .append(String.format("Instruments: %d not broken left", instrumentsNotBroken)).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
