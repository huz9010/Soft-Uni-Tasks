package magicGame.core;

import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.interfaces.MagicRepositoryImpl;
import magicGame.repositories.interfaces.MagicianRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static magicGame.common.ExceptionMessages.*;
import static magicGame.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private MagicRepositoryImpl magics;
    private MagicianRepositoryImpl magicians;
    private RegionImpl region;

    public ControllerImpl() {
        magics = new MagicRepositoryImpl();
        magicians = new MagicianRepositoryImpl();
        region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        if (!type.equals("RedMagic") && !type.equals("BlackMagic")) {
            throw new IllegalArgumentException(INVALID_MAGIC_TYPE);
        }
        if (type.equals("RedMagic"))    {
            magics.addMagic(new RedMagic(name, bulletsCount));
        }   else magics.addMagic(new BlackMagic(name, bulletsCount));
        return String.format(SUCCESSFULLY_ADDED_MAGIC, name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        if (magics.findByName(magicName) == null)   {
            throw new NullPointerException(MAGIC_CANNOT_BE_FOUND);
        }

        switch (type)   {
            case "Wizard":
                magicians.addMagician(new Wizard(username, health, protection, magics.findByName(magicName)));
                break;
            case "BlackWidow":
                magicians.addMagician(new BlackWidow(username, health, protection, magics.findByName(magicName)));
                break;
            default:
                throw new IllegalArgumentException(INVALID_MAGICIAN_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_MAGICIAN, username);
    }

    @Override
    public String startGame() {
        return region.start(magicians.getData());
    }

    @Override
    public String report() {
        List<Magician> magicianList = magicians.getData().stream()
                .sorted(Comparator.comparing(Magician::getHealth).thenComparing(Magician::getUsername)).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();

        for (Magician magician : magicianList)  {

            sb.append(magician);
        }

        return sb.toString().trim();
    }
}
